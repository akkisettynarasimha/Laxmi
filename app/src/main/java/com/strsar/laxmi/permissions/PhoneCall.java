package com.strsar.laxmi.permissions;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.strsar.laxmi.R;

public class PhoneCall extends AppCompatActivity {

    EditText editText;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);

        editText = (EditText) findViewById(R.id.editText1);
        button1=(Button)findViewById(R.id.button1);
//Performing action on button click
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {

             /*   if (ActivityCompat.checkSelfPermission(PhoneCall.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    startActivity(callIntent);
                    return;
                }*/

            }
        });
    }
}
