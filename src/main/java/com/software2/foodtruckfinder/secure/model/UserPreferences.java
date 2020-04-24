package com.software2.foodtruckfinder.secure.model;

import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserPreferences {
    @Id
    @NotNull
    private Long id;
    @ElementCollection
    private List<String> likes;
    @Column(columnDefinition = "numeric(3,1) default 30")
    private Double proximity;
    @NotNull
    private Integer price;

    @Override
    public String toString() {
        return "UserPreferences{" +
                "id=" + id +
                ", likes=" + likes +
                ", proximity=" + proximity +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }

    public List<String> getLikes() {
        return likes;
    }

    public Double getProximity() {
        return proximity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public void setProximity(Double proximity) {
        this.proximity = proximity;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public UserPreferences() {};

    public UserPreferences(Long id){
        this.id = id;
        this.likes = new ArrayList<>();
        this.proximity = 15.0;
        this.price = 1;
    }
    public UserPreferences(UserPreferences up){
        this.id = up.getId();
        this.likes = up.getLikes();
        this.proximity = up.getProximity();
        this.price = up.getPrice();
    }
}
