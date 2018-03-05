package com.example.codepath.moviesinterview.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

//import static clojure.lang.RT.set;

/**
 * Created by gretel on 2/28/18.
 */

public class ProductionCompanies implements Parcelable {

    private Long producerId;
    private String name;

    protected ProductionCompanies(){

    }

    public ProductionCompanies(JSONObject jsonObject) throws JSONException {
        this();
        if (jsonObject.has("id")) setProducerId(jsonObject.getLong("id"));
        if (jsonObject.has("name")) setName(jsonObject.getString("name"));
    }

    protected ProductionCompanies(Parcel in){
        producerId = in.readLong();
        name = in.readString();
    }

    public static final Creator<ProductionCompanies> CREATOR = new Creator<ProductionCompanies>() {
        @Override
        public ProductionCompanies createFromParcel(Parcel in) {
            return new ProductionCompanies(in);
        }

        @Override
        public ProductionCompanies[] newArray(int size) {
            return new ProductionCompanies[size];
        }
    };

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(producerId);
        dest.writeString(name);

    }
}
