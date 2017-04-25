package com.amh.kuyaplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

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

public class MainListHotelMurahDetail extends Activity {
    private static final String TAG = MainListHotelMurah.class.getSimpleName();

    // Movies json url
    private static final String url = "http://kuywisata.hol.es/list_hotel_detail.php?id_hotel=";
    private ProgressDialog pDialog;
    private List<ListHotelMurahDetail> hotelMurah = new ArrayList<ListHotelMurahDetail>();
    private ListView listView;
    private CustomListAdapterDetailHotel adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_murah_detail);

        listView = (ListView) findViewById(R.id.list_detail);
        adapter = new CustomListAdapterDetailHotel(this, hotelMurah);
        listView.setAdapter(adapter);

        Bundle d = new Bundle();
        d = getIntent().getExtras();
        String id_hotel = d.getString("id_hotel");
        Log.d("pouj :", id_hotel);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // changing action bar color
        /*getActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#1b1b1b")));*/
        String URLS = url + id_hotel;

        // Creating volley request obj
        JsonArrayRequest hotelReq = new JsonArrayRequest(URLS,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                ListHotelMurahDetail hotelDetail = new ListHotelMurahDetail();
                                hotelDetail.setId_hotel(obj.getString("id_hotel"));
                                hotelDetail.setName_hotel_detail(obj.getString("name_hotel"));
                                hotelDetail.setThumbnailUrl_detail(obj.getString("nama"));
                                hotelDetail.setStart_from_detail(obj.getInt("start_from"));
                                hotelDetail.setStreet_hotel_detail(obj.getString("street_hotel"));
                                hotelDetail.setState_hotel_detail(obj.getString("state_hotel"));
                                hotelDetail.setCity_hotel_detail(obj.getString("city_hotel"));
                                hotelDetail.setPostal_code_hotel_detail(obj.getString("postal_code_hotel"));
                                hotelDetail.setDesk_detail(obj.getString("desk"));



                                // adding movie to movies array
                                hotelMurah.add(hotelDetail);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

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
