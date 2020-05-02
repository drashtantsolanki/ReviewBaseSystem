/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
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
 * @author admin
 */
@Entity
@Table(name = "ratingcriterias")
@NamedQueries({
    @NamedQuery(name = "Ratingcriterias.findAll", query = "SELECT r FROM Ratingcriterias r"),
    @NamedQuery(name = "Ratingcriterias.findByRatingCriteriaId", query = "SELECT r FROM Ratingcriterias r WHERE r.ratingCriteriaId = :ratingCriteriaId"),
    @NamedQuery(name = "Ratingcriterias.findByCriteriaName", query = "SELECT r FROM Ratingcriterias r WHERE r.criteriaName = :criteriaName")})
public class Ratingcriterias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RatingCriteriaId")
    private Integer ratingCriteriaId;
    @Basic(optional = false)
    @Column(name = "CriteriaName")
    private String criteriaName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ratingCriteriaId")
    private Collection<Categoryratingcriteria> categoryratingcriteriaCollection;

    public Ratingcriterias() {
    }

    public Ratingcriterias(Integer ratingCriteriaId) {
        this.ratingCriteriaId = ratingCriteriaId;
    }

    public Ratingcriterias(Integer ratingCriteriaId, String criteriaName) {
        this.ratingCriteriaId = ratingCriteriaId;
        this.criteriaName = criteriaName;
    }

    public Integer getRatingCriteriaId() {
        return ratingCriteriaId;
    }

    public void setRatingCriteriaId(Integer ratingCriteriaId) {
        this.ratingCriteriaId = ratingCriteriaId;
    }

    public String getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }

    @JsonbTransient
    public Collection<Categoryratingcriteria> getCategoryratingcriteriaCollection() {
        return categoryratingcriteriaCollection;
    }

    public void setCategoryratingcriteriaCollection(Collection<Categoryratingcriteria> categoryratingcriteriaCollection) {
        this.categoryratingcriteriaCollection = categoryratingcriteriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ratingCriteriaId != null ? ratingCriteriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ratingcriterias)) {
            return false;
        }
        Ratingcriterias other = (Ratingcriterias) object;
        if ((this.ratingCriteriaId == null && other.ratingCriteriaId != null) || (this.ratingCriteriaId != null && !this.ratingCriteriaId.equals(other.ratingCriteriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ratingcriterias[ ratingCriteriaId=" + ratingCriteriaId + " ]";
    }
    
}
