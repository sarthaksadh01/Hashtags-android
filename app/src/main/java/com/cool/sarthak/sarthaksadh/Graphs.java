package com.cool.sarthak.sarthaksadh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Graphs extends Activity {
    TextView textView,cnt;
    RelativeLayout loading,data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphs);
        int yes = ThreadLocalRandom.current().nextInt(1000,10001);
        int no = ThreadLocalRandom.current().nextInt(1000,10001);
        int z =yes+no;
        loading=findViewById(R.id.loading);
        data2=findViewById(R.id.data);

        textView = findViewById(R.id.hash);
        cnt = findViewById(R.id.count);
        cnt.setText("Total Tweets: "+z);
        Bundle bundle = getIntent().getExtras();
        String hash = bundle.getString("hash");
        textView.setText(hash);
        final BarChart chart = (BarChart) findViewById(R.id.bar_chart);
        ArrayList<BarEntry> BarEntry = new ArrayList<>();
        BarEntry.add(new BarEntry(1f, yes));
        BarEntry.add(new BarEntry(2f, no));
        BarDataSet dataSet = new BarDataSet(BarEntry, "Projects");
        ArrayList<String> labels = new ArrayList<>();

        labels.add("Yes");
        labels.add("No");

        final BarData b = new BarData(dataSet);
        dataSet.setColors(new int[]{R.color.a,R.color.b}, this);
        chart.setDrawGridBackground(false);
        chart.setDescription("");
        chart.setDrawBorders(true);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                loading.setVisibility(View.GONE);
                data2.setVisibility(View.VISIBLE);
                chart.animateY(2000);
                chart.setData(b);


            }
        }, 6600);



    }
}
