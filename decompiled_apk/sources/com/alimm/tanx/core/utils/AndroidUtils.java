package com.alimm.tanx.core.utils;

import XXO0.oIX0oI;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.SdkConstant;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.RequestBaseBean;
import com.alimm.tanx.core.config.TanxConfig;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;

/* loaded from: classes.dex */
public class AndroidUtils implements NotConfused {
    private static final String TAG = "PackageUtils";
    private static RequestBaseBean.AdDeviceBean deviceBean;

    public static String getAndroidId() {
        return "";
    }

    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return StringUtil.filterNonPrintableCharacters(String.valueOf(packageManager.getApplicationLabel(packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAppVersion(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getBrand() {
        return StringUtil.filterNonPrintableCharacters(Build.BRAND);
    }

    public static RequestBaseBean.AdDeviceBean getDeviceBean() {
        getDeviceInfo(true);
        return deviceBean;
    }

    public static String getDeviceInfo(boolean z) {
        try {
            if (deviceBean == null) {
                RequestBaseBean.AdDeviceBean adDeviceBean = new RequestBaseBean.AdDeviceBean();
                deviceBean = adDeviceBean;
                adDeviceBean.user_agent = getUserAgent();
                deviceBean.android_id = getAndroidId();
                RequestBaseBean.AdDeviceBean adDeviceBean2 = deviceBean;
                adDeviceBean2.device_type = 0;
                adDeviceBean2.brand = getBrand();
                deviceBean.model = getModel();
                RequestBaseBean.AdDeviceBean adDeviceBean3 = deviceBean;
                adDeviceBean3.os = "Android";
                adDeviceBean3.osv = getSystemVersion();
                Point screenSize = getScreenSize(TanxCoreSdk.getApplication());
                RequestBaseBean.AdDeviceBean adDeviceBean4 = deviceBean;
                adDeviceBean4.width = screenSize.x;
                adDeviceBean4.height = screenSize.y;
                adDeviceBean4.pixel_ratio = getDisplayDpi(TanxCoreSdk.getApplication());
            }
            deviceBean.network = NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getKey();
            return JSON.toJSONString(deviceBean);
        } catch (Exception e) {
            LogUtils.e(e);
            e.printStackTrace();
            if (z) {
                TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "PackageUtils", LogUtils.getStackTraceMessage(e), "");
            }
            return "";
        }
    }

    public static int getDisplayDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static String getModel() {
        return StringUtil.filterNonPrintableCharacters(Build.MODEL);
    }

    public static String getPackageName(Context context) {
        if (context != null) {
            return StringUtil.filterNonPrintableCharacters(context.getPackageName());
        }
        return "";
    }

    public static int getScreenOrientation(Context context) {
        int i = context.getResources().getConfiguration().orientation;
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        return 0;
    }

    public static Point getScreenSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getUserAgent() {
        return StringUtil.filterNonPrintableCharacters(System.getProperty("http.agent"));
    }

    public static String getUserAgentSuffix() {
        return " AliApp(TANXSDK/" + SdkConstant.getSdkVersion() + oIX0oI.I0Io.f4095I0Io;
    }

    public static RequestBaseBean.AdDeviceBean getUtDeviceBean() {
        getDeviceInfo(false);
        return deviceBean;
    }

    public static String mediaNameStr() {
        String str;
        String str2;
        try {
            TanxConfig config = TanxCoreSdk.getConfig();
            String packageName = getPackageName(TanxCoreSdk.getApplication());
            if (TextUtils.isEmpty(packageName)) {
                str = "";
            } else {
                str = getAppVersion(TanxCoreSdk.getApplication(), packageName);
            }
            if (config == null) {
                str2 = "";
            } else {
                str2 = config.getAppName();
            }
            return "AppName/" + str2 + "/" + packageName + "/" + str;
        } catch (Exception e) {
            LogUtils.e(e);
            return "";
        }
    }
}
