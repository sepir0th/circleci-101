package com.example.lenovo.myapplication.WebService;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by erwinlim on 19/02/18.
 */

public class WebServiceSingleton {
    private static WebServiceSingleton mWebServiceSingletonInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static Context mContext;

    private WebServiceSingleton(Context context){
        mContext = context;
        mRequestQueue = getRequestQueue();

        mImageLoader = new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> cache = new LruCache<>(20);
            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }
        });
    }

    public static synchronized WebServiceSingleton getInstance(Context context){
        if(mWebServiceSingletonInstance == null){
            mWebServiceSingletonInstance = new WebServiceSingleton(context);
        }
        return mWebServiceSingletonInstance;
    }

    public RequestQueue getRequestQueue(){
        if(mRequestQueue == null){
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag){
        req.setTag(tag);
        getRequestQueue().add(req);
    }

    public ImageLoader getmImageLoader(){
        return mImageLoader;
    }

    public void cancelPendingRequests(Object tag){
        if(mRequestQueue != null){
            mRequestQueue.cancelAll(tag);
        }
    }
}