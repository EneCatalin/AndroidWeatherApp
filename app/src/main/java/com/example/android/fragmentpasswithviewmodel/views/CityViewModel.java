package com.example.android.fragmentpasswithviewmodel.views;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.android.fragmentpasswithviewmodel.model.city.City;
import com.example.android.fragmentpasswithviewmodel.model.city.CityRepository;

import java.util.List;

public class CityViewModel extends AndroidViewModel {

    private CityRepository mRepository;

    private LiveData<List<City>> mAllCities;

    public CityViewModel(Application application) {
        super(application);
        mRepository = new CityRepository(application);
        mAllCities = mRepository.getAllCities();
    }


    LiveData<List<City>> getmAllCities() { return mAllCities; }

    public void insert(City city) { mRepository.insert(city); }


    public LiveData getAllcities() {
        return mAllCities;
    }

    public void deleteAll() {mRepository.deleteAll();}
    public void deleteWord(City city) {mRepository.deleteCity(city);}
}
