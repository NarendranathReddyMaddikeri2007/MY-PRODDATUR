package com.example.project2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdView;

public class Activity_Feedback extends AppCompatActivity {
    private EditText exit_text;
    private TextView button;
    String user_feedback="", subject = "App User Feedback";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        //-----------------------------------------
        //Receive user email and admin email from homepage through intents
        Intent intent = getIntent();
        String user_email= intent.getStringExtra("user_email");
        String admin_email=intent.getStringExtra("admin_email");
        //-----------------------------------------
        exit_text = findViewById(R.id.edit_text_feedback);
        button = findViewById(R.id.textView5);
        user_feedback=exit_text.getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open mail apps using intents
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ admin_email});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, user_feedback);
                intent.setData(Uri.parse("mailto:"));
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });
    }
}