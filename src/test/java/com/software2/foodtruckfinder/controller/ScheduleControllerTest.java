package com.software2.foodtruckfinder.controller;

import com.software2.foodtruckfinder.secure.controller.ScheduleController;
import com.software2.foodtruckfinder.secure.model.Schedule;
import com.software2.foodtruckfinder.secure.model.Truck;
import com.software2.foodtruckfinder.secure.repository.ScheduleRepository;
import com.software2.foodtruckfinder.secure.repository.TruckLocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ScheduleControllerTest {
    private ScheduleRepository sr;
    private ScheduleController sc;

    @BeforeEach
    void init(){
        sr = new ScheduleRepository() {
            @Override
            public Schedule findByid(Long id) {
                return new Schedule();
            }

            @Override
            public boolean existsById(Long id) {
                return true;
            }

            @Override
            public List<Schedule> findByTruckID(Integer truckID) {
                return new ArrayList<Schedule>();
            }

            @Override
            public List<TruckLocation> getTrucksForToday(int today) {
                return new ArrayList<TruckLocation>();
            }

            @Override
            public List<Schedule> findAll() {
                return new ArrayList<Schedule>();
            }

            @Override
            public List<Schedule> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Schedule> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends Schedule> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Schedule> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public void deleteInBatch(Iterable<Schedule> entities) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Schedule getOne(Long aLong) {
                return null;
            }

            @Override
            public <S extends Schedule> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Schedule> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Schedule> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Schedule> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Schedule> findById(Long aLong) {
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
            public void delete(Schedule entity) {

            }

            @Override
            public void deleteAll(Iterable<? extends Schedule> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Schedule> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Schedule> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Schedule> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Schedule> boolean exists(Example<S> example) {
                return false;
            }
        };

        sc = new ScheduleController(sr);
    }

    @Test
    @DisplayName("add test")
    void addTest() throws CloneNotSupportedException {
        Schedule s = new Schedule();
        Schedule[] arr = new Schedule[]{s};

        assertEquals(HttpStatus.OK, sc.addNewSchedule(arr).getStatusCode());
    }

    @Test
    @DisplayName("delete test")
    void deleteTest(){
        assertTrue(sc.deleteAllSchedules());
    }

    @Test
    @DisplayName("get by id test")
    void getByIdTest(){
        assertTrue(sc.findScheduleByID(123).isEmpty());
    }

    @Test
    @DisplayName("get single by id test")
    void getSingleByIdTest(){
        assertNotNull(sc.findSingleScheduleByID(123l));
    }

    @Test
    @DisplayName("Update test")
    void updateTest() throws CloneNotSupportedException {
        Schedule s = new Schedule();
        Schedule[] arr = new Schedule[]{s};
        assertEquals(HttpStatus.OK, sc.updateSchedule(arr).getStatusCode());
    }

    @Test
    @DisplayName("Get trucks for today test")
    void getForTodayTest(){
        assertTrue(sc.getTrucksForToday().isEmpty());
    }
}
