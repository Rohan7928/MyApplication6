package com.example.myapplication6;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_layout extends AppCompatActivity {
    TextView chat,status,call;

    ViewPager viewPager;
    TabLayout tabLayout;

    PagerViewAdapter pagerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_layout);

        chat=findViewById(R.id.Chat);
        call=findViewById(R.id.Call);


        viewPager=findViewById(R.id.fragemnt_container);
        status=findViewById(R.id.Status);

        tabLayout=findViewById(R.id.tab_layout);


        tabLayout.addTab(tabLayout.newTab().setText("Camera"));
        tabLayout.addTab(tabLayout.newTab().setText("Chat"));
        tabLayout.addTab(tabLayout.newTab().setText("Status"));
        tabLayout.addTab(tabLayout.newTab().setText("Call"));


        pagerViewAdapter=new PagerViewAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerViewAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

   /*      camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onPageSelected(int i) {
                onchangetab(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

   @RequiresApi(api = Build.VERSION_CODES.M)
    private void onchangetab(int i) {

        if(i==0)
        {
            camera.setTextSize(25);
            camera.setTextColor(getColor(R.color.colorPrimaryDark));

            chat.setTextSize(20);

            camera.setTextColor(getColor(R.color.colorPrimary));
            status.setTextSize(20);

            camera.setTextColor(getColor(R.color.colorPrimary));

            call.setTextSize(20);
            camera.setTextColor(getColor(R.color.colorPrimary));
        }
       if(i==1)
       {
           camera.setTextSize(20);
           camera.setTextColor(getColor(R.color.colorPrimary));

           chat.setTextSize(25);

           camera.setTextColor(getColor(R.color.colorPrimaryDark));
           status.setTextSize(20);

           camera.setTextColor(getColor(R.color.colorPrimary));

           call.setTextSize(20);
           camera.setTextColor(getColor(R.color.colorPrimary));
       }
        if(i==1)
        {
            camera.setTextSize(20);
            camera.setTextColor(getColor(R.color.colorPrimary));

            chat.setTextSize(20);

            camera.setTextColor(getColor(R.color.colorPrimary));
            status.setTextSize(25);

            camera.setTextColor(getColor(R.color.colorPrimaryDark));

            call.setTextSize(20);
            camera.setTextColor(getColor(R.color.colorPrimary));
        }
        if(i==1)
        {
            camera.setTextSize(20);
            camera.setTextColor(getColor(R.color.colorPrimary));

            chat.setTextSize(20);

            camera.setTextColor(getColor(R.color.colorPrimary));
            status.setTextSize(20);

            camera.setTextColor(getColor(R.color.colorPrimary));

            call.setTextSize(25);
            camera.setTextColor(getColor(R.color.colorPrimaryDark));
        }*/
    }

}
