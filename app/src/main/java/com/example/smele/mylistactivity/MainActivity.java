package com.example.smele.mylistactivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ListActivity {


    String[] catNamesArray;
    Cat[] cats;

//           new String[] { "Рыжик", "Барсик", "Мурзик",
//           "Мурка", "Васька", "Томасина", "Бобик", "Кристина", "Пушок",
//           "Дымка", "Кузя", "Китти", "Барбос", "Масяня", "Симба" };
//           getResources().getStringArray(R.array.cat_arr);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        catNamesArray = getResources().getStringArray(R.array.cat_arr);
        cats = Cat.getCats(this);
        ArrayAdapter<Cat> adapter = new ArrayAdapter(this, R.layout.list_layout, cats);
        setListAdapter(adapter);
        super.onCreate(savedInstanceState);

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
