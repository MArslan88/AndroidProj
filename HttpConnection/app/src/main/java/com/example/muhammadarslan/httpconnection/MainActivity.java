package com.example.muhammadarslan.httpconnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView=(TextView)findViewById(R.id.myTextView);
        Button btn=(Button)findViewById(R.id.callHttp);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyTask myTask=new MyTask(textView);
                myTask.execute("https://www.googleapis.com/books/v1/volumes?q=android");
            }
        });
    }
}
