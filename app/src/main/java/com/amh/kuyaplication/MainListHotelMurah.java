package com.amh.kuyaplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aminhasian on 20/04/2017.
 */

public class MainListHotelMurah extends Activity {
    private static final String TAG = MainListHotelMurah.class.getSimpleName();

    // Movies json url
    private static final String url = "http://kuywisata.hol.es/list_hotel.php";
    private ProgressDialog pDialog;
    private List<ListHotelMurah> hotelMurah = new ArrayList<ListHotelMurah>();
    private ListView listView;
    private CustomListAdapterHotel adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_murah);

        listView = (ListView) findViewById(R.id.list);
        adapter = new CustomListAdapterHotel(this, hotelMurah);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // changing action bar color
        /*getActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#1b1b1b")));*/

        // Creating volley request obj
        JsonArrayRequest hotelReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                ListHotelMurah hotel = new ListHotelMurah();

                                hotel.setId_hotel(obj.getString("id_hotel"));
                                hotel.setName_hotel(obj.getString("name_hotel"));
                                hotel.setThumbnailUrl(obj.getString("nama"));
                                hotel.setStart_from(obj.getInt("start_from"));
                                hotel.setState_hotel(obj.getString("state_hotel"));
                                hotel.setCity_hotel(obj.getString("city_hotel"));



                                // adding movie to movies array
                                hotelMurah.add(hotel);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    Intent intent =new Intent(getApplicationContext(),MainListHotelMurahDetail.class);

                                    String id_hotel = ((TextView) view.findViewById(R.id.id_hotel)).getText().toString();
                                    intent.putExtra("id_hotel",id_hotel);
                                    Log.d("afqr", id_hotel);
                                    startActivity(intent);
                                }
                            });

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(hotelReq);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        [[getMenuInflater().inflate(R.menu.activity_main_action, menu);
        return true;
    }*/
}
