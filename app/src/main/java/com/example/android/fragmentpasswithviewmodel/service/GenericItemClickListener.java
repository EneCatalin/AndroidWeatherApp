package com.example.android.fragmentpasswithviewmodel.service;

import android.support.v7.widget.RecyclerView;

public interface GenericItemClickListener<T, VH extends RecyclerView.ViewHolder> {

    void onItemClicked(VH vh, T item, int pos);
}