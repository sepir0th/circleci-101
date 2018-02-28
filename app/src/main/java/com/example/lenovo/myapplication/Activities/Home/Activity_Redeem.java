package com.example.lenovo.myapplication.Activities.Home;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.lenovo.myapplication.CustomGridview.Book;
import com.example.lenovo.myapplication.CustomGridview.BooksAdapter;
import com.example.lenovo.myapplication.CustomGridview.SubHeaderMenuAdapter;
import com.example.lenovo.myapplication.Promo.MyPagerAdapter;
import com.example.lenovo.myapplication.R;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by erwinlim on 12/02/18.
 */

public class Activity_Redeem extends Fragment implements View.OnClickListener{

    /*
     * our parameters to set Promo functions
     */
    public final static int PAGES = 5;
    // You can choose a bigger number for LOOPS, but you know, nobody will fling
    // more than 1000 times just in order to test your "infinite" ViewPager :D
    public final static int LOOPS = 1;
    public final static int FIRST_PAGE = PAGES * LOOPS / 2;

    public MyPagerAdapter adapter;
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
//
        Book mainRedemptionPulsa = new Book("Pulsa",1,R.drawable.ic_054_smartphone_1,"0");
        Book mainRedemptionPaketData = new Book("Paket Data",1,R.drawable.ic_012_browser_1,"0");
        Book mainRedemptionPLN = new Book("PLN",1,R.drawable.ic_009_startup,"0");
        Book mainRedemptionTelepon = new Book("Telepon",1,R.drawable.ic_002_credit_card_6,"0");
        Book mainRedemptionBPJS = new Book("BPJS",1,R.drawable.ic_003_shopping_bag_2,"0");
        Book mainRedemptionPDAM = new Book("PDAM",1,R.drawable.ic_006_coding,"0");
        Book mainRedemptionVoucher = new Book("Voucher",1,R.drawable.ic_007_analytics_1,"0");
        Book mainRedemptionEVoucher = new Book("e-Voucher",1,R.drawable.ic_013_purse,"0");
        Book mainRedemptionKuliner = new Book("Kuliner",1,R.drawable.ic_015_gift_1,"0");
        Book mainRedemptionElektronik = new Book("Elektronik",1,R.drawable.ic_014_buy_1,"0");
        Book mainRedemptionGames = new Book("Games",1,R.drawable.ic_001_pin,"0");
        Book mainRedemptionCicilan = new Book("Cicilan",1,R.drawable.ic_005_shirt,"0");

        Book subHeaderGridMenuScanTrans = new Book("Scan Transaksi",1,R.drawable.ic_011_gift_2,"0");
        Book subHeaderGridMenuStamp = new Book("Stamp Program",1,R.drawable.ic_012_browser_1,"0");
        Book subHeaderGridMenuScanQR = new Book("Scan QR To Pay",1,R.drawable.ic_054_smartphone_1,"0");

        setupPromo(mainLayout);

        Book[] books = {mainRedemptionPulsa, mainRedemptionPaketData, mainRedemptionPLN, mainRedemptionTelepon,
                mainRedemptionBPJS, mainRedemptionPDAM, mainRedemptionVoucher, mainRedemptionEVoucher, mainRedemptionKuliner,
                mainRedemptionElektronik, mainRedemptionGames, mainRedemptionCicilan};
        Book[] subHeaderGridMenuItems = {subHeaderGridMenuScanTrans, subHeaderGridMenuStamp, subHeaderGridMenuScanQR};

        GridView gridView = mainLayout.findViewById(R.id.gridview);
        BooksAdapter booksAdapter = new BooksAdapter(getContext(), books);
        gridView.setAdapter(booksAdapter);

        GridView subHeaderGridMenu = mainLayout.findViewById(R.id.SubHeaderGridMenu);
        SubHeaderMenuAdapter subHeaderGridMenuAdapter = new SubHeaderMenuAdapter(getContext(), subHeaderGridMenuItems);
        subHeaderGridMenu.setAdapter(subHeaderGridMenuAdapter);
        subHeaderGridMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.i("Menu clicked : ", String.valueOf(position));
                if(position == 3){

                }
            }
        });

        return mainLayout;
    }

    public void setupPromo(LinearLayout RedeemLayout){
        pager = RedeemLayout.findViewById(R.id.myviewpager);

        int[] imagesArray = {R.drawable.banner_creative_kids,R.drawable.banner_instant,R.drawable.banner_material_android_hive,R.drawable.download_app,R.drawable.photo_promo};

        adapter = new MyPagerAdapter(getActivity(), getChildFragmentManager(), imagesArray);
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
}
