package com.software2.foodtruckfinder.secure.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private long truckID;
    @NotNull
    private Integer day;
    private boolean isOpen;
    private LocalTime startTime;
    private LocalTime endTime;
    private Double longitude;
    private Double latitude;
    public boolean getOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
        if(isOpen == false){
            setEndTime(null);
            setStartTime(null);
            setLatitude(null);
            setLongitude(null);
        }
    }

    public Long getId() {
        return id;
    }
    public long getTruckID() {
        return truckID;
    }
    public Integer getDay() {
        return day;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public Double getLongitude() {
        return longitude;
    }
    public Double getLatitude() {
        return latitude;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setTruckID(long truckID) {
        this.truckID = truckID;
    }
    public void setDay(Integer day) {
        this.day = day;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", truckID=" + truckID +
                ", day=" + day +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    @Override
    public Schedule clone() throws CloneNotSupportedException {
        Schedule newClone = new Schedule();
        newClone.setLatitude(this.getLatitude());
        newClone.setLongitude(this.getLongitude());
        newClone.setOpen(this.getOpen());
        newClone.setId(this.getId());
        newClone.setDay(this.getDay());
        newClone.setEndTime(this.getEndTime());
        newClone.setStartTime(this.getStartTime());
        newClone.setTruckID(this.getTruckID());

        return newClone;
    }
}