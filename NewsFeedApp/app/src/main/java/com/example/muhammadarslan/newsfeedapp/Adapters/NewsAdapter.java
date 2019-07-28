package com.example.muhammadarslan.newsfeedapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.muhammadarslan.newsfeedapp.Interfaces.MyItemClickListener;
import com.example.android.newsfeedapp.R;
import com.example.muhammadarslan.newsfeedapp.Utilities.News;

import java.util.List;

/**
 * Created by saqib on 25-Aug-17.
 */

public class NewsAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private List<News> mNewsList;
    private MyItemClickListener mListener;

    public NewsAdapter(List<News> newsList, MyItemClickListener listener) {
        this.mNewsList = newsList;
        this.mListener = listener;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View myItemView =  LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        CustomViewHolder customViewHolder = new CustomViewHolder(myItemView);

        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int position) {

        final News currentNews = mNewsList.get(position);
        holder.mSectionTextView.setText(currentNews.getmSection());
        holder.mTitleTextView.setText(currentNews.getmTitle());
        holder.mTypeTextView.setText(currentNews.getmType());
        holder.mDatePublishedTextView.setText(currentNews.getmDatePublished());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(currentNews);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public void clear() {
        mNewsList.clear();
        notifyDataSetChanged();
    }


    public void addAll(List<News> newsList) {
        mNewsList.addAll(newsList);
        notifyDataSetChanged();
    }
}
