package com.example.myapplication6;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class phone_call extends AppCompatActivity {
   EditText phnnumber;
   TextView currentdate;
   Button callnumber,changedate,gettoggle;
    DatePicker datePicker;
    ToggleButton t1,t2;
    RatingBar rating;
   private static int Request_call=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);
       phnnumber=findViewById(R.id.number);
       callnumber=findViewById(R.id.call);
       currentdate=findViewById(R.id.current_date);
       changedate=findViewById(R.id.change_date);
       gettoggle=findViewById(R.id.get_toggle);
       datePicker=findViewById(R.id.date_picker);
       t1=findViewById(R.id.toggle1);
       t2=findViewById(R.id.toggle2);
       rating=findViewById(R.id.ratebar);
       currentdate.setText("Current Date:"+getcurrentDate());

       changedate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               currentdate.setText("Changed Date" +getcurrentDate());
           }
       });
       gettoggle.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               toggle();
               ratingbar();

           }
       });

    }

    private void ratingbar() {
        String rate=String.valueOf(rating.getRating());
        Toast.makeText(this,"Rating:"+rate, Toast.LENGTH_SHORT).show();

    }

    private void toggle() {
        StringBuilder builder=new StringBuilder();
        builder.append("Toggle1:"+t1.getText());
        builder.append("\nToggle2:"+t2.getText());
        Toast.makeText(this, builder.toString(), Toast.LENGTH_SHORT).show();
    }


    //Date Picker
public String getcurrentDate()
{
    StringBuilder date=new StringBuilder();
    date.append((datePicker.getMonth()+1)+"/");
    date.append(datePicker.getDayOfMonth()+"/");
    date.append(datePicker.getYear());
    return date.toString();
}


    public  void onDialButton(View v)
    {
        makecall();

    }

    private void makecall() {
        String num=phnnumber.getText().toString();
        if(ContextCompat.checkSelfPermission(phone_call.this,
                Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(phone_call.this,
                    new String[]{Manifest.permission.CALL_PHONE},Request_call);
        }
        else
        {
            Intent intent=new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+ num));
            startActivity(intent);

        }

        }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == Request_call)
        {
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
            {
                makecall();
            }
            else
            {
                Toast.makeText(this, "PERISSION DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
