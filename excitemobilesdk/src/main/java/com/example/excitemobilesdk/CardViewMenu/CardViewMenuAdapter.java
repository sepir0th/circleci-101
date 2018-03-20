package com.example.excitemobilesdk.CardViewMenu;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.excitemobilesdk.R;

import java.util.ArrayList;

import static com.example.excitemobilesdk.Utils.AppConstants.CARD_VIEW_STATIC_MODE;
import static com.example.excitemobilesdk.Utils.AppConstants.GRID_MODE_CARD;

/**
 * Created by erwinlim on 23/02/18.
 */

public class CardViewMenuAdapter extends RecyclerView.Adapter<CardViewMenuAdapter.MenuViewHolder> {

    private ArrayList<CardViewMenu> dataList;
    private Context mContext;
    private Integer cardMode;
    private Integer columnNum = 3;  //default value 3, to avoid any crash if not being set
    private CardViewMenuListener cardViewMenuListener;

    public CardViewMenuAdapter(ArrayList<CardViewMenu> dataList, Context mContext, Integer CardMode,
                               CardViewMenuListener cardViewMenuListener) {
        this.dataList = dataList;
        this.mContext = mContext;
        this.cardMode = CardMode;
        this.cardViewMenuListener = cardViewMenuListener;
    }

    public void setColumnNum(Integer columnNum){
        this.columnNum = columnNum;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_cardviewmenu, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MenuViewHolder holder, final int position) {
        holder.txtEmpName.setText(dataList.get(position).getEmployeeName());
        holder.txtEmpEmail.setText(dataList.get(position).getEmployeeEmail());
        holder.gridViewMenu.setAdapter(dataList.get(position).getGridViewMenu());
        holder.intCardIndex = position;

        int size = columnNum;
        if(dataList.get(position).getColumnNum() != 0){
            holder.gridViewMenu.setNumColumns(dataList.get(position).getColumnNum());
            size = dataList.get(position).getColumnNum();
        }else{
            holder.gridViewMenu.setNumColumns(columnNum);
        }

        // Calculated single Item Layout Width for each grid element ....
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity)mContext).getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        float width = 95;
        int totalWidth = (int) (width * size * density);
        if(cardMode == GRID_MODE_CARD){
            width = dm.widthPixels / columnNum;
            totalWidth = (int) (width * size - 100);
        }

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(totalWidth, LinearLayout.LayoutParams.MATCH_PARENT);
        holder.gridViewMenu.setLayoutParams(params);

        holder.btnListAllMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardViewMenuListener.cardViewShowAllOnClick(holder, position, view);
            }
        });

        if(holder.txtEmpEmail.getText() == ""){
            holder.txtEmpEmail.setVisibility(View.GONE);
        }
        if(holder.txtEmpName.getText() == ""){
            holder.txtEmpName.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        TextView txtEmpName, txtEmpEmail;
        GridView gridViewMenu;
        Button btnListAllMenu;
        int intCardIndex = 0;

        MenuViewHolder(View itemView) {
            super(itemView);

            txtEmpName = itemView.findViewById(R.id.txt_employee_name);
            txtEmpEmail = itemView.findViewById(R.id.txt_employee_email);
            gridViewMenu = itemView.findViewById(R.id.GridViewMenu);
            gridViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    cardViewMenuListener.cardViewOnClick(adapterView, view, position, l, intCardIndex);

                }
            });
            btnListAllMenu = itemView.findViewById(R.id.btn_listAllMenu);
            if(cardMode == CARD_VIEW_STATIC_MODE || cardMode == GRID_MODE_CARD){
                btnListAllMenu.setVisibility(View.GONE);
                if(cardMode == CARD_VIEW_STATIC_MODE){
                    txtEmpName.setGravity(Gravity.CENTER_HORIZONTAL);
                }
            }
        }
    }
}
