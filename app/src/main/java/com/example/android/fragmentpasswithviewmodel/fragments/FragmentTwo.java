package com.example.android.fragmentpasswithviewmodel.fragments;


import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.fragmentpasswithviewmodel.MainActivity;
import com.example.android.fragmentpasswithviewmodel.R;
import com.example.android.fragmentpasswithviewmodel.model.day.DayLongWeather;
import com.example.android.fragmentpasswithviewmodel.network.GetWeatherDataService;
import com.example.android.fragmentpasswithviewmodel.network.RetrofitInstance;
import com.example.android.fragmentpasswithviewmodel.vm.SharedViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentTwo extends Fragment {
    TextView txtData;

    GetWeatherDataService service = RetrofitInstance.getRetrofitInstance().create(GetWeatherDataService.class);


    // Class name for Log tag
    private static final String LOG_TAG = FragmentTwo.class.getSimpleName();

    private ImageView mWeatherImage;
    private TextView mDaily_weather_temperature;
    private TextView mDaily_weather_weather_description;
    private TextView mDaily_weather_min;
    private TextView mDaily_weather_max;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.fragment_three, container, false);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedViewModel model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        model.getCity().observe(this, (String item) -> {
            txtData = (TextView)view.findViewById(R.id.cityData);
            txtData.setText(item);
            Log.d("PRIMIT", item);



            // Get the intent that launched this activity, and the message in
            // the intent extra.

            //TODO DELETE THIS and implement the check in the main activity

            String cityName = item;
            //Shows a popup if no city was inserted and sends the user back to Main. DELETE
            if(cityName.equals("")){
                AlertDialog.Builder ab = new AlertDialog.Builder(getContext());
                ab.setMessage("No city entered");
                ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent in=new Intent(getContext(), MainActivity.class);
                        FragmentTwo.this.startActivity(in);
                    }
                });
                ab.create().show();
            }

            mWeatherImage=view.findViewById(R.id.daily_weather_icon);
            mDaily_weather_temperature=view.findViewById(R.id.daily_weather_temperature);
            mDaily_weather_weather_description=view.findViewById(R.id.daily_weather_weather_description);
            mDaily_weather_max=view.findViewById(R.id.daily_weather_max);
            mDaily_weather_min=view.findViewById(R.id.daily_weather_min);




            Call<DayLongWeather> call = service.getOneDayWeatherData(cityName, "metric",GetWeatherDataService.API_KEY);

            /*Log the URL called*/
            Log.wtf("URL Called", call.request().url() + "");

            call.enqueue(new Callback<DayLongWeather>() {

                @Override
                public void onResponse(Call<DayLongWeather> call, Response<DayLongWeather> response) {
                    assert response.body() != null;


                    Log.d("ENTERED IF", String.valueOf(response.body().getCod()));

                    DayLongWeather dayLongWeather= response.body();
                    mDaily_weather_temperature.setText(Integer.toString(dayLongWeather.getMain().getTemp()));
                    mDaily_weather_weather_description.setText(dayLongWeather.getWeather().get(0).getMain());
                    mDaily_weather_max.setText(Integer.toString(dayLongWeather.getMain().getTempMax()));
                    mDaily_weather_min.setText(Integer.toString(dayLongWeather.getMain().getTempMin()));
                    mWeatherImage.setImageResource(getWeatherId(dayLongWeather.getWeather().get(0).getId()));

                }

                @Override
                public void onFailure(Call<DayLongWeather> call, Throwable t) {
                    Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    t.printStackTrace();
                }
            });






        });
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
