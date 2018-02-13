package com.example.lenovo.myapplication.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.lenovo.myapplication.CustomGridview.Book;
import com.example.lenovo.myapplication.CustomGridview.BooksAdapter;
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
        editText = mainLayout.findViewById(R.id.inputField);
        chgButton = mainLayout.findViewById(R.id.changeText);
        chgButton.setOnClickListener(this);
        switchButton = mainLayout.findViewById(R.id.switchActivity);
        switchButton.setOnClickListener(this);

        Book goRide = new Book("GO-RIDE",1,R.drawable.ic_001_fan,"0");
        Book goCar = new Book("GO-CAR",1,R.drawable.ic_002_dancer_1,"0");
        Book goBlueBird = new Book("GO-BLUEBIRD",1,R.drawable.ic_003_man,"0");
        Book goFood = new Book("GO-FOOD",1,R.drawable.ic_007_theater_1,"0");
        Book goSend = new Book("GO-SPEED",1,R.drawable.ic_008_binoculars,"0");
        Book goPulsa = new Book("GO-PULSA",1,R.drawable.ic_010_painting,"0");
        Book goBills = new Book("GO-BILLS",1,R.drawable.ic_019_hat_1,"0");
        Book goShop = new Book("GO-SHOP",1,R.drawable.ic_022_mask,"0");
        Book goMart = new Book("GO-MART",1,R.drawable.ic_034_violin,"0");

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


        Book[] books = {goRide, goCar, goBlueBird, goFood, goSend, goPulsa, goBills, goShop};

        GridView gridView = mainLayout.findViewById(R.id.gridview);
        gridView.setNumColumns(4);
        BooksAdapter booksAdapter = new BooksAdapter(getContext(), books);
        gridView.setAdapter(booksAdapter);

        return mainLayout;
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.changeText:
                editText.setText("Lalala");
                break;
            case R.id.switchActivity:
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                intent.putExtra("input", editText.getText().toString());
                startActivity(intent);
                break;
        }

    }
}
