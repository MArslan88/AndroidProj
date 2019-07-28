package com.example.muhammadarslan.newsfeedapp.Activities;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.muhammadarslan.newsfeedapp.Adapters.NewsAdapter;
import com.example.muhammadarslan.newsfeedapp.Interfaces.MyItemClickListener;
import com.example.muhammadarslan.newsfeedapp.Loaders.NewsLoader;
import com.example.android.newsfeedapp.R;
import com.example.muhammadarslan.newsfeedapp.Utilities.News;

import java.util.ArrayList;
import java.util.List;

public class NewsFeedActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>>, SearchView.OnQueryTextListener {

    private TextView mEmptyStateTextView;
    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private String mSearchQueryText;
    private NewsAdapter mAdapter;
    private static final String LOG_TAG = NewsFeedActivity.class.getSimpleName();
    private static final int NEWS_LOADER_ID = 1;
    private static final String REQUEST_URL = "http://content.guardianapis.com/search?api-key=test";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

      mAdapter = new NewsAdapter(new ArrayList<News>(), new MyItemClickListener() {
          @Override
          public void onItemClick(News news) {
              Uri webPage = Uri.parse(news.getmUrl());
              Intent webPageIntent = new Intent(Intent.ACTION_VIEW, webPage);
              if (webPageIntent.resolveActivity(getPackageManager()) != null) {
                  startActivity(webPageIntent);
              }
          }
      });
        mRecyclerView.setAdapter(mAdapter);
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(NEWS_LOADER_ID, null, this);

        } else {
            mProgressBar.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.GONE);
            mEmptyStateTextView.setVisibility(View.VISIBLE);
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }

    }

    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {


        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
        mEmptyStateTextView.setVisibility(View.GONE);

        String appendedQuery ="";
        if (mSearchQueryText != null) {
            appendedQuery = "&q="+mSearchQueryText;
        }

        return new NewsLoader(this, REQUEST_URL+appendedQuery);
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> newsList) {

        mProgressBar.setVisibility(View.GONE);
        mEmptyStateTextView.setVisibility(View.VISIBLE);
        mEmptyStateTextView.setText(R.string.no_news_found);
        mAdapter.clear();
        if (newsList != null && !newsList.isEmpty()) {
            mEmptyStateTextView.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
            mAdapter.addAll(newsList);
        }

    }

    @Override
    public void onLoaderReset(Loader loader) {
        mAdapter.clear();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        mSearchQueryText = query;
       restartLoader();
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search));
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {

                Log.e(LOG_TAG, "onClosedListener called");
                searchView.onActionViewCollapsed();
                mSearchQueryText = null;
                restartLoader();
                return true;
            }
        });
        return true;
    }

    private void restartLoader() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            getLoaderManager().restartLoader(NEWS_LOADER_ID, null, this);

        } else {
            mProgressBar.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.GONE);
            mEmptyStateTextView.setVisibility(View.VISIBLE);
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
    }
}
