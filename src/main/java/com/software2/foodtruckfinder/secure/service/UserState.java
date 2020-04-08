package com.software2.foodtruckfinder.secure.service;

import com.software2.foodtruckfinder.secure.model.UserPreferences;
import com.software2.foodtruckfinder.secure.payload.Rankings;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class UserState {
    Long id;
    Double lat;
    Double lng;
    Double dis;
    Integer price;
    ArrayList<String> type;
    Integer day;

    public UserState(UserPreferences one, Double lat, Double lon) {
        this.id = one.getId();
        this.lat = lat;
        this.lng = lon;
        this.dis = one.getProximity();
        this.price = one.getPrice();
        this.type = new ArrayList<String>(one.getLikes());
        this.day = Rankings.dayOfWeekToInt(new SimpleDateFormat("EEEE").format(new Date()).toUpperCase());
    }

    @Override
    public String toString() {
        return "UserState{" +
                "id=" + id +
                ", lat=" + lat +
                ", lng=" + lng +
                ", dis=" + dis +
                ", price=" + price +
                ", type=" + type +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserState)) return false;
        UserState userState = (UserState) o;
        return Objects.equals(id, userState.id) &&
                Objects.equals(lat, userState.lat) &&
                Objects.equals(lng, userState.lng) &&
                Objects.equals(dis, userState.dis) &&
                Objects.equals(price, userState.price) &&
                Objects.equals(type, userState.type) &&
                Objects.equals(day, userState.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lat, lng, dis, price, type, day);
    }
}
