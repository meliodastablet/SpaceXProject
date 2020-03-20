package com.mcakiroglu.spacexproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.mcakiroglu.spacexproject.R;
import com.mcakiroglu.spacexproject.api.ApiClient;
import com.mcakiroglu.spacexproject.api.PadDetailsInterface;
import com.mcakiroglu.spacexproject.classes.LaunchPadDetails;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PadDetailsActivity extends AppCompatActivity {
    String siteid;
    PadDetailsInterface padDetailsInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pad_details);

        Intent intent = getIntent();
        siteid = intent.getExtras().getString("siteid");

         padDetailsInterface= ApiClient.getClient().create(PadDetailsInterface.class);
        Call<LaunchPadDetails> call = padDetailsInterface.getPadDetails(siteid);
        call.enqueue(new Callback<LaunchPadDetails>() {
            @Override
            public void onResponse(Call<LaunchPadDetails> call, Response<LaunchPadDetails> response) {
                LaunchPadDetails launchPadDetailsList = response.body();


                System.out.println(launchPadDetailsList.toString());

            }

            @Override
            public void onFailure(Call<LaunchPadDetails> call, Throwable t) {
                System.out.println("Fail" + " " + t.getMessage());

            }
        });
    }
}
