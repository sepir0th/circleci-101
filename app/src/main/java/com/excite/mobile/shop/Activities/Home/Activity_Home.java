package com.excite.mobile.shop.Activities.Home;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.excite.mobile.shop.Activities.Home.Promo.PromoAdapter;
import com.excite.mobile.shop.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by erwinlim on 12/02/18.
 */

public class Activity_Home extends Fragment{
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    /*
     * our parameters to set Promo functions
     */
    public final static int PAGES = 5;
    // You can choose a bigger number for LOOPS, but you know, nobody will fling
    // more than 1000 times just in order to test your "infinite" ViewPager :D
    public final static int LOOPS = 1000;
    public final static int FIRST_PAGE = PAGES * LOOPS / 2;

    public PromoAdapter adapter;
    public ViewPager pager;
    /*
     * ends of promo parameters
     */

    public Activity_Home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout homeLayout = (LinearLayout )inflater.inflate(R.layout.fragment_home, container, false);
        toolbar = homeLayout.findViewById(R.id.toolbar);

        viewPager = homeLayout.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = homeLayout.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        return homeLayout;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new Activity_Redeem(), getResources().getString(R.string.REDEEM_POINT));
        adapter.addFragment(new Activity_EarnPoint(), getResources().getString(R.string.EARN_POINT));
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
