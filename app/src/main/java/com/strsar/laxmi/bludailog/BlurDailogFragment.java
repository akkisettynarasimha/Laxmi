package com.strsar.laxmi.bludailog;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.strsar.laxmi.R;

public class BlurDailogFragment extends AppCompatActivity  implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur_dailog_fragment);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
              SampleDailogFragemt sampleDailogFragemt=   SampleDailogFragemt.newInstance(
                20,12.f,true,false);
              sampleDailogFragemt.show(getFragmentManager(),"blur_sample");
        }

    }
}
