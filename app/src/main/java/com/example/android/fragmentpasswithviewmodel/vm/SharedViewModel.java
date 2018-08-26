package com.example.android.fragmentpasswithviewmodel.vm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<String> city = new MutableLiveData<>();

    public void sendCity(String item) {
        city.setValue(item);
    }

    public LiveData<String> getCity() {
        return city;
    }
}