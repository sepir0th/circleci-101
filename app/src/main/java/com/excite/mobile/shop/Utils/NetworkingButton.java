package com.excite.mobile.shop.Utils;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.excite.mobile.shop.Activities.NoNetwork.NonetworkActivity;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by erwinlim on 09/03/18.
 * <p>
 * This class responsible to provide standard functions across all modules.</br>
 * some of the functions are :
 * - standard function to accomodate no network state.
 * </p>
 */

public class NetworkingButton extends android.support.v7.widget.AppCompatButton{
    private Context mContext;
    private NetworkingButtonListener networkingButtonListener;

    /**
     * this flag is used to give a default mechanism when there isnt any network connected to the device
     * the mechanism is to show a default error page when there is no internet.
     */
    private Boolean defaultNetworkError = true;

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

    /**
     * provide a setter to change default value of defaultNetworkError </br>
     * please check {@link NetworkingButton#defaultNetworkError} for better explanation
     *
     * @param defaultNetworkError is used to change the flag.
     */
    public void setDefaultNetworkError(Boolean defaultNetworkError){
        this.defaultNetworkError = defaultNetworkError;
    }

    /**
     * this function used to override the click functions to always the connection state before do next process.</br>
     * {@link NetworkingButton#defaultNetworkError} is a flag to avoid this default mechanism.
     *
     * @param l used to instantiate our listener to be used
     */
    public void setOnNetworkClickListener(@Nullable NetworkingButtonListener l){
        networkingButtonListener = l;
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isOnline()){
                    if(defaultNetworkError){
                        mContext.startActivity(new Intent(mContext, NonetworkActivity.class));
                    }else {
                        networkingButtonListener.onErrorResponse();
                    }
                }else{
                    networkingButtonListener.onClick(view);
                }
            }
        });
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
