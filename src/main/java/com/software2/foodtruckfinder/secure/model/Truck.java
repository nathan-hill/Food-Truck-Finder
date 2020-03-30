package com.software2.foodtruckfinder.secure.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String Name;
    @NotNull
    private String Schedule;
    @NotNull
    private String Description;
    @NotNull
    private String Menu;
    @NotNull
    private Long ownerID;
    @NotNull
    private String type;
    @NotNull
    private Cost cost;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSchedule(String schedule) {
        Schedule = schedule;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setMenu(String menu) {
        Menu = menu;
    }

    public void setOwnerID(Long ownerID) {
        this.ownerID = ownerID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getSchedule() {
        return Schedule;
    }

    public String getDescription() {
        return Description;
    }

    public String getMenu() {
        return Menu;
    }

    public Long getOwnerID() {
        return ownerID;
    }

    public String getType() {
        return type;
    }

    public Integer getCost() {
        return cost.ordinal();
    }
}