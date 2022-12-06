package com.example.project2;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Movies extends AppCompatActivity {

    String[] hall ={"CineHub",
            "Araveti Theatre 2k a/c Dts",
            "Sri Venkateswara Theatre",
            "Sudha Theatre",
            "Sree Chand Theatre",
    };

    String[] location ={"CineHub Proddatur",
            "Araveti Theatre 2k a/c Dts Proddatur",
            "Sri Venkateswara Theatre Proddatur",
            "Sudha Theatre Proddatur",
            "Sree Chand Theatre Proddatur",
            };
    int[] hall_image ={R.drawable.cinehub_movies,
    R.drawable.araveti_movies, R.drawable.venkateswara_movies,
    R.drawable.sudha_movies, R.drawable.chand_movies};

    String[] movies ={"https://in.bookmyshow.com/proddatur/cinemas/sri-sai-rajeswari-complex-cine-hub-proddatur/SSRC",
            "https://in.bookmyshow.com/proddatur/cinemas/araveti-2k-ac-dolby-atmos-proddatur/AVTI",
            "https://www.ticketnew.com/Sri-Venkateswara-Picture-Palce-2K-3D-A-C-Dts-Proddatur-Book-My-Movie-Show-Tickets/Online-Ticket-Booking/1563",
            "https://in.bookmyshow.com/proddatur/cinemas/sudha-theater-ac-ufo-2k-dolby-proddatur/STHP",
            "https://in.bookmyshow.com/proddatur/cinemas/chand-picture-palace-ac-dts-proddatur/CPPD",
            };
    ListView listview_movies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //--------------------------------
        listview_movies = findViewById(R.id.list_view_movies);
        //--------------------------------
        listview_movies.setAdapter(new MyAdapter(this));
    }

    private class MyAdapter extends BaseAdapter {
        Context context; View view;
        public MyAdapter(Activity_Movies activity_movies) {
            context = activity_movies;
        }

        @Override
        public int getCount() {
            return hall.length;
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
            view = LayoutInflater.from(context).inflate(R.layout.item_movies, parent, false);
            TextView title = view.findViewById(R.id.tv_title_hall_movies);
            title.setText(""+hall[position]);
            TextView locn = view.findViewById(R.id.tv_location_hall_movies);
            ImageView iv = view.findViewById(R.id.iv_hall_movies);
            iv.setImageResource(hall_image[position]);
            locn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("geo:0,0?q="+location[position]);
                    Intent i1;
                    i1 = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(i1);
                }
            });
            TextView book_movies = view.findViewById(R.id.tv_book_movies);
            book_movies.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse(""+movies[position]);
                    Intent i2 =new  Intent(Intent.ACTION_VIEW, uri);
                    startActivity(i2);
                }
            });
            return view;
        }
    }
}

