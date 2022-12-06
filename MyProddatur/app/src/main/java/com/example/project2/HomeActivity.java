package com.example.project2;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {
    ImageButton info, tourism, food, movies, gold, cloth, transport, institutions, dasara;
    private String user_email, user_name, user_feedback, my_email="dossier.technologies15@gmail.com";
    private FirebaseAuth firebaseAuth;
    private GoogleSignInClient googleSignInClient;
    private static final String AD_UNIT_ID = "ca-app-pub-9565330992545160~2413884732";
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //------------------------------------
        makeAds();
        //MobileAds.initialize(HomeActivity.this,getString(R.string.admob_ad_Id));
        //------------------------------------
        info = findViewById(R.id.ib_home_info);
        tourism = findViewById(R.id.ib_home_tourism);
        food = findViewById(R.id.ib_home_food);
        movies = findViewById(R.id.ib_home_movies);
        gold = findViewById(R.id.ib_home_gold);
        dasara = findViewById(R.id.ib_home_dasara_celebrations);
        cloth = findViewById(R.id.ib_home_cloths);
        transport = findViewById(R.id.ib_home_transport);
        institutions = findViewById(R.id.ib_home_institutions);
        //------------------------------------
        //firebase
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            user_email=firebaseUser.getEmail();
            user_name=firebaseUser.getDisplayName();
        }
        googleSignInClient= GoogleSignIn.getClient(HomeActivity.this, GoogleSignInOptions.DEFAULT_SIGN_IN);
        //------------------------------------
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //------------------------
                Intent inf = new Intent(HomeActivity.this, Activity_About.class);
                startActivity(inf);
            }
        });
        //----------
        dasara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent das = new Intent(HomeActivity.this, Activity_Dasara.class);
                startActivity(das);
            }
        });
        //----------
        tourism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trsm=new Intent(HomeActivity.this, Activity_Tourism.class);
                startActivity(trsm);
            }
        });
        //----------
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fd=new Intent(HomeActivity.this, Activity_FoodCourt.class);
                startActivity(fd);
            }
        });
        //----------
        movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mvs=new Intent(HomeActivity.this, Activity_Movies.class);
                startActivity(mvs);
            }
        });
        //----------
        gold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gld = new Intent(HomeActivity.this, Activity_Gold.class);
                startActivity(gld);
            }
        });
        //----------
        cloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clth=new Intent(HomeActivity.this, Activity_Clothing.class);
                startActivity(clth);
            }
        });
        //----------
        institutions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inst=new Intent(HomeActivity.this, Activity_Institutions.class);
                startActivity(inst);
            }
        });
        //----------
        transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tran=new Intent(HomeActivity.this, Activity_Transport.class);
                startActivity(tran);
            }
        });
        //-----------------------------------
        
    }

    private void makeAds() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
    //------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i=getMenuInflater();
        i.inflate(R.menu.menu,menu);
        return true;
    }
    //------------------------------------

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.menu_user_info:
                  onUserInfoClick();
                  break;
            case R.id.menu_signout:
                 onSignoutClick();
                break;
            case R.id.menu_feedback:
                 onFeedbackClick();
                break;
            case R.id.menu_about:
                 onAboutClick();
                break;
            case R.id.menu_exit:
                 onExitClick();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
    //firebase
    private void onSignoutClick() {
        // Sign out from google
        googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    firebaseAuth.signOut();
                    Toast.makeText(getApplicationContext(), "Logout successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

    private void onFeedbackClick() {
        Intent fdbk=new Intent(HomeActivity.this,Activity_Feedback.class);
        fdbk.putExtra("user_email",user_email);
        fdbk.putExtra("admin_email",my_email);
        startActivity(fdbk);
    }

    private void onAboutClick() {
        Intent abt=new Intent(HomeActivity.this,Activity_User_Settings.class);
        startActivity(abt);
    }

    private void onExitClick() {
        finish();
    }

    private void onUserInfoClick() {
        Intent ui=new Intent(HomeActivity.this, Activity_UserInfo.class);
        ui.putExtra("user_name",user_name);
        ui.putExtra("user_email",user_email);
        startActivity(ui);
    }

    //------------------------------------
    private void signOut() {
        googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    firebaseAuth.signOut();
                    Toast.makeText(getApplicationContext(), "Logout successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(HomeActivity.this, MainActivity.class));
                    finish();
                }
            }
        });
    }
}
