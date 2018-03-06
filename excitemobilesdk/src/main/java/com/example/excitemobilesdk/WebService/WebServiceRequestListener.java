package com.example.excitemobilesdk.WebService;

import com.android.volley.VolleyError;

/**
 * Created by erwinlim on 01/03/18.
 */

public interface WebServiceRequestListener {
    public void onResponse(String response);
    public void onErrorResponse(VolleyError error);
}
