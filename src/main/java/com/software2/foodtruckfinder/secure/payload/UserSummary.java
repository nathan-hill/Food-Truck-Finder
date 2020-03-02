package com.software2.foodtruckfinder.secure.payload;

public class UserSummary {
    private Long id;
    private String username;
    private String name;
    private String type;

    public UserSummary(Long id, String username, String name, String type) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
