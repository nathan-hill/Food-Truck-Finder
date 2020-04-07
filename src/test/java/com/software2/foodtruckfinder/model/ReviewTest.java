package com.software2.foodtruckfinder.model;

import com.software2.foodtruckfinder.secure.model.Review;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewTest {
    private Review r;

    @BeforeEach
    void init(){
        r = new Review();
    }

    @Test
    @DisplayName("ID tests")
    void idTest(){
        r.setId(123l);
        assertEquals(123l, r.getId());
    }

    @Test
    @DisplayName("User id tests")
    void userIdTest(){
        r.setUserID(4321l);
        assertEquals(4321l, r.getUserID());
    }

    @Test
    @DisplayName("Rating Test")
    void ratingTest(){
        r.setRating(5555);
        assertEquals(5555, r.getRating());
    }

    @Test
    @DisplayName("Description Test")
    void descriptionTest(){
        r.setDescription("the description");
        assertEquals("the description", r.getDescription());
    }


}
