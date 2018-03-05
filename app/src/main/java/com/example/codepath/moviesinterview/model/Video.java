package com.example.codepath.moviesinterview.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gretel on 2/28/18.
 */

public class Video implements Parcelable {

    private String videoId;
    private String name;
    private String key;
    private String site;

    protected Video(){

    }

    public Video(JSONObject jsonObject) throws JSONException{
        this();

        if(jsonObject.has("id")) setVideoId(jsonObject.getString("id"));
        if(jsonObject.has("name")) setName(jsonObject.getString("name"));
        if(jsonObject.has("key")) setKey(jsonObject.getString("key"));
        if(jsonObject.has("site")) setSite(jsonObject.getString("site"));
    }

    protected Video(Parcel in){
        videoId = in.readString();
        name = in.readString();
        key = in.readString();
        site = in.readString();
    }

    public static final Creator<Video> CREATOR = new Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
        }
    };

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(videoId);
        dest.writeString(name);
        dest.writeString(key);
        dest.writeString(site);

    }
}
