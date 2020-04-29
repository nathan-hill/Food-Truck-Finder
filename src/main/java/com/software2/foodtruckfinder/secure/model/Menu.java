package com.software2.foodtruckfinder.secure.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity // This tells Hibernate to make a table out of this class
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private Long truckid;

    @Lob
    private byte[] cover;

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }
}
