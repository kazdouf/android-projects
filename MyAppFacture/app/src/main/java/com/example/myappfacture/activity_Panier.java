package com.example.myappfacture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class activity_Panier extends AppCompatActivity {

    GridView GPan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__panier);

        GPan=findViewById(R.id.GrdVPan);
        /*Produit PR;
        Intent itpr=getIntent();
        PR=(Produit) itpr.getSerializableExtra("p");
        Toast.makeText(getApplicationContext(),PR.getIdProd(),Toast.LENGTH_LONG).show();*/
        /*
        AdapterProduit adpr=new AdapterProduit(getApplicationContext(),Panier.getPan());
        GPan.setAdapter(adpr);*/

        Intent itpr = getIntent();
        ArrayList<Produit> Panie = (ArrayList<Produit>) itpr.getSerializableExtra("lstP");
        AdapterProduit adpr = new AdapterProduit(this,Panie);
        GPan.setAdapter(adpr);
    }
}
