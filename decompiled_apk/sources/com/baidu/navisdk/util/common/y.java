package com.baidu.navisdk.util.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

@Deprecated
/* loaded from: classes8.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    public static int f9253a = -1;
    public static int b = -1;

    public static int a(Context context) {
        NetworkInfo networkInfo;
        if (context == null) {
            return -100;
        }
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("getActiveNetworkSubtype", e);
            }
            networkInfo = null;
        }
        if (networkInfo == null) {
            return -100;
        }
        if (networkInfo.getType() == 1) {
            return 88;
        }
        return networkInfo.getSubtype();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(android.content.Context r2) {
        /*
            r0 = 1
            if (r2 != 0) goto L8
            java.lang.String r2 = java.lang.Integer.toString(r0)
            return r2
        L8:
            java.lang.String r1 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r1)     // Catch: java.lang.Exception -> L17
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2     // Catch: java.lang.Exception -> L17
            if (r2 == 0) goto L17
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()     // Catch: java.lang.Exception -> L17
            goto L18
        L17:
            r2 = 0
        L18:
            if (r2 == 0) goto L28
            int r1 = r2.getType()
            if (r1 != r0) goto L22
            r0 = 2
            goto L28
        L22:
            int r2 = r2.getSubtype()
            int r0 = r2 + 1000
        L28:
            java.lang.String r2 = java.lang.Integer.toString(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.common.y.b(android.content.Context):java.lang.String");
    }

    public static int c(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager.getActiveNetworkInfo() == null) {
                return 0;
            }
            int type = connectivityManager.getActiveNetworkInfo().getType();
            if (type != 0) {
                if (type != 1) {
                    return 1;
                }
                return 2;
            }
            return 3;
        } catch (Exception unused) {
            return 1;
        }
    }

    @Deprecated
    public static boolean d(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null) {
            return false;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception unused) {
        }
        if (connectivityManager == null) {
            LogUtil.e("NetworkUtils", "ConnectivityManager is null");
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnected();
        }
        LogUtil.e("NetworkUtils", "No Connected！");
        return false;
    }

    public static boolean e(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo == null) {
                return false;
            }
            if (!networkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static NetworkInfo a(Context context, int i) {
        if (context == null) {
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (i == 2) {
            return connectivityManager.getNetworkInfo(1);
        }
        if (i != 3) {
            return null;
        }
        return connectivityManager.getNetworkInfo(0);
    }

    public static boolean b(Context context, int i) {
        ConnectivityManager connectivityManager;
        NetworkInfo.State state;
        if (context == null) {
            return false;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception unused) {
        }
        if (connectivityManager == null) {
            LogUtil.e("NetworkUtils", "ConnectivityManager is null");
            return false;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(i);
        return networkInfo != null && ((state = networkInfo.getState()) == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING);
    }
}
