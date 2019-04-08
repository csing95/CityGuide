package edu.txstate.cas388.cityguide;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class AttractionInfoActivity extends AppCompatActivity {
    int intId;
    double dblCost;
    String strUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_info);

        SharedPreferences sharedPref2 = PreferenceManager.getDefaultSharedPreferences(this);
        intId = sharedPref2.getInt("id", 0);
        dblCost = sharedPref2.getFloat("cost", 0);
        strUrl = sharedPref2.getString("url", "");

        Button costCalculation = findViewById(R.id.btnCalculateCostAttr);
        final Button goToWebsite = findViewById(R.id.btnGoToWebsite);

        if (strUrl.equals("")){
            goToWebsite.setEnabled(false);
        }

        goToWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (goToWebsite.isEnabled()) {
                    //Start an activity
                }

            }
        });



        final EditText numberOfPersons = findViewById(R.id.txtNumberOfPersons);

        costCalculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intPersons = Integer.parseInt(numberOfPersons.getText().toString());
                double dblTotalCost = dblCost * intPersons;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                Toast.makeText(AttractionInfoActivity.this, "Total Cost:" +
                        currency.format(dblTotalCost) + ".", Toast.LENGTH_LONG).show();

            }
        });





    }
}
