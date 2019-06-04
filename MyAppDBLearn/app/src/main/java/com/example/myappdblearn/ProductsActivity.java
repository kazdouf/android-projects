package com.example.myappdblearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.myapplication.R;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {

    Spinner admins;
    EditText PrdName;
    DBConnection db;
    ArrayAdapter adr;
    ListView lstAdmPrds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        admins = findViewById(R.id.spnAdmins);
        PrdName = findViewById(R.id.txtProduct);
        lstAdmPrds = findViewById(R.id.lstAdminsPrds);

        db = new DBConnection(this);
        ArrayList lstAdmins = db.getAdminsSpin();
        adr = new ArrayAdapter(this,android.R.layout.simple_spinner_item,lstAdmins);
        admins.setAdapter(adr);

        AfficherLaListe();
    }

    public void AddProduct(View view) {
        db.insertProduct(PrdName.getText().toString(),Integer.parseInt(adr.getItem(admins.getSelectedItemPosition()).toString().substring(0,1)));
        AfficherLaListe();
    }

    public void AfficherLaListe(){
        db = new DBConnection(this);
        ArrayList lstAdms = db.getAllRecordsPrds();
        lstAdmPrds.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lstAdms));
    }
}
