package com.example.android.fragmentpasswithviewmodel.fragments;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.fragmentpasswithviewmodel.R;
import com.example.android.fragmentpasswithviewmodel.adapter.city.CityListAdapter;
import com.example.android.fragmentpasswithviewmodel.model.city.City;
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

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);

        CityListAdapter adapter = new CityListAdapter(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        mCityViewModel.getAllcities().observe(this, new Observer<List<City>>() {
            @Override
            public void onChanged(@Nullable final List<City> words) {
                // Update the cached copy of the words in the adapter.
                adapter.setCities(words);
            }
        });

// Add the functionality to swipe items in the
        // recycler view to delete that item
        ItemTouchHelper helper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0,
                        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView,
                                          RecyclerView.ViewHolder viewHolder,
                                          RecyclerView.ViewHolder target) {
                        return false;
                    }



                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder,
                                         int direction) {
                        int position = viewHolder.getAdapterPosition();
                        City mCity = adapter.getCityAtPosition(position);
                        Toast.makeText(getContext(), "Deleting " +
                                mCity.getCity(), Toast.LENGTH_LONG).show();

                        // Delete the word
                        mCityViewModel.deleteWord(mCity);
                    }


                });

        helper.attachToRecyclerView(recyclerView);



        Button buttonX = (Button)view.findViewById(R.id.btnPassData);
        buttonX.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
//                Log.d("TRIMIS",inData.getText().toString());
                model.sendCity(inData.getText().toString());
                //DO SOMETHING! {RUN SOME FUNCTION ... DO CHECKS... ETC}

                /**SHOULD ADD A CITY**/
                City city = new City(inData.getText().toString());
                mCityViewModel.insert(city);


                /**HIDES THE KEYBOARD**/
                InputMethodManager inputManager = (InputMethodManager)
                        getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.toggleSoftInput(0, 0);
                adapter.notifyDataSetChanged();




            }
        });




    }
}

