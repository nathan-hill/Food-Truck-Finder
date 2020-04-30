package com.software2.foodtruckfinder.controller;

import com.software2.foodtruckfinder.secure.controller.SubscriptionController;
import com.software2.foodtruckfinder.secure.model.Schedule;
import com.software2.foodtruckfinder.secure.model.Subscription;
import com.software2.foodtruckfinder.secure.repository.SubscriptionRepository;
import org.apache.lucene.index.DocIDMerger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class SubscriptionControllerTest {
    private SubscriptionRepository sr;
    private SubscriptionController sc;

    @BeforeEach
    void init(){
        sr = new SubscriptionRepository() {
            @Override
            public Iterable<Subscription> findSubscriptionsByUid(Long uid) {
                return null;
            }

            @Override
            public Iterable<Subscription> findByTruckId(Long truckID) {
                return null;
            }

            @Override
            public Subscription findSubscriptionById(Long id) {
                return new Subscription();
            }

            @Override
            public Iterable<Subscription> findReviewsByTruckId(Long tid) {
                return null;
            }

            @Override
            public List<Subscription> findAll() {
                return new ArrayList<Subscription>();
            }

            @Override
            public List<Subscription> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Subscription> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends Subscription> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Subscription> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public void deleteInBatch(Iterable<Subscription> entities) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Subscription getOne(Long aLong) {
                return null;
            }

            @Override
            public <S extends Subscription> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Subscription> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Subscription> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Subscription> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Subscription> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return true;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Subscription entity) {

            }

            @Override
            public void deleteAll(Iterable<? extends Subscription> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Subscription> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Subscription> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Subscription> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Subscription> boolean exists(Example<S> example) {
                return false;
            }
        };

        sc = new SubscriptionController(sr);
    }

    @Test
    @DisplayName("Add test")
    void addTest(){
        assertEquals(HttpStatus.OK, sc.addNewSubscription(new Subscription()).getStatusCode());
    }

    @Test
    @DisplayName("get all test")
    void getAllTest(){
        assertNotNull(sc.getAllSubscription());
    }

    @Test
    @DisplayName("Delete Test")
    void deleteTest(){
        assertTrue(sc.deleteAllSubscriptions());
    }

    @Test
    @DisplayName("get by id test")
    void getByIdTest(){
        assertNotNull(sc.findSubscriptionById(123l));
    }

    @Test
    @DisplayName("Update Test")
    void updateTest(){
        Subscription s = new Subscription();
        s.setId(123l);
        s.setTruckid(123l);
        s.setUid(123l);
        assertEquals(HttpStatus.OK, sc.updateSubscription(s).getStatusCode());
    }
}
