package com.example.android.fragmentpasswithviewmodel.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.fragmentpasswithviewmodel.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UnixTimeConverterScriptAct extends AppCompatActivity {

    private static final String TAG = "UnixTimeAct";
    EditText unixTimeUnit;
    TextView convertedDayTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unix_time_converter_script);

        unixTimeUnit=(EditText) findViewById(R.id.unixEditText);
        convertedDayTV=(TextView)findViewById(R.id.convertedDayTV);
    }

    public void unixConvert(View view) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
//        Date dateFormat = new java.util.Date(unixTimeUnit.getText().toString());
        Date dateFormat = new java.util.Date(Long.parseLong(unixTimeUnit.getText().toString())*1000);
//        Log.d(TAG, String.valueOf(dateFormat));
        String weekday = sdf.format(dateFormat);
        Log.d(TAG, String.valueOf(weekday));


        unixTimeUnit.getText();
//        Log.d(TAG, String.valueOf(unixTimeUnit.getText()).trim());
//        convertedDayTV.setText((c.get(Calendar.DAY_OF_WEEK)));
    }
}
//
