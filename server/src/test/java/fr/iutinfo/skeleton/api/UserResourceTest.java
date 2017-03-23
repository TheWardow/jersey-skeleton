package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.UserDto;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static fr.iutinfo.skeleton.api.Helper.*;
import static org.junit.Assert.assertEquals;

public class UserResourceTest extends JerseyTest {
    private static final String PATH = "/user";
    private UserDao dao = BDDFactory.getDbi().open(UserDao.class);

    @Override
    protected Application configure() {
        return new Api();
    }

    @Before
    public void init() {
        Helper.initDb();
    }

    @Test
    public void read_should_return_a_user_as_object() {
        createUserWithLogin("foo");
        UserDto utilisateur = target(PATH + "/foo").request().get(UserDto.class);
        assertEquals("foo", utilisateur.getName());
    }

    @Ignore
    @Test
    public void create_should_return_the_user_with_valid_id() {
        User user = new User(0, "thomas");
        Entity<User> userEntity = Entity.entity(user, MediaType.APPLICATION_JSON);
        String json = target(PATH).request().post(userEntity).readEntity(String.class);
        assertEquals("{\"id\":1,\"login\":\"thomas\"", json.substring(0, 23));
    }

    @Test
    public void list_should_return_all_users() {
    	createUserWithLogin("foo");
        createUserWithLogin("bar");
        List<UserDto> users = target(PATH + "/").request().get(listUserResponseType);
        assertEquals(2, users.size());
    }

    @Ignore
    @Test
    public void list_all_must_be_ordered() {
    	createUserWithLogin("foo");
        createUserWithLogin("bar");
        List<UserDto> users = target(PATH + "/").request().get(listUserResponseType);
        assertEquals("foo", users.get(0).getLogin());
    }

    @Test
    public void after_delete_read_user_sould_return_204() {
        User u = createUserWithLogin("toto");
        int status = target(PATH + "/" + u.getId()).request().delete().getStatus();
        assertEquals(204, status);
    }

    @Test
    public void should_delete_user() {
        User u = createUserWithLogin("toto");
        target(PATH + "/" + u.getId()).request().delete();
        User user = dao.findById(u.getId());
        Assert.assertEquals(null, user);
    }

    @Test
    public void delete_unexisting_should_return_404() {
        int status = target(PATH + "/unexisting").request().delete().getStatus();
        assertEquals(404, status);
    }

    @Test
    public void list_should_search_in_name_field() {
    	createUserWithLogin("foo");
    	createUserWithLogin("bar");

        List<UserDto> users = target(PATH + "/").queryParam("q", "ba").request().get(listUserResponseType);
        assertEquals("bar", users.get(0).getName());
    }

}
