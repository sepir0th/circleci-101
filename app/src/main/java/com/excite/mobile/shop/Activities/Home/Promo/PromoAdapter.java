package com.excite.mobile.shop.Activities.Home.Promo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.excite.mobile.shop.Activities.Home.Activity_Redeem;
import com.excite.mobile.shop.R;

public class PromoAdapter extends FragmentPagerAdapter implements ViewPager.PageTransformer {
    public final static float BIG_SCALE = 1.4f;
    public final static float SMALL_SCALE = 1.4f;
    public final static float DIFF_SCALE = BIG_SCALE - SMALL_SCALE;

    private LinearLayoutPromo cur = null;
    private LinearLayoutPromo next = null;
    private Context context;
    private FragmentManager fm;
    private float scale;
    private int[] images;

    public PromoAdapter(Context context, FragmentManager fm, int[] images) {
        super(fm);
        this.fm = fm;
        this.context = context;
        this.images = images;
    }

    @Override
    public Fragment getItem(int position) {
        // make the first pager bigger than others
        if (position == Activity_Redeem.FIRST_PAGE)
            scale = BIG_SCALE;
        else
            scale = SMALL_SCALE;

        position = position % Activity_Redeem.PAGES;
        return FragmentPromo.newInstance(context, position, scale, this.images[position]);
    }

    @Override
    public int getCount() {
        return Activity_Redeem.PAGES * Activity_Redeem.LOOPS;
    }

    @Override
    public void transformPage(View page, float position) {
        LinearLayoutPromo linearLayoutPromo = page.findViewById(R.id.root);
        float scale = BIG_SCALE;
        if (position > 0) {
            scale = scale - position * DIFF_SCALE;
        } else {
            scale = scale + position * DIFF_SCALE;
        }
        if (scale < 0) scale = 0;
        linearLayoutPromo.setScaleBoth(scale);
    }
}
