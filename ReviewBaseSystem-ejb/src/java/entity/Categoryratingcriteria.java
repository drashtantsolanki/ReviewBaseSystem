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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "categoryratingcriteria")
@NamedQueries({
    @NamedQuery(name = "Categoryratingcriteria.findAll", query = "SELECT c FROM Categoryratingcriteria c"),
    @NamedQuery(name = "Categoryratingcriteria.findByCategoryRatingCriteriaId", query = "SELECT c FROM Categoryratingcriteria c WHERE c.categoryRatingCriteriaId = :categoryRatingCriteriaId"),
    @NamedQuery(name = "Categoryratingcriteria.getCategoryRatingCriteriaByCategoryId", query = "SELECT c FROM Categoryratingcriteria c WHERE c.categoryId = :categoryId")})
public class Categoryratingcriteria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CategoryRatingCriteriaId")
    private Integer categoryRatingCriteriaId;
    @JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId")
    @ManyToOne(optional = false)
    private Category categoryId;
    @JoinColumn(name = "RatingCriteriaId", referencedColumnName = "RatingCriteriaId")
    @ManyToOne(optional = false)
    private Ratingcriterias ratingCriteriaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryRatingCriteriaId")
    private Collection<Reviewxcriteria> reviewxcriteriaCollection;

    public Categoryratingcriteria() {
    }

    public Categoryratingcriteria(Integer categoryRatingCriteriaId) {
        this.categoryRatingCriteriaId = categoryRatingCriteriaId;
    }

    public Integer getCategoryRatingCriteriaId() {
        return categoryRatingCriteriaId;
    }

    public void setCategoryRatingCriteriaId(Integer categoryRatingCriteriaId) {
        this.categoryRatingCriteriaId = categoryRatingCriteriaId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Ratingcriterias getRatingCriteriaId() {
        return ratingCriteriaId;
    }

    public void setRatingCriteriaId(Ratingcriterias ratingCriteriaId) {
        this.ratingCriteriaId = ratingCriteriaId;
    }

    @JsonbTransient
    public Collection<Reviewxcriteria> getReviewxcriteriaCollection() {
        return reviewxcriteriaCollection;
    }

    public void setReviewxcriteriaCollection(Collection<Reviewxcriteria> reviewxcriteriaCollection) {
        this.reviewxcriteriaCollection = reviewxcriteriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryRatingCriteriaId != null ? categoryRatingCriteriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoryratingcriteria)) {
            return false;
        }
        Categoryratingcriteria other = (Categoryratingcriteria) object;
        if ((this.categoryRatingCriteriaId == null && other.categoryRatingCriteriaId != null) || (this.categoryRatingCriteriaId != null && !this.categoryRatingCriteriaId.equals(other.categoryRatingCriteriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Categoryratingcriteria[ categoryRatingCriteriaId=" + categoryRatingCriteriaId + " ]";
    }

}
