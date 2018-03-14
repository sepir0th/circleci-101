package com.excite.mobile.shop.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.excite.mobile.shop.Activities.Home.Activity_Home;
import com.excite.mobile.shop.Activities.Profile.ProfileActivity;
import com.excite.mobile.shop.Activities.Search.SearchActivity;
import com.excite.mobile.shop.R;
import com.excite.mobile.shop.WelcomeSliders.PrefManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by LENOVO on 06/02/2018.
 */
public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Button btn_search;
    private Button btn_profile;
    private FirebaseAnalytics mFirebaseAnalytics;
    public PrefManager prefManager;
    public FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        // Checking for first time launch - before calling setContentView()
        prefManager = new PrefManager(this);

        if (!prefManager.isLoginSession() && this.mAuth.getCurrentUser()== null) {
            finish();
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout =  findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        btn_search = findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), SearchActivity.class);
                startActivity(intent);
            }
        });
        btn_profile = findViewById(R.id.btn_profile);
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });


        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "dashboard");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "dashboard");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "screen");
        mFirebaseAnalytics.logEvent("Click_promo_banner", bundle);
        mFirebaseAnalytics.setCurrentScreen(this, "Dashboard", null /* class override */);
        mFirebaseAnalytics.setUserProperty("favorite_item", "lazada");
    }

    /**
     * our function to move the activity into the dashboard.
     */
    public void launchDashboardScreen() {
        prefManager.setLoginSession(true);
        startActivity(new Intent(MainActivity.this, MainActivity.class));
        finish();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Activity_Home(), "Beranda");
        adapter.addFragment(new TwoFragment(), "Info");
        adapter.addFragment(new TwoFragment(), "Bantuan");
        adapter.addFragment(new TwoFragment(), "History");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}