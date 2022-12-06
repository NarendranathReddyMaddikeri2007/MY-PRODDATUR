package com.example.project2;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


public class MainActivity extends AppCompatActivity {
    private GoogleSignInClient googleSignInClient;
    private FirebaseAuth firebaseAuth;
    SignInButton btSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        btSignIn = findViewById(R.id.button_user_sign_in);
        //-------------------------------------
        GoogleSignInOptions googleSignInOptions=new GoogleSignInOptions.Builder(
                GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("985057027615-4cc79rdi5ibecevgfpivq51ttr2j3nug.apps.googleusercontent.com")
                .requestEmail()
                .build();
        googleSignInClient= GoogleSignIn.getClient(MainActivity.this,googleSignInOptions);
        //-------------------------
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=googleSignInClient.getSignInIntent();
                startActivityForResult(intent,100);
            }
        });
        //-------------------------
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        //-------------------------
        if(firebaseUser!=null){
            startActivity(new Intent(MainActivity.this,Activity_SplashScreen.class)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            Task<GoogleSignInAccount> signInAccountTask=GoogleSignIn.getSignedInAccountFromIntent(data);
            if(signInAccountTask.isSuccessful()){
                String s="Google sign in successful";
                displayToast(s);
                //-------------------------
                try {
                    GoogleSignInAccount googleSignInAccount=signInAccountTask.getResult(ApiException.class);
                    if(googleSignInAccount!=null){
                        AuthCredential authCredential= GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(),null);
                        firebaseAuth.signInWithCredential(authCredential)
                                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(task.isSuccessful()){
                                            startActivity(new Intent(MainActivity.this,Activity_SplashScreen.class)
                                                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                                            finish();
                                            displayToast("Firebase authentication successful");
                                        }
                                        else{
                                            displayToast("Authentication Failed"+task.getException().getMessage());
                                        }
                                    }
                                });
                        //-------------------------
                    }
                }
                catch (ApiException e){
                    e.printStackTrace();
                }
            }
        }
    }
    private void displayToast(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }
}