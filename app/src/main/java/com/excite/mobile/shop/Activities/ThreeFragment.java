package com.excite.mobile.shop.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.excite.mobile.shop.R;


/**
 * Created by erwinlim on 12/02/18.
 */

public class ThreeFragment extends Fragment{
    public ThreeFragment() {
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
        RelativeLayout LayoutEarnPoint = (RelativeLayout) inflater.inflate(R.layout.fragment_three, container, false);

        WebView myWebView = (WebView) LayoutEarnPoint.findViewById(R.id.webview);
        myWebView.loadUrl("https://shop.excite.co.id/legals/howitworks/");

        return LayoutEarnPoint;
    }
}
