package com.example.stackoverflowapi.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersReceived {

    @SerializedName("items")
    private List<Users> fUsers;

    public List<Users> getUsers() {
        return fUsers;
    }

    public void setUsers(List<Users> users) {
        fUsers = users;
    }
}
