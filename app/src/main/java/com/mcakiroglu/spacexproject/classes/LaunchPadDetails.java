package com.mcakiroglu.spacexproject.classes;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LaunchPadDetails {



    @SerializedName("location")
    @Expose
    public Location location;
    @SerializedName("details")
    @Expose
    public String details;
    @SerializedName("site_id")
    @Expose
    public String siteId;

    public Location getLocation() {
        return location;
    }

    public String getDetails() {
        return details;
    }

    public String getSiteId() {
        return siteId;
    }

    @Override
    public String toString() {
        return "LaunchPadDetails{" +
                "location=" + location.toString() +
                ", details='" + details + '\'' +
                ", siteId='" + siteId + '\'' +
                '}';
    }
}
