package com.software2.foodtruckfinder.secure.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long truckid;

    @NotNull
    private Long userID;

    @NotNull
    private String description;

    @NotNull
    private Integer rating;

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
