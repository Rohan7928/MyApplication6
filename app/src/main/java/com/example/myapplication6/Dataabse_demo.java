package com.example.myapplication6;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Blob;
import java.util.ArrayList;

public class Dataabse_demo extends SQLiteOpenHelper {
public static final String DATABASE_NAME="student1.db";
public static final String TABLE_NAME="student";
public static final String Col_1="ID";
public static final String Col_2="NAME";
public static final String Col_3="MARKS";
public static final String Col_4="PHOTO";
    byte[] b;
    public Dataabse_demo(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MARKS INTEGER,PHOTO BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public Boolean insertdata(String name, String marks, byte[] photo)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col_2,name);
        contentValues.put(Col_3,marks);
        contentValues.put(Col_4,photo);

        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;

        }
    }
    public ArrayList<Student> getData()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        ArrayList<Student> students=new ArrayList<>();
        String query="SELECT * FROM "+ TABLE_NAME;
        Cursor cursor= db.rawQuery(query,null);
      if(cursor!=null)
      {
          if(cursor.moveToFirst())
          {
              do {
                  Student student=new Student();
                  student.setId(cursor.getInt(cursor.getColumnIndex(Col_1)));
                  student.setName(cursor.getString(cursor.getColumnIndex(Col_2)));
                  student.setMarks(cursor.getString(cursor.getColumnIndex(Col_3)));
                  b=cursor.getBlob(cursor.getColumnIndex(Col_4));
                student.setPhoto(b);
                  students.add(student);
              }
              while (cursor.moveToNext());
          }
      }
        return  students;


    }
    public Boolean updatedata(String id,String name,String marks)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put(Col_1,id);
        content.put(Col_2,name);
        content.put(Col_3,marks);
        db.update(TABLE_NAME,content,"ID = ?",new String[]{id});
        return true;
    }
    public Integer deletedata(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
       return db.delete(TABLE_NAME,"ID = ?",new String[]{id});

    }
}
