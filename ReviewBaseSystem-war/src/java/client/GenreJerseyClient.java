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
 * Jersey REST client generated for REST resource:GenreResource [genre]<br>
 * USAGE:
 * <pre>
 *        GenreJerseyClient client = new GenreJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author admin
 */
public class GenreJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ReviewBaseSystem-war/webresources";

    public GenreJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("genre");
    }

    public void deleteGenre(String genreid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteGenre/{0}", new Object[]{genreid})).request().post(null);
    }

    public void updateGenre(String genreid, String genrename) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateGenre/{0}/{1}", new Object[]{genreid, genrename})).request().post(null);
    }

    public <T> T allGenre(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getGenre(Class<T> responseType, String genreid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getGenre/{0}", new Object[]{genreid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addGenre(String genrename) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addGenre/{0}", new Object[]{genrename})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
