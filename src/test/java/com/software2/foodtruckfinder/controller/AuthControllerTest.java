package com.software2.foodtruckfinder.controller;

import com.software2.foodtruckfinder.secure.controller.AuthController;
import com.software2.foodtruckfinder.secure.payload.LoginRequest;
import com.software2.foodtruckfinder.secure.payload.SignUpRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AuthControllerTest {

    private AuthController ac;

    @BeforeEach
    void init(){
        ac = new AuthController();
    }

    @DisplayName("null authenticateUser Test")
    @Test
    void nullAuthenticateUserTest(){
        assertThrows(NullPointerException.class, ()-> ac.authenticateUser(null));
    }

    /******
    @DisplayName("valid authenticationUser Test")
    @Test
    void validAuthenticateUserTest(){
        LoginRequest lr = new LoginRequest();
        lr.setPassword("password");
        lr.setUsernameOrEmail("username");
        assertNotNull(ac.authenticateUser(lr));
    }
     ****/

    @DisplayName("null registerUser Test")
    @Test
    void nullRegisterUserTest(){
        assertThrows(NullPointerException.class, ()->ac.registerUser(null));
    }

    /****
    @DisplayName("valid registerUser Test")
    @Test
    void validRegisterUserTest(){
        assertNotNull(ac.registerUser(new SignUpRequest()));
    }
    ***/

}
