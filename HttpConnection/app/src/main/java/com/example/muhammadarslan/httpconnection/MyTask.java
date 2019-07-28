package com.example.muhammadarslan.httpconnection;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Muhammad Arslan on 9/10/2017.
 */

public class MyTask extends AsyncTask<String,Void,String> {
    TextView textView;

    public MyTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(String... strings) {
        String response="";
        try{
            URL url=new URL(strings[0]);
            HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
            BufferedReader br=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line=br.readLine()) !=null){
                response +=line;
            }
            br.close();
        }
        catch (java.io.IOException e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
       textView.setText(s);
    }
}
