package x0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.octopus.ad.model.e;

/* loaded from: classes11.dex */
public class XX {
    public static boolean I0Io(Context context) {
        return ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected();
    }

    public static String II0xO0(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static e.d oIX0oI(Context context) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getNetworkInfo(1);
        } else {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return e.d.NET_WIFI;
        }
        try {
            switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return e.d.NET_2G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return e.d.NET_3G;
                case 13:
                    return e.d.NET_4G;
                default:
                    return e.d.NET_OTHER;
            }
        } catch (Exception unused) {
            return e.d.NET_OTHER;
        }
    }

    public static void oxoX(Context context) {
        if (context != null) {
            o0 oIX0oI2 = o0.oIX0oI();
            try {
                oIX0oI2.f33740oIX0oI = oIX0oI(context);
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null && 5 == telephonyManager.getSimState()) {
                    String simOperator = telephonyManager.getSimOperator();
                    if (simOperator != null) {
                        if (!simOperator.equals("46000") && !simOperator.equals("46002") && !simOperator.equals("46007")) {
                            if (simOperator.equals("46001")) {
                                oIX0oI2.f33738II0xO0 = e.c.ISP_CN_UNICOM;
                            } else if (simOperator.equals("46003")) {
                                oIX0oI2.f33738II0xO0 = e.c.ISP_CN_TEL;
                            }
                        }
                        oIX0oI2.f33738II0xO0 = e.c.ISP_CN_MOBILE;
                    } else {
                        oIX0oI2.f33738II0xO0 = e.c.ISP_UNKNOWN;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            oIX0oI2.f33737I0Io = "0.0.0.0";
        }
    }
}
