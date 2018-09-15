package com.example.android.fragmentpasswithviewmodel.adapter.week;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.fragmentpasswithviewmodel.R;
import com.example.android.fragmentpasswithviewmodel.model.week.WeatherList;
import com.example.android.fragmentpasswithviewmodel.utils.DayNameConverter;
import com.example.android.fragmentpasswithviewmodel.utils.UnixConverterUtil;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private ArrayList<WeatherList> weatherList;

    public WeatherAdapter(ArrayList<WeatherList> weatherList) {
        this.weatherList = weatherList;
    }


    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_weather_row, parent, false);
        return new WeatherViewHolder(view);
    }


    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {

//        holder.mDayOfTheWeek.setText(UnixConverterUtil(we));


        if(position == 0){
            holder.mDayOfTheWeek.setText(R.string.Today);
        }else {
            holder.mDayOfTheWeek.setText(new DayNameConverter().dayConverter((String.valueOf
                            (new UnixConverterUtil().timeConverter(
                    String.valueOf(weatherList.get(position).getDt()))))
                    ,holder.mDayOfTheWeek.getContext()));
        }
        
        holder.mWeatherDescr.setText(weatherList.get(position).getWeather().get(0).getMain());
        holder.mDayWeather.setText(Integer.toString(weatherList.get(position).getTemp().getDay()));
        holder.mNightWeather.setText(Integer.toString(weatherList.get(position).getTemp().getNight()));
        holder.mWeatherImage.setImageResource(getWeatherId(weatherList.get(position).getWeather().get(0).getId()));
        weatherList.get(position).getWeather().get(0).getId();

    }


    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder {

        TextView mWeatherDescr;
        TextView mDayWeather;
        TextView mNightWeather;
        ImageView mWeatherImage;
        TextView mDayOfTheWeek;

        WeatherViewHolder(View itemView) {
            super(itemView);
            mDayOfTheWeek=(TextView) itemView.findViewById(R.id.Day_of_the_week);
            mWeatherDescr = (TextView) itemView.findViewById(R.id.main_weather_description_of_weekday);
            mDayWeather = (TextView) itemView.findViewById(R.id.day_temp);
            mNightWeather = (TextView) itemView.findViewById(R.id.night_temp);
            mWeatherImage =(ImageView) itemView.findViewById(R.id.weather_Icon);
        }
    }


    private static int getWeatherId(int apiId) {
        // http://bugs.openweathermap.org/projects/api/wiki/Weather_Condition_Codes
        if (apiId >= 200 && apiId <= 232) {
            return R.drawable.weather_icon_storm_cloud_symbol_with_lightning_bolt_and_hail;
        } else if (apiId >= 300 && apiId <= 321) {
            return R.drawable.weather_icon_rainy_day;
        } else if (apiId >= 500 && apiId <= 504) {
            return R.drawable.weather_icon_cloud_with_rain_drops;
        } else if (apiId == 511) {
            return R.drawable.weather_icon_storm_cloud_symbol_with_lightning_bolt_and_hail;
        } else if (apiId >= 520 && apiId <= 531) {
            return R.drawable.weather_icon_storm_cloud_symbol_with_lightning_bolt_and_hail;
        } else if (apiId >= 600 && apiId <= 622) {
            return R.drawable.weather_icon_snow_weather_symbol;
        } else if (apiId >= 701 && apiId <= 761) {
            return R.drawable.weather_icon_cloud_with_hail;
        } else if (apiId == 800) {
            return R.drawable.weather_icon_rising_sun;
        } else if (apiId == 801) {
            return R.drawable.weather_icon_cloudy_day;
        }
        else if(apiId>801)
        {
            return R.drawable.weather_icon_cloudy_day;
        }
        return apiId;
    }
}