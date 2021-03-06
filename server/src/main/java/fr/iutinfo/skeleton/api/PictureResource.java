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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.PictureDto;

@Path("/picture")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PictureResource {
    final static Logger logger = LoggerFactory.getLogger(UserResource.class);
    private static PictureDao dao = getDbi().open(PictureDao.class);
    

    public PictureResource() throws SQLException {
        if (!tableExist("picture")) {
            logger.debug("Create table picture");
            dao.createPictureTable();
        }
    }

    @POST
    public PictureDto createUser(PictureDto dto) {
        Picture picture = new Picture();
        picture.initFromDto(dto);
        int id = dao.insert(picture);
        dto.setId(id);
        return dto;
    }

    @GET
    @Path("/{id}")
    public PictureDto getPicture(@PathParam("id") int id) {
        Picture picture = dao.findById(id);
        if (picture == null) {
            throw new WebApplicationException(404);
        }
        return picture.convertToDto();
    }

    @GET
    public List<PictureDto> getAllPictures() {
        List<Picture> picture;
        picture = dao.all();
        return picture.stream().map(Picture::convertToDto).collect(Collectors.toList());
    }

    @DELETE
    @Path("/{id}")
    public void deletePicture(@PathParam("id") int id) {
        dao.delete(id);
    }

}
