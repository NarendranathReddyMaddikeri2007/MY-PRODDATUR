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

public class Activity_Institutions extends AppCompatActivity {
    RecyclerView recyclerview;
    String[] titles ={"Gautam High School",
            "Aditya High School",
            "St Joseph High School",
            "SCHOLARS' HIGH SCHOOL",
            "Sarada High School",
            "Sri Chaitanya School",
            "Sri Chaitanya school",
            "Sri Chaitanya School",
            "Gopi Krishna Central School",
            "Ushodaya High School",
            "Jeevan Jyothi High School",
            "Narayana Olympiad School",
            "Keshava Reddy School",
            "Gouthami Institute of Technology for Women",
            "Vaagdevi Institute Of Technology & Science",
            "Chaitanya Bharathi Institute of Technology",
            "Sai Rajeswari Institute Of Technology And Sciences"};
    String[] address ={"Sai Kuteer Road, Bollavaram, Y.M.R. Colony, Proddatur, Andhra Pradesh 516360",
            "Nehru Rd, Venkateswara Pet, Proddatur, Andhra Pradesh 516360",
            "Bollavaram, Proddatur, Andhra Pradesh 516360",
            "Cooperative Colony Main Rd, YMR Colony, Proddatur, Andhra Pradesh 516360",
            "Venkateswara Pet, Proddatur, Andhra Pradesh 516360",
            "near Aravinda Ashram, Sai Nagar, YMR Colony, Proddatur, Andhra Pradesh 516360",
            "Sri Sai Rajeswary Colony, Proddatur, Andhra Pradesh 516360",
            "Beside Golden Park,Bollavaram, Proddatur, Andhra Pradesh 516360",
            "Dorasanipalli, Proddatur, Andhra Pradesh 516360",
            "YMR Colony, Proddatur, Andhra Pradesh 516360",
            "Cooperative Colony Main Rd, Sai Nagar, YMR Colony, Proddatur, Andhra Pradesh 516360",
            "Narayana olympiad School, Sastry Nagar, YMR Colony, Proddatur, Andhra Pradesh 516360",
            "Pottipadu Rd, Bollavaram, Proddatur, Andhra Pradesh 516360",
            "Jammalamadug - Proddatur Road Sai Nagar, Peddasettypalle(V), Proddatur 516360",
            "Peddasettipalli, Proddatur, Andhra Pradesh 516360",
            "Vidya Nagar, Pallvolu, Proddatur, Andhra Pradesh 516360",
            "Mydukur Road Lingapuram, Balaji Nagar, Proddatur, Andhra Pradesh 516362",
    };

    int images[]={R.drawable.gautam_high_school,
    R.drawable.aditya_high_school,
    R.drawable.st_joseph_high_school,
    R.drawable.scholers_high_school,
    R.drawable.sarada_high_school,
    R.drawable.sri_chaitanya_school_ymr_colony,
    R.drawable.sri_chaitanya_school_cinehub,
    R.drawable.sri_chaitanya_school_bollaram,
    R.drawable.gopi_krishna_school,
    R.drawable.ushodaya_high_school,
    R.drawable.jeevan_jyothi_high_school,
    R.drawable.narayana_school,
    R.drawable.keshava_reddy_school,
    R.drawable.gautami_collage,
    R.drawable.vagdevi_collage,
    R.drawable.cbit_collage,
    R.drawable.srit_collage
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institutions);
        recyclerview = findViewById(R.id.institutions_recyclerview);
        //---------------------------------
        recyclerview.setAdapter(new MyAdapter(this));
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    private class MyAdapter extends RecyclerView.Adapter<MyHolder> {
        Context context;
        View view;
        public MyAdapter(Activity_Institutions activity_institutions) {
            context = activity_institutions;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            view = LayoutInflater.from(context).inflate(R.layout.item_institutions, parent, false);
            MyHolder h = new MyHolder(view);
            return h;
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
          holder.title.setText(titles[position]);
          holder.address.setText(address[position]);
          holder.image.setImageResource(images[position]);
        }

        @Override
        public int getItemCount() {
            return titles.length;
        }
    }

    private class MyHolder extends RecyclerView.ViewHolder{
        TextView title, address;
        ImageView image;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_institutions_tv_title);
            address = itemView.findViewById(R.id.item_institutions_tv_address);
            image = itemView.findViewById(R.id.item_institutions_imageview);
        }
    }
}