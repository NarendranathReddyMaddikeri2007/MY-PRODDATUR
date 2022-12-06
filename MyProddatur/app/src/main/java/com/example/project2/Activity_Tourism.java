package com.example.project2;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_Tourism extends AppCompatActivity {
    String names[]={
                    "Ammavarisala Temple",
                    "Rameswaram Temple",
                    "Ahobilam",
                    "Kanyateertham",
                    "Brahmamgari Matam",
                    "Vellala Temple",
                    "Gandi Temple",
                    "Gandikota Fort",
                    "Gandikota Canyon Camping",
                    "Belum Caves"
    };
    String location[]={
    "Sri Vasavi Kanyaka Parameswari Temple Proddatur",
    "Mukthi Rameswaram Temple Proddatur",
    "Ahobilam Temple Andhra Pradesh",
    "Kanyateertham Proddatur",
    "Brahmamgari Matam Kadapa",
    "Vellala Temple Proddatur",
    "Gandi Temple",
    "Gandikota Fort",
    "Gandikota Canyon Camping",
    "Belum Caves kurnool"
    };
    int image[]={R.drawable.ammavarisala,R.drawable.rameswaram_temple,R.drawable.ahobilam, R.drawable.kanyateertham,
                 R.drawable.brahmamgari_matam, R.drawable.vellala, R.drawable.gandi,R.drawable.gandikota_fort,
                 R.drawable.gandikota_camping, R.drawable.belum_caves
    };
    int distance[]={0,0,67,17,50,23,58,38,38,71};
    String more_info[]={
    "http://ammavarisala.blogspot.com/",
    "https://gotirupati.com/mukthi-rameshwaram-proddatur/",
    "https://www.ahobilamutt.org/us/information/visitingahobilam.asp",
    "https://etrace.in/pincode/andhra-pradesh/ysr-kadapa/jammalamadugu/kanyatheertham/",
    "https://www.tripadvisor.com/ShowUserReviews-g2285985-d2708897-r811861062-Brahmamgari_Matham_Temple-Guntur_Guntur_District_Andhra_Pradesh.html",
    "https://www.ishtadevata.com/temple/vellala-sanjeevaraya-swamy-temple-vellala-kadapa/",
    "https://www.viharadarshani.in/2021/02/gandi-anjaneya-temple-history-timings-distance.html/",
    "https://en.wikipedia.org/wiki/Gandikota",
    "http://gandikotacampingclub.com/",
    "https://en.wikipedia.org/wiki/Belum_Caves",
    };
    String description[]={
    "Sri Vasavi Kanyaka Parameswari Temple is  dedicated to Sri Kanyakaparameswari, a form of Goddess Parvati. " +
            "The Goddess Sri Kanyakaparameswari is the prime deity of AryaVysya community.",

    "Sri Rameswaram temple also known as Mukthi Rameswaram and Ramalingeswaram " +
            "is a very famous temple dedicated to Lord Shiva. To complete the pilgrimage " +
            "towards Varanasi (Kasi), one has to visit this temple. The Saikata Lingam in " +
            "the temple was installed by Lord Sri Rama. The temple was built " +
            "by Sri Krishan Devaraya in 16th century.",

    "Ahobilam is located in Kurnool district of Andhra Pradesh in the hills of the Eastern Ghats. " +
            "The temple consists of nine shrines to Lord Narasimha. In" +
            "addition to the nine shrines, there is a temple for " +
            "Prahaladavarada in the foothills of the mountain",

    "Kanya theertham is a holy place of lady deity sri Bala tripura sundari. " +
            "Many people adore her as Sreemaatha, Adi parashakthi, and Durga. " +
            "There are proofs that many jain theerthankaras and sages like agasthya " +
            "visited this place many centuries ago.",

    "Brahmamgari Matam Temple is dedicated to Brahmamgari who used to predict the " +
            "occurrences of the Kaliyuga. Sanctity of the site is due to the belief " +
            "that prophecies of Brahmamgari turned out to be true.",

    "The village is more popular in the hearts of devotees of Sri Hanuman because of the " +
            "ancient temple for the Lord located in this village. Lord of the kshetra is " +
            "known by the name Sri Sanjeevaraya Swami.",

    "Gandi is renowned for the Anjaneya Swamy Temple that has been " +
            "constructed on the west side of the River Papaghni, " +
            "on the foot of a hill."+
            "According to mythology, Lord Rama had once visited " +
            "this area while returning from Lanka.",

    "Belonging to the 13th century, architecture is inspired by Vijayanagar style and Quli Qutb style. " +
            "It is located in a scenic landscape with rich natural resources. " +
            "Deep valleys and hills surrounding the fort, it remained almost invincible.",

    "Gandikota – India’s own grand canyon, gandikota Grand Canyon Camping is specialized in providing delicious " +
            "food for a variety of adventure activities in Gandikota like camping " +
            "at Gandikota Canyon, Bonfire, Trekking, Kayaking and Back.",

    "Belum caves are second largest cave system on the Indian subcontinent, " +
            "known for its speleothems, " +
            "such as stalactite and stalagmite formations. "+
            "This cave system was formed over the course of tens of thousands of years " +
            "by the constant flow of underground water from the now-disappeared river Chitravathi."
    };
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //----------------------
        listview = findViewById(R.id.list_view_food_court);
        //----------------------
        listview.setAdapter(new MyAdapter(this));
    }

    private class MyAdapter extends BaseAdapter {
        Context context;
        public MyAdapter(Activity_Tourism activity_tourism) {
            context = activity_tourism;
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

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_tourism, parent, false);
            TextView btn =view.findViewById(R.id.tv_tourist_place);
            btn.setText(""+names[position]);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in=new Intent(Activity_Tourism.this, Activity_Tourism_Info.class);
                    in.putExtra("distance",distance[position]);
                    in.putExtra("location",location[position]);
                    in.putExtra("image",image[position]);
                    in.putExtra("more_info",more_info[position]);
                    in.putExtra("description",description[position]);
                    startActivity(in);
                }
            });
            return view;
        }
    }
}