package com.example.android.fragmentpasswithviewmodel.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.fragmentpasswithviewmodel.R;
import com.example.android.fragmentpasswithviewmodel.adapter.week.WeatherAdapter;
import com.example.android.fragmentpasswithviewmodel.model.week.WeatherDataList;
import com.example.android.fragmentpasswithviewmodel.model.week.WeatherList;
import com.example.android.fragmentpasswithviewmodel.network.GetWeatherDataService;
import com.example.android.fragmentpasswithviewmodel.network.RetrofitInstance;
import com.example.android.fragmentpasswithviewmodel.vm.SharedViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentWeek extends Fragment {


    private WeatherAdapter adapter;
    private RecyclerView recyclerView;
    GetWeatherDataService service = RetrofitInstance.getRetrofitInstance().create(GetWeatherDataService.class);


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.fragment_week, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedViewModel model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        Log.d("GOTHERE221112", "GOT HERE");

        model.getCity().observe(this, item -> {
            String cityName = item;

            /*Call the method with parameter in the interface to get the employee data*/
            Call<WeatherDataList> call = service.getWeekWeatherData(cityName, "metric", "7", GetWeatherDataService.API_KEY);

            /*Log the URL called*/


            call.enqueue(new Callback<WeatherDataList>() {
                @Override
                public void onResponse(Call<WeatherDataList> call, Response<WeatherDataList> response) {

                    if (response.code() == 200 && response.message().equals("OK")) {
                        generateWeatherList(response.body().getWeatherArrayList());
                    } else {
                        Log.d("FragmentWeek", "stoppedHere");
                    }
                }

                @Override
                public void onFailure(Call<WeatherDataList> call, Throwable t) {
                    Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                }
            });


        });

    }

    private void generateWeatherList(ArrayList<WeatherList> weatherDataList) {
        recyclerView = (RecyclerView) getView().findViewById(R.id.seven_day_recycler);

        adapter = new WeatherAdapter(weatherDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

}

