package com.software2.foodtruckfinder;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User user;

    @BeforeEach
    void init(){
        user = new User("Email", "Password");
    }

    @DisplayName("Null Constructor Input")
    @Test
    void nullConstructorTest(){
        assertAll(
                ()-> assertThrows(NullPointerException.class, ()->new User(null, "pass")),
                ()-> assertThrows(NullPointerException.class, ()->new User("user", null))
        );
    }


    @DisplayName("Email Tests")
    @Nested
    class nestedEmailTests{
        @DisplayName("getEmail Test")
        @Test
        void getEmailTest(){
            assertEquals("Email",user.getEmail());
        }

        @DisplayName("Null setEmail Test")
        @Test
        void nullSetEmail(){
            assertThrows(NullPointerException.class, ()->user.setEmail(null));
        }

        @DisplayName("setEmail Test")
        @Test
        void setEmailTest(){
            user.setEmail("NewEmail");
            assertEquals("NewEmail", user.getEmail());
        }

    }

    @DisplayName("Password Tests")
    @Nested
    class passwordTests{
        @DisplayName("gePassword Test")
        @Test
        void getEmailTest(){
            assertEquals("Password",user.getPassword());
        }

        @DisplayName("Null setPassword Test")
        @Test
        void nullSetPass(){
            assertThrows(NullPointerException.class, ()->user.setPassword(null));
        }

        @DisplayName("setPassword Test")
        @Test
        void setEmailTest(){
            user.setPassword("NewPassword");
            assertEquals("NewPassword", user.getPassword());
        }
    }
}
