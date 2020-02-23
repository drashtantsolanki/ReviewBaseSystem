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

    //=======================Role=====================================
    @Override
    public Role getRoleById(int roleId) {
        Role role = em.find(Role.class, roleId);
        return role;
    }

    @Override
    public Role getRoleByName(String roleName) {
        Role role = (Role) em.createNamedQuery("Role.findByRoleName").setParameter("roleName", roleName);
        return role;
    }

    @Override
    public void addRole(Role role) {
        Role objrole = new Role();
        objrole.setRoleName(role.getRoleName());
        em.persist(objrole);
    }

    @Override
    public void updateRole(int roleId, Role role) {
        Role objrole = em.find(Role.class, roleId);
        objrole.setRoleName(role.getRoleName());
        em.merge(objrole);

    }

    @Override
    public void removeRole(int roleId) {
        Role objrole = em.find(Role.class, roleId);
        em.remove(objrole);
    }

    //=======================permission=====================================
    @Override
    public Collection<Permission> getAllPermissions() {
        return em.createNamedQuery("Permission.findAll").getResultList();
    }

    @Override
    public Permission getPermissionById(int permissionId) {
        Permission objPermission = em.find(Permission.class, permissionId);
        return objPermission;
    }

    @Override
    public Permission getPermissionByName(String permissionName) {
        Permission objPermission = (Permission) em.createNamedQuery("Permission.findByPermissionName").setParameter("permissionName", permissionName).getSingleResult();
        return objPermission;
    }

    @Override
    public void addPermission(Permission permission) {
        Permission objPermission = new Permission();
        objPermission.setPermissionName(permission.getPermissionName());
        em.persist(objPermission);
    }

    @Override
    public void updatePermission(int permissionId, Permission permission) {

        Permission objPermission = em.find(Permission.class, permission.getPermissionId());
        //objPermission.setPermissionName(permission.getPermissionName());
        em.merge(objPermission);
    }

    @Override
    public void removePermission(int permissionId) {
        Permission objpermission = em.find(Permission.class, permissionId);
        em.remove(objpermission);
    }

    //=================================Role Permission===========================================
    @Override
    public Collection<Rolepermission> getAllRolePermission() {
        return em.createNamedQuery("Rolepermission.findAll").getResultList();
    }

    @Override
    public Collection<Rolepermission> getAllRolePermissionByname() {
        Collection<Rolepermission> lst = em.createNamedQuery("Rolepermission.findAllByName").getResultList();
        return lst;
    }

    @Override
    public Rolepermission getRolePermissionById(int rolePermissionId) {
        Rolepermission rp = em.find(Rolepermission.class, rolePermissionId);
        return rp;
    }

    @Override
    public Rolepermission getRolePermissionByRoleId(int roleId) {
        Rolepermission rp = em.find(Rolepermission.class, roleId);
        return rp;
    }

    @Override
    public Rolepermission getRolePermissionByPermissionId(int permissionId) {
        Rolepermission rp = em.find(Rolepermission.class, permissionId);
        return rp;
    }

    @Override
    public void addRolePermission(Rolepermission rolePermission) {
        em.persist(rolePermission);
    }

    @Override
    public void updateRolePermission(Rolepermission rolePermission) {
        Rolepermission rp = em.find(Rolepermission.class, rolePermission.getRolePermissionId());
        em.merge(rolePermission);
    }

    @Override
    public void removeRolePermission(int rolePermissionId) {
        Rolepermission rp = em.find(Rolepermission.class, rolePermissionId);
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

    //============================Category=============================
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

    //============================CategoryRatingCriteria=============================
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

    //============================Product=============================
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

    //============================RatingCriteria=============================
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
}
