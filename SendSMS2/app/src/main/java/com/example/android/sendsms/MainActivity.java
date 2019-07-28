package com.example.android.sendsms;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//    public void sendSMS(View v)
//    {
//        String number = "03453235126";  // The number on which you want to send SMS
//        startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));
//    }

     public void sendSMS(View v)
      {
     Uri uri = Uri.parse("smsto:03453235126");
         Intent it = new Intent(Intent.ACTION_SENDTO, uri);
         it.putExtra("sms_body", "Here you can set the SMS text to be sent");
         startActivity(it);
      }
}
