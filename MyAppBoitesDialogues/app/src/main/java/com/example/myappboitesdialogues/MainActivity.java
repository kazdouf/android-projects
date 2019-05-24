package com.example.myappboitesdialogues;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder unBuild;
    private Button btnListe;
    private String[] Filere;
    private boolean[] checked;
    private ArrayList<String> eltSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Filere = new String[]{"TDI","TRI","TSGE","TSC","TCE"};
        checked = new boolean[]{false,false,false,false,false};
        eltSelect = new ArrayList<String>();

        btnListe = findViewById(R.id.btBoiteL);
        btnListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unBuild = new AlertDialog.Builder(MainActivity.this);

                unBuild.setTitle("Boite Dialogue Liste");
                unBuild.setItems(Filere, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, Filere[which],Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog BoiteListe = unBuild.create();
                BoiteListe.show();
            }
        });
    }

    public void BoiteSimple(View view) {
        unBuild =new AlertDialog.Builder(MainActivity.this);

        unBuild.setTitle("Boite Dialogue simple");
        unBuild.setMessage("choisisez ok ou no!");

        unBuild.setPositiveButton("ok",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Hello From ok",Toast.LENGTH_SHORT).show();
            }
        });

        unBuild.setNegativeButton("no",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Hello From no",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog uneBoite = unBuild.create();
        uneBoite.show();
    }

    public void BoiteMultiplChoix(View view) {
        unBuild =new AlertDialog.Builder(MainActivity.this);

        unBuild.setTitle("Boite Dialogue Multiple choix");
        unBuild.setMultiChoiceItems(Filere, checked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked)
                    eltSelect.add(Filere[which]);
                else eltSelect.remove(Filere[which]);
            }
        });
        unBuild.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for(int i = 0; i < )
            }
        });

        AlertDialog uneBoite = unBuild.create();
        uneBoite.show();
    }
}
