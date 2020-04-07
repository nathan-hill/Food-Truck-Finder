package com.software2.foodtruckfinder.payload;

import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.model.UserPreferences;
import com.software2.foodtruckfinder.secure.payload.UserUserPreferenceCombo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserUserPreferenceComboTest {
    private UserUserPreferenceCombo uupc;

    @Test
    void test(){
        User u = new User();
        u.setId(1234l);
        UserPreferences up = new UserPreferences();
        uupc = new UserUserPreferenceCombo(u, up);
        System.out.println(uupc.toString());
        assertNotNull(uupc.toString());
    }
}
