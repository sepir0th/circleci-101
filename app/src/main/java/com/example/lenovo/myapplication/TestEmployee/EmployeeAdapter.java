package com.example.lenovo.myapplication.TestEmployee;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.lenovo.myapplication.Activities.EarnPointDetails.ListEarnPointsMenu;
import com.example.lenovo.myapplication.Activities.ExcitePartner.ExcitePartnerMaster;
import com.example.lenovo.myapplication.R;

import java.util.ArrayList;

/**
 * Created by erwinlim on 23/02/18.
 */

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private ArrayList<Employee> dataList;
    private Context mContext;

    public EmployeeAdapter(ArrayList<Employee> dataList, Context mContext) {

        this.dataList = dataList;
        this.mContext = mContext;
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_employee, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, final int position) {
        holder.txtEmpName.setText(dataList.get(position).getEmployeeName());
        holder.txtEmpEmail.setText(dataList.get(position).getEmployeeEmail());
        holder.gridViewMenu.setAdapter(dataList.get(position).getGridViewMenu());
        holder.btnListAllMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("button earn point", "list all menu "+ position);
                Intent intentAllMenu = new Intent(mContext, ListEarnPointsMenu.class);
                mContext.startActivity(intentAllMenu);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView txtEmpName, txtEmpEmail;
        GridView gridViewMenu;
        Button btnListAllMenu;

        EmployeeViewHolder(View itemView) {
            super(itemView);
            txtEmpName = itemView.findViewById(R.id.txt_employee_name);
            txtEmpEmail = itemView.findViewById(R.id.txt_employee_email);
            gridViewMenu = itemView.findViewById(R.id.GridViewMenu);
            gridViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Log.i("Menu clicked : ", String.valueOf(position));
                    Intent excitePartnerMaster = new Intent(mContext, ExcitePartnerMaster.class);
                    mContext.startActivity(excitePartnerMaster);
                }
            });
            btnListAllMenu = itemView.findViewById(R.id.btn_listAllMenu);
        }
    }
}
