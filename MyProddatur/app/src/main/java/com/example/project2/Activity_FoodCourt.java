package com.example.project2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_FoodCourt extends AppCompatActivity {
    String names[]={"Zwarma proddatur",
                    "Spot Cafe",
                    "Cool Court Restaurant",
                    "CRUSH cafe and restaurant",
                    "Jail Food House",
                    "Pizza Hut",
                    "Grilled and Fried",
                    "Arabian Hotel, Mandi House",
                    "People's Dine",
                    "Manasa Restaurant",
                    "Sagar Restaurant",
                    "Andhra Spice Restaurant",
                    "Haritha Vanam Restaurant",
                    "Kritunga Restaurant"};
    String type[]={"Chicken Restaurant",
                   "Continental Restaurant",
                   "Restaurant",
                   "Restaurant",
                   "Family Restaurant",
                   "Pizza Restaurant",
                   "Restaurant",
                   "Arabian Restaurant",
                   "Restaurant",
                   "Family Restaurant",
                   "Veg Restaurant",
                   "Andhra Restaurant",
                   "Restaurant",
                   "Family Restaurant"};
    String[] location ={"Zwarma proddatur",
                       "Spot Cafe Proddatur",
                       "Cool Court Restaurant Proddatur",
                       "CRUSH cafe and restaurant Proddatur",
                       "Jail Food House Proddatur",
                       "Pizza Hut Proddatur",
                       "Grilled and Fried Proddatur",
                       "Arabian Hotel, Mandi House Proddatur",
                       "People's Dine Proddatur",
                       "Manasa Restaurant Proddatur",
                       "Sagar Restaurant Proddatur",
                       "Andhra Spice Restaurant Proddatur",
                       "Haritha Vanam Restaurant Proddatur",
                       "Kritunga Restaurant Proddatur"};
    ListView listview_food_court;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_court);
       // this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //----------------------
        listview_food_court = findViewById(R.id.list_view_food_court);
        //----------------------
        listview_food_court.setAdapter(new MyAdapter(this));
        //----------------------
    }

    private class MyAdapter extends BaseAdapter {
        Context context;
        View view;
        public MyAdapter(Activity_FoodCourt activity_foodCourt) {
            context = activity_foodCourt;
        }

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @SuppressLint({"ViewHolder", "SetTextI18n"})
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
            TextView title=view.findViewById(R.id.tv_title_food_court);
            title.setText(""+names[position]);
            TextView description = view.findViewById(R.id.tv_description_food_court);
            description.setText(""+type[position]);
            TextView button = view.findViewById(R.id.tv_button_food_court);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("geo:0,0?q="+location[position]);
                    Intent i2;
                    i2 = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(i2);
                }
            });
            return view;
        }
    }
}
