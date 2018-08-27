
package com.example.android.fragmentpasswithviewmodel.model.week;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeekLongWeather {

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Integer message;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("weatherList")
    @Expose
    private java.util.List<WeatherList> weatherList = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public WeekLongWeather() {
    }

    /**
     * 
     * @param message
     * @param cnt
     * @param cod
     * @param weatherList
     * @param city
     */
    public WeekLongWeather(String cod, Integer message, City city, Integer cnt, java.util.List<WeatherList> weatherList) {
        super();
        this.cod = cod;
        this.message = message;
        this.city = city;
        this.cnt = cnt;
        this.weatherList = weatherList;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public WeekLongWeather withCod(String cod) {
        this.cod = cod;
        return this;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public WeekLongWeather withMessage(Integer message) {
        this.message = message;
        return this;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public WeekLongWeather withCity(City city) {
        this.city = city;
        return this;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public WeekLongWeather withCnt(Integer cnt) {
        this.cnt = cnt;
        return this;
    }

    public java.util.List<WeatherList> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(java.util.List<WeatherList> weatherList) {
        this.weatherList = weatherList;
    }

    public WeekLongWeather withList(java.util.List<WeatherList> weatherList) {
        this.weatherList = weatherList;
        return this;
    }

}
