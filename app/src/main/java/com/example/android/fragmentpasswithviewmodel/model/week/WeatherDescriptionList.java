package com.example.android.fragmentpasswithviewmodel.model.week;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherDescriptionList {
    @SerializedName("weather")
    private ArrayList<Weather> weatherDescriptionList;

    public ArrayList<Weather> getWeatherDescriptionList() {
        return weatherDescriptionList;
    }

    public void setWeatherDescriptionList(ArrayList<Weather> weatherDescriptionList) {
        this.weatherDescriptionList = weatherDescriptionList;
    }
}
