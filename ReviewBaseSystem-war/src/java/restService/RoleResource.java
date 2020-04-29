/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restService;

import ejb.adminejbLocal;
import entity.Role;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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
@Path("role")
@RequestScoped
public class RoleResource {

    @EJB adminejbLocal admin;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RoleResource
     */
    public RoleResource() {
    }

    /**
     * Retrieves representation of an instance of restService.RoleResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Role> getAllRoles() {
        return admin.getAllRoles();
    }
    
    @GET
    @Path("getrole/{id}")
    public Role getRoleById(@PathParam("id") int id)
    {
        return admin.getRoleById(id);
    }

    @POST
    @Path("addRole/{rolename}")
    public void addRole(@PathParam("rolename") String rolename)
    {
        admin.addRole(rolename);
    }
    
    @POST
    @Path("updateRole/{id}/{rolename}")
    public void updateRole(@PathParam("id") int id,@PathParam("rolename") String rolename)
    {
        admin.updateRole(id, rolename);
    }
    
    @DELETE
    @Path("deleterole/{rid}")
    public void deleteRole(@PathParam("rid") int rid)
    {
        admin.removeRole(rid);
    }
}
