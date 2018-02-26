package com.example.lenovo.myapplication.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.lenovo.myapplication.CustomGridview.Book;
import com.example.lenovo.myapplication.CustomGridview.BooksAdapter;
import com.example.lenovo.myapplication.CustomGridview.SubHeaderMenuAdapter;
import com.example.lenovo.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;


/**
 * Created by erwinlim on 12/02/18.
 */

public class OneFragment extends Fragment implements View.OnClickListener{

    EditText editText;
    Button chgButton;
    Button switchButton;

    public OneFragment() {
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
        LinearLayout mainLayout = (LinearLayout )inflater.inflate(R.layout.fragment_one, container, false);
//        editText = mainLayout.findViewById(R.id.inputField);
//        chgButton = mainLayout.findViewById(R.id.changeText);
//        chgButton.setOnClickListener(this);
//        switchButton = mainLayout.findViewById(R.id.switchActivity);
//        switchButton.setOnClickListener(this);

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
        Book subHeaderGridMenuGetPoint = new Book("Bantuan",1,R.drawable.ic_054_smartphone_1,"0");

        BannerSlider bannerSlider = mainLayout.findViewById(R.id.banner_slider1);
        bannerSlider.setInterval(5000);
        bannerSlider.setLoopSlides(true);
        bannerSlider.setDefaultIndicator(1);
        bannerSlider.clearAnimation();
        List<Banner> banners=new ArrayList<>();
        //add banner using image url
        //banners.add(new RemoteBanner("Put banner image url here ..."));
        //add banner using resource drawable
        banners.add(new DrawableBanner(R.drawable.banner_creative_kids));
        banners.add(new DrawableBanner(R.drawable.banner_instant));
        banners.add(new DrawableBanner(R.drawable.banner_material_android_hive));
        bannerSlider.setBanners(banners);


        Book[] books = {mainRedemptionPulsa, mainRedemptionPaketData, mainRedemptionPLN, mainRedemptionTelepon,
                mainRedemptionBPJS, mainRedemptionPDAM, mainRedemptionVoucher, mainRedemptionEVoucher, mainRedemptionKuliner,
                mainRedemptionElektronik, mainRedemptionGames, mainRedemptionCicilan};
        Book[] subHeaderGridMenuItems = {subHeaderGridMenuScanTrans, subHeaderGridMenuStamp, subHeaderGridMenuScanQR,
                subHeaderGridMenuGetPoint};

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
