package com.strsar.laxmi.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.strsar.laxmi.R;

public class FragmentTwo extends Fragment{

    public static final String TAG="fragment";

    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG,"onAttach2");
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate2");

    }
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_tow, container,false);

    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"onStart2");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume2");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause2");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"onStop2");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG,"onDestroyView2");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDetroy2");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"onDetach2");

    }
}
