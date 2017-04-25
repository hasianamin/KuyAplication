package com.amh.kuyaplication;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by aminhasian on 14/03/2017.
 */

public class CustomListAdapterDetail extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<ListRestoMurahDetail> restoItemDetail;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapterDetail(Activity activity, List<ListRestoMurahDetail> restoItemDetail) {
        this.activity = activity;
        this.restoItemDetail = restoItemDetail;
    }

    @Override
    public int getCount() {
        return restoItemDetail.size();
    }

    @Override
    public Object getItem(int location) {
        return restoItemDetail.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row_detail, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView id_resto = (TextView) convertView.findViewById(R.id.id_resto);
        TextView name_resto = (TextView) convertView.findViewById(R.id.name_resto);
        TextView street_resto = (TextView) convertView.findViewById(R.id.street_resto);
        TextView state_resto = (TextView) convertView.findViewById(R.id.state_resto);
        TextView city_resto = (TextView) convertView.findViewById(R.id.city_resto);
        TextView cost_for_two = (TextView) convertView.findViewById(R.id.cost_for_two);
        TextView postal_code_resto = (TextView) convertView.findViewById(R.id.postal_code_resto);
        TextView desk = (TextView) convertView.findViewById(R.id.desk);
        TextView avg_rating_resto = (TextView) convertView.findViewById(R.id.avg_rating_resto);


        // getting movie data for the row
        ListRestoMurahDetail m = restoItemDetail.get(position);

        // thumbnail image
        thumbNail.setImageUrl(m.getThumbnailUrl_detail(), imageLoader);

        // title
        id_resto.setText(m.getId_resto());

        name_resto.setText(m.getName_resto_detail());

        // rating
        cost_for_two.setText(String.valueOf(m.getCost_for_two_detail()));

        street_resto.setText(m.getStreet_resto_detail());
        state_resto.setText(m.getState_resto_detail());
        city_resto.setText(m.getCity_resto_detail());
        postal_code_resto.setText(m.getPostal_code_resto_detail());


        desk.setText(m.getDesk_detail());

        avg_rating_resto.setText(m.getAvg_rating_resto_detail());
        Log.d("jgok",m.getAvg_rating_resto_detail());
        /*avg_rating_resto.setText(String.valueOf(m.getAvg_rating_resto_detail()));*/



        return convertView;
    }
}
