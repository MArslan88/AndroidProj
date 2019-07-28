package com.example.muhammadarslan.newsfeedapp.Loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.example.muhammadarslan.newsfeedapp.Utilities.News;
import com.example.muhammadarslan.newsfeedapp.Utilities.QueryUtils;

import java.util.List;

/**
 * Created by saqib on 25-Aug-17.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private String mUrl;
    private static final String LOG_TAG = NewsLoader.class.getSimpleName();

    public NewsLoader(Context context, String url) {
        super(context);
        this.mUrl = url;
    }

    @Override
    public List<News> loadInBackground() {

        if (mUrl == null) {
            return null;
        }
        List<News> newsList = QueryUtils.fetchDataFromNetwork(mUrl);
        return newsList;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
