package com.example.myappdblearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AdminsAct(View view) {
        Intent itAdminsAct = new Intent(MainActivity.this,AdminsActivity.class);
        startActivity(itAdminsAct);
    }

    public void ProdsAct(View view) {
        Intent itProdsAct = new Intent(MainActivity.this,ProductsActivity.class);
        startActivity(itProdsAct);
    }
}
