package com.software2.foodtruckfinder.secure.service;

import com.software2.foodtruckfinder.secure.model.UserPreferences;
import com.software2.foodtruckfinder.secure.payload.Rankings;
import com.software2.foodtruckfinder.secure.payload.TruckDistance;
import com.software2.foodtruckfinder.secure.repository.ReviewRepository;
import com.software2.foodtruckfinder.secure.repository.ScheduleRepository;
import com.software2.foodtruckfinder.secure.repository.TruckRepository;
import com.software2.foodtruckfinder.secure.repository.UPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UPreferenceService {

    @Autowired
    private UPreferenceRepository _uprefrepo;
    @Autowired
    private ScheduleRepository _schedrepo;
    @Autowired
    private TruckRepository _truckRepo;
    @Autowired
    private ReviewRepository _reviewRepo;

    public ArrayList<TruckDistance> getPrioritizedTrucks(Long id, Double lon, Double lat) throws Exception {
        //the result will be kept in a map of the truck and its ranking
        return RecommendedStore.getStoredPreferred(id, lat, lon, _truckRepo, _uprefrepo, _schedrepo, _reviewRepo);

    }

    private int getToday() {
        //1 is sunday 7 is saturday
        return Calendar.getInstance(TimeZone.getDefault()).get(Calendar.DAY_OF_WEEK);
    }

    public static String getDayOfWeek(int value) {
        String day = "";
        switch (value) {
            case 7:
                day = "SUNDAY";
                break;
            case 1:
                day = "MONDAY";
                break;
            case 2:
                day = "TUESDAY";
                break;
            case 3:
                day = "WEDNESDAY";
                break;
            case 4:
                day = "THURSDAY";
                break;
            case 5:
                day = "FRIDAY";
                break;
            case 6:
                day = "SATURDAY";
                break;
        }
        return day;
    }

    public static <T> List<T> iteratorToList(Iterator<T> i) {
        List<T> res = new ArrayList<>();

        for (Iterator<T> it = i; it.hasNext(); ) {
            T t = it.next();
            res.add(t);
        }
        return res;
    }
}
