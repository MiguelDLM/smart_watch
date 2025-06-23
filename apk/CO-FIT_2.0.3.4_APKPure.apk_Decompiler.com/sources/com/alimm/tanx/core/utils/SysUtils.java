package com.alimm.tanx.core.utils;

import OoOoXO0.xoXoI;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.orange.OrangeManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.spi.LocationInfo;

public class SysUtils implements NotConfused {
    private static final String TAG = "SysUtils";

    public static boolean checkUrlSuffixAndValid(String str) {
        String urlSuffix = getUrlSuffix(str);
        if (!TextUtils.isEmpty(urlSuffix)) {
            return OrangeManager.getInstance().getWebSuffixWhiteSwitch(urlSuffix);
        }
        return false;
    }

    public static long currentTimeSecs() {
        return System.currentTimeMillis() / 1000;
    }

    public static List<String> getInstallStatus() {
        ArrayList arrayList = new ArrayList();
        HashMap<String, Boolean> installSwitch = OrangeManager.getInstance().getInstallSwitch();
        if (OrangeManager.getInstance().getInstallSwitch() != null) {
            for (Map.Entry next : installSwitch.entrySet()) {
                if (next.getValue() != null && ((Boolean) next.getValue()).booleanValue() && !TextUtils.isEmpty((CharSequence) next.getKey()) && hasPackage(TanxCoreSdk.getApplication(), (String) next.getKey())) {
                    arrayList.add(next.getKey());
                }
            }
        }
        return arrayList;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier <= 0) {
                identifier = R.dimen.default_status_bar_height;
            }
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
            Log.v(TAG, "System StatusBar height : " + dimensionPixelSize);
            return dimensionPixelSize;
        } catch (Exception e) {
            int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.default_status_bar_height);
            Log.e(TAG, "getStatusBarHeight() failed:", e);
            return dimensionPixelSize2;
        }
    }

    public static int getStatusBarHeight2WebView(Context context) {
        int i;
        int statusbarHeight = getStatusbarHeight(context);
        if (statusbarHeight > 0) {
            i = statusbarHeight - 58;
        } else {
            i = 0;
        }
        if (i <= 0) {
            return 0;
        }
        return i;
    }

    public static int getStatusbarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String getUrlSuffix(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            LogUtils.d("getUrlSuffix", "url为空");
            return null;
        }
        int indexOf = str.indexOf(LocationInfo.NA);
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        int indexOf2 = str.indexOf(xoXoI.f16453oxoX);
        if (indexOf2 > 0) {
            str = str.substring(0, indexOf2);
        }
        String[] split2 = str.split("[\\\\/]");
        if (split2 == null || (split = split2[split2.length - 1].split("\\.")) == null || split.length < 1) {
            return "";
        }
        return split[split.length - 1];
    }

    private static boolean hasPackage(Context context, String str) {
        if (context == null || str == null) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 256);
            return true;
        } catch (Exception unused) {
            LogUtils.d("hasPackage", str + " not fount app");
            return false;
        }
    }

    public static boolean isValidUrl(String str) {
        try {
            URI uri = new URI(str.replaceAll("\\\\", "").trim());
            if (uri.getHost() == null) {
                return false;
            }
            if (uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            LogUtils.e(e);
            return false;
        }
    }
}
