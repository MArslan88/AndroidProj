package com.example.android.project3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCLickSubmitButton(View view) {

        int score = 0;
        int totalQuestion = 8;

        RadioButton radioButton = (RadioButton) findViewById(R.id.question_1_correct_option);
        if (radioButton.isChecked()) {
            score++;
        }

        radioButton = (RadioButton) findViewById(R.id.question_2_correct_option);
        if (radioButton.isChecked()) {
            score++;
        }
        radioButton = (RadioButton) findViewById(R.id.question_3_correct_option);
        if (radioButton.isChecked()) {
            score++;
        }
        radioButton = (RadioButton) findViewById(R.id.question_4_correct_option);
        if (radioButton.isChecked()) {
            score++;
        }
        radioButton = (RadioButton) findViewById(R.id.question_5_correct_option);
        if (radioButton.isChecked()) {
            score++;
        }
        radioButton = (RadioButton) findViewById(R.id.question_6_correct_option);
        if (radioButton.isChecked()) {
            score++;
        }

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.question_7_1st_correct_option);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.question_7_2nd_correct_option);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.question_7_3rd_correct_option);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.question_7_wrong_option);
        if (checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && !checkBox4.isChecked()) {

            score++;
        }

         checkBox1 = (CheckBox) findViewById(R.id.question_8_1st_correct_option);
         checkBox2 = (CheckBox) findViewById(R.id.question_8_2nd_correct_option);
         checkBox3 = (CheckBox) findViewById(R.id.question_8_1st_wrong_option);
         checkBox4 = (CheckBox) findViewById(R.id.question_8_2nd_wrong_option);
        if (checkBox1.isChecked() && checkBox2.isChecked() && !checkBox3.isChecked() && !checkBox4.isChecked()) {

            score++;
        }
        Toast.makeText(this,score+" out of "+totalQuestion+" are correct",Toast.LENGTH_SHORT).show();
        displayScore(score);
    }

    public void displayScore(int score) {

        TextView textView = (TextView) findViewById(R.id.score_display_text_view);
        textView.setText(String.valueOf(score));
    }

}
