package com.mcakiroglu.spacexproject.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LaunchSite {


    @SerializedName("site_name")
    @Expose
    public String siteName;

    @SerializedName("site_id")
    @Expose
    public String siteId;

    @Override
    public String toString() {
        return "LaunchSite{" +
                "siteName='" + siteName + '\'' +
                ", siteId='" + siteId + '\'' +
                '}';
    }
}

