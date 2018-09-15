package com.example.android.fragmentpasswithviewmodel.utils;

import android.content.Context;

import com.example.android.fragmentpasswithviewmodel.R;

public class weatherStatusConverter {
    public String weatherStatusConverter(String weatherStatus, Context context){

//        SharedPreferences settings= PreferenceManager.getDefaultSharedPreferences(this);
        if(weatherStatus.equals("clear")){
            weatherStatus=context.getResources().getString(R.string.Monday);
        }else if(weatherStatus.equals("drizzle")){
            weatherStatus=context.getResources().getString((R.string.Tuesday));
        }else if(weatherStatus.equals("rain")){
            weatherStatus=context.getResources().getString((R.string.Tuesday));
        }else if(weatherStatus.equals("thunderstorm")){
            weatherStatus=context.getResources().getString((R.string.Tuesday));
        }else if(weatherStatus.equals("snow")){
            weatherStatus=context.getResources().getString((R.string.Tuesday));
        }

        return weatherStatus;
    }

}
