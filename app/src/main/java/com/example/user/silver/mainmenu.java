package com.example.user.silver;

/**
 * Created by user on 2016-09-18.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class mainmenu extends AppCompatActivity {
    RelativeLayout layout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
        layout = (RelativeLayout) findViewById(R.id.mainmenu);
        
        Button musicshool = (Button) findViewById(R.id.musicshool);
        musicshool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainmenu.this, musicschool.class);
                startActivity(intent);
            }
        });

        Button gateball = (Button) findViewById(R.id.gateball);
        gateball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainmenu.this, gateball.class);
                startActivity(intent);
            }
        });

        //dancesports버튼
        Button dancesports = (Button) findViewById(R.id.dancesports);
        dancesports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainmenu.this, dancesports.class);
                startActivity(intent);
            }
        });

        Button computerschool = (Button) findViewById(R.id.computerschool);
        computerschool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mainmenu.this, computerschool.class);
                startActivity(intent);
            }
        });

        Button free = (Button) findViewById(R.id.free);
        free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainmenu.this, qna.class);
                startActivity(intent);
            }
        });

        Button qna = (Button) findViewById(R.id.qna);
        qna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainmenu.this, Silvermarket.class);
                startActivity(intent);
            }
        });
    }

}
