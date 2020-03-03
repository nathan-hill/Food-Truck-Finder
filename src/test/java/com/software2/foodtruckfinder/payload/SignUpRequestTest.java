package com.software2.foodtruckfinder.payload;

import com.software2.foodtruckfinder.secure.payload.SignUpRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SignUpRequestTest {

    SignUpRequest sur;

    @BeforeEach
    void init(){
        sur = new SignUpRequest();
    }

    @DisplayName("name Tests")
    @Nested
    class nameTests{

        /**********Not yet implemented
        @DisplayName("too short setName")
        @Test
        void tooShortSetName(){
            assertThrows(IllegalArgumentException.class, ()->sur.setName("no"));
        }

        @DisplayName("too long setName")
        @Test
        void tooLongSetName(){
            assertThrows(IllegalArgumentException.class, ()->sur.setName("ahahahahahahahahahahahahahahahahahah"));
        }

         **********/

        @DisplayName("valid Name")
        @Test
        void validSetName(){
            sur.setName("myName");
            assertEquals("myName", sur.getName());
        }
    }

    @DisplayName("email Tests")
    @Nested
    class emailTests{

        /**********Not yet implemented
        @DisplayName("too long setEmail")
        @Test
        void tooLongSetName(){
            assertThrows(IllegalArgumentException.class,
                    ()->sur.setEmail("ahahahahahahahahahahahahahahahahahahahaahahahahahahahahahahahahah"));
        }

        @DisplayName("invalid emails")
        @ParameterizedTest(name = "email = {0}")
        @ValueSource(strings = {"notAnEmail", "noAmpersand.com", "noPeriod@gmial", ""})
        void invalidEmialsTest(String email){
            assertThrows(IllegalArgumentException.class, ()->sur.setEmail(email));
        }
         **********/

        @DisplayName("valid Email")
        @ParameterizedTest(name = "email = {0}")
        @ValueSource(strings = {"myEmail@email.com", "jane_doe@baylor.edu", "iLuvDogs@yahoo.com", "soccer4ever@gmail.com"})
        void validSetName(String email){
            sur.setEmail(email);
            assertEquals(email, sur.getEmail());
        }
    }

    @DisplayName("password Tests")
    @Nested
    class passwordTests{
        /******** Not yet implemented
        @DisplayName("too short setPassword")
        @Test
        void tooShortSetPassword(){
            assertThrows(IllegalArgumentException.class, ()->sur.setPassword("nope"));
        }

        @DisplayName("too long setPassword")
        @Test
        void tooLongSetPassword(){
            assertThrows(IllegalArgumentException.class, ()->sur.setPassword("ahahahahahahahahahahahahahahahahahah"));
        }
         *******/

        @DisplayName("valid Password")
        @Test
        void validSetPassword(){
            sur.setPassword("myPassword");
            assertEquals("myPassword", sur.getPassword() );
        }
    }
}
