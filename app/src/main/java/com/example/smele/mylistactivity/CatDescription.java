package com.example.smele.mylistactivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by smele on 16.09.2017.
 */

public class CatDescription extends Activity {
    static final String EXTRA_NAME = "cat_name";
    static final String EXTRA_DESCR = "cat_descr";
    TextView textVName;
    TextView textVDescr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cat_description_layout);
        textVName = (TextView)findViewById(R.id.textV_name);
        textVDescr = (TextView)findViewById(R.id.textV_description);
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            textVName.setText(bundle.getString(EXTRA_NAME));
            textVDescr.setText(bundle.getString(EXTRA_DESCR));
        }



    }
}
