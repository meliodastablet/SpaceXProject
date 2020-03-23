package com.mcakiroglu.spacexproject.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mcakiroglu.spacexproject.R;
import com.mcakiroglu.spacexproject.adapters.ImageRecycleAdapter;

import java.util.ArrayList;

public class MissionPhotosActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missionphotos);

        recyclerView = (RecyclerView) findViewById(R.id.rview);

        ArrayList<String> flick = getIntent().getStringArrayListExtra("flick");
        System.out.println(flick.toString());


        LinearLayoutManager layoutManaget = new LinearLayoutManager(MissionPhotosActivity.this);
        recyclerView.setLayoutManager(layoutManaget);
        ImageRecycleAdapter adapter = new ImageRecycleAdapter(MissionPhotosActivity.this,flick);
        recyclerView.setAdapter(adapter);
    }
}
