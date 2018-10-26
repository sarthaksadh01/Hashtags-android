package com.cool.sarthak.sarthaksadh;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SharedPreferences getPref = PreferenceManager.getDefaultSharedPreferences(this);
       final String intro_status = getPref.getString("intro_cleared",null);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                if(intro_status==null){
                    Intent mainIntent = new Intent(SplashScreen.this, Tutorial.class);
                    SplashScreen.this.startActivity(mainIntent);
                    SplashScreen.this.finish();
                }
                else{
                    Intent mainIntent = new Intent(SplashScreen.this, Search.class);
                    SplashScreen.this.startActivity(mainIntent);
                    SplashScreen.this.finish();
                }


            }
        }, 3300);

    }
}
