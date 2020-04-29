
package com.software2.foodtruckfinder.controller;

import com.software2.foodtruckfinder.secure.controller.UPreferenceController;
import com.software2.foodtruckfinder.secure.model.UserPreferences;
import com.software2.foodtruckfinder.secure.repository.UPreferenceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UPreferenceControllerTest {
    private UPreferenceRepository upr;
    private UPreferenceController upc;

    @BeforeEach
    void init(){
        upr = new UPreferenceRepository() {

            @Override
            public UserPreferences findUserPreferencesById(Long id) {
                return new UserPreferences();
            }


            @Override
            public List<UserPreferences> findAll() {
                return new ArrayList<UserPreferences>();
            }

            @Override
            public List<UserPreferences> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<UserPreferences> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends UserPreferences> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends UserPreferences> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public void deleteInBatch(Iterable<UserPreferences> entities) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public UserPreferences getOne(Long aLong) {
                return null;
            }

            @Override
            public <S extends UserPreferences> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends UserPreferences> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<UserPreferences> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends UserPreferences> S save(S entity) {
                return null;
            }

            @Override
            public Optional<UserPreferences> findById(Long aLong) {
                UserPreferences up = new UserPreferences();
                Optional<UserPreferences> upo = Optional.of(up);
                return upo;
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
            public void delete(UserPreferences entity) {

            }

            @Override
            public void deleteAll(Iterable<? extends UserPreferences> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends UserPreferences> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends UserPreferences> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends UserPreferences> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends UserPreferences> boolean exists(Example<S> example) {
                return false;
            }
        };
        upc = new UPreferenceController(upr);
    }

    @Test
    @DisplayName("add test")
    void addTest(){
        assertEquals(HttpStatus.OK, upc.addNewUPreferences(new UserPreferences()).getStatusCode());
    }

    @Test
    @DisplayName("get all test")
    void getAllTest(){
        assertNotNull(upc.getAllUPreferences());
    }

    @Test
    @DisplayName("delete test")
    void deleteTest(){
        assertTrue(upc.deleteAllUPreferences());
    }

    @Test
    @DisplayName("find by id test")
    void findByIdTest(){
        assertNotNull(upc.findUPreferencesByID(123l));
    }

    @Test
    @DisplayName("Update test")
    void updateTest(){
        assertEquals(HttpStatus.OK, upc.updateUPreferences(new UserPreferences()).getStatusCode());
    }
}