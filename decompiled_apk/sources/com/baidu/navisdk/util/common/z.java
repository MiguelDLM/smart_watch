package com.baidu.navisdk.util.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: classes8.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    public static volatile int f9254a = 0;
    public static volatile int b = -1;

    public static boolean a(Context context) {
        int s = com.baidu.navisdk.framework.b.s();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NetworkUtilsV2", "isConnectNetwork --> mapLongLinkConnectType = " + s);
            LogUtil.e("NetworkUtilsV2", "isConnectNetwork --> sConnectType = " + b);
        }
        if (s == -1) {
            if (b == 2) {
                return true;
            }
            return b(context);
        }
        if (s == 2 || b == 2) {
            return true;
        }
        return b(context);
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null) {
            return false;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("NetworkUtilsV2", "isNetworkAvailable --> e = " + e);
            }
        }
        if (connectivityManager == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("NetworkUtilsV2", "ConnectivityManager is null!");
                LogUtil.e("NetworkUtilsV2", "isNetworkAvailable --> isConnected = false");
            }
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            boolean isConnected = activeNetworkInfo.isConnected();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("NetworkUtilsV2", "isNetworkAvailable --> activeInfo = " + activeNetworkInfo);
                LogUtil.e("NetworkUtilsV2", "isNetworkAvailable --> isConnected = " + isConnected);
            }
            return isConnected;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NetworkUtilsV2", "No Connected!");
            LogUtil.e("NetworkUtilsV2", "isNetworkAvailable --> isConnected = false");
        }
        return false;
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1) {
            return false;
        }
        return true;
    }
}
