package com.software2.foodtruckfinder.model;

import com.software2.foodtruckfinder.secure.model.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User user;

    @BeforeEach
    void init(){
        user = new User("Name", "Username", "Email", "Password", "Type");
        user.setId(500l);
    }

    @DisplayName("Name Tests")
    @Nested
    class nestedNameTests{
        @DisplayName("getName Test")
        @Test
        void getEmailTest(){
            assertEquals("Name",user.getName());
        }

        @DisplayName("setName Test")
        @Test
        void setEmailTest(){
            user.setName("NewName");
            assertEquals("NewName", user.getName());
        }

    }

    @DisplayName("Username Tests")
    @Nested
    class nestedUsernameTests{
        @DisplayName("getUsername Test")
        @Test
        void getEmailTest(){
            assertEquals("Username",user.getUsername());
        }

        @DisplayName("setUsername Test")
        @Test
        void setEmailTest(){
            user.setUsername("NewUsername");
            assertEquals("NewUsername", user.getUsername());
        }

    }

    @DisplayName("Email Tests")
    @Nested
    class nestedEmailTests{
        @DisplayName("getEmail Test")
        @Test
        void getEmailTest(){
            assertEquals("Email",user.getEmail());
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
        void getPasswordTest(){
            assertEquals("Password",user.getPassword());
        }


        @DisplayName("setPassword Test")
        @Test
        void setEmailTest(){
            user.setPassword("NewPassword");
            assertEquals("NewPassword", user.getPassword());
        }
    }

    @DisplayName("toString test")
    @Test
    void toStringTest(){
        assertEquals("User{" +
                "id=" + 500 +
                ", name='Name" + '\'' +
                ", username='Username" + '\'' +
                ", email='Email" + '\'' +
                ", password='Password" + '\'' +
                ", type='Type" + "\'}"
                , user.toString());
    }

    @Test
    @DisplayName("Type test")
    void typeTest(){
        user.setType("Customer");
        assertEquals("Customer", user.getType());
    }
}
