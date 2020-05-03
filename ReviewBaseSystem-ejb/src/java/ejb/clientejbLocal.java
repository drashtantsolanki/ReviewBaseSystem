/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Advertise;
import entity.Reviews;
import entity.Reviewxcriteria;
import entity.Users;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author hi
 */
@Local
public interface clientejbLocal {

    //user    
    Collection<Users> getAllUsers();

    Users getUserById(int userId);

    Users getUserByName(String name);

    Users getUserByEmail(String email);

    Collection<Users> getUserByCity(String city);

    void addUser(String name, String email, String phno, String interest, String gender, Date bdate, String city, String pass);

    void updateUser(int uid, String name, String email, String phno, String interest, String gender, Date bdate, String city);

    void removeUser(int userId);

    String getEncryptedPassword(String Password);

    //advertisement
    Collection<Advertise> getAllAdvertise();

    Advertise getAdvertiseById(int advertiseId);

    Advertise getAdvertiseByProductId(int productId);

    Collection<Advertise> getAdvertiseByDate(Date date);

    //Advertise getAdvertiseByDate(Date date);
    //(if advertise is exists between start date and end date)
    void addAdvertise(Date startDate, Date endDate, int productId);

    void updateAdvertise(int advertiseId, Date startDate, Date endDate, int productId);

    void removeAdvertise(int advertiseId);

    //Reviews
    Collection<Reviews> getAllReviews();

    Reviews getReviewById(int reviewId);

    Collection<Reviews> getReviewByProductID(int productId);

    Collection<Reviews> getReviewByDate(Date date);

    Collection<Reviews> getReviewsByUserId(int userId);

    void addReview(int productId, Date date, int userId);

    void updateReview(int reviewId, int productId, Date date, int userId);

    void removeReview(int reviewId, int productId, int userId);

    //ReviewxCriteria
    Collection<Reviewxcriteria> getAllReviewxCriteria();

    Reviewxcriteria getReviewxCriteriaById(int reviewXcriteriaId);

    Collection<Reviewxcriteria> getReviewxCriteriaByRate(float rate);

    Reviewxcriteria getReviewxCriteriaByCategoryRatingCriteriaId(int categoryRatingCriteriaId);

    Reviewxcriteria getReviewxCriteriaByReviewId(int reviewId);

    void addReviewxCriteria(int rate, String description, int categoryRatingCriteriaId, int reviewId);

    void updateReviewxCriteria(int reviewXcriteriaId, int rate, String description, int categoryRatingCriteriaId, int reviewId);

    void removeReviewxCriteria(int reviewXcriteriaId, int categoryRatingCriteriaId, int reviewId);

    public Collection<Advertise> getAdvertiseByDate(String tdate);
}
