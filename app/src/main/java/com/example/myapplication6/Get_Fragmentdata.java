package com.example.myapplication6;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Get_Fragmentdata extends AppCompatActivity {
   EditText user,pass;
   Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get__fragmentdata);
       user=findViewById(R.id.username);
       pass=findViewById(R.id.userpass);
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        //Fragment_Camera camera=new Fragment_Camera();
        //transaction.add(R.id.linear,camera);
        transaction.commit();
        bundle=getIntent().getExtras();
        String name=bundle.getString("username");
        String password=bundle.getString("pass");
        user.setText(name);
        pass.setText(password);

    }

}
