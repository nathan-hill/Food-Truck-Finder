package com.software2.foodtruckfinder.model;

import com.software2.foodtruckfinder.secure.model.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {
    private Menu m;

    @BeforeEach
    void init(){
        m = new Menu();
    }

    @Test
    @DisplayName("id test")
    void idTest(){
        m.setId(1234l);
        assertEquals(1234l, m.getId());
    }

    @Test
    @DisplayName("truckId test")
    void truckIdTest(){
        m.setTruckid(1234l);
        assertEquals(1234l, m.getTruckid());
    }


    @Test
    @DisplayName("cover test")
    void coverTest(){
        byte[] b = new byte[2];
        b[0] = 0x1;
        b[1] = 0x2;
        m.setCover(b);
        assertEquals(b, m.getCover());
    }


    @Test
    @DisplayName("text test")
    void textTest(){
        m.setText("stuff");
        assertEquals("stuff", m.getText());
    }
}
