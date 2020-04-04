package com.software2.foodtruckfinder.secure.repository;

public interface TruckLocation {
    Integer getId();
    String getDescription();
    String getMenu();
    String getName();
    String getSchedule();
    Integer getCost();
    Integer getOwnerid();
    String getType();
    Integer getDay();
    String getEnd_time();
    Double getLatitude();
    Double getLongitude();
    String getStart_time();
    Integer getTruckid();
    Boolean getIs_open();
}
