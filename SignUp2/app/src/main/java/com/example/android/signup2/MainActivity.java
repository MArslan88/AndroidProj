package com.example.android.signup2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnsubmit=(Button)findViewById(R.id.submit);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView username=(TextView)findViewById(R.id.userName);
                if(username.getText().toString().isEmpty()){
                    username.setHintTextColor(Color.RED);
                }

                TextView emailId=(TextView)findViewById(R.id.email);
                if(emailId.getText().toString().isEmpty()){
                    emailId.setHintTextColor(Color.RED);
                }else if(!emailId.getText().toString().contains("@") || !emailId.getText().toString().contains(".com")) {
                    Toast.makeText(MainActivity.this,"Please insert correct email",Toast.LENGTH_SHORT).show();
                }

                TextView password=(TextView)findViewById(R.id.password);
                if(password.getText().toString().isEmpty()){
                    password.setHintTextColor(Color.RED);
                }

                TextView confirmPassword=(TextView)findViewById(R.id.confPass);
                if(confirmPassword.getText().toString().isEmpty()){
                    confirmPassword.setHintTextColor(Color.RED);
                }
            }
        });
    }



}
