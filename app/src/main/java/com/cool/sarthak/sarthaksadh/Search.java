package com.cool.sarthak.sarthaksadh;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Search extends Activity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        editText = findViewById(R.id.email);
    }

    public void chutia(View view) {
        String s = "#";
        s = s + editText.getText().toString();
        if (s.equals("#")) {
            int x =0;

        } else {

            Intent intent = new Intent(this, Graphs.class);
            intent.putExtra("hash", s);
            startActivity(intent);


        }
    }
}
