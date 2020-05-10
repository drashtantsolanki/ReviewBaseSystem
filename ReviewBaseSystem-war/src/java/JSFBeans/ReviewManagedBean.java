/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.ReviewJerseyClient;
import ejb.adminejbLocal;
import entity.Reviews;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
@Named(value = "reviewManagedBean")
@RequestScoped
public class ReviewManagedBean {

    @EJB
    private adminejbLocal admin;

    ReviewJerseyClient jerseyClient = new ReviewJerseyClient();

    private int reviewId, productId, userId;
    private Date date;
    private List<Reviews> reviewses;

    public ReviewManagedBean() {
    }

    public adminejbLocal getAdmin() {
        return admin;
    }

    public void setAdmin(adminejbLocal admin) {
        this.admin = admin;
    }

    public ReviewJerseyClient getJerseyClient() {
        return jerseyClient;
    }

    public void setJerseyClient(ReviewJerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Reviews> getReviewses() {
        return reviewses;
    }

    public void setReviewses(List<Reviews> reviewses) {
        this.reviewses = reviewses;
    }

    @PostConstruct
    public void init() {
        Response response = jerseyClient.allReview(Response.class);
        ArrayList<Reviews> arrayList = new ArrayList<Reviews>();
        GenericType<Collection<Reviews>> genericType = new GenericType<Collection<Reviews>>() {
        };
        arrayList = (ArrayList<Reviews>) response.readEntity(genericType);
        reviewses = arrayList;
    }

    public String addReview() {
        jerseyClient.addReview(productId + "", date + "", userId + "");
        return "ratingcriteriaindex.xhtml?faces-redirect=true";
    }

    public String deleteReview(String reviewId) {
        jerseyClient.deleteReview(reviewId);
        return "reviewindex.xhtml?faces-redirect=true";
    }

    public String getReview(String reviewId) {
        Response response = jerseyClient.getReviews(Response.class, reviewId);
        GenericType<Reviews> genericType = new GenericType<Reviews>() {
        };
        Reviews reviews = response.readEntity(genericType);
        this.reviewId = reviews.getReviewId();
        date = reviews.getDate();
        productId = reviews.getProductId().getProductId();
        userId = reviews.getUserId().getUserId();

        return "addreview.xhtml";
    }

    public String getReviewByDate(String date) {
        Response response = jerseyClient.getReviewByDate(Response.class, date);
        GenericType<Reviews> genericType = new GenericType<Reviews>() {
        };
        Reviews reviews = response.readEntity(genericType);
        this.reviewId = reviews.getReviewId();
        date = reviews.getDate().toString();
        productId = reviews.getProductId().getProductId();
        userId = reviews.getUserId().getUserId();

        return "addreview.xhtml";
    }

    public String getReviewByProductId(String productId) {
        Response response = jerseyClient.getReviewByProductId(Response.class, productId);
        GenericType<Reviews> genericType = new GenericType<Reviews>() {
        };
        Reviews reviews = response.readEntity(genericType);
        this.reviewId = reviews.getReviewId();
        date = reviews.getDate();
        productId = reviews.getProductId().getProductId().toString();
        userId = reviews.getUserId().getUserId();

        return "addreview.xhtml";
    }

    public String getReviewByUserId(String userId) {
        Response response = jerseyClient.getReviewByUserId(Response.class, userId);
        GenericType<Reviews> genericType = new GenericType<Reviews>() {
        };
        Reviews reviews = response.readEntity(genericType);
        this.reviewId = reviews.getReviewId();
        date = reviews.getDate();
        productId = reviews.getProductId().getProductId();
        userId = reviews.getUserId().getUserId().toString();

        return "addreview.xhtml";
    }
}
