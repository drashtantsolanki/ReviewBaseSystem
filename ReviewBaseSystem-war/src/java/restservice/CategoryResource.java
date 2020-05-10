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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("category")
@RequestScoped
public class CategoryResource {

    @EJB
    adminejbLocal admin;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CategoryResource
     */
    public CategoryResource() {
    }

    @GET
    public Collection<Category> allCategory() {
        return admin.getAllCategory();
    }

    @POST
    @Path("addCategory/{categoryname}")
    public void addCategory(@PathParam("categoryname") String categoryname) {
        admin.AddCategory(categoryname);
    }

    @GET
    @Path("getCategory/{categoryid}")
    public Category getCategory(@PathParam("categoryid") int categoryid) {
        return admin.getCategoryById(categoryid);
    }

    @POST
    @Path("updateCategory/{categoryid}/{categoryname}")
    public void updateCategory(@PathParam("categoryid") int categoryid, @PathParam("categoryname") String categoryname) {
        admin.updateCategory(categoryid, categoryname);
    }

    @POST
    @Path("deleteCategory/{categoryid}")
    public void deleteCategory(@PathParam("categoryid") int categoryid) {
        admin.removeCategory(categoryid);
    }
}
