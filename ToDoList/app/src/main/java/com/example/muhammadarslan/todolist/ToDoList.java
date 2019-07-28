package com.example.muhammadarslan.todolist;

import com.orm.SugarRecord;

/**
 * Created by Muhammad Arslan on 10/15/2017.
 */

public class ToDoList extends SugarRecord<ToDoList> {
    private String name;
    private int age;

    public ToDoList(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
