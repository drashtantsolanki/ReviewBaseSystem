/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restService;

import ejb.clientejbLocal;
import entity.Users;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.transaction.Transactional;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author hi
 */
@Path("review")
public class RestResource {

    @EJB clientejbLocal client;

    /**
     * Creates a new instance of RestResource
     */
    public RestResource() {
    }

    /**
     * Retrieves representation of an instance of restService.RestResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Users> getUsers() {
        //TODO return proper representation object
        return client.getAllUsers();
    }
    
//    @POST
//    @Path("addUser/{bdate}/{city}/{email}/{gender}/{interest}/{name}/{password}/{phno}")
//    public void addUser(@PathParam("bdate") String birthDate,@PathParam("city") String city,@PathParam("email") String email,@PathParam("gender") String gender,@PathParam("interest") String interest,@PathParam("name") String name,@PathParam("password") String password,@PathParam("phno") String phoneNumber) throws ParseException
//    {
//        Users users=new Users();
//        String bdate=birthDate;
//        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(bdate);
//        users.setBirthdate(date);
//        users.setCity(city);
//        users.setEmail(email);
//        users.setGender(gender);
//        users.setInterest(interest);
//        users.setPassword(password);
//        users.setPhoneNumber(phoneNumber);
//        users.setName(name);
//        client.addUser(users);
//    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addUser")
    public void addUser(Users u) throws ParseException 
    {
        Users users=new Users();
//        Date bdate=u.getBirthdate();
//        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(bdate.toString());
        //users.setBirthdate(u.getBirthdate());
        users.setCity(u.getCity());
        users.setEmail(u.getEmail());
        users.setGender(u.getGender());
        users.setInterest(u.getInterest());
        users.setPassword(u.getPassword());
        users.setPhoneNumber(u.getPhoneNumber());
        users.setName(u.getName());
        client.addUser(users);
    }
    
    

    /**
     * PUT method for updating or creating an instance of RestResource
     * @param content representation for the resource
     */
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
