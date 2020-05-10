/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservice;

import ejb.adminejbLocal;
import entity.Categoryratingcriteria;
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
@Path("categoryratingcriteria")
@RequestScoped
public class CategoryratingcriteriaResource {

    @EJB
    adminejbLocal admin;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CategoryratingcriteriaResource
     */
    public CategoryratingcriteriaResource() {
    }

    @GET
    public Collection<Categoryratingcriteria> allCategoryratingcriteria() {
        return admin.getAllCategoryRatingCriteria();
    }

    @POST
    @Path("addCategoryratingcriteria/{categoryid}/{ratingcriteriaid}")
    public void addCategoryratingcriteria(@PathParam("categoryid") int categoryid, @PathParam("ratingcriteriaid") int ratingcriteriaid) {
        admin.addCategoryRatingCriteria(categoryid, ratingcriteriaid);
    }

    @GET
    @Path("getCategoryratingcriteria/{categoryratingcriteriaid}")
    public Categoryratingcriteria getCategoryratingcriteria(@PathParam("categoryratingcriteriaid") int categoryratingcriteriaid) {
        return admin.getCategoryRatingCriteriaById(categoryratingcriteriaid);
    }

    @POST
    @Path("updateCategoryratingcriteria/{categoryratingcriteriaid}/{categoryid}/{ratingcriteriaid}")
    public void updateCategoryratingcriteria(@PathParam("categoryratingcriteriaid") int categoryratingcriteriaid, @PathParam("categoryid") int categoryid, @PathParam("ratingcriteriaid") int ratingcriteriaid) {
        admin.updateCategoryRatingCriteria(categoryratingcriteriaid, categoryid, ratingcriteriaid);
    }

    @POST
    @Path("deleteCategoryratingcriteria/{categoryratingcriteriaid}")
    public void deleteCategoryratingcriteria(@PathParam("categoryratingcriteriaid") int categoryratingcriteriaid) {
        admin.removeCategoryRatingCriteria(categoryratingcriteriaid);
    }

    @GET
    @Path("getCategoryratingcriteriaByCategoryId/{categoryid}")
    public Categoryratingcriteria getCategoryratingcriteriaByCategoryId(@PathParam("categoryid") int categoryid) {
        return (Categoryratingcriteria) admin.getCategoryRatingCriteriaByCategoryId(categoryid);
    }

    @GET
    @Path("getCategoryRatingCriteriaByRatingCriteriaId/{ratingcriteriaid}")
    public Categoryratingcriteria getCategoryRatingCriteriaByRatingCriteriaId(@PathParam("ratingcriteriaid") int ratingcriteriaid) {
        return (Categoryratingcriteria) admin.getCategoryRatingCriteriaByRatingCriteriaId(ratingcriteriaid);
    }

}
