package com.strsar.laxmi.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.strsar.laxmi.R;

public class ActivityLifeCycle extends AppCompatActivity {

    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("start"+i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("resume"+i);
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("pause"+i);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("restart"+i);
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("stop"+i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    System.out.println("Destroy"+i);
    }
}
