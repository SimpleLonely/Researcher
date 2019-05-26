package com.alljedi.bottomnavigationapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle bundle=getIntent().getExtras();
        int id=bundle.getInt("photo");
        String message=bundle.getString("message");
        //ImageView Iv=(ImageView) findViewById(R.id.Iv);
        //Iv.setImageResource(id);
        //TextView tv=(TextView) findViewById(R.id.tv_message);
        //tv.setText(message);

    }
}
