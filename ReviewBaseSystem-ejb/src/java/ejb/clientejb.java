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
import java.security.MessageDigest;
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
public class clientejb implements clientejbLocal {

    @PersistenceContext(unitName = "MyReview")
    private EntityManager em;

    @Override
    public Collection<Users> getAllUsers() {
        return em.createNamedQuery("Users.findAll").getResultList();
    }

    @Override
    public Users getUserById(int userId) {
        Users u = em.find(Users.class, userId);
        return u;
    }

    @Override
    public Users getUserByName(String name) {
        return (Users) em.createNamedQuery("Users.findByName").setParameter("name", name).getSingleResult();
    }

    @Override
    public Users getUserByEmail(String email) {
        return (Users) em.createNamedQuery("Users.findByEmail").setParameter("email", email).getSingleResult();
    }

    @Override
    public Collection<Users> getUserByCity(String city) {
        return em.createNamedQuery("Users.findByCity").setParameter("city", city).getResultList();
    }

    @Override
    public void addUser(Users objUser) {
        Users obj = new Users();
        obj.setName(objUser.getName());
        obj.setEmail(objUser.getEmail());
        obj.setPhoneNumber(objUser.getPhoneNumber());
        obj.setInterest(objUser.getInterest());
        obj.setGender(objUser.getGender());
        obj.setBirthdate(objUser.getBirthdate());
        obj.setCity(objUser.getCity());
        obj.setPassword(objUser.getPassword());
        em.persist(obj);
    }

    @Override
    public void updateUser(Users objUser) {
        Users u = em.find(Users.class, objUser.getUserId());
        u.setName(objUser.getName());
        u.setEmail(objUser.getEmail());
        u.setPhoneNumber(objUser.getPhoneNumber());
        u.setInterest(objUser.getInterest());
        u.setGender(objUser.getGender());
        u.setBirthdate(objUser.getBirthdate());
        u.setCity(objUser.getCity());
        u.setPassword(objUser.getPassword());
        em.merge(u);

    }

    @Override
    public void removeUser(int userId) {
        Users u = em.find(Users.class, userId);
        em.remove(u);
    }

    @Override
    public String getEncryptedPassword(String Password) {
        String encrypedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(Password.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            encrypedPassword = sb.toString();
        } catch (Exception e) {
        }
        return encrypedPassword;
    }

    //===============================Advertise==================================
    @Override
    public Collection<Advertise> getAllAdvertise() {
        return em.createNamedQuery("Advertise.findAll").getResultList();
    }

    @Override
    public Advertise getAdvertiseById(int advertiseId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Advertise getAdvertiseByProductId(int productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Advertise getAdvertiseByDate(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addAdvertise(Advertise advertise) {
        em.persist(advertise);
    }

    @Override
    public void updateAdvertise(int advertiseId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAdvertise(int advertiseId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void persist(Object object) {
        em.persist(object);
    }

    //============================Reviews=============================
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

    //============================ReviewxCriteria=============================
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
