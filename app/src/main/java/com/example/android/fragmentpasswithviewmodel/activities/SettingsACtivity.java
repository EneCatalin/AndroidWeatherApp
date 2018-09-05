package com.example.android.fragmentpasswithviewmodel.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.android.fragmentpasswithviewmodel.R;


public class SettingsACtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_activity);
//        getActionBar().setDisplayHomeAsUpEnabled(true);
        final Activity activity = this;
        activity.setTitle("Settings");

    }

    public void select_celius(View view) {
    }

    public void select_fahrenheit(View view) {
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }


}
