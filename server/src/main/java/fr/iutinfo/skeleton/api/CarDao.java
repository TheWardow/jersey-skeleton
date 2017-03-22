package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface CarDao {

	
	@SqlUpdate("create table Car (Carid integer primary key autoincrement, userid integer, marque varchar(20), modele varchar(20), couleur varchar(20), commentaire text, foreign key(userid) references users(userid))")
    void createCarTable();

    @SqlUpdate("insert into Car (userid, marque, modele, couleur, commentaire) values (:userId,:marque,:modele, :couleur, :commentaire)")
    @GetGeneratedKeys
    int insert(@BindBean() Car Car);
    
    @SqlQuery("select * from Car where Carid = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Car findById(@Bind("id") int id);
    
    @SqlQuery("select * from Car")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Car> all();
    
    @SqlQuery("select id from Car")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Car> search(@Bind("id") int id);
    
    @SqlUpdate("delete from Car where id = :id")
    void delete(@Bind("id") int id);
}
