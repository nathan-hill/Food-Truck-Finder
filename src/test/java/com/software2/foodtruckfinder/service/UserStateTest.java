package com.software2.foodtruckfinder.service;

import com.software2.foodtruckfinder.secure.model.UserPreferences;
import com.software2.foodtruckfinder.secure.service.UserState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserStateTest {
    private UserState us;
    private UserPreferences up;

    @BeforeEach
    void init(){
        up = new UserPreferences();
        List<String> list = new ArrayList<>();
        list.add("mexican");
        list.add("chinese");
        up.setId(1234l);
        up.setPrice(2);
        up.setProximity(12.3);
        up.setLikes(list);

        us = new UserState(up, 23.4, 34.5);
    }

    @Test
    @DisplayName("constructor test")
    void constructorTest(){
        assertAll(
                ()-> assertEquals(23.4, us.getLat()),
                ()-> assertEquals(34.5, us.getLng()),
                ()-> assertEquals(us.getPrice(), up.getPrice()),
                ()-> assertEquals(us.getId(), up.getId()),
                ()-> assertEquals(us.getDis(), up.getProximity())
        );
    }
}
