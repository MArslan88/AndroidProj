package com.example.muhammadarslan.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Name> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtName=(EditText)findViewById(R.id.edtName);
        Button btnAdd=(Button)findViewById(R.id.btnAdd);
        final MySqliteHelper mySqliteHelper=new MySqliteHelper(this);

        contacts=new ArrayList<>();
        ListView myListView = (ListView) findViewById(R.id.myList);
        final MyListAdapter listAdapter = new MyListAdapter(this,contacts,mySqliteHelper);
        myListView.setAdapter(listAdapter);

        // This will get the DATA from DB on the begining of app
        contacts.clear();
        contacts.addAll(mySqliteHelper.getContacts());
        listAdapter.notifyDataSetChanged();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName=edtName.getText().toString();
                Name contact=new Name(strName);

                long id= mySqliteHelper.addName(contact);

                // This will get the DATA from DB after adding in ArrayList
                contacts.clear();
                contacts.addAll(mySqliteHelper.getContacts());
                listAdapter.notifyDataSetChanged();

                // To empty the EDITVIEW after entering and getting data on DB
                edtName.setText("");
            }
        });

    }
}
