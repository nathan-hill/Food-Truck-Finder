package com.software2.foodtruckfinder.secure.payload;

import com.software2.foodtruckfinder.secure.model.Cost;
import com.software2.foodtruckfinder.secure.model.Truck;
import com.sun.istack.NotNull;

import java.time.LocalTime;
import java.util.LinkedHashMap;

public class TruckLocation {
    int id;
    String description;
    String menu;
    String name;
    String schedule;
    int cost;
    int ownerid;
    String type;
    //schedule id
    int day;
    String end_time;
    double latitude;
    double longitude;
    String start_time;
    int truckid;
    boolean is_open;

    public TruckLocation() {
    }

    public TruckLocation(int id, String description, String menu, String name, String schedule, int cost, int ownerid, String type, int day, String end_time, double latitude, double longitude, String start_time, int truckid, boolean is_open) {
        this.id = id;
        this.description = description;
        this.menu = menu;
        this.name = name;
        this.schedule = schedule;
        this.cost = cost;
        this.ownerid = ownerid;
        this.type = type;
        this.day = day;
        this.end_time = end_time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.start_time = start_time;
        this.truckid = truckid;
        this.is_open = is_open;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public boolean isIs_open() {
        return is_open;
    }

    public void setIs_open(boolean is_open) {
        this.is_open = is_open;
    }
}
