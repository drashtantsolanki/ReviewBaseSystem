/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Category;
import entity.Categoryratingcriteria;
import entity.Product;
import entity.Ratingcriterias;
import entity.Reviews;
import entity.Reviewxcriteria;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author hi
 */
@Local
public interface adminejbLocal {

    //Category
    Collection<Category> getAllCategory();

    Category getCategoryById(int categoryId);

    Collection<Category> getCategoryByName(String categoryName);

    void AddCategory(Category category);

    void updateCategory(int categoryId, Category category);

    void removeCategory(int categoryId);

    //CategoryRatingCriteria
    Collection<Categoryratingcriteria> getAllCategoryRatingCriteria();

    Categoryratingcriteria getCategoryRatingCriteriaById(int categoryratingcriteriaId);

    Collection<Categoryratingcriteria> getCategoryRatingCriteriaByCategoryId(int categoryId);

    Categoryratingcriteria getCategoryRatingCriteriaByRatingCriteriaId(int ratingCriteriaId);

    void addCategoryRatingCriteria(Categoryratingcriteria categoryratingcriteria);

    void updateCategoryRatingCriteria(int categoryRatingCriteriaId, Categoryratingcriteria categoryratingcriteria);

    void removeCategoryRatingCriteria(int categoryRatingCriteriaId);

    //Product
    Collection<Product> getAllProduct();

    Product getProductById(int productId);

    Collection<Product> getProductByProductName(String productName);

    Collection<Product> getProductByCategoryId(int categoryId);

    void addProductToCategory(Product product);

    void updateProductToCategory(int productId, Product product);

    void removeProductFromCategory(int productId);

    //RatingCriteria
    Collection<Ratingcriterias> getAllRatingCriteria();

    Ratingcriterias getRatingCriteriaById(int ratingCriteriaId);

    Collection<Ratingcriterias> getRatingCriteriaByCriteriaName(String criteriaName);

    void addRatingCriteria(Ratingcriterias ratingcriterias);

    void updateRatingCriteria(int ratingCriteriaId, Ratingcriterias ratingcriterias);

    void removeRatingCriteria(int ratingCriteriaId);

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
