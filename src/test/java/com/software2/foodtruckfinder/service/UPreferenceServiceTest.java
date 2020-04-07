package com.software2.foodtruckfinder.service;

import com.software2.foodtruckfinder.secure.repository.UPreferenceRepository;
import com.software2.foodtruckfinder.secure.service.UPreferenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UPreferenceServiceTest {
    private UPreferenceService ups;

    @BeforeEach
    void init(){
        ups = new UPreferenceService();
    }

    @Test
    @DisplayName("getDayOfWeek test")
    void getTodayTest(){
        assertAll(
                ()->assertEquals("SUNDAY", UPreferenceService.getDayOfWeek(7)),
                ()->assertEquals("MONDAY", UPreferenceService.getDayOfWeek(1)),
                ()->assertEquals("TUESDAY", UPreferenceService.getDayOfWeek(2)),
                ()->assertEquals("WEDNESDAY", UPreferenceService.getDayOfWeek(3)),
                ()->assertEquals("THURSDAY", UPreferenceService.getDayOfWeek(4)),
                ()->assertEquals("FRIDAY", UPreferenceService.getDayOfWeek(5)),
                ()->assertEquals("SATURDAY", UPreferenceService.getDayOfWeek(6))
        );
    }
}
