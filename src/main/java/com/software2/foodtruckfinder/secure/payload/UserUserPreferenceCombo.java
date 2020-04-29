package com.software2.foodtruckfinder.secure.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.model.UserPreferences;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserUserPreferenceCombo {
    public User user;
    public UserPreferences preferences;

    public UserUserPreferenceCombo(User user, UserPreferences preferences) {
        this.user = user;
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return "UserUserPreferenceCombo{" +
                "user=" + user.toString() +
                ", userPreferences=" + preferences.toString() +
                '}';
    }
}
