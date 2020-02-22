/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hi
 */
@Entity
@Table(name = "rolepermission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rolepermission.findAll", query = "SELECT r FROM Rolepermission r"),
    @NamedQuery(name = "Rolepermission.findByRolePermissionId", query = "SELECT r FROM Rolepermission r WHERE r.rolePermissionId = :rolePermissionId"),
    @NamedQuery(name = "Rolepermission.findAllByName", query = "SELECT r.rolePermissionId,r1.roleName,p.permissionName FROM Rolepermission r, Role r1,Permission p WHERE r1.roleId=r.roleId AND p.permissionId=r.permissionId ")
})
public class Rolepermission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RolePermissionId")
    private Integer rolePermissionId;
    @JoinColumn(name = "RoleId", referencedColumnName = "RoleId")
    @ManyToOne(optional = false)
    private Role roleId;
    @JoinColumn(name = "PermissionId",referencedColumnName = "PermissionId")
    @ManyToOne(optional = false)
    private Permission permissionId;

    public Rolepermission() {
    }
    
    

    public Rolepermission(Integer rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public Integer getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(Integer rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Permission getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Permission permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolePermissionId != null ? rolePermissionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rolepermission)) {
            return false;
        }
        Rolepermission other = (Rolepermission) object;
        if ((this.rolePermissionId == null && other.rolePermissionId != null) || (this.rolePermissionId != null && !this.rolePermissionId.equals(other.rolePermissionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Rolepermission[ rolePermissionId=" + rolePermissionId + " ]";
    }
    
}
