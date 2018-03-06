package com.example.lenovo.myapplication.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.excitemobilesdk.CardViewMenu.CardViewMenu;
import com.example.excitemobilesdk.CardViewMenu.CardViewMenuAdapter;
import com.example.excitemobilesdk.CardViewMenu.CardViewMenuListener;
import com.example.excitemobilesdk.CustomGridView.GridViewMenu;
import com.example.excitemobilesdk.CustomGridView.GridViewMenuAdapter;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.Utils.AppConstants;

import java.util.ArrayList;

import static com.example.excitemobilesdk.Utils.AppConstants.CARD_VIEW_LIST_MODE;


/**
 * Created by erwinlim on 12/02/18.
 */

public class TwoFragment extends Fragment implements View.OnClickListener, CardViewMenuListener {

    EditText editText;
    Button chgButton;
    Button switchButton;

    private RecyclerView recyclerView;
    private CardViewMenuAdapter adapter;
    private ArrayList<CardViewMenu> cardViewMenuArrayList;

    public TwoFragment() {
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
        RelativeLayout mainLayout = (RelativeLayout )inflater.inflate(R.layout.fragment_two, container, false);
        editText = mainLayout.findViewById(R.id.inputFieldTwo);
        chgButton = mainLayout.findViewById(R.id.changeTextTwo);
        chgButton.setOnClickListener(this);
        switchButton = mainLayout.findViewById(R.id.switchActivityTwo);
        switchButton.setOnClickListener(this);

        GridViewMenu mainRedemptionPulsa = new GridViewMenu("Pulsa",1,R.drawable.ic_054_smartphone_1,"0");
        GridViewMenu mainRedemptionPaketData = new GridViewMenu("Paket Data",1,R.drawable.ic_012_browser_1,"0");
        GridViewMenu mainRedemptionPLN = new GridViewMenu("PLN",1,R.drawable.ic_009_startup,"0");
        GridViewMenu mainRedemptionTelepon = new GridViewMenu("Telepon",1,R.drawable.ic_002_credit_card_6,"0");
        GridViewMenu mainRedemptionBPJS = new GridViewMenu("BPJS",1,R.drawable.ic_003_shopping_bag_2,"0");
        GridViewMenu mainRedemptionPDAM = new GridViewMenu("PDAM",1,R.drawable.ic_006_coding,"0");
        GridViewMenu mainRedemptionVoucher = new GridViewMenu("Voucher",1,R.drawable.ic_007_analytics_1,"0");
        GridViewMenu mainRedemptionEVoucher = new GridViewMenu("e-Voucher",1,R.drawable.ic_013_purse,"0");
        GridViewMenu mainRedemptionKuliner = new GridViewMenu("Kuliner",1,R.drawable.ic_015_gift_1,"0");
        GridViewMenu mainRedemptionElektronik = new GridViewMenu("Elektronik",1,R.drawable.ic_014_buy_1,"0");
        GridViewMenu mainRedemptionGames = new GridViewMenu("Games",1,R.drawable.ic_001_pin,"0");
        GridViewMenu mainRedemptionCicilan = new GridViewMenu("Cicilan",1,R.drawable.ic_005_shirt,"0");

        GridViewMenu[] gridViewMenus = {mainRedemptionPulsa, mainRedemptionPaketData, mainRedemptionPLN, mainRedemptionTelepon,
                mainRedemptionBPJS, mainRedemptionPDAM, mainRedemptionVoucher, mainRedemptionEVoucher, mainRedemptionKuliner,
                mainRedemptionElektronik, mainRedemptionGames, mainRedemptionCicilan};
        GridViewMenuAdapter gridViewMenuAdapter = new GridViewMenuAdapter(getContext(), gridViewMenus);


        cardViewMenuArrayList = new ArrayList<>();
        cardViewMenuArrayList.add(new CardViewMenu("Belanja Online", "Dapatkan Cashback point dengan belanja online", gridViewMenuAdapter));
        cardViewMenuArrayList.add(new CardViewMenu("Bonus Point", "Dapatkan bonus point dengan melakukan aksi gratis", gridViewMenuAdapter));
        cardViewMenuArrayList.add(new CardViewMenu("Stamp Program", "Koleksi stamp dengan mengunjungi merchant favorit", gridViewMenuAdapter));
        cardViewMenuArrayList.add(new CardViewMenu("Belanja di Merchant", "Dapatkan Point dari setiap transaksi di merchant favorite", gridViewMenuAdapter));
        cardViewMenuArrayList.add(new CardViewMenu("Partner Excite", "Dapatkan point dari partner Excite", gridViewMenuAdapter));

        adapter = new CardViewMenuAdapter(cardViewMenuArrayList, getActivity(), CARD_VIEW_LIST_MODE, this);
        adapter.setColumnNum(3);
        recyclerView = (RecyclerView) mainLayout.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return mainLayout;
    }

    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.changeTextTwo:
//                editText.setText("Lalala");
//                break;
//            case R.id.switchActivityTwo:
//                Intent intent = new Intent(getActivity(), SecondActivity.class);
//                intent.putExtra("input", editText.getText().toString());
//                startActivity(intent);
//                break;
//        }

    }

    @Override
    public void cardViewOnClick(AdapterView<?> adapterView, View view, int position, long l) {

    }

    @Override
    public void cardViewShowAllOnClick(CardViewMenuAdapter.MenuViewHolder holder, int position, View view) {

    }
}
