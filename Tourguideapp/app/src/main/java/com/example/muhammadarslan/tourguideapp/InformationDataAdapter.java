package com.example.muhammadarslan.tourguideapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Muhammad Arslan on 8/26/2018.
 */

public class InformationDataAdapter extends ArrayAdapter<InformationData> {

    public InformationDataAdapter(Activity context, ArrayList<InformationData> informationData) {
        super(context,0, informationData);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
    }

        // Get the {@link AndroidFlavor} object located at this position in the list
        InformationData currentInformationData = getItem(position);


        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        nameTextView.setText(currentInformationData.getmName());


        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description);
        descriptionTextView.setText(currentInformationData.getmDescription());

        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address);
        addressTextView.setText(currentInformationData.getmAddress());

        TextView contactTextView = (TextView) listItemView.findViewById(R.id.contact);
        contactTextView.setText(currentInformationData.getmContact());


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
}
}
