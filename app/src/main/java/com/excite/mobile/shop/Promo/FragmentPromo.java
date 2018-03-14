package com.excite.mobile.shop.Promo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.excite.mobile.shop.R;

public class FragmentPromo extends Fragment {

    public static Fragment newInstance(Context context, int pos, float scale, int image) {
        Bundle b = new Bundle();
        b.putInt("pos", pos);
        b.putFloat("scale", scale);
        b.putInt("image", image);
        return Fragment.instantiate(context, FragmentPromo.class.getName(), b);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        LinearLayout l = (LinearLayout)
                inflater.inflate(R.layout.content_promo, container, false);

        int pos = this.getArguments().getInt("pos");
        Button buttonImage = l.findViewById(R.id.content);
        Log.i("Position","Position = " + pos);

        buttonImage.setBackground(getResources().getDrawable(this.getArguments().getInt("image")));

        LinearLayoutPromo root = l.findViewById(R.id.root);
        float scale = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);

        return l;
    }
}
