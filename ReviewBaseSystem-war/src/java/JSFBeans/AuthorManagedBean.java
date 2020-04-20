/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.AuthorJerseyClient;
import ejb.commanejbLocal;
import entity.Author;
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
@Named(value = "authorManagedBean")
@RequestScoped
public class AuthorManagedBean {

    @EJB
    private commanejbLocal comman;

    AuthorJerseyClient jerseyClient = new AuthorJerseyClient();

    private int authorId;
    private String authorName;

    public AuthorManagedBean() {
    }

    public commanejbLocal getComman() {
        return comman;
    }

    public void setComman(commanejbLocal comman) {
        this.comman = comman;
    }

    public AuthorJerseyClient getJerseyClient() {
        return jerseyClient;
    }

    public void setJerseyClient(AuthorJerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Collection<Author> getAllAuthors() {
        Response response = jerseyClient.allAuthor(Response.class);
        ArrayList<Author> arrayList = new ArrayList<Author>();
        GenericType<Collection<Author>> genericType = new GenericType<Collection<Author>>() {
        };
        arrayList = (ArrayList<Author>) response.readEntity(genericType);
        return arrayList;
    }

    public String addAuthor() {
        if (this.authorId != 0) {
            jerseyClient.updateAuthor(authorId + "", authorName);
        } else {
            jerseyClient.addAuthor(authorName);
        }
        return "authorindex.xhtml";
    }

    public String deleteAuthor(String authorId) {
        jerseyClient.deleteAuthor(authorId);
        return "authorindex.xhtml";
    }

    public String getAuthor(String authorId) {
        Response response = jerseyClient.getAuthor(Response.class, authorId);
        GenericType<Author> genericType = new GenericType<Author>() {
        };
        Author author = response.readEntity(genericType);
        this.authorId = author.getAuthorId();
        authorName = author.getAuthorName();

        return "addauthor.xhtml";
    }

}
