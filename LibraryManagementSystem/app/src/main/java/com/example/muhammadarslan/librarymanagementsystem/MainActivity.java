package com.example.muhammadarslan.librarymanagementsystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;



public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private ProgressDialog progressDialog;
    private FirebaseDatabase firebaseDatabase;


    private EditText userId;
    private EditText userPassword;
    private Spinner spinnerUserType;
    String user_type;
    String user_id;
    String uid;
    public static final int RC_SIGN_IN = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userId = (EditText)findViewById(R.id.userId);
        userPassword = (EditText)findViewById(R.id.password);
        spinnerUserType = (Spinner)findViewById(R.id.spinner);

        Button signIn = (Button) findViewById(R.id.signIn);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(this);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user !=null){
                    // user is signed in
                    Toast.makeText(MainActivity.this, "You're now signed in", Toast.LENGTH_SHORT).show();
                }else {
                    // user is signed out
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setProviders(
                                            AuthUI.EMAIL_PROVIDER)
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SIGN_IN){
            if(requestCode == RESULT_OK){
                Toast.makeText(this, "Signed In", Toast.LENGTH_SHORT).show();
            }else if(requestCode ==RESULT_CANCELED){
                Toast.makeText(this, "Sign in canceled", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        firebaseAuth.removeAuthStateListener(mAuthStateListener);
    }



    @Override
    protected void onResume() {
        super.onResume();
        firebaseAuth.addAuthStateListener(mAuthStateListener);
        if(uid != null && user_type.equals("Admin")){
            Intent intent = new Intent(MainActivity.this,AdminActivity.class);
            startActivity(intent);
        }else if(uid !=null && user_type.equals("User")){
            Intent intent = new Intent(MainActivity.this,BooksShowCase.class);
            startActivity(intent);
        }

    }

    private void registerUser(){
        String email=userId.getText().toString().trim();
        final String password=userPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this,"Pleas enter your email",Toast.LENGTH_SHORT).show();
            // Stoping the function for further execution
            return;
        }

        if(TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this,"Pleas enter your password",Toast.LENGTH_SHORT).show();
            // Stoping the function for further execution
            return;
        }
        //if validations are ok
        //we will first show progressbar
        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //user is successfully registered and loged in
                    //we will start the profile activity here
                    //right now lets display a Toast only
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,"Registed Successfully",Toast.LENGTH_SHORT).show();

                    user_type= spinnerUserType.getSelectedItem().toString();

                    uid = firebaseAuth.getCurrentUser().getUid();
                    firebaseDatabase.getReference().child("users/" +uid).setValue(new User(userId.getText().toString(),user_type));

                    if(user_type.equals("Admin")){
                        // Admin's Activities shows
                        Intent intent = new Intent(MainActivity.this,AdminActivity.class);
                        startActivity(intent);
                    }else{
                        // user's Activities shows
                        Intent intent = new Intent(MainActivity.this,BooksShowCase.class);
                        startActivity(intent);
                    }

                }else {
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,"Could not registed, please try again...!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
