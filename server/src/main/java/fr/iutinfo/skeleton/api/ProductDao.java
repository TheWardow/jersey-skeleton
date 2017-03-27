package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface ProductDao {
    @SqlUpdate("create table product(id integer primary key autoincrement, marque varchar(30), type varchar(30), quantite integer)")
    void createProductTable();
    
    @SqlUpdate("insert into product (marque,type,quantite) values (:marque,:type,:quantite)")
    @GetGeneratedKeys
    int insert(@BindBean() Product produit);

    @SqlQuery("select * from product where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Product findById(@Bind("id") int id);

    @SqlQuery("select * from product where cleanerLogin = :login")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Product> search(@Bind("login") String login);

    @SqlUpdate("drop table if exists product")
    void dropProductTable();

    @SqlUpdate("delete from product where id = :id")
    void delete(@Bind("id") int id);

    @SqlQuery("select * from product order by id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Product> all();
    
    void close();
}
