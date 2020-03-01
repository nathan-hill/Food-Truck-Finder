package com.software2.foodtruckfinder;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @NotNull
    private String email;
    @NotNull
    private String password;


    public User(String email, String pass){
        Objects.requireNonNull(email, "Null email");
        Objects.requireNonNull(pass, "Null Password");

        this.email = email;
        this.password = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Objects.requireNonNull(email, "Null email");
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        Objects.requireNonNull(pass, "Null password");
        this.password = pass;
    }
}