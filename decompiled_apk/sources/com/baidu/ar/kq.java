package com.baidu.ar;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: classes7.dex */
public final class kq {
    public static boolean p(Context context) {
        NetworkInfo r = r(context);
        return r != null && r.isAvailable();
    }

    public static boolean q(Context context) {
        NetworkInfo r = r(context);
        return r != null && r.isAvailable() && r.getType() == 1;
    }

    private static NetworkInfo r(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static boolean s(Context context) {
        NetworkInfo r = r(context);
        return r != null && r.isAvailable() && r.getType() == 0;
    }

    public static int t(Context context) {
        NetworkInfo r = r(context);
        if (r != null && r.isAvailable() && r.getType() == 0) {
            String subtypeName = r.getSubtypeName();
            switch (r.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 2;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 3;
                case 13:
                    return 4;
                default:
                    if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                        return 3;
                    }
                    break;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static String u(Context context) {
        if (!p(context) || context == null) {
            return "not_Reachable";
        }
        if (q(context)) {
            return "wifi";
        }
        int t = t(context);
        return t == 2 ? "2G" : t == 3 ? "3G" : t == 4 ? "4G" : "other_network";
    }
}
