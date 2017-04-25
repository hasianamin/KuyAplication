package com.amh.kuyaplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpsiResto extends AppCompatActivity {

    private Button btnRestoMurah;
    private Button btnRestoDekat;
    private Button btnRestoRating;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opsi_resto);

        btnRestoDekat = (Button) findViewById(R.id.btnRestoDekat);
        btnRestoMurah = (Button) findViewById(R.id.btnRestoMurah);
        btnRestoRating = (Button) findViewById(R.id.btnRestoRating);

        btnRestoDekat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btnRestoDekat);
                Intent a = new Intent(context, RestoMapActivity.class);
                startActivity(a);
            }
        });

        btnRestoMurah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btnRestoMurah);
                Intent a = new Intent(context, MainListRestoMurah.class);
                startActivity(a);
            }
        });

        btnRestoRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btnRestoRating);
                Intent a = new Intent(context, MainListRestoMurah.class);
                startActivity(a);
            }
        });
    }
}
