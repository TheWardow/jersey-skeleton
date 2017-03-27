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

import fr.iutinfo.skeleton.common.dto.ProductDto;
import fr.iutinfo.skeleton.common.dto.UserDto;

@Path("/produit")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource{
    final static Logger logger = LoggerFactory.getLogger(ProductResource.class);
    private static ProductDao dao = getDbi().open(ProductDao.class);
    

    public ProductResource() throws SQLException {
        if (!tableExist("product")) {
            logger.debug("Create table product");
            dao.createProductTable();
        }
    }

    @POST
    public ProductDto createProduct(ProductDto dto) {
    	Product produit = new Product();
    	produit.initFromDto(dto);
        int id = dao.insert(produit);
        dto.setId(id);
        return dto;
    }


    @GET
    public List<ProductDto> getAllProduct() {
        List<Product> produit;
        
        produit = dao.all();
       
        return produit.stream().map(Product::convertToDto).collect(Collectors.toList());
    }

    @DELETE
    @Path("/{id}")
    public void deleteProduct(@PathParam("id") int id) {
        dao.delete(id);
    }

}
