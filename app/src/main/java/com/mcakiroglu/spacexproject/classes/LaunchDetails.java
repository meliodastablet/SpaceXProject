package com.mcakiroglu.spacexproject.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LaunchDetails {

    @SerializedName("mission_name")
    @Expose
    public String missionName;
    @SerializedName("launch_year")
    @Expose
    public String launchYear;
    @SerializedName("flight_number")
    @Expose
    public Integer flightNumber;


    @SerializedName("launch_date_utc")
    @Expose
    public String launchDateUtc;
    @SerializedName("details")
    @Expose
    public Object details;


    @SerializedName("links")
    @Expose
    public Links links;

    @SerializedName("launch_site")
    @Expose
    public LaunchSite launchSite;

    @SerializedName("rocket")
    @Expose
    public Rocket rocket;

    @Override
    public String toString() {
        return "LaunchDetails{" +
                "missionName='" + missionName + '\'' +
                ", launchYear='" + launchYear + '\'' +
                ", flightNumber=" + flightNumber +


                ", launchDateUtc='" + launchDateUtc + '\'' +
                ", details=" + details +
                ", links=" + links.toString() +
                ", launchSite=" + launchSite.toString() +
                ", rocket=" + rocket.toString() +
                '}';
    }
}
