
package com.example.android.fragmentpasswithviewmodel.model.week;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Temp {

    @SerializedName("day")
    @Expose
    private Float day;
    @SerializedName("min")
    @Expose
    private Float min;
    @SerializedName("max")
    @Expose
    private Float max;
    @SerializedName("night")
    @Expose
    private Float night;
    @SerializedName("eve")
    @Expose
    private Float eve;
    @SerializedName("morn")
    @Expose
    private Float morn;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Temp() {
    }

    /**
     * 
     * @param min
     * @param eve
     * @param max
     * @param morn
     * @param night
     * @param day
     */
    public Temp(Float day, Float min, Float max, Float night, Float eve, Float morn) {
        super();
        this.day = day;
        this.min = min;
        this.max = max;
        this.night = night;
        this.eve = eve;
        this.morn = morn;
    }

    public int getDay() {
        return Math.round(day);
    }

    public void setDay(Float day) {
        this.day = day;
    }

    public Temp withDay(Float day) {
        this.day = day;
        return this;
    }

    public Float getMin() {
        return min;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public Temp withMin(Float min) {
        this.min = min;
        return this;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }

    public Temp withMax(Float max) {
        this.max = max;
        return this;
    }

    public int getNight() {
        return Math.round(night);
    }

    public void setNight(Float night) {
        this.night = night;
    }

    public Temp withNight(Float night) {
        this.night = night;
        return this;
    }

    public Float getEve() {
        return eve;
    }

    public void setEve(Float eve) {
        this.eve = eve;
    }

    public Temp withEve(Float eve) {
        this.eve = eve;
        return this;
    }

    public Float getMorn() {
        return morn;
    }

    public void setMorn(Float morn) {
        this.morn = morn;
    }

    public Temp withMorn(Float morn) {
        this.morn = morn;
        return this;
    }

}
