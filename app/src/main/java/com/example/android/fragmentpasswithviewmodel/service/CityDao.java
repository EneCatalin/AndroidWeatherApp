package com.example.android.fragmentpasswithviewmodel.service;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.android.fragmentpasswithviewmodel.model.city.City;

import java.util.List;

@Dao
public interface CityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(City city);

    @Query("DELETE FROM city_table")
    void deleteAll();

    @Query("SELECT * from city_table ORDER BY city ASC")
    LiveData<List<City>> getAllCities();

    @Query("SELECT * from city_table LIMIT 1")
    City[] getAnyCity();

    /**we get a string with the city name*/
    @Query("DELETE FROM city_table WHERE city=:city")
    void deleteCity(String city);
}
