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
 * Jersey REST client generated for REST resource:CategoryResource
 * [category]<br>
 * USAGE:
 * <pre>
 *        CategoryJerseyClient client = new CategoryJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author admin
 */
public class CategoryJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ReviewBaseSystem-war/webresources";

    public CategoryJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("category");
    }

    public <T> T allCategory(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateCategory(String categoryid, String categoryname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCategory/{0}/{1}", new Object[]{categoryid, categoryname})).request().post(null);
    }

    public <T> T getCategory(Class<T> responseType, String categoryid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCategory/{0}", new Object[]{categoryid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteCategory(String categoryid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteCategory/{0}", new Object[]{categoryid})).request().post(null);
    }

    public void addCategory(String categoryname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCategory/{0}", new Object[]{categoryname})).request().post(null);
    }

    public void close() {
        client.close();
    }

}
