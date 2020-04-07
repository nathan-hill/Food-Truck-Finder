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

   // private Integer day;
    private boolean monOpen;
    private LocalTime monStartTime;
    private LocalTime monEndTime;
    private Double monLongitude;
    private Double monLatitude;

    private boolean tueOpen;
    private LocalTime tueStartTime;
    private LocalTime tueEndTime;
    private Double tueLongitude;
    private Double tueLatitude;

    private boolean wedOpen;
    private LocalTime wedStartTime;
    private LocalTime wedEndTime;
    private Double wedLongitude;
    private Double wedLatitude;

    private boolean thuOpen;
    private LocalTime thuStartTime;
    private LocalTime thuEndTime;
    private Double thuLongitude;
    private Double thuLatitude;

    private boolean friOpen;
    private LocalTime friStartTime;
    private LocalTime friEndTime;
    private Double friLongitude;
    private Double friLatitude;

    private boolean satOpen;
    private LocalTime satStartTime;
    private LocalTime satEndTime;
    private Double satLongitude;
    private Double satLatitude;

    private boolean sunOpen;
    private LocalTime sunStartTime;
    private LocalTime sunEndTime;
    private Double sunLongitude;
    private Double sunLatitude;

    public Long getId() {
        return id;
    }
    public long getTruckID() {
        return truckID;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTruckID(long truckID) {
        this.truckID = truckID;
    }

    public boolean MonOpen() {
        return monOpen;
    }

    public void setMonOpen(boolean open) {
        monOpen = open;
        if(monOpen == false){
            setMonEndTime(null);
            setMonStartTime(null);
            setMonLatitude(null);
            setMonLongitude(null);
        }
    }

    public LocalTime getMonStartTime() {
        return monStartTime;
    }
    public LocalTime getMonEndTime() {
        return monEndTime;
    }
    public Double getMonLongitude() {
        return monLongitude;
    }
    public Double getMonLatitude() {
        return monLatitude;
    }
    public void setMonStartTime(LocalTime startTime) {
        this.monStartTime = startTime;
    }
    public void setMonEndTime(LocalTime endTime) {
        this.monEndTime = endTime;
    }
    public void setMonLongitude(Double longitude) {
        this.monLongitude = longitude;
    }
    public void setMonLatitude(Double latitude) {
        this.monLatitude = latitude;
    }

    public boolean TueOpen() {
        return tueOpen;
    }

    public void setTueOpen(boolean open) {
        tueOpen = open;
        if(tueOpen == false){
            setTueEndTime(null);
            setTueStartTime(null);
            setTueLatitude(null);
            setTueLongitude(null);
        }
    }

    public LocalTime getTueStartTime() {
        return tueStartTime;
    }
    public LocalTime getTueEndTime() {
        return tueEndTime;
    }
    public Double getTueLongitude() {
        return tueLongitude;
    }
    public Double getTueLatitude() {
        return tueLatitude;
    }
    public void setTueStartTime(LocalTime startTime) {
        this.tueStartTime = startTime;
    }
    public void setTueEndTime(LocalTime endTime) {
        this.tueEndTime = endTime;
    }
    public void setTueLongitude(Double longitude) {
        this.tueLongitude = longitude;
    }
    public void setTueLatitude(Double latitude) {
        this.tueLatitude = latitude;
    }

    public boolean WedOpen() {
        return wedOpen;
    }
    public void setWedOpen(boolean open) {
        wedOpen = open;
        if(wedOpen == false){
            setWedEndTime(null);
            setWedStartTime(null);
            setWedLatitude(null);
            setWedLongitude(null);
        }
    }
    public LocalTime getWedStartTime() {
        return wedStartTime;
    }
    public LocalTime getWedEndTime() {
        return wedEndTime;
    }
    public Double getWedLongitude() {
        return wedLongitude;
    }
    public Double getWedLatitude() {
        return wedLatitude;
    }
    public void setWedStartTime(LocalTime startTime) {
        this.wedStartTime = startTime;
    }
    public void setWedEndTime(LocalTime endTime) {
        this.wedEndTime = endTime;
    }
    public void setWedLongitude(Double longitude) {
        this.wedLongitude = longitude;
    }
    public void setWedLatitude(Double latitude) {
        this.wedLatitude = latitude;
    }

    public boolean ThuOpen() {
        return thuOpen;
    }
    public void setThuOpen(boolean open) {
        thuOpen = open;
        if(thuOpen == false){
            setThuEndTime(null);
            setThuStartTime(null);
            setThuLatitude(null);
            setThuLongitude(null);
        }
    }
    public LocalTime getThuStartTime() {
        return thuStartTime;
    }
    public LocalTime getThuEndTime() {
        return thuEndTime;
    }
    public Double getThuLongitude() {
        return thuLongitude;
    }
    public Double getThuLatitude() {
        return thuLatitude;
    }
    public void setThuStartTime(LocalTime startTime) {
        this.thuStartTime = startTime;
    }
    public void setThuEndTime(LocalTime endTime) {
        this.thuEndTime = endTime;
    }
    public void setThuLongitude(Double longitude) {
        this.thuLongitude = longitude;
    }
    public void setThuLatitude(Double latitude) {
        this.thuLatitude = latitude;
    }

    public boolean FriOpen() {
        return friOpen;
    }
    public void setFriOpen(boolean open) {
        friOpen = open;
        if(friOpen == false){
            setFriEndTime(null);
            setFriStartTime(null);
            setFriLatitude(null);
            setFriLongitude(null);
        }
    }
    public LocalTime getFriStartTime() {
        return friStartTime;
    }
    public LocalTime getFriEndTime() {
        return friEndTime;
    }
    public Double getFriLongitude() {
        return friLongitude;
    }
    public Double getFriLatitude() {
        return friLatitude;
    }
    public void setFriStartTime(LocalTime startTime) {
        this.friStartTime = startTime;
    }
    public void setFriEndTime(LocalTime endTime) {
        this.friEndTime = endTime;
    }
    public void setFriLongitude(Double longitude) {
        this.friLongitude = longitude;
    }
    public void setFriLatitude(Double latitude) {
        this.friLatitude = latitude;
    }

    public boolean SatOpen() {
        return satOpen;
    }
    public void setSatOpen(boolean open) {
        satOpen = open;
        if(satOpen == false){
            setSatEndTime(null);
            setSatStartTime(null);
            setSatLatitude(null);
            setSatLongitude(null);
        }
    }
    public LocalTime getSatStartTime() {
        return satStartTime;
    }
    public LocalTime getSatEndTime() {
        return satEndTime;
    }
    public Double getSatLongitude() {
        return satLongitude;
    }
    public Double getSatLatitude() {
        return satLatitude;
    }
    public void setSatStartTime(LocalTime startTime) {
        this.satStartTime = startTime;
    }
    public void setSatEndTime(LocalTime endTime) {
        this.satEndTime = endTime;
    }
    public void setSatLongitude(Double longitude) {
        this.satLongitude = longitude;
    }
    public void setSatLatitude(Double latitude) {
        this.satLatitude = latitude;
    }

    public boolean SunOpen() {
        return sunOpen;
    }
    public void setSunOpen(boolean open) {
        sunOpen = open;
        if(sunOpen == false){
            setSunEndTime(null);
            setSunStartTime(null);
            setSunLatitude(null);
            setSunLongitude(null);
        }
    }
    public LocalTime getSunStartTime() {
        return sunStartTime;
    }
    public LocalTime getSunEndTime() {
        return sunEndTime;
    }
    public Double getSunLongitude() {
        return sunLongitude;
    }
    public Double getSunLatitude() {
        return sunLatitude;
    }
    public void setSunStartTime(LocalTime startTime) {
        this.sunStartTime = startTime;
    }
    public void setSunEndTime(LocalTime endTime) {
        this.sunEndTime = endTime;
    }
    public void setSunLongitude(Double longitude) {
        this.sunLongitude = longitude;
    }
    public void setSunLatitude(Double latitude) {
        this.sunLatitude = latitude;
    }
    
    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", truckID=" + truckID +
                ", monOpen=" + monOpen +
                ", monStartTime=" + monStartTime +
                ", monEndTime=" + monEndTime +
                ", monLongitude=" + monLongitude +
                ", monLatitude=" + monLatitude +

                ", tueOpen=" + tueOpen +
                ", tueStartTime=" + tueStartTime +
                ", tueEndTime=" + tueEndTime +
                ", tueLongitude=" + tueLongitude +
                ", tueLatitude=" + tueLatitude +

                ", wedOpen=" + wedOpen +
                ", wedStartTime=" + wedStartTime +
                ", wedEndTime=" + wedEndTime +
                ", wedLongitude=" + wedLongitude +
                ", wedLatitude=" + wedLatitude +

                ", thuOpen=" + thuOpen +
                ", thuStartTime=" + thuStartTime +
                ", thuEndTime=" + thuEndTime +
                ", thuLongitude=" + thuLongitude +
                ", thuLatitude=" + thuLatitude +
                
                ", friOpen=" + friOpen +
                ", friStartTime=" + friStartTime +
                ", friEndTime=" + friEndTime +
                ", friLongitude=" + friLongitude +
                ", friLatitude=" + friLatitude +

                ", satOpen=" + satOpen +
                ", satStartTime=" + satStartTime +
                ", satEndTime=" + satEndTime +
                ", satLongitude=" + satLongitude +
                ", satLatitude=" + satLatitude +

                ", sunOpen=" + sunOpen +
                ", sunStartTime=" + sunStartTime +
                ", sunEndTime=" + sunEndTime +
                ", sunLongitude=" + sunLongitude +
                ", sunLatitude=" + sunLatitude + 
                '}';
    }

    @Override
    public Schedule clone() throws CloneNotSupportedException {
        Schedule newClone = new Schedule();
        newClone.setId(this.getId());
        newClone.setTruckID(this.getTruckID());

        newClone.setMonLatitude(this.getMonLatitude());
        newClone.setMonLongitude(this.getMonLongitude());
        newClone.setMonOpen(this.MonOpen());
        newClone.setMonEndTime(this.getMonEndTime());
        newClone.setMonStartTime(this.getMonStartTime());
        

        newClone.setTueLatitude(this.getTueLatitude());
        newClone.setTueLongitude(this.getTueLongitude());
        newClone.setTueOpen(this.TueOpen());
        newClone.setTueEndTime(this.getTueEndTime());
        newClone.setTueStartTime(this.getTueStartTime());
        

        newClone.setWedLatitude(this.getWedLatitude());
        newClone.setWedLongitude(this.getWedLongitude());
        newClone.setWedOpen(this.WedOpen());
        newClone.setWedEndTime(this.getWedEndTime());
        newClone.setWedStartTime(this.getWedStartTime());
        

        newClone.setThuLatitude(this.getThuLatitude());
        newClone.setThuLongitude(this.getThuLongitude());
        newClone.setThuOpen(this.ThuOpen());
        newClone.setThuEndTime(this.getThuEndTime());
        newClone.setThuStartTime(this.getThuStartTime());
        

        newClone.setFriLatitude(this.getFriLatitude());
        newClone.setFriLongitude(this.getFriLongitude());
        newClone.setFriOpen(this.FriOpen());
        newClone.setFriEndTime(this.getFriEndTime());
        newClone.setFriStartTime(this.getFriStartTime());
        

        newClone.setSatLatitude(this.getSatLatitude());
        newClone.setSatLongitude(this.getSatLongitude());
        newClone.setSatOpen(this.SatOpen());
        newClone.setSatEndTime(this.getSatEndTime());
        newClone.setSatStartTime(this.getSatStartTime());
        

        newClone.setSunLatitude(this.getSunLatitude());
        newClone.setSunLongitude(this.getSunLongitude());
        newClone.setSunOpen(this.SunOpen());
        newClone.setSunEndTime(this.getSunEndTime());
        newClone.setSunStartTime(this.getSunStartTime());
        

        return newClone;
    }
}
