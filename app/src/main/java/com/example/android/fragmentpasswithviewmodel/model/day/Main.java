
package com.example.android.fragmentpasswithviewmodel.model.day;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    @Expose
    private Float temp;
    @SerializedName("pressure")
    @Expose
    private Integer pressure;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;
    @SerializedName("temp_min")
    @Expose
    private Float tempMin;
    @SerializedName("temp_max")
    @Expose
    private Float tempMax;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Main() {
    }

    /**
     * 
     * @param humidity
     * @param pressure
     * @param tempMax
     * @param temp
     * @param tempMin
     */
    public Main(Float temp, Integer pressure, Integer humidity, Float tempMin, Float tempMax) {
        super();
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }

    public int getTemp() {
        return Math.round(temp);
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Main withTemp(Float temp) {
        this.temp = temp;
        return this;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Main withPressure(Integer pressure) {
        this.pressure = pressure;
        return this;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Main withHumidity(Integer humidity) {
        this.humidity = humidity;
        return this;
    }

    public int getTempMin() {
        return Math.round(tempMin);
    }

    public void setTempMin(Float tempMin) {
        this.tempMin = tempMin;
    }

    public Main withTempMin(Float tempMin) {
        this.tempMin = tempMin;
        return this;
    }

    public int getTempMax() {
        return Math.round(tempMax);
    }

    public void setTempMax(Float tempMax) {
        this.tempMax = tempMax;
    }

    public Main withTempMax(Float tempMax) {
        this.tempMax = tempMax;
        return this;
    }

}
