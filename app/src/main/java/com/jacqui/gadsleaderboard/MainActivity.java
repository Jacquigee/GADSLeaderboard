package com.jacqui.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabItem tabLearning = findViewById(R.id.learningTab);
        TabItem tabSkills = findViewById(R.id.skillsTab);
        ViewPager viewPager = findViewById(R.id.viewPager);
    }
}