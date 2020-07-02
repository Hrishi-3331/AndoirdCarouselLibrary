package com.hrishistudio.devstudio3331.carouselexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDemo(View view){
        Intent intent = new Intent(MainActivity.this, DemoActivity.class);
        intent.putExtra("key", Integer.valueOf(view.getContentDescription().toString()));
        startActivity(intent);
    }
}
