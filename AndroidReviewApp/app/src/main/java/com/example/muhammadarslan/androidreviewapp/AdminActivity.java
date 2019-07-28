package com.example.muhammadarslan.androidreviewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

public class AdminActivity extends AppCompatActivity {


    private static final int RC_PHOTO_PICKER =  2;
    ImageView mMoviePicture;
    EditText mMovieName;
    EditText mMovieType;
    EditText mMovieURL;
    EditText mMovieDescription;
    RatingBar mMovieRating;
    Button mSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        mMoviePicture=(ImageView)findViewById(R.id.movie_pic);
        mMovieName=(EditText)findViewById(R.id.movie_name);
        mMovieType=(EditText)findViewById(R.id.movie_type);
        mMovieURL=(EditText)findViewById(R.id.movie_url);
        mMovieDescription=(EditText)findViewById(R.id.movie_description);
        mMovieRating=(RatingBar)findViewById(R.id.movie_rating);
        mSaveButton=(Button)findViewById(R.id.saveBtn);

        mMoviePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Fire an intent to show an image picker
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                startActivityForResult(Intent.createChooser(intent, "Complete action using"), RC_PHOTO_PICKER);
            }
        });



    }
}
