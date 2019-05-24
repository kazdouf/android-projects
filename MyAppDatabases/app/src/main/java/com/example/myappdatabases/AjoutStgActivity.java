package com.example.myappdatabases;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AjoutStgActivity extends AppCompatActivity {

    EditText numero;
    EditText nom;
    EditText filiere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_stg);

        numero = findViewById(R.id.txtNumStg);
        nom = findViewById(R.id.txtNomStg);
        filiere = findViewById(R.id.txtFilStg);
    }

    public void AddStg(View view) {
        DBConnection db = new DBConnection(this);
        Stagiaire stg = new Stagiaire(Integer.parseInt(numero.getText().toString()),
                                        nom.getText().toString(),
                                        filiere.getText().toString()
        );
        db.AjouterStagiaire(stg);
        Toast.makeText(getApplicationContext(),"stagiaire ajoutee avec succes",Toast.LENGTH_LONG).show();
    }
}
