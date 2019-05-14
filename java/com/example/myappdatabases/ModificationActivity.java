package com.example.myappdatabases;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ModificationActivity extends AppCompatActivity {

    EditText nomStg, filStg;
    TextView idStg,lbmsg;
    ListView lstStg;
    ListAdapter lstStgAdr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification);

        idStg = findViewById(R.id.lblMAJIdStg);
        nomStg = findViewById(R.id.txtMAJNomStg);
        filStg = findViewById(R.id.txtMAJFilStg);
        lbmsg = findViewById(R.id.lblMAJMsg);

        lstStg = findViewById(R.id.lstvMAJStg);

        AfficherStagiaires();
        //Toast.makeText(getApplicationContext(),String.valueOf(lstCursor.getCount()),Toast.LENGTH_LONG).show();

        lstStg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                idStg.setText(((TextView)view.findViewById(R.id.lblId)).getText());
                nomStg.setText(((TextView)view.findViewById(R.id.lblNom)).getText());
                filStg.setText(((TextView)view.findViewById(R.id.lblFiliere)).getText());
            }
        });
    }

    public void AfficherStagiaires(){
        DBConnection db = new DBConnection(this);
        Cursor lstCursor = db.ListeStagiairesCursor();
        lstStgAdr = new SimpleCursorAdapter(this,R.layout.modevuestg,lstCursor,
                new String[]{db.ChampId,db.ChampNom,db.ChampFiliere},new int[]{R.id.lblId,R.id.lblNom,R.id.lblFiliere},0);
        lstStg.setAdapter(lstStgAdr);
    }

    public void ModifierStg(View view) {
        DBConnection db = new DBConnection(this);
        db.modifierStagiaire(idStg.getText().toString(),nomStg.getText().toString(),filStg.getText().toString());
        AfficherStagiaires();
    }

    public void SupprimerStg(View view) {
        DBConnection db = new DBConnection(this);
        db.supprimerStagiaire(idStg.getText().toString());
        AfficherStagiaires();
    }
}
