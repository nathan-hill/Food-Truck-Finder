package com.software2.foodtruckfinder.controller;

import com.software2.foodtruckfinder.secure.controller.LoginController;
import com.software2.foodtruckfinder.secure.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LoginControllerTest {

    private LoginController lc;

    @DisplayName("null ValidateUser Test")
    @Test
    void nullValidateUserTest(){
        lc = new LoginController();
        assertThrows(NullPointerException.class, ()->lc.validateUser(null));
    }

    /**
    @DisplayName("valid ValidateUser Test")
    @Test
    void validValidateUserTest(){
        lc = new LoginController();
        assertNotNull(lc.validateUser(new User("name", "username", "email", "pass")));
    }
    **/
}
