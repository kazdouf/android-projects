package com.example.myappgallery;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AppelActivity extends AppCompatActivity {

    EditText numero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appel);

        numero = findViewById(R.id.txtNumAppel);
    }

    public void PassAppel(View view) {
        try {
            Intent appel = new Intent(Intent.ACTION_CALL);
            String number = numero.getText().toString();
            //Toast.makeText(this,number,Toast.LENGTH_LONG).show();
            appel.setData(Uri.parse("tel: "+number));
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},0);
                startActivity(appel);
            }else{
                startActivity(appel);
            }
        }catch (Exception ex){
            TextView error = findViewById(R.id.lblerror);
            error.setText(ex.getMessage());
        }
    }
}
