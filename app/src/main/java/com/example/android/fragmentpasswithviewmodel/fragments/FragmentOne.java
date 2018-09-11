package com.example.android.fragmentpasswithviewmodel.fragments;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.android.fragmentpasswithviewmodel.MainActivity;
import com.example.android.fragmentpasswithviewmodel.R;
import com.example.android.fragmentpasswithviewmodel.adapter.city.CityListAdapter;
import com.example.android.fragmentpasswithviewmodel.model.city.City;
import com.example.android.fragmentpasswithviewmodel.service.ItemCheckListener;
import com.example.android.fragmentpasswithviewmodel.service.ItemClickListener;
import com.example.android.fragmentpasswithviewmodel.views.CityViewModel;
import com.example.android.fragmentpasswithviewmodel.vm.SharedViewModel;

import java.util.List;

public class FragmentOne extends Fragment {

    private CityViewModel mCityViewModel;
    RadioButton cityCheck;

    private SharedViewModel model;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_one, container, false);
        return rootView;


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        final EditText inData = (EditText) view.findViewById(R.id.inMessage);
        cityCheck=(RadioButton) view.findViewById(R.id.city_status_radio_btn);

        /**RecyclerView and database stuff here. I really need to start commenting this*/
        mCityViewModel = ViewModelProviders.of(this).get(CityViewModel.class);




        /**this lets the user press X and the city disappears, poof */
        ItemClickListener listener = new ItemClickListener()
        {
            @Override
            public void onItemClicked(RecyclerView.ViewHolder vh, City city, int pos)
            {
//                mCityViewModel.deleteCity(item.toString());
                mCityViewModel.deleteCity(city.getCity());

                /**Hides the keyboard so it doesn't drive the user nuts**/
                InputMethodManager inputManager = (InputMethodManager)
                        getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputManager != null) {
                    inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        };


        /**the overall app needs to get modified but anyway, this will fetch information about
         * the checked (via radio) city**/
        ItemCheckListener checkListener = new ItemCheckListener()
        {
            @Override
            public void onItemClicked(RecyclerView.ViewHolder vh, City city, int pos)
            {
//                Toast.makeText(getActivity(), "Item clicked: " + pos, Toast.LENGTH_LONG).show();


                /**sends the city**/
                model.sendCity(city.getCity());
                ((MainActivity) getActivity())
                        .setActionBarTitle(city.getCity());

                /**Hides the keyboard so it doesn't drive the user nuts**/
                InputMethodManager inputManager = (InputMethodManager)
                        getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputManager != null) {
                    inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }


            }
        };


        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);

        CityListAdapter adapter = new CityListAdapter(getContext(),listener,checkListener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    /**checks if any cities are added/deleted*/
        mCityViewModel.getAllcities().observe(this, new Observer<List<City>>() {
        @Override
        public void onChanged(@Nullable final List<City> words) {
            // Update the cached copy of the words in the adapter.
            adapter.setCities(words);

        }
        });


        Button buttonX = (Button)view.findViewById(R.id.btnPassData);
        buttonX.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {


                /**shows dialogue telling you to enter a city
                 * makes sure not to enter an empty string but atm doesn't check
                 * for anything else**/
                if(inData.getText().toString().equals("")){
                    AlertDialog.Builder ab = new AlertDialog.Builder(getContext());
                    ab.setMessage("No city entered");
                    ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent in=new Intent(getContext(), MainActivity.class);

                    }
                });
                    ab.create().show();
                }
                else{
                    /**SHOULD ADD A CITY**/
                    City city = new City(inData.getText().toString());
                    mCityViewModel.insert(city);
                }


                /**HIDES THE KEYBOARD**/
                InputMethodManager inputManager = (InputMethodManager)
                        getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.toggleSoftInput(0, 0);
                adapter.notifyDataSetChanged();



            }
        });

    }

}

