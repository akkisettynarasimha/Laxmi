package com.strsar.laxmi.recyclerviewexample;

import java.util.Comparator;

public class Sortbyroll implements Comparator<Model>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Model a, Model b)

    {
       /* if(a.isData()){
            return 1;
        }else {
            return 0;
        }*/
       // return a.getCount()-b.getCount();
        return -(a.getCount()-b.getCount());
    }
}
