/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Author;
import entity.Company;
import entity.Genre;
import entity.Publisher;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author hi
 */
@Local
public interface commanejbLocal {
    //************Author Methods***************//

    void addAuthor(String AuthorName);

    void updateAuthor(int AuthorId, String AuthorName);

    void removeAuthor(int AuthorId);

    Author getAuthorById(int AuthorId);

    Author getAuthorByName(String AuthorName);

    Collection<Author> getAllAuthor();

    //************Company Methods***************//
    void addCompany(String CompanyName);

    void updateComapany(int CompanyId, String CompanyName);

    void removeCompany(int CompanyId);

    Company getCompanuById(int CompanyId);

    Company getCompanyByName(String CompanyName);

    Collection<Company> getAllCompany();

    //*********Genre Methods************//
    void addGenre(String GenreName);

    void updateGenre(int GenreId, String GenreName);

    void removeGenre(int GenreId);

    Genre getGenreById(int GenreId);

    Genre getGenreByName(String GenreName);

    Collection<Genre> getAllGenre();

    //************Publisher Methods***************//
    void addPublisher(String PublisherName);

    void updatePublisher(int PublisherId, String PublisherName);

    void removePublisher(int PublisherId);

    Publisher getPublisherById(int PublisherId);

    Publisher getPublisherByName(String PublisherName);

    Collection<Publisher> getAllPublisher();
}
