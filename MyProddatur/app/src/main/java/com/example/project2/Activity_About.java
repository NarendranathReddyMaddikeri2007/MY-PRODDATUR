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

public class Activity_About extends AppCompatActivity {
    RecyclerView recyclerview;
    // Get arrays and put them on  layout using recycler view.
    String[] about_title ={
                   "Proddatur-Introduction",
                   "History",
                   "Population",
                   "Economy",
                   "Famous Shopping Areas",
                   "Gold Business",
                   "Transportation",
    };
    String[] about_description ={
    "Proddatur is a city in the YSR Kadapa District of Andhra Pradesh.\n" +
            "It is based on the banks of the Penna River.\n\nThe city is a municipality, " +
            "and also the mandal headquarters of Proddatur mandal.\n\n"+
            "Proddatur is well known for its gold and cotton industries, " +
            "and hence is called the Second Bombay.\n\nVijaya Dashami or Dussehra is a festival " +
            "celebrated here with great pomp and enthusiasm due to the festival celebration " +
            "Proddatur is also called as a 2nd mysore.",
    "As per Hindu mythology, after Lord Ram killed Ravana and was returning with Sita, " +
            "he decided to rest in this city and stopped here along the banks of " +
            "Penna at sunset—which is how the city got its name. \n\nSunset in Telugu is Proddu.",
    "According to 2011 census, it has a population of more than 150,000 in the town and more than " +
            "200,000 in the metropolitan area. " +
            "\n\nIn order to improve the living conditions of the slum dwellers, " +
            "The municipality is providing infrastructure facilities like Roads, " +
            "Drains, Water Supply and Street Lighting.",
    "The livelihood of majority of the people is agriculture the cultivation is mostly rained is both kharif and rabi seasons. " +
            "\n\nThe main industries in the town cotton, oil and town is famous for gold, cloth and retail items business.",
    "> KK Street\n\n> Vedurla Bazar\n\n> Mydukur Road\n\n>Korrapadu Road\n\n> Rajabhata Street\n\n> Rajaji Road\n\n> Homespet\n\n> Gandhi Road\n\n" +
            "> S.S Mall\n\n> Vivekananda Cloth Market\n\n> Balaji Cloth Market\n\n> Nandini Wholesale Cloth Market\n\n> Vastrabharathi Cloth Market\n\n" +
            "> New Vastrabharathi cloth market",
    "Proddatur is very famous for gold business.\n\n" +
            "Proddatur got the name and fame as Second Bombay in respect of gold business.\n\n" +
            "In proddatur there are nearly 500 gold business shops are located in an area called Ammavarisala street.\n\n" +
            "Here we can find the different different designs and models of jewelry which even not available in Hyderabad, Bangalore & Chennai.\n\n" +
            "One more great news is that you can find the gold rates at proddatur on any news paper in their business papers.\n\n" +
            "Good thing is that the gold rates at proddatur are less by comparing with other cities like Hyderabad, Bangalore & Chennai.",
    "The town is well connected by road to surrounding towns.\n\n" +
            "The nearest railway station is Yerraguntla, " +
            "located 13 kilometres (8.1 mi) from the town and on the Mumbai–Chennai railway line.\n\n" +
            "A new railway station is constructed in Proddatur on the bypass road near " +
            "Jammalamadugu Road towards Rameshwaram from the town to Nandyal.\n\n" +
            "Furhter, Railways accepted for " +
            "Cumbum(Prakasam district) – Proddatur railway line in 2010 Railways " +
            "Budget and a survey was underway."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
      //  this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        recyclerview = findViewById(R.id.recycler_view_about);
        recyclerview.setAdapter(new MyAdapter(this));
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    private class MyAdapter extends RecyclerView.Adapter<MyHolder> {
        Context context;
        View view;
        public MyAdapter(Activity_About activity_about) {
            context = activity_about;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            view  = LayoutInflater.from(context).inflate(R.layout.item_about, parent, false);
            MyHolder h = new MyHolder(view);
            return h;
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
             holder.t1.setText(about_title[position]);
             holder.t2.setText(about_description[position]);
        }

        @Override
        public int getItemCount() {
            return about_title.length;
        }
    }
    class MyHolder extends RecyclerView.ViewHolder{
        TextView t1, t2;
        MyHolder(View itemView){
            super(itemView);
            t1 = itemView.findViewById(R.id.item_about_title);
            t2 = itemView.findViewById(R.id.item_about_description);
        }
    }
}