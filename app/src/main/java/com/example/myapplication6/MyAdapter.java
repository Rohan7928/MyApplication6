package com.example.myapplication6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication6.R;
import com.example.myapplication6.Student;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter
{
    Context context;
    ArrayList<Student> list;
    public MyAdapter(Context context,ArrayList<Student> arrayList)
    {
        this.context=context;
        this.list=arrayList;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.mylayout,parent,false);
        TextView tvid,tvname,tvmarks;
        ImageView showimage;
        Student student=list.get(position);

        tvid=convertView.findViewById(R.id.et_id);
        tvname=convertView.findViewById(R.id.et_name);
        tvmarks=convertView.findViewById(R.id.et_marks);
        showimage=convertView.findViewById(R.id.show_image);


        tvid.setText(String.valueOf(student.getId()));
        tvname.setText(student.getName());
        tvmarks.setText(student.getMarks());
        showimage.setImageBitmap(convertToBitmap(student.getPhoto()));
        return convertView;
    }
    private Bitmap convertToBitmap(byte[] b){

        return BitmapFactory.decodeByteArray(b, 0, b.length);

    }
}
