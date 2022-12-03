package com.example.project2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Activity_Tourism_Info extends AppCompatActivity {
    ImageButton moreinfo, route;
    TextView info, dist;
    ImageView picture;
    String location = "", web_info="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_info);
        //---------------------
        moreinfo = findViewById(R.id.ib_more_info);
        route = findViewById(R.id.ib_route_location);
        info = findViewById(R.id.tv_temples_description);
        dist = findViewById(R.id.tv_distance);
        picture = findViewById(R.id.iv_image);
        //---------------------
        Intent intent = getIntent();
        info.setText(intent.getStringExtra("description"));
        String distance= intent.getIntExtra("distance", 0) +" Kms";
        dist.setText(distance);
        picture.setImageResource(intent.getIntExtra("image",0));
        location = intent.getStringExtra("location");
        web_info=intent.getStringExtra("more_info");

        moreinfo.setOnClickListener(v -> {
            Uri uri;
            uri = Uri.parse(intent.getStringExtra("more_info"));
            Intent i1 =new  Intent(Intent.ACTION_VIEW, uri);
            startActivity(i1);
        });
        route.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:0,0?q="+intent.getStringExtra("location"));
                Intent i2;
                i2 = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i2);
            }
        });
    }

}