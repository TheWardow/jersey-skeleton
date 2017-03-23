package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.CleanerDto;
import fr.iutinfo.skeleton.common.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

@Path("/cleaner")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CleanerResource {
    final static Logger logger = LoggerFactory.getLogger(CleanerResource.class);
    private static CleanerDao dao = getDbi().open(CleanerDao.class);
    

    public CleanerResource() throws SQLException {
        if (!tableExist("cleaners")) {
            logger.debug("Crate table cleaners");
            dao.createCleanerTable();
        }
    }

    @POST
    public CleanerDto createCleaner(CleanerDto dto) {
        Cleaner cleaner = new Cleaner();
        cleaner.initFromDto(dto);
        cleaner.resetPasswordHash();
        int id = dao.insert(cleaner);
        dto.setId(id);
        return dto;
    }

    @GET
    @Path("/{name}")
    public CleanerDto getCleaner(@PathParam("name") String login) {
        Cleaner cleaner = dao.findByLogin(login);
        if (cleaner == null) {
            throw new WebApplicationException(404);
        }
        return cleaner.convertToDto();
    }

    @GET
    public List<CleanerDto> getAllCleaners(@QueryParam("q") String query) {
        List<Cleaner> cleaners;
        if (query == null) {
            cleaners = dao.all();
        } else {
            logger.debug("Search cleaners with query: " + query);
            cleaners = dao.search("%" + query + "%");
        }
        return cleaners.stream().map(Cleaner::convertToDto).collect(Collectors.toList());
    }

    @DELETE
    @Path("/{login}")
    public void deleteCleaner(@PathParam("login") int login) {
        dao.delete(login);
    }

}
