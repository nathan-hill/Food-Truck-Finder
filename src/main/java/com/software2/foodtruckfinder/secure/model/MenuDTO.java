package com.software2.foodtruckfinder.secure.model;

import com.sun.istack.NotNull;

public class MenuDTO {

    private Long id;
    private String Name;
    private String Description;
    private Long ownerID;
    private String type;
    private Integer cost;
    private String Menutext;

    public String getMenutext() {
        return Menutext;
    }

    public void setMenutext(String menutext) {
        Menutext = menutext;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setOwnerID(Long ownerID) {
        this.ownerID = ownerID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public Long getOwnerID() {
        return ownerID;
    }

    public String getType() {
        return type;
    }

    public Integer getCost() {
        return cost;
    }

}
