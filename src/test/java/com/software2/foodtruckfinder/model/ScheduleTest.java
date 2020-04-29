package com.software2.foodtruckfinder.model;

import com.software2.foodtruckfinder.secure.model.Schedule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class ScheduleTest {
    private Schedule s;

    @BeforeEach
    void init(){
        s = new Schedule();
    }

    @Test
    @DisplayName("get and set test")
    void getSetTest(){
        LocalTime st = LocalTime.now();
        LocalTime et = LocalTime.now();
        s.setId(1234l);
        s.setOpen(true);
        s.setStartTime(st);
        s.setEndTime(et);
        s.setLatitude(32.1);
        s.setLongitude(12.3);
        s.setDay(3);
        s.setTruckID(345l);

        assertAll(
                ()-> assertEquals(1234l, s.getId()),
                ()-> assertEquals(st, s.getStartTime()),
                ()-> assertEquals(et, s.getEndTime()),
                ()-> assertEquals(32.1, s.getLatitude()),
                ()-> assertEquals(12.3, s.getLongitude()),
                ()-> assertEquals(3, s.getDay()),
                ()-> assertEquals(345l, s.getTruckID()),
                ()-> assertTrue(s.getOpen())
        );
    }

    @Test
    @DisplayName("isOpen false test")
    void isOpenTest(){
        s.setOpen(false);
        assertFalse(s.getOpen());
    }

    @Test
    @DisplayName("toString Test")
    void toStringTest(){
        LocalTime st = LocalTime.now();
        LocalTime et = LocalTime.now();
        String string =  "Schedule{" +
                "id=" + 123l +
                ", truckID=" + 345l +
                ", day=" + 3 +
                ", startTime=" + st +
                ", endTime=" + et +
                ", longitude=" + 12.3 +
                ", latitude=" + 32.1 +
                '}';

        s.setId(123l);
        s.setStartTime(st);
        s.setEndTime(et);
        s.setLatitude(32.1);
        s.setLongitude(12.3);
        s.setDay(3);
        s.setTruckID(345l);

        assertEquals(string, s.toString());
    }

    @Test
    @DisplayName("clone test")
    void cloneTest() throws CloneNotSupportedException {
        LocalTime st = LocalTime.now();
        LocalTime et = LocalTime.now();
        s.setId(1234l);
        s.setOpen(true);
        s.setStartTime(st);
        s.setEndTime(et);
        s.setLatitude(32.1);
        s.setLongitude(12.3);
        s.setDay(3);
        s.setTruckID(345l);

        Schedule clone = s.clone();

        assertAll(
                ()-> assertEquals(clone.getId(), s.getId()),
                ()-> assertEquals(clone.getStartTime(), s.getStartTime()),
                ()-> assertEquals(clone.getEndTime(), s.getEndTime()),
                ()-> assertEquals(clone.getLatitude(), s.getLatitude()),
                ()-> assertEquals(clone.getLongitude(), s.getLongitude()),
                ()-> assertEquals(clone.getDay(), s.getDay()),
                ()-> assertEquals(clone.getTruckID(), s.getTruckID()),
                ()-> assertTrue(clone.getOpen())
        );
    }
}
