package com.software2.foodtruckfinder.payload;

import com.software2.foodtruckfinder.secure.payload.UserIdentityAvailability;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.repository.NoRepositoryBean;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserIdentityAvailabilityTest {
    private UserIdentityAvailability uia;

    @BeforeEach
    void init(){
        uia = new UserIdentityAvailability(true);
    }

    @DisplayName("getAvailable Test")
    @Test
    void getAvailableTest(){
        assertTrue(uia.getAvailable());
    }

    @DisplayName("setAvailable Test")
    @Test
    void setAvailableTest(){
        uia.setAvailable(false);
        assertFalse(uia.getAvailable());
    }
}
