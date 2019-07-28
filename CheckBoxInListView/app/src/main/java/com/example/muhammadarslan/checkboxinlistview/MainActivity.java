package com.example.muhammadarslan.checkboxinlistview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    ListView listView;
    Model[] modelItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView1);

        modelItems = new Model[5];
        modelItems[0] = new Model("pizza", 0);
        modelItems[1] = new Model("burger", 0);
        modelItems[2] = new Model("olives", 1);
        modelItems[3] = new Model("orange", 0);
        modelItems[4] = new Model("tomato", 1);
        CustomAdapter adapter = new CustomAdapter(this, modelItems);
        listView.setAdapter(adapter);
    }


}
