package com.software2.foodtruckfinder.payload;

import com.software2.foodtruckfinder.secure.payload.ApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApiResponseTest {
    private ApiResponse ar;

    @BeforeEach
    void init(){
        ar = new ApiResponse(true, "message stuff");
    }

    @DisplayName("getSuccess Test")
    @Test
    void getSuccessTest(){
        assertTrue(ar.getSuccess());
    }

    @DisplayName("setSuccessTest")
    @Test
    void setSuccessTest(){
        ar.setSuccess(false);
        assertFalse(ar.getSuccess());
    }

    @DisplayName("getMessage test")
    @Test
    void getMessageTest(){
        assertEquals("message stuff", ar.getMessage());
    }

    @DisplayName("setMessage test")
    @Test
    void setMessageTest(){
        ar.setMessage("new message");
        assertEquals("new message", ar.getMessage());
    }
}
