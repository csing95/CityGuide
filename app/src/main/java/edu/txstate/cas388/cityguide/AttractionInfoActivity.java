package edu.txstate.cas388.cityguide;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AttractionInfoActivity extends AppCompatActivity {

    int intId;
    double dblCost;
    String strURL;
    String strName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_info);

        SharedPreferences sharedPref2 = PreferenceManager.getDefaultSharedPreferences(this);

        intId = sharedPref2.getInt("id", 0);
        dblCost = sharedPref2.getInt("cost", 0);
        strURL = sharedPref2.getString("url", "");
        strName = sharedPref2.getString("name", "");

    }
}
