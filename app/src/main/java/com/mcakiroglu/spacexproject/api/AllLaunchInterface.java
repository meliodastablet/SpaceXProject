package com.mcakiroglu.spacexproject.api;



import com.mcakiroglu.spacexproject.classes.Launches;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AllLaunchInterface {


    @GET("launches/")
    Call<List<Launches>> getLaunches();
}
