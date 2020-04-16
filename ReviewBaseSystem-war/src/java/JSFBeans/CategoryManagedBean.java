/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import ejb.adminejbLocal;
import entity.Category;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author admin
 */
@Named(value = "categoryManagedBean")
@RequestScoped
public class CategoryManagedBean {
    
    @EJB
    private adminejbLocal admin;
    
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
        return admin.getAllCategory();
    }
    
    public String addCategory() {
        System.out.println("in add");
        if (this.categoryId != 0) {
            admin.updateCategory(this.categoryId, this.categoryName);
        } else {
            System.out.println("name=" + this.categoryName);
            admin.AddCategory(categoryName);
        }
        return "categoryindex.xhtml";
    }
    
    public String deleteCategory(String categoryId) {
        admin.removeCategory(Integer.parseInt(categoryId));
        return "categoryindex.xhtml";
    }
    
    public String getCategory(String categoryId) {
        Category category = admin.getCategoryById(Integer.parseInt(categoryId));
        this.categoryId = category.getCategoryId();
        this.categoryName = category.getCategoryName();
        return "addcategory.xhtml";
    }
    
}
