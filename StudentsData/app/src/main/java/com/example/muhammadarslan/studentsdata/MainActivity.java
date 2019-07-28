package com.example.muhammadarslan.studentsdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView addStudentData=(TextView) findViewById(R.id.addRecordBtn);
        TextView searchBtn=(TextView) findViewById(R.id.searchBtn);
        TextView viewBtn=(TextView) findViewById(R.id.viewBtn);

        addStudentData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addStudentIntent=new Intent(MainActivity.this,AddStudentData.class);

                //Start the new activity
                startActivity(addStudentIntent);
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchDataIntent=new Intent(MainActivity.this,SearchStudentData.class);

                //Start the new activity
                startActivity(searchDataIntent);
            }
        });

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewAllDataIntent=new Intent(MainActivity.this,ViewAllData.class);

                //Start the new activity
                startActivity(viewAllDataIntent);
            }
        });
    }
}
