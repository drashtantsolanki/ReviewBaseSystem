/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.ProductJerseyClient;
import ejb.adminejbLocal;
import entity.Categoryratingcriteria;
import entity.Product;
import entity.Reviews;
import entity.Reviewxcriteria;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import models.custom;
import org.primefaces.event.RateEvent;
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
    private int productId, categoryId, authorId, genreId, publisherId, companyId, rate1, rate2;
    private String productName, referencelink, productImage;
    private UploadedFile file;
    private Collection<Product> productsbycateogry;
    private Collection<Categoryratingcriteria> categoryratingcriterias;
    private Collection<Reviewxcriteria> reviewxcriterias;
    private Collection<custom> customcollection;
    private Collection<Reviews> reviewses;

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

    public Collection<Product> getProductsbycateogry() {
        return productsbycateogry;
    }

    public void setProductsbycateogry(Collection<Product> productsbycateogry) {
        this.productsbycateogry = productsbycateogry;
    }

    public Collection<Categoryratingcriteria> getCategoryratingcriterias() {
        return categoryratingcriterias;
    }

    public void setCategoryratingcriterias(Collection<Categoryratingcriteria> categoryratingcriterias) {
        this.categoryratingcriterias = categoryratingcriterias;
    }

    public Collection<Reviewxcriteria> getReviewxcriterias() {
        return reviewxcriterias;
    }

    public void setReviewxcriterias(Collection<Reviewxcriteria> reviewxcriterias) {
        this.reviewxcriterias = reviewxcriterias;
    }

    public int getRate1() {
        return rate1;
    }

    public void setRate1(int rate1) {
        this.rate1 = rate1;
    }

    public int getRate2() {
        return rate2;
    }

    public void setRate2(int rate2) {
        this.rate2 = rate2;
    }

    public Collection<custom> getCustomcollection() {
        return customcollection;
    }

    public void setCustomcollection(Collection<custom> customcollection) {
        this.customcollection = customcollection;
    }

    public Collection<Reviews> getReviewses() {
        return reviewses;
    }

    public void setReviewses(Collection<Reviews> reviewses) {
        this.reviewses = reviewses;
    }

    @PostConstruct
    public void init() {
        Response response = jerseyClient.allProduct(Response.class);
        ArrayList<Product> arrayList = new ArrayList<Product>();
        GenericType<Collection<Product>> genericType = new GenericType<Collection<Product>>() {
        };
        arrayList = (ArrayList<Product>) response.readEntity(genericType);
        products = arrayList;

        customcollection = new ArrayList<custom>();
        reviewses = new ArrayList<Reviews>();
        reviewxcriterias = new ArrayList<Reviewxcriteria>();

        try {
            getProduct(String.valueOf(productId));
        } catch (Exception e) {

        }
    }

    public String addProduct() throws IOException {
        if (file != null) {
            System.out.println(file.getFileName());
            InputStream input = file.getInputStream();
            String path = "F:\\Project\\ReviewBaseSystem\\ReviewBaseSystem\\ReviewBaseSystem-war\\web\\images\\productimages";
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            sb.append(random.nextInt(9) + 1);
            for (int i = 0; i < 11; i++) {
                sb.append(random.nextInt(10));
            }
            String temp = sb.toString();
            productImage = temp + file.getFileName();
            Files.copy(input, new File(path, productImage).toPath());
            jerseyClient.addProduct(categoryId + "", productName, productImage, referencelink, authorId + "", genreId + "", publisherId + "", companyId + "");
        }
        return "productindex.xhtml?faces-redirect=true";
    }

    public String deleteProduct(int productid) {
        admin.removeProduct(productid);
        return "productindex.xhtml?faces-redirect=true";
    }

    public String getProduct(String productId) throws IOException {
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

        categoryratingcriterias = admin.getCategoryRatingCriteriaByCategoryId(categoryId);

        for (Categoryratingcriteria c : categoryratingcriterias) {
            int id = admin.getCategoryratingcriteria(categoryId, c.getRatingCriteriaId().getRatingCriteriaId());
            reviewses = admin.getReviewsByProductId(this.productId);

            for (Reviews r : reviewses) {
                reviewxcriterias = admin.getReviewxCriteriaByCategoryRatingCriteriaIdandReviewId(id, r.getReviewId());
                System.out.println("test");
                for (Reviewxcriteria r1 : reviewxcriterias) {
                    System.out.println(r1.getRate() + " " + r1.getCategoryRatingCriteriaId().getRatingCriteriaId().getCriteriaName() + " " + r1.getReviewId().getReviewId());
                }
            }
        }

        return "productrating.xhtml";
    }

    public void handleFileUpload() {
//        System.out.println(productId);
        System.out.println(file.getFileName());
//        return "productindex.xhtml?faces-redirect=true";
    }

    public void onRowEdit(RowEditEvent<Product> event) {
        FacesMessage msg = new FacesMessage("Product Edited", event.getObject().getAuthorId().getAuthorName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        admin.updateProductToCategory(event.getObject().getProductId(), event.getObject().getCategoryId().getCategoryId(), event.getObject().getProductName(), event.getObject().getReferenceLink(), event.getObject().getAuthorId().getAuthorId(), event.getObject().getGenreId().getGenreId(), event.getObject().getPublisherId().getPublisherId(), event.getObject().getCompanyId().getCompanyId());
    }

    public void onRowCancel(RowEditEvent<Product> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void productByCategory(int categoryid) {
        productsbycateogry = null;
        products = null;
        productsbycateogry = admin.getProductByCategoryId(categoryid);
    }

    public void onrate(RateEvent<Integer> rateEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:" + rateEvent.getRating());
        FacesContext.getCurrentInstance().addMessage(null, message);
        System.out.println(rateEvent.getRating());
    }

    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addReview() {
        for (Reviewxcriteria r : reviewxcriterias) {
            System.out.println(r.getRate());
        }
    }
}
