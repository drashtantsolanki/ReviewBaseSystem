/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.NewsJerseyClient;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import models.NewsEntity;

/**
 * 
 * 
/**
 *
 * @author hi
 */
@Named(value = "newsManagedBean")
@RequestScoped
public class NewsManagedBean {
    
    NewsJerseyClient njc=new NewsJerseyClient();
    private String author,title,description,url,urlToImage,publishedAt,content;
    private Collection<NewsEntity> lstNews;
    

    public NewsManagedBean() {
        
    }

    public NewsJerseyClient getNjc() {
        return njc;
    }

    public void setNjc(NewsJerseyClient njc) {
        this.njc = njc;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Collection<NewsEntity> getLstNews() {
        return lstNews;
    }

    public void setLstNews(Collection<NewsEntity> lstNews) {
        this.lstNews = lstNews;
    }
    
    
    
    @PostConstruct
    public void init()
    {
        lstNews=new ArrayList<NewsEntity>();
    }    
    
    public void getAllNews()
    {
        
    }
    
}
