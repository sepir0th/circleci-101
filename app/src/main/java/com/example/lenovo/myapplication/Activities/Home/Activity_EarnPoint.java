package com.example.lenovo.myapplication.Activities.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.example.lenovo.myapplication.Activities.EarnPointDetails.ListEarnPointsMenu;
import com.example.lenovo.myapplication.Activities.ExcitePartner.ExcitePartnerList;
import com.example.lenovo.myapplication.Activities.ExcitePartner.ExcitePartnerMaster;
import com.example.lenovo.myapplication.Activities.MerchantDetails.MerchantDetails;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.Utils.AppConstants;

import java.util.ArrayList;

import static com.example.excitemobilesdk.Utils.AppConstants.CARD_VIEW_LIST_MODE;


/**
 * Created by erwinlim on 12/02/18.
 */

public class Activity_EarnPoint extends Fragment implements View.OnClickListener, CardViewMenuListener {

    private RecyclerView recyclerView;
    private CardViewMenuAdapter adapter;
    private ArrayList<CardViewMenu> cardViewMenuArrayList;
    private ArrayList<GridViewMenu> gridViewMenus_onlineShop;
    private ArrayList<GridViewMenu> gridViewMenus_bonusPoint;

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

        GridViewMenu mainRedemptionPulsa = new GridViewMenu("Kupon & Voucher", R.drawable.ic_054_smartphone_1);
        GridViewMenu mainRedemptionPaketData = new GridViewMenu("Fashion", R.drawable.ic_012_browser_1);
        GridViewMenu mainRedemptionPLN = new GridViewMenu("Gadget", R.drawable.ic_009_startup);
        GridViewMenu mainRedemptionTelepon = new GridViewMenu("Elektronik", R.drawable.ic_002_credit_card_6);
        GridViewMenu mainRedemptionBPJS = new GridViewMenu("Tiket & Hotel", R.drawable.ic_003_shopping_bag_2);
        GridViewMenu mainRedemptionPDAM = new GridViewMenu("Otomotif", R.drawable.ic_006_coding);
        GridViewMenu mainRedemptionVoucher = new GridViewMenu("Isi Ulang", R.drawable.ic_007_analytics_1);
        GridViewMenu mainRedemptionEVoucher = new GridViewMenu("Tagihan", R.drawable.ic_013_purse);

        GridViewMenu mainRedemptionKuliner = new GridViewMenu("Daftar", R.drawable.ic_015_gift_1);
        GridViewMenu mainRedemptionElektronik = new GridViewMenu("Survey", R.drawable.ic_014_buy_1);
        GridViewMenu mainRedemptionGames = new GridViewMenu("Review", R.drawable.ic_001_pin);
        GridViewMenu mainRedemptionCicilan = new GridViewMenu("Download", R.drawable.ic_005_shirt);

        GridViewMenu mainRedemptionStarbuck = new GridViewMenu("Starbuck", R.drawable.starbucks_logo);
        GridViewMenu mainRedemptionKillney = new GridViewMenu("Killney", R.drawable.starbucks_logo);
        GridViewMenu mainRedemptionIndomaret = new GridViewMenu("Lawson", R.drawable.starbucks_logo);
        GridViewMenu mainRedemptionAlfamart = new GridViewMenu("Indomaret", R.drawable.starbucks_logo);
        GridViewMenu mainRedemptionLawson = new GridViewMenu("Alfamart", R.drawable.starbucks_logo);
        GridViewMenu mainRedemptionKelontong = new GridViewMenu("Lawson", R.drawable.starbucks_logo);
        GridViewMenu mainRedemptionPonta = new GridViewMenu("Kopi Tiam", R.drawable.starbucks_logo);
        GridViewMenu mainRedemptionOvo = new GridViewMenu("Anomali", R.drawable.starbucks_logo);

        GridViewMenu[] gridViewMenus = {mainRedemptionStarbuck, mainRedemptionKillney, mainRedemptionIndomaret, mainRedemptionAlfamart,
                mainRedemptionLawson, mainRedemptionKelontong, mainRedemptionPonta, mainRedemptionOvo};
        GridViewMenuAdapter gridViewMenuAdapter = new GridViewMenuAdapter(getContext(), gridViewMenus, 300,300);

        GridViewMenu[] gridViewMenus_onlineShop = {mainRedemptionPulsa, mainRedemptionPaketData, mainRedemptionPLN, mainRedemptionTelepon,
                mainRedemptionBPJS, mainRedemptionPDAM, mainRedemptionVoucher, mainRedemptionEVoucher};
        GridViewMenuAdapter gridViewMenuAdapter_onlineShop = new GridViewMenuAdapter(getContext(), gridViewMenus_onlineShop);

