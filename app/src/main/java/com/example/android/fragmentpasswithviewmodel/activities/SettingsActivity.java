package com.example.android.fragmentpasswithviewmodel.activities;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;

import com.example.android.fragmentpasswithviewmodel.R;

/**You use a specialized Fragment subclass to display a list of settings.
 *  The best practice is to use a regular Activity that hosts a PreferenceFragment
 *  that displays the app settings. Fragments like PreferenceFragment provide a
 *  more flexible architecture for your app, compared to using activities alone. **/
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();

        /**apparently needed for the action bar, but not really. StackOverflow copy pasta, proud
         * of myself over this of all pieces of code copied. Ima rewrite this whole thing myself
         * the second I actually understand how settings and the bloody action bar work together**/
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

//    @Override
//    public boolean onSupportNavigateUp(){
//        finish();
//        return true;
//    }

    /**SO SO SO very pissed I had to add this (also had a beer and some wine so yeah
     * NEED THIS or we don't get an actionBar. Why ? Because there's no god, that's why
     *later edit, our lord and Saviour google sayeth
     * If you're developing for Android 3.0 (API level 11) and higher, you should use a PreferenceFragment to display your list of Preference objects. You can add a PreferenceFragment to any activity—you don't need to use PreferenceActivity.

     Fragments provide a more flexible architecture for your app, compared to using activities alone, no matter what kind of activity you're building. As such, we suggest you use PreferenceFragment to control the display of your settings instead of PreferenceActivity when possible.**/
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
