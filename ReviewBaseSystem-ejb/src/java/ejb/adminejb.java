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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hi
 */
@Stateless
public class adminejb implements adminejbLocal {

    @PersistenceContext(unitName = "MyReview")
    EntityManager em;

    @Override
    public Collection<Category> getAllCategory() {
        return em.createNamedQuery("Category.findAll").getResultList();
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return (Category) em.find(Category.class, categoryId);
    }

    @Override
    public Collection<Category> getCategoryByName(String categoryName) {
        Collection<Category> categorys = em.createNamedQuery("Category.findByCategoryName")
                .setParameter("categoryName", categoryName)
                .getResultList();

        return categorys;
    }

    @Override
    public void AddCategory(Category category) {
        em.persist(category);
    }

    @Override
    public void updateCategory(int categoryId, Category category) {
        Category objCategory = (Category) em.find(Category.class, categoryId);
        objCategory.setCategoryName(category.getCategoryName());
        em.merge(objCategory);
    }

    @Override
    public void removeCategory(int categoryId) {
        Category category = (Category) em.find(Category.class, categoryId);
        em.remove(category);
    }

    @Override
    public Collection<Categoryratingcriteria> getAllCategoryRatingCriteria() {
        return em.createNamedQuery("Categoryratingcriteria.findAll").getResultList();
    }

    @Override
    public Categoryratingcriteria getCategoryRatingCriteriaById(int categoryratingcriteriaId) {
        return (Categoryratingcriteria) em.find(Categoryratingcriteria.class, categoryratingcriteriaId);
    }

    //test baki
    @Override
    public Collection<Categoryratingcriteria> getCategoryRatingCriteriaByCategoryId(int categoryId) {
        Collection<Categoryratingcriteria> categoryratingcriterias = em.createNamedQuery("Categoryratingcriteria.getCategoryRatingCriteriaByCategoryId")
                .setParameter("categoryId", categoryId)
                .getResultList();

        return categoryratingcriterias;
    }

