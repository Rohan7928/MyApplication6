package com.example.myapplication6;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Student {


    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(int id, String name, String marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    public Student()
    {

    }

    String name;
    String marks;

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    byte[] photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }




}
