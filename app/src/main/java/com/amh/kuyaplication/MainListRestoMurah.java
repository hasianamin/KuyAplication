package com.amh.kuyaplication;

/**
 * Created by aminhasian on 28/02/2017.
 */
import com.amh.kuyaplication.CustomListAdapter;
import com.amh.kuyaplication.AppController;
import com.amh.kuyaplication.ListRestoMurah;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

public class MainListRestoMurah extends Activity {
    private static final String TAG = MainListRestoMurah.class.getSimpleName();

    // Movies json url
    private static final String url = "http://kuywisata.hol.es/list_restoran.php";
    private ProgressDialog pDialog;
    private List<ListRestoMurah> restoMurah = new ArrayList<ListRestoMurah>();
    private ListView listView;
    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto_murah);

        listView = (ListView) findViewById(R.id.list);
        adapter = new CustomListAdapter(this, restoMurah);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // changing action bar color
        /*getActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#1b1b1b")));*/

        // Creating volley request obj
        JsonArrayRequest restoReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                ListRestoMurah resto = new ListRestoMurah();

                                resto.setId_resto(obj.getString("id_resto"));
                                resto.setName_resto(obj.getString("name_resto"));
                                resto.setThumbnailUrl(obj.getString("nama"));
                                resto.setCost_for_two(obj.getInt("cost_for_two"));
                                resto.setState_resto(obj.getString("state_resto"));
                                resto.setCity_resto(obj.getString("city_resto"));



                                // adding movie to movies array
                                restoMurah.add(resto);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    Intent intent =new Intent(getApplicationContext(),MainListRestoMurahDetail.class);

                                    String id_resto = ((TextView) view.findViewById(R.id.id_resto)).getText().toString();
                                    intent.putExtra("id_resto",id_resto);
                                    Log.d("afqr", id_resto);
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
        AppController.getInstance().addToRequestQueue(restoReq);
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
