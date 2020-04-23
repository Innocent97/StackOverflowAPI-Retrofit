package com.example.stackoverflowapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.stackoverflowapi.adapter.StackAdapter;
import com.example.stackoverflowapi.models.Users;
import com.example.stackoverflowapi.models.UsersReceived;
import com.example.stackoverflowapi.rest.ApiClient;
import com.example.stackoverflowapi.rest.UserEndpoint;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView fRecyclerView;
    StackAdapter fAdapter;
    List<Users> fUsersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        fRecyclerView.setLayoutManager( new LinearLayoutManager( this ));
        fAdapter = new StackAdapter( this, fUsersList );
        fRecyclerView.setAdapter( fAdapter );

        loadUsersData();
    }

    private void loadUsersData() {
        UserEndpoint endpoint = ApiClient.getRetrofit().create( UserEndpoint.class );
        Call<UsersReceived> call =  endpoint.getUsers("reputation");
        call.enqueue(new Callback<UsersReceived>() {
            @Override
            public void onResponse(Call<UsersReceived> call, Response<UsersReceived> response) {

                fUsersList.clear();
                fUsersList.addAll( response.body().getUsers() );
                fAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<UsersReceived> call, Throwable t) {
                Toast.makeText( getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
