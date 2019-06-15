package com.example.myapplication6;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_Camera extends Fragment {
    Button bsubmit;
    EditText ename,epass;
    Intent chooser=null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_camera,null);
        ename=view.findViewById(R.id.etname);
        epass=view.findViewById(R.id.etpass);
        bsubmit=view.findViewById(R.id.btnsubmit);
        bsubmit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
        String user=ename.getText().toString();
        String pass=epass.getText().toString();
        if(user.equals("rohan") && pass.equals("rohna123")) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setData(Uri.parse("mailto:"));
            String[] to={"Rohan7928@gmail.com"};
            i.putExtra(Intent.EXTRA_EMAIL,to);
            i.putExtra(Intent.EXTRA_SUBJECT,"Welcome");
            i.putExtra(Intent.EXTRA_TEXT,"This is your Data");
            i.setType("message/rfc822");
            chooser=Intent.createChooser(i,"Send Email");
            startActivity(chooser);
        }
        else
        {
            Toast.makeText(getContext(), "doesn't match", Toast.LENGTH_SHORT).show();
        }

           }
       });
        return view;
    }
}
