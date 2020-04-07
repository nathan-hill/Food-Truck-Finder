package com.software2.foodtruckfinder.model;

import com.software2.foodtruckfinder.secure.model.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MessageTest {
    private Message m;

    @BeforeEach
    void init(){
        m = new Message("name", 123l, 321l, "message", new Timestamp(123), "subject", false);
    }

    @Test
    @DisplayName("Name Test")
    void nameTest(){
        m.setTruckName("truckName");
        assertEquals("truckName", m.getTruckName());
    }

    @Test
    @DisplayName("sender Tests")
    void senderTest(){
        m.setSender(456l);
        assertEquals(456l, m.getSender());
    }

    @Test
    @DisplayName("receiver tests")
    void receiverTest(){
        m.setReceiver(789l);
        assertEquals(789l, m.getReceiver());
    }

    @Test
    @DisplayName("text Test")
    void subjectTest(){
        m.setText("new message");
        assertEquals("new message", m.getText());
    }

    @Test
    @DisplayName("isRead test")
    void readTest(){
        m.setRead(true);
        assertTrue(m.getRead());
    }

}
