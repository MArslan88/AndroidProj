package com.example.muhammadarslan.sqldatabase;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText edtId, edtName, edtSurName, edtMarks;
    Button btnAdd;
    Button btnViewAll;
    Button btnUpdate;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new DataBaseHelper(this);

        edtId=(EditText)findViewById(R.id.idEdt);
        edtName=(EditText)findViewById(R.id.nameEdt);
        edtSurName=(EditText)findViewById(R.id.surnameEdt);
        edtMarks=(EditText)findViewById(R.id.marksEdt);
        btnAdd=(Button)findViewById(R.id.addBtn);
        btnViewAll=(Button)findViewById(R.id.viewBtn);
        btnUpdate=(Button)findViewById(R.id.updateBtn);
        btnDelete=(Button)findViewById(R.id.deleteBtn);
        AddData();
        ViewAll();
        UpdateData();
        DeleteData();
    }

    public void UpdateData(){
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdate= myDb.updatData(edtId.getText().toString(),edtName.getText().toString(),
                        edtSurName.getText().toString(),edtMarks.getText().toString());
                if(isUpdate==true)
                    Toast.makeText(MainActivity.this,"Data is Updated",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Data is not Updated",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void AddData(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               boolean isInserted = myDb.inserData(edtName.getText().toString(),edtSurName.getText().toString(),edtMarks.getText().toString());
                if(isInserted==true)
                    Toast.makeText(MainActivity.this,"Data is inserted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Data is not inserted",Toast.LENGTH_SHORT).show();
            }
        });

        edtName.setText("");

    }
    public void DeleteData(){
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deleteRows=myDb.deleteData(edtId.getText().toString());
                if (deleteRows >0)
                    Toast.makeText(MainActivity.this,"Data is Deleted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Data is not Deleted",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ViewAll(){
        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=myDb.getAllData();
                if(res.getCount()==0){
                    // Show Message
                    showMessage("Error","No data found...!");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Id :"+ res.getString(0) +"\n");
                    buffer.append("Name :"+ res.getString(1) +"\n");
                    buffer.append("SurName :"+ res.getString(2) +"\n");
                    buffer.append("Marks :"+ res.getString(3) +"\n\n");
                }
                // Show All Data
                showMessage("Data",buffer.toString());
            }
        });
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
