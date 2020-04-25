/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.CategoryJerseyClient;
import com.oracle.wls.shaded.org.apache.bcel.generic.AALOAD;
import ejb.adminejbLocal;
import entity.Category;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author admin
 */
@Named(value = "categoryManagedBean")
@RequestScoped
public class CategoryManagedBean implements Serializable {

    @EJB
    private adminejbLocal admin;

    CategoryJerseyClient jerseyClient = new CategoryJerseyClient();

    private int categoryId;
    private String categoryName;
    private List<Category> categorys;

    public CategoryManagedBean() {
    }

    public adminejbLocal getAdmin() {
        return admin;
    }

    public void setAdmin(adminejbLocal admin) {
        this.admin = admin;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int CategoryId) {
        this.categoryId = CategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.categoryName = CategoryName;
    }

    public CategoryJerseyClient getJerseyClient() {
        return jerseyClient;
    }

    public void setJerseyClient(CategoryJerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    public List<Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<Category> categorys) {
        this.categorys = categorys;
    }

    @PostConstruct
    public void init() {
        Response response = jerseyClient.allCategory(Response.class);
        ArrayList<Category> arrayList = new ArrayList<Category>();
        GenericType<Collection<Category>> genericType = new GenericType<Collection<Category>>() {
        };
        arrayList = (ArrayList<Category>) response.readEntity(genericType);
        categorys = arrayList;
    }

    public void onRowEdit(RowEditEvent<Category> event) {
        FacesMessage msg = new FacesMessage("Edit Successfully", event.getObject().getCategoryName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        jerseyClient.updateCategory(event.getObject().getCategoryId() + "", event.getObject().getCategoryName());
    }

    public void onRowCancel(RowEditEvent<Category> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getCategoryName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String addCategory() {
        jerseyClient.addCategory(categoryName);
        return "categoryindex.xhtml?faces-redirect=true";
    }

    public String deleteCategory(String categoryId) {
        jerseyClient.deleteCategory(categoryId);
        return "categoryindex.xhtml?faces-redirect=true";
    }

    public void getCategory(String categoryId) {
        Response response = jerseyClient.getCategory(Response.class, categoryId);
        GenericType<Category> genericType = new GenericType<Category>() {
        };
        Category category = response.readEntity(genericType);
        this.categoryId = category.getCategoryId();
        categoryName = category.getCategoryName();
    }
}
