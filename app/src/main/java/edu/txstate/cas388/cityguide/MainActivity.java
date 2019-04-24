package edu.txstate.cas388.cityguide;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.message.BasicHeader;

public class MainActivity extends ListActivity {

    //    String[] strAttractions = {"Art Institute","Magnificent Mile","Willis Tower","Navy Pier","Water Tower"};
//    int[] intAttractionIDs = {101,102,103,104,105};
//    double[] dblAttractionCost = {20.88,50,10.80,12.8,25.5};
//    String[] strAttractionURL = {"http://artic.edu", "http://themagnificentmil.com", null, null, null};
//    int[] intAttractionImg = {R.drawable.ic_launcher_chicago, 0, 0, 0, 0}; //This is how you have images be displayed. Obviously change the last thing after drawable
    List<Attraction> attractions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main); //must comment out this line or runtime error will occur
//
////        Define the data type of the elements in the array (data source, model
//        setListAdapter(new ArrayAdapter<String>(MainActivity.this,
//                android.R.layout.simple_list_item_1, strAttractions));
//        setListAdapter(new ArrayAdapter<String>(MainActivity.this, R.layout.activity_main, R.id.txtTravel, strAttractions));
//
////        1) Create list
//        attractions = new ArrayList<Attraction>();
//
////        2) Add attraction beans to the list
//        Attraction att = new Attraction(intAttractionIDs[0],strAttractions[0],dblAttractionCost[0],strAttractionURL[0],intAttractionImg[0]);
//        attractions.add(att);
//        for (int i=0; i < strAttractions.length; i++) {
//            Attraction att = new Attraction(intAttractionIDs[i],strAttractions[i],dblAttractionCost[i],strAttractionURL[i],intAttractionImg[i]);
//            attractions.add(att);
//        }
//
////        Displays the info. Similar to the one above but for Attractions
//        setListAdapter(new ArrayAdapter<Attraction>(MainActivity.this,
//                R.layout.activity_main, R.id.txtTravel, attractions));
        getAttractions();
    }

    void getAttractions(){
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader("Accept", "application/json"));

        RestAPIClient.get(MainActivity.this, "attractions.json", headers.toArray(new Header[headers.size()]),
                null, new JsonHttpResponseHandler() {
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                        //create an arrayList
                        ArrayList<Attraction> attractions = new ArrayList<Attraction>();

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                attractions.add(new Attraction(response.getJSONObject(i)));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            MainActivity.this.setListAdapter(new ArrayAdapter<Attraction>(MainActivity.this,android.R.layout.simple_list_item_1, attractions));

                            //setListAdapter(new ArrayAdapter<Attraction>(MainActivity.this, R.layout.activity_main, R.id.txtTravel, attractions));
                        }
                    }
                });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
//        position = index (position in array)
//        super.onListItemClick(l, v, position, id);


//        if (position == 0){
//            Toast.makeText(MainActivity.this, "You selected " + strAttractions[0],Toast.LENGTH_LONG).show();
//            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://artic.edu")));
//        } else
//        {
//
//            Attraction selectedAttraction = attractions.get(position);
//
//            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
//            SharedPreferences.Editor editor = sharedPref.edit();
//            editor.putInt("id", selectedAttraction.getId());
//            editor.putFloat("cost", (float) selectedAttraction.getCost());
//            editor.putString("name", selectedAttraction.getName());
//            editor.putString("url", selectedAttraction.getUrl());
//
//            editor.commit();
//
//           startActivity(new Intent(MainActivity.this, AttractionInfoActivity.class));
//
//
//            DecimalFormat tenth = new DecimalFormat("$###,###,##");
//            Toast.makeText(MainActivity.this, "You selected " + selectedAttraction.getName()
//                    + ", and the cost is " + tenth.format(selectedAttraction.getCost()) + ".",Toast.LENGTH_LONG).show();
//        }



    }
}
