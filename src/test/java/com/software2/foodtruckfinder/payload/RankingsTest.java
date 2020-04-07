package com.software2.foodtruckfinder.payload;

import com.software2.foodtruckfinder.secure.model.Schedule;
import com.software2.foodtruckfinder.secure.model.Truck;
import com.software2.foodtruckfinder.secure.payload.Rankings;
import com.software2.foodtruckfinder.secure.repository.ScheduleRepository;
import com.software2.foodtruckfinder.secure.repository.TruckRepository;
import com.software2.foodtruckfinder.secure.repository.UPreferenceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RankingsTest {
    private TruckRepository tr;
    private UPreferenceRepository upr;
    private ScheduleRepository sr;
    private Rankings r;

    @BeforeEach
    void init(){
        r = new Rankings(122l, 12.4, 34.56);
    }

    @Test
    @DisplayName("normalize test")
    void normalizeTest(){
        Map<Truck, Double> map = new HashMap<>();
        Truck t1 = new Truck();
        t1.setId(12345l);
        Truck t2 = new Truck();
        t2.setId(54321l);

        map.put(t1, 1.5);
        map.put(t2, 2.5);

        assertNotNull(r.normalizeMap(map));

    }


}
