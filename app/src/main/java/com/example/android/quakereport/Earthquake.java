package com.example.android.quakereport;

/**
 * Created by Md Rana Mahmud on 1/12/2018.
 */

public class Earthquake {
    private String magnitude;
    private String location;
    private String date;

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Earthquake(String magnitude, String location, String date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }
}
