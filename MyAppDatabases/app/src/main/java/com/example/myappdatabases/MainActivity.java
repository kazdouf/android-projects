package com.example.myappdatabases;

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

    public void AjoutActivity(View view) {
        Intent itAddStg = new Intent(getApplicationContext(),AjoutStgActivity.class);
        startActivity(itAddStg);
    }

    public void AffichActivity(View view) {
        Intent itShowStg = new Intent(getApplicationContext(),ListeStagiairesActivity.class);
        startActivity(itShowStg);
    }

    public void RechercheActivity(View view) {
        Intent itFindStg = new Intent(getApplicationContext(),RechercheStgActivity.class);
        startActivity(itFindStg);
    }

    public void ModifierActivity(View view) {
        Intent itUpdateStg = new Intent(getApplicationContext(),ModificationActivity.class);
        startActivity(itUpdateStg);
    }
}
