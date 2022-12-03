package com.example.project2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Activity_Transport extends AppCompatActivity {

    String[] bus_companies ={"APSRTC","INDU TRAVELS","PRL TRAVELS","AR BCVR TRAVELS","VASAVI TRAVELS","VEERA TRAVELS",
    "MAHESWARI TRAVELS"};

    int[] bus_images ={R.drawable.apsrtc_transport, R.drawable.indu_travels_transport,
    R.drawable.prl_travels_transport, R.drawable.arbcvr_travels_transport, R.drawable.vasavi_travels_transport,
    R.drawable.veera_travels_transport,R.drawable.maheswari_travels_transport};

    String[] railway_stations={"Yerraguntla", "Proddatur", "Kadapa", "Nandhyal"};

    String[] railway_stations_distance={"13Kms", "4.1Kms", "56Kms", "94Kms"};

    RecyclerView buses, railways;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);
        //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //------------------------------------------
        buses = findViewById(R.id.rv_buses_transport);
        railways = findViewById(R.id.rv_trains_transport);
        //------------------------------------------
        buses.setAdapter(new MyAdapter1(this));
        buses.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        //------------------------------------------
        railways.setAdapter(new MyAdapter2(this));
        railways.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        //------------------------------------------
    }
    //------------------------------------------
    private class MyAdapter1 extends RecyclerView.Adapter<MyHolder1> {
        Context context; View view;
        public MyAdapter1(Activity_Transport activity_transport) {
            context = activity_transport;
        }

        @NonNull
        @Override
        public MyHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            view = LayoutInflater.from(context).inflate(R.layout.item_transport_buses,parent,false);
            MyHolder1 h1 = new MyHolder1(view);
            return h1;
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder1 holder, int position) {
           holder.img.setImageResource(bus_images[position]);
           holder.tv.setText(bus_companies[position]);
        }

        @Override
        public int getItemCount() {
            return bus_companies.length;
        }
    }

    private class MyHolder1 extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tv;
        public MyHolder1(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_cv_buses_transport);
            tv = itemView.findViewById(R.id.tv_cv_bus_title_transport);
        }
    }
    //------------------------------------------
    private class MyAdapter2 extends RecyclerView.Adapter<MyHolder2> {
        Context context; View view;
        public MyAdapter2(Activity_Transport activity_transport) {
            context = activity_transport;
        }

        @NonNull
        @Override
        public MyHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            view = LayoutInflater.from(context).inflate(R.layout.item_transport_railways, parent, false);
            MyHolder2 h2 = new MyHolder2(view);
            return h2;
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder2 holder, int position) {
            holder.title.setText(railway_stations[position]);
            holder.distance.setText(railway_stations_distance[position]);
        }

        @Override
        public int getItemCount() {
            return railway_stations.length;
        }
    }

    private class MyHolder2 extends RecyclerView.ViewHolder {
        TextView title, distance;
        public MyHolder2(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_cv_train_transport);
            distance = itemView.findViewById(R.id.value_distance_tv_cv_transport);
        }
    }
}