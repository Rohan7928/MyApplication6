package com.example.myapplication6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Send_email extends AppCompatActivity {
 EditText to,subject,message;
 Button sendemail;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
        to=findViewById(R.id.toemail);
        message=findViewById(R.id.emailmessage);
        subject=findViewById(R.id.emailsubject);
        sendemail=findViewById(R.id.send);
        sendemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendEmail();
            }
        });
    }

    private void SendEmail() {
     String recepentlist=to.getText().toString().trim();
     String[] recepent=recepentlist.split(",");
     String mailsubject=subject.getText().toString();
     String mailmessage=message.getText().toString();
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recepent);
        intent.putExtra(Intent.EXTRA_SUBJECT,mailsubject);
        intent.putExtra(Intent.EXTRA_TEXT,mailmessage);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose an email content"));
    }
}
