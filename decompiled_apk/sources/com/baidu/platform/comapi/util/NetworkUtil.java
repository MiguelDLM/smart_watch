package com.baidu.platform.comapi.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* loaded from: classes8.dex */
public class NetworkUtil {
    public static final int NETYPE_2G = 2;
    public static final int NETYPE_3G = 3;
    public static final int NETYPE_4G = 4;
    public static final int NETYPE_4G_UNKNOWN = 10;
    public static final int NETYPE_MOBILE_3G = 8;
    public static final int NETYPE_MOBILE_UNICOM_2G = 6;
    public static final int NETYPE_NOCON = -1;
    public static final int NETYPE_TELECOM_2G = 5;
    public static final int NETYPE_TELECOM_3G = 7;
    public static final int NETYPE_UNICOM_3G = 9;
    public static final int NETYPE_UNKNOWN = 0;
    public static final int NETYPE_WIFI = 1;
    public static String mProxyHost = "";
    public static int mProxyPort = 0;
    public static boolean mUseProxy = false;

    @SuppressLint({"NewApi"})
    private static String a(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            return "mobile";
        }
        boolean hasTransport = networkCapabilities.hasTransport(1);
        boolean hasTransport2 = networkCapabilities.hasTransport(0);
        boolean hasTransport3 = networkCapabilities.hasTransport(3);
        boolean hasTransport4 = networkCapabilities.hasTransport(6);
        boolean hasTransport5 = networkCapabilities.hasTransport(4);
        boolean hasTransport6 = networkCapabilities.hasTransport(5);
        if (hasTransport) {
            return "WIFI";
        }
        if (hasTransport2) {
            return "CELLULAR";
        }
        if (hasTransport3) {
            return "ETHERNET";
        }
        if (hasTransport4) {
            return "LoWPAN";
        }
        if (hasTransport5) {
            return "VPN";
        }
        if (!hasTransport6) {
            return "mobile";
        }
        return "WifiAware";
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            try {
                return connectivityManager.getActiveNetworkInfo();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static NetworkInfo[] getAllNetworkInfo(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getCurrentNetMode(Context context) {
        Network activeNetwork;
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        int i = -1;
        if (activeNetworkInfo != null) {
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                i = 1;
            } else if (type == 0 || type == 3 || type == 4 || type == 5) {
                if (Build.VERSION.SDK_INT > 29) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager != null) {
                        activeNetwork = connectivityManager.getActiveNetwork();
                        return a(connectivityManager.getNetworkCapabilities(activeNetwork));
                    }
                    return "mobile";
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    switch (telephonyManager.getNetworkType()) {
                        case 1:
                        case 2:
                            i = 6;
                            break;
                        case 3:
                        case 9:
                        case 10:
                        case 15:
                            i = 9;
                            break;
                        case 4:
                            i = 5;
                            break;
                        case 5:
                        case 6:
                        case 12:
                            i = 7;
                            break;
                        case 7:
                        case 11:
                        case 16:
                            i = 2;
                            break;
                        case 8:
                        case 17:
                            i = 8;
                            break;
                        case 13:
                        case 18:
                            i = 4;
                            break;
                        case 14:
                            i = 3;
                            break;
                        default:
                            i = 0;
                            break;
                    }
                }
            }
        }
        return Integer.toString(i);
    }

    public static String getNetworkOperatorInfo(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                try {
                    StringBuilder sb = new StringBuilder(networkOperator);
                    sb.insert(3, ":");
                    return sb.toString();
                } catch (Exception unused) {
                }
            }
        }
        return "";
    }

    public static int getNetworkOperatorType(Context context) {
        String networkOperatorInfo = getNetworkOperatorInfo(context);
        if (!TextUtils.isEmpty(networkOperatorInfo)) {
            if (!networkOperatorInfo.startsWith("460:00") && !networkOperatorInfo.startsWith("460:02")) {
                if (networkOperatorInfo.startsWith("460:01")) {
                    return 1;
                }
                if (networkOperatorInfo.startsWith("460:03")) {
                    return 2;
                }
                return -1;
            }
            return 0;
        }
        return -1;
    }

    public static boolean initConnectState() {
        return true;
    }

    public static boolean isNetworkAvailable(Context context) {
        try {
            if (isWifiConnected(context)) {
                return true;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            if (!activeNetworkInfo.isConnectedOrConnecting()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || 1 != activeNetworkInfo.getType()) {
                return false;
            }
            if (!activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        r5 = 1;
     */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isWifiState(android.content.Context r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            android.content.Context r1 = r5.getApplicationContext()
            java.lang.String r2 = "wifi"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.net.wifi.WifiManager r1 = (android.net.wifi.WifiManager) r1
            r2 = 1
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L25
            r4 = 23
            if (r3 < r4) goto L27
            java.lang.String r3 = "android.permission.ACCESS_WIFI_STATE"
            int r5 = androidx.core.app.IXxxXO.oIX0oI(r5, r3)     // Catch: java.lang.Exception -> L25
            if (r5 != 0) goto L2c
            int r5 = r1.getWifiState()     // Catch: java.lang.Exception -> L25
            goto L2d
        L25:
            goto L2c
        L27:
            int r5 = r1.getWifiState()     // Catch: java.lang.Exception -> L25
            goto L2d
        L2c:
            r5 = 1
        L2d:
            r1 = 3
            if (r5 != r1) goto L31
            r0 = 1
        L31:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.util.NetworkUtil.isWifiState(android.content.Context):boolean");
    }

    @SuppressLint({"NewApi"})
    public static void registerNetwork(Context context) {
        if (context == null) {
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkRequest build = new NetworkRequest.Builder().build();
        if (connectivityManager != null) {
            connectivityManager.registerNetworkCallback(build, new k());
        }
    }

    public static void updateNetworkProxy(Context context) {
    }
}
