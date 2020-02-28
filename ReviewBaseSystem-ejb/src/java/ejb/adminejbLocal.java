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
import java.util.Collection;
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

    void AddCategory(String categoryName);

    void updateCategory(int categoryId, String categoryName);

    void removeCategory(int categoryId);

    //CategoryRatingCriteria
    Collection<Categoryratingcriteria> getAllCategoryRatingCriteria();

    Categoryratingcriteria getCategoryRatingCriteriaById(int categoryratingcriteriaId);

    Collection<Categoryratingcriteria> getCategoryRatingCriteriaByCategoryId(int categoryId);

    Categoryratingcriteria getCategoryRatingCriteriaByRatingCriteriaId(int ratingCriteriaId);

    void addCategoryRatingCriteria(int categoryId, int ratingCriteriaId);

    void updateCategoryRatingCriteria(int categoryRatingCriteriaId, int categoryId, int ratingCriteriaId);

    void removeCategoryRatingCriteria(int categoryRatingCriteriaId, int categoryId, int ratingCriteriaId);

    //Product
    Collection<Product> getAllProduct();

    Product getProductById(int productId);

    Collection<Product> getProductByProductName(String productName);

    Collection<Product> getProductByCategoryId(int categoryId);

    void addProductToCategory(int categoryId, String productName, String productImage, String referenceLink, int authorId, int genreId, int publisherId, int companyId);

    void updateProductToCategory(int productId, int categoryId, String productName, String productImage, String referenceLink, int authorId, int genreId, int publisherId, int companyId);

    void removeProductFromCategory(int productId, int categoryId);

    //RatingCriteria
    Collection<Ratingcriterias> getAllRatingCriteria();

    Ratingcriterias getRatingCriteriaById(int ratingCriteriaId);

    Collection<Ratingcriterias> getRatingCriteriaByCriteriaName(String criteriaName);

    void addRatingCriteria(String criteriaName);

    void updateRatingCriteria(int ratingCriteriaId, String criteriaName);

    void removeRatingCriteria(int ratingCriteriaId);

    //RolePermission 
    Collection<Rolepermission> getAllRolePermission();

    Collection<Rolepermission> getAllRolePermissionByname();

    Collection<Rolepermission> getAllRolePermissionWithName();

    Rolepermission getRolePermissionById(int rolePermissionId);

    Rolepermission getRolePermissionByRoleId(int roleId);

    Rolepermission getRolePermissionByPermissionId(int permissionId);

    void addRolePermission(Rolepermission rolePermission);

    void updateRolePermission(Rolepermission rolePermission);

    void removeRolePermission(int rolePermissionId);

    //UserRole
    Collection<Userrole> getAllUserRole();

    Userrole getUserRoleById(int userRoleId);

    Userrole getUserRoleByUserId(int userId);

    Userrole getUserRoleByRoleId(int roleId);

    void addUserRole(Userrole userRole);

    void updateUserRole(int userRoleId);

    void removeUserRole(int userRoleId);

    //Permission
    Collection<Permission> getAllPermissions();

    Permission getPermissionById(int permissionId);

    Permission getPermissionByName(String permissionName);

    void addPermission(Permission permission);

    void updatePermission(int permissionId, Permission permission);

    void removePermission(int permissionId);

    //user    
    Collection<Users> getAllUsers();

    Users getUserById(int userId);

    Users getUserByName(String name);

    Users getUserByEmail(String email);

    Users getUserByCity(String city);

    void addUser(Users objUser);

    void updateUser(int userId);

    void removeUser(int userId);

    //Role
    Role getRoleById(int roleId);

    Role getRoleByName(String roleName);

    void addRole(Role role);

    void updateRole(int roleId, Role role);

    void removeRole(int roleId);

}
