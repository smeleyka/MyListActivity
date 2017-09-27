package com.example.smele.mylistactivity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;


public class MainActivity extends ListActivity {

    static final String TAG = R.class.getSimpleName();

    String[] catNamesArray;
    Cat[] cats;

//           new String[] { "Рыжик", "Барсик", "Мурзик",
//           "Мурка", "Васька", "Томасина", "Бобик", "Кристина", "Пушок",
//           "Дымка", "Кузя", "Китти", "Барбос", "Масяня", "Симба" };
//           getResources().getStringArray(R.array.cat_arr);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        catNamesArray = getResources().getStringArray(R.array.cat_arr);
        cats = Cat.getCats(this);
        ArrayAdapter<Cat> adapter = new ArrayAdapter(this, R.layout.list_layout, R.id.list_textV, cats);
        setListAdapter(adapter);
        Log.d(TAG, "END");


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);


        Toast.makeText(getApplicationContext(),
                "Вы выбрали " + (position + 1) + " элемент", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, CatDescription.class);
        intent.putExtra(CatDescription.EXTRA_NAME, cats[position].getName());
        intent.putExtra(CatDescription.EXTRA_DESCR, cats[position].getDescription());
        startActivity(intent);

    }

}


