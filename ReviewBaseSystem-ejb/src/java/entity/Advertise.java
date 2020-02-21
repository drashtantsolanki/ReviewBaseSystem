/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hi
 */
@Entity
@Table(name = "advertise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advertise.findAll", query = "SELECT a FROM Advertise a"),
    @NamedQuery(name = "Advertise.findByAdvertiseId", query = "SELECT a FROM Advertise a WHERE a.advertiseId = :advertiseId"),
    @NamedQuery(name = "Advertise.findByStartDate", query = "SELECT a FROM Advertise a WHERE a.startDate = :startDate"),
    @NamedQuery(name = "Advertise.findByEndDate", query = "SELECT a FROM Advertise a WHERE a.endDate = :endDate")})
public class Advertise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AdvertiseId")
    private Integer advertiseId;
    @Basic(optional = false)
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne(optional = false)
    private Product productId;

    public Advertise() {
    }

    public Advertise(Integer advertiseId) {
        this.advertiseId = advertiseId;
    }

    public Advertise(Integer advertiseId, Date startDate, Date endDate) {
        this.advertiseId = advertiseId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getAdvertiseId() {
        return advertiseId;
    }

    public void setAdvertiseId(Integer advertiseId) {
        this.advertiseId = advertiseId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (advertiseId != null ? advertiseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advertise)) {
            return false;
        }
        Advertise other = (Advertise) object;
        if ((this.advertiseId == null && other.advertiseId != null) || (this.advertiseId != null && !this.advertiseId.equals(other.advertiseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Advertise[ advertiseId=" + advertiseId + " ]";
    }
    
}
