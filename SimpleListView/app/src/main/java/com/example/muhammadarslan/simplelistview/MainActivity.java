package com.example.muhammadarslan.simplelistview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    ListView listView;
    String[] days={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listView);

        /*ArrayList<Days> days=new ArrayList<Days>();

        days.add(new Days("Sunday"));
        days.add(new Days("Monday"));
        days.add(new Days("Tuesday"));
        days.add(new Days("Wednesday"));
        days.add(new Days("Thursday"));
        days.add(new Days("Friday"));
        days.add(new Days("Saturday"));*/

       /* days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");*/

       ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,days);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView temp = (TextView) view;
                Toast.makeText(MainActivity.this,temp.getText(),Toast.LENGTH_SHORT).show();
            }
        });


    }



}
