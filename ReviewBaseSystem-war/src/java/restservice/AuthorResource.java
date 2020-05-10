/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservice;

import ejb.commanejbLocal;
import entity.Author;
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
@Path("author")
@RequestScoped
public class AuthorResource {

    @EJB
    commanejbLocal comman;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AuthorResource
     */
    public AuthorResource() {
    }

    @GET
    public Collection<Author> allAuthor() {
        return comman.getAllAuthor();
    }

    @POST
    @Path("addAuthor/{authorname}")
    public void addAuthor(@PathParam("authorname") String authorname) {
        comman.addAuthor(authorname);
    }

    @GET
    @Path("getAuthor/{authorid}")
    public Author getAuthor(@PathParam("authorid") int authorid) {
        return comman.getAuthorById(authorid);
    }

    @POST
    @Path("updateAuthor/{authorid}/{authorname}")
    public void updateAuthor(@PathParam("authorid") int authorid, @PathParam("authorname") String authorname) {
        comman.updateAuthor(authorid, authorname);
    }

    @POST
    @Path("deleteAuthor/{authorid}")
    public void deleteAuthor(@PathParam("authorid") int authorid) {
        comman.removeAuthor(authorid);
    }
}
