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
//        if (settings.getString("Lang_list_pref",null).equals("Romanian")){
//            if(day.equals("Monday")){
//                day=getResources().getString(R.string.Monday);
//            }else if(day.equals("Tuesday")){
//                day=getResources().getString((R.string.Tuesday));
//            }else if(day.equals("Wednesday")){
//                day=getResources().getString((R.string.Tuesday));
//            }else if(day.equals("Thursday")){
//                day=getResources().getString((R.string.Tuesday));
//            }else if(day.equals("Friday")){
//                day=getResources().getString((R.string.Tuesday));
//            }else if(day.equals("Saturday")){
//                day=getResources().getString((R.string.Tuesday));
//            }else if(day.equals("Sunday")){
//                day=getResources().getString((R.string.Tuesday));
//            }
//        }
//        else if(settings.getString("Lang_list_pref",null).equals("English")){
//
//        }else if (settings.getString("Lang_list_pref",null).equals("Croatian")) {
//            settings.getString("Lang_list_pref", null).equals("Croatian");
//        }

        return day;
    }
}
