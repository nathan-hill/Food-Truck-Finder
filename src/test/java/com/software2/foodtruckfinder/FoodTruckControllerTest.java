package com.software2.foodtruckfinder;

import com.software2.foodtruckfinder.secure.controller.FoodTruckController;
import com.software2.foodtruckfinder.secure.controller.UserController;
import com.software2.foodtruckfinder.secure.model.Truck;
import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.repository.TruckRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class FoodTruckControllerTest {
    @Autowired
    FoodTruckController ftc;
    private ArrayList<Truck> db = new ArrayList<>();

    @BeforeEach
    void init(){
        Truck a = new Truck();
        a.setName("truck a");
        Truck b = new Truck();
        b.setName("truck b");

        db.add(a);
        db.add(b);

        /**********************************************
        ftc = new FoodTruckController(new TruckRepository() {
            @Override
            public <S extends Truck> S save(S entity) {
                return null;
            }

            @Override
            public <S extends Truck> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public boolean existsById(Long id) {
                return false;
            }

            @Override
            public Optional<Truck> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public List<Truck> findTrucksByOwnerID(long userId) {
                return null;
            }

            //@Override
            //public boolean existsById(Integer integer) {
                //return false;
            //}

            //@Override
            //public Iterable<Truck> findAll() {
                //return new Iterable<Truck>() {
                    //@Override
                    //public Iterator<Truck> iterator() {
                        //return null;
                    //}
                //};

            //}

            //@Override
            //public Iterable<Truck> findAllById(Iterable<Integer> integers) {
                //return null;
            //}

            @Override
            public long count() {
                return 0;
            }

            //@Override
            //public void deleteById(Integer integer) {

            //}

            @Override
            public void delete(Truck entity) {

            }

            @Override
            public void deleteAll(Iterable<? extends Truck> entities) {

            }

            @Override
            public void deleteAll() {

            }
        });
         *********************************************************/
    }

    @DisplayName("null addNewTruck Test")
    @Test
    void nullAddNewTest(){
        assertThrows(NullPointerException.class, ()->ftc.addNewTruck(null));
    }


//    @DisplayName("getAllTrucks Test")
//    @Test
//    void getAllTest(){
//        assertNotNull(ftc.getAllTrucks());
//    }
//
//    @DisplayName("deleteAllTrucks Test")
//    @Test
//    void deleteAllTest(){
//        assertTrue(ftc.deleteAllTrucks());
//    }
}
