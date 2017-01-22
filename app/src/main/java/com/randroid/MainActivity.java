package com.randroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_retrofit(View view) {
        Intent intent = new Intent(MainActivity.this, Retrofit2.class);
        startActivity(intent);
    }

    public void button_insert(View view) {
        Intent intent = new Intent(MainActivity.this, Insert.class);
        startActivity(intent);
    }
}
