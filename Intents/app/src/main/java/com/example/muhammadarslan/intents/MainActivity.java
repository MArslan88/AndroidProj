package com.example.muhammadarslan.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button clickBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickBtn=(Button)findViewById(R.id.clickBtn);

        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(MainActivity.this,"Activity is calling",Toast.LENGTH_SHORT);
                toast.show();
                Intent intent=new Intent(MainActivity.this,ActivityOne.class);
                startActivity(intent);
            }
        });
    }

}
