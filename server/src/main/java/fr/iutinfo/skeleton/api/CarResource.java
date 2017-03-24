package fr.iutinfo.skeleton.api;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.CarDto;

@Path("/car")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {
	

	final static Logger logger = LoggerFactory.getLogger(UserResource.class);
    private static CarDao dao = getDbi().open(CarDao.class);

    public CarResource() throws SQLException {
        if (!tableExist("Car")) {
            logger.debug("Create table Car");
            dao.createCarTable();
        }
    }
    
    
    @POST
    public CarDto createCar(CarDto dto) {
        Car Car = new Car();
        Car.initFromDto(dto);
        int id = dao.insert(Car);
        dto.setId(id);
        return dto;
    }
    
    @GET
    @Path("/{name}")
    public CarDto getCar(@PathParam("name") int id) {
    	Car Car = dao.findById(id);
        if (Car == null) {
            throw new WebApplicationException(404);
        }
        return Car.convertToDto();
    }
    /*
    @GET
    public List<CarDto> getAllCar(@QueryParam("q") String query) {
        List<Car> Cars;
        if (query == null) {
            Cars = dao.all();
        } else {
            logger.debug("Search users with query: " + query);
            Cars = dao.search("%" + query + "%");
        }
        return Cars.stream().map(User::convertToDto).collect(Collectors.toList());
    }*/
    
    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") int id) {
        dao.delete(id);
    }
}
