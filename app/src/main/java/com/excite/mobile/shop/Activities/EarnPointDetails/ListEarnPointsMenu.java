package com.excite.mobile.shop.Activities.EarnPointDetails;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.excitemobilesdk.CustomGridView.GridViewMenu;
import com.excite.mobile.shop.R;
import com.excite.mobile.shop.Utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

public class ListEarnPointsMenu extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<GridViewMenu> gridViewMenus_onlineShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_earn_points_menu);

        int TabCurrentIndex = getIntent().getIntExtra(AppConstants.TAB_CURRENT_INDEX, 0);
        gridViewMenus_onlineShop = getIntent().getParcelableArrayListExtra(AppConstants.TAB_TITLE);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        //here we are auto select the tab based on previous selection item
        tabLayout =  findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(TabCurrentIndex).select();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        if(gridViewMenus_onlineShop != null) {
            for (GridViewMenu gridMenu : gridViewMenus_onlineShop) {
                adapter.addFragment(new ListEarnPointsMenuFragment(), gridMenu.getMenuTitle());
            }
        }else{
            adapter.addFragment(new ListEarnPointsMenuFragment(), "Food & Beverage");
            adapter.addFragment(new ListEarnPointsMenuFragment(), "Luxury Dining");
            adapter.addFragment(new ListEarnPointsMenuFragment(), "Health & Beauty");
            adapter.addFragment(new ListEarnPointsMenuFragment(), "Stationary");
        }
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
