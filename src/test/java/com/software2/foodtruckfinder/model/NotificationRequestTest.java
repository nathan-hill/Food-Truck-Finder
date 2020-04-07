package com.software2.foodtruckfinder.model;

import com.software2.foodtruckfinder.secure.model.NotificationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotificationRequestTest {
    private NotificationRequest nr;
    private Long[] arr = new Long[]{123l, 345l, 456l};

    @BeforeEach
    void init(){
        nr = new NotificationRequest();
    }

    @Test
    @DisplayName("Parameter Constructor test")
    void constructorTest(){
        nr = new NotificationRequest(arr, 987l, "message");
        assertEquals("message", nr.getMessage());
    }

    @Test
    @DisplayName("to tests")
    void toTest(){
        nr.setTo(arr);
        Long[] arr2 = nr.getTo();
        assertAll(
                ()->assertEquals(123l, arr2[0]),
                ()->assertEquals(345l, arr2[1]),
                ()->assertEquals(456l, arr2[2])
        );
    }

    @Test
    @DisplayName("message Test")
    void messageTest(){
        nr.setMessage("message");
        assertEquals("message", nr.getMessage());
    }

    @Test
    @DisplayName("toString Test")
    void toStringTest(){
        nr.setTo(arr);
        nr.setMessage("message");
        String test = "NotificationRequest{" +
                "to=" + Arrays.toString(arr) +
                ", message='message" + '\'' +
                '}';
        assertEquals(test, nr.toString());
    }
}
