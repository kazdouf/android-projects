package com.example.myappfacture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class CatalogProduitActivity extends AppCompatActivity implements Serializable {

    ListView lstV;
    Button btP;
    Button btAff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_facture);

        btP=findViewById(R.id.btnAddPanier);
        //Toast.makeText(getApplicationContext(),"se Produit deja exist",Toast.LENGTH_LONG).show();

        CatalogProduit ctgP = new CatalogProduit();
        Produit p1 = new Produit("p1","Produit1","photo1",100);
        Produit p2 = new Produit("p2","Produit2","photo2",150.2);
        Produit p3 = new Produit("p3","Produit3","photo3",4011);

        ctgP.ajouterProd(p1);
        ctgP.ajouterProd(p2);
        ctgP.ajouterProd(p3);

        final AdapterProduit adp = new AdapterProduit(getApplicationContext(),ctgP.getLstProd());

        lstV = findViewById(R.id.lstvCatalog);
        lstV.setAdapter(adp);

        lstV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Intent itaddP = new Intent(getApplicationContext(),achatproduit.class);
                //Passer des valeurs simples
                itaddP.putExtra("id_P_ext",adp.getItem(position).getIdProd());
                itaddP.putExtra("nom_P_ext",adp.getItem(position).getNomProd());
                itaddP.putExtra("photo_P_ext",adp.getItem(position).getPhotoProd());
                itaddP.putExtra("prix_P_ext",adp.getItem(position).getPrix());
               startActivity(itaddP);*/
                //Passer un objet serialisable
                Produit Padd = adp.getItem(position);
                //Intent itaddP = new Intent(getApplicationContext(),activity_Panier.class);
                //itaddP.putExtra("p",Padd);
                //startActivity(itaddP);
                Panier.ajouterProdPan(Padd);
                Toast.makeText(getApplicationContext(),adp.getItem(position).getNomProd()
                                +" ajoutee au panier",Toast.LENGTH_LONG).show();

            }
        });
        btP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btAff = findViewById(R.id.btnAffPanier);
        btAff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itaddP = new Intent(getApplicationContext(),activity_Panier.class);
                //Bundle bdl = new Bundle();
                itaddP.putExtra("lstP",(ArrayList<Produit>)Panier.getPan());
                startActivity(itaddP);
            }
        });
    }
}
