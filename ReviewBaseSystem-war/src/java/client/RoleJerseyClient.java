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
 * Jersey REST client generated for REST resource:RoleResource [role]<br>
 * USAGE:
 * <pre>
 *        RoleJerseyClient client = new RoleJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author hi
 */
public class RoleJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ReviewBaseSystem-war/webresources";

    public RoleJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("role");
    }

    public <T> T getRoleById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getrole/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllRoles(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateRole(String id, String rolename) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateRole/{0}/{1}", new Object[]{id, rolename})).request().post(null);
    }

    public void deleteRole(String rid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleterole/{0}", new Object[]{rid})).request().delete();
    }

    public void addRole(String rolename) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addRole/{0}", new Object[]{rolename})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
