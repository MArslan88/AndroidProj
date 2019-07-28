package com.example.muhammadarslan.jsonparsingusinggson;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Muhammad Arslan on 9/1/2018.
 */

public class MySingleton {
    private static MySingleton mInstances;
    private RequestQueue requestQueue;
    private static Context mCtx;

    private MySingleton(Context context){
        mCtx = context;
        requestQueue = getRequestQueue();
    }

    private RequestQueue getRequestQueue(){
        if(requestQueue == null)
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        return requestQueue;

    }

    public static synchronized MySingleton getmInstances(Context context){
        if(mInstances == null){
            mInstances = new MySingleton(context);
        }
        return mInstances;
    }
    public<T> void addToRequestQue(Request<T> request){
        getRequestQueue().add(request);
    }
}
