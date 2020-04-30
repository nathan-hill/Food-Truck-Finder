package com.software2.foodtruckfinder.model;

import com.software2.foodtruckfinder.secure.model.FoodTruckReviewDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FoodTruckReviewDTOTest {
    FoodTruckReviewDTO ftrd;

    @BeforeEach
    void init(){
        ftrd = new FoodTruckReviewDTO();
    }

    @Test
    @DisplayName("truckId test")
    void truckIdTest(){
        ftrd.setTruckid(1234l);
        assertEquals(1234l, ftrd.getTruckid());
    }

    @Test
    @DisplayName("userId test")
    void userIdTest(){
        ftrd.setUserID(1234l);
        assertEquals(1234l, ftrd.getUserID());
    }

    @Test
    @DisplayName("description test")
    void descriptionTest(){
        ftrd.setDescription("great stuff");
        assertEquals("great stuff", ftrd.getDescription());
    }

    @Test
    @DisplayName("rating test")
    void ratingTest(){
        ftrd.setRating(123);
        assertEquals(123, ftrd.getRating());
    }

    @Test
    @DisplayName("name test")
    void nameTest(){
        ftrd.setName("my name");
        assertEquals("my name", ftrd.getName());
    }

    @Test
    @DisplayName("customer test")
    void customerTest(){
        ftrd.setCustomer("this customer");
        assertEquals("this customer", ftrd.getCustomer());
    }

    @Test
    @DisplayName("id test")
    void idTest(){
        ftrd.setId(1234l);
        assertEquals(1234l, ftrd.getId());
    }
}
