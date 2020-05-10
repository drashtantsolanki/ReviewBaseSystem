/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservice;

import ejb.commanejbLocal;
import entity.Publisher;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("publisher")
@RequestScoped
public class PublisherResource {
    
    @EJB
    commanejbLocal comman;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PublisherResource
     */
    public PublisherResource() {
    }
    
    @GET
    public Collection<Publisher> allPublisher() {
        return comman.getAllPublisher();
    }
    
    @POST
    @Path("addPublisher/{publishername}")
    public void addPublisher(@PathParam("publishername") String publishername) {
        comman.addPublisher(publishername);
    }
    
    @GET
    @Path("getPublisher/{publisherid}")
    public Publisher getPublisher(@PathParam("publisherid") int publisherid) {
        return comman.getPublisherById(publisherid);
    }
    
    @POST
    @Path("updatePublisher/{publisherid}/{publishername}")
    public void updatePublisher(@PathParam("publisherid") int publisherid, @PathParam("publishername") String publishername) {
        comman.updatePublisher(publisherid, publishername);
    }
    
    @POST
    @Path("deletePublisher/{publisherid}")
    public void deletePublisher(@PathParam("publisherid") int publisherid) {
        comman.removePublisher(publisherid);
    }
}
