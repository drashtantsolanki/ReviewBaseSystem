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
import javax.persistence.Lob;
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
@Table(name = "reviewxcriteria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reviewxcriteria.findAll", query = "SELECT r FROM Reviewxcriteria r"),
    @NamedQuery(name = "Reviewxcriteria.findByReviewXCriteriaId", query = "SELECT r FROM Reviewxcriteria r WHERE r.reviewXCriteriaId = :reviewXCriteriaId"),
    @NamedQuery(name = "Reviewxcriteria.findByRate", query = "SELECT r FROM Reviewxcriteria r WHERE r.rate = :rate")})
public class Reviewxcriteria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ReviewXCriteriaId")
    private Integer reviewXCriteriaId;
    @Basic(optional = false)
    @Column(name = "Rate")
    private float rate;
    @Basic(optional = false)
    @Lob
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "ReviewId", referencedColumnName = "ReviewId")
    @ManyToOne(optional = false)
    private Reviews reviewId;
    @JoinColumn(name = "CategoryRatingCriteriaId", referencedColumnName = "CategoryRatingCriteriaId")
    @ManyToOne(optional = false)
    private Categoryratingcriteria categoryRatingCriteriaId;

    public Reviewxcriteria() {
    }

    public Reviewxcriteria(Integer reviewXCriteriaId) {
        this.reviewXCriteriaId = reviewXCriteriaId;
    }

    public Reviewxcriteria(Integer reviewXCriteriaId, float rate, String description) {
        this.reviewXCriteriaId = reviewXCriteriaId;
        this.rate = rate;
        this.description = description;
    }

    public Integer getReviewXCriteriaId() {
        return reviewXCriteriaId;
    }

    public void setReviewXCriteriaId(Integer reviewXCriteriaId) {
        this.reviewXCriteriaId = reviewXCriteriaId;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Reviews getReviewId() {
        return reviewId;
    }

    public void setReviewId(Reviews reviewId) {
        this.reviewId = reviewId;
    }

    public Categoryratingcriteria getCategoryRatingCriteriaId() {
        return categoryRatingCriteriaId;
    }

    public void setCategoryRatingCriteriaId(Categoryratingcriteria categoryRatingCriteriaId) {
        this.categoryRatingCriteriaId = categoryRatingCriteriaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewXCriteriaId != null ? reviewXCriteriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reviewxcriteria)) {
            return false;
        }
        Reviewxcriteria other = (Reviewxcriteria) object;
        if ((this.reviewXCriteriaId == null && other.reviewXCriteriaId != null) || (this.reviewXCriteriaId != null && !this.reviewXCriteriaId.equals(other.reviewXCriteriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Reviewxcriteria[ reviewXCriteriaId=" + reviewXCriteriaId + " ]";
    }
    
}
