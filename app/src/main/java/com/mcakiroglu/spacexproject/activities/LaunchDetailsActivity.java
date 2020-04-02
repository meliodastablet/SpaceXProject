package com.mcakiroglu.spacexproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mcakiroglu.spacexproject.R;
import com.mcakiroglu.spacexproject.api.ApiClient;
import com.mcakiroglu.spacexproject.api.LaunchDetailsInterface;
import com.mcakiroglu.spacexproject.api.PadDetailsInterface;
import com.mcakiroglu.spacexproject.classes.LaunchDetails;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaunchDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    String flightnum;
    LaunchDetailsInterface launchDetailsInterface;
    Firebase reference;
    private DatabaseReference mDatabase;
    TextView textView, tw, tw2, tw3, tw4, tw5, tw6;
    ImageView iw;
    Button b,b1,b2;
    String s,s2,s4;
    List<String> s3 = new ArrayList<String>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_details);
        Firebase.setAndroidContext(this);
        reference = new Firebase("https://spacex-72334.firebaseio.com/");
        mDatabase = FirebaseDatabase.getInstance().getReference();
        textView = (TextView) findViewById(R.id.numviews);
        tw = (TextView) findViewById(R.id.mname);
        tw2 = (TextView) findViewById(R.id.lyear);
        tw3 = (TextView) findViewById(R.id.lsite);
        tw4 = (TextView) findViewById(R.id.rname);
        tw5 = (TextView) findViewById(R.id.ldate);
        tw6 = (TextView) findViewById(R.id.details);
        iw = (ImageView) findViewById(R.id.imageView);
        b = (Button) findViewById(R.id.wiki);
        b1 = (Button) findViewById(R.id.yutup);
        b2 = (Button) findViewById(R.id.images);
        tw3.setOnClickListener(this);
        b.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        Intent intent = getIntent();
        flightnum = intent.getExtras().getString("flightnum");

        launchDetailsInterface = ApiClient.getClient().create(LaunchDetailsInterface.class);
        Call<LaunchDetails> call = launchDetailsInterface.getLaunchDetails(flightnum);
        call.enqueue(new Callback<LaunchDetails>() {
            @Override
            public void onResponse(Call<LaunchDetails> call, Response<LaunchDetails> response) {
                LaunchDetails launchDetailsList = response.body();

                tw.setText(launchDetailsList.getMissionName());
                tw2.setText(launchDetailsList.getLaunchYear());
                tw3.setText("Launch Site: " + launchDetailsList.getLaunchSite().siteName);
                tw4.setText("Rocket Name: " + launchDetailsList.getRocket().getRocketName());
                tw5.setText("Launch Date: " + launchDetailsList.getLaunchDateUtc());
                if(launchDetailsList.getDetails() == null)
                    tw6.setText("-");
                else{
                    tw6.setText("Details: " + launchDetailsList.getDetails());
                }


                s = launchDetailsList.getLinks().wikipedia;
                s2 = launchDetailsList.getLinks().videoLink;
                s3 = launchDetailsList.getLinks().flickrImages;
                s4 = launchDetailsList.getLaunchSite().siteId;
                Glide.with(getApplicationContext()).load(launchDetailsList.getLinks().missionPatch).into(iw);

                if(launchDetailsList.getLinks().flickrImages.isEmpty())
                    b2.setVisibility(View.GONE);
                else
                    System.out.println(launchDetailsList.getLinks().flickrImages.toString());

                try {
                    if(launchDetailsList.getLinks().wikipedia.isEmpty())
                    b.setVisibility(View.GONE);
                }catch (Exception e){
                    b.setVisibility(View.GONE);
                    }

                try {
                    if(launchDetailsList.getLinks().videoLink.isEmpty())
                        b1.setVisibility(View.GONE);
                } catch (Exception e) {
                    b1.setVisibility(View.GONE);
                     }

                //System.out.println(launchDetailsList.toString());

            }

            @Override
            public void onFailure(Call<LaunchDetails> call, Throwable t) {
                System.out.println("Fail" + " " + t.getMessage());

            }
        });

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(flightnum).child("count").getValue(String.class) == null){

                    mDatabase.child(flightnum).child("count").setValue("1");
                    textView.setText("Number of Views: " + 1);
                }else{
                    int k = Integer.parseInt(dataSnapshot.child(flightnum).child("count").getValue(String.class));
                    mDatabase.child(flightnum).child("count").setValue(k+1);
                    String k2 = dataSnapshot.child(flightnum).child("count").getValue(String.class);
                    textView.setText("Number of Views: " + (Integer.parseInt(k2) + 1));
                }


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.wiki){

            WebView myWebView = new WebView(getApplicationContext());
            setContentView(myWebView);
            myWebView.loadUrl(s);

        }else if(v.getId() == R.id.yutup){
            WebView myWebView = new WebView(getApplicationContext());
            setContentView(myWebView);
            myWebView.loadUrl(s2);


        }else if(v.getId() == R.id.images){
            Intent i = new Intent(this,MissionPhotosActivity.class);
            i.putStringArrayListExtra("flick", (ArrayList<String>) s3);
            startActivity(i);

        }else if(v.getId() == R.id.lsite){
            Intent intent = new Intent(this, PadDetailsActivity.class);
            intent.putExtra("siteid",s4);
            startActivity(intent);
        }

    }
}
