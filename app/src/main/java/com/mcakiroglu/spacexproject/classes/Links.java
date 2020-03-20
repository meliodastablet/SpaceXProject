package com.mcakiroglu.spacexproject.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Links {

    @SerializedName("mission_patch")
    @Expose
    public String missionPatch;

    @SerializedName("wikipedia")
    @Expose
    public String wikipedia;
    @SerializedName("video_link")
    @Expose
    public String videoLink;

    @SerializedName("flickr_images")
    @Expose
    public List<Object> flickrImages = null;


    @Override
    public String toString() {
        return "Links{" +
                "missionPatch='" + missionPatch + '\'' +
                ", wikipedia='" + wikipedia + '\'' +
                ", videoLink='" + videoLink + '\'' +
                ", flickrImages=" + flickrImages +
                '}';
    }
}
