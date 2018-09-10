package com.example.android.fragmentpasswithviewmodel.activities;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.android.fragmentpasswithviewmodel.R;

/**You use a specialized Fragment subclass to display a list of settings.
 *  The best practice is to use a regular Activity that hosts a PreferenceFragment
 *  that displays the app settings. Fragments like PreferenceFragment provide a
 *  more flexible architecture for your app, compared to using activities alone. **/
public class SettingsActivity extends AppCompatActivity {
    public  void recreateSetting(){
        recreate();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();

        MyPreferenceFragment frag =  new MyPreferenceFragment();

        getFragmentManager().beginTransaction().replace(android.R.id.content, frag).commit();

    }

    private static android.preference.Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener = new android.preference.Preference.OnPreferenceChangeListener() {
        @Override
        public boolean onPreferenceChange(android.preference.Preference preference, Object value) {
            String stringValue = value.toString();

            Log.d("CECECECE", "onPreferenceChange: ");
            if (preference instanceof ListPreference) {
                // For list preferences, look up the correct display value in
                // the preference's 'entries' list.
                ListPreference listPreference = (ListPreference) preference;
                int index = listPreference.findIndexOfValue(stringValue);

                // Set the summary to reflect the new value.
                preference.setSummary(
                        index >= 0
                                ? listPreference.getEntries()[index]
                                : null);


            }
            return true;
        }
    };
    private static void bindPreferenceSummaryToValue(Preference preference) {
        // Set the listener to watch for value changes.
        preference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);

        // Trigger the listener immediately with the preference's
        // current value.
        sBindPreferenceSummaryToValueListener.onPreferenceChange(preference,
                PreferenceManager
                        .getDefaultSharedPreferences(preference.getContext())
                        .getString(preference.getKey(), ""));
    }
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
            bindPreferenceSummaryToValue(findPreference("Lang_list_pref"));


            /**This is a clever little cheat until I implement the new fragment with returning to this one
             * thingy**/
            Preference pref;
            pref = findPreference("Lang_list_pref");
            pref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    Log.d("VALNOU", "valoare: "+newValue);
                    if(newValue.equals("English")){
                        Toast.makeText(getActivity(),"Language Changed!",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getActivity(),"Limbă Schimbată!",Toast.LENGTH_LONG).show();
                    }
                    return true;
                }
            });

        }

    }
}


