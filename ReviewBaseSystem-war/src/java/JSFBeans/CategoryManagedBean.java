/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.CategoryJerseyClient;
import ejb.adminejbLocal;
import entity.Category;
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
@Named(value = "categoryManagedBean")
@RequestScoped
public class CategoryManagedBean {

    @EJB
    private adminejbLocal admin;

    CategoryJerseyClient jerseyClient = new CategoryJerseyClient();

    private int categoryId;
    private String categoryName;

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

    public Collection<Category> getAllCategory() {
        Response response = jerseyClient.allCategory(Response.class);
        ArrayList<Category> arrayList = new ArrayList<Category>();
        GenericType<Collection<Category>> genericType = new GenericType<Collection<Category>>() {
        };
        arrayList = (ArrayList<Category>) response.readEntity(genericType);
        return arrayList;
    }

    public String addCategory() {
        if (this.categoryId != 0) {
            jerseyClient.updateCategory(categoryId + "", categoryName);
        } else {
            jerseyClient.addCategory(categoryName);
        }
        return "categoryindex.xhtml";
    }

    public String deleteCategory(String categoryId) {
        jerseyClient.deleteCategory(categoryId);
        return "categoryindex.xhtml";
    }

    public String getCategory(String categoryId) {
        Response response = jerseyClient.getCategory(Response.class, categoryId);
        GenericType<Category> genericType = new GenericType<Category>() {
        };
        Category category = response.readEntity(genericType);
        this.categoryId = category.getCategoryId();
        categoryName = category.getCategoryName();

        return "addcategory.xhtml";
    }
}