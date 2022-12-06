package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity_User_Settings extends AppCompatActivity {
    String about_admin="I'm student at VITAP University and done this application project for my home town.";
    String about_app="This app mainly built to facilitate people to know about proddatur " +
            "and get info about it's tourist places, shopping areas, hotels, gold shops and textile shops.\n\n" +
            "Logics used: Recyclerviews and stylesheets";
    TextView abt_admin, abt_app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);
        abt_admin = findViewById(R.id.about_admin_description);
        abt_app = findViewById(R.id.about_app_description);
        abt_app.setText(String.valueOf(about_app));
        abt_admin.setText(String.valueOf(about_admin));
    }
}