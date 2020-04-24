package com.software2.foodtruckfinder.secure.model;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class FoodTruckReviewDTO {

    private Long id;
    private Long truckid;
    private Long userID;
    private String description;
    private Integer rating;
    private String Name;

    public FoodTruckReviewDTO() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getTruckid() {
        return truckid;
    }

    public void setTruckid(Long truckid) {
        this.truckid = truckid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserID() {
        return userID;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

}