    @Override
    public Categoryratingcriteria getCategoryRatingCriteriaByRatingCriteriaId(int ratingCriteriaId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCategoryRatingCriteria(Categoryratingcriteria categoryratingcriteria) {
        em.persist(categoryratingcriteria);
    }

    @Override
    public void updateCategoryRatingCriteria(int categoryRatingCriteriaId, Categoryratingcriteria categoryratingcriteria) {
        Categoryratingcriteria objCategoryratingcriteria = (Categoryratingcriteria) em.find(Categoryratingcriteria.class, categoryRatingCriteriaId);
        objCategoryratingcriteria.setCategoryId(categoryratingcriteria.getCategoryId());
        objCategoryratingcriteria.setRatingCriteriaId(categoryratingcriteria.getRatingCriteriaId());
        em.merge(objCategoryratingcriteria);
    }

    @Override
    public void removeCategoryRatingCriteria(int categoryRatingCriteriaId) {
        Categoryratingcriteria categoryratingcriteria = (Categoryratingcriteria) em.find(Categoryratingcriteria.class, categoryRatingCriteriaId);
        em.remove(categoryratingcriteria);
    }

    @Override
    public Collection<Product> getAllProduct() {
        return em.createNamedQuery("Product.findAll").getResultList();
    }

    @Override
    public Product getProductById(int productId) {
        return (Product) em.find(Product.class, productId);
    }

    @Override
    public Collection<Product> getProductByProductName(String productName) {
        Collection<Product> products = em.createNamedQuery("Product.findByProductName")
                .setParameter("productName", productName)
                .getResultList();

        return products;
    }

    //test baki
    @Override
    public Collection<Product> getProductByCategoryId(int categoryId) {
        Collection<Product> products = em.createNamedQuery("Product.findByCategoryId")
                .setParameter("categoryId", categoryId)
                .getResultList();

        return products;
    }

    @Override
    public void addProductToCategory(Product product) {
        em.persist(product);
    }

    @Override
    public void updateProductToCategory(int productId, Product product) {
        Product objProduct = (Product) em.find(Product.class, productId);
        objProduct.setCategoryId(product.getCategoryId());
        objProduct.setProductName(product.getProductName());
        objProduct.setProductImage(product.getProductImage());
        objProduct.setReferenceLink(product.getReferenceLink());
        objProduct.setAuthorId(product.getAuthorId());
        objProduct.setGenreId(product.getGenreId());
        objProduct.setPublisherId(product.getPublisherId());
        objProduct.setCompanyId(product.getCompanyId());
        em.merge(objProduct);
    }

    @Override
    public void removeProductFromCategory(int productId) {
        Product product = (Product) em.find(Product.class, productId);
        em.remove(product);
    }

    @Override
    public Collection<Ratingcriterias> getAllRatingCriteria() {
        return em.createNamedQuery("Ratingcriterias.findAll").getResultList();
    }
    
    //---------------------------------------------------------------------------------------------------------------------

    @Override
    public Ratingcriterias getRatingCriteriaById(int ratingCriteriaId) {
        return (Ratingcriterias) em.find(Ratingcriterias.class, ratingCriteriaId);
    }

    @Override
    public Collection<Ratingcriterias> getRatingCriteriaByCriteriaName(String criteriaName) {
        Collection<Ratingcriterias> ratingcriteriases = em.createNamedQuery("Ratingcriterias.findByCriteriaName")
                .setParameter("criteriaName", criteriaName)
                .getResultList();

        return ratingcriteriases;
    }

    @Override
    public void addRatingCriteria(Ratingcriterias ratingcriterias) {
        em.persist(ratingcriterias);
    }

    @Override
    public void updateRatingCriteria(int ratingCriteriaId, Ratingcriterias ratingCriteria) {
        Ratingcriterias objRatingcriterias = (Ratingcriterias) em.find(Ratingcriterias.class, ratingCriteriaId);
        objRatingcriterias.setCriteriaName(ratingCriteria.getCriteriaName());
        em.merge(objRatingcriterias);
    }

    @Override
    public void removeRatingCriteria(int ratingCriteriaId) {
        Ratingcriterias ratingcriterias = (Ratingcriterias) em.find(Ratingcriterias.class, ratingCriteriaId);
        em.remove(ratingcriterias);
    }

    @Override
    public Collection<Reviews> getAllReviews() {
        return em.createNamedQuery("Reviews.findAll").getResultList();
    }

    @Override
    public Reviews getReviewById(int reviewId) {
        return (Reviews) em.find(Reviews.class, reviewId);
    }

    @Override
    public Collection<Reviews> getReviewByProductID(int productId) {
        Collection<Reviews> reviewses = em.createNamedQuery("Reviews.findByProductId")
                .setParameter("productId", productId)
                .getResultList();

        return reviewses;
    }

    @Override
    public Collection<Reviews> getReviewByDate(Date date) {
        Collection<Reviews> reviewses = em.createNamedQuery("Reviews.findByDate")
                .setParameter("date", date)
                .getResultList();

        return reviewses;
    }

    @Override
    public Collection<Reviews> getReviewsByUserId(int userId) {
        Collection<Reviews> reviewses = em.createNamedQuery("Reviews.findByUserId")
                .setParameter("userId", userId)
                .getResultList();

        return reviewses;
    }

    @Override
    public void addReview(Reviews reviews) {
        em.persist(reviews);
    }

    @Override
    public void updateReview(int reviewId, Reviews reviews) {
        Reviews objReviews = (Reviews) em.find(Reviews.class, reviewId);
        objReviews.setProductId(reviews.getProductId());
        objReviews.setDate(reviews.getDate());
        objReviews.setUserId(reviews.getUserId());
        em.merge(objReviews);
    }

    @Override
    public void removeReview(int reviewId) {
        Reviews reviews = (Reviews) em.find(Reviews.class, reviewId);
        em.remove(reviews);
    }

    @Override
    public Collection<Reviewxcriteria> getAllReviewxCriteria() {
        return em.createNamedQuery("Reviewxcriteria.findAll").getResultList();
    }

    @Override
    public Reviewxcriteria getReviewxCriteriaById(int reviewXcriteriaId) {
        return (Reviewxcriteria) em.find(Reviewxcriteria.class, reviewXcriteriaId);
    }

    @Override
    public Collection<Reviewxcriteria> getReviewxCriteriaByRate(float rate) {
        Collection<Reviewxcriteria> reviewxcriterias = em.createNamedQuery("Reviewxcriteria.findByRate")
                .setParameter("rate", rate)
                .getResultList();

        return reviewxcriterias;
    }

    @Override
    public Reviewxcriteria getReviewxCriteriaByCategoryRatingCriteriaId(int categoryRatingCriteriaId) {
        return (Reviewxcriteria) em.find(Reviewxcriteria.class, categoryRatingCriteriaId);
    }

    @Override
    public Reviewxcriteria getReviewxCriteriaByReviewId(int reviewId) {
        return (Reviewxcriteria) em.find(Reviewxcriteria.class, reviewId);
    }

    @Override
    public void addReviewxCriteria(Reviewxcriteria reviewxcriteria) {
        em.persist(reviewxcriteria);
    }

    @Override
    public void updateReviewxCriteria(int reviewXcriteriaId, Reviewxcriteria reviewxcriteria) {
        Reviewxcriteria objReviewxcriteria = (Reviewxcriteria) em.find(Reviewxcriteria.class, reviewXcriteriaId);
        objReviewxcriteria.setRate(reviewxcriteria.getRate());
        objReviewxcriteria.setDescription(reviewxcriteria.getDescription());
        objReviewxcriteria.setCategoryRatingCriteriaId(reviewxcriteria.getCategoryRatingCriteriaId());
        objReviewxcriteria.setReviewId(reviewxcriteria.getReviewId());
        em.merge(objReviewxcriteria);
    }

    @Override
    public void removeReviewxCriteria(int reviewXcriteriaId) {
        Reviewxcriteria reviewxcriteria = (Reviewxcriteria) em.find(Reviewxcriteria.class, reviewXcriteriaId);
        em.remove(reviewxcriteria);
    }
}
