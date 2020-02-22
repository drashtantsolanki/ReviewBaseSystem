/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Permission;
import entity.Role;
import entity.Rolepermission;
import entity.Userrole;
import entity.Users;
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
    private EntityManager em;

    //@PersistenceContext(unitName = "MyReview")
    //EntityManager em;
    
    
    //------------------------------------Role------------------------------------------
    
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

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Role getRoleById(int roleId) {
        Role role=em.find(Role.class, roleId);
        return role;
    }

    @Override
    public Role getRoleByName(String roleName) {
        Role role=(Role) em.createNamedQuery("Role.findByRoleName").setParameter("roleName",roleName);
        return role;
    }

    @Override
    public void addRole(Role role) {
        Role objrole=new Role();
        objrole.setRoleName(role.getRoleName());
        em.persist(objrole);
    }

    @Override
    public void updateRole(int roleId,Role role) {
        Role objrole=em.find(Role.class, roleId);
        objrole.setRoleName(role.getRoleName());
        em.merge(objrole);
        
    }

    @Override
    public void removeRole(int roleId) {
        Role objrole=em.find(Role.class, roleId);
        em.remove(objrole);
    }
    

    //=======================permission=====================================
    
    @Override
    public Collection<Permission> getAllPermissions() {
        return em.createNamedQuery("Permission.findAll").getResultList();
    }

    @Override
    public Permission getPermissionById(int permissionId) {
        Permission objPermission=em.find(Permission.class, permissionId);
        return objPermission;
    }

    @Override
    public Permission getPermissionByName(String permissionName) {
        Permission objPermission=(Permission) em.createNamedQuery("Permission.findByPermissionName").setParameter("permissionName", permissionName).getSingleResult();
        return objPermission;
    }

    @Override
    public void addPermission(Permission permission) {
        Permission objPermission=new Permission();
        objPermission.setPermissionName(permission.getPermissionName());
        em.persist(objPermission);
    }

    @Override
    public void updatePermission(int permissionId,Permission permission) {
        
        Permission objPermission=em.find(Permission.class,permission.getPermissionId());
        //objPermission.setPermissionName(permission.getPermissionName());
        em.merge(objPermission);
    }

    @Override
    public void removePermission(int permissionId) {
        Permission objpermission=em.find(Permission.class,permissionId);
        em.remove(objpermission);
    }

    
    
    
    
    
    //=================================Role Permission===========================================
    
    @Override
    public Collection<Rolepermission> getAllRolePermission() {
        return em.createNamedQuery("Rolepermission.findAll").getResultList();
    }
    
    @Override
    public Collection<Rolepermission> getAllRolePermissionByname(){
        Collection<Rolepermission> lst =em.createNamedQuery("Rolepermission.findAllByName").getResultList();
        return lst;
    }
    
    
    @Override
    public Rolepermission getRolePermissionById(int rolePermissionId) {
        Rolepermission rp=em.find(Rolepermission.class,rolePermissionId);
        return rp;
    }

    @Override
    public Rolepermission getRolePermissionByRoleId(int roleId) {
        Rolepermission rp=em.find(Rolepermission.class,roleId);
        return rp;
    }

    @Override
    public Rolepermission getRolePermissionByPermissionId(int permissionId) {
        Rolepermission rp=em.find(Rolepermission.class,permissionId);
        return rp;
    }

    @Override
    public void addRolePermission(Rolepermission rolePermission) 
    {
        em.persist(rolePermission);
    }

    @Override
    public void updateRolePermission(Rolepermission rolePermission) {
        Rolepermission rp=em.find(Rolepermission.class,rolePermission.getRolePermissionId());
        em.merge(rolePermission);
    }

    @Override
    public void removeRolePermission(int rolePermissionId) {
        Rolepermission rp=em.find(Rolepermission.class,rolePermissionId);
        em.remove(rp);
    }

    
    
    //============================user Role=============================
    
    
    
    @Override
    public Collection<Userrole> getAllUserRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Userrole getUserRoleById(int userRoleId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Userrole getUserRoleByUserId(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Userrole getUserRoleByRoleId(int roleId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUserRole(Userrole userRole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUserRole(int userRoleId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUserRole(int userRoleId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    @Override
    public Collection<Users> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users getUserById(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users getUserByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users getUserByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users getUserByCity(String city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUser(Users objUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUser(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Rolepermission> getAllRolePermissionWithName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void persist(Object object) {
        em.persist(object);
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
