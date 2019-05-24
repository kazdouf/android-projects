package com.example.myappmoyenne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText n1,n2,n3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.txtNote);
        n2 = findViewById(R.id.txtNote1);
        n3 = findViewById(R.id.txtNote2);
    }

    public void calc(View view) {
        if(n1.getText().toString().equals("")||n2.getText().toString().equals("")||n3.getText().toString().equals("")){
            Toast.makeText(this,"veuillez remplire les champs!",Toast.LENGTH_LONG).show();
        }else{
            double moy = (Double.parseDouble(n1.getText().toString())+
                    Double.parseDouble(n2.getText().toString())+
                    Double.parseDouble(n3.getText().toString()))/3;
            if(moy > 10){
                Intent itReussite = new Intent(this,ReussiteActivity.class);
                itReussite.putExtra("moy",moy);
                startActivity(itReussite);
            }else{
                Intent itRecale = new Intent(this,RecaleActivity.class);
                itRecale.putExtra("moy",moy);
                startActivity(itRecale);
            }
        }
    }
}
