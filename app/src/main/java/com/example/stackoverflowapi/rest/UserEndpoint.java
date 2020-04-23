package com.example.stackoverflowapi.rest;

import com.example.stackoverflowapi.models.UsersReceived;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserEndpoint {

    @GET("/2.2/users?page=1&pagesize=100&order=desc&site=stackoverflow")
    Call<UsersReceived> getUsers(@Query("users") String user );
}
