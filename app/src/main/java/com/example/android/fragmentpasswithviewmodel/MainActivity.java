package com.example.android.fragmentpasswithviewmodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.android.fragmentpasswithviewmodel.activities.SettingsActivity;
import com.example.android.fragmentpasswithviewmodel.adapter.ViewPageAdapter;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;

//    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPageAdapter viewPagerAdapter;
    public static final String EXTRA_MESSAGE =
            "com.example.android.fragmentpasswithviewmode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /***Setting the default preferences
         * About the third argument:
         * A boolean indicating whether the default values should be set more than once. When false, the system
         * the default values only if this method has never been called in the past. As long as you set this
         * argument to false, you can safely call this method every time the main activity starts without overriding
         * the user's saved settings values. However, if you set it to true, the method will override any previous
         * values with the defaults.*/
        PreferenceManager.setDefaultValues(this, R.xml.main_preferences, false);

        /**This log is just a small example of how to access the preferences. As a wise ostrich once said:
         * easy peasy lemon squeezy**/
        Log.d("ActMLog", "dark theme key: "+ PreferenceManager.getDefaultSharedPreferences(this).getBoolean("dark_theme_key", false));
//        toolbar=(Toolbar)findViewById(R.id.toolbar);
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

    /**pretty self explanatory but just in case:
     * this creates the three dots menu */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.weather_menu,menu);
        return true;
    }



    public void send_to_weather_menu(MenuItem item) {
        Log.d("Pressed", "send_to_weather_menu: ");
        Intent intent = new Intent(this, SettingsActivity.class);

        intent.putExtra(EXTRA_MESSAGE, "hi");
        startActivity(intent);

    }
}
