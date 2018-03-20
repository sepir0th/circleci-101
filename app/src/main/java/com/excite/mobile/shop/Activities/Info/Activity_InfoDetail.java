package com.excite.mobile.shop.Activities.Info;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.excite.mobile.shop.Activities.MainActivity;
import com.excite.mobile.shop.Activities.Profile.ProfileActivity;
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


        Button btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_InfoDetail.this, MainActivity.class);
                intent.putExtra("MainActivity_SelectedTab", 1);
                startActivity(intent);
                finish();
            }
        });
    }

}
