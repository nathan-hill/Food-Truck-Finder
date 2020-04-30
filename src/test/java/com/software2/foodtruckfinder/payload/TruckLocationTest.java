package com.software2.foodtruckfinder.payload;

import com.software2.foodtruckfinder.secure.payload.TruckLocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TruckLocationTest {
    private TruckLocation tl;

    @BeforeEach
    void init(){
        tl = new TruckLocation(33, "description", "menu", "name", "schedule",
                2, 81, "type", 4, "end_time", 1.0, 2.0,
                "start_time", 12, true);
    }

    @Test
    @DisplayName("id test")
    void idTest(){
        tl.setId(11);
        assertEquals(11, tl.getId());
    }

    @Test
    @DisplayName("Description Test")
    void descriptionTest(){
        tl.setDescription("desc");
        assertEquals("desc", tl.getDescription());
    }

    @Test
    @DisplayName("MenuTest Test")
    void menuTest(){
        tl.setMenu("test");
        assertEquals("test", tl.getMenu());
    }

    @Test
    @DisplayName("Name Test")
    void nameTest(){
        tl.setName("test");
        assertEquals("test", tl.getName());
    }


    @Test
    @DisplayName("Schedule Test")
    void scheduleTest(){
        tl.setSchedule("test");
        assertEquals("test", tl.getSchedule());
    }


    @Test
    @DisplayName("Cost Test")
    void costTest(){
        tl.setCost(10);
        assertEquals(10, tl.getCost());
    }

    @Test
    @DisplayName("Owner ID Test")
    void ownerIDTest(){
        tl.setOwnerid(10);
        assertEquals(10, tl.getOwnerid());
    }


    @Test
    @DisplayName("Type Test")
    void typeTest(){
        tl.setType("test");
        assertEquals("test", tl.getType());
    }


    @Test
    @DisplayName("Day Test")
    void dayTest(){
        tl.setDay(5);
        assertEquals(5, tl.getDay());
    }



    @Test
    @DisplayName("Start Time Test")
    void startTimeTest(){
        tl.setStart_time("test");
        assertEquals("test", tl.getStart_time());
    }



    @Test
    @DisplayName("End Time Test")
    void endTimeTest(){
        tl.setEnd_time("test");
        assertEquals("test", tl.getEnd_time());
    }

    @Test
    @DisplayName("Lattitude test")
    void latTest(){
        tl.setLatitude(3.0);
        assertEquals(3.0, tl.getLatitude());
    }

    @Test
    @DisplayName("Longitude test")
    void lonTest(){
        tl.setLongitude(3.0);
        assertEquals(3.0, tl.getLongitude());
    }

    @Test
    @DisplayName("Open Test")
    void OpenTest(){
        tl.setIs_open(false);
        assertFalse(tl.isIs_open());
    }
}
