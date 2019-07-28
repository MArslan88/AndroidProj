package com.example.android.assignment7.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.assignment7.R;

/**
 * Created by lab2 on 2017-07-23.
 */
public class CustomeViewHolder extends RecyclerView.ViewHolder {

    TextView mUserName;
    TextView mCourse;

    public CustomeViewHolder(View itemView) {
        super(itemView);
        mUserName=(TextView) itemView.findViewById(R.id.username);
        mCourse=(TextView) itemView.findViewById(R.id.course);
    }
}
