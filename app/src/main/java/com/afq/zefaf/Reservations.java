package com.afq.zefaf;

import android.os.Bundle;

import com.afq.zefaf.Adapter.PagerAdapter;
import com.afq.zefaf.Fragments.ItemFragment;
import com.afq.zefaf.Fragments.NoReservationsFragment;
import com.afq.zefaf.Fragments.dummy.DummyContent;
import com.afq.zefaf.Model.Tabs;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

public class Reservations extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    private MaterialToolbar mToolbar;
    private TabLayout mTabs;

    PagerAdapter pagerAdapter;
    ViewPager viewPager;
    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle(getString(R.string.app_name));
        mToolbar.setTitleTextColor(getColor(R.color.accent));
        mToolbar.setBackgroundColor(getColor(R.color.white));

        setupTabs();
    }

    public void setupTabs(){

        mTabs = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.pager);

        mTabs.setTabTextColors(getColor(R.color.black), getColor(R.color.accent));
        mTabs.setSelectedTabIndicatorColor(getColor(R.color.accent));

        ArrayList tabs = new ArrayList<>();
        tabs.add(new Tabs(getString(R.string.current_res), new ItemFragment()));
        tabs.add(new Tabs(getString(R.string.previous_res), new NoReservationsFragment()));

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, tabs);
        viewPager.setAdapter(pagerAdapter);
        mTabs.setupWithViewPager(viewPager);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        ft.commit();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
