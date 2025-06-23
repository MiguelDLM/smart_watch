package com.baidu.navisdk.vi;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.PhoneNumberUtils;
import android.webkit.MimeTypeMap;
import com.baidu.navisdk.framework.interfaces.c;
import com.baidu.navisdk.framework.interfaces.g;
import com.baidu.navisdk.t;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* loaded from: classes8.dex */
public class VDeviceAPI {
    public static final String APP_NAME_BAIDU_MAP = "BaiduMap";
    public static final String APP_PRODUCT_KIND = "baiduNavi_SDK_FOR_Map";
    private static final int ERROR_INVALID_ADDRESS = 1;
    private static final int ERROR_INVALID_FILE_FORMAT = 2;
    private static final String TAG = "VDeviceAPI in java";
    private static PowerManager.WakeLock mWakeLock;
    private static Context sContext;
    private static String sSDCardCachePath;
    private static String sSDCardPath;

    /* loaded from: classes8.dex */
    public class a extends f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9403a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, String str3) {
            super(str, str2);
            this.f9403a = str3;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            TipTool.onCreateJNIToast(VDeviceAPI.sContext, this.f9403a);
            return null;
        }
    }

    public static String add(String str, String str2) {
        return new BigInteger(str).add(new BigInteger(str2)).toString();
    }

    public static String divide(String str, String str2) {
        return new BigInteger(str).divide(new BigInteger(str2)).toString();
    }

    public static boolean equals(String str, String str2) {
        if (new BigInteger(str).compareTo(new BigInteger(str2)) == 0) {
            return true;
        }
        return false;
    }

    public static String getAppPackageName() {
        return a0.g();
    }

    public static String getAppPackageVersion() {
        return a0.k();
    }

    public static String getAppProductKind() {
        LogUtil.e("VDeviceAPI", "getAppProductKind");
        return APP_PRODUCT_KIND;
    }

    public static int getAppVersionCode() {
        return a0.j();
    }

    public static long getAvailableMemory() {
        Context context = sContext;
        if (context == null) {
            return 0L;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    public static String getCachePath() {
        return sSDCardCachePath;
    }

    public static String getChannelID() {
        String str = "baidu";
        if (sContext == null) {
            return "baidu";
        }
        String str2 = "/data/data/" + sContext.getPackageName() + "/channel";
        File file = new File(str2);
        if (!file.exists()) {
            try {
                InputStream open = sContext.getAssets().open("channel");
                byte[] bArr = new byte[open.available()];
                open.read(bArr);
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
                fileOutputStream.write(bArr);
                str = l0.a(bArr, "UTF-8");
                fileOutputStream.close();
                open.close();
            } catch (IOException e) {
                LogUtil.e("", e.toString());
            }
        } else {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                str = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8)).readLine();
                fileInputStream.close();
            } catch (Exception e2) {
                LogUtil.e("", e2.toString());
            }
        }
        return str.trim();
    }

    public static String getCuid() {
        LogUtil.e("VDeviceAPI", "getCuid");
        return a0.e();
    }

    public static int getCurrentNetworkType() {
        return y.c(sContext);
    }

    public static String getDataVersion() {
        return t.b();
    }

    public static long getFreeSpace() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        return (statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1024;
    }

    public static String getImei() {
        return "000000000000000";
    }

    public static String getModuleFileName() {
        Context context = sContext;
        if (context == null) {
            return null;
        }
        return context.getFilesDir().getAbsolutePath();
    }

    public static VNetworkInfo getNetworkInfo(int i) {
        return new VNetworkInfo(y.a(sContext, i));
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getPhoneType() {
        String str = Build.MODEL;
        if (str == null || str.length() == 0) {
            return "unknown";
        }
        return str;
    }

    public static String getSDKVersion() {
        return t.a();
    }

    public static int getScreenBrightness() {
        int i;
        Context context = sContext;
        if (context == null) {
            return -1;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            i = Settings.System.getInt(contentResolver, "screen_brightness_mode");
        } catch (Settings.SettingNotFoundException e) {
            LogUtil.e("", e.toString());
            i = 0;
        }
        if (i == 1) {
            return -1;
        }
        try {
            return Settings.System.getInt(contentResolver, "screen_brightness");
        } catch (Settings.SettingNotFoundException unused) {
            return -1;
        }
    }

    public static float getScreenDensity() {
        return ScreenUtil.getInstance().getDensity();
    }

    public static int getScreenDensityDpi() {
        return ScreenUtil.getInstance().getDPI();
    }

    public static long getSdcardFreeSpace() {
        long j;
        long j2 = 0;
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            j = statFs.getBlockSize();
            try {
                j2 = statFs.getAvailableBlocks();
            } catch (Exception unused) {
                LogUtil.e(TAG, "getSdcardFreeSpace fail");
                return (j * j2) / 1024;
            }
        } catch (Exception unused2) {
            j = 0;
        }
        return (j * j2) / 1024;
    }

    public static String getSdcardPath() {
        return sSDCardPath;
    }

    public static long getSdcardTotalSpace() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (statFs.getBlockSize() * statFs.getBlockCount()) / 1024;
    }

    public static float getSystemMetricsX() {
        return ScreenUtil.getInstance().getWidthPixels();
    }

    public static float getSystemMetricsY() {
        return ScreenUtil.getInstance().getHeightPixels();
    }

    public static long getTotalMemory() {
        try {
            FileReader fileReader = new FileReader("/proc/meminfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader, 8192);
            long intValue = Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue();
            try {
                bufferedReader.close();
                fileReader.close();
                return intValue;
            } catch (IOException unused) {
                return intValue;
            }
        } catch (IOException unused2) {
            return 0L;
        }
    }

    public static long getTotalSpace() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        return (statFs.getBlockSize() * statFs.getBlockCount()) / 1024;
    }

    public static ScanResult[] getWifiHotpot() {
        Context context = sContext;
        if (context == null) {
            return null;
        }
        List<ScanResult> scanResults = ((WifiManager) context.getSystemService("wifi")).getScanResults();
        return (ScanResult[]) scanResults.toArray(new ScanResult[scanResults.size()]);
    }

    public static int getWindowHeight() {
        return ScreenUtil.getInstance().getHeightPixels();
    }

    public static int getWindowWidth() {
        return ScreenUtil.getInstance().getWidthPixels();
    }

    public static boolean gt(String str, String str2) {
        if (new BigInteger(str).compareTo(new BigInteger(str2)) > 0) {
            return true;
        }
        return false;
    }

    public static void init(Context context, String str, String str2) {
        sContext = context;
        sSDCardPath = str;
        sSDCardCachePath = str2;
    }

    public static int isWifiConnected() {
        return y.e(sContext) ? 1 : 0;
    }

    public static boolean lt(String str, String str2) {
        if (new BigInteger(str).compareTo(new BigInteger(str2)) < 0) {
            return true;
        }
        return false;
    }

    public static void makeCall(String str) {
        if (sContext == null) {
            return;
        }
        sContext.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)));
    }

    public static String mod(String str, String str2) {
        return new BigInteger(str).mod(new BigInteger(str2)).toString();
    }

    public static String multiply(String str, String str2) {
        return new BigInteger(str).multiply(new BigInteger(str2)).toString();
    }

    public static boolean nlt(String str, String str2) {
        if (new BigInteger(str).compareTo(new BigInteger(str2)) >= 0) {
            return true;
        }
        return false;
    }

    public static native void onNetworkStateChanged();

    public static void openUrl(String str) {
        if (sContext == null) {
            return;
        }
        sContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public static String powerMod(String str, int i, String str2) {
        BigInteger bigInteger = new BigInteger(str);
        BigInteger bigInteger2 = new BigInteger(str2);
        BigInteger bigInteger3 = new BigInteger("1");
        while (i > 0) {
            if (i % 2 != 0) {
                bigInteger3 = bigInteger3.multiply(bigInteger).mod(bigInteger2);
                i--;
            } else {
                bigInteger = bigInteger.multiply(bigInteger).mod(bigInteger2);
                i /= 2;
            }
        }
        return bigInteger3.mod(bigInteger2).toString();
    }

    public static int sendMMS(String str, String str2, String str3, String str4) {
        if (sContext == null) {
            return 0;
        }
        if (!PhoneNumberUtils.isWellFormedSmsAddress(str)) {
            LogUtil.e(TAG, "invalid address: " + str);
            return 1;
        }
        try {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(str4)).toString()));
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("address", str);
            intent.putExtra("subject", str2);
            intent.putExtra("sms_body", str3);
            intent.putExtra("android.intent.extra.STREAM", Uri.parse("file://" + str4));
            intent.setType(mimeTypeFromExtension);
            sContext.startActivity(intent);
            return 0;
        } catch (Exception unused) {
            LogUtil.e(TAG, "can't get the mimetype of this file: " + str4);
            return 2;
        }
    }

    public static void sendSMS(String str, String str2) {
        if (sContext == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", str2);
        sContext.startActivity(intent);
    }

    public static boolean setNetworkChangedCallback() {
        return false;
    }

    @SuppressLint({"Wakelock"})
    public static void setScreenAlwaysOn(boolean z) {
        try {
            if (z) {
                if (mWakeLock == null) {
                    try {
                        PowerManager powerManager = (PowerManager) sContext.getSystemService("power");
                        if (powerManager != null) {
                            mWakeLock = powerManager.newWakeLock(536870922, "VDeviceAPI");
                        }
                    } catch (Exception unused) {
                    }
                }
                PowerManager.WakeLock wakeLock = mWakeLock;
                if (wakeLock != null) {
                    wakeLock.acquire();
                }
            } else {
                PowerManager.WakeLock wakeLock2 = mWakeLock;
                if (wakeLock2 != null && wakeLock2.isHeld()) {
                    mWakeLock.release();
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static void setupSoftware(String str) {
        if (sContext == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        sContext.startActivity(intent);
    }

    public static void showJniToast(String str) {
        g d = c.p().d();
        if (d != null && d.O()) {
            String str2 = "ENG:" + str;
            if (LogUtil.LOGGABLE) {
                LogUtil.e("showJniToast", " showJniToast toast: " + str2);
            }
            com.baidu.navisdk.util.worker.c.a().a((f) new a("ShowJniToast-" + VDeviceAPI.class.getSimpleName(), null, str2), new e(99, 0));
        }
    }

    public static String subtract(String str, String str2) {
        return new BigInteger(str).subtract(new BigInteger(str2)).toString();
    }

    public static boolean unsetNetworkChangedCallback() {
        return false;
    }
}
