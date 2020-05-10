/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservice;

import ejb.adminejb;
import ejb.adminejbLocal;
import entity.Ratingcriterias;
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
@Path("ratingcriteria")
@RequestScoped
public class RatingcriteriaResource {

    @EJB
    adminejbLocal admin;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RatingcriteriaResource
     */
    public RatingcriteriaResource() {
    }

    @GET
    public Collection<Ratingcriterias> allRatingCriteria() {
        return admin.getAllRatingCriteria();
    }

    @POST
    @Path("addRatingCriteria/{ratingcriterianame}")
    public void addCategory(@PathParam("ratingcriterianame") String ratingcriterianame) {
        admin.addRatingCriteria(ratingcriterianame);
    }

    @GET
    @Path("getRatingCriteria/{ratingcriteriaid}")
    public Ratingcriterias getRatingCriteria(@PathParam("ratingcriteriaid") int ratingcriteriaid) {
        return admin.getRatingCriteriaById(ratingcriteriaid);
    }

    @POST
    @Path("updateRatingCriteria/{ratingcriteriaid}/{ratingcriterianame}")
    public void updateRatingCriteria(@PathParam("ratingcriteriaid") int ratingcriteriaid, @PathParam("ratingcriterianame") String ratingcriterianame) {
        admin.updateRatingCriteria(ratingcriteriaid, ratingcriterianame);
    }

    @POST
    @Path("deleteRatingCriteria/{ratingcriteriaid}")
    public void deleteRatingCriteria(@PathParam("ratingcriteriaid") int ratingcriteriaid) {
        admin.removeRatingCriteria(ratingcriteriaid);
    }
}
