package com.example.muhammadarslan.cardviewexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Contact> list=new ArrayList<Contact>();

    int [] imageId={R.drawable.pearl_continental,R.drawable.marriott,R.drawable.beach_luxury};
    String[] hotel_title, hotel_description, hotel_contact, hotel_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hotel_title=getResources().getStringArray(R.array.hotel_title);
        hotel_description=getResources().getStringArray(R.array.hotel_description);
        hotel_contact=getResources().getStringArray(R.array.contact);
        hotel_location=getResources().getStringArray(R.array.location);

//        TextView contact_view=(TextView)findViewById(R.id.contact);
//        contact_view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:" + 03453235126));
//                if (intent.resolveActivity(getPackageManager()) != null) {
//                    startActivity(intent);
//                }
//            }
//        });

        int count=0;
        for(String Title:hotel_title){
            Contact contact=new Contact(imageId[count],Title,hotel_description[count],hotel_contact[count],hotel_location[count]);
            count++;

            list.add(contact);
        }
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();
        adapter=new ContactAdapter(list);
        recyclerView.setAdapter(adapter);

    }
}
