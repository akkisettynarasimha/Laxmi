package com.strsar.laxmi.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.strsar.laxmi.R;

public class FragmentOne extends Fragment {

    public static final String TAG="fragment";
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG,"onAttach");
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView");

        return inflater.inflate(R.layout.fragment_one, container, false);

    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"onActivityCreated");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG,"onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDetroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"onDetach");

    }
}