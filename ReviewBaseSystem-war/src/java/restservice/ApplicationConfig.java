/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservice;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author admin
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(restservice.AuthorResource.class);
        resources.add(restservice.CategoryResource.class);
        resources.add(restservice.CompanyResource.class);
        resources.add(restservice.GenreResource.class);
        resources.add(restservice.ProductResource.class);
        resources.add(restservice.PublisherResource.class);
        resources.add(restservice.RatingcriteriaResource.class);
    }
    
}
