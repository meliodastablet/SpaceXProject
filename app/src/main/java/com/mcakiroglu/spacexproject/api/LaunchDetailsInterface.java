package com.mcakiroglu.spacexproject.api;



import com.mcakiroglu.spacexproject.classes.LaunchDetails;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LaunchDetailsInterface {

    @GET("launches/{flight_number}")
    Call<LaunchDetails> getLaunchDetails(@Path(value = "flight_number",encoded = true) String flight_number);
}
