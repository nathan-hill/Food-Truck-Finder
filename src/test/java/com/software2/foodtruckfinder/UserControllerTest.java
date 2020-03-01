package com.software2.foodtruckfinder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;

import java.util.Iterator;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTest {
    private UserController uc;

    @BeforeEach
    void init(){
        uc = new UserController();
    }

    @DisplayName("addNewUser Tests")
    @Nested
    class addNewUserTests{
        @DisplayName("null addNewUser Test")
        @Test
        void nullAddNewTest(){
            assertThrows(NullPointerException.class, ()->uc.addNewUser(null));
        }

        @DisplayName("valid addNewUser Test")
        @Test
        void validAddNewTest(){
            User[] users = new User[5];
            int i=0;
            for(User u : users){
                users[i]=new User("Email"+i,"Pass"+i);
                i++;
            }

            for(i=0; i<5; i++){
                assertEquals(uc.addNewUser(users[i]).getBody().getEmail(), "Email"+i);
            }
        }

    }

    @DisplayName("Delete Test")
    @Test
    void deleteTest(){
        assertTrue(uc.deleteAllUsers());
    }

    @DisplayName("getAllUsers Test")
    @Test
    void getAllTest(){
        Iterable<User> userIt = new Iterable<User>() {
            @Override
            public Iterator<User> iterator() {
                return null;
            }
        };
        assertEquals(uc.getAllUsers().getClass(), userIt.getClass());
    }
}
