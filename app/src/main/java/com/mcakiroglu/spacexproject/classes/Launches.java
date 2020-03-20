package com.mcakiroglu.spacexproject.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Launches {

    @SerializedName("mission_name")
    @Expose
    public String missionName;
    @SerializedName("launch_year")
    @Expose
    public String launchYear;
    @SerializedName("flight_number")
    @Expose
    public Integer flightNumber;

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }
}
