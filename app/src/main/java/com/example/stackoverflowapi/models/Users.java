package com.example.stackoverflowapi.models;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class Users {

    @SerializedName("location")
    private String location;

    @SerializedName("display_name")
    private String username;

    @SerializedName("reputation")
    private String reputation;

    @SerializedName("badge_counts")
    private HashMap< String, Integer > badges = new HashMap<>();

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public HashMap<String, Integer> getBadges() {
        return badges;
    }

    public void setBadges(HashMap<String, Integer> badges) {
        this.badges = badges;
    }
}
