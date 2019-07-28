package com.example.muhammadarslan.contactmanager;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchData extends AppCompatActivity {

    EditText etSearch;
    Button btnSearch;
    TextView tvName,tvEmail;
    DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);

        dataBaseHelper=new DataBaseHelper(this);
        etSearch=findViewById(R.id.etSearch);
        btnSearch=findViewById(R.id.btnSearch);
        tvName=findViewById(R.id.tvName);
        tvEmail=findViewById(R.id.tvEmail);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor=dataBaseHelper.getData(etSearch.getText().toString());
                tvName.setText("");
                tvEmail.setText("");

                while (cursor.moveToNext()){
                    tvName.setText(cursor.getString(1));
                    tvEmail.setText(cursor.getString(3));
                }
            }
        });
    }
}
