package com.strsar.laxmi.stringhandleing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.strsar.laxmi.R;

public class StrSplit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_str_split);
        String strMain = "Alpha, Beta, Delta, Gamma, Sigma";
        String[] arrSplit = strMain.split(", ");
        for (int i=0; i < arrSplit.length; i++)
        {
            System.out.println("narasimha"+arrSplit[i]);
        }
    }
}
