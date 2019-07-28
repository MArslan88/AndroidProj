package com.example.muhammadarslan.androidreviewapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Muhammad Arslan on 12/3/2017.
 */

public class MovieAdapter extends ArrayAdapter<Model> {
    public MovieAdapter(@NonNull Context context, int resource, @NonNull List<Model> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_movies, parent, false);
        }

        ImageView photoImageView = (ImageView) convertView.findViewById(R.id.photoImageView);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.movieTitle);
        TextView descriptionTextView = (TextView) convertView.findViewById(R.id.descriptionTextView);

        Model message = getItem(position);

        boolean isPhoto = message.getmTitleImage() != null;
        if (isPhoto) {
            titleTextView.setVisibility(View.GONE);
            photoImageView.setVisibility(View.VISIBLE);

        } else {
            titleTextView.setVisibility(View.VISIBLE);
            photoImageView.setVisibility(View.GONE);
            titleTextView.setText(message.getmMovieTitle());
        }
        descriptionTextView.setText(message.getmMovieDescription());

        return convertView;

    }
}
