package com.amh.kuyaplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpsiHotel extends AppCompatActivity {

    private Button btnHotelMurah;
    private Button btnHotelDekat;
    private Button btnHotelRating;

    final Context context = this;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_opsi_hotel);

            btnHotelDekat = (Button) findViewById(R.id.btnHotelDekat);
            btnHotelMurah = (Button) findViewById(R.id.btnHotelMurah);
            btnHotelRating = (Button) findViewById(R.id.btnHotelRating);

            btnHotelDekat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(v == btnHotelDekat);
                    Intent a = new Intent(context, MainAbout.class);
                    startActivity(a);
                }
            });

            btnHotelMurah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(v == btnHotelMurah);
                    Intent a = new Intent(context, MainListHotelMurah.class);
                    startActivity(a);
                }
            });

            btnHotelRating.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(v == btnHotelRating);
                    Intent a = new Intent(context, MainListRestoMurah.class);
                    startActivity(a);
                }
            });
        }

}
