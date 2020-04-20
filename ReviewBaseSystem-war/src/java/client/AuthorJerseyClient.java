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
 * Jersey REST client generated for REST resource:AuthorResource [author]<br>
 * USAGE:
 * <pre>
 *        AuthorJerseyClient client = new AuthorJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author admin
 */
public class AuthorJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ReviewBaseSystem-war/webresources";

    public AuthorJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("author");
    }

    public <T> T getAuthor(Class<T> responseType, String authorid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAuthor/{0}", new Object[]{authorid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addAuthor(String authorname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addAuthor/{0}", new Object[]{authorname})).request().post(null);
    }

    public void updateAuthor(String authorid, String authorname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateAuthor/{0}/{1}", new Object[]{authorid, authorname})).request().post(null);
    }

    public <T> T allAuthor(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteAuthor(String authorid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteAuthor/{0}", new Object[]{authorid})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
