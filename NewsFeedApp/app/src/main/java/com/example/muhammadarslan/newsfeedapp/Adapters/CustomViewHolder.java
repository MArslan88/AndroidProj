package com.example.muhammadarslan.newsfeedapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.newsfeedapp.R;

/**
 * Created by saqib on 25-Aug-17.
 */

public class CustomViewHolder extends RecyclerView.ViewHolder {

     TextView mSectionTextView;
     TextView mTitleTextView;
     TextView mTypeTextView;
     TextView mDatePublishedTextView;

    public CustomViewHolder(View itemView) {
        super(itemView);

       mSectionTextView = itemView.findViewById(R.id.section_text_view);
        mTitleTextView = itemView.findViewById(R.id.title_text_view);
        mTypeTextView = itemView.findViewById(R.id.type_text_view);
        mDatePublishedTextView = itemView.findViewById(R.id.publication_date_text_view);
    }
}
