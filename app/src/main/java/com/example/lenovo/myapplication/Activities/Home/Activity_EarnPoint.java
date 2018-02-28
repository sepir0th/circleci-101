package com.example.lenovo.myapplication.Activities.Home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.lenovo.myapplication.CustomGridview.Book;
import com.example.lenovo.myapplication.CustomGridview.BooksAdapter;
import com.example.lenovo.myapplication.CustomGridview.SubHeaderMenuAdapter;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.TestEmployee.Employee;
import com.example.lenovo.myapplication.TestEmployee.EmployeeAdapter;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.views.BannerSlider;


/**
 * Created by erwinlim on 12/02/18.
 */

public class Activity_EarnPoint extends Fragment implements View.OnClickListener{

    private RecyclerView recyclerView;
    private EmployeeAdapter adapter;
    private ArrayList<Employee> employeeArrayList;

    public Activity_EarnPoint() {
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
        LinearLayout earnPointLayout = (LinearLayout )inflater.inflate(R.layout.fragment_earnpoint, container, false);

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

        Book[] books = {mainRedemptionPulsa, mainRedemptionPaketData, mainRedemptionPLN, mainRedemptionTelepon,
                mainRedemptionBPJS, mainRedemptionPDAM, mainRedemptionVoucher, mainRedemptionEVoucher, mainRedemptionKuliner,
                mainRedemptionElektronik, mainRedemptionGames, mainRedemptionCicilan};
        BooksAdapter booksAdapter = new BooksAdapter(getContext(), books);

        employeeArrayList = new ArrayList<>();
        employeeArrayList.add(new Employee("Belanja Online", "Dapatkan Cashback point dengan belanja online", booksAdapter));
        employeeArrayList.add(new Employee("Bonus Point", "Dapatkan bonus point dengan melakukan aksi gratis", booksAdapter));
        employeeArrayList.add(new Employee("Stamp Program", "Koleksi stamp dengan mengunjungi merchant favorit", booksAdapter));
        employeeArrayList.add(new Employee("Belanja di Merchant", "Dapatkan Point dari setiap transaksi di merchant favorite", booksAdapter));
        employeeArrayList.add(new Employee("Partner Excite", "Dapatkan point dari partner Excite", booksAdapter));

        recyclerView = earnPointLayout.findViewById(R.id.recycler_view);

        adapter = new EmployeeAdapter(employeeArrayList, getActivity());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        return earnPointLayout;
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