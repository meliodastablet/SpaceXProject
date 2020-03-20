package com.mcakiroglu.spacexproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.mcakiroglu.spacexproject.R;
import com.mcakiroglu.spacexproject.api.ApiClient;
import com.mcakiroglu.spacexproject.api.LaunchDetailsInterface;
import com.mcakiroglu.spacexproject.classes.LaunchDetails;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaunchDetailsActivity extends AppCompatActivity {
    String flightnum;
    LaunchDetailsInterface launchDetailsInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_details);

        Intent intent = getIntent();
        flightnum = intent.getExtras().getString("flightnum");

        launchDetailsInterface = ApiClient.getClient().create(LaunchDetailsInterface.class);
        Call<LaunchDetails> call = launchDetailsInterface.getLaunchDetails(flightnum);
        call.enqueue(new Callback<LaunchDetails>() {
            @Override
            public void onResponse(Call<LaunchDetails> call, Response<LaunchDetails> response) {
                LaunchDetails launchDetailsList = response.body();


                System.out.println(launchDetailsList.toString());

            }

            @Override
            public void onFailure(Call<LaunchDetails> call, Throwable t) {
                System.out.println("Fail" + " " + t.getMessage());

            }
        });


    }
}
