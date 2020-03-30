package com.software2.foodtruckfinder.secure.model;

//import com.sun.istack.NotNull;
//import org.hibernate.annotations.NaturalId;
//
//import javax.persistence.*;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.Size;
//
//
//@Entity // This tells Hibernate to make a table out of this class
//public class Owner {
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private Long id;
//
//    @NotNull
//    @Size(max = 40)
//    private String name;
//
//    @NotNull
//    @Size(max = 15)
//    private String username;
//
//    @NotNull
//    @NaturalId
//    @Size(max = 40)
//    @Email
//    private String email;
//
//    @NotNull
//    @Size(max = 100)
//    private String password;
//
//    public Owner() {
//    }
//
//    public Owner(String name, String username, String email, String password) {
//        this.name = name;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//}