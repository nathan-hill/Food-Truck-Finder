package com.software2.foodtruckfinder.secure.model;

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
