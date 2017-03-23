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

import fr.iutinfo.skeleton.common.dto.CommandeDto;
import fr.iutinfo.skeleton.common.dto.UserDto;

@Path("/commande")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommandeResource{
    final static Logger logger = LoggerFactory.getLogger(CommandeResource.class);
    private static CommandeDao dao = getDbi().open(CommandeDao.class);
    

    public CommandeResource() throws SQLException {
        if (!tableExist("commande")) {
            logger.debug("Create table commmande");
            dao.createCommandeTable();
        }
    }

    @POST
    public CommandeDto createUser(CommandeDto dto) {
    	Commande commande = new Commande();
    	commande.initFromDto(dto);
        int id = dao.insert(commande);
        dto.setId(id);
        return dto;
    }

    @GET
    @Path("/{id}")
    public CommandeDto getCommande(@PathParam("id") int id) {
        Commande commande = dao.findById(id);
        if (commande == null) {
            throw new WebApplicationException(404);
        }
        return commande.convertToDto();
    }

    @GET
    public List<CommandeDto> getAllCommande() {
        List<Commande> commande;
        
        commande = dao.all();
       
        return commande.stream().map(Commande::convertToDto).collect(Collectors.toList());
    }

    @DELETE
    @Path("/{id}")
    public void deleteCommande(@PathParam("id") int id) {
        dao.delete(id);
    }

}
