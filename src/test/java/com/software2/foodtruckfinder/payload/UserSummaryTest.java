package com.software2.foodtruckfinder.payload;

import com.software2.foodtruckfinder.secure.payload.UserSummary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserSummaryTest {
    UserSummary us;

    @BeforeEach
    void init(){
        us = new UserSummary(500l, "username", "name");
    }

    @DisplayName("username tests")
    @Nested
    class usernameTests{
        @DisplayName("getUsername test")
        @Test
        void getIdTest(){
            assertEquals("username", us.getUsername());
        }

        @DisplayName("setUsername test")
        @Test
        void setIdTest(){
            us.setUsername("newUsername");
            assertEquals("newUsername", us.getUsername());
        }
    }

    @DisplayName("name tests")
    @Nested
    class nameTests{
        @DisplayName("getName test")
        @Test
        void getIdTest(){
            assertEquals("name", us.getName());
        }

        @DisplayName("setName test")
        @Test
        void setIdTest(){
            us.setName("newName");
            assertEquals("newName", us.getName());
        }
    }

    @DisplayName("Id tests")
    @Nested
    class idTests{
        @DisplayName("getId test")
        @Test
        void getIdTest(){
            assertEquals(500L, us.getId());
        }

        @DisplayName("setId test")
        @Test
        void setIdTest(){
            us.setId(600L);
            assertEquals(600L, us.getId());
        }
    }
}
