package com.example.myappgallery;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class MessageActivity extends AppCompatActivity {

    EditText numero,MESSAGE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        numero = findViewById(R.id.txtNumMessage);
        MESSAGE = findViewById(R.id.txtMessage);
    }

    public void PassMsg(View view) {
        SmsManager sms = SmsManager.getDefault();
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},0);
            sms.sendTextMessage(numero.getText().toString(),null,MESSAGE.getText().toString(),null,null);
        }else {
            sms.sendTextMessage(numero.getText().toString(),null,
                    MESSAGE.getText().toString(),null,null);
        }

    }
}
