package com.example.myapplicationcalculatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button btp,btmi,btmu,btd,btqui;
EditText txt1,txt2;
TextView txtr;
double nb1,nb2,rus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btp=findViewById(R.id.btpluse);
        btmi=findViewById(R.id.btmoin);
        btmu=findViewById(R.id.btmulti);
        btd=findViewById(R.id.btdivi);
        txt1=findViewById(R.id.txtnb1);
        txt2=findViewById(R.id.txtnb2);
        txtr=findViewById(R.id.txtrus);
        btqui=findViewById(R.id.btqui);

        btp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nb1=Double.parseDouble(txt1.getText().toString());
                nb2=Double.parseDouble(txt2.getText().toString());
                rus=nb1+nb2;
                txtr.setText(String.valueOf(rus));
            }
        });
        btmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nb1=Double.parseDouble(txt1.getText().toString());
                nb2=Double.parseDouble(txt2.getText().toString());
                rus=nb1-nb2;
                txtr.setText(String.valueOf(rus));
            }
        });
        btmu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nb1=Double.parseDouble(txt1.getText().toString());
                nb2=Double.parseDouble(txt2.getText().toString());
                rus=nb1*nb2;
                txtr.setText(String.valueOf(rus));
            }
        });
        btd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nb1=Double.parseDouble(txt1.getText().toString());
                nb2=Double.parseDouble(txt2.getText().toString());
                if(nb2>0){
                    rus=nb1/nb2;
                    txtr.setText(String.valueOf(rus));
                }
                else {
                    txtr.setText("impossible de dévise par 0");
                }
            }
        });
        btqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
