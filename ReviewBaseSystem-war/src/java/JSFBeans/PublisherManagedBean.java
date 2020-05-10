/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.PublisherJerseyClient;
import ejb.commanejbLocal;
import entity.Publisher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author admin
 */
@Named(value = "publisherManagedBean")
@RequestScoped
public class PublisherManagedBean {

    @EJB
    private commanejbLocal comman;

    PublisherJerseyClient jerseyClient = new PublisherJerseyClient();

    private int publisherId;
    private String publisherName;
    private List<Publisher> publishers;

    public PublisherManagedBean() {
    }

    public commanejbLocal getComman() {
        return comman;
    }

    public void setComman(commanejbLocal comman) {
        this.comman = comman;
    }

    public PublisherJerseyClient getJerseyClient() {
        return jerseyClient;
    }

    public void setJerseyClient(PublisherJerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    @PostConstruct
    public void init() {
        Response response = jerseyClient.allPublisher(Response.class);
        ArrayList<Publisher> arrayList = new ArrayList<Publisher>();
        GenericType<Collection<Publisher>> genericType = new GenericType<Collection<Publisher>>() {
        };
        arrayList = (ArrayList<Publisher>) response.readEntity(genericType);
        publishers = arrayList;
    }

    public String addPublisher() {
        if (this.publisherId != 0) {
            jerseyClient.updatePublisher(publisherId + "", publisherName);
        } else {
            jerseyClient.addPublisher(publisherName);
        }
        return "publisherindex.xhtml";
    }

    public String deletePublisher(String publisherId) {
        jerseyClient.deletePublisher(publisherId);
        return "publisherindex.xhtml";
    }

    public String getPublisher(String publisherId) {
        Response response = jerseyClient.getPublisher(Response.class, publisherId);
        GenericType<Publisher> genericType = new GenericType<Publisher>() {
        };
        Publisher publisher = response.readEntity(genericType);
        this.publisherId = publisher.getPublisherId();
        publisherName = publisher.getPublisherName();

        return "addpublisher.xhtml";
    }

}
