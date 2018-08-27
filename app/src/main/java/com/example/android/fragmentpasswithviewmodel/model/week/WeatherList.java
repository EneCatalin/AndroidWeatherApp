
package com.example.android.fragmentpasswithviewmodel.model.week;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherList {

    @SerializedName("dt")
    @Expose
    private Integer dt;
    @SerializedName("temp")
    @Expose
    private Temp temp;
    @SerializedName("pressure")
    @Expose
    private Float pressure;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;
    @SerializedName("weather")
    @Expose
    private java.util.List<Weather> weather = null;
    @SerializedName("speed")
    @Expose
    private Float speed;
    @SerializedName("deg")
    @Expose
    private Integer deg;
    @SerializedName("clouds")
    @Expose
    private Integer clouds;
    @SerializedName("snow")
    @Expose
    private Float snow;

    /**
     * No args constructor for use in serialization
     * 
     */
    public WeatherList() {
    }

    /**
     * 
     * @param clouds
     * @param dt
     * @param humidity
     * @param pressure
     * @param speed
     * @param snow
     * @param deg
     * @param weather
     * @param temp
     */
    public WeatherList(Integer dt, Temp temp, Float pressure, Integer humidity, java.util.List<Weather> weather, Float speed, Integer deg, Integer clouds, Float snow) {
        super();
        this.dt = dt;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.weather = weather;
        this.speed = speed;
        this.deg = deg;
        this.clouds = clouds;
        this.snow = snow;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public WeatherList withDt(Integer dt) {
        this.dt = dt;
        return this;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public WeatherList withTemp(Temp temp) {
        this.temp = temp;
        return this;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public WeatherList withPressure(Float pressure) {
        this.pressure = pressure;
        return this;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public WeatherList withHumidity(Integer humidity) {
        this.humidity = humidity;
        return this;
    }

    public java.util.List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    public WeatherList withWeather(java.util.List<Weather> weather) {
        this.weather = weather;
        return this;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public WeatherList withSpeed(Float speed) {
        this.speed = speed;
        return this;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    public WeatherList withDeg(Integer deg) {
        this.deg = deg;
        return this;
    }

    public Integer getClouds() {
        return clouds;
    }

    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    public WeatherList withClouds(Integer clouds) {
        this.clouds = clouds;
        return this;
    }

    public Float getSnow() {
        return snow;
    }

    public void setSnow(Float snow) {
        this.snow = snow;
    }

    public WeatherList withSnow(Float snow) {
        this.snow = snow;
        return this;
    }

}
