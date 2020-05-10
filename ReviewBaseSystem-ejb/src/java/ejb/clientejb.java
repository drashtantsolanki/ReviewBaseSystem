/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Advertise;
import entity.Categoryratingcriteria;
import entity.Product;
import entity.Reviews;
import entity.Reviewxcriteria;
import entity.Product;
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
    public void addUser(String name,String email,String phno,String interest,String gender,Date bdate,String city,String pass) {
        Users obj=new Users();
        obj.setName(name);
        obj.setEmail(email);
        obj.setPhoneNumber(phno);
        obj.setInterest(interest);
        obj.setGender(gender);
        obj.setBirthdate(bdate);
        obj.setCity(city);
        String epass=getEncryptedPassword(pass);
        obj.setPassword(epass);
        em.persist(obj);
    }

    @Override
    public void updateUser(int uid,String name,String email,String phno,String interest,String gender,Date bdate,String city) {
        Users u = em.find(Users.class, uid);
        u.setName(name);
        u.setEmail(email);
        u.setPhoneNumber(phno);
        u.setInterest(interest);
        u.setGender(gender);
        u.setBirthdate(bdate);
        u.setCity(city);
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
        return (Advertise) em.createNamedQuery("Advertise.findByAdvertiseId").getSingleResult();
    }

    @Override
    public Advertise getAdvertiseByProductId(int productId) {
        return em.find(Advertise.class, productId);
    }

    @Override
    public Collection<Advertise> getAdvertiseByDate(Date date) {
        Collection<Advertise> lstAd=em.createNamedQuery("Advertise.findByDate").setParameter("tdate", date).getResultList();
        return lstAd;
    }

    @Override
    public void addAdvertise(Date startDate,Date endDate,int productId) {
        Advertise ad=new Advertise();
        Product p=em.find(Product.class, productId);
        Collection<Advertise> lstad=p.getAdvertiseCollection();
        
        ad.setStartDate(startDate);
        ad.setEndDate(endDate);
        ad.setProductId(p);
        
        lstad.add(ad);
        p.setAdvertiseCollection(lstad);
        em.merge(p);
        em.persist(ad); 
    }

    @Override
    public void updateAdvertise(int advertiseId,Date startDate,Date endDate,int productId) {
        
        Advertise ad=em.find(Advertise.class, advertiseId);
        
        Product p=em.find(Product.class, productId);
        Collection<Advertise> lstad=p.getAdvertiseCollection();
        
        ad.setStartDate(startDate);
        ad.setEndDate(endDate);
        ad.setProductId(p);
        
        lstad.add(ad);
        p.setAdvertiseCollection(lstad);
        em.merge(p);
        em.merge(ad); 
    }

    @Override
    public void removeAdvertise(int advertiseId) {
        Advertise objAddvertise=em.find(Advertise.class,advertiseId);
        em.remove(objAddvertise);
    }

    public void persist(Object object) {
        em.persist(object);
    }

    // <editor-fold defaultstate="collapsed" desc="Reviews">
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
    public void addReview(int productId, Date date, int userId) {
        Product product = (Product) em.find(Product.class, productId);
        Users users = (Users) em.find(Users.class, userId);

        Collection<Reviews> reviewses = product.getReviewsCollection();
        Collection<Reviews> reviewses1 = users.getReviewsCollection();

        Reviews reviews = new Reviews();
        reviews.setProductId(product);
        reviews.setDate(date);
        reviews.setUserId(users);

        reviewses.add(reviews);
        reviewses1.add(reviews);
        product.setReviewsCollection(reviewses);
        users.setReviewsCollection(reviewses1);

        em.persist(reviews);
        em.merge(product);
        em.merge(users);
    }

    @Override
    public void updateReview(int reviewId, int productId, Date date, int userId) {
        Reviews reviews = (Reviews) em.find(Reviews.class, reviewId);
        Product product = (Product) em.find(Product.class, productId);
        Users users = (Users) em.find(Users.class, userId);

        Collection<Reviews> reviewses = product.getReviewsCollection();
        Collection<Reviews> reviewses1 = users.getReviewsCollection();

        if (reviewses.contains(reviews)) {
            reviewses.remove(reviews);
        }

        if (reviewses1.contains(reviews)) {
            reviewses1.remove(reviews);
        }

        reviews.setProductId(product);
        reviews.setDate(date);
        reviews.setUserId(users);

        reviewses.add(reviews);
        reviewses1.add(reviews);

        em.merge(product);
        em.merge(users);
    }

    @Override
    public void removeReview(int reviewId, int productId, int userId) {
        Reviews reviews = (Reviews) em.find(Reviews.class, reviewId);
        Product product = (Product) em.find(Product.class, productId);
        Users users = (Users) em.find(Users.class, userId);

        Collection<Reviews> reviewses = product.getReviewsCollection();
        Collection<Reviews> reviewses1 = users.getReviewsCollection();

        if (reviewses.contains(reviews)) {
            reviewses.remove(reviews);
            product.setReviewsCollection(reviewses);
        }

        if (reviewses1.contains(reviews)) {
            reviewses1.remove(reviews);
            users.setReviewsCollection(reviewses1);
            em.remove(reviews);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ReviewxCriteria">
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
    public void addReviewxCriteria(int rate, String description, int categoryRatingCriteriaId, int reviewId) {
        Categoryratingcriteria categoryratingcriteria = (Categoryratingcriteria) em.find(Categoryratingcriteria.class, categoryRatingCriteriaId);
        Reviews reviews = (Reviews) em.find(Reviews.class, reviewId);

        Collection<Reviewxcriteria> reviewxcriterias = categoryratingcriteria.getReviewxcriteriaCollection();
        Collection<Reviewxcriteria> reviewxcriterias1 = reviews.getReviewxcriteriaCollection();

        Reviewxcriteria reviewxcriteria = new Reviewxcriteria();
        reviewxcriteria.setRate(rate);
        reviewxcriteria.setDescription(description);
        reviewxcriteria.setCategoryRatingCriteriaId(categoryratingcriteria);
        reviewxcriteria.setReviewId(reviews);

        reviewxcriterias.add(reviewxcriteria);
        reviewxcriterias1.add(reviewxcriteria);
        categoryratingcriteria.setReviewxcriteriaCollection(reviewxcriterias);
        reviews.setReviewxcriteriaCollection(reviewxcriterias1);

        em.persist(reviewxcriteria);
        em.merge(categoryratingcriteria);
        em.merge(reviews);
    }

    @Override
    public void updateReviewxCriteria(int reviewXcriteriaId, int rate, String description, int categoryRatingCriteriaId, int reviewId) {
        Reviewxcriteria reviewxcriteria = (Reviewxcriteria) em.find(Reviewxcriteria.class, reviewXcriteriaId);
        Categoryratingcriteria categoryratingcriteria = (Categoryratingcriteria) em.find(Categoryratingcriteria.class, categoryRatingCriteriaId);
        Reviews reviews = (Reviews) em.find(Reviews.class, reviewId);

        Collection<Reviewxcriteria> reviewxcriterias = categoryratingcriteria.getReviewxcriteriaCollection();
        Collection<Reviewxcriteria> reviewxcriterias1 = reviews.getReviewxcriteriaCollection();

        if (reviewxcriterias.contains(reviewxcriteria)) {
            reviewxcriterias.remove(reviewxcriteria);
        }

        if (reviewxcriterias1.contains(reviewxcriteria)) {
            reviewxcriterias1.remove(reviewxcriteria);
        }

        reviewxcriteria.setRate(rate);
        reviewxcriteria.setDescription(description);
        reviewxcriteria.setCategoryRatingCriteriaId(categoryratingcriteria);
        reviewxcriteria.setReviewId(reviews);

        reviewxcriterias.add(reviewxcriteria);
        reviewxcriterias1.add(reviewxcriteria);
        categoryratingcriteria.setReviewxcriteriaCollection(reviewxcriterias);
        reviews.setReviewxcriteriaCollection(reviewxcriterias1);

        em.merge(categoryratingcriteria);
        em.merge(reviews);
    }

    @Override
    public void removeReviewxCriteria(int reviewXcriteriaId, int categoryRatingCriteriaId, int reviewId) {
        Reviewxcriteria reviewxcriteria = (Reviewxcriteria) em.find(Reviewxcriteria.class, reviewXcriteriaId);
        Categoryratingcriteria categoryratingcriteria = (Categoryratingcriteria) em.find(Categoryratingcriteria.class, categoryRatingCriteriaId);
        Reviews reviews = (Reviews) em.find(Reviews.class, reviewId);

        Collection<Reviewxcriteria> reviewxcriterias = categoryratingcriteria.getReviewxcriteriaCollection();
        Collection<Reviewxcriteria> reviewxcriterias1 = reviews.getReviewxcriteriaCollection();

        if (reviewxcriterias.contains(reviewxcriteria)) {
            reviewxcriterias.remove(reviewxcriteria);
            categoryratingcriteria.setReviewxcriteriaCollection(reviewxcriterias);
        }

        if (reviewxcriterias1.contains(reviewxcriteria)) {
            reviewxcriterias1.remove(reviewxcriteria);
            reviews.setReviewxcriteriaCollection(reviewxcriterias1);
            em.remove(reviewxcriteria);
        }
    }
    // </editor-fold>
    @Override
    public Collection<Advertise> getAdvertiseByDate(String tdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
