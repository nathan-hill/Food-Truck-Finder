package com.software2.foodtruckfinder.model;

import com.software2.foodtruckfinder.secure.model.MenuDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuDTOTest {
    private MenuDTO mt;

    private String type;
    private Integer cost;
    private String Menu;

    @BeforeEach
    void init(){
        mt = new MenuDTO();
    }

    @Test
    @DisplayName("id test")
    void idTest(){
        mt.setId(12345l);
        assertEquals(12345l, mt.getId());
    }

    @Test
    @DisplayName("name test")
    void nameTest(){
        mt.setName("name");
        assertEquals("name", mt.getName());
    }

    @Test
    @DisplayName("description test")
    void descriptionTest(){
        mt.setDescription("description");
        assertEquals("description", mt.getDescription());
    }

    @Test
    @DisplayName("ownerId test")
    void ownerIdTest(){
        mt.setOwnerID(12345l);
        assertEquals(12345l, mt.getOwnerID());
    }

    @Test
    @DisplayName("type test")
    void typeTest(){
        mt.setType("type");
        assertEquals("type", mt.getType());
    }

    @Test
    @DisplayName("cost test")
    void costTest(){
        mt.setCost(4);
        assertEquals(4, mt.getCost());
    }

    @Test
    @DisplayName("menu test")
    void menuTest(){
        mt.setMenu("tacos");
        assertEquals("tacos", mt.getMenu());
    }
}
