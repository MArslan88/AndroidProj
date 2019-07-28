package com.example.android.assignment7.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.assignment7.R;
import com.example.android.assignment7.model.Student;

import java.util.ArrayList;

/**
 * Created by lab2 on 2017-07-23.
 */
public class StudentAdapter extends RecyclerView.Adapter<CustomeViewHolder>{
    private ArrayList<Student> students;

    public StudentAdapter(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public CustomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View myItemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        CustomeViewHolder customeViewHolder=new CustomeViewHolder(myItemView);

        return customeViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomeViewHolder holder, int position) {
        Student mystudent=students.get(position);
        holder.mUserName.setText(mystudent.getStudentName());
        holder.mCourse.setText(mystudent.getStudentCourse());

    }

    @Override
    public int getItemCount() {
        return ;
    }
}
