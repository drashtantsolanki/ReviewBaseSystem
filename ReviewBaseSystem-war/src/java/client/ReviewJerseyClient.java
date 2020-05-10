/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:ReviewResource [review]<br>
 * USAGE:
 * <pre>
 *        ReviewJerseyClient client = new ReviewJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author admin
 */
public class ReviewJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ReviewBaseSystem-war/webresources";

    public ReviewJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("review");
    }

    public <T> T getReviewByProductId(Class<T> responseType, String productid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getReviewByProductId/{0}", new Object[]{productid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T allReview(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getReviews(Class<T> responseType, String reviewid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getReview/{0}", new Object[]{reviewid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getReviewByDate(Class<T> responseType, String date) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getReviewByDate/{0}", new Object[]{date}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getReviewByUserId(Class<T> responseType, String userid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getReviewByUserId/{0}", new Object[]{userid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addReview(String productid, String date, String userid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addReview/{0}/{1}/{2}", new Object[]{productid, date, userid})).request().post(null);
    }

    public void updateReview(String reviewid, String productid, String date, String userid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateReview/{0}/{1}/{2}/{3}", new Object[]{reviewid, productid, date, userid})).request().post(null);
    }

    public void deleteReview(String reviewid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteReview/{0}", new Object[]{reviewid})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
