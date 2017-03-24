package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface CleanerDao {
    @SqlUpdate("create table cleaners (login varchar(20) primary key, passwdHash varchar(64), nom varchar(30), prenom varchar(30), tel varchar(12), email varchar(100), dob date, salt varchar(64),localisation varchar(200), note double, search varchar(1024))")
    void createCleanerTable();
    
    @SqlUpdate("drop table if exists cleaners")
    void dropCleanerTable();

    @SqlUpdate("insert into cleaners (login,passwdHash,nom,prenom,tel,email,dob,search, salt, localisation, note) values (:login,:passwdHash,:nom,:prenom,:isadmin,:tel,:email,:dob,:search, :salt, :localisation, :note)")
    @GetGeneratedKeys
    int insert(@BindBean() Cleaner cleaner);

    @SqlQuery("select * from cleaners where login = :login")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Cleaner findByLogin(@Bind("login") String login);

    @SqlQuery("select * from cleaners where search like :login")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Cleaner> search(@Bind("login") String login);


    @SqlUpdate("delete from cleaners where login = :login")
    void delete(@Bind("login") int login);

    @SqlQuery("select * from cleaners order by login")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Cleaner> all();

    void close();
}
