package com.example.myappdialogpers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myappdialogpers.R;

public class MainActivity extends AppCompatActivity {
    Button btAff,btn1,btn2;
    TextView txtv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtv = findViewById(R.id.txt1);
        btAff=findViewById(R.id.btAfficher);
        btAff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final boite_personnalisee boitetPer=new boite_personnalisee(MainActivity.this );
                boitetPer.setStrtitreBoite("Un titre personnalisé");
                boitetPer.setStrMessageBoite("un Message perso");

                boitetPer.getBtonOk().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"bout OK",Toast.LENGTH_LONG).show();
                        //txtv.setText("Bout Ok");
                        txtv.setText(boitetPer.getSaisieEditText().getText());
                        boitetPer.dismiss();
                    }
                });
                Button nonBt = boitetPer.getBtonNon();
                nonBt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"bout Non",Toast.LENGTH_LONG).show();
                        //txtv.setText(boitetPer.getSaisieEditText().getText());
                        boitetPer.dismiss();
                    }
                });
                boitetPer.getIcone().setImageResource(R.drawable.excel);

                boitetPer.AfficherBoite();
            }
        });
        /*btn1=findViewById(R.id.btnex1);
        btn2=findViewById(R.id.btnex2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1=new Intent(getApplicationContext(),Exercice1Activity.class);
                startActivity(it1);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it2=new Intent(getApplicationContext(),Exercice2Activity.class);
                startActivity(it2);
            }
        });*/

    }
    public void ShowMenu(View view) {
        Intent it = new Intent(getApplicationContext(),MenuActivity.class);
        startActivity(it);
    }
}
