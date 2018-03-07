package com.example.lenovo.myapplication.Activities.RedeemPointsDetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.excitemobilesdk.CardViewMenu.CardViewMenu;
import com.example.excitemobilesdk.CardViewMenu.CardViewMenuAdapter;
import com.example.excitemobilesdk.CardViewMenu.CardViewMenuListener;
import com.example.excitemobilesdk.CustomGridView.GridViewMenu;
import com.example.excitemobilesdk.CustomGridView.GridViewMenuAdapter;
import com.example.lenovo.myapplication.Activities.MerchantDetails.MerchantDetails;
import com.example.lenovo.myapplication.R;

import java.util.ArrayList;

import static com.example.excitemobilesdk.Utils.AppConstants.CARD_VIEW_LIST_MODE;
import static com.example.excitemobilesdk.Utils.AppConstants.CARD_VIEW_STATIC_MODE;
import static com.example.excitemobilesdk.Utils.AppConstants.GRID_MODE_CARD;

/**
 * Created by erwinlim on 05/03/18.
 */

public class RedeemDetailsFragment extends Fragment implements CardViewMenuListener {

    private RecyclerView recyclerView;
    private CardViewMenuAdapter adapter;
    private ArrayList<CardViewMenu> cardViewMenuArrayList;

    public RedeemDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        LinearLayout LayoutRedeemPulsa = (LinearLayout) inflater.inflate(R.layout.fragment_redeem_points_pulsa, container, false);
        GridViewMenu mainRedemptionPulsa = new GridViewMenu("Pulsa", R.drawable.banner_creative_kids);
        mainRedemptionPulsa.setMenuSubitle("ini pulsa");
        GridViewMenu mainRedemptionPaketData = new GridViewMenu("Paket Data", R.drawable.banner_instant);
        mainRedemptionPaketData.setMenuSubitle("ini pulsa");
        GridViewMenu mainRedemptionPLN = new GridViewMenu("PLN", R.drawable.banner_material_android_hive);
        mainRedemptionPLN.setMenuSubitle("ini pulsa");
        GridViewMenu mainRedemptionTelepon = new GridViewMenu("Telepon", R.drawable.ic_002_credit_card_6);
        mainRedemptionTelepon.setMenuSubitle("ini pulsa");
        GridViewMenu mainRedemptionBPJS = new GridViewMenu("BPJS", R.drawable.ic_003_shopping_bag_2);
        mainRedemptionBPJS.setMenuSubitle("ini pulsa");
        GridViewMenu mainRedemptionPDAM = new GridViewMenu("PDAM", R.drawable.ic_006_coding);
        mainRedemptionPDAM.setMenuSubitle("ini pulsa");
        GridViewMenu mainRedemptionVoucher = new GridViewMenu("Voucher", R.drawable.ic_007_analytics_1);
        mainRedemptionVoucher.setMenuSubitle("ini pulsa");
        GridViewMenu mainRedemptionEVoucher = new GridViewMenu("e-Voucher", R.drawable.ic_013_purse);
        mainRedemptionEVoucher.setMenuSubitle("ini pulsa");
        GridViewMenu mainRedemptionKuliner = new GridViewMenu("Kuliner", R.drawable.ic_015_gift_1);
        mainRedemptionKuliner.setMenuSubitle("ini pulsa");
        GridViewMenu mainRedemptionElektronik = new GridViewMenu("Elektronik", R.drawable.ic_014_buy_1);
        mainRedemptionElektronik.setMenuSubitle("ini pulsa");
        GridViewMenu mainRedemptionGames = new GridViewMenu("Games", R.drawable.ic_001_pin);
        mainRedemptionGames.setMenuSubitle("ini pulsa");
        GridViewMenu mainRedemptionCicilan = new GridViewMenu("Cicilan", R.drawable.ic_005_shirt);
        mainRedemptionCicilan.setMenuSubitle("ini pulsa");
        GridViewMenu mainRedemptionVoucher2 = new GridViewMenu("Voucher", R.drawable.ic_007_analytics_1);
        mainRedemptionVoucher2.setMenuSubitle("ini pulsa");
        GridViewMenu mainRedemptionEVoucher2 = new GridViewMenu("e-Voucher", R.drawable.ic_013_purse);
        mainRedemptionEVoucher2.setMenuSubitle("ini pulsa");
        GridViewMenu mainRedemptionKuliner2 = new GridViewMenu("Kuliner", R.drawable.ic_015_gift_1);
        mainRedemptionKuliner2.setMenuSubitle("ini pulsa");
        GridViewMenu mainRedemptionElektronik2 = new GridViewMenu("Elektronik", R.drawable.ic_014_buy_1);
        mainRedemptionElektronik2.setMenuSubitle("ini pulsa");
        GridViewMenu mainRedemptionGames2 = new GridViewMenu("Games", R.drawable.ic_001_pin);
        mainRedemptionGames2.setMenuSubitle("ini pulsa");
        GridViewMenu mainRedemptionCicilan2 = new GridViewMenu("Cicilan", R.drawable.ic_005_shirt);
        mainRedemptionCicilan2.setMenuSubitle("ini pulsa");

        GridViewMenu[] gridViewMenus = {mainRedemptionPulsa, mainRedemptionPaketData, mainRedemptionPLN, mainRedemptionTelepon,
                mainRedemptionBPJS, mainRedemptionPDAM, mainRedemptionVoucher, mainRedemptionEVoucher, mainRedemptionKuliner,
                mainRedemptionElektronik, mainRedemptionGames, mainRedemptionCicilan, mainRedemptionVoucher2, mainRedemptionEVoucher2,
                mainRedemptionKuliner2, mainRedemptionElektronik2, mainRedemptionGames2, mainRedemptionCicilan2};
        GridViewMenuAdapter gridViewMenuAdapter = new GridViewMenuAdapter(getContext(), gridViewMenus, 500, 500);

        cardViewMenuArrayList = new ArrayList<>();
        cardViewMenuArrayList.add(new CardViewMenu("", "", gridViewMenuAdapter));

        adapter = new CardViewMenuAdapter(cardViewMenuArrayList, getActivity(), GRID_MODE_CARD, this);
        adapter.setColumnNum(2);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView = LayoutRedeemPulsa.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return LayoutRedeemPulsa;
    }

    @Override
    public void cardViewOnClick(AdapterView<?> adapterView, View view, int position, long l, int cardIndex) {

    }

    @Override
    public void cardViewShowAllOnClick(CardViewMenuAdapter.MenuViewHolder holder, int position, View view) {

    }
}
