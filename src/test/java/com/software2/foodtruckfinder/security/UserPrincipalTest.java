package com.software2.foodtruckfinder.security;

import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.security.UserPrincipal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserPrincipalTest {
    private UserPrincipal up;

    @BeforeEach
    void init(){
        up = new UserPrincipal(500l, "name", "username", "email", "password");
    }

    @DisplayName("UserPrincipal create constructor test")
    @Test
    void UserPrincipalCreateTEst(){
        User user = new User("name", "username", "email", "password", "type");
        UserPrincipal up1 = UserPrincipal.create(user);
        assertAll(
                ()->assertEquals("name", up1.getName()),
                ()->assertEquals("username", up1.getUsername()),
                ()->assertEquals("email", up1.getEmail()),
                ()->assertEquals("password", up1.getPassword())
        );
    }

    @DisplayName("get tests")
    @Test
    void getTests(){
        assertAll(
                ()->assertEquals("name", up.getName()),
                ()->assertEquals("username", up.getUsername()),
                ()->assertEquals("email", up.getEmail()),
                ()->assertEquals("password", up.getPassword())
        );
    }

    @DisplayName("boolean Funcitons test")
    @Test
    void booleanFunctionTests(){
        assertAll(
                ()->assertTrue(up.isAccountNonExpired()),
                ()->assertTrue(up.isAccountNonLocked()),
                ()->assertTrue(up.isCredentialsNonExpired()),
                ()->assertTrue(up.isEnabled())
        );
    }




}
