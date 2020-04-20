/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.ProductJerseyClient;
import ejb.adminejbLocal;
import entity.Product;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author admin
 */
@Named(value = "productManagedBean")
@Dependent
public class ProductManagedBean {

    @EJB
    private adminejbLocal admin;

    ProductJerseyClient jerseyClient = new ProductJerseyClient();

    private int productId, categoryId, authorId, genreId, publisherId, companyId;
    private String productName, referencelink;
    private final String pImage = "noimage.png";
    private UploadedFile productImage;

    public ProductManagedBean() {
    }

    public adminejbLocal getAdmin() {
        return admin;
    }

    public void setAdmin(adminejbLocal admin) {
        this.admin = admin;
    }

    public ProductJerseyClient getJerseyClient() {
        return jerseyClient;
    }

    public void setJerseyClient(ProductJerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getReferencelink() {
        return referencelink;
    }

    public void setReferencelink(String referencelink) {
        this.referencelink = referencelink;
    }

    public UploadedFile getProductImage() {
        return productImage;
    }

    public void setProductImage(UploadedFile productImage) {
        this.productImage = productImage;
    }

    public Collection<Product> getAllProduct() {
        Response response = jerseyClient.allProduct(Response.class);
        ArrayList<Product> arrayList = new ArrayList<Product>();
        GenericType<Collection<Product>> genericType = new GenericType<Collection<Product>>() {
        };
        arrayList = (ArrayList<Product>) response.readEntity(genericType);
        return arrayList;
    }

    public String addProduct() {
        if (this.productId != 0) {
            jerseyClient.updateProduct(productId + "", categoryId + "", productName, pImage, referencelink, authorId + "", genreId + "", publisherId + "", companyId + "");
        } else {
            jerseyClient.addProduct(categoryId + "", productName, pImage, referencelink, authorId + "", genreId + "", publisherId + "", companyId + "");
        }
        return "productindex.xhtml";
    }

    public String deleteProduct(String productId, String categoryId) {
        jerseyClient.deleteProduct(productId, categoryId);
        return "productindex.xhtml";
    }

    public String getProduct(String productId) {
        Response response = jerseyClient.getProduct(Response.class, productId);
        GenericType<Product> genericType = new GenericType<Product>() {
        };
        Product product = response.readEntity(genericType);
        this.productId = product.getProductId();
        this.categoryId = product.getCategoryId().getCategoryId();
        productName = product.getProductName();
//        productimage = product.getProductImage();
        referencelink = product.getReferenceLink();
        authorId = product.getAuthorId().getAuthorId();
        genreId = product.getGenreId().getGenreId();
        publisherId = product.getPublisherId().getPublisherId();
        companyId = product.getCompanyId().getCompanyId();

        return "addproduct.xhtml";
    }

    public void upload() {
        if (productImage != null) {
            FacesMessage message = new FacesMessage("Successful", productImage.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
