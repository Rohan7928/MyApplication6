package com.example.myapplication6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Myholder> {
    Context context;
    ArrayList<Student> arrayList;

    public RecyclerAdapter(Home_page home_page, ArrayList<Student> students) {
        this.context=home_page;
        this.arrayList=students;
    }

    @NonNull
    @Override
    public RecyclerAdapter.Myholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.home_data,viewGroup,false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.Myholder myholder, int i) {
        Student student=arrayList.get(i);
        myholder.getname.setText(student.getName());
        myholder.getmarks.setText(student.getMarks());
        myholder.imageView.setImageBitmap(convertToBitmap(student.getPhoto()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
       TextView getname,getmarks;
       ImageView imageView;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            getname=itemView.findViewById(R.id.get_name);
            getmarks=itemView.findViewById(R.id.get_marks);
           imageView=itemView.findViewById(R.id.get_photo);
        }

    }
    private Bitmap convertToBitmap(byte[] b){

        return BitmapFactory.decodeByteArray(b, 0, b.length);

    }
}
