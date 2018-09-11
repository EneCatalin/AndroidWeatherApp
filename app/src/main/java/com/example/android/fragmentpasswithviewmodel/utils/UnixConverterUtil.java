package com.example.android.fragmentpasswithviewmodel.utils;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UnixConverterUtil {


    SimpleDateFormat sdf = new SimpleDateFormat("EEEE");

    public String timeConverter(String unixTime) {
        Date dateFormat = new java.util.Date(Long.parseLong(unixTime)*1000);

        Log.d("UNIXTIME", String.valueOf(sdf.format(dateFormat)));
        String weekday=sdf.format(dateFormat);
        return weekday;
    }
}
