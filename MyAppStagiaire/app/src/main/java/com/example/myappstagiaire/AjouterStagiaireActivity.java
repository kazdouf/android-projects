package com.example.myappstagiaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AjouterStagiaireActivity extends AppCompatActivity {

    Button AddStg;

    EditText NumStg;
    EditText NomStg;
    EditText PhotoStg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_stagiaire);


        NumStg = findViewById(R.id.txtNumStg);
        NomStg = findViewById(R.id.txtNomStg);
        PhotoStg = findViewById(R.id.imgStg);

        AddStg = findViewById(R.id.btnAjoutStg);
        AddStg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stagiaire stg = new Stagiaire (Integer.valueOf(NumStg.getText().toString())
                        ,NomStg.getText().toString(),PhotoStg.getText().toString());
                ClasseTDI.AjouterStg(stg);
                Toast.makeText(getApplicationContext(),"Stagiaire ajoutee avec succes",Toast.LENGTH_LONG).show();
            }
        });
    }
}
