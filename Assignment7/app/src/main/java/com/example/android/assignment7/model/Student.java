package com.example.android.assignment7.model;

/**
 * Created by lab2 on 2017-07-23.
 */
public class Student {
    private String studentName;
    private String studentCourse;

    public Student(String student_name,String student_course){
        this.studentName=student_name;
        this.studentCourse=student_course;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }
}
