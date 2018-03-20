package com.excite.mobile.shop.Activities.Home.EarnPointDetails.ExcitePartner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import com.example.excitemobilesdk.CardViewMenu.CardViewMenu;
import com.example.excitemobilesdk.CardViewMenu.CardViewMenuAdapter;
import com.example.excitemobilesdk.CardViewMenu.CardViewMenuListener;
import com.example.excitemobilesdk.CustomGridView.GridViewMenu;
import com.example.excitemobilesdk.CustomGridView.GridViewMenuAdapter;
import com.excite.mobile.shop.R;

import java.util.ArrayList;

import static com.example.excitemobilesdk.Utils.AppConstants.GRID_MODE_CARD;

public class ExcitePartnerList extends AppCompatActivity implements CardViewMenuListener {
    private RecyclerView recyclerView;
    private CardViewMenuAdapter adapter;
    private ArrayList<CardViewMenu> cardViewMenuArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excite_partner_list);
        GridViewMenu mainRedemptionPulsa = new GridViewMenu("", R.drawable.banner_creative_kids);
        GridViewMenu mainRedemptionPaketData = new GridViewMenu(" ", R.drawable.banner_instant);
        GridViewMenu mainRedemptionPLN = new GridViewMenu("", R.drawable.banner_material_android_hive);

        GridViewMenu[] gridViewMenus = {mainRedemptionPulsa, mainRedemptionPaketData, mainRedemptionPLN};
        GridViewMenuAdapter gridViewMenuAdapter = new GridViewMenuAdapter(this, gridViewMenus, 450, 1000);

        cardViewMenuArrayList = new ArrayList<>();
        cardViewMenuArrayList.add(new CardViewMenu("", "", gridViewMenuAdapter));

        adapter = new CardViewMenuAdapter(cardViewMenuArrayList, this, GRID_MODE_CARD, this);
        adapter.setColumnNum(1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void cardViewOnClick(AdapterView<?> adapterView, View view, int gridItemPosition, long l, int cardIndex) {

    }

    @Override
    public void cardViewShowAllOnClick(CardViewMenuAdapter.MenuViewHolder holder, int position, View view) {

    }
}
