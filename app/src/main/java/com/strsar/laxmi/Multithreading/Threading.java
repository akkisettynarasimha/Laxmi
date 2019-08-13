package com.strsar.laxmi.Multithreading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.strsar.laxmi.R;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Threading extends AppCompatActivity {

    TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threading);
        textview=(TextView)findViewById(R.id.textview);
        try {
        for(int i=2;i<3;i++){

       //
            textview.setText(""+i);
            Thread.sleep(200);

        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
