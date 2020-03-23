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

    public String getLaunchDateUtc() {
        return launchDateUtc;
    }

    public void setLaunchDateUtc(String launchDateUtc) {
        this.launchDateUtc = launchDateUtc;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public LaunchSite getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(LaunchSite launchSite) {
        this.launchSite = launchSite;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }
}
