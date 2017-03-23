package fr.iutinfo.skeleton.api;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.GenericType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.UserDto;

public class Helper {
    private final static Logger logger = LoggerFactory.getLogger(Helper.class);
    private static final UserDao dao = BDDFactory.getDbi().open(UserDao.class);
    static GenericType<List<UserDto>> listUserResponseType = new GenericType<List<UserDto>>() {
    };

    public static void initDb() {
        dao.dropUserTable();
        dao.createUserTable();
    }

    static User createUserWithLogin(String login) {
        User user = new User(0, login);
        return createUser(user);
    }

    static User createUserWithEmail(String name, String email) {
        User user = new User(0, name);
        user.setEmail(email);
        return createUser(user);
    }

    public static User createUserWithPassword(String login, String passwd, String salt) {
        User user = new User(0, login);
        user.setSalt(salt);
        user.setPassword(passwd);
        logger.debug("createUserWithPassword Hash : " + user.getPasswdHash());
        return createUser(user);
    }

    private static User createUser(User user) {
        int id = dao.insert(user);
        user.setId(id);
        return user;
    }


    private static User createFullUSer(String login, String password, String nom, String prenom, int isAdmin, String tel, Date dob, String email) {
        User user = new User(0, login);
        user.setEmail(email);
        user.setPassword(password);
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setIsadmin(isAdmin);
        user.setTel(tel);
        user.setDob(dob);
        int id = dao.insert(user);
        user.setId(id);
        return user;
    }
}

