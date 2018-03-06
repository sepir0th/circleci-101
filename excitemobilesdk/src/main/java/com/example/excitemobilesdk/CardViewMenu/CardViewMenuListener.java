package com.example.excitemobilesdk.CardViewMenu;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by erwinlim on 05/03/18.
 */

public interface CardViewMenuListener {
    public void cardViewOnClick(AdapterView<?> adapterView, View view, int position, long l);
    public void cardViewShowAllOnClick(CardViewMenuAdapter.MenuViewHolder holder, final int position, View view);
}
