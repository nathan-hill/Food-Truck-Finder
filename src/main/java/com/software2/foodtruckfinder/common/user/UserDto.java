package com.software2.foodtruckfinder.common.user;

public class UserDto {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

//import alloy.util.Momento;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import java.util.List;
//import java.util.Map;

//
//public class UserDto implements Momento<String> {
//    private Long id;
//    private String principal;
//    private List<String> roles;
//    private UserType type;
//    private Map<String, Object> attributes;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setPrincipal(String principal) {
//        this.principal = principal;
//    }
//
//    public void setRoles(List<String> roles) {
//        this.roles = roles;
//    }
//
//    public void setType(UserType type) {
//        this.type = type;
//    }
//
//    public void setAttributes(Map<String, Object> attributes) {
//        this.attributes = attributes;
//    }
//
//    public String getPrincipal() {
//        return principal;
//    }
//
//    public List<String> getRoles() {
//        return roles;
//    }
//
//    public Map<String, Object> getAttributes() {
//        return attributes;
//    }
//
//    public UserType getType() {
//        return type;
//    }
//
//    @JsonIgnore
//    @Override
//    public String getMomento() {
//        return principal;
//    }
//
//    public enum UserType {
//        OWNER, SITTER
//    }
//}