package com.software2.foodtruckfinder;

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
        truck.setId(456);
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
        truck.setId(789);

        assertAll(
                ()->assertEquals("M-F 4:30-8", truck.getSchedule()),
                ()->assertEquals("new cool truck name", truck.getName()),
                ()->assertEquals(789, truck.getId())
        );
    }
}
