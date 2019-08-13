package com.strsar.laxmi.secarchbar;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.strsar.laxmi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GenericListHeaderViewHolder extends RecyclerView.ViewHolder {
    final View view;
    private String labelText;

    @BindView(R.id.label)
    TextView labelView;

    String getLabelText() {
        return labelText;
    }

    void setLabelText(String labelText) {
        this.labelText = labelText;
        labelView.setText(labelText);
    }

    GenericListHeaderViewHolder(View view) {
        super(view);
        this.view = view;
        ButterKnife.bind(this, view);
    }

    @Override
    public String toString() {
        return super.toString() + " '" + labelView.getText() + "'";
    }
}
