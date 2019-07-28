package com.example.muhammadarslan.tourguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class HotelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour_list);

        // Create a list of Hotels
        final ArrayList<TourGuide> tourGuides=new ArrayList<TourGuide>();
        tourGuides.add(new TourGuide("Pearl Continental","Pearl Continental Hotel is one of the finest hotels in Karachi.",R.drawable.color_black));
        tourGuides.add(new TourGuide("Marriott Hotel","Marriott Hotel is a leading 5-star hotel located in the heart of Karachi.",R.drawable.marriothotel));
        tourGuides.add(new TourGuide("Avari Towers","Avari has 17-story ultra-modern structure is located at Fatima Jinnah road.",R.drawable.avarihotel));

        // Create an {@link TourGuideAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        TourGuideAdapter adapter = new TourGuideAdapter(this, tourGuides, R.color.category_hotel);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // tour_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }
}
