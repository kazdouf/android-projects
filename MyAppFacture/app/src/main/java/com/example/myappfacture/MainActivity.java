package com.example.myappfacture;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Prod ;
    EditText Designation;
    EditText PrixHT;
    EditText PrixUTTC;
    EditText Remise;
    EditText Ttva;
    EditText tRemise;
    EditText TotalTTC;
    EditText TVA;

    TextView Result;

    Spinner Categorie;

    Button Calcul;
    Button ctg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Prod = findViewById(R.id.txtidProd);
        Designation = findViewById(R.id.txtDesignation);
        PrixHT = findViewById(R.id.txtPrixHT);
        PrixUTTC = findViewById(R.id.txtPrixUTTC);
        Remise = findViewById(R.id.txtRemise);
        Ttva = findViewById(R.id.txtTtva);
        TVA = findViewById(R.id.txtTVA);
        tRemise = findViewById(R.id.txttRemise);
        TotalTTC = findViewById(R.id.txtTotalTTC);
        Result = findViewById(R.id.lblNetApaye);
        Categorie = findViewById(R.id.spnCat);
        Calcul = findViewById(R.id.btnCalculer);
        ctg = findViewById(R.id.btnCatalog);

        /*String[] Categ = new String[]{"Industriel", "Informatique", "Menager"};
        ArrayAdapter adr = new ArrayAdapter(MainActivity.this,
                            R.layout.support_simple_spinner_dropdown_item, Categ);
        Categorie.setAdapter(adr);*/

        Calcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getApplicationContext(),Categorie.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
                String cat = Categorie.getSelectedItem().toString();
                double ttva = 0.00;
                double tva1 = 0.00;
                double TotalTC = 0.00;
                double TRemise = 0.00;
                double remise = 0.00;
                double netAp = 0.00;


                if(cat.equals("Industriel"))
                    ttva = 0.20;
                if(cat.equals("Informatique"))
                    ttva = 0.10;
                if(cat.equals("Menager"))
                    ttva = 0.05;

                tva1 = ttva * Double.parseDouble(PrixHT.getText().toString());
                Ttva.setText((ttva*100) + " %");
                TVA.setText(String.valueOf(tva1));

                TotalTC = Double.parseDouble(PrixHT.getText().toString()) + tva1;
                PrixUTTC.setText(String.valueOf(TotalTC));

                TotalTTC.setText(String.valueOf(TotalTC));

                if(TotalTC > 20000)
                    TRemise = 0.05;
                else {
                    if (TotalTC > 10000)
                        TRemise = 0.025;
                    else {
                        if (TotalTC > 5000)
                            TRemise = 0.01;
                    }
                }

                remise = TotalTC * TRemise;

                netAp = TotalTC - remise;

                tRemise.setText((TRemise*100)+" %");
                Remise.setText(String.valueOf(remise));
                Result.setText(String.valueOf(netAp));

            }
        });
        ctg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),CatalogProduitActivity.class);
                startActivity(it);
            }
        });
    }
}
