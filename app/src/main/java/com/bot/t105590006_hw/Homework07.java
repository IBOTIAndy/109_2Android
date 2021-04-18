package com.bot.t105590006_hw;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class Homework07 extends AppCompatActivity {
    // The order message, displayed in the Toast and sent to the new Activity.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework07);

        // ... Code inside onCreate() method
        Toolbar toolbar = findViewById(R.id.hw07_toolbar); //test
        setSupportActionBar(toolbar);
        // Create an instance of the tab layout from the view.
        TabLayout tabLayout = findViewById(R.id.hw07_tab_layout);
        // Set the text for each tab.
        tabLayout.addTab(tabLayout.newTab().setText(R.string.hw07_tabLayout_left));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.hw07_tabLayout_mid));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.hw07_tabLayout_right));
        // Set the tabs to fill the entire layout.
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        // Use PagerAdapter to manage page views in fragments.
        // Each page is represented by its own fragment.
        final ViewPager viewPager = findViewById(R.id.hw07_pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        // Setting a listener for clicks.
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
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
}

