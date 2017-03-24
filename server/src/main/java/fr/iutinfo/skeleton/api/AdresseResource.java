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

import fr.iutinfo.skeleton.common.dto.AdresseDto;

@Path("/adresse")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdresseResource {
	

	final static Logger logger = LoggerFactory.getLogger(UserResource.class);
    private static AdresseDao dao = getDbi().open(AdresseDao.class);

    public AdresseResource() throws SQLException {
        if (!tableExist("adresse")) {
            logger.debug("Create table adresse");
            dao.createAdresseTable();
        }
    }

    @POST
    public AdresseDto createAdresse(AdresseDto dto) {
        Adresse adresse = new Adresse();
        adresse.initFromDto(dto);
        int id = dao.insert(adresse);
        dto.setAdresseId(id);
        return dto;
    }
    
    @GET
    @Path("/{name}")
    public AdresseDto getAdresse(@PathParam("name") int id) {
    	Adresse adresse = dao.findById(id);
        if (adresse == null) {
            throw new WebApplicationException(404);
        }
        return adresse.convertToDto();
    }
    
    @GET
    public List<AdresseDto> getAllAdresse() {
        List<Adresse> adresses;
        adresses = dao.all();
        return adresses.stream().map(Adresse::convertToDto).collect(Collectors.toList());
    }
    
    @DELETE
    @Path("/{id}")
    public void deleteAdresse(@PathParam("id") int id) {
        dao.delete(id);
    }
}
