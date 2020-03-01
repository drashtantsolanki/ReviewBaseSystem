/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Author;
import entity.Permission;
import entity.Role;
import entity.Rolepermission;
import entity.Userrole;
import entity.Users;
import entity.Category;
import entity.Categoryratingcriteria;
import entity.Company;
import entity.Genre;
import entity.Product;
import entity.Publisher;
import entity.Ratingcriterias;
import java.util.Collection;
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

    // <editor-fold defaultstate="collapsed" desc="Category">
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
    public void AddCategory(String categoryName) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        em.persist(category);
    }

    @Override
    public void updateCategory(int categoryId, String categoryName) {
        Category category = (Category) em.find(Category.class, categoryId);
        category.setCategoryName(categoryName);
        em.merge(category);
    }

    @Override
    public void removeCategory(int categoryId) {
        Category category = (Category) em.find(Category.class, categoryId);
        em.remove(category);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CategoryRatingCriteria">
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
    public void addCategoryRatingCriteria(int categoryId, int ratingCriteriaId) {
        Category category = (Category) em.find(Category.class, categoryId);
        Ratingcriterias ratingcriterias = (Ratingcriterias) em.find(Ratingcriterias.class, ratingCriteriaId);

        Collection<Categoryratingcriteria> categoryratingcriterias = category.getCategoryratingcriteriaCollection();
        Collection<Categoryratingcriteria> categoryratingcriterias1 = ratingcriterias.getCategoryratingcriteriaCollection();

        Categoryratingcriteria c = new Categoryratingcriteria();
        c.setCategoryId(category);
        c.setRatingCriteriaId(ratingcriterias);

        categoryratingcriterias.add(c);
        categoryratingcriterias1.add(c);
        category.setCategoryratingcriteriaCollection(categoryratingcriterias);
        ratingcriterias.setCategoryratingcriteriaCollection(categoryratingcriterias1);

        em.persist(c);
        em.merge(category);
        em.merge(ratingcriterias);

    }

    @Override
    public void updateCategoryRatingCriteria(int categoryRatingCriteriaId, int categoryId, int ratingCriteriaId) {
        Categoryratingcriteria categoryratingcriteria = (Categoryratingcriteria) em.find(Categoryratingcriteria.class, categoryRatingCriteriaId);
        Category category = (Category) em.find(Category.class, categoryId);
        Ratingcriterias ratingcriterias = (Ratingcriterias) em.find(Ratingcriterias.class, ratingCriteriaId);

        Collection<Categoryratingcriteria> categoryratingcriterias = category.getCategoryratingcriteriaCollection();
        Collection<Categoryratingcriteria> categoryratingcriterias1 = ratingcriterias.getCategoryratingcriteriaCollection();

        if (categoryratingcriterias.contains(categoryratingcriteria)) {
            categoryratingcriterias.remove(categoryratingcriteria);
        }

        if (categoryratingcriterias1.contains(categoryratingcriteria)) {
            categoryratingcriterias1.remove(categoryratingcriteria);
        }

        categoryratingcriteria.setCategoryId(category);
        categoryratingcriteria.setRatingCriteriaId(ratingcriterias);

        categoryratingcriterias.add(categoryratingcriteria);
        categoryratingcriterias1.add(categoryratingcriteria);
        category.setCategoryratingcriteriaCollection(categoryratingcriterias);
        ratingcriterias.setCategoryratingcriteriaCollection(categoryratingcriterias1);

        em.merge(category);
        em.merge(ratingcriterias);
    }

    @Override
    public void removeCategoryRatingCriteria(int categoryRatingCriteriaId, int categoryId, int ratingCriteriaId) {
        Categoryratingcriteria categoryratingcriteria = (Categoryratingcriteria) em.find(Categoryratingcriteria.class, categoryRatingCriteriaId);
        Category category = (Category) em.find(Category.class, categoryId);
        Ratingcriterias ratingcriterias = (Ratingcriterias) em.find(Ratingcriterias.class, ratingCriteriaId);

        Collection<Categoryratingcriteria> categoryratingcriterias = category.getCategoryratingcriteriaCollection();
        Collection<Categoryratingcriteria> categoryratingcriterias1 = ratingcriterias.getCategoryratingcriteriaCollection();

        if (categoryratingcriterias.contains(categoryratingcriteria)) {
            categoryratingcriterias.remove(categoryratingcriteria);
            category.setCategoryratingcriteriaCollection(categoryratingcriterias);
        }

        if (categoryratingcriterias1.contains(categoryratingcriteria)) {
            categoryratingcriterias1.remove(categoryratingcriteria);
            ratingcriterias.setCategoryratingcriteriaCollection(categoryratingcriterias);
            em.remove(categoryratingcriteria);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Product">
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
    public void addProductToCategory(int categoryId, String productName, String productImage, String referenceLink, int authorId, int genreId, int publisherId, int companyId) {
        Category category = em.find(Category.class, categoryId);
        Collection<Product> products = category.getProductCollection();

        Product product = new Product();
        product.setCategoryId(category);
        product.setProductName(productName);
        product.setProductImage(productImage);
        product.setReferenceLink(referenceLink);

        if (authorId == 0) {
            product.setAuthorId(null);
        } else {
            Author author = em.find(Author.class, authorId);
            product.setAuthorId(author);
        }

        if (genreId == 0) {
            product.setGenreId(null);
        } else {
            Genre genre = em.find(Genre.class, genreId);
            product.setGenreId(genre);
        }

        if (publisherId == 0) {
            product.setPublisherId(null);
        } else {
            Publisher publisher = em.find(Publisher.class, publisherId);
            product.setPublisherId(publisher);
        }

        if (companyId == 0) {
            product.setCompanyId(null);
        } else {
            Company company = em.find(Company.class, companyId);
            product.setCompanyId(company);
        }

        products.add(product);
        category.setProductCollection(products);

        em.persist(product);
        em.merge(category);
    }

    @Override
    public void updateProductToCategory(int productId, int categoryId, String productName, String productImage, String referenceLink, int authorId, int genreId, int publisherId, int companyId) {
        Product product = em.find(Product.class, productId);
        Category category = em.find(Category.class, categoryId);
        Collection<Product> products = category.getProductCollection();

        if (products.contains(product)) {
            products.remove(product);
        }

        product.setCategoryId(category);
        product.setProductName(productName);
        product.setProductImage(productImage);
        product.setReferenceLink(referenceLink);

        if (authorId == 0) {
            product.setAuthorId(null);
        } else {
            Author author = em.find(Author.class, authorId);
            product.setAuthorId(author);
        }

        if (genreId == 0) {
            product.setGenreId(null);
        } else {
            Genre genre = em.find(Genre.class, genreId);
            product.setGenreId(genre);
        }

        if (publisherId == 0) {
            product.setPublisherId(null);
        } else {
            Publisher publisher = em.find(Publisher.class, publisherId);
            product.setPublisherId(publisher);
        }

        if (companyId == 0) {
            product.setCompanyId(null);
        } else {
            Company company = em.find(Company.class, companyId);
            product.setCompanyId(company);
        }

        products.add(product);
        category.setProductCollection(products);

        em.merge(category);
    }

    @Override
    public void removeProductFromCategory(int productId, int categoryId) {
        Product product = (Product) em.find(Product.class, productId);
        Category category = (Category) em.find(Category.class, categoryId);

        Collection<Product> products = category.getProductCollection();
        if (products.contains(product)) {
            products.remove(product);
            category.setProductCollection(products);
            em.remove(product);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="RatingCriteria">
    @Override
    public Collection<Ratingcriterias> getAllRatingCriteria() {
        return em.createNamedQuery("Ratingcriterias.findAll").getResultList();
    }

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
    public void addRatingCriteria(String criteriaName) {
        Ratingcriterias ratingcriterias = new Ratingcriterias();
        ratingcriterias.setCriteriaName(criteriaName);
        em.persist(ratingcriterias);
    }

    @Override
    public void updateRatingCriteria(int ratingCriteriaId, String criteriaName) {
        Ratingcriterias ratingcriterias = (Ratingcriterias) em.find(Ratingcriterias.class, ratingCriteriaId);
        ratingcriterias.setCriteriaName(criteriaName);
        em.merge(ratingcriterias);
    }

    @Override
    public void removeRatingCriteria(int ratingCriteriaId) {
        Ratingcriterias ratingcriterias = (Ratingcriterias) em.find(Ratingcriterias.class, ratingCriteriaId);
        em.remove(ratingcriterias);
    }
    // </editor-fold>
}
