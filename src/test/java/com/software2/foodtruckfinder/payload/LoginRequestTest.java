package com.software2.foodtruckfinder.payload;

import com.software2.foodtruckfinder.secure.payload.LoginRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginRequestTest {
    private LoginRequest lr;

    @BeforeEach
    void init(){
        lr = new LoginRequest();
    }

    @DisplayName("usernameOrEmail Test")
    @Test
    void usernameOrEmailTest(){
        lr.setUsernameOrEmail("userEmail");
        assertEquals("userEmail", lr.getUsernameOrEmail());
    }

    @DisplayName("password Test")
    @Test
    void passwordTest(){
        lr.setPassword("password");
        assertEquals("password", lr.getPassword());
    }

}
