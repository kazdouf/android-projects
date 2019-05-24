package com.example.myappstagiaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class ListeStagiairesTDIActivity extends AppCompatActivity {

    GridView GvLstStg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_stagiaires_tdi);

        Intent it = getIntent();
        GvLstStg = findViewById(R.id.grdLstStg);
        AdapterStagiaire adrStg = new AdapterStagiaire(getApplicationContext(), ClasseTDI.getLstStg());
        GvLstStg.setAdapter(adrStg);
    }
}
