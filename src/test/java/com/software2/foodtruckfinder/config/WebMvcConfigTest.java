package com.software2.foodtruckfinder.config;

import com.software2.foodtruckfinder.secure.config.WebMvcConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WebMvcConfigTest {
    private WebMvcConfig wmc;

    @DisplayName("null addCorsMapping Test")
    @Test
    void nullAddCorsMappingTest(){
        wmc = new WebMvcConfig();
        assertThrows(NullPointerException.class, ()->wmc.addCorsMappings(null));
    }

    @DisplayName("valid addCorsMapping Test")
    @Test
    void addCorsMappingTest(){
        wmc = new WebMvcConfig();
        assertDoesNotThrow(()->wmc.addCorsMappings(new CorsRegistry()));
    }
}
