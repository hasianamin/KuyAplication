package com.amh.kuyaplication;

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

import static com.amh.kuyaplication.R.id.id_hotel;

/**
 * Created by aminhasian on 20/04/2017.
 */

public class CustomListAdapterDetailHotel extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<ListHotelMurahDetail> hotelItemDetail;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapterDetailHotel(Activity activity, List<ListHotelMurahDetail> hotelItemDetail) {
        this.activity = activity;
        this.hotelItemDetail = hotelItemDetail;
    }

    @Override
    public int getCount() {
        return hotelItemDetail.size();
    }

    @Override
    public Object getItem(int location) {
        return hotelItemDetail.get(location);
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
            convertView = inflater.inflate(R.layout.list_row_detail_hotel, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView id_hotel = (TextView) convertView.findViewById(R.id.id_hotel);
        TextView name_hotel = (TextView) convertView.findViewById(R.id.name_hotel);
        TextView street_hotel = (TextView) convertView.findViewById(R.id.street_hotel);
        TextView state_hotel = (TextView) convertView.findViewById(R.id.state_hotel);
        TextView city_hotel = (TextView) convertView.findViewById(R.id.city_hotel);
        TextView start_from = (TextView) convertView.findViewById(R.id.start_from);
        TextView postal_code_hotel = (TextView) convertView.findViewById(R.id.postal_code_hotel);
        TextView desk = (TextView) convertView.findViewById(R.id.desk);


        // getting movie data for the row
        ListHotelMurahDetail m = hotelItemDetail.get(position);

        // thumbnail image
        thumbNail.setImageUrl(m.getThumbnailUrl_detail(), imageLoader);

        // title
        id_hotel.setText(m.getId_hotel());

        name_hotel.setText(m.getName_hotel_detail());

        // rating
        start_from.setText(String.valueOf(m.getStart_from_detail()));

        street_hotel.setText(m.getStreet_hotel_detail());
        state_hotel.setText(m.getState_hotel_detail());
        city_hotel.setText(m.getCity_hotel_detail());
        postal_code_hotel.setText(m.getPostal_code_hotel_detail());


        desk.setText(m.getDesk_detail());



        return convertView;
    }
}
