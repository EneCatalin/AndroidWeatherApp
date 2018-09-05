package com.example.android.fragmentpasswithviewmodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.android.fragmentpasswithviewmodel.activities.SettingsACtivity;
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
        Intent intent = new Intent(this, SettingsACtivity.class);

        intent.putExtra(EXTRA_MESSAGE, "hi");
        startActivity(intent);

    }
}
