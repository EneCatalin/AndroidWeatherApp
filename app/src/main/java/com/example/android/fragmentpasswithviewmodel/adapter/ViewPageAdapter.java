package com.example.android.fragmentpasswithviewmodel.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.fragmentpasswithviewmodel.fragments.FragmentOne;
import com.example.android.fragmentpasswithviewmodel.fragments.FragmentThree;
import com.example.android.fragmentpasswithviewmodel.fragments.FragmentTwo;
import com.example.android.fragmentpasswithviewmodel.fragments.FragmentWeek;

public class ViewPageAdapter extends FragmentPagerAdapter {

    public ViewPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new FragmentOne();
        } else if (position == 1) {
            fragment = new FragmentTwo();
        } else if(position == 2){
            fragment = new FragmentThree();
        } else if(position == 3){
            fragment= new FragmentWeek();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "Tab-1";
        } else if (position == 1) {
            title = "Tab-2";
        } else if(position == 2){
            title ="Tab-3";
        } else if(position == 3){
            title = "Tab-4";
        }
        return title;
    }
}
