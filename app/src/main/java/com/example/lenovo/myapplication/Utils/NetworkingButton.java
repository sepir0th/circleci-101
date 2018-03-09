package com.example.lenovo.myapplication.Utils;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.myapplication.Activities.MainActivity;
import com.example.lenovo.myapplication.Activities.NoNetwork.NonetworkActivity;
import com.example.lenovo.myapplication.Registration.LoginActivity;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by erwinlim on 09/03/18.
 */

public class NetworkingButton extends android.support.v7.widget.AppCompatButton{
    private Context mContext;

    public NetworkingButton(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        this.mContext = context;
    }

    public NetworkingButton(Context context, AttributeSet attrs){
        super(context, attrs);
        this.mContext = context;
    }

    public NetworkingButton(Context context)
    {
        super(context);
        this.mContext = context;
    }

    public boolean isOnline() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) mContext
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            boolean connected = networkInfo != null && networkInfo.isAvailable() &&
                    networkInfo.isConnected();
            return connected;

        } catch (Exception e) {
            System.out.println("CheckConnectivity Exception: " + e.getMessage());
            Log.v("connectivity", e.toString());
        }
        return false;
    }

    public void setOnNetworkClickListener(@Nullable OnClickListener l){
        if(!isOnline()){
            mContext.startActivity(new Intent(mContext, NonetworkActivity.class));
        }else {
            setOnClickListener(l);
        }
    }

    public boolean isInternetAvailable() {
        try {
            final InetAddress address = InetAddress.getByName("www.google.com");
            return !address.equals("");
        } catch (UnknownHostException e) {
            // Log error
        }
        return false;
    }
}
