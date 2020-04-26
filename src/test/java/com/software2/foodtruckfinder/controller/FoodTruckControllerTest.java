package com.software2.foodtruckfinder.controller;

import com.software2.foodtruckfinder.secure.controller.FoodTruckController;
import com.software2.foodtruckfinder.secure.model.Truck;
import com.software2.foodtruckfinder.secure.repository.TruckRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
//
//public class FoodTruckControllerTest {
//    private TruckRepository tr;
//    private FoodTruckController fc;
//
//    @BeforeEach
//    void init(){
//        tr = new TruckRepository() {
//            //mock repository for testing because true repository isn't loaded until application is running
//            @Override
//            public boolean existsById(Long id) {
//                return true;
//            }
//
//            @Override
//            public List<Truck> findByTypeIn(List<String> type) {
//                return null;
//            }
//
//            @Override
//            public Optional<Truck> findById(Integer in) {
//                return Optional.empty();
//            }
//
//            @Override
//            public List<Truck> findTrucksByOwnerID(long userId) {
//                return new ArrayList<Truck>();
//            }
//
//            @Override
//            public List<Truck> findAll() {
//                return null;
//            }
//
//            @Override
//            public List<Truck> findAll(Sort sort) {
//                return null;
//            }
//
//            @Override
//            public List<Truck> findAllById(Iterable<Long> longs) {
//                return null;
//            }
//
//            @Override
//            public <S extends Truck> List<S> saveAll(Iterable<S> entities) {
//                return null;
//            }
//
//            @Override
//            public void flush() {
//
//            }
//
//            @Override
//            public <S extends Truck> S saveAndFlush(S entity) {
//                return null;
//            }
//
//            @Override
//            public void deleteInBatch(Iterable<Truck> entities) {
//
//            }
//
//            @Override
//            public void deleteAllInBatch() {
//
//            }
//
//            @Override
//            public Truck getOne(Long aLong) {
//                return null;
//            }
//
//            @Override
//            public <S extends Truck> List<S> findAll(Example<S> example) {
//                return null;
//            }
//
//            @Override
//            public <S extends Truck> List<S> findAll(Example<S> example, Sort sort) {
//                return null;
//            }
//
//            @Override
//            public Page<Truck> findAll(Pageable pageable) {
//                return null;
//            }
//
//            @Override
//            public <S extends Truck> S save(S entity) {
//                return null;
//            }
//
//            @Override
//            public Optional<Truck> findById(Long aLong) {
//                return Optional.empty();
//            }
//
//            @Override
//            public long count() {
//                return 0;
//            }
//
//            @Override
//            public void deleteById(Long aLong) {
//
//            }
//
//            @Override
//            public void delete(Truck entity) {
//
//            }
//
//            @Override
//            public void deleteAll(Iterable<? extends Truck> entities) {
//
//            }
//
//            @Override
//            public void deleteAll() {
//
//            }
//
//            @Override
//            public <S extends Truck> Optional<S> findOne(Example<S> example) {
//                return Optional.empty();
//            }
//
//            @Override
//            public <S extends Truck> Page<S> findAll(Example<S> example, Pageable pageable) {
//                return null;
//            }
//
//            @Override
//            public <S extends Truck> long count(Example<S> example) {
//                return 0;
//            }
//
//            @Override
//            public <S extends Truck> boolean exists(Example<S> example) {
//                return false;
//            }
//        };
//        fc = new FoodTruckController(tr);
//    }
//
//    @Test
//    @DisplayName("null add truck test")
//    void addTruckTest(){
//        assertThrows(NullPointerException.class, ()->fc.addNewTruck(null));
//    }
//
//    @Test
//    @DisplayName("find all test")
//    void findAllTest(){
//        assertNull(fc.getAllTrucks());
//    }
//
//    @Test
//    @DisplayName("delete all test")
//    void deleteAllTest(){
//        assertTrue(fc.deleteAllTrucks());
//    }
//
//    @Test
//    @DisplayName("Find by Id Test")
//    void findByIdTest(){
//        Optional<Truck> ot = fc.findByTruckId(0);
//        assertTrue(ot.isEmpty());
//    }
//
//    @Test
//    @DisplayName("Find by Owner ID test")
//    void findByOwnerIdTest(){
//        List<Truck> ls = fc.findTrucksByOwnerID(123l);
//        assertTrue(ls.isEmpty());
//    }
//
//    @Test
//    @DisplayName("Update test")
//    void updateTest(){
//        Truck t = new Truck();
//        t.setId(1234l);
//        assertNotNull(fc.updateTruck(t));
//    }
//
//
//}


public class FoodTruckControllerTest {
    private TruckRepository tr;
    private FoodTruckController fc;

    @BeforeEach
    void init(){
        tr = new TruckRepository() {
            //mock repository for testing because true repository isn't loaded until application is running
            @Override
            public boolean existsById(Long id) {
                return true;
            }

            @Override
            public List<Truck> findByTypeIn(List<String> type) {
                return null;
            }

            @Override
            public Optional<Truck> findById(Integer in) {
                return Optional.empty();
            }

            @Override
            public List<Truck> findTrucksByOwnerID(long userId) {
                return new ArrayList<Truck>();
            }

            @Override
            public String findNameByid(long tid) {
                return null;
            }

            @Override
            public Truck findTruckById(Long id) {
                return null;
            }

            @Override
            public List<Truck> findAll() {
                return null;
            }

            @Override
            public List<Truck> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Truck> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends Truck> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Truck> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public void deleteInBatch(Iterable<Truck> entities) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Truck getOne(Long aLong) {
                return null;
            }

            @Override
            public <S extends Truck> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Truck> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Truck> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Truck> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Truck> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Truck entity) {

            }

            @Override
            public void deleteAll(Iterable<? extends Truck> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Truck> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Truck> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Truck> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Truck> boolean exists(Example<S> example) {
                return false;
            }

			@Override
			public void deleteTruck(Long tid) {
				// TODO Auto-generated method stub
				
			}
        };
        fc = new FoodTruckController(tr);
    }

    @Test
    @DisplayName("null add truck test")
    void addTruckTest(){
        assertThrows(NullPointerException.class, ()->fc.addNewTruck(null));
    }

    @Test
    @DisplayName("find all test")
    void findAllTest(){
        assertNull(fc.getAllTrucks());
    }

    @Test
    @DisplayName("delete all test")
    void deleteAllTest(){
        assertTrue(fc.deleteAllTrucks());
    }

    @Test
    @DisplayName("Find by Id Test")
    void findByIdTest(){
        Optional<Truck> ot = fc.findByTruckId(1l);
        assertTrue(ot.isEmpty());
    }

    @Test
    @DisplayName("Find by Owner ID test")
    void findByOwnerIdTest(){
        List<Truck> ls = fc.findTrucksByOwnerID(123l);
        assertTrue(ls.isEmpty());
    }

    @Test
    @DisplayName("Update test")
    void updateTest(){
        Truck t = new Truck();
        t.setId(1234l);
        assertNotNull(fc.updateTruck(t));
    }


}

