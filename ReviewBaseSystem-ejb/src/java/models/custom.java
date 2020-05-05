/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author admin
 */
public class custom {

    private int ratingcriteriaId, rate, categoryratingcriteriaId;
    private String criteriaName;

    public custom() {
    }

    public int getRatingcriteriaId() {
        return ratingcriteriaId;
    }

    public void setRatingcriteriaId(int ratingcriteriaId) {
        this.ratingcriteriaId = ratingcriteriaId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }

    public int getCategoryratingcriteriaId() {
        return categoryratingcriteriaId;
    }

    public void setCategoryratingcriteriaId(int categoryratingcriteriaId) {
        this.categoryratingcriteriaId = categoryratingcriteriaId;
    }

}
