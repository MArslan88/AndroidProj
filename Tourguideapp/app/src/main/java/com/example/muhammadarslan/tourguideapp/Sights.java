package com.example.muhammadarslan.tourguideapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Sights extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sights);

        final ArrayList<InformationData> words=new ArrayList<InformationData>();
        words.add(new InformationData("Ghibli Museum","its a museum","Karachi","0345"));
        words.add(new InformationData("Ghibli Museum","its a museum","Karachi","0345"));
        words.add(new InformationData("Ghibli Museum","its a museum","Karachi","0345"));
        words.add(new InformationData("Ghibli Museum","its a museum","Karachi","0345"));



/*        LinearLayout rootView=(LinearLayout)findViewById(R.id.rootView);

        for(int index=0;index<words.size();index++){
            TextView wordView=new TextView(this);
            wordView.setText(words.get(index));
            rootView.addView(wordView);
        }

        */

        InformationDataAdapter adapter=new InformationDataAdapter(this,words);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                InformationData informationData=words.get(position);
                Toast.makeText(Sights.this, "its clicked the position "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
