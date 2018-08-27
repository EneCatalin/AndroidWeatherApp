package com.example.android.fragmentpasswithviewmodel.model.week;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherDataList {
    @SerializedName("cod")
    private String cod;

    @SerializedName("list")
    private ArrayList<WeatherList> weatherList;

    public ArrayList<WeatherList> getWeatherArrayList() {
        return weatherList;
    }

    public void setEmployeeArrayList(ArrayList<WeatherList> weatherArrayList) {
        this.weatherList = weatherArrayList;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }



}
