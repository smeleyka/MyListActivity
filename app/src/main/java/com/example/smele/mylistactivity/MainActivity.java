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

    public class MyArrayAdapter<T> extends ArrayAdapter<T> {

        MyArrayAdapter(Context context, int resource, int textViewResourceId, List<T> objects) {
            super(context, resource, textViewResourceId, objects);
        }

        @NonNull
        @Override
        private  View createViewFromResource() {
            return createViewFromResource(,,,,);
        }

        @NonNull
        @Override
        private  View createViewFromResource(@NonNull LayoutInflater inflater, int position,
                                             @Nullable View convertView, @NonNull ViewGroup parent, int resource) {
            final View view;
            final TextView text;

            if (convertView == null) {
                view = inflater.inflate(resource, parent, false);
            } else {
                view = convertView;
            }

            try {
                if (mFieldId == 0) {
                    //  If no custom field is assigned, assume the whole resource is a TextView
                    text = (TextView) view;
                } else {
                    //  Otherwise, find the TextView field within the layout
                    text = (TextView) view.findViewById(mFieldId);

                    if (text == null) {
                        throw new RuntimeException("Failed to find view with ID "
                                + mContext.getResources().getResourceName(mFieldId)
                                + " in item layout");
                    }
                }
            } catch (ClassCastException e) {
                Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
                throw new IllegalStateException(
                        "ArrayAdapter requires the resource ID to be a TextView", e);
            }

            final T item = getItem(position);
            if (item instanceof CharSequence) {
                text.setText((CharSequence) item);
            } else {
                text.setText(item.toString());
            }

            return view;
        }



    }
}


