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
 * Jersey REST client generated for REST resource:UserRoleResource
 * [userrole]<br>
 * USAGE:
 * <pre>
 *        UserRoleJerseyClient client = new UserRoleJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author hi
 */
public class UserRoleJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ReviewBaseSystem-war/webresources";

    public UserRoleJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("userrole");
    }

    public <T> T getUserRole(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateUserRole(String id, String uid, String rid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateUserRole/{0}/{1}/{2}", new Object[]{id, uid, rid})).request().post(null);
    }

    public void deleteUserrole(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteUserrole/{0}", new Object[]{id})).request().delete();
    }

    public void putJson(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void addUserRole(String uid, String rid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addUserRole/{0}/{1}", new Object[]{uid, rid})).request().post(null);
    }

    public <T> T getUserroleById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserroleById/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
