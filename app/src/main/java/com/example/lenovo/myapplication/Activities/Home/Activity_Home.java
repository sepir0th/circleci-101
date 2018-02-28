package com.example.lenovo.myapplication.Activities.Home;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.lenovo.myapplication.Activities.MainActivity;
import com.example.lenovo.myapplication.Activities.TwoFragment;
import com.example.lenovo.myapplication.CustomGridview.Book;
import com.example.lenovo.myapplication.CustomGridview.BooksAdapter;
import com.example.lenovo.myapplication.CustomGridview.SubHeaderMenuAdapter;
import com.example.lenovo.myapplication.Promo.MyPagerAdapter;
import com.example.lenovo.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.views.BannerSlider;


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

    public MyPagerAdapter adapter;
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
        adapter.addFragment(new Activity_Redeem(), "Redeem Point");
        adapter.addFragment(new Activity_EarnPoint(), "Dapatkan Point");
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
