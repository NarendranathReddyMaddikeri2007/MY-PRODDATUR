package com.example.project2;

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

public class Activity_Clothing extends AppCompatActivity {

    ListView listview;

    String[] brand_name ={"URBAN TOUCH","RELIANCE TRENDS","MAX","Easybuy","Jockey Exclusive Store",
    "ALLEN SOLLY","Peter England","ROMAN ISLAND","Pan America Outlet","The Arvind Store"};

    String[] shop_address ={"10/466, Opp. RTC Bus Stand, Mydukur Road, Proddatur, Andhra Pradesh 516360",
    "7, G1&1A, SS Mall and Multiplex, 834, Korrapadu Rd, YMR Colony, Proddatur, Andhra Pradesh 516360",
    "7/947, YMR Colony, Proddatur, Andhra Pradesh 516360",
    "7, Ground and first floor. SS Mall and Multiplex, 834, Korrapadu Rd, YMR Colony, Proddatur, Andhra Pradesh 516360",
    "G1 - G1A, SS Mall Multiplex, Korrapadu Rd, Proddatur, Andhra Pradesh 516360",
    "7, 833/1/2, Korrapadu Rd, beside SS MALL, YMR Colony, Proddatur, Andhra Pradesh 516360",
    "D.no, 8-702, Gandhi Rd, near MORE Super Market, Sarvakatta, Proddatur, Andhra Pradesh 516360",
    "24/459, Gandhi Rd, Sarvakatta, Proddatur, Andhra Pradesh 516360",
    "Vijayanagaram St, Sarvakatta, Proddatur, Andhra Pradesh 516360",
    "Shop No G-5, SS Mall, Korrapadu Rd, near Dandapani Arvind Store, YMR Colony, Proddatur, Andhra Pradesh 516360"};

    String[] brand_website ={"https://urban-touch.business.site/","http://trends.ajio.com/",
    "https://www.maxfashion.in/in/en/","https://easybuyindia.com/","https://stores.jockey.in/jockey-exclusive-store-proddatur-kadapa-19069/home?utm_source=GMB",
    "http://wwww.allensollyindia.com/","http://red.peterengland.com/",
    "http://www.romanisland.com/","https://pan-america-exclusive-outlet.business.site/",
    "https://stores.thearvindstore.com/menswear-proddatur-cuddapah-29048/home?utm_source=GMB"};

    String[] shop_location ={"URBAN TOUCH Proddatur","TRENDS Proddatur","Max Proddatur","EasyBuy Proddatur",
    "Jockey Exclusive Store Proddatur","ALLEN SOLLY PRODDATUR","Peter England Menswear Exclusive Showroom Proddatur",
    "ROMAN ISLAND Proddatur","Pan America Exclusive Outlet Proddatur",
    "The Arvind Store Proddatur"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing);
        //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //----------------------------------------
        listview= findViewById(R.id.list_view_cloths);
        listview.setAdapter(new MyAdapter(this));
    }
    //----------------------------------------
    private class MyAdapter extends BaseAdapter {
        Context context;
        View view;
        public MyAdapter(Activity_Clothing activity_clothing) {
            context = activity_clothing;
        }

        @Override
        public int getCount() {
            return brand_name.length;
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
            view = LayoutInflater.from(context).inflate(R.layout.item_clothing, parent, false);
            TextView title, address, location, website;
            title = view.findViewById(R.id.tv_title_cloth_shop);
            address = view.findViewById(R.id.tv_address_cloth_shop);
            website = view.findViewById(R.id.tv_website_cloth_brand);
            location = view.findViewById(R.id.tv_location_cloth_shop);
            title.setText(brand_name[position]);
            address.setText(shop_address[position]);
            //----------
            website.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse(brand_website[position].toString());
                    Intent i1 = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(i1);
                }
            });
            //----------
            location.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("geo:0,0?q="+shop_location[position].toString());
                    Intent i2 = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(i2);
                }
            });
            //----------
            return view;
        }
    }
}