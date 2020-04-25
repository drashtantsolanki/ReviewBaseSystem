/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.ProductJerseyClient;
import ejb.adminejbLocal;
import entity.Category;
import entity.Product;
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
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author admin
 */
@Named(value = "productManagedBean")
@RequestScoped
public class ProductManagedBean {

    @EJB
    private adminejbLocal admin;

    ProductJerseyClient jerseyClient = new ProductJerseyClient();

    private List<Product> products;
    private int productId, categoryId, authorId, genreId, publisherId, companyId;
    private String productName, referencelink, productImage;
    private UploadedFile file;

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

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @PostConstruct
    public void init() {
        Response response = jerseyClient.allProduct(Response.class);
        ArrayList<Product> arrayList = new ArrayList<Product>();
        GenericType<Collection<Product>> genericType = new GenericType<Collection<Product>>() {
        };
        arrayList = (ArrayList<Product>) response.readEntity(genericType);
        products = arrayList;
    }

    public String addProduct() {
        if (productId != 0) {
            System.out.println(productId + " " + categoryId + " " + productName + " " + referencelink + " " + authorId + " " + genreId + " " + publisherId + " " + companyId);
            admin.updateProductToCategory(productId, categoryId, productName, referencelink, authorId, genreId, publisherId, companyId);
        } else {
            jerseyClient.addProduct(categoryId + "", productName, productImage, referencelink, authorId + "", genreId + "", publisherId + "", companyId + "");
        }
        return "productindex.xhtml";
    }

    public String deleteProduct(String productId, String categoryId) {
        jerseyClient.deleteProduct(productId, categoryId);
        return "productindex.xhtml?faces-redirect=true";
    }

    public String getProduct(String productId) {
        Response response = jerseyClient.getProduct(Response.class, productId);
        GenericType<Product> genericType = new GenericType<Product>() {
        };
        Product product = response.readEntity(genericType);
        this.productId = product.getProductId();
        this.categoryId = product.getCategoryId().getCategoryId();
        productName = product.getProductName();
        productImage = product.getProductImage();
        referencelink = product.getReferenceLink();
        authorId = product.getAuthorId().getAuthorId();
        genreId = product.getGenreId().getGenreId();
        publisherId = product.getPublisherId().getPublisherId();
        companyId = product.getCompanyId().getCompanyId();

        System.out.println(categoryId + " " + referencelink + " " + authorId);

        return "addproduct.xhtml?faces-redirect=true";
    }

    public String handleFileUpload(String productId) {
        System.out.println(productId);
        System.out.println(file);
//        InputStream input = file.getInputStream();
//        String path = "F:\\Project\\ReviewBaseSystem\\ReviewBaseSystem\\ReviewBaseSystem-war\\web\\images\\productimages";
//        Random random = new Random();
//        StringBuilder sb = new StringBuilder();
//
//        sb.append(random.nextInt(9) + 1);
//        for (int i = 0; i < 11; i++) {
//            sb.append(random.nextInt(10));
//        }
//        String temp = sb.toString();
//        productImage = temp + file.getSubmittedFileName();
//        Files.copy(input, new File(path, productImage).toPath());
//        System.out.println("pid" + productId + " " + productImage);
//        admin.updateImage(Integer.parseInt(productId), productImage);
        return "productindex.xhtml?faces-redirect=true";
    }

    public void onRowEdit(RowEditEvent<Category> event) {
        FacesMessage msg = new FacesMessage("Category Edited", event.getObject().getCategoryName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
