package com.example.muhammadarslan.tourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView school=(TextView) findViewById(R.id.school);

        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent schoolIntent=new Intent(MainActivity.this,SchoolActivity.class);
                startActivity(schoolIntent);
            }
        });

        TextView hotel=(TextView)findViewById(R.id.hotel);

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hotelIntent=new Intent(MainActivity.this,HotelsActivity.class);
                startActivity(hotelIntent);
            }
        });

        TextView mall=(TextView)findViewById(R.id.mall);

        mall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mallIntent=new Intent(MainActivity.this, MallActivity.class);
                startActivity(mallIntent);
            }
        });

        TextView resturant=(TextView)findViewById(R.id.resturant);

        resturant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resturantIntent=new Intent(MainActivity.this,ResturantActivity.class);
                startActivity(resturantIntent);
            }
        });
    }
}
