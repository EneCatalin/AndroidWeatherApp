package com.example.android.fragmentpasswithviewmodel.network;

import com.example.android.fragmentpasswithviewmodel.model.day.DayLongWeather;
import com.example.android.fragmentpasswithviewmodel.model.week.WeatherDataList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface GetWeatherDataService {

//    @GET("daily?q=London&units=metric&q=7&APPID=944c4ecad48b3a0ab486b55e2eba2130")
//    Call<WeatherDataList> getWeekWeatherData(
//    );

    @GET
    Call<WeatherDataList> getWeekWeatherData(@Url String url);



    String API_KEY = "944c4ecad48b3a0ab486b55e2eba2130";

    @GET("forecast/daily")
    Call<WeatherDataList> getWeekWeatherData(@Query("q") String city, @Query("units") String units,
                                             @Query("count") String count, @Query("APPID") String key);


    @GET("weather")
    Call<DayLongWeather> getOneDayWeatherData(@Query("q") String city, @Query("units") String units,
                                              @Query("APPID") String key);

}
