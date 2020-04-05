package com.software2.foodtruckfinder.secure.model;

import java.util.Arrays;

public class NotificationRequest {
    public Long[] to;

    public NotificationRequest() {
    }

    public String message;

    public NotificationRequest(Long[] to, Long from, String message) {
        this.to = to;
        this.message = message;
    }

    public Long[] getTo() {
        return to;
    }

    public void setTo(Long[] to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "NotificationRequest{" +
                "to=" + Arrays.toString(to) +
                ", message='" + message + '\'' +
                '}';
    }
}
