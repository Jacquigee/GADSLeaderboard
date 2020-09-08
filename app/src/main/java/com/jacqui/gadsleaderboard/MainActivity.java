package com.jacqui.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //ArrayList<LearningHours>  learningHours = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Retrofit

        //getLearnerResponse();
        
        //TabLayout
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabItem tabLearning = findViewById(R.id.learningTab);
        TabItem tabSkills = findViewById(R.id.skillsTab);
        final ViewPager viewPager = findViewById(R.id.viewPager);

        //Viewpager Adapter
        pagerAdapter pagerAdapter = new pagerAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

//    private void getLearnerResponse() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://gadsapi.herokuapp.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
//        Call<List<LearningHours>> call = requestInterface.getLearningJson();
//
//        call.enqueue(new Callback<List<LearningHours>>() {
//            @Override
//            public void onResponse(Call<List<LearningHours>> call, Response<List<LearningHours>> response) {
//                learningHours=new ArrayList<>(response.body());
//                Toast.makeText(MainActivity.this,"Success", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<List<LearningHours>> call, Throwable t) {
//                Toast.makeText(MainActivity.this,"Failed", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}