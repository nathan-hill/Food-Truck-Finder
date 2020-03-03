package com.software2.foodtruckfinder.config;

import com.software2.foodtruckfinder.secure.config.SecurityConfig;
import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.security.JwtAuthenticationFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import static org.junit.jupiter.api.Assertions.*;

public class SecurityConfigTest {
    SecurityConfig sc;

    @BeforeEach
    void init(){
        sc = new SecurityConfig();
    }

    @DisplayName("JwtAuthenticationFilter Test")
    @Test
    void jwtAuthenticationFilterTest(){
        assertNotNull(sc.jwtAuthenticationFilter());
    }

    @DisplayName("null AuthenticationManager Config test")
    @Test
    void nullConfigTest(){
        AuthenticationManagerBuilder am = null;
        assertThrows(NullPointerException.class, ()->sc.configure(am));
    }

    @DisplayName("valid AuthenticationManager Config test")
    @Test
    void validAMConfigTest(){
        ObjectPostProcessor<Object> o = new ObjectPostProcessor<Object>() {
            @Override
            public <O> O postProcess(O object) {
                return null;
            }
        };
        AuthenticationManagerBuilder am = new AuthenticationManagerBuilder(o);

        assertDoesNotThrow(()->sc.configure(am));
    }


    @DisplayName("passwordEncoder Test")
    @Test
    void passwordEncoderTest(){
        assertNotNull(sc.passwordEncoder());
    }

}
