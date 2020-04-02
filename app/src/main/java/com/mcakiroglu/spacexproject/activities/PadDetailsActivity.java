package com.mcakiroglu.spacexproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Region;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mcakiroglu.spacexproject.R;
import com.mcakiroglu.spacexproject.api.ApiClient;
import com.mcakiroglu.spacexproject.api.PadDetailsInterface;
import com.mcakiroglu.spacexproject.classes.LaunchPadDetails;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PadDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {
    String siteid;
    TextView tw,tw2,tw3;
    PadDetailsInterface padDetailsInterface;
    GoogleMap map;
    LatLng lsite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pad_details);

        tw = (TextView) findViewById(R.id.padname);
        tw2 = (TextView) findViewById(R.id.region);
        tw3 = (TextView) findViewById(R.id.padDetails);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        Intent intent = getIntent();
        siteid = intent.getExtras().getString("siteid");

         padDetailsInterface= ApiClient.getClient().create(PadDetailsInterface.class);
        Call<LaunchPadDetails> call = padDetailsInterface.getPadDetails(siteid);
        call.enqueue(new Callback<LaunchPadDetails>() {
            @Override
            public void onResponse(Call<LaunchPadDetails> call, Response<LaunchPadDetails> response) {
                LaunchPadDetails launchPadDetailsList = response.body();


                System.out.println(launchPadDetailsList.toString());
                tw.setText("Name: " + launchPadDetailsList.getLocation().name);
                tw2.setText("Region: " + launchPadDetailsList.getLocation().region);
                tw3.setText("Details: " + launchPadDetailsList.getDetails());
                lsite = new LatLng(launchPadDetailsList.getLocation().latitude,launchPadDetailsList.getLocation().longitude);
                map.addMarker(new MarkerOptions().position(lsite).title("Pad"));
                map.moveCamera(CameraUpdateFactory.newLatLng(lsite));

            }

            @Override
            public void onFailure(Call<LaunchPadDetails> call, Throwable t) {
                System.out.println("Fail" + " " + t.getMessage());

            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;




        //map.addMarker(new MarkerOptions().position(lsite).title("Pad"));
        //map.moveCamera(CameraUpdateFactory.newLatLng(lsite));
    }


}
