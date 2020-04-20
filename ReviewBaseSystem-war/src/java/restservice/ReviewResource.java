/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservice;

import ejb.adminejbLocal;
import entity.Category;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("review")
public class ReviewResource {

    @EJB
    adminejbLocal admin;

    /**
     * Creates a new instance of ReviewResource
     */
    public ReviewResource() {
    }

    /**
     * Retrieves representation of an instance of restservice.ReviewResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/getdata")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Category> getAllCategory() {
        for (Category c : admin.getAllCategory()) {
            System.out.println(c.getCategoryName());
            
        }
        return admin.getAllCategory();
    }
}
