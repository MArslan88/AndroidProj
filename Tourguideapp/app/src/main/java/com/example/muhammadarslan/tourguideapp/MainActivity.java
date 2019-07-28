package com.example.muhammadarslan.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView sights=(TextView)findViewById(R.id.sights);

        sights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sightIntent= new Intent(MainActivity.this,Sights.class);
                startActivity(sightIntent);
            }
        });
    }
}
