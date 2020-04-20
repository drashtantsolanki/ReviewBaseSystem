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
 * Jersey REST client generated for REST resource:RatingcriteriaResource
 * [ratingcriteria]<br>
 * USAGE:
 * <pre>
 *        RatingCriteriaJerseyClient client = new RatingCriteriaJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author admin
 */
public class RatingCriteriaJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ReviewBaseSystem-war/webresources";

    public RatingCriteriaJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("ratingcriteria");
    }

    public <T> T allRatingCriteria(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteRatingCriteria(String categoryid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteRatingCriteria/{0}", new Object[]{categoryid})).request().post(null);
    }

    public void updateRatingCriteria(String ratingcriteriaid, String ratingcriterianame) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateRatingCriteria/{0}/{1}", new Object[]{ratingcriteriaid, ratingcriterianame})).request().post(null);
    }

    public <T> T getRatingCriteria(Class<T> responseType, String ratingcriteriaid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getRatingCriteria/{0}", new Object[]{ratingcriteriaid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addRatingCriteria(String ratingcriterianame) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addRatingCriteria/{0}", new Object[]{ratingcriterianame})).request().post(null);
    }

    public void close() {
        client.close();
    }

}
