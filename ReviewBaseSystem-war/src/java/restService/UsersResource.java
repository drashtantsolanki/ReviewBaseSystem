/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restService;

import ejb.clientejbLocal;
import entity.Users;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
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
@Path("generic")
@RequestScoped
public class UsersResource {

    @Context
    private UriInfo context;

    @EJB clientejbLocal client;
    /**
     * Creates a new instance of UsersResource
     */
    public UsersResource() {
    }

    /**
     * Retrieves representation of an instance of restService.UsersResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Users> getAllUsers()
    {
        //TODO return proper representation object
        return client.getAllUsers();
    }
    
    @POST
    @Path("adduser/{name}/{phno}/{pass}/{interest}/{gender}/{email}/{city}/{bdate}")
    public void addUser(@PathParam("name") String name,@PathParam("phno") String phno,@PathParam("interest") String interest,@PathParam("gender") String gender,@PathParam("email") String email,@PathParam("city") String city,@PathParam("bdate") String bdate,@PathParam("pass") String pass)
    {
        try {
            Date d1=new SimpleDateFormat("yyyy-mm-dd").parse(bdate);
            client.addUser(name, email, phno, interest, gender, d1, city, pass);
        } catch (Exception e) {
        }
        
    }
    
    
    @POST
    @Path("updateuser/{uid}/{name}/{phno}/{pass}/{interest}/{gender}/{email}/{city}/{bdate}")
    public void updateUser(@PathParam("uid")int uid,@PathParam("name") String name,@PathParam("phno") String phno,@PathParam("interest") String interest,@PathParam("gender") String gender,@PathParam("email") String email,@PathParam("city") String city,@PathParam("bdate") String bdate)
    {
        try {
            Date d1=new SimpleDateFormat("yyyy-mm-dd").parse(bdate);
            client.updateUser(uid, name, email, phno, interest, gender, d1, city);
        } catch (Exception e) {
        }
    }
    
    
    @DELETE
    @Path("deleteuser/{uid}")
    public void deleteUser(@PathParam("uid") int uid)
    {
        client.removeUser(uid);
    }
    
    
    
    
    @GET
    @Path("getuser/{id}")
    public Users getUserById(@PathParam("id") int id)
    {
        return client.getUserById(id);
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
