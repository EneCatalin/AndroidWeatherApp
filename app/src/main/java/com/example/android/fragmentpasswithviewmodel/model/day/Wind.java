
package com.example.android.fragmentpasswithviewmodel.model.day;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    @Expose
    private Float speed;
    @SerializedName("deg")
    @Expose
    private Integer deg;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Wind() {
    }

    /**
     * 
     * @param speed
     * @param deg
     */
    public Wind(Float speed, Integer deg) {
        super();
        this.speed = speed;
        this.deg = deg;
    }

    public int getSpeed() {
        return Math.round(speed);
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Wind withSpeed(Float speed) {
        this.speed = speed;
        return this;
    }

    public Integer getDeg() {
        return Math.round(deg);
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    public Wind withDeg(Integer deg) {
        this.deg = deg;
        return this;
    }

}
