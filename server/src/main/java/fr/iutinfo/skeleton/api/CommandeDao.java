package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface CommandeDao {
    @SqlUpdate("create table commande (id integer primary key autoincrement, idcar integer, logincleaner integer, date datetime,duree integer,termine integer,accepte integer, foreign key(idcar) references car(id), foreign key(logincleaner) references cleaners(login))")
    void createCommandeTable();
    

    @SqlUpdate("insert into commande (idcar,logincleaner,date,duree,termine,accepte) values (:idcar,:logincleaner,:date,:duree,:termine,:accepte)")
    @GetGeneratedKeys
    int insert(@BindBean() Commande commande);

    @SqlQuery("select * from commande where idcar = :idcar order by date desc limit 1")
    @RegisterMapperFactory(BeanMapperFactory.class)
    User findByIdCar(@Bind("idcar") int idcar);

    @SqlQuery("select * from commande where idcar = :idcar")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Commande> search(@Bind("idcar") int idcar);

    @SqlUpdate("drop table if exists commande")
    void dropCommandeTable();

    @SqlUpdate("delete from commande where id = :id")
    void delete(@Bind("id") int id);

    @SqlQuery("select * from commande order by id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Commande> all();

    @SqlQuery("select * from users where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Commande findById(@Bind("id") int id);

    void close();
}
