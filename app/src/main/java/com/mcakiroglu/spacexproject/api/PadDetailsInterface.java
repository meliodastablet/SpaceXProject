package com.mcakiroglu.spacexproject.api;

import com.mcakiroglu.spacexproject.classes.LaunchPadDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PadDetailsInterface {

    @GET("launchpads/{site_id}")
    Call<LaunchPadDetails> getPadDetails(@Path(value = "site_id",encoded = true) String site_id);
}
