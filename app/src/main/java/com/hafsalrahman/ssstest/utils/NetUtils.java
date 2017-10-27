package com.hafsalrahman.ssstest.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by hafsal on 10/25/17.
 */

public class NetUtils {

    public static boolean network;

    Context mContext;

    public NetUtils(Context mContext) {
        this.mContext = mContext;
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        network = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        return network;
    }

}
