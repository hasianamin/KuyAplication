package com.amh.kuyaplication;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
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
 * Created by aminhasian on 14/03/2017.
 */

public class MainListRestoMurahDetail extends Activity {
    private static final String TAG = MainListRestoMurah.class.getSimpleName();

    // Movies json url
    private static final String url = "http://kuywisata.hol.es/list_restoran_detail.php?id_resto=";
    private ProgressDialog pDialog;
    private List<ListRestoMurahDetail> restoMurah = new ArrayList<ListRestoMurahDetail>();
    private ListView listView;
    private CustomListAdapterDetail adapter;
    /*private Button btnRateresto;
    Dialog rankDialog;
    RatingBar ratingBar;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto_murah_detail);

        listView = (ListView) findViewById(R.id.list_detail);
        adapter = new CustomListAdapterDetail(this, restoMurah);
        listView.setAdapter(adapter);

        Bundle d = new Bundle();
        d = getIntent().getExtras();
        String id_resto = d.getString("id_resto");
        Log.d("pouj :", id_resto);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // changing action bar color
        /*getActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#1b1b1b")));*/
        String URLS = url + id_resto;

        // Creating volley request obj
        JsonArrayRequest restoReq = new JsonArrayRequest(URLS,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                ListRestoMurahDetail restoDetail = new ListRestoMurahDetail();
                                restoDetail.setId_resto(obj.getString("id_resto"));
                                restoDetail.setName_resto_detail(obj.getString("name_resto"));
                                restoDetail.setThumbnailUrl_detail(obj.getString("nama"));
                                restoDetail.setCost_for_two_detail(obj.getInt("cost_for_two"));
                                restoDetail.setStreet_resto_detail(obj.getString("street_resto"));
                                restoDetail.setState_resto_detail(obj.getString("state_resto"));
                                restoDetail.setCity_resto_detail(obj.getString("city_resto"));
                                restoDetail.setPostal_code_resto_detail(obj.getString("postal_code_resto"));
                                restoDetail.setDesk_detail(obj.getString("desk"));
                                restoDetail.setAvg_rating_resto_detail(obj.getString("avg_rating_resto"));
                                /*restoDetail.setAvg_rating_resto_detail(obj.getInt("avg_rating_resto"));*/
                                Log.d("asfasda",obj.getString("avg_rating_resto"));
                                // adding movie to movies array
                                restoMurah.add(restoDetail);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

/*                        btnRateresto = (Button) findViewById(R.id.btnRateresto);

                        btnRateresto.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                rankDialog = new Dialog(MainListRestoMurahDetail.this, R.style.FullHeightDialog);
                                rankDialog.setContentView(R.layout.rank_dialog);
                                rankDialog.setCancelable(true);
                                ratingBar = (RatingBar) rankDialog.findViewById(R.id.dialog_ratingbar);
//                                ratingBar.setRating(userRankValue);

                                TextView text = (TextView) rankDialog.findViewById(R.id.rank_dialog_text1);
                                text.setText("gfgf");

                                Button updateButton = (Button) rankDialog.findViewById(R.id.rank_dialog_button);
                                updateButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        rankDialog.dismiss();
                                }
                                });
                                //now that the dialog is set up, it's time to show it
                                rankDialog.show();
                            }
                        });*/

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
