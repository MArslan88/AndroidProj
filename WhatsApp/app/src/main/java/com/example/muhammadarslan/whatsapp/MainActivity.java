package com.example.muhammadarslan.whatsapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ViewPager myViewPager;
    private TabLayout myTabLayout;
    private TabsAccessorAdapter myTabsAccessorAdapter;

    private FirebaseUser currentUser;
    private FirebaseAuth mAuth;
    private DatabaseReference rootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        rootRef = FirebaseDatabase.getInstance().getReference();

        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("WhatsApp"); // Title of the App

        myViewPager = (ViewPager)findViewById(R.id.main_tabs_pager);
        myTabsAccessorAdapter = new TabsAccessorAdapter(getSupportFragmentManager());
        myViewPager.setAdapter(myTabsAccessorAdapter);

        myTabLayout = (TabLayout)findViewById(R.id.main_tabs);
        myTabLayout.setupWithViewPager(myViewPager);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(currentUser == null){
            SendUserToLoginActivity();
        }else{
            verifyUserExistance();
        }
    }

    private void verifyUserExistance() {
        String currentUserID = mAuth.getCurrentUser().getUid(); // to get the User ID
        rootRef.child("Users").child(currentUserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if((dataSnapshot.child("name").exists())){
                    Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                }else{
                    SendUserToSettingsActivity();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if(item.getItemId()==R.id.main_logout_option){ // this will logout the user and send user to LoginActivity
            mAuth.signOut();
            SendUserToLoginActivity();
        }
        if(item.getItemId()==R.id.main_setting_option){
            SendUserToSettingsActivity();
        }
        if(item.getItemId()==R.id.main_create_group_option){
            RequestNewGroup();
        }
        if(item.getItemId()==R.id.main_find_friends_option){
            SendUserToFindFriendsActivity();
        }
        return true;
    }

    private void RequestNewGroup() {
        // will ask the user to enter the group name
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.AlertDialog);
        builder.setTitle("Enter Group Name");

        final EditText groupNameField = new EditText(MainActivity.this);
        groupNameField.setHint("e.g Coding Cafe");
        builder.setView(groupNameField);

        builder.setPositiveButton("Create", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String groupName = groupNameField.getText().toString();

                if(TextUtils.isEmpty(groupName)){
                    Toast.makeText(MainActivity.this, "Please write Group Name", Toast.LENGTH_SHORT).show();
                }else{
                    CreateNewGroup(groupName);
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    private void CreateNewGroup(final String groupName) {
        rootRef.child("Groups").child(groupName).setValue("")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, groupName+" group is created successfully...", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void SendUserToLoginActivity() {
        Intent loginIntent = new Intent(MainActivity.this,LoginActivity.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginIntent);
    }

    private void SendUserToFindFriendsActivity() {
        Intent findFriendsIntent = new Intent(MainActivity.this,FindFriendsActivity.class);
        startActivity(findFriendsIntent);
    }

    private void SendUserToSettingsActivity() {
        Intent settingsIntent = new Intent(MainActivity.this,SettingsActivity.class);
        startActivity(settingsIntent);
    }
}
