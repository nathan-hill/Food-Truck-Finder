package com.software2.foodtruckfinder.secure.service;

import com.software2.foodtruckfinder.secure.model.Truck;
import com.software2.foodtruckfinder.secure.payload.Rankings;
import com.software2.foodtruckfinder.secure.payload.TruckDistance;
import com.software2.foodtruckfinder.secure.repository.ScheduleRepository;
import com.software2.foodtruckfinder.secure.repository.TruckRepository;
import com.software2.foodtruckfinder.secure.repository.UPreferenceRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RecommendedStore {
    public static HashMap<UserState, ArrayList<TruckDistance>> _storedPreferences;

    static {
        _storedPreferences = new HashMap<>();
    }

    public static  ArrayList<TruckDistance> getStoredPreferred(Long id, Double lat, Double lon, TruckRepository t, UPreferenceRepository u, ScheduleRepository s) throws Exception {

        for(Map.Entry<UserState, ArrayList<TruckDistance>> tr: _storedPreferences.entrySet()){
            System.err.println(tr.getKey().toString() + " " + tr.getValue());
        }

        UserState us = new UserState(u.getOne(id), lat, lon);

        System.out.println(us.toString());

        if(_storedPreferences.get(us) == null){
            System.err.println("Did not find preference");
            //it has never been computed and needs to be
            Map<Long, Double> ranking = new LinkedHashMap<>();

            ArrayList<TruckDistance> truckDistance = new Rankings(id, lat, lon)
                    .init(t, u, s)
                    .prioritizeDate()
                    .prioritizeDistance()
                    .prioritizePrice()
                    .prioritizeType()
                    .getResult();

            _storedPreferences.put(us, truckDistance);

            return truckDistance;
        }else{
            System.err.println("Found Preference");

            //it has been computed and will be shown to user;
            return _storedPreferences.get(us);
        }
    }
}
