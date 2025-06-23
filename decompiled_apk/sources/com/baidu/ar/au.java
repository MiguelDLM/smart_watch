package com.baidu.ar;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Locale;

/* loaded from: classes7.dex */
public class au {

    /* loaded from: classes7.dex */
    public enum a {
        WIFI,
        CMNET,
        CMWAP,
        NONE
    }

    public static boolean d(Context context) {
        try {
            NetworkInfo[] allNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo();
            if (allNetworkInfo != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static a e(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            int type = activeNetworkInfo.getType();
            return type == 0 ? (activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().toLowerCase(Locale.getDefault()).equals("cmnet")) ? a.CMWAP : a.CMNET : type == 1 ? a.WIFI : a.NONE;
        }
        return a.NONE;
    }
}
