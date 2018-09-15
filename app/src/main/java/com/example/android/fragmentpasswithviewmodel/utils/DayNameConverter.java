package com.example.android.fragmentpasswithviewmodel.utils;

import android.content.Context;

import com.example.android.fragmentpasswithviewmodel.R;

public class DayNameConverter {



    public String dayConverter(String day, Context context){

//        SharedPreferences settings= PreferenceManager.getDefaultSharedPreferences(this);
        if(day.equals("Monday")){
            day=context.getResources().getString(R.string.Monday);
        }else if(day.equals("Tuesday")){
            day=context.getResources().getString((R.string.Tuesday));
        }else if(day.equals("Wednesday")){
            day=context.getResources().getString((R.string.Tuesday));
        }else if(day.equals("Thursday")){
            day=context.getResources().getString((R.string.Tuesday));
        }else if(day.equals("Friday")){
            day=context.getResources().getString((R.string.Tuesday));
        }else if(day.equals("Saturday")){
            day=context.getResources().getString((R.string.Tuesday));
        }else if(day.equals("Sunday")){
            day=context.getResources().getString((R.string.Tuesday));
        }

        return day;
    }
}
