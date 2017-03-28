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

public class HelperTest extends JerseyTest{

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
	    	createUserWithName("foo");
	        UserDto utilisateur = target(PATH + "/foo").request().get(UserDto.class);
	        assertEquals("foo", utilisateur.getName());
	    }

	    @Test
	    public void read_user_should_return_good_email() {
	        createIan();
	        UserDto user = target(PATH + "/debian").request().get(UserDto.class);
	        assertEquals("ian@debian.org", user.getEmail());
	    }

	    @Test
	    public void read_user_should_return_hashed_password() throws NoSuchAlgorithmException {
	        createUserWithPassword("Momo", "motdepasse","graindesel");
	        User user = dao.findByLogin("Momo");
	        String pwd = user.getPasswdHash();
	        assertEquals("84edb3f1dcfbb6812672f56489433f374612054bed48890a54ab07a64dccaa6f", pwd);
	    }

	    @Ignore
	    @Test
	    public void create_should_return_the_user_with_valid_id() {
	        User user = new User(0, "thomas");
	        Entity<User> userEntity = Entity.entity(user, MediaType.APPLICATION_JSON);
	        String json = target(PATH).request().post(userEntity).readEntity(String.class);
	        assertEquals("{\"id\":1,\"isAdmin\":0,\"login\":\"thomas\"", json.substring(0, 36));
	    }
	    @Ignore
	    @Test
	    public void list_should_return_all_users() {
	        createUserWithName("foo");
	        createUserWithName("bar");
	        List<UserDto> users = target(PATH + "/").request().get(listUserResponseType);
	        assertEquals(2, users.size());
	    }
	    
	    @Ignore
	    @Test
	    public void list_all_must_be_ordered() {
	        createUserWithName("foo");
	        createUserWithName("bar");
	        List<UserDto> users = target(PATH + "/").request().get(listUserResponseType);
	        assertEquals("bar", users.get(0).getName());
	    }

	    @Test
	    public void after_delete_read_user_sould_return_204() {
	        User u = createUserWithName("toto");
	        int status = target(PATH + "/" + u.getId()).request().delete().getStatus();
	        assertEquals(204, status);
	    }

	    @Test
	    public void should_delete_user() {
	        User u = createUserWithName("toto");
	        target(PATH + "/" + u.getLogin()).request().delete();
	        User user = dao.findByLogin(u.getLogin());
	        Assert.assertEquals(null, user);
	    }

	    @Test
	    public void delete_unexisting_should_return_204() {
	        int status = target(PATH + "/unexisting").request().delete().getStatus();
	        assertEquals(204, status);
	    }

	    @Test
	    public void list_should_search_in_name_field() {
	        createUserWithName("foo");
	        createUserWithName("bar");

	        List<UserDto> users = target(PATH + "/").queryParam("q", "ba").request().get(listUserResponseType);
	        assertEquals("bar", users.get(0).getName());
	    }

	    @Test
	    public void list_should_search_in_email_field() {
	        createRms();
	        createLinus();
	        createRob();

	        List<UserDto> users = target(PATH + "/").queryParam("q", "fsf").request().get(listUserResponseType);
	        assertEquals(2, users.size());
	    }
}
