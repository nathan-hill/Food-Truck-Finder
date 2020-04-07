package com.software2.foodtruckfinder.model;

import com.software2.foodtruckfinder.secure.model.Truck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TruckTest {
    private Truck truck;

    @BeforeEach
    void init(){
        truck = new Truck();
        truck.setSchedule("MWF 10-3");
        truck.setName("coolTruckName");
        truck.setId((long) 456);
    }

    @DisplayName("get functions tests")
    @Test
    void getTests(){
        assertAll(
                ()->assertEquals("MWF 10-3", truck.getSchedule()),
                ()->assertEquals("coolTruckName", truck.getName()),
                ()->assertEquals(456, truck.getId())
        );
    }

    @DisplayName("set functions tests")
    @Test
    void setTests(){
        truck.setName("new cool truck name");
        truck.setSchedule("M-F 4:30-8");
        truck.setId((long) 789);

        assertAll(
                ()->assertEquals("M-F 4:30-8", truck.getSchedule()),
                ()->assertEquals("new cool truck name", truck.getName()),
                ()->assertEquals(789, truck.getId())
        );
    }

    @Test
    @DisplayName("copy constructor test")
    void copyConstructorTest(){
        Truck truck1 = new Truck(truck);

        assertAll(
                ()->assertEquals(truck.getId(), truck1.getId()),
                ()->assertEquals(truck.getSchedule(), truck1.getSchedule()),
                ()->assertEquals(truck.getName(), truck1.getName())
        );
    }

    @Test
    @DisplayName("getMe test")
    void getMeTest(){
        Truck truck1 = truck.getMe();

        assertAll(
                ()->assertEquals(truck.getId(), truck1.getId()),
                ()->assertEquals(truck.getSchedule(), truck1.getSchedule()),
                ()->assertEquals(truck.getName(), truck1.getName())
        );
    }

    @Test
    @DisplayName("getZero test")
    void getZeroTest(){
        assertEquals(0.0, truck.getZero());
    }

    @Test
    @DisplayName("Cost Test")
    void costTest(){
        truck.setCost(4);
        assertEquals(4, truck.getCost());
    }

    @Test
    @DisplayName("Type Test")
    void typeTest(){
        truck.setType("Mexican");
        assertEquals("Mexican", truck.getType());
    }

    @Test
    @DisplayName("toString Test")
    void toStringTest(){
        String test = "Truck{" +
                "id=" + 456 +
                ", Name='" + "coolTruckName" + '\'' +
                ", Schedule='" + "MWF 10-3" + '\'' +
                ", Description='" + "null" + '\'' +
                ", Menu='" + "null" + '\'' +
                ", ownerID=" + "null" +
                ", type='" + "null" + '\'' +
                ", cost=" + "null" +
                '}';

        assertEquals(test, truck.toString());
    }
}
