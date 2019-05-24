package com.example.myappmoyenne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RecaleActivity extends AppCompatActivity {
    TextView moyRec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recale);

        moyRec = findViewById(R.id.lblmoyRec);

        Intent itMoy = getIntent();
        double moy = itMoy.getDoubleExtra("moy",0.0);
        moyRec.setText(String.valueOf(moy));
    }
}
