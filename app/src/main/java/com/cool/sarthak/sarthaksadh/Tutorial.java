package com.cool.sarthak.sarthaksadh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class Tutorial extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        addFragment(new Step.Builder()
//                setTitle("#HASHTAG")
                .setContent("Worried about reviews?\nLiked your product or not?\nTheir Reactions?\n\nHASHTAG provides an ultimate solution .")
                .setBackgroundColor(Color.parseColor("#076585")) // int background color
                .setDrawable(R.drawable.hashx) // int top drawable
                // .setSummary("This is summary")
                .build());

        addFragment(new Step.Builder()
                .setContent("Personalised Search\nEnter a hashtag\nGet total hashtag count\nGenerate a graph for positive and negative reviews.")
                .setBackgroundColor(Color.parseColor("#076585")) // int background color
                .setDrawable(R.drawable.graph) // int top drawable
                // .setSummary("")
                .build());




    }

    @Override
    public void finishTutorial() {
        SharedPreferences getPref = PreferenceManager.getDefaultSharedPreferences(this);
        getPref.edit().putString("intro_cleared","yes").apply();
        Intent intent = new Intent(Tutorial.this,Search.class);
        startActivity(intent);
        finish();
    }
}

