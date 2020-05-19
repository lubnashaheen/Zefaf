package com.afq.zefaf;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class Reservations extends AppCompatActivity {

    private MaterialToolbar mToolbar;
    private TabLayout mTabs;
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle(getString(R.string.app_name));
        mToolbar.setTitleTextColor(getColor(R.color.accent));
        mToolbar.setBackgroundColor(getColor(R.color.white));

        mTabs = findViewById(R.id.tabs);
        mTabs.setTabTextColors(getColor(R.color.black), getColor(R.color.accent));
        mTabs.setSelectedTabIndicatorColor(getColor(R.color.accent));

        mPager = findViewById(R.id.pager);

        mTabs.setupWithViewPager(mPager);
    }
}
