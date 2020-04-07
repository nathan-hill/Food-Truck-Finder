package com.software2.foodtruckfinder.model;

import com.software2.foodtruckfinder.secure.model.UserPreferences;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserPreferencesTest {
    private UserPreferences up;

    @Test
    @DisplayName("Constructor test")
    void constructorTest(){
        up = new UserPreferences(1234l);
        assertAll(
                ()->assertEquals(1234l, up.getId()),
                ()->assertEquals(15.0, up.getProximity()),
                ()->assertEquals(1, up.getPrice())
        );
    }
}
