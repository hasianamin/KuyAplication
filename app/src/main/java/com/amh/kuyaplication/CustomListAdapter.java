package com.amh.kuyaplication;

/**
 * Created by aminhasian on 28/02/2017.
 */
import com.amh.kuyaplication.R;
import com.amh.kuyaplication.AppController;
import com.amh.kuyaplication.ListRestoMurah;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<ListRestoMurah> restoItem;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapter(Activity activity, List<ListRestoMurah> restoItem) {
        this.activity = activity;
        this.restoItem = restoItem;
    }

    @Override
    public int getCount() {
        return restoItem.size();
    }

    @Override
    public Object getItem(int location) {
        return restoItem.get(location);
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
            convertView = inflater.inflate(R.layout.list_row, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView id_resto = (TextView) convertView.findViewById(R.id.id_resto);
        TextView name_resto = (TextView) convertView.findViewById(R.id.name_resto);
        TextView state_resto = (TextView) convertView.findViewById(R.id.state_resto);
        TextView city_resto = (TextView) convertView.findViewById(R.id.city_resto);
        TextView cost_for_two = (TextView) convertView.findViewById(R.id.cost_for_two);

        // getting movie data for the row
        ListRestoMurah m = restoItem.get(position);

        // thumbnail image
        thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);

        id_resto.setText(m.getId_resto());

        // title
        name_resto.setText(m.getName_resto());

        // rating
        cost_for_two.setText(String.valueOf(m.getCost_for_two()));


        state_resto.setText(m.getState_resto());
        city_resto.setText(m.getCity_resto());


        return convertView;
    }
}
