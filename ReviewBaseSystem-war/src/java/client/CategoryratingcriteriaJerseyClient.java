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
 * Jersey REST client generated for REST resource:CategoryratingcriteriaResource
 * [categoryratingcriteria]<br>
 * USAGE:
 * <pre>
 *        CategoryratingcriteriaJerseyClient client = new CategoryratingcriteriaJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author admin
 */
public class CategoryratingcriteriaJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ReviewBaseSystem-war/webresources";

    public CategoryratingcriteriaJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("categoryratingcriteria");
    }

    public <T> T getCategoryratingcriteria(Class<T> responseType, String categoryratingcriteriaid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCategoryratingcriteria/{0}", new Object[]{categoryratingcriteriaid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T allCategoryratingcriteria(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateCategoryratingcriteria(String categoryratingcriteriaid, String categoryid, String ratingcriteriaid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCategoryratingcriteria/{0}/{1}/{2}", new Object[]{categoryratingcriteriaid, categoryid, ratingcriteriaid})).request().post(null);
    }

    public void deleteCategoryratingcriteria(String categoryratingcriteriaid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteCategoryratingcriteria/{0}", new Object[]{categoryratingcriteriaid})).request().post(null);
    }

    public <T> T getCategoryratingcriteriaByCategoryId(Class<T> responseType, String categoryid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCategoryratingcriteriaByCategoryId/{0}", new Object[]{categoryid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCategoryRatingCriteriaByRatingCriteriaId(Class<T> responseType, String ratingcriteriaid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCategoryRatingCriteriaByRatingCriteriaId/{0}", new Object[]{ratingcriteriaid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addCategoryratingcriteria(String categoryid, String ratingcriteriaid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCategoryratingcriteria/{0}/{1}", new Object[]{categoryid, ratingcriteriaid})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
