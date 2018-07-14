package com.example.lenovo.educationapp;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        tabLayout=(TabLayout)findViewById(R.id.tab);
        viewPager=(ViewPager)findViewById(R.id.pager);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        }); viewPager.setAdapter(new HomeAdapter(getSupportFragmentManager()));

    }

    private class HomeAdapter extends FragmentPagerAdapter {


        public HomeAdapter(android.support.v4.app.FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "ADD Values";
                case 1:
                    return "Phone Database";
                case 2 :
                    return "Server Database";
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new TAB1();
                case 1:
                    return new TAB2();
                case 2:
                    return new TAB3();
            }
            return null;
        }


    }
}