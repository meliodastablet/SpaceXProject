package com.mcakiroglu.spacexproject.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rocket {


    @SerializedName("rocket_name")
    @Expose
    public String rocketName;

    @Override
    public String toString() {
        return "Rocket{" +
                "rocketName='" + rocketName + '\'' +
                '}';
    }
}