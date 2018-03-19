package com.excite.mobile.shop.Activities.Home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.excitemobilesdk.CardViewMenu.CardViewMenu;
import com.example.excitemobilesdk.CardViewMenu.CardViewMenuAdapter;
import com.example.excitemobilesdk.CardViewMenu.CardViewMenuListener;
import com.example.excitemobilesdk.CustomGridView.GridViewMenu;
import com.example.excitemobilesdk.CustomGridView.GridViewMenuAdapter;
import com.example.excitemobilesdk.CustomGridView.SubHeaderMenuAdapter;
import com.excite.mobile.shop.Activities.RedeemPointsDetails.RedeemDetailsHome;
import com.excite.mobile.shop.Promo.PromoAdapter;
import com.excite.mobile.shop.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.excitemobilesdk.Utils.AppConstants.CARD_VIEW_STATIC_MODE;


/**
 * Created by erwinlim on 12/02/18.
 */

public class Activity_Redeem extends Fragment implements View.OnClickListener, CardViewMenuListener {

    /*
     * our parameters to set Promo functions
     */
    public final static int PAGES = 5;
    // You can choose a bigger number for LOOPS, but you know, nobody will fling
    // more than 1000 times just in order to test your "infinite" ViewPager :D
    public final static int LOOPS = 1;
    public final static int FIRST_PAGE = PAGES * LOOPS / 2;

    public PromoAdapter adapter;
    public ViewPager pager;

    int currentPage = 0;
    /*
     * ends of promo parameters
     */

    public Activity_Redeem() {
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
        LinearLayout mainLayout = (LinearLayout )inflater.inflate(R.layout.fragment_redeem, container, false);
        setupMainMenu(mainLayout);
        setupPromo(mainLayout);
        setupGridViewSubMenu(mainLayout);

        return mainLayout;
    }

    public void setupGridViewSubMenu(LinearLayout mainLayout){
        //setup sub header menu gridview
//        GridViewMenu subHeaderGridMenuScanTrans = new GridViewMenu("Scan Transaksi", R.drawable.ic_011_gift_2);
//        GridViewMenu subHeaderGridMenuStamp = new GridViewMenu("Stamp Program", R.drawable.ic_012_browser_1);
//        GridViewMenu subHeaderGridMenuScanQR = new GridViewMenu("Scan QR To Pay", R.drawable.ic_054_smartphone_1);
//        GridViewMenu[] subHeaderGridMenuItems = {subHeaderGridMenuScanTrans, subHeaderGridMenuStamp, subHeaderGridMenuScanQR};
//        GridView subHeaderGridMenu = mainLayout.findViewById(R.id.SubHeaderGridMenu);
//        SubHeaderMenuAdapter subHeaderGridMenuAdapter = new SubHeaderMenuAdapter(getContext(), subHeaderGridMenuItems);
//        subHeaderGridMenu.setAdapter(subHeaderGridMenuAdapter);
//        subHeaderGridMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Log.i("Menu clicked : ", String.valueOf(position));
//                if(position == 3){
//
//                }
//            }
//        });
    }

    public GridViewMenuAdapter setupGridViewMainMenu(){
        GridViewMenu mainRedemptionPulsa = new GridViewMenu("Pulsa", R.drawable.ic_054_smartphone_1);
        GridViewMenu mainRedemptionPaketData = new GridViewMenu("Paket Data", R.drawable.ic_012_browser_1);
        GridViewMenu mainRedemptionPLN = new GridViewMenu("PLN", R.drawable.ic_009_startup);
        GridViewMenu mainRedemptionTelepon = new GridViewMenu("Telepon", R.drawable.ic_002_credit_card_6);
        GridViewMenu mainRedemptionBPJS = new GridViewMenu("BPJS", R.drawable.ic_003_shopping_bag_2);
        GridViewMenu mainRedemptionPDAM = new GridViewMenu("PDAM" , R.drawable.ic_006_coding);
        GridViewMenu mainRedemptionVoucher = new GridViewMenu("Voucher", R.drawable.ic_007_analytics_1);
        GridViewMenu mainRedemptionEVoucher = new GridViewMenu("e-Voucher", R.drawable.ic_013_purse);
        GridViewMenu mainRedemptionKuliner = new GridViewMenu("Kuliner", R.drawable.ic_015_gift_1);
        GridViewMenu mainRedemptionElektronik = new GridViewMenu("Elektronik", R.drawable.ic_014_buy_1);
        GridViewMenu mainRedemptionGames = new GridViewMenu("Games", R.drawable.ic_001_pin);
        GridViewMenu mainRedemptionCicilan = new GridViewMenu("Cicilan", R.drawable.ic_005_shirt);

        GridViewMenu[] gridViewMenus = {mainRedemptionPulsa, mainRedemptionPaketData, mainRedemptionPLN, mainRedemptionTelepon,
                mainRedemptionBPJS, mainRedemptionPDAM, mainRedemptionVoucher, mainRedemptionEVoucher, mainRedemptionKuliner,
                mainRedemptionElektronik, mainRedemptionGames, mainRedemptionCicilan};
        return new GridViewMenuAdapter(getContext(), gridViewMenus);
    }

    public void setupMainMenu(LinearLayout mainLayout){
        ArrayList<CardViewMenu> cardViewMenuArrayList = new ArrayList<>();
        cardViewMenuArrayList.add(new CardViewMenu("Tukar Excite Point dengan Produk berikut :", "", this.setupGridViewMainMenu()));

        CardViewMenuAdapter adapter = new CardViewMenuAdapter(cardViewMenuArrayList, getActivity(), CARD_VIEW_STATIC_MODE,
                this);
        adapter.setColumnNum(4);

        RecyclerView recyclerView = mainLayout.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void setupPromo(LinearLayout RedeemLayout){
        pager = RedeemLayout.findViewById(R.id.ViewPagerPromo);

        int[] imagesArray = {R.drawable.banner_creative_kids,R.drawable.banner_instant,R.drawable.banner_material_android_hive,R.drawable.download_app,R.drawable.photo_promo};

        adapter = new PromoAdapter(getActivity(), getChildFragmentManager(), imagesArray);
        pager.setAdapter(adapter);
        pager.setPageTransformer(false, adapter);

        // Set current item to the middle page so we can fling to both
        // directions left and right
        pager.setCurrentItem(FIRST_PAGE);

        // Necessary or the pager will only have one extra page to show
        // make this at least however many pages you can see
        pager.setOffscreenPageLimit(3);

        // Set margin for pages as a negative number, so a part of next and
        // previous pages will be showed
        pager.setPageMargin(-450);

        final Handler handler = new Handler();


        final Runnable update = new Runnable() {
            public void run() {
                if (currentPage == PAGES) {
                    currentPage = 0;
                }
                pager.setCurrentItem(currentPage++, true);
            }
        };


        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 1000, 3000);
    }


    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.changeText:
//                editText.setText("Lalala");
//                break;
//            case R.id.switchActivity:
//                Intent intent = new Intent(getActivity(), SecondActivity.class);
//                intent.putExtra("input", editText.getText().toString());
//                startActivity(intent);
//                break;
//        }

    }

    @Override
    public void cardViewOnClick(AdapterView<?> adapterView, View view, int position, long l, int cardIndex) {
            Log.i("Menu clicked : ", String.valueOf(position));
            Intent intent = new Intent(getActivity(), RedeemDetailsHome.class);
            startActivity(intent);
    }

    @Override
    public void cardViewShowAllOnClick(CardViewMenuAdapter.MenuViewHolder holder, int position, View view) {

    }
}
