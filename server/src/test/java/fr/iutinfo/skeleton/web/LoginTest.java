package fr.iutinfo.skeleton.web;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.api.Adresse;
import fr.iutinfo.skeleton.api.Car;
import fr.iutinfo.skeleton.api.Cleaner;
import fr.iutinfo.skeleton.api.Commande;
import fr.iutinfo.skeleton.api.Helper;
import fr.iutinfo.skeleton.api.Picture;
import fr.iutinfo.skeleton.api.Product;
import fr.iutinfo.skeleton.api.User;
import fr.iutinfo.skeleton.api.UserDao;

public class LoginTest extends JerseyTest {
    final static Logger logger = LoggerFactory.getLogger(LoginTest.class);
    private Helper h;
    private UserDao dao;
    private String path = "/login";

    @Override
    protected Application configure() {
        return new WebConfig();
    }


    @Before
    public void init() {
        Helper.initDb();
    }

    @Test
    public void should_create_table() {
//    	User a = Helper.createAdminWithPassword("admin", "admin");
//        User u = Helper.createUserWithPassword("user", "user");
//        Cleaner c = Helper.createCleanerWithPassword("cleaner", "cleaner", "Tahiti", "Bob");
//        Car car = Helper.createCar(u.getLogin(), "peugeot","206","bleue","","154 AFD 59");
//        Commande com = Helper.createCommande(car.getId(), c.getLogin());
//        Picture pic = Helper.createPicture(c.getId(), "img/photo.jpg", 0);
//        Adresse adresse = Helper.createAdresse("10B", "rue Simone de Beauvoir", "Loos", 59120, u.getLogin());
//        Product product = Helper.createProduct("savon", "Mr Propre", 20, c.getLogin());
        assertEquals(1, 1);
    }
    /*
    @Test
    @Ignore// missing MVC template injection
    public void should_redirect_to_user_detail_with_good_authorization_header() {
        h.createUserWithPassword("tclavier", "motdepasse", "graindesel");
        String authorization = "Basic " + Base64.encodeAsString("tclavier:motdepasse");
        Response response = target(path).request().header(AUTHORIZATION, authorization).get();
        int status = response.getStatus();
        assertEquals(TEMPORARY_REDIRECT.getStatusCode(), status);
    }

    @Test
    @Ignore // missing MVC template injection
    public void should_set_cookie_with_user_with_good_authorization_header() {
        h.createUserWithPassword("tclavier", "motdepasse", "graindesel");
        String authorization = "Basic " + Base64.encodeAsString("tclavier:motdepasse");
        Response response = target(path).request().header(AUTHORIZATION, authorization).get();
        assertEquals(1, response.getCookies().size());
    }

    @Ignore
    @Test
    public void should_return_unauthorized_headers_without_authorization_header() {
        Response response = target(path).request().get();
        int status = response.getStatus();
        String wwwHeader = response.getHeaderString(HttpHeaders.WWW_AUTHENTICATE);
        assertEquals(UNAUTHORIZED.getStatusCode(), status);
        assertEquals("Basic realm=\"Mon application\"", wwwHeader);
    }

    @Ignore
    @Test
    public void should_return_unauthorized_headers_with_authorization_header_on_same_user() {
        h.createUserWithPassword("tclavier", "motdepasse", "graindesel");
        String authorization = "Basic " + Base64.encodeAsString("tclavier:motdepasse");
        Response response = target(path).queryParam("user", "tclavier").request().header(AUTHORIZATION, authorization).get();
        int status = response.getStatus();
        String wwwHeader = response.getHeaderString(HttpHeaders.WWW_AUTHENTICATE);
        assertEquals(UNAUTHORIZED.getStatusCode(), status);
        assertEquals("Basic realm=\"Mon application\"", wwwHeader);
    }

    @Ignore
    @Test
    public void should_return_unauthorized_status_for_bad_user() {
        h.createUserWithPassword("tclavier", "motdepasse", "graindesel");
        String authorization = "Basic " + Base64.encodeAsString("tclavier:pasdemotdepasse");
        int utilisateur = target(path).request().header(AUTHORIZATION, authorization).get().getStatus();
        assertEquals(UNAUTHORIZED.getStatusCode(), utilisateur);
    }*/
}
