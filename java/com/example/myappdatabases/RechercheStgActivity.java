package com.example.myappdatabases;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class RechercheStgActivity extends AppCompatActivity {

    EditText idStg,nomStg,filiereStg;
    GridView GrdAffichage;
    CheckBox chId,chNom,chFil;
    String criter;
    //String[] vals = new String[]{};
    ArrayList<String> vals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_stg);

        idStg = findViewById(R.id.txtRNumStg);
        nomStg = findViewById(R.id.txtRNomStg);
        filiereStg = findViewById(R.id.txtRFiliereStg);
        chId = findViewById(R.id.chkId);
        chNom = findViewById(R.id.chkNom);
        chFil = findViewById(R.id.chkFiliere);

        GrdAffichage = findViewById(R.id.grdStagiaire);

    }

    public void RechercheStg(View view) {
        criter = "1 = 1   ";
        vals = new ArrayList<String>();
        if(chId.isChecked()){
            criter += " and "+ DBConnection.ChampId+"=? ";
            vals.add(idStg.getText().toString());
        }
        if(chNom.isChecked()){
            criter += " and "+ DBConnection.ChampNom+"=? ";
            vals.add(nomStg.getText().toString());
        }
        if(chFil.isChecked()){
            criter += " and "+ DBConnection.ChampFiliere+"=? ";
            vals.add(filiereStg.getText().toString());
        }
        //Toast.makeText(getApplicationContext(),criter,Toast.LENGTH_LONG).show();
        if(chId.isChecked() || chNom.isChecked() || chFil.isChecked()) {
            DBConnection db = new DBConnection(this);
            Cursor crRes = db.RechercheStagiaire(vals, criter);
            ListAdapter lstStgAdr = new SimpleCursorAdapter(this, R.layout.modevuestg, crRes,
                    new String[]{db.ChampId, db.ChampNom, db.ChampFiliere},
                    new int[]{R.id.lblId, R.id.lblNom, R.id.lblFiliere}, 0);
            GrdAffichage.setAdapter(lstStgAdr);
        }
    }
}
