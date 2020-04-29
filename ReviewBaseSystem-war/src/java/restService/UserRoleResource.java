/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restService;

import ejb.adminejbLocal;
import entity.Userrole;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author hi
 */
@Path("userrole")
@RequestScoped
public class UserRoleResource {

    @EJB adminejbLocal admin;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserRoleResource
     */
    public UserRoleResource() {
    }

    /**
     * Retrieves representation of an instance of restService.UserRoleResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Userrole> getUserRole() {
        //TODO return proper representation object
        return admin.getAllUserRole();
    }
    
    @GET
    @Path("getUserroleById/{id}")
    public Userrole getUserroleById(@PathParam("id") int id) 
    {
        return admin.getUserRoleById(id);
    }
    
    @POST
    @Path("addUserRole/{uid}/{rid}")
    public void addUserRole(@PathParam("uid") int uid,@PathParam("rid") int rid)
    {
        admin.addUserRole(uid, rid);
    }
    
    @POST
    @Path("updateUserRole/{id}/{uid}/{rid}")
    public void updateUserRole(@PathParam("id") int id,@PathParam("uid") int uid,@PathParam("rid") int rid)
    {
        admin.updateUserRole(uid, rid, id);
    }
    
    
    @DELETE
    @Path("deleteUserrole/{id}")
    public void deleteUserrole(@PathParam("id") int id)
    {
        admin.removeUserRole(id);
    }
    
     /**
     * PUT method for updating or creating an instance of UsersResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
