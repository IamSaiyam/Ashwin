package com.sih.dorec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.VideoView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView logo = findViewById(R.id.ashwinLogo);
        VideoView video = findViewById(R.id.video);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.document_gif);
        video.setVideoURI(uri);
        video.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);
                Splash.this.finishActivity(0);
            }
        }, 2000);
    }
}