package com.example.muhammadarslan.newsfeedapp.Utilities;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by saqib on 25-Aug-17.
 */

public class QueryUtils {

    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils() {

    }


    public static List<News> fetchDataFromNetwork(String requestUrl) {

        URL url = createUrl(requestUrl);

        String jsonResponse = null;
        try {
            jsonResponse = makeHTTPRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG , "Problem making the HTTP request" , e);
        }

        List<News> newsList = extractFeaturesFromJson(jsonResponse);

        return newsList;

    }

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG , "Error with creating Url " ,e);
        }
        return  url;
    }
    private  static String makeHTTPRequest(URL url) throws IOException {

        String jsonResponse = "";

        if(url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try{
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000); //in milliseconds
            urlConnection.setConnectTimeout(15000); //in milliseonds;
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if(urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG , "Error response Code: "+ urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG , "Problem retrieving the newsfeed JSON results ", e);
        } finally {
            if(urlConnection != null) {
                urlConnection.disconnect();
            }
            if(inputStream != null) {
                inputStream.close();
            }
        }

        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();

        if(inputStream != null) {

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream , Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }

        return output.toString();
    }

    private static List<News> extractFeaturesFromJson(String jsonResponse) {

        if(TextUtils.isEmpty(jsonResponse)) {
            return null;
        }

        List<News> newsList = new ArrayList<>();

        try {
            JSONObject baseJsonResponse = new JSONObject(jsonResponse);
            JSONObject responseJsonObject = baseJsonResponse.getJSONObject("response");
            JSONArray resultsJsonArray = responseJsonObject.optJSONArray("results");

            for ( int i = 0 ; i < resultsJsonArray.length() ; i++) {

                JSONObject currentNews = resultsJsonArray.getJSONObject(i);
                String section = currentNews.optString("sectionName");
                String title = currentNews.optString("webTitle");
                String type = currentNews.optString("type");
                String datePublished = currentNews.optString("webPublicationDate");
                String url = currentNews.optString("webUrl");


                newsList.add( new News(section, title, type, datePublished, url));
            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e(LOG_TAG, "Problem parsing the newsfeed JSON results", e);
        }
        return newsList;
    }
}
