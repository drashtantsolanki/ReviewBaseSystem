/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.RatingCriteriaJerseyClient;
import ejb.adminejbLocal;
import entity.Category;
import entity.Ratingcriterias;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author admin
 */
@Named(value = "ratingCriteriaManagedBean")
@RequestScoped
public class RatingCriteriaManagedBean {

    @EJB
    private adminejbLocal admin;

    RatingCriteriaJerseyClient jerseyClient = new RatingCriteriaJerseyClient();

    private int ratingcriteriaId;
    private String ratingcriteriaName;
    private List<Ratingcriterias> ratingcriteriases;

    public RatingCriteriaManagedBean() {
    }

    public adminejbLocal getAdmin() {
        return admin;
    }

    public void setAdmin(adminejbLocal admin) {
        this.admin = admin;
    }

    public RatingCriteriaJerseyClient getJerseyClient() {
        return jerseyClient;
    }

    public void setJerseyClient(RatingCriteriaJerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    public int getRatingcriteriaId() {
        return ratingcriteriaId;
    }

    public void setRatingcriteriaId(int ratingcriteriaId) {
        this.ratingcriteriaId = ratingcriteriaId;
    }

    public String getRatingcriteriaName() {
        return ratingcriteriaName;
    }

    public void setRatingcriteriaName(String ratingcriteriaName) {
        this.ratingcriteriaName = ratingcriteriaName;
    }

    public List<Ratingcriterias> getRatingcriteriases() {
        return ratingcriteriases;
    }

    public void setRatingcriteriases(List<Ratingcriterias> ratingcriteriases) {
        this.ratingcriteriases = ratingcriteriases;
    }

    @PostConstruct
    public void init() {
        Response response = jerseyClient.allRatingCriteria(Response.class);
        ArrayList<Ratingcriterias> arrayList = new ArrayList<Ratingcriterias>();
        GenericType<Collection<Ratingcriterias>> genericType = new GenericType<Collection<Ratingcriterias>>() {
        };
        arrayList = (ArrayList<Ratingcriterias>) response.readEntity(genericType);
        ratingcriteriases = arrayList;
    }

    public String addRatingCriteria() {
        jerseyClient.addRatingCriteria(ratingcriteriaName);
        return "ratingcriteriaindex.xhtml?faces-redirect=true";
    }

    public void onRowEdit(RowEditEvent<Ratingcriterias> event) {
        FacesMessage msg = new FacesMessage("Edit Successfully", event.getObject().getCriteriaName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println(event.getObject().getCriteriaName());
        jerseyClient.updateRatingCriteria(event.getObject().getRatingCriteriaId() + "", event.getObject().getCriteriaName());
    }

    public void onRowCancel(RowEditEvent<Ratingcriterias> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getCriteriaName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String deleteRatingCriteria(String ratingcriteriaId) {
        jerseyClient.deleteRatingCriteria(ratingcriteriaId);
        return "ratingcriteriaindex.xhtml?faces-redirect=true";
    }

    public String getRatingCriteria(String ratingcriteriaId) {
        Response response = jerseyClient.getRatingCriteria(Response.class, ratingcriteriaId);
        GenericType<Ratingcriterias> genericType = new GenericType<Ratingcriterias>() {
        };
        Ratingcriterias ratingcriterias = response.readEntity(genericType);
        this.ratingcriteriaId = ratingcriterias.getRatingCriteriaId();
        ratingcriteriaName = ratingcriterias.getCriteriaName();

        return "addratingcriteria.xhtml";
    }
}
