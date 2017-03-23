package fr.iutinfo.skeleton.api;

import java.util.List;

import javax.ws.rs.core.GenericType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.UserDto;

public class Helper {
    private final static Logger logger = LoggerFactory.getLogger(Helper.class);
    private static final UserDao userdao = BDDFactory.getDbi().open(UserDao.class);
    private static final CarDao cardao = BDDFactory.getDbi().open(CarDao.class);
    private static final CleanerDao cleanerdao = BDDFactory.getDbi().open(CleanerDao.class);
    private static final PictureDao picturedao = BDDFactory.getDbi().open(PictureDao.class);
    private static final CommandeDao commandedao = BDDFactory.getDbi().open(CommandeDao.class);
    static GenericType<List<UserDto>> listUserResponseType = new GenericType<List<UserDto>>() {
    };

    public static void initDb() {
    	userdao.dropUserTable();
    	userdao.createUserTable();
    	cardao.dropCarTable();
    	cardao.createCarTable();
    	cleanerdao.dropCleanerTable();
    	cleanerdao.createCleanerTable();
    	picturedao.dropPictureTable();
    	picturedao.createPictureTable();
    	commandedao.dropCommandeTable();
    	commandedao.createCommandeTable();
    }

    static User createUserWithName(String name) {
        User user = new User(0, name);
        return createUser(user);
    }

    static User createUserWithEmail(String name, String email) {
        User user = new User(0, name);
        user.setEmail(email);
        return createUser(user);
    }

    public static User createUserWithPassword(String name, String passwd, String salt) {
        User user = new User(0, name);
        user.setSalt(salt);
        user.setPassword(passwd);
        logger.debug("createUserWithPassword Hash : " + user.getPasswdHash());
        return createUser(user);
    }

    private static User createUser(User user) {
        int id = userdao.insert(user);
        user.setId(id);
        return user;
    }


    private static User createFullUSer(String nom, String prenom, String login, String email, String password, int isAdmin) {
        User user = new User();
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);
        user.setIsadmin(isAdmin);
        user.setNom(nom);
        user.setPrenom(prenom);
        int id = userdao.insert(user);
        user.setId(id);
        return user;
    }

    static void createRms() {
        createFullUSer("Richard", "Stallman", "RMS", "rms@fsf.org", "gnuPaswword", 0);
    }

    static User createRob() {
        return createFullUSer("Robert", "Capillo", "rob", "rob@fsf.org", "paswword", 0);
    }

    static User createLinus() {
        return createFullUSer("Linus", "Torvalds", "linus", "linus@linux.org", "paswword", 0);
    }
}
