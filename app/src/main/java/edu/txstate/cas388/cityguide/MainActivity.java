package edu.txstate.cas388.cityguide;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {
    //eventually in database
    String[] strAttractions = {"Art Institute","Magnificent Mile","Willis Tower","Navy Pier","Water Tower"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main); //must comment out this line or runtime error will occur

        //Define the data type of the elements in the array (data source, model
        setListAdapter(new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, strAttractions));
    }
}
