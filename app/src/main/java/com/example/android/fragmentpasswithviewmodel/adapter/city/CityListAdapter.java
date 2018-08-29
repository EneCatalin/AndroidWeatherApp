package com.example.android.fragmentpasswithviewmodel.adapter.city;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.android.fragmentpasswithviewmodel.R;
import com.example.android.fragmentpasswithviewmodel.model.city.City;

import java.util.List;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.CityViewHolder> { ;
    private String lastSelectedCity="";

    private final LayoutInflater mInflater;
    private List<City> mCities; // Cached copy of words

    public CityListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_city_row, parent, false);
        return new CityViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        if (mCities != null) {
            City current = mCities.get(position);
            holder.cityItemView.setText(current.getCity());

        } else {
            // Covers the case of data not being ready yet.
            holder.cityItemView.setText("No City");
        }
        holder.selectionState.setChecked(lastSelectedCity.equals((String) holder.cityItemView.getText()));


    }

    public void setCities(List<City> words){
        mCities = words;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mCities has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mCities != null)
            return mCities.size();
        else return 0;
    }

    class CityViewHolder extends RecyclerView.ViewHolder {
        public RadioButton selectionState;

        //THIS USED TO BE private FIANAL
        private  TextView cityItemView;


        private CityViewHolder(View itemView) {
            super(itemView);
            cityItemView = itemView.findViewById(R.id.CityName);
            selectionState = (RadioButton) itemView.findViewById(R.id.city_status_radio_btn);


            selectionState.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastSelectedCity=cityItemView.getText().toString();
                    notifyDataSetChanged();

                }
            });


        }
    }


    public City getCityAtPosition (int position) {
        return mCities.get(position);
    }


}
//