        //this is intended to pass the variable to the other activities
        this.gridViewMenus_onlineShop = new ArrayList<>();
        this.gridViewMenus_onlineShop.add(mainRedemptionPulsa);
        this.gridViewMenus_onlineShop.add(mainRedemptionPaketData);
        this.gridViewMenus_onlineShop.add(mainRedemptionPLN);
        this.gridViewMenus_onlineShop.add(mainRedemptionTelepon);
        this.gridViewMenus_onlineShop.add(mainRedemptionBPJS);
        this.gridViewMenus_onlineShop.add(mainRedemptionPDAM);
        this.gridViewMenus_onlineShop.add(mainRedemptionVoucher);
        this.gridViewMenus_onlineShop.add(mainRedemptionEVoucher);

        //this is intended to pass the variable to the other activities
        this.gridViewMenus_bonusPoint = new ArrayList<>();
        this.gridViewMenus_bonusPoint.add(mainRedemptionKuliner);
        this.gridViewMenus_bonusPoint.add(mainRedemptionElektronik);
        this.gridViewMenus_bonusPoint.add(mainRedemptionGames);
        this.gridViewMenus_bonusPoint.add(mainRedemptionCicilan);


        GridViewMenu[] gridViewMenus_BonusPoint = {mainRedemptionKuliner, mainRedemptionElektronik, mainRedemptionGames, mainRedemptionCicilan};
        GridViewMenuAdapter gridViewMenuAdapter_BonusPoint = new GridViewMenuAdapter(getContext(), gridViewMenus_BonusPoint);

        cardViewMenuArrayList = new ArrayList<>();
        cardViewMenuArrayList.add(new CardViewMenu("Belanja Online", "Dapatkan Cashback point dengan belanja online", gridViewMenuAdapter_onlineShop, 4));
        cardViewMenuArrayList.add(new CardViewMenu("Bonus Point", "Dapatkan bonus point dengan melakukan aksi gratis", gridViewMenuAdapter_BonusPoint));
        cardViewMenuArrayList.add(new CardViewMenu("Stamp Program", "Koleksi stamp dengan mengunjungi merchant favorit", gridViewMenuAdapter));
        cardViewMenuArrayList.add(new CardViewMenu("Belanja di Merchant", "Dapatkan Point dari setiap transaksi di merchant favorite", gridViewMenuAdapter));
        cardViewMenuArrayList.add(new CardViewMenu("Partner Excite", "Dapatkan point dari partner Excite", gridViewMenuAdapter));

        adapter = new CardViewMenuAdapter(cardViewMenuArrayList, getActivity(), CARD_VIEW_LIST_MODE, this);
        adapter.setColumnNum(12);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView = earnPointLayout.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return earnPointLayout;
    }


    public void onClick(View view) {

    }

    @Override
    public void cardViewOnClick(AdapterView<?> adapterView, View view, int position, long l, int cardIndex) {
        if(cardIndex == 0) {
            Intent excitePartnerMaster = new Intent(getActivity(), ListEarnPointsMenu.class);
            excitePartnerMaster.putParcelableArrayListExtra(AppConstants.TAB_TITLE, gridViewMenus_onlineShop);
            excitePartnerMaster.putExtra(AppConstants.TAB_CURRENT_INDEX, position);
            startActivity(excitePartnerMaster);
        }else if(cardIndex == 1){
            Intent excitePartnerMaster = new Intent(getActivity(), ListEarnPointsMenu.class);
            excitePartnerMaster.putParcelableArrayListExtra(AppConstants.TAB_TITLE, gridViewMenus_bonusPoint);
            excitePartnerMaster.putExtra(AppConstants.TAB_CURRENT_INDEX, position);
            startActivity(excitePartnerMaster);
        }else if(cardIndex == 4){
            Intent excitePartnerMaster = new Intent(getActivity(), ExcitePartnerMaster.class);
            startActivity(excitePartnerMaster);
        }else{
            Intent intent = new Intent(getActivity(), MerchantDetails.class);
            startActivity(intent);
        }
    }

    @Override
    public void cardViewShowAllOnClick(CardViewMenuAdapter.MenuViewHolder holder, int position, View view) {
        if(position != 4) {
            Intent excitePartnerMaster = new Intent(getActivity(), ListEarnPointsMenu.class);
            startActivity(excitePartnerMaster);
        }else{
            Intent excitePartnerList = new Intent(getActivity(), ExcitePartnerList.class);
            startActivity(excitePartnerList);
        }
    }
}
