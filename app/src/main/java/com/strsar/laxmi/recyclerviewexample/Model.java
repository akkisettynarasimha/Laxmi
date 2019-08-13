package com.strsar.laxmi.recyclerviewexample;

public class Model {
    private String text;
    private int count;

    private boolean isSelected = false;

    public Model(String text, boolean data) {
        this.text = text;

    }

    public Model(String text,  int count) {
        this.text = text;

        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    // Used to print student details in main()

}
