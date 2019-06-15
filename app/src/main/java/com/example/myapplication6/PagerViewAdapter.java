package com.example.myapplication6;

import android.graphics.Camera;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class PagerViewAdapter extends FragmentStatePagerAdapter {
  int tabcount;
    public PagerViewAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabcount=tabCount;
    }

    @Override
    public Fragment getItem(int i) {
       switch (i)
       {
           case 0:
           {
               Fragment_Camera camera=new Fragment_Camera();
               return camera;
           }
           case 1:
           {
               Fragment_Chat chat=new Fragment_Chat();
               return chat;
           }
           case 2:
           {
               Fragment_Status status=new Fragment_Status();
               return status;
           }
           case 3:
           {
               Fragment_Call call=new Fragment_Call();
               return call;
           }
       }



        return null;
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
