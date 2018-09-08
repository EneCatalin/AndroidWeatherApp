package com.example.android.fragmentpasswithviewmodel.activities;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;

import com.example.android.fragmentpasswithviewmodel.R;


//public class SettingsActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        addPreferencesFromResource(R.xml.main_preferences);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        final Activity activity = this;
//        activity.setTitle("Settings");
//
//
//    }
//
//
//}
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    public static class MyPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.main_preferences);
        }
    }
}











//
//
//public class SettingsActivity extends PreferenceActivity {
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        addPreferencesFromResource(R.xml.main_preferences);
//    }
//}

//public class SettingsActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_settings_activity);
////        getActionBar().setDisplayHomeAsUpEnabled(true);
//        final Activity activity = this;
//        activity.setTitle("Settings");
//
//    }
//
//    public void select_celius(View view) {
//    }
//
//    public void select_fahrenheit(View view) {
//    }
//
//    public void setActionBarTitle(String title) {
//        getSupportActionBar().setTitle(title);
//    }
//
//
//}
