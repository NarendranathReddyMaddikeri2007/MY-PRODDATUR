package com.example.project2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_UserInfo extends AppCompatActivity {
    TextView user_name, user_email, note;
    String username, useremail;
    String user_info_note="Note:\n-Connect internet to get fast loading\n-Please give suggestions " +
            "and advices for addings and improvements using my mail";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        //------------------------------------------
        user_name = findViewById(R.id.tv_user_name);
        user_email = findViewById(R.id.tv_user_email);
        //------------------------------------------
        Intent intent = getIntent();
        username = String.valueOf(intent.getStringExtra("user_name"));
        useremail=String.valueOf(intent.getStringExtra("user_email"));
        user_name.setText(username);
        user_email.setText(useremail);
        //------------------------------------------
        note = findViewById(R.id.tv_user_info_note);
        note.setText(user_info_note);
        //------------------------------------------
//        firebaseAuth=FirebaseAuth.getInstance();
//        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
//        if(firebaseUser!=null){
//            user_name.setText(firebaseUser.getDisplayName());
//            user_email.setText(firebaseUser.getEmail());
//        }
//        googleSignInClient= GoogleSignIn.getClient(Activity_UserInfo.this, GoogleSignInOptions.DEFAULT_SIGN_IN);
    }
}