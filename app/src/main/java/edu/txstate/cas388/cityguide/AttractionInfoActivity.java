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

        Button btnCostCalculation = findViewById(R.id.btnCalculateCostAttr);
        final Button btnGoToWebsite = findViewById(R.id.btnGoToWebsite);
        final EditText txtNumberOfPersons = findViewById(R.id.txtNumberOfPersons);

        if (strURL.equals("")){
            btnGoToWebsite.setEnabled(false);
        }

        btnGoToWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnGoToWebsite.isEnabled()){
                    //start an activity
                }
            }
        });


        btnCostCalculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intPersons = Integer.parseInt(txtNumberOfPersons.getText().toString());
                double dblTotalCost = dblCost * intPersons;
                DecimalFormat currency = new DecimalFormat("$###,###.00");
                Toast.makeText(AttractionInfoActivity.this, "Total Cost: " + currency.format(dblTotalCost), Toast.LENGTH_LONG).show();

            }
        });

    }
}
