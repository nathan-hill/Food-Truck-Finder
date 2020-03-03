package com.software2.foodtruckfinder.controller;

import com.software2.foodtruckfinder.secure.controller.UserController;
import com.software2.foodtruckfinder.secure.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTest {

    UserController uc;

    @BeforeEach
    void init(){
        uc = new UserController();
    }

    @DisplayName("null addNewUser Test")
    @Test
    void nullAddNewTest(){
        assertThrows(NullPointerException.class, ()->uc.addNewUser(null));
    }

    @DisplayName("valid addNewUser Test")
    @Test
    void validAddNewTest(){
        assertNotNull(uc.addNewUser(new User("name", "username", "email", "password")));
    }

    @DisplayName("getAllUsers Test")
    @Test
    void getAllTest(){
        assertNotNull(uc.getAllUsers());
    }

    @DisplayName("deleteAllUsers Test")
    @Test
    void deleteAllTest(){
        assertTrue(uc.deleteAllUsers());
    }
}
