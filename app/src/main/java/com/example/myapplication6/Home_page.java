package com.example.myapplication6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home_page extends AppCompatActivity {
   RecyclerView recyclerView;
   Dataabse_demo db;
   ArrayList<Student> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        db=new Dataabse_demo(this);
        arrayList=new ArrayList<Student>();
        recyclerView=findViewById(R.id.recycle_view);
        Toast.makeText(getApplicationContext(),"Working",Toast.LENGTH_SHORT).show();
        arrayList=db.getData();
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(this,arrayList);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(Home_page.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);


        recyclerView.setAdapter(recyclerAdapter);

    }

}
