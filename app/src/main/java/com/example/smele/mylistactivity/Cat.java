package com.example.smele.mylistactivity;

import android.content.Context;

/**
 * Created by smele on 16.09.2017.
 */

public class Cat {
    private String name;
    private String img;
    private String description;

    public Cat(String name,String img, String description) {
        this.name = name;
        this.img = img;
        this.description = description;
    }

    static Cat[] getCats(Context c){
        String[] catName;
        String[] catImg;
        String[] catDescr;

        catName=c.getResources().getStringArray(R.array.cat_arr);
        catImg=c.getResources().getStringArray(R.array.cat_img);
        catDescr=c.getResources().getStringArray(R.array.cat_arr_descr);
        Cat[] catArr = new Cat[catName.length];
        for (int i = 0; i < catName.length; i++) {
            catArr[i]=new Cat(catName[i],catImg[i],catDescr[i]);
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
