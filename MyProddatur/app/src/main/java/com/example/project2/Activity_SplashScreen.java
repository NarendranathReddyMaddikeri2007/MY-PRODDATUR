package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class Activity_SplashScreen extends AppCompatActivity {
    ProgressBar progressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progressbar = findViewById(R.id.progressBar);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(Activity_SplashScreen.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        },5000);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}