package com.example.excitemobilesdk.CustomGridView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.excitemobilesdk.R;

/**
 * Created by erwinlim on 13/02/18.
 */

public class GridViewMenuAdapter extends BaseAdapter {

    private final Context mContext;
    private final GridViewMenu[] gridViewMenus;
    private int imageHeight = 0;
    private int imageWidth = 0;

    // 1
    public GridViewMenuAdapter(Context context, GridViewMenu[] gridViewMenus) {
        this.mContext = context;
        this.gridViewMenus = gridViewMenus;
    }

    public GridViewMenuAdapter(Context context, GridViewMenu[] gridViewMenus, int imageHeight, int imageWidth) {
        this.mContext = context;
        this.gridViewMenus = gridViewMenus;
        this.imageHeight = imageHeight;
        this.imageWidth = imageWidth;
    }

    @Override
    public int getCount() {
        return gridViewMenus.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // 1
        final GridViewMenu gridViewMenu = gridViewMenus[position];

        // 2
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.linearlayout_gridviewmenu, null);
        }

        final TextView menuTitle = convertView.findViewById(R.id.txt_gridviewmenu_title);
        final TextView menuSubTitle = convertView.findViewById(R.id.txt_gridviewmenu_subtitle);
        final ImageView menuImg = convertView.findViewById(R.id.imageview_cover_art);

        menuTitle.setText(gridViewMenu.getMenuTitle());
        menuSubTitle.setText(gridViewMenu.getMenuSubitle());
        menuImg.setImageResource(gridViewMenu.getImageResource());
        if(imageHeight != 0 && imageWidth != 0) {
            menuImg.getLayoutParams().width = imageWidth;
            menuImg.getLayoutParams().height = imageHeight;
        }
        menuImg.requestLayout();

        return convertView;
    }
}
