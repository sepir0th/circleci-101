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

public class SubHeaderMenuAdapter extends BaseAdapter {

    private final Context mContext;
    private final GridViewMenu[] gridViewMenus;

    // 1
    public SubHeaderMenuAdapter(Context context, GridViewMenu[] gridViewMenus) {
        this.mContext = context;
        this.gridViewMenus = gridViewMenus;
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
            convertView = layoutInflater.inflate(R.layout.linearlayout_subheadermenu, null);
        }

        final TextView productName = convertView.findViewById(R.id.textview_book_name);
        final ImageView productImg = convertView.findViewById(R.id.imageview_cover_art);

        productName.setText(gridViewMenu.getMenuTitle());
        productImg.setImageResource(gridViewMenu.getImageResource());

        return convertView;
    }
}
