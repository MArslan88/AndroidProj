package com.example.muhammadarslan.screenorientation;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score;
    EditText et;
    String etString;
    Button bIncrement,bShowValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score=0;
        et=(EditText)findViewById(R.id.et_EditText);
        bIncrement=(Button)findViewById(R.id.bIncrement);
        bShowValue=(Button)findViewById(R.id.bShowValue);


        bIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score +=1;
            }
        });

        bShowValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Your SCORE is "+score, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override //this will save the data when activity will be destroy
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        etString=et.getText().toString();

        outState.putString("edittext",etString);
        outState.putInt("score",score);
    }

    @Override  // this will retrieve the data when activity will be back in landscape mode or vice versa
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        et.setText(savedInstanceState.getString("edittext"));
        score=savedInstanceState.getInt("score");

    }
}
