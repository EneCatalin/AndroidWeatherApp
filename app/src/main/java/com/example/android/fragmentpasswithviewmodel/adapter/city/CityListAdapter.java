package com.example.android.fragmentpasswithviewmodel.adapter.city;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.android.fragmentpasswithviewmodel.R;
import com.example.android.fragmentpasswithviewmodel.model.city.City;

import java.util.List;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.CityViewHolder> {


    private String lastSelectedCity="";

    /**Get layout inflater*/
    private final LayoutInflater mInflater;
    private List<City> mCities; // Cached copy of words

    public CityListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_city_row, parent, false);
        /**return city view holder and pass row inside*/
        return new CityViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {


        if (mCities != null) {
            /**Get current city*/
            City current = mCities.get(position);
            holder.cityItemView.setText(current.getCity());

        } else {
            // Covers the case of data not being ready yet.
            holder.cityItemView.setText("No City");
        }

        /**Ran into a weird bug so I had to implement all onClickListeners
         * otherwise one would grow and take over the ones without a listener
         * no idea why, just let this be**/
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // write your code here
                Log.d("ClickedClicked", "this "+position);
            }

        });


        holder.deleteCity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("ClickedClicked222","those? "+position);
            }

        });

        /**Keep it here or in the viewholder. Careful with this it can break the
         * city checked thingy**/
        holder.selectionState.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("ClickedClicked111","that "+position);

                lastSelectedCity=holder.cityItemView.getText().toString();
                Log.d("CheckedCity",lastSelectedCity=holder.cityItemView.getText().toString());
                notifyDataSetChanged();
            }
        });



        /**need this to uncheck the city radios
         *  since only one radio button is allowed to be selected,
         this condition un-checks previous selections
         WHY though ???*/
        holder.selectionState.setChecked(lastSelectedCity.equals((String) holder.cityItemView.getText()));


        Log.d("PositionIS", String.valueOf(position));
    }

    public void setCities(List<City> cities){
        mCities = cities;
        notifyDataSetChanged();
    }


    /**no idea
     * if
     * this
     * works
     * maybe delete
     * @param city
     * tested, this and setCities seem to do the same beep
     */
    public void deleteCity(List<City>city){
        mCities=city;
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
        private TextView deleteCity;

        //THIS USED TO BE private FIANAL
        private  TextView cityItemView;

        private CityViewHolder(View itemView) {
            super(itemView);
            cityItemView = itemView.findViewById(R.id.CityName);
            selectionState = (RadioButton) itemView.findViewById(R.id.city_status_radio_btn);
            deleteCity=itemView.findViewById(R.id.deleteCity);



        }
    }


    public City getCityAtPosition (int position) {
        return mCities.get(position);
    }


}