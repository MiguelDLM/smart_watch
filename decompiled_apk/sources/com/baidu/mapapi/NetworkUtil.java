package com.baidu.mapapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;

/* loaded from: classes7.dex */
public class NetworkUtil {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f5751a = false;

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        NetworkInfo networkInfo = null;
        if (context == null) {
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                NetworkRequest build = new NetworkRequest.Builder().build();
                if (connectivityManager != null && !f5751a) {
                    connectivityManager.registerNetworkCallback(build, new b(context));
                    f5751a = true;
                }
            } else {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            }
        } catch (Exception unused) {
        }
        return networkInfo;
    }

    public static String getCurrentNetMode(Context context) {
        Network activeNetwork;
        if (context == null) {
            return null;
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        int i = 0;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                i = 1;
            } else {
                if (Build.VERSION.SDK_INT > 29) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager != null) {
                        activeNetwork = connectivityManager.getActiveNetwork();
                        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
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
                    return "mobile";
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return Integer.toString(0);
                }
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
                    case 7:
                    case 12:
                        i = 7;
                        break;
                    case 8:
                        i = 8;
                        break;
                    case 11:
                        i = 2;
                        break;
                    case 13:
                        i = 4;
                        break;
                    case 14:
                        i = 10;
                        break;
                }
            }
        }
        return Integer.toString(i);
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

    public static boolean isWifiConnected(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return false;
        }
        try {
            if (1 == networkInfo.getType()) {
                return networkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void updateNetworkProxy(Context context) {
        SysUpdateObservable.getInstance().updateNetworkProxy(context);
    }

    public static boolean isWifiConnected(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || 1 != activeNetworkInfo.getType()) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }
}
