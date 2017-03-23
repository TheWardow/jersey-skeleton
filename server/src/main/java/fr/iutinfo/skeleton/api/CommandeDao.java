package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface CommandeDao {
    @SqlUpdate("create table commande (id integer primary key autoincrement, idcar integer,idpicture integer, idcleaner integer, date datetime,duree integer,termine integer,accepte integer, foreign key(idcar) references car(id), foreign key(idcleaner) references cleaners(id), foreign key(idpicture) references picture(id))")
    void createCommandeTable();
    

    @SqlUpdate("insert into commande (idcar,idpicture,idcleaner,date,duree,termine,accepte) values (:idcar,:idpicture,:idcleaner,:date,:duree,:termine,:accepte)")
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
