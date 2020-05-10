/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.ReviewxcriteriaJerseyClient;
import ejb.adminejbLocal;
import entity.Reviews;
import entity.Reviewxcriteria;
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
import org.primefaces.event.RateEvent;

/**
 *
 * @author admin
 */
@Named(value = "reviewxcriteriaManagedBean")
@RequestScoped
public class ReviewxcriteriaManagedBean {

    @EJB
    private adminejbLocal admin;

    ReviewxcriteriaJerseyClient jerseyClient = new ReviewxcriteriaJerseyClient();

    private int reviewxcriteriaId, categoryratingcriteriaId, reviewId;
    private Integer rate1, rate2;
    private String description;
    private List<Reviewxcriteria> reviewxcriterias;

    public ReviewxcriteriaManagedBean() {
    }

    public adminejbLocal getAdmin() {
        return admin;
    }

    public void setAdmin(adminejbLocal admin) {
        this.admin = admin;
    }

    public ReviewxcriteriaJerseyClient getJerseyClient() {
        return jerseyClient;
    }

    public void setJerseyClient(ReviewxcriteriaJerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    public int getReviewxcriteriaId() {
        return reviewxcriteriaId;
    }

    public void setReviewxcriteriaId(int reviewxcriteriaId) {
        this.reviewxcriteriaId = reviewxcriteriaId;
    }

    public int getCategoryratingcriteriaId() {
        return categoryratingcriteriaId;
    }

    public void setCategoryratingcriteriaId(int categoryratingcriteriaId) {
        this.categoryratingcriteriaId = categoryratingcriteriaId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getRate1() {
        return rate1;
    }

    public void setRate1(Integer rate1) {
        this.rate1 = rate1;
    }

    public Integer getRate2() {
        return rate2;
    }

    public void setRate2(Integer rate2) {
        this.rate2 = rate2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Reviewxcriteria> getReviewxcriterias() {
        return reviewxcriterias;
    }

    public void setReviewxcriterias(List<Reviewxcriteria> reviewxcriterias) {
        this.reviewxcriterias = reviewxcriterias;
    }

    @PostConstruct
    public void init() {
        Response response = jerseyClient.allReviewxcriteria(Response.class);
        ArrayList<Reviewxcriteria> arrayList = new ArrayList<Reviewxcriteria>();
        GenericType<Collection<Reviewxcriteria>> genericType = new GenericType<Collection<Reviewxcriteria>>() {
        };
        arrayList = (ArrayList<Reviewxcriteria>) response.readEntity(genericType);
        reviewxcriterias = arrayList;
    }

    public void addReviewxcriteria() {
//        jerseyClient.addReviewxcriteria(rate + "", description, categoryratingcriteriaId + "", reviewId + "");
//        return "reviewxcriteriaindex.xhtml?faces-redirect=true";
    }

    public String deleteReviewxcriteria(String reviewxcriteriaId) {
        jerseyClient.deleteReviewxcriteria(reviewxcriteriaId);
        return "reviewxcriteriaindex.xhtml?faces-redirect=true";
    }

    public String getReviewxcriteria(String reviewxcriteriaId) {
        Response response = jerseyClient.getReviewxcriteria(Response.class, reviewxcriteriaId);
        GenericType<Reviewxcriteria> genericType = new GenericType<Reviewxcriteria>() {
        };
        Reviewxcriteria reviewxcriteria = response.readEntity(genericType);
        this.reviewxcriteriaId = reviewxcriteria.getReviewXCriteriaId();
//        rate = reviewxcriteria.getRate();
        description = reviewxcriteria.getDescription();
        categoryratingcriteriaId = reviewxcriteria.getCategoryRatingCriteriaId().getCategoryRatingCriteriaId();
        reviewId = reviewxcriteria.getReviewXCriteriaId();

        return "addreview.xhtml";
    }

    public String getReviewcriteriaByRate(String rate) {
        Response response = jerseyClient.getReviewxcriteriaByRate(Response.class, rate);
        GenericType<Reviewxcriteria> genericType = new GenericType<Reviewxcriteria>() {
        };
        Reviewxcriteria reviewxcriteria = response.readEntity(genericType);
        this.reviewxcriteriaId = reviewxcriteria.getReviewXCriteriaId();
        description = reviewxcriteria.getDescription();
        categoryratingcriteriaId = reviewxcriteria.getCategoryRatingCriteriaId().getCategoryRatingCriteriaId();
        reviewId = reviewxcriteria.getReviewXCriteriaId();

        return "addreview.xhtml";
    }

    public String getReviewcriteriaByCategoryRatingCriteriaId(String categoryratingcriteriaId) {
        Response response = jerseyClient.getReviewxcriteriaByCategoryratingcriteria(Response.class, categoryratingcriteriaId);
        GenericType<Reviewxcriteria> genericType = new GenericType<Reviewxcriteria>() {
        };
        Reviewxcriteria reviewxcriteria = response.readEntity(genericType);
        this.reviewxcriteriaId = reviewxcriteria.getReviewXCriteriaId();
        description = reviewxcriteria.getDescription();
        reviewId = reviewxcriteria.getReviewXCriteriaId();

        return "addreview.xhtml";
    }

    public String getReviewxcriteriaByReviewId(String reviewId) {
        Response response = jerseyClient.getReviewxcriteriaByReview(Response.class, reviewId);
        GenericType<Reviewxcriteria> genericType = new GenericType<Reviewxcriteria>() {
        };
        Reviewxcriteria reviewxcriteria = response.readEntity(genericType);
        this.reviewxcriteriaId = reviewxcriteria.getReviewXCriteriaId();
        description = reviewxcriteria.getDescription();
        categoryratingcriteriaId = reviewxcriteria.getCategoryRatingCriteriaId().getCategoryRatingCriteriaId();

        return "addreview.xhtml";
    }

    public void onrate(RateEvent<Integer> rateEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:" + rateEvent.getRating());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addRating() {
        System.out.println(rate1+" "+rate2);
    }
}
