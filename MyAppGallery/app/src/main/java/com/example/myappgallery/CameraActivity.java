package com.example.myappgallery;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);


    }

    public void captVideo(View view) {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},0);
            Intent video = new Intent("android.media.action.VIDEO_CAPTURE");
            startActivity(video);
        }else{
            Intent video = new Intent("android.media.action.VIDEO_CAPTURE");
            startActivity(video);
        }

    }

    public void photo(View view) {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},0);
            Intent photo = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivity(photo);
        }else{
            Intent photo = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivity(photo);
        }
    }
    /*storage environment class / file class */
}
