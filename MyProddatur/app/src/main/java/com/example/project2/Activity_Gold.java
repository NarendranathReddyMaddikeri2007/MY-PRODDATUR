package com.example.project2;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Activity_Gold extends AppCompatActivity {
    String[] gold_shops ={"Busetty Jewellers","Sri Guru Raghavendra Jewellers","Thallam Jewellers","S.D.S Jewellers",
    "Nagendra Jewellers","D Abdul Hussain & Sons","Nandam Jewellers & Sons","Satyam Jewellers","Gupta Jewellers",
    "Sri Krishna Jewellers","Settipally Jewellers","Sri Chinmaya Jewellery","SR Jewellers","Sri Shiva Kameshwari Jewellers",
    "Sri Alavala Jewellers","Praveen Jewellers","Sri Lakshmi Vinayaka Jewellers","SSV Jewellers",
    "Bhumireddy Jewellers","Karnati Jewellers","AR Jewellers","Anand Jewellery & Works","Rajendra Jewellers",
    "Sri Vishnu Jewellers","Brahmendra Jewellers","Sri TVR Jewellers","D.A.H Jewellers","Donthu Jewellers",
    "Sri Vasavi Jewellers","H.J Jewellers","J.M Jewellers","Ibrahim Jewellers","N.M Jewellery & Works",
    "Sri Sri Lalith Jewellers","Sri Sri Kalyani Jewellers","Amrutha Jewellers","Zuber Jewellers","Azeez Jewellers",
    "Markendaya Jewellers","Sri Srinivasa Jewellers","SB Jewellers & Works","SS Jewellers","Ramamanohara Jewellers",
    "Sri New Panduranga Jewellers","Sri Lakshmi Venkateshwara Jewellers","RNT Jewellers & Works"};
    RecyclerView recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gold);
      //  this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //------------------------------------
        recyclerview = findViewById(R.id.recycler_view_gold);
        //------------------------------------
        recyclerview.setAdapter(new MyAdapter(this));
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }


    private class MyAdapter extends RecyclerView.Adapter<MyHolder> {
        Context context;
        View view;

        public MyAdapter(Activity_Gold activity_gold) {
            context = activity_gold;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            view = LayoutInflater.from(context).inflate(R.layout.item_gold, parent,false);
            MyHolder h=new MyHolder(view);
            return h;
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            holder.tv.setText(""+gold_shops[position]);
        }

        @Override
        public int getItemCount() {
            return gold_shops.length;
        }
    }

    private class MyHolder extends RecyclerView.ViewHolder {
        TextView tv;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.textview_gold);
        }
    }
}
