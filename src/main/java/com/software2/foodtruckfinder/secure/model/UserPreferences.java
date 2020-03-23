package com.software2.foodtruckfinder.secure.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
@Entity
public class UserPreferences {

    @Id
    @NotNull
    private Long id;

    // added these two fields
    @ElementCollection
    private List<String> foodLikes;

    @ElementCollection
    private List<String> dislikes;

    @NotNull
    private Double proximity;

    @NotNull
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Double getProximity() {
        return proximity;
    }

    public void setProximity(Double proximity) {
        this.proximity = proximity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getDislikes() {
        return dislikes;
    }

    public void setDislikes(List<String> dislikes) {
        this.dislikes = dislikes;
    }

    public List<String> getFoodLikes() {
        return foodLikes;
    }

    public void setFoodLikes(List<String> preferences) {
        this.foodLikes = preferences;
    }


}
