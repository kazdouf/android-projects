package com.example.myappmoyenne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReussiteActivity extends AppCompatActivity {
    TextView moyRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reussite);

        moyRes = findViewById(R.id.lblmoyReus);

        Intent itMoy = getIntent();
        double moy = itMoy.getDoubleExtra("moy",10.0);
        moyRes.setText(String.valueOf(moy));
    }
}
