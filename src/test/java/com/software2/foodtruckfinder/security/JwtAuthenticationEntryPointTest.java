package com.software2.foodtruckfinder.security;

import com.software2.foodtruckfinder.secure.security.JwtAuthenticationEntryPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponseWrapper;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JwtAuthenticationEntryPointTest {
    private JwtAuthenticationEntryPoint jp;

    @BeforeEach
    void init(){
        jp = new JwtAuthenticationEntryPoint();
    }
    @DisplayName("null Request test")
    @Test
    void nullHttpServletRequestTest(){
        assertThrows(NullPointerException.class, ()-> jp.commence(null, new HttpServletResponseWrapper(new MockHttpServletResponse()), null));
    }

    @DisplayName("null Response test")
    @Test
    void nullHttpServletResponseTest(){
        assertThrows(NullPointerException.class, ()-> jp.commence(new HttpServletRequestWrapper(new MockHttpServletRequest()), new HttpServletResponseWrapper(new MockHttpServletResponse()), null));
    }


    @DisplayName("Valid Test")
    @Test
    void validTest(){
        AuthenticationException e = new AuthenticationException("error message") {
            @Override
            public String getMessage() {
                return super.getMessage();
            }
        };
        assertDoesNotThrow(()->jp.commence(new HttpServletRequestWrapper(new MockHttpServletRequest()), new HttpServletResponseWrapper(new MockHttpServletResponse()), e));
    }
}
