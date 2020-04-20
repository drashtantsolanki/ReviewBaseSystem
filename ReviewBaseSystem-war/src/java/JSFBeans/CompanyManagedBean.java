/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.CompanyJerseyClient;
import ejb.commanejbLocal;
import entity.Company;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author admin
 */
@Named(value = "companyManagedBean")
@RequestScoped
public class CompanyManagedBean {

    @EJB
    private commanejbLocal comman;

    CompanyJerseyClient jerseyClient = new CompanyJerseyClient();

    private int companyId;
    private String companyName;

    public CompanyManagedBean() {
    }

    public commanejbLocal getComman() {
        return comman;
    }

    public void setComman(commanejbLocal comman) {
        this.comman = comman;
    }

    public CompanyJerseyClient getJerseyClient() {
        return jerseyClient;
    }

    public void setJerseyClient(CompanyJerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Collection<Company> getAllCompany() {
        Response response = jerseyClient.allCompany(Response.class);
        ArrayList<Company> arrayList = new ArrayList<Company>();
        GenericType<Collection<Company>> genericType = new GenericType<Collection<Company>>() {
        };
        arrayList = (ArrayList<Company>) response.readEntity(genericType);
        return arrayList;
    }

    public String addCompany() {
        if (this.companyId != 0) {
            jerseyClient.updateCompany(companyId + "", companyName);
        } else {
            jerseyClient.addCompany(companyName);
        }
        return "companyindex.xhtml";
    }

    public String deleteCompany(String companyId) {
        jerseyClient.deleteCompany(companyId);
        return "companyindex.xhtml";
    }

    public String getCompany(String companyId) {
        Response response = jerseyClient.getCompany(Response.class, companyId);
        GenericType<Company> genericType = new GenericType<Company>() {
        };
        Company company = response.readEntity(genericType);
        this.companyId = company.getCompanyId();
        companyName = company.getCompanyName();

        return "addcompany.xhtml";
    }
}
