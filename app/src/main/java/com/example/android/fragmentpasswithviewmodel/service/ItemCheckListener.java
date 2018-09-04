package com.example.android.fragmentpasswithviewmodel.service;

import android.support.v7.widget.RecyclerView;

import com.example.android.fragmentpasswithviewmodel.model.city.City;

public interface ItemCheckListener {
    void onItemClicked(RecyclerView.ViewHolder vh, City item, int pos);
}
