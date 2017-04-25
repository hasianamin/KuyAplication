package com.amh.kuyaplication;


import com.amh.kuyaplication.R;
import com.amh.kuyaplication.AppController;
import com.amh.kuyaplication.ListHotelMurah;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by aminhasian on 20/04/2017.
 */

public class CustomListAdapterHotel extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<ListHotelMurah> hotelItem;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapterHotel(Activity activity, List<ListHotelMurah> hotelItem) {
        this.activity = activity;
        this.hotelItem = hotelItem;
    }

    @Override
    public int getCount() {
        return hotelItem.size();
    }

    @Override
    public Object getItem(int location) {
        return hotelItem.get(location);
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
            convertView = inflater.inflate(R.layout.list_row_hotel, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView id_hotel = (TextView) convertView.findViewById(R.id.id_hotel);
        TextView name_hotel = (TextView) convertView.findViewById(R.id.name_hotel);
        TextView state_hotel = (TextView) convertView.findViewById(R.id.state_hotel);
        TextView city_hotel = (TextView) convertView.findViewById(R.id.city_hotel);
        TextView start_from = (TextView) convertView.findViewById(R.id.start_from);

        // getting movie data for the row
        ListHotelMurah m = hotelItem.get(position);

        // thumbnail image
        thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);

        id_hotel.setText(m.getId_hotel());

        // title
        name_hotel.setText(m.getName_hotel());

        // rating
        start_from.setText(String.valueOf(m.getStart_from()));


        state_hotel.setText(m.getState_hotel());
        city_hotel.setText(m.getCity_hotel());


        return convertView;
    }
}
