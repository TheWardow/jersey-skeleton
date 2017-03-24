package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface AdresseDao {

	
	@SqlUpdate("create table adresse (adresseid integer primary key autoincrement, numero varchar(10), voie varchar(100), ville varchar(40), cp integer, userlogin varchar(20), foreign key(userlogin) references users(login))")
    void createAdresseTable();
	
	@SqlUpdate("drop table if exists adresse")
    void dropAdresseTable();

    @SqlUpdate("insert into adresse (numero, voie, ville, cp, userlogin) values (:numero, :voie, :ville, :cp, :userlogin)")
    @GetGeneratedKeys
    int insert(@BindBean() Adresse adresse);
    
    @SqlQuery("select * from adresse where adresseid = :adresseid")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Adresse findById(@Bind("id") int id);
    
    @SqlQuery("select * from adresse where ville = :ville")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Adresse findByVille(@Bind("ville") String ville);
    
    @SqlQuery("select * from adresse where cp = :cp")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Adresse findByCp(@Bind("cp") int cp);
    
    @SqlQuery("select * from adresse where userlogin = :userlogin")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Adresse findByLogin(@Bind("userlogin") String userlogin);
    
    @SqlQuery("select * from adresse")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Adresse> all();
    
    @SqlUpdate("delete from adresse where adresseid = :id")
    void delete(@Bind("id") int id);
}
