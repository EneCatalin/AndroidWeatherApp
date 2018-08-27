package com.example.android.fragmentpasswithviewmodel.model.city;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "city_table")
public class City {



    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "city")
    private String mCity;

    public City(@NonNull String city) {
        this.mCity = city;
    }

    public String getCity(){
        return this.mCity;
    }

}
