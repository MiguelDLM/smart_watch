package xoX;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;

/* loaded from: classes13.dex */
public class xxIXOIIO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final Uri f35148oIX0oI = Uri.parse("content://telephony/carriers/preferapn");

    public static String I0Io(Context context) {
        try {
            Cursor query = context.getContentResolver().query(f35148oIX0oI, null, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            if (query.isAfterLast()) {
                query.close();
                return null;
            }
            String string = query.getString(query.getColumnIndex("proxy"));
            query.close();
            return string;
        } catch (SecurityException e) {
            xx0.xxIXOIIO.II0XooXoX("openSDK_LOG.APNUtil", "getApnProxy has exception: " + e.getMessage());
            return "";
        }
    }

    public static String II0xO0(Context context) {
        try {
            Cursor query = context.getContentResolver().query(f35148oIX0oI, null, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            if (query.isAfterLast()) {
                query.close();
                return null;
            }
            String string = query.getString(query.getColumnIndex("apn"));
            query.close();
            return string;
        } catch (SecurityException e) {
            xx0.xxIXOIIO.II0XooXoX("openSDK_LOG.APNUtil", "getApn has exception: " + e.getMessage());
            return "";
        } catch (Exception e2) {
            xx0.xxIXOIIO.II0XooXoX("openSDK_LOG.APNUtil", "getApn has exception: " + e2.getMessage());
            return "";
        }
    }

    public static String X0o0xo(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "MOBILE";
        }
        return activeNetworkInfo.getTypeName();
    }

    public static String oIX0oI(Context context) {
        int oxoX2 = oxoX(context);
        if (oxoX2 == 2) {
            return "wifi";
        }
        if (oxoX2 == 1) {
            return "cmwap";
        }
        if (oxoX2 == 4) {
            return "cmnet";
        }
        if (oxoX2 == 16) {
            return "uniwap";
        }
        if (oxoX2 == 8) {
            return "uninet";
        }
        if (oxoX2 == 64) {
            return "wap";
        }
        if (oxoX2 == 32) {
            return TKDownloadReason.KSAD_TK_NET;
        }
        if (oxoX2 == 512) {
            return "ctwap";
        }
        if (oxoX2 == 256) {
            return "ctnet";
        }
        if (oxoX2 == 2048) {
            return "3gnet";
        }
        if (oxoX2 == 1024) {
            return "3gwap";
        }
        String II0xO02 = II0xO0(context);
        if (II0xO02 != null && II0xO02.length() != 0) {
            return II0xO02;
        }
        return "none";
    }

    public static int oxoX(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            xx0.xxIXOIIO.II0XooXoX("openSDK_LOG.APNUtil", "getMProxyType has exception: " + e.getMessage());
        }
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return 128;
        }
        if (activeNetworkInfo.getTypeName().toUpperCase().equals("WIFI")) {
            return 2;
        }
        String lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
        if (lowerCase.startsWith("cmwap")) {
            return 1;
        }
        if (!lowerCase.startsWith("cmnet") && !lowerCase.startsWith("epc.tmobile.com")) {
            if (lowerCase.startsWith("uniwap")) {
                return 16;
            }
            if (lowerCase.startsWith("uninet")) {
                return 8;
            }
            if (lowerCase.startsWith("wap")) {
                return 64;
            }
            if (lowerCase.startsWith(TKDownloadReason.KSAD_TK_NET)) {
                return 32;
            }
            if (lowerCase.startsWith("ctwap")) {
                return 512;
            }
            if (lowerCase.startsWith("ctnet")) {
                return 256;
            }
            if (lowerCase.startsWith("3gwap")) {
                return 1024;
            }
            if (lowerCase.startsWith("3gnet")) {
                return 2048;
            }
            if (lowerCase.startsWith("#777")) {
                String I0Io2 = I0Io(context);
                if (I0Io2 != null) {
                    if (I0Io2.length() > 0) {
                        return 512;
                    }
                }
                return 256;
            }
            return 128;
        }
        return 4;
    }
}
