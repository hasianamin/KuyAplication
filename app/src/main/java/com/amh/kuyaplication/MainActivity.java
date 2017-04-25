package com.amh.kuyaplication;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.amh.kuyaplication.SQLiteHandler;
import com.amh.kuyaplication.SessionManager;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    private Button btnLogout;
    private Button btnHotel;
    private Button btnResto;
    private Button btnAbout;
    private Button btnProfile;

    SQLiteHandler db;
    SessionManager session;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //txtName = (TextView) findViewById(R.id.name);
        //txtEmail = (TextView) findViewById(R.id.email);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnHotel = (Button) findViewById(R.id.btnHotel);
        btnResto = (Button) findViewById(R.id.btnResto);
        btnAbout = (Button) findViewById(R.id.btnAbout);
        btnProfile = (Button) findViewById(R.id.btnProfile);

        final Context context = this;

        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btnAbout);
                Intent a = new Intent(context, MainAbout.class);
                startActivity(a);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btnProfile);
                Intent a = new Intent(context, MainProfile.class);
                startActivity(a);
            }
        });

        btnResto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btnResto);
                Intent a = new Intent(context, OpsiResto.class);
                startActivity(a);
            }
        });
        btnHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == btnHotel);
                Intent a = new Intent(context, OpsiHotel.class);
                startActivity(a);
            }
        });

        // Logout button click event
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });


    }

    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}





