package com.software2.foodtruckfinder.payload;

import com.software2.foodtruckfinder.secure.model.Truck;
import com.software2.foodtruckfinder.secure.payload.TruckDistance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TruckDistanceTest {
    private TruckDistance td;

<<<<<<< HEAD
    @BeforeEach
    void init(){
        Truck t = new Truck();
        t.setId(1234l);
        t.setName("my truck");

        t.setType("mexican");
        t.setDescription("tacos and street corn");
        t.setOwnerID(4567l);
        t.setCost(3);
        td = new TruckDistance(t, 1.5, 1.0);
    }

    @Test
    @DisplayName("truck tests")
    void truckTest(){
        assertAll(
                ()->assertEquals(1234l, td.getId()),
                ()->assertEquals("my truck", td.getName()),

                ()->assertEquals("mexican", td.getType()),
                ()->assertEquals("tacos and street corn", td.getDescription()),
                ()->assertEquals(4567l, td.getOwnerID()),
                ()->assertEquals(3, td.getCost())
        );
    }

    @Test
    @DisplayName("Distance test")
    void distanceTest(){
        td.setDistance(2.5);
        assertEquals(2.5, td.getDistance());
    }

    @Test
    @DisplayName("Score test")
    void scoreTest(){
        td.setScore(4.3);
        assertEquals(4.3, td.getScore());
    }
=======
//    @BeforeEach
//    void init(){
//        Truck t = new Truck();
//        t.setId(1234l);
//        t.setName("my truck");
//
//        t.setType("mexican");
//        t.setDescription("tacos and street corn");
//        t.setMenu("tacos and corn");
//        t.setOwnerID(4567l);
//        t.setCost(3);
//        td = new TruckDistance(t, 1.5, 1.0);
//    }
//
//    @Test
//    @DisplayName("truck tests")
//    void truckTest(){
//        assertAll(
//                ()->assertEquals(1234l, td.getId()),
//                ()->assertEquals("my truck", td.getName()),
//
//                ()->assertEquals("mexican", td.getType()),
//                ()->assertEquals("tacos and street corn", td.getDescription()),
//                ()->assertEquals("tacos and corn", td.getMenu()),
//                ()->assertEquals(4567l, td.getOwnerID()),
//                ()->assertEquals(3, td.getCost())
//        );
//    }
//
//    @Test
//    @DisplayName("Distance test")
//    void distanceTest(){
//        td.setDistance(2.5);
//        assertEquals(2.5, td.getDistance());
//    }
//
//    @Test
//    @DisplayName("Score test")
//    void scoreTest(){
//        td.setScore(4.3);
//        assertEquals(4.3, td.getScore());
//    }
>>>>>>> a8e71d9d79acf391c09d4ee45ef5486ab542e3a8

}
