package com.software2.foodtruckfinder.payload;

import com.software2.foodtruckfinder.secure.payload.UserProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserProfileTest {
    UserProfile up;
    Instant instant;

    @BeforeEach
    void init(){
        instant = Instant.now();
        up = new UserProfile((long) 500, "username", "name", instant);
    }

    @DisplayName("Id tests")
    @Nested
    class idTests{
        @DisplayName("getId test")
        @Test
        void getIdTest(){
            assertEquals(500L, up.getId());
        }

        @DisplayName("setId test")
        @Test
        void setIdTest(){
            up.setId(600L);
            assertEquals(600L, up.getId());
        }
    }

    @DisplayName("username tests")
    @Nested
    class usernameTests{
        @DisplayName("getUsername test")
        @Test
        void getIdTest(){
            assertEquals("username", up.getUsername());
        }

        @DisplayName("setUsername test")
        @Test
        void setIdTest(){
            up.setUsername("newUsername");
            assertEquals("newUsername", up.getUsername());
        }
    }

    @DisplayName("name tests")
    @Nested
    class nameTests{
        @DisplayName("getName test")
        @Test
        void getIdTest(){
            assertEquals("name", up.getName());
        }

        @DisplayName("setName test")
        @Test
        void setIdTest(){
            up.setName("newName");
            assertEquals("newName", up.getName());
        }
    }

    @DisplayName("JoinedAt tests")
    @Nested
    class instantTests{
        @DisplayName("getJoinedAt test")
        @Test
        void getIdTest(){
            assertEquals(instant, up.getJoinedAt());
        }

        @DisplayName("setJoinedAt test")
        @Test
        void setIdTest(){
            Instant in = Instant.now();
            up.setJoinedAt(in);
            assertEquals(in, up.getJoinedAt());
        }
    }
}
