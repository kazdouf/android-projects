package com.example.myappdatabases;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class ListeStagiairesActivity extends AppCompatActivity {

    ListView lstStg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_stagiaires);

        lstStg = findViewById(R.id.lstviewStagiaires);

        DBConnection db = new DBConnection(this);

        //ArrayList<Stagiaire> ListeStg = db.ListeStagiaire();

        Cursor lstCursor = db.ListeStagiairesCursor();

        //Toast.makeText(getApplicationContext(),String.valueOf(lstCursor.getCount()),Toast.LENGTH_LONG).show();
        ListAdapter lstStgAdr = new SimpleCursorAdapter(this,R.layout.modevuestg,lstCursor,
               new String[]{db.ChampId,db.ChampNom,db.ChampFiliere},new int[]{R.id.lblId,R.id.lblNom,R.id.lblFiliere},0);
        lstStg.setAdapter(lstStgAdr);
        //Toast.makeText(getApplicationContext(),String.valueOf(lstStgAdr.getItem(0)),Toast.LENGTH_LONG).show();
        /*Adapterstagiaire adr = new Adapterstagiaire(this,ListeStg);
        lstStg.setAdapter(adr);*/
    }
}
