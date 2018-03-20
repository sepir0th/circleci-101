package com.excite.mobile.shop.Activities.Home.EarnPointDetails;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.excitemobilesdk.CustomGridView.GridViewMenu;
import com.excite.mobile.shop.Activities.Home.EarnPointDetails.BonusPointDetails.BonusPointDetailsFragment;
import com.excite.mobile.shop.Activities.Home.EarnPointDetails.StampProgramDetails.StampProgramDetailsFragment;
import com.excite.mobile.shop.Activities.Search.SearchActivity;
import com.excite.mobile.shop.Activities.Home.EarnPointDetails.ShopOnline.ShopOnlineFragment;
import com.excite.mobile.shop.R;
import com.excite.mobile.shop.Utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

public class ListEarnPointsMenu extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View mProgressView;
    private ArrayList<GridViewMenu> gridViewMenus_onlineShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_earn_points_menu);

        int TabCurrentIndex = getIntent().getIntExtra(AppConstants.TAB_CURRENT_INDEX, 0);
        gridViewMenus_onlineShop = getIntent().getParcelableArrayListExtra(AppConstants.TAB_CONTENT);
        mProgressView = findViewById(R.id.login_progress);

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


        Button btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button btn_search = findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

        //showProgress(true);
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            viewPager.setVisibility(show ? View.GONE : View.VISIBLE);
            viewPager.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    viewPager.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            viewPager.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        if(getIntent().getStringExtra(AppConstants.TAB_TITLE).contentEquals(getString(R.string.card_title_online_shop))){
            for (GridViewMenu gridMenu : gridViewMenus_onlineShop) {
                adapter.addFragment(new ShopOnlineFragment(), gridMenu.getMenuTitle());
            }
        }else if(getIntent().getStringExtra(AppConstants.TAB_TITLE).contentEquals(getString(R.string.card_title_bonus_point))) {
            for (GridViewMenu gridMenu : gridViewMenus_onlineShop) {
                adapter.addFragment(new BonusPointDetailsFragment(), gridMenu.getMenuTitle());
            }
        }else{
            adapter.addFragment(new StampProgramDetailsFragment(), "Food & Beverage");
            adapter.addFragment(new StampProgramDetailsFragment(), "Luxury Dining");
            adapter.addFragment(new StampProgramDetailsFragment(), "Health & Beauty");
            adapter.addFragment(new StampProgramDetailsFragment(), "Stationary");
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
