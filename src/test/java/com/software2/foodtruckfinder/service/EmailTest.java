package com.software2.foodtruckfinder.service;

import com.software2.foodtruckfinder.secure.service.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailTest {
    private Email e;

    @BeforeEach
    void init(){
        e = new Email("me", "subject", "from me");
    }


    @Test
    @DisplayName("To tests")
    void toTest(){
        e.setTo("toTest");
        assertEquals("toTest", e.getTo());
    }

    @Test
    @DisplayName("Subject tests")
    void subTest(){
        e.setSub("subTest");
        assertEquals("subTest", e.getSub());
    }

    @Test
    @DisplayName("Message tests")
    void mesTest(){
        e.setMsg("messageTest");
        assertEquals("messageTest", e.getMsg());
    }

    @Test
    @DisplayName("toString Test")
    void toStringTest(){
        String test = "Email{" +
                "from='" + "wwm.notifications@gmail.com" + '\'' +
                ", password='" + "BaylorB3Ars!" + '\'' +
                ", to='" + "me" + '\'' +
                ", sub='" + "subject" + '\'' +
                ", msg='" + "from me" + '\'' +
                '}';

        assertEquals(test, e.toString());
    }
}
