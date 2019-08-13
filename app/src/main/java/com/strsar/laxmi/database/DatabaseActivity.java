package com.strsar.laxmi.database;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.strsar.laxmi.R;

public class DatabaseActivity extends AppCompatActivity {

    DbHelder dbHelder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        dbHelder = new DbHelder(DatabaseActivity.this, null, null, 1);

       boolean b= dbHelder.notificationInsert("","2019-7-3","2019-7-21");
       if(b){
           Toast.makeText(DatabaseActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
       }else {
           Toast.makeText(DatabaseActivity.this, "Not Inserted", Toast.LENGTH_SHORT).show();
       }

       Cursor cursor= dbHelder.getSelectedData();
       System.out.println("cursor_get_count"+cursor.getCount());

    }
}
