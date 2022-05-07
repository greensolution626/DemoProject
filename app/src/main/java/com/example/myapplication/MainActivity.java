package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.adapters.HomeLiveTestAdapter;
import com.example.myapplication.adapters.HomeSliderAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager viewpager_image;
    private TabLayout indicator;
    private HomeSliderAdapter homeSliderAdapter;

    private TextView tv_seeAllLiveTest;
    private RecyclerView recy_liveTest;
    private HomeLiveTestAdapter liveTestAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpager_image = findViewById(R.id.viewpager_image);
        indicator = findViewById(R.id.indicator);
        homeSliderAdapter = new HomeSliderAdapter(this);
        viewpager_image.setAdapter(homeSliderAdapter);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);
        indicator.setupWithViewPager(viewpager_image, true);

        tv_seeAllLiveTest = findViewById(R.id.tv_seeAllLiveTest);
        recy_liveTest = findViewById(R.id.recy_liveTest);
        recy_liveTest.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        liveTestAdapter = new HomeLiveTestAdapter(this, this);
        recy_liveTest.setAdapter(liveTestAdapter);

    }

    @Override
    public void onClick(View view) {

    }

    private class SliderTimer extends TimerTask {

        @Override
        public void run() {

            if (MainActivity.this != null) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (viewpager_image.getCurrentItem() < 6 - 1) {
                            viewpager_image.setCurrentItem(viewpager_image.getCurrentItem() + 1);
                        } else {
                            viewpager_image.setCurrentItem(0);
                        }
                    }
                });
            }

        }
    }
}