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

    void addUser(Users objUser);

    void updateUser(Users objUser);

    void removeUser(int userId);

    String getEncryptedPassword(String Password);

    //advertisement
    Collection<Advertise> getAllAdvertise();

    Advertise getAdvertiseById(int advertiseId);

    Advertise getAdvertiseByProductId(int productId);

    Advertise getAdvertiseByDate(Date date);

    //(if advertise is exists between start date and end date)
    void addAdvertise(Advertise advertise);

    void updateAdvertise(int advertiseId);

    void removeAdvertise(int advertiseId);

    //Reviews
    Collection<Reviews> getAllReviews();

    Reviews getReviewById(int reviewId);

    Collection<Reviews> getReviewByProductID(int productId);

    Collection<Reviews> getReviewByDate(Date date);

    Collection<Reviews> getReviewsByUserId(int userId);

    void addReview(Reviews reviews);

    void updateReview(int reviewId, Reviews reviews);

    void removeReview(int reviewId);

    //ReviewxCriteria
    Collection<Reviewxcriteria> getAllReviewxCriteria();

    Reviewxcriteria getReviewxCriteriaById(int reviewXcriteriaId);

    Collection<Reviewxcriteria> getReviewxCriteriaByRate(float rate);

    Reviewxcriteria getReviewxCriteriaByCategoryRatingCriteriaId(int categoryRatingCriteriaId);

    Reviewxcriteria getReviewxCriteriaByReviewId(int reviewId);

    void addReviewxCriteria(Reviewxcriteria reviewxcriteria);

    void updateReviewxCriteria(int reviewXcriteriaId, Reviewxcriteria reviewxcriteria);

    void removeReviewxCriteria(int reviewXcriteriaId);
}
