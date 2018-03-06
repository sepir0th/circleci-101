package com.example.excitemobilesdk.WebService;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by erwinlim on 01/03/18.
 */

public class WebServiceRequest extends StringRequest {
    private Map<String, String> requestParams;
    private Boolean cacheMode = false;

    /**
     * Creates a new request with the given method.
     * This method is using protocol.
     *
     * @param method        the request {@link Method} to use
     * @param url           URL to fetch the string at
     */
    public WebServiceRequest(int method, String url, final WebServiceRequestListener WRListener) {
        super(method, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.i("response string",response.toString());
                WRListener.onResponse(response);
            }
        },  new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("error response","Error: " + error.getMessage());
                WRListener.onErrorResponse(error);
            }
        });
    }

    /**
     * Creates a new request with the given method.
     *
     * @param method        the request {@link Method} to use
     * @param url           URL to fetch the string at
     * @param listener      Listener to receive the String response
     * @param errorListener Error listener, or null to ignore errors
     */
    public WebServiceRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener,  errorListener);
    }

    public void setMapParams(Map<String, String> mapParams){
        this.requestParams = mapParams;
    }

    public void setCacheMode(Boolean cacheMode){
        this.cacheMode = cacheMode;
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        if(cacheMode) {
            Cache.Entry cacheEntry = HttpHeaderParser.parseCacheHeaders(response);
            if (cacheEntry == null) {
                cacheEntry = new Cache.Entry();
            }
            final long cacheHitButRefreshed = 3 * 60 * 1000; // in 3 minutes cache will be hit, but also refreshed on background
            final long cacheExpired = 60 * 60 * 1000; // in 24 hours this cache entry expires completely
            long now = System.currentTimeMillis();
            final long softExpire = now + cacheHitButRefreshed;
            final long ttl = now + cacheExpired;
            cacheEntry.data = response.data;
            cacheEntry.softTtl = softExpire;
            cacheEntry.ttl = ttl;
            String headerValue;
            headerValue = response.headers.get("Date");
            if (headerValue != null) {
                cacheEntry.serverDate = HttpHeaderParser.parseDateAsEpoch(headerValue);
            }
            headerValue = response.headers.get("Last-Modified");
            if (headerValue != null) {
                cacheEntry.lastModified = HttpHeaderParser.parseDateAsEpoch(headerValue);
            }
            cacheEntry.responseHeaders = response.headers;

            String jsonString = null;
            try {
                jsonString = new String(response.data,
                        HttpHeaderParser.parseCharset(response.headers));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            return Response.success(jsonString, cacheEntry);
        }else {
            return super.parseNetworkResponse(response);
        }
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return this.requestParams;
    }
}
