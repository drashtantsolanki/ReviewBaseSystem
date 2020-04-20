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
 * Jersey REST client generated for REST resource:CompanyResource [company]<br>
 * USAGE:
 * <pre>
 *        CompanyJerseyClient client = new CompanyJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author admin
 */
public class CompanyJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ReviewBaseSystem-war/webresources";

    public CompanyJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("company");
    }

    public void deleteCompany(String companyid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteCompany/{0}", new Object[]{companyid})).request().post(null);
    }

    public <T> T getCompany(Class<T> responseType, String companyid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCompany/{0}", new Object[]{companyid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addCompany(String companyname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCompany/{0}", new Object[]{companyname})).request().post(null);
    }

    public void updateCompany(String companyid, String companyname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCompany/{0}/{1}", new Object[]{companyid, companyname})).request().post(null);
    }

    public <T> T allCompany(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
