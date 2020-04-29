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
 * Jersey REST client generated for REST resource:ReviewxcriteriaResource
 * [reviewxcriteria]<br>
 * USAGE:
 * <pre>
 *        ReviewxcriteriaJerseyClient client = new ReviewxcriteriaJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author admin
 */
public class ReviewxcriteriaJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ReviewBaseSystem-war/webresources";

    public ReviewxcriteriaJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("reviewxcriteria");
    }

    public void deleteReviewxcriteria(String reviewxcriteriaid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteReviewxcriteria/{0}", new Object[]{reviewxcriteriaid})).request().post(null);
    }

    public <T> T getReviewxcriteriaByRate(Class<T> responseType, String rate) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getReviewxcriteriaByRate/{0}", new Object[]{rate}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateAuthor(String reviewxcriteriaid, String rate, String description, String categoryratingcriteriaid, String reviewid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateReviewxcriteria/{0}/{1}/{2}/{3}/{4}", new Object[]{reviewxcriteriaid, rate, description, categoryratingcriteriaid, reviewid})).request().post(null);
    }

    public <T> T getReviewxcriteriaByCategoryratingcriteria(Class<T> responseType, String categoryratingcriteriaid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getReviewxcriteriaByCategoryratingcriteria/{0}", new Object[]{categoryratingcriteriaid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T allReviewxcriteria(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addReviewxcriteria(String rate, String description, String categoryratingcriteriaid, String reviewid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addReviewxcriteria/{0}/{1}/{2}/{3}", new Object[]{rate, description, categoryratingcriteriaid, reviewid})).request().post(null);
    }

    public <T> T getReviewxcriteria(Class<T> responseType, String reviewxcriteriaid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getReviewxcriteria/{0}", new Object[]{reviewxcriteriaid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getReviewxcriteriaByReview(Class<T> responseType, String reviewid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getReviewxcriteriaByReview/{0}", new Object[]{reviewid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
