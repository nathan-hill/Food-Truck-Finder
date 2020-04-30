package com.software2.foodtruckfinder.model;

import com.software2.foodtruckfinder.secure.model.Subscription;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubscriptionTest {
    private Subscription s;

    @BeforeEach
    void init(){
        s = new Subscription();
    }

    @Test
    @DisplayName("id test")
    void idTest(){
        s.setId(123l);
        assertEquals(123l, s.getId());
    }

    @DisplayName("uid test")
    void uidTest(){
        s.setUid(456l);
        assertEquals(456l, s.getUid());
    }

    @DisplayName("truckId test")
    void truckIdTest(){
        s.setTruckid(789l);
        assertEquals(789l, s.getTruckid());
    }


}
