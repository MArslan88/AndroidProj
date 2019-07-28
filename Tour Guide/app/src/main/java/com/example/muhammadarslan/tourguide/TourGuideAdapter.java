package com.example.muhammadarslan.tourguide;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muhammad Arslan on 9/4/2017.
 */

public class TourGuideAdapter extends ArrayAdapter<TourGuide> {

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceID;

    public TourGuideAdapter(Activity context, ArrayList<TourGuide> words, int colorResourceID) {
        super(context, 0, words);
        mColorResourceID=colorResourceID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView=convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_items,parent,false);
        }
        // Get the {@link currentItem} object located at this position in the list
        TourGuide currentItem = getItem(position);

        // Find the TextView in the title_text_view.xml layout with the ID version_name
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        // Get the title from the current Item object and
        // set this text on the name TextView
        titleTextView.setText(currentItem.getmTitle());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView descriptiontTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        descriptiontTextView.setText(currentItem.getmDescription());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if(currentItem.hasImage()){
            // Set the ImageView to the image resource specified in the current item
            imageView.setImageResource(currentItem.getmImageResourceId());

            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }else{
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the them color for the list item
        View textContainer= listItemView.findViewById(R.id.text_container);
        // Find the color that the resource Id maps to
        int color = ContextCompat.getColor(getContext(),mColorResourceID);
        // Set the beckground color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
