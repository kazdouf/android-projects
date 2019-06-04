package com.example.myappdblearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class AdminsActivity extends AppCompatActivity {

    private ListView listeA;
    private EditText id, name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admins);

        listeA = findViewById(R.id.lstAdmins);
        id = findViewById(R.id.txtID);
        name = findViewById(R.id.txtNom);
        email = findViewById(R.id.txtEmail);

        AfficherLaListe();
    }

    public void AfficherLaListe(){
        DBConnection db = new DBConnection(this);
        ArrayList lstAdms = db.getAllRecords();
        listeA.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lstAdms));
    }

    public void SaveData(View view) {
        DBConnection db = new DBConnection(this);
        db.insertAdmin(name.getText().toString(),email.getText().toString());
        AfficherLaListe();
    }

    public void updateData(View view) {
        DBConnection db = new DBConnection(this);
        db.updateAdmin(Integer.parseInt(id.getText().toString()),
                name.getText().toString(),email.getText().toString()
        );
        AfficherLaListe();
    }

    public void deleteData(View view) {
        DBConnection db = new DBConnection(this);
        //Toast.makeText(this,id.getText().toString(),Toast.LENGTH_LONG).show();
        db.deleteAdmin(Integer.parseInt(id.getText().toString()));
        AfficherLaListe();
    }
}
