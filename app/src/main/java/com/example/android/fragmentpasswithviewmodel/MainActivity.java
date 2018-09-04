package com.example.android.fragmentpasswithviewmodel;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.fragmentpasswithviewmodel.adapter.ViewPageAdapter;

public class MainActivity extends AppCompatActivity {


    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPageAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        /**Without this line the checked item pref is destroyed. This is just an easy fix
         * PROBABLY a very bad idea in any project where a lot of data is saved in a fragment
         * but since this is a small weather thingy it should hopefully be ok
         * */
        viewPager.setOffscreenPageLimit(2);



        /**Uncomment this for a tabbed layout**/
//        tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(viewPager);
    }
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.weather_menu,menu);
        return true;
    }



    public void send_to_weather_menu(MenuItem item) {
        Log.d("Pressed", "send_to_weather_menu: ");
    }
}
