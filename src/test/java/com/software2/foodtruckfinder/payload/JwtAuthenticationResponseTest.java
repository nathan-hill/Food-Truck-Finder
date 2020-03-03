package com.software2.foodtruckfinder.payload;

import com.software2.foodtruckfinder.secure.payload.JwtAuthenticationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JwtAuthenticationResponseTest {
    private JwtAuthenticationResponse jar;

    @BeforeEach
    void init(){
        jar = new JwtAuthenticationResponse("accessToken");
    }

    @DisplayName("getAccessToken Test")
    @Test
    void getAccessTest(){
        assertEquals("accessToken", jar.getAccessToken());
    }

    @DisplayName("setAccessToken Test")
    @Test
    void setAccessTest(){
        jar.setAccessToken("newToken");
        assertEquals("newToken", jar.getAccessToken());
    }

    @DisplayName("getTokenType Test")
    @Test
    void getTokenTypeTest(){
        assertEquals("Bearer", jar.getTokenType());
    }

    @DisplayName("setTokenType Test")
    @Test
    void setTokenTypeTest(){
        jar.setTokenType("newTokenType");
        assertEquals("newTokenType", jar.getTokenType());
    }
}
