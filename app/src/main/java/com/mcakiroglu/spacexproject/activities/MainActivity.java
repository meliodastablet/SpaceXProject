package com.mcakiroglu.spacexproject.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mcakiroglu.spacexproject.R;
import com.mcakiroglu.spacexproject.api.AllLaunchInterface;
import com.mcakiroglu.spacexproject.api.ApiClient;
import com.mcakiroglu.spacexproject.classes.Launches;
import com.mcakiroglu.spacexproject.adapters.RecyclerViewAdapter;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AllLaunchInterface allLaunchInterface;
    EditText editText;
    Button button;
    RecyclerView recyclerView;
    List<Launches> launchesList = new ArrayList<>();
    List<Launches> searchList = new ArrayList<>();
    String s = "1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            editText = (EditText) findViewById(R.id.search);
           findViewById(R.id.button).setOnClickListener(this);

            allLaunchInterface = ApiClient.getClient().create(AllLaunchInterface.class);

            Call<List<Launches>> call = allLaunchInterface.getLaunches();

            call.enqueue(new Callback<List<Launches>>() {
                @Override
                public void onResponse(Call<List<Launches>> call, Response<List<Launches>> response) {


                    launchesList = response.body();
                    //adapterSet(launchesList);

                    LinearLayoutManager layoutManaget = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(layoutManaget);
                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainActivity.this,launchesList);
                    recyclerView.setAdapter(adapter);




                }

                @Override
                public void onFailure(Call<List<Launches>> call, Throwable t) {
                    System.out.println("Fail");
                }
            });







    }

    List<Launches> searchMission(String name, List<Launches> launchesList){
        searchList.clear();

        for(int i =0; i < launchesList.size();i++){
            if(containsIgnoreCase(launchesList.get(i).missionName,name))
                searchList.add(launchesList.get(i));

        }
            return searchList;


    }
    @Override
    public void onClick(View v){


        if(v.getId() == R.id.button){
            if(editText.getText() != null) {

                searchList =searchMission(editText.getText().toString(),launchesList);
                if(searchList.isEmpty()){
                    Toast.makeText(this, "No result found with the given parameters...", Toast.LENGTH_SHORT).show();
                }else{
                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainActivity.this,searchList);
                    recyclerView.setAdapter(null);
                    recyclerView.setAdapter(adapter);
                }
            }

        }

    }
}
