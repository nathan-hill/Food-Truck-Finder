package com.software2.foodtruckfinder.security;

import com.software2.foodtruckfinder.secure.security.JwtTokenProvider;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.Null;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class JwtTokenProviderTest {
    private JwtTokenProvider jtp;

    @BeforeEach
    void init(){
        jtp = new JwtTokenProvider();
    }

    @DisplayName("null generateToken test")
    @Test
    void generateTokenTest(){
        assertThrows(IllegalArgumentException.class, ()->jtp.generateToken(null));
    }

    @DisplayName("null getUserId test")
    @Test
    void nullGetId(){
        assertThrows(IllegalArgumentException.class, ()->jtp.getUserIdFromJWT(null));
    }

    @DisplayName("malformed jwtToken getUserId test")
    @Test
    void invalidGetId(){
        assertThrows(MalformedJwtException.class, ()->jtp.getUserIdFromJWT("notAUserID"));
    }

    @DisplayName("valid JwtToken getUserId test")
    @Test
    void validTokenTest(){
        JwtBuilder builder = Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setSubject(String.valueOf(500l))
                .setIssuer("issuer")
                .signWith(SignatureAlgorithm.HS512, "JWTSuperSecretKey");
        assertEquals(500l, jtp.getUserIdFromJWT(builder.compact()));
    }

    @DisplayName("null validateToken Test")
    @Test
    void nullValidateToken(){
        assertFalse(jtp.validateToken(null));
    }

    @DisplayName("validateToken Test")
    @Test
    void validateTokenTest(){
        assertFalse(jtp.validateToken("invalidStuff"));
    }


}
