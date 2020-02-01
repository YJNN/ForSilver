package com.example.user.silver;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by user on 2016-11-07.
 */
public class musicschool extends AppCompatActivity {
    GpsInfo gps;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicschool);
        gps = new GpsInfo(musicschool.this);
        if (gps.isGetLocation()) {

        } else {
            gps.showSettingsAlert();
        }
        Button button =(Button) findViewById(R.id.naver);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(musicschool.this, musicschoolnaver.class);
                startActivity(intent);
            }
        });
    }
}
