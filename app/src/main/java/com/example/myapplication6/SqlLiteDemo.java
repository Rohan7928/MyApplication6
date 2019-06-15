package com.example.myapplication6;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class SqlLiteDemo extends AppCompatActivity {
    Dataabse_demo mydb;
    EditText ename, emarks, id;
    Button add,photo;
    Button view, update, delete;
    ListView listView;
    ImageView getimage;
    private int PICK_IMAGE_REQUEST = 1;
    ArrayList<Student> arrayList;
    byte[] b;
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_lite_demo);
        mydb = new Dataabse_demo(this);
        ename = findViewById(R.id.name);
        id = findViewById(R.id.Id);
        emarks = findViewById(R.id.marks);
        add = findViewById(R.id.Add_Data);
        photo=findViewById(R.id.Add_photo);
        view = findViewById(R.id.View_Data);
        update = findViewById(R.id.Update_Data);
        delete = findViewById(R.id.Delete_Data);
        listView = findViewById(R.id.list_data);
        getimage=findViewById(R.id.Get_Image);
        arrayList = new ArrayList<Student>();

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "working", Toast.LENGTH_SHORT).show();
                arrayList = mydb.getData();
                MyAdapter adapter = new MyAdapter(SqlLiteDemo.this, arrayList);
                listView.setAdapter(adapter);
            }
        });

        //OPen FileManager
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
// Show only images, no videos or anything else
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
// Always show the chooser (if there are multiple options available)
                startActivityForResult(intent, PICK_IMAGE_REQUEST);

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateData();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteData();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etname = ename.getText().toString();
                String etmarks = emarks.getText().toString();

                Boolean isinserted = mydb.insertdata(etname, etmarks,b);
                if (isinserted = true) {
                    Toast.makeText(SqlLiteDemo.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SqlLiteDemo.this, "Data is not Inserted", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void DeleteData() {
        String ID = id.getText().toString();
        Integer deletedata = mydb.deletedata(ID);
        if (deletedata > 0) {
            Toast.makeText(this, "Data is Deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Data is not Deleted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));
                b=getBytes(bitmap);
                ImageView imageView = (ImageView) findViewById(R.id.Get_Image);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    // convert from byte array to bitmap
    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
    private void UpdateData() {
        String Id = id.getText().toString();
        String Name = ename.getText().toString();
        String Marks = emarks.getText().toString();

        Boolean isUpdate = mydb.updatedata(Id, Name, Marks);
        if (isUpdate == true) {
            Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Data is not Updated", Toast.LENGTH_SHORT).show();

        }
    }
}

             /* Cursor cursor=mydb.getData();
             if(cursor.getCount()==0)
             {

                 showmessage("Error","No Data Found");
                 return;
             }
             else
             {
                 StringBuffer buffer=new StringBuffer();
                 while (cursor.moveToNext())
                 {
                    *//* arrayList.add(cursor.getString(0));
                     ListAdapter listAdapter=new ArrayAdapter<>(getApplication(),R.layout.activity_sql_lite_demo,arrayList);
                     listView.setAdapter(listAdapter);
                    *//* buffer.append("id:"+cursor.getString(0)+"\n");
                     buffer.append("Name:"+cursor.getString(1)+"\n");
                     buffer.append("Marks:"+cursor.getString(2)+"\n\n");
                 }
             showmessage("Data",buffer.toString());
             }
         }
     });*/


     /*    public void showmessage(String title, String message) {
             AlertDialog.Builder builder = new AlertDialog.Builder(this);
             builder.setCancelable(true);
             builder.setTitle(title);
             builder.setMessage(message);
             builder.show();
         }

*/