package com.excite.mobile.shop.Activities.Info;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.excite.mobile.shop.R;
import com.excite.mobile.shop.Utils.AppConstants;

public class Activity_InfoDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__info_detail);

        String strNotificationID = getIntent().getStringExtra(AppConstants.NOTIFICATION_ID);

        TextView txtInfoSummary = findViewById(R.id.txt_InfoDetail);
        txtInfoSummary.setText(strNotificationID);
    }

}
