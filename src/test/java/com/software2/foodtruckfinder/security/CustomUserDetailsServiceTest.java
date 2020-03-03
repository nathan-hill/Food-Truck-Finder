package com.software2.foodtruckfinder.security;

import com.software2.foodtruckfinder.secure.security.CustomUserDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomUserDetailsServiceTest {
    CustomUserDetailsService cds;

    @BeforeEach
    void init(){
        cds = new CustomUserDetailsService();
    }

    @DisplayName("null LoadByUserId Test")
    @Test
    void nullLoadByUserIdTest(){
        assertThrows(NullPointerException.class, ()->cds.loadUserById(null));
    }

    @DisplayName("valid LoadByUserId Test")
    @Test
    void validLoadByUserIdTest(){
        assertNotNull(cds.loadUserById(500L));
    }

    @DisplayName("null LoadByUsername Test")
    @Test
    void nullLoadByUsernameTest(){
        assertThrows(NullPointerException.class, ()->cds.loadUserByUsername(null));
    }

    @DisplayName("valid LoadByUsername Test")
    @Test
    void validLoadByUsernameTest(){
        assertNotNull(cds.loadUserByUsername("username"));
    }
}
