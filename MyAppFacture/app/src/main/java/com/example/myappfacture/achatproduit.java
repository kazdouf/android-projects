package com.example.myappfacture;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class achatproduit extends AppCompatActivity{

    TextView id11; TextView nom; TextView priP;    ImageView photo;Spinner cat; Button Confirm;
    TextView Ttva;    TextView TVA; TextView lblPUTTC;
    double ttva=0.0;double tva1 = 0.00;double PrUTTC;

    Context ctx;

    Intent it1;
    String idP; String nomP; double pr=0.00;String NomPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achatproduit);
        ctx = getApplicationContext();
        it1=getIntent();
        id11= findViewById(R.id.lblidP);
        nom = findViewById(R.id.lblDesignation);
        priP = findViewById(R.id.lblPrHT);
        cat =findViewById(R.id.spnCat1);
        Ttva=findViewById(R.id.lblTtva);
        TVA=findViewById(R.id.lblTVA);
        lblPUTTC=findViewById(R.id.lblPrUTTC);
        Confirm=findViewById(R.id.btnConfirm);

        idP = it1.getStringExtra("id_P_ext");


        nomP = it1.getStringExtra("nom_P_ext");

       pr = it1.getDoubleExtra("prix_P_ext",0.0);

        NomPhoto = it1.getStringExtra("photo_P_ext");
        Toast.makeText(getApplicationContext(),NomPhoto,Toast.LENGTH_LONG).show();
        id11.setText(idP);
        nom.setText(nomP);
        priP.setText(String.valueOf(pr));

       ArrayAdapter adapterCat1 = ArrayAdapter.createFromResource(ctx,R.array.Categories,  android.R.layout.simple_spinner_item);
        adapterCat1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

      cat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String categsel=  parent.getItemAtPosition(position).toString();// cat.getSelectedItem().toString();

                Toast.makeText(getApplicationContext(),categsel,Toast.LENGTH_LONG).show();

                if(categsel.equals("Industriel"))
                    ttva = 0.20;
                if(categsel.equals("Informatique"))
                    ttva = 0.10;
                if(categsel.equals("Menager"))
                   ttva = 0.05;

                Ttva.setText(String.valueOf(ttva*100)+ " %");
                tva1 = ttva * Double.parseDouble(priP.getText().toString());
                TVA.setText(String.valueOf(tva1));

                double a = 1.856999;
                BigDecimal bd = new BigDecimal(PrUTTC);
                bd= bd.setScale(2,BigDecimal.ROUND_DOWN);
                PrUTTC = bd.doubleValue();
              PrUTTC = Double.parseDouble(priP.getText().toString()) + tva1;
              lblPUTTC.setText(String.valueOf(PrUTTC));
              lblPUTTC.setBackgroundColor(getColor(R.color.colorAccent));
 /* */
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
      Confirm.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Produit prod;
              prod = new Produit(idP,nomP,NomPhoto,pr);
              Panier.ajouterProdPan(prod);
              Intent itpan=new Intent(getApplicationContext(),activity_Panier.class);
              startActivity(itpan);

          }
      });
        //photo = findViewById(R.id.photoProd);


        /*int idph = ctx.getResources().getIdentifier(photoP,"drawable",ctx.getPackageName());
        photo.setImageResource(idph);*/


    }

}
