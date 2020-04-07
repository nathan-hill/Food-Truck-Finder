package com.software2.foodtruckfinder.secure.payload;

import com.software2.foodtruckfinder.secure.model.Truck;

import java.util.*;

public class TruckDistance implements Comparable {

    Double distance;
    Truck t;
    Double score;

    public TruckDistance(Truck t, Double distance, Double score) {
        this.t = new Truck(t);
        this.distance = distance;
        this.score = score;
    }

    public static ArrayList<TruckDistance> makeArrayFromMap(LinkedHashMap<Truck, Double> distances, LinkedHashMap<Truck, Double> sortedRankings) {
        ArrayList<TruckDistance> res = new ArrayList<>();

        for(Map.Entry<Truck, Double> e: sortedRankings.entrySet()){
            res.add(new TruckDistance(e.getKey(), distances.get(e.getKey()), e.getValue()));
        }

        Collections.sort(res);

        return res;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Long getId() {
        return t.getId();
    }

    public String getName() {
        return t.getName();
    }

    
    public String getDescription() {
        return t.getDescription();
    }

    public String getMenu() {
        return t.getMenu();
    }

    public Long getOwnerID() {
        return t.getOwnerID();
    }

    public String getType() {
        return t.getType();
    }

    public Integer getCost() {
        return t.getCost();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double rank) {
        this.score = rank;
    }


    @Override
    public int compareTo(Object o) {
        return this.score.compareTo(((TruckDistance)o).getScore());
    }
}
