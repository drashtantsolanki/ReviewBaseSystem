/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservice;

import ejb.adminejbLocal;
import entity.Product;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("product")
@RequestScoped
public class ProductResource {

    @EJB
    adminejbLocal admin;

    @Context
    private UriInfo context;

    public ProductResource() {
    }

    @GET
    public Collection<Product> allProduct() {
        return admin.getAllProduct();
    }

    @POST
    @Path("addProduct/{categoryid}/{productname}/{productimage}/{referencelink}/{authorid}/{genreid}/{publisherid}/{companyid}")
    public void addProduct(@PathParam("categoryid") int categoryid, @PathParam("productname") String productname, @PathParam("productimage") String productimage, @PathParam("referencelink") String referencelink, @PathParam("authorid") int authorid, @PathParam("genreid") int genreid, @PathParam("publisherid") int publisherid, @PathParam("companyid") int companyid) {
        admin.addProductToCategory(categoryid, productname, productimage, referencelink, authorid, genreid, publisherid, companyid);
    }

    @GET
    @Path("getProduct/{productid}")
    public Product getProduct(@PathParam("productid") int productid) {
        return admin.getProductById(productid);
    }

    @POST
    @Path("updateProduct/{productid}/{categoryid}/{productname}/{productimage}/{referencelink}/{authorid}/{genreid}/{publisherid}/{companyid}")
    public void updateProduct(@PathParam("productid") int productid, @PathParam("categoryid") int categoryid, @PathParam("productname") String productname, @PathParam("productimage") String productimage, @PathParam("referencelink") String referencelink, @PathParam("authorid") int authorid, @PathParam("genreid") int genreid, @PathParam("publisherid") int publisherid, @PathParam("companyid") int companyid) {
        admin.updateProductToCategory(productid, categoryid, productname, productimage, referencelink, authorid, genreid, publisherid, companyid);
    }

    @POST
    @Path("deleteProduct/{productid}/{categoryid}")
    public void deleteProduct(@PathParam("productid") int productid, @PathParam("categoryid") int categoryid) {
        admin.removeProductFromCategory(productid, categoryid);
    }
}
