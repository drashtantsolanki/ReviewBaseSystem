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
import entity.Reviews;
import entity.Reviewxcriteria;

import java.util.Collection;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hi
 */
@Stateless
public class adminejb implements adminejbLocal {

    @PersistenceContext(unitName = "MyReview")
    EntityManager em;

    // <editor-fold defaultstate="collapsed" desc="Role">
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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Permission">
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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="RolePermission">
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
    public void addRolePermission(int roleId, int permissionId) {
        Rolepermission rp = new Rolepermission();

        Role role = em.find(Role.class, roleId);
        Permission permission = em.find(Permission.class, permissionId);

        Collection<Rolepermission> lstrp1 = role.getRolepermissionCollection();
        Collection<Rolepermission> lstrp2 = permission.getRolepermissionCollection();
        rp.setRoleId(role);
        rp.setPermissionId(permission);
        lstrp1.add(rp);
        lstrp2.add(rp);
        em.merge(role);
        em.merge(permission);
        em.persist(rp);
    }

    @Override
    public void updateRolePermission(int roleId, int permissionId, int rolePermissionId) {
        Rolepermission rp = em.find(Rolepermission.class, rolePermissionId);

        Role role = em.find(Role.class, roleId);
        Permission permission = em.find(Permission.class, permissionId);

        Collection<Rolepermission> lstrp1 = role.getRolepermissionCollection();
        Collection<Rolepermission> lstrp2 = permission.getRolepermissionCollection();

        rp.setRoleId(role);
        rp.setPermissionId(permission);
        lstrp1.add(rp);
        lstrp2.add(rp);

        em.merge(role);
        em.merge(permission);
        em.merge(rp);
    }

    @Override
    public void removeRolePermission(int rolePermissionId) {
        Rolepermission rp = em.find(Rolepermission.class, rolePermissionId);
        em.remove(rp);
    }

    @Override
    public Collection<Rolepermission> getAllRolePermissionWithName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="UserRole">
    @Override
    public Collection<Userrole> getAllUserRole() {
        return em.createNamedQuery("Userrole.findAll").getResultList();
    }

    @Override
    public Userrole getUserRoleById(int userRoleId) {
        return (Userrole) em.createNamedQuery("Userrole.findByUserRoleId").getSingleResult();
    }

    @Override
    public Userrole getUserRoleByUserId(int userId) {
        return em.find(Userrole.class, userId);
    }

    @Override
    public Userrole getUserRoleByRoleId(int roleId) {
        return em.find(Userrole.class, roleId);
    }

    @Override
    public void addUserRole(int userId, int roleId) {
        Userrole ur = new Userrole();

        Users users = em.find(Users.class, userId);
        Role role = em.find(Role.class, roleId);

        Collection<Userrole> lstur1 = users.getUserroleCollection();
        Collection<Userrole> lstur2 = role.getUserroleCollection();

        ur.setRoleId(role);
        ur.setUserId(users);
        lstur1.add(ur);
        lstur2.add(ur);

        users.setUserroleCollection(lstur1);
        role.setUserroleCollection(lstur2);

        em.merge(role);
        em.merge(users);
        em.persist(ur);

    }

    @Override
    public void updateUserRole(int userId, int roleId, int userRoleId) {
        Userrole ur = em.find(Userrole.class, userRoleId);

        Role role = em.find(Role.class, roleId);
        Users users = em.find(Users.class, userId);

        Collection<Userrole> lstur1 = role.getUserroleCollection();
        Collection<Userrole> lstur2 = users.getUserroleCollection();

        ur.setRoleId(role);
        ur.setUserId(users);
        lstur1.add(ur);
        lstur2.add(ur);

        role.setUserroleCollection(lstur1);
        users.setUserroleCollection(lstur2);

        em.merge(role);
        em.merge(users);
        em.merge(ur);

    }

    @Override
    public void removeUserRole(int userRoleId) {
        Userrole obj = em.find(Userrole.class, userRoleId);
        em.remove(obj);
    }
    // </editor-fold>

    //============================USERS=================================
    public void persist(Object object) {
        em.persist(object);
    }

    // <editor-fold defaultstate="collapsed" desc="User">
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
    // </editor-fold>

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
    public void updateProductToCategory(int productId, int categoryId, String productName, String referenceLink, int authorId, int genreId, int publisherId, int companyId) {
        Product product = em.find(Product.class, productId);
        Category category = em.find(Category.class, categoryId);
        Collection<Product> products = category.getProductCollection();

        if (products.contains(product)) {
            products.remove(product);
        }

        product.setCategoryId(category);
        product.setProductName(productName);
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
        public void updateImage(int productid, String productimage) {
        Product product = em.find(Product.class, productid);
        product.setProductImage(productimage);
        em.merge(product);
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

    // </editor-fold>
}
