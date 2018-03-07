package com.example.lenovo.myapplication.Activities.RedeemPointsDetails;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.lenovo.myapplication.Activities.EarnPointDetails.ListEarnPointsMenu;
import com.example.lenovo.myapplication.Activities.EarnPointDetails.ListEarnPointsMenuFragment;
import com.example.lenovo.myapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class RedeemDetailsHome extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_earn_points_menu);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("Redeem Point");

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout =  findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new RedeemDetailsFragment(), "Pulsa");
        adapter.addFragment(new RedeemDetailsFragment(), "Paket Data");
        adapter.addFragment(new RedeemDetailsFragment(), "PLN");
        adapter.addFragment(new RedeemDetailsFragment(), "Telepon");
        adapter.addFragment(new RedeemDetailsFragment(), "BPJS");
        adapter.addFragment(new RedeemDetailsFragment(), "PDAM");
        adapter.addFragment(new RedeemDetailsFragment(), "Voucher");
        adapter.addFragment(new RedeemDetailsFragment(), "E-Voucher");
        adapter.addFragment(new RedeemDetailsFragment(), "Kuliner");
        adapter.addFragment(new RedeemDetailsFragment(), "Elektronik");
        adapter.addFragment(new RedeemDetailsFragment(), "Games");
        adapter.addFragment(new RedeemDetailsFragment(), "Cicilan");
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

