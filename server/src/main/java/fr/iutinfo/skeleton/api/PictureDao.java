package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface PictureDao
{
    @SqlUpdate("create table picture (id integer primary key autoincrement, date datetime, nettoye integer, path varchar(256), commandeid integer, foreign key(commandeid) references commande(id))")
    void createPictureTable();
    
    @SqlUpdate("insert into picture (date, nettoye, path, commandeid) values (:date, :nettoye, :path, :commandeid)")
    @GetGeneratedKeys
    int insert(@BindBean() Picture picture);

    @SqlQuery("select * from picture where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Picture findById(@Bind("id") int id);

    @SqlUpdate("drop table if exists picture")
    void dropPictureTable();

    @SqlUpdate("delete from picture where id = :id")
    void delete(@Bind("id") int id);

    @SqlQuery("select * from picture order by id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Picture> all();

    void close();
}
