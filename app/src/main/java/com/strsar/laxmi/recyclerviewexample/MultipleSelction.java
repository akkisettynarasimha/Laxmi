package com.strsar.laxmi.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.strsar.laxmi.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultipleSelction extends AppCompatActivity {
    private List<Model> mModelList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_selction);
        button=(Button)findViewById(R.id.button);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new RecyclerViewAdapter(getListData(),this);
        LinearLayoutManager manager = new LinearLayoutManager(MultipleSelction.this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter = new RecyclerViewAdapter(getListChange(),MultipleSelction.this);
                LinearLayoutManager manager = new LinearLayoutManager(MultipleSelction.this);
                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setLayoutManager(manager);
                mRecyclerView.setAdapter(mAdapter);
            }
        });

    }
    private List<Model> getListData() {
            mModelList = new ArrayList<>();

            mModelList.add(new Model("TextView " ,0));
            mModelList.add(new Model("TextView " ,3));
            mModelList.add(new Model("TextView " ,0));
            mModelList.add(new Model("TextView " ,2));
            mModelList.add(new Model("TextView " ,0));
            mModelList.add(new Model("TextView " ,1));

        return mModelList;
    }
    private List<Model> getListChange() {
        mModelList = new ArrayList<>();

        mModelList.add(new Model("TextView " ,0));
        mModelList.add(new Model("TextView " ,3));
        mModelList.add(new Model("TextView " ,0));
        mModelList.add(new Model("TextView " ,2));
        mModelList.add(new Model("TextView " ,0));
        mModelList.add(new Model("TextView " ,1));

            System.out.println("UnSorted ");
            for(int i=0;i<mModelList.size();i++){

                System.out.println("Mounika :"+mModelList.get(i));
                Collections.sort(mModelList,new Sortbyroll());
            }

            System.out.println("Sorting :");
            for(int j=0;j<mModelList.size();j++){

                System.out.println("Narasimha :"+mModelList.get(j));
            }
        return mModelList;
    }
}
