package com.example.android.fragmentpasswithviewmodel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
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

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="ActMLog" ;
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

        PreferenceManager.getDefaultSharedPreferences(this).getString("Lang_list_pref", "English");
//        Log.d(TAG, "Locale:"+));

        /***using this little fella in the location stuff*/
        SharedPreferences settings=PreferenceManager.getDefaultSharedPreferences(this);

        if (settings.getString("Lang_list_pref",null).equals("Romanian")) {
            Log.d(TAG, "ENTERED1");

            Locale locale = new Locale("ro");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
            settings.edit().putString("Lang_list_pref", "ro").commit();
        }
        if (settings.getString("Lang_list_pref",null).equals("English")) {
            Log.d(TAG, "ENTERED2");
            Locale locale = new Locale("en_US");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
            settings.edit().putString("Lang_list_pref", "en").commit();
        }
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
//        Log.d(TAG, "dark theme key: "+ PreferenceManager.getDefaultSharedPreferences(this).getBoolean("dark_theme_key", false));
//        Log.d(TAG, "onCreate: "+PreferenceManager.getDefaultSharedPreferences(this).getString("Lang_list_pref", "English"));
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
//        Log.d(TAG, "send_to_weather_menu: ");
        Intent intent = new Intent(this, SettingsActivity.class);

        intent.putExtra(EXTRA_MESSAGE, "hi");
        startActivity(intent);

    }
}
