package com.example.android.assignment7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.assignment7.adapter.StudentAdapter;
import com.example.android.assignment7.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Student> students=new ArrayList<>();
        students.add(new Student("student1","course1"));
        students.add(new Student("student2","course2"));
        students.add(new Student("student3","course3"));
        students.add(new Student("student4","course4"));

        recyclerView=(RecyclerView) findViewById(R.id.rv_item);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);

        StudentAdapter studentAdapter=new StudentAdapter(students);
        recyclerView.setAdapter(studentAdapter);
    }
}
