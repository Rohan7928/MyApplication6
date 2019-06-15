package com.example.myapplication6;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Message_send extends AppCompatActivity {
    EditText tonumber, tomessage;
    Button sendmessage,changetime;
    TextView currenttime;
    TimePicker timePicker;
    private static int Request_call = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_send);
        tonumber = findViewById(R.id.towhom);
        tomessage = findViewById(R.id.txtmessage);
        sendmessage = findViewById(R.id.sendmessage);
        changetime=findViewById(R.id.change_time);
        currenttime=findViewById(R.id.current_time);
        timePicker=findViewById(R.id.time_picker);
        timePicker.setIs24HourView(false);
        currenttime.setText("Current time:"+getcurrenttime());
        /*LayoutInflater layoutInflater=getLayoutInflater();
        final View layou=layoutInflater.inflate(R.layout.activity_message_send,(ViewGroup)findViewById(R.id.custom_toast));
        *///Time picker
        changetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currenttime.setText("Changed time:"+getcurrenttime());
               /* Toast toast=new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                //toast.setView(layou);
                toast.show();
*/
            }
        });

        //Send Message
        sendmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Message_send.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Message_send.this, new String[]{Manifest.permission.SEND_SMS}, Request_call);
                } else {
                    message();
                }

            }
        });
    }

    //time picker
    public String getcurrenttime()
    {
        String time=timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute();
        return time;
    }


    //Send Message
    private void message() {
        String number = tonumber.getText().toString().trim();
        String message = tomessage.getText().toString().trim();
        if (number.equals("") || message.equals("")) {
            Toast.makeText(this, "Enter Number And Message", Toast.LENGTH_SHORT).show();

        } else {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number, null, message, null, null);
            Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == Request_call)
        {
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                message();
            }
            else
            {
                Toast.makeText(this, "PERMISSION DENIED", Toast.LENGTH_SHORT).show();

            }
        }
    }
}