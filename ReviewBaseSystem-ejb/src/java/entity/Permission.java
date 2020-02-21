/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hi
 */
@Entity
@Table(name = "permission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p"),
    @NamedQuery(name = "Permission.findByPermissionId", query = "SELECT p FROM Permission p WHERE p.permissionId = :permissionId"),
    @NamedQuery(name = "Permission.findByPermissionName", query = "SELECT p FROM Permission p WHERE p.permissionName = :permissionName")})
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PermissionId")
    private Integer permissionId;
    @Basic(optional = false)
    @Column(name = "PermissionName")
    private String permissionName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permissionId")
    private Collection<Rolepermission> rolepermissionCollection;

    public Permission() {
    }

    public Permission(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Permission(Integer permissionId, String permissionName) {
        this.permissionId = permissionId;
        this.permissionName = permissionName;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @XmlTransient
    public Collection<Rolepermission> getRolepermissionCollection() {
        return rolepermissionCollection;
    }

    public void setRolepermissionCollection(Collection<Rolepermission> rolepermissionCollection) {
        this.rolepermissionCollection = rolepermissionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permissionId != null ? permissionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.permissionId == null && other.permissionId != null) || (this.permissionId != null && !this.permissionId.equals(other.permissionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Permission[ permissionId=" + permissionId + " ]";
    }
    
}
