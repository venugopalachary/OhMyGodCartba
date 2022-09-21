package com.ohmygodcart.android.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ohmygodcart.android.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        // hide the title bar name
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().hide();

        //

        /*Duration of wait*/
        int SPLASH_DISPLAY_LENGTH = 5000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the MainActivity. */
                Intent onboardIntent = new Intent(SplashScreen.this, Onboarding.class);
                startActivity(onboardIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}