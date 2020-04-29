/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.CategoryratingcriteriaJerseyClient;
import ejb.adminejbLocal;
import entity.Categoryratingcriteria;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author admin
 */
@Named(value = "categoryratingcriteriaManagedBean")
@RequestScoped
public class CategoryratingcriteriaManagedBean {

    @EJB
    private adminejbLocal admin;

    CategoryratingcriteriaJerseyClient jerseyClient = new CategoryratingcriteriaJerseyClient();

    private int categoryratingcriteriaId, categoryId, ratingcriteriaId;
    private List<Categoryratingcriteria> categoryratingcriterias;

    public CategoryratingcriteriaManagedBean() {
    }

    public adminejbLocal getAdmin() {
        return admin;
    }

    public void setAdmin(adminejbLocal admin) {
        this.admin = admin;
    }

    public CategoryratingcriteriaJerseyClient getJerseyClient() {
        return jerseyClient;
    }

    public void setJerseyClient(CategoryratingcriteriaJerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    public int getCategoryratingcriteriaId() {
        return categoryratingcriteriaId;
    }

    public void setCategoryratingcriteriaId(int categoryratingcriteriaId) {
        this.categoryratingcriteriaId = categoryratingcriteriaId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getRatingcriteriaId() {
        return ratingcriteriaId;
    }

    public void setRatingcriteriaId(int ratingcriteriaId) {
        this.ratingcriteriaId = ratingcriteriaId;
    }

    public List<Categoryratingcriteria> getCategoryratingcriterias() {
        return categoryratingcriterias;
    }

    public void setCategoryratingcriterias(List<Categoryratingcriteria> categoryratingcriterias) {
        this.categoryratingcriterias = categoryratingcriterias;
    }

    @PostConstruct
    public void init() {
        Response response = jerseyClient.allCategoryratingcriteria(Response.class);
        ArrayList<Categoryratingcriteria> arrayList = new ArrayList<Categoryratingcriteria>();
        GenericType<Collection<Categoryratingcriteria>> genericType = new GenericType<Collection<Categoryratingcriteria>>() {
        };
        arrayList = (ArrayList<Categoryratingcriteria>) response.readEntity(genericType);
        categoryratingcriterias = arrayList;
    }

    public String addCategoryratingcriteria() throws IOException {
        jerseyClient.addCategoryratingcriteria(categoryId + "", ratingcriteriaId + "");
        return "categoryratingcriteriaindex.xhtml?faces-redirect=true";
    }

    public String deleteCategoryratingcriteria(String categoryratingcriteriaId) {
        jerseyClient.deleteCategoryratingcriteria(categoryratingcriteriaId);
        return "productindex.xhtml?faces-redirect=true";
    }

    public String getCategoryratingcriteria(String categoryratingcriteriaId) {
        Response response = jerseyClient.getCategoryratingcriteria(Response.class, categoryratingcriteriaId);
        GenericType<Categoryratingcriteria> genericType = new GenericType<Categoryratingcriteria>() {
        };
        Categoryratingcriteria categoryratingcriteria = response.readEntity(genericType);
        this.categoryratingcriteriaId = categoryratingcriteria.getCategoryRatingCriteriaId();
        categoryId = categoryratingcriteria.getCategoryId().getCategoryId();
        ratingcriteriaId = categoryratingcriteria.getRatingCriteriaId().getRatingCriteriaId();

        return "productrating.xhtml";
    }

    public void getCategoryratingcriteriaByCategoryId(String categoryid) {        
        categoryratingcriterias = (List<Categoryratingcriteria>) admin.getCategoryRatingCriteriaByCategoryId(categoryId);
        System.out.println(categoryratingcriterias);
    }
}
