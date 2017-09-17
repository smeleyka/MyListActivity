package com.example.smele.mylistactivity;

import android.content.Context;

/**
 * Created by smele on 16.09.2017.
 */

public class Cat {
    private String name;
    private String description;

    public Cat(String name, String description) {
        this.name = name;
        this.description = description;
    }

    static Cat[] getCats(Context c){
        String[] catName;
        String[] catDescr;

        catName=c.getResources().getStringArray(R.array.cat_arr);
        catDescr=c.getResources().getStringArray(R.array.cat_arr_descr);
        Cat[] catArr = new Cat[catName.length];
        for (int i = 0; i < catName.length; i++) {
            catArr[i]=new Cat(catName[i],catDescr[i]);
        }
        return catArr;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name;
    }
}
