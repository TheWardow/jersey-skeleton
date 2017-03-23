package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface UserDao {
    @SqlUpdate("create table users (login varchar(20) primary key, passwdHash varchar(64), nom varchar(30), prenom varchar(30),isAdmin integer, tel varchar(12), email varchar(100), dob date, salt varchar(64), search varchar(1024))")
    void createUserTable();
    

    @SqlUpdate("insert into users (login,passwdHash,nom,prenom,isAdmin,tel,email,dob,search, salt) values (:login,:passwdHash,:nom,:prenom,:isadmin,:tel,:email,:dob,:search, :salt)")
    @GetGeneratedKeys
    int insert(@BindBean() User user);

    @SqlQuery("select * from users where login = :login")
    @RegisterMapperFactory(BeanMapperFactory.class)
    User findByLogin(@Bind("login") String login);

    @SqlQuery("select * from users where search like :login")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<User> search(@Bind("login") String login);

    @SqlUpdate("drop table if exists users")
    void dropUserTable();

    @SqlUpdate("delete from users where login = :login")
    void delete(@Bind("login") int login);

    @SqlQuery("select * from users order by login")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<User> all();

    @SqlQuery("select * from users where login = :login")
    @RegisterMapperFactory(BeanMapperFactory.class)
    User findById(@Bind("login") int login);

    void close();
}
