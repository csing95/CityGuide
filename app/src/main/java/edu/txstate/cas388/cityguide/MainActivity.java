package edu.txstate.cas388.cityguide;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    //eventually in database
    String[] strAttractions = {"Art Institute","Magnificent Mile","Willis Tower","Navy Pier","Water Tower"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main); //must comment out this line or runtime error will occur

//        Define the data type of the elements in the array (data source, model
//        setListAdapter(new ArrayAdapter<String>(MainActivity.this,
//                android.R.layout.simple_list_item_1, strAttractions));
        setListAdapter(new ArrayAdapter<String>(MainActivity.this,
                R.layout.activity_main, R.id.txtTravel, strAttractions));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
//        position = index (position in array)
//        super.onListItemClick(l, v, position, id);


        /*if (position == 0){
            Toast.makeText(MainActivity.this, "You selected " + strAttractions[0],Toast.LENGTH_LONG).show();
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://artic.edu")));
        }*/

        //look up selected element in array
        String strIndex =strAttractions[position];
        Toast.makeText(MainActivity.this, "You selected " + strIndex + ".",Toast.LENGTH_LONG).show();

    }
}
