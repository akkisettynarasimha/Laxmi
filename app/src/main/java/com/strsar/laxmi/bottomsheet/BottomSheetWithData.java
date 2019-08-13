package com.strsar.laxmi.bottomsheet;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.strsar.laxmi.R;

public class BottomSheetWithData extends AppCompatActivity {
    private BottomSheetBehavior mBottomSheetBehaviour;
    Button openBottomSheetButton,closeBottomSheetButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_with_data);
        View nestedScrollView = (View) findViewById(R.id.nestedScrollView);
        openBottomSheetButton=(Button)findViewById(R.id.openBottomSheetButton);
        closeBottomSheetButton=(Button)findViewById(R.id.closeBottomSheetButton);

        mBottomSheetBehaviour = BottomSheetBehavior.from(nestedScrollView);

   //     mBottomSheetBehaviour.setPeekHeight(100);    //Set the peek height



        openBottomSheetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Collapse
                mBottomSheetBehaviour.setPeekHeight(0);
                mBottomSheetBehaviour.setState(BottomSheetBehavior.STATE_COLLAPSED);

            }
        });
        closeBottomSheetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBottomSheetBehaviour.setPeekHeight(0);
            //    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        //       mBottomSheetBehaviour.set
                //
                //       PeekHeight(100);    //Set the peek height

                mBottomSheetBehaviour.setState(BottomSheetBehavior.STATE_EXPANDED);    // Will show the bottom sheet
        //     mBottomSheetBehaviour.setState(BottomSheetBehavior.STATE_COLLAPSED);

            }
        });

       /* mBottomSheetBehaviour.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                String state = "";

                switch (newState) {
                    case BottomSheetBehavior.STATE_DRAGGING: {
                        state = "DRAGGING";
                        break;
                    }
                    case BottomSheetBehavior.STATE_SETTLING: {
                        state = "SETTLING";
                        break;
                    }
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        state = "EXPANDED";
                        break;
                    }
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        state = "COLLAPSED";
                        break;
                    }
                    case BottomSheetBehavior.STATE_HIDDEN: {
                        state = "HIDDEN";
                        break;
                    }
                }

                Toast.makeText(BottomSheetWithData.this, "Bottom Sheet State Changed to: " + state, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });*/
    }
}
