package com.software2.foodtruckfinder.model;

import com.software2.foodtruckfinder.secure.model.NotificationsDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.Times;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotificationsDTOTest {

    private NotificationsDTO nd;

    @BeforeEach
    void init(){
        nd = new NotificationsDTO();
    }

    @Test
    @DisplayName("time test")
    void timeTest(){
        Timestamp ts = new Timestamp(123);
        nd.setSentTime(ts);
        assertEquals(ts, nd.getSentTime());
    }

    @Test
    @DisplayName("truckName test")
    void truckNameTest(){
        nd.setTruckName("truckName");
        assertEquals("truckName", nd.getTruckName());
    }

    @Test
    @DisplayName("sender test")
    void senderTest(){
        nd.setSender("sender");
        assertEquals("sender", nd.getSender());
    }

    @Test
    @DisplayName("text test")
    void textTest(){
        nd.setText("text");
        assertEquals("text", nd.getText());
    }

    @Test
    @DisplayName("read test")
    void readTest(){
        nd.setRead("1");
        assertEquals("1", nd.getRead());
    }
}
