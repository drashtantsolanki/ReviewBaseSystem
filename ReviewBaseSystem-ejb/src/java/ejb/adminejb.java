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

    //@PersistenceContext(unitName = "MyReview")
    //EntityManager em;
    
    
    //------------------------------------Role------------------------------------------
    
    @Override
    public Collection<Role> getAllRoles() {
        return em.createNamedQuery("Role.findAll").getResultList();
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

    
}
