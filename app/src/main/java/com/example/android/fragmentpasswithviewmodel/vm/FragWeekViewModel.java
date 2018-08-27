package com.example.android.fragmentpasswithviewmodel.vm;

import android.arch.lifecycle.ViewModel;

public class FragWeekViewModel extends ViewModel {

    public String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
