package com.software2.foodtruckfinder.model;

import com.software2.foodtruckfinder.secure.model.ScheduleDTO;
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
        truck.setName("coolTruckName");
        truck.setId((long) 456);
        truck.setCost(3);
        truck.setOwnerID(12l);
        truck.setMenu("tacos");
        truck.setType("mexican");
        truck.setDescription("awesome tacos");
    }

    @DisplayName("get functions tests")
    @Test
    void getTests(){
        assertAll(
                ()->assertEquals("coolTruckName", truck.getName()),
                ()->assertEquals(456, truck.getId()),
                ()->assertEquals(3, truck.getCost()),
                ()->assertEquals(12l, truck.getOwnerID()),
                ()->assertEquals("tacos", truck.getMenu()),
                ()->assertEquals("mexican", truck.getType()),
                ()->assertEquals("awesome tacos", truck.getDescription())
        );
    }

    @DisplayName("set functions tests")
    @Test
    void setTests(){
        truck.setName("new coolTruckName");
        truck.setId(33l);
        truck.setCost(2);
        truck.setOwnerID(13l);
        truck.setMenu("enchiladas");
        truck.setType("tex mex");
        truck.setDescription("awesome enchiladas");

        assertAll(
                ()->assertEquals("new coolTruckName", truck.getName()),
                ()->assertEquals(33l, truck.getId()),
                ()->assertEquals(2, truck.getCost()),
                ()->assertEquals(13l, truck.getOwnerID()),
                ()->assertEquals("enchiladas", truck.getMenu()),
                ()->assertEquals("tex mex", truck.getType()),
                ()->assertEquals("awesome enchiladas", truck.getDescription())
        );
    }

    @Test
    @DisplayName("copy constructor test")
    void copyConstructorTest(){
        Truck truck1 = new Truck(truck);

        assertAll(
                ()->assertEquals(truck.getId(), truck1.getId()),
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
                ", Description='" + "awesome tacos" + '\'' +
                ", ownerID=" + "12" +
                ", type='" + "mexican" + '\'' +
                ", cost=" + "3" +
                '}';

        assertEquals(test, truck.toString());
    }
}
