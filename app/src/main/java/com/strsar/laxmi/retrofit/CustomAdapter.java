package com.strsar.laxmi.retrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.strsar.laxmi.R;

import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<RetroPhoto> dataList;
    private Context context;

    public CustomAdapter(Context context,List<RetroPhoto> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtTitle;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.title);

        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).getTitle());
       holder.txtTitle.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {



               LayoutInflater layout = (LayoutInflater)context
                       .getSystemService(LAYOUT_INFLATER_SERVICE);
               View popupView = layout.inflate(R.layout.dailog_box, null);
            /*   Display display = context.getWindowManager().getDefaultDisplay();
               int height = display.getHeight();
               int width = display.getWidth();*/
              /* final PopupWindow popupWindaow = new PopupWindow(popupView,
                       (int) (width / 1.4), (int) (height / 2.5));
               popupWindaow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

               TextView tv1 = (TextView) popupView
                       .findViewById(R.id.textView1);
*/
          //     tv1.setText("Really delete this entry?");


           }
       });


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
