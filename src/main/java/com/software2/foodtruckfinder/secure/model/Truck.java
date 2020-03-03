package com.software2.foodtruckfinder.secure.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Truck {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String Name;
    @NotNull
    private String Schedule;
    @NotNull
    private String Description;
    @NotNull
    private String Menu;

    @ManyToOne
    @JoinColumn(name = "ownerID", referencedColumnName = "uid")
    private User ownerID;


    public String getMenu() {
        return Menu;
    }

    public void setMenu(String menu) {
        Menu = menu;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSchedule() {
        return Schedule;
    }

    public void setSchedule(String schedule) {
        Schedule = schedule;
    }

    public Integer getId() {
        return id;
    }
}