package com.example.katakita.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.katakita.R;
import com.example.katakita.adapter.viewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class chatActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private viewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        adapter = new viewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}