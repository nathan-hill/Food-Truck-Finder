package com.software2.foodtruckfinder.secure.model;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class FoodTruckReviewDTO {

    private Long id;
    private Long truckid;
    private Long userID;
    private String description;
    private Integer rating;
    private String FTName;
    private String Customer;

    public FoodTruckReviewDTO copy(Review r, String ftname, String Customer) {
        FoodTruckReviewDTO f = new FoodTruckReviewDTO();
        f.setDescription(r.getDescription());
        f.setId(r.getId());
        f.setName(ftname);
        f.setCustomer(Customer);
        f.setRating(r.getRating());
        f.setTruckid(r.getTruckid());
        f.setUserID(r.getUserID());

        return f;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }


    public FoodTruckReviewDTO() {
    }

    public String getName() {

        return FTName;
    }

    public void setName(String name) {
        FTName = name;
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
