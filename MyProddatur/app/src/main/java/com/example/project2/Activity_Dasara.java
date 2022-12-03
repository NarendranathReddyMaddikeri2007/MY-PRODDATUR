package com.example.project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_Dasara extends AppCompatActivity {
    String explanation = "Dasara is celebrated on a very grand scale at Proddatur, " +
            "the center of the Visya community which has organised itself well.\n" +
            "It is known as the second Mysore for Dasara celebrations.\n" +
            "Over two lakhs of people are said to visit the place from far and near.\n" +
            "Vasanthosthavam during the day and Ammavari procession during the night are attractive, " +
            "with keelugurrams and dance parties.";
    RecyclerView recyclerview;
    int[] images ={R.drawable.dasara_image1, R.drawable.dasara_image2, R.drawable.dasara_image4,
    R.drawable.dasara_image5};
    TextView exp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasara);
        //---------------------------------------
       recyclerview = findViewById(R.id.recyclerview_dasara);
       exp = findViewById(R.id.tv_explanation_dasara);
        //---------------------------------------
        exp.setText(explanation);
        //---------------------------------------
        recyclerview.setAdapter(new MyAdapter(this));
        recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        //---------------------------------------
    }

    private class MyAdapter extends RecyclerView.Adapter<MyHolder> {
        Context context;
        View view;
        public MyAdapter(Activity_Dasara activity_dasara) {
            context = activity_dasara;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            view = LayoutInflater.from(context).inflate(R.layout.item_dasara, parent, false);
            MyHolder h = new MyHolder(view);
            return h;
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
               holder.iv.setImageResource(images[position]);
        }

        @Override
        public int getItemCount() {
            return images.length;
        }
    }

    private class MyHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_item_dasara);
        }
    }
}