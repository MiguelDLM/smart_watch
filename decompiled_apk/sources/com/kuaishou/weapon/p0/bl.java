package com.kuaishou.weapon.p0;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.webkit.WebSettings;
import com.google.android.exoplayer2.util.MimeTypes;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/* loaded from: classes11.dex */
public class bl {
    public static String A() {
        try {
            String a2 = bh.a("persist.service.bdroid.bdaddr");
            if (TextUtils.isEmpty(a2)) {
                return bi.c;
            }
            return a2;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String B() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", String.class).invoke(cls, "gsm.version.baseband");
            if (TextUtils.isEmpty(str)) {
                return bi.c;
            }
            return str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String C() {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            StringBuilder sb = new StringBuilder();
            sb.append(numberOfCameras);
            return sb.toString();
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String D() {
        try {
            return BigDecimal.valueOf(((float) (new StatFs(Environment.getDataDirectory().getPath()).getTotalBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String E() {
        try {
            return BigDecimal.valueOf(((float) (new StatFs(Environment.getDataDirectory().getPath()).getAvailableBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String F() {
        return bi.d;
    }

    public static String G() {
        return bi.d;
    }

    public static long H() {
        BufferedReader bufferedReader;
        String readLine;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        do {
            try {
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                }
            } catch (Throwable unused2) {
                if (bufferedReader == null) {
                    return 0L;
                }
                bufferedReader.close();
            }
            try {
                bufferedReader.close();
            } catch (IOException unused3) {
                return 0L;
            }
        } while (!readLine.contains("MemTotal"));
        long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue();
        try {
            bufferedReader.close();
        } catch (IOException unused4) {
        }
        return longValue;
    }

    public static String I() {
        try {
            return f.a(new File("/system/bin/app_process"));
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String J() {
        try {
            File file = new File("/system/bin/servicemanager");
            if (file.exists() && file.canRead()) {
                return f.a(file);
            }
            return bi.d;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String K() {
        try {
            File file = new File("/system/framework/framework.jar");
            if (file.exists() && file.canRead()) {
                return f.a(file);
            }
            return bi.d;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String L() {
        return Build.getRadioVersion();
    }

    public static String a() {
        try {
            String str = Build.MANUFACTURER;
            return TextUtils.isEmpty(str) ? bi.c : str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String b() {
        try {
            String str = Build.BRAND;
            return TextUtils.isEmpty(str) ? bi.c : str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String c() {
        try {
            String str = Build.MODEL;
            return TextUtils.isEmpty(str) ? bi.c : str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String d() {
        try {
            String str = Build.HARDWARE;
            return TextUtils.isEmpty(str) ? bi.c : str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String e() {
        try {
            String str = Build.PRODUCT;
            return TextUtils.isEmpty(str) ? bi.c : str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String f() {
        try {
            String str = Build.DEVICE;
            return TextUtils.isEmpty(str) ? bi.c : str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String g() {
        try {
            String str = Build.BOARD;
            return TextUtils.isEmpty(str) ? bi.c : str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String h() {
        try {
            String str = Build.HOST;
            return TextUtils.isEmpty(str) ? bi.c : str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String i() {
        try {
            String str = Build.USER;
            return TextUtils.isEmpty(str) ? bi.c : str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String j() {
        try {
            String str = Build.TYPE;
            return TextUtils.isEmpty(str) ? bi.c : str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String k() {
        try {
            String str = Build.TAGS;
            if (TextUtils.isEmpty(str)) {
                return bi.c;
            }
            return str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String l() {
        try {
            String str = Build.BOOTLOADER;
            if (TextUtils.isEmpty(str)) {
                return bi.c;
            }
            return str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String m() {
        try {
            String str = Build.ID;
            if (TextUtils.isEmpty(str)) {
                return bi.c;
            }
            return str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String n() {
        try {
            String str = Build.DISPLAY;
            if (TextUtils.isEmpty(str)) {
                return bi.c;
            }
            return str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String o() {
        try {
            String str = Build.VERSION.CODENAME;
            if (TextUtils.isEmpty(str)) {
                return bi.c;
            }
            return str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String p() {
        try {
            String a2 = bh.a("rild.libpath");
            if (TextUtils.isEmpty(a2)) {
                return bi.c;
            }
            return a2;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String q() {
        try {
            String str = Build.VERSION.RELEASE;
            if (TextUtils.isEmpty(str)) {
                return bi.c;
            }
            return str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static int r() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable unused) {
            return -2;
        }
    }

    public static String s() {
        try {
            String str = Build.FINGERPRINT;
            if (TextUtils.isEmpty(str)) {
                return bi.c;
            }
            return str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String t() {
        try {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return bi.c;
            }
            return property;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String u() {
        Process process;
        InputStream inputStream;
        BufferedReader bufferedReader = null;
        try {
            process = Runtime.getRuntime().exec("uname -a");
            try {
                if (process.waitFor() == 0) {
                    inputStream = process.getInputStream();
                } else {
                    inputStream = process.getErrorStream();
                }
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream), 512);
                    try {
                        String readLine = bufferedReader2.readLine();
                        try {
                            bufferedReader2.close();
                        } catch (Throwable unused) {
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        process.destroy();
                        return readLine;
                    } catch (Throwable unused3) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused5) {
                            }
                        }
                        if (process != null) {
                            process.destroy();
                            return bi.d;
                        }
                        return bi.d;
                    }
                } catch (Throwable unused6) {
                }
            } catch (Throwable unused7) {
                inputStream = null;
            }
        } catch (Throwable unused8) {
            process = null;
            inputStream = null;
        }
    }

    public static String v() {
        try {
            String str = Build.RADIO;
            if (TextUtils.isEmpty(str)) {
                return bi.c;
            }
            return str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String w() {
        try {
            String a2 = bh.a("ro.build.description");
            if (TextUtils.isEmpty(a2)) {
                return bi.c;
            }
            return a2;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String x() {
        try {
            String str = Build.VERSION.INCREMENTAL;
            if (TextUtils.isEmpty(str)) {
                return bi.c;
            }
            return str;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String y() {
        try {
            String a2 = bh.a("ro.product.name");
            if (TextUtils.isEmpty(a2)) {
                return bi.c;
            }
            return a2;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static String z() {
        try {
            String a2 = bh.a("dalvik.vm.heapgrowthlimit");
            if (TextUtils.isEmpty(a2)) {
                return bi.c;
            }
            return a2;
        } catch (Throwable unused) {
            return bi.d;
        }
    }

    public static int a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return -1;
            }
            return telephonyManager.getPhoneType();
        } catch (Throwable unused) {
            return -2;
        }
    }

    public static String b(Context context) {
        String property;
        try {
            try {
                property = WebSettings.getDefaultUserAgent(context);
            } catch (Throwable unused) {
                property = System.getProperty("http.agent");
            }
            return TextUtils.isEmpty(property) ? bi.c : property;
        } catch (Throwable unused2) {
            return bi.d;
        }
    }

    public static String c(Context context) {
        int i;
        int i2;
        WindowMetrics maximumWindowMetrics;
        Rect bounds;
        Rect bounds2;
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            defaultDisplay.getMetrics(new DisplayMetrics());
            if (Build.VERSION.SDK_INT >= 31) {
                maximumWindowMetrics = windowManager.getMaximumWindowMetrics();
                bounds = maximumWindowMetrics.getBounds();
                i = bounds.width();
                bounds2 = maximumWindowMetrics.getBounds();
                i2 = bounds2.height();
            } else {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                i = point.x;
                i2 = point.y;
            }
            float a2 = a(j(context));
            float b = b(j(context));
            if (a2 != 0.0f && b != 0.0f) {
                int round = Math.round((i / a2) * 2.54f) * 10;
                int round2 = Math.round((i2 / b) * 2.54f) * 10;
                if (round > round2) {
                    return round2 + "mm * " + round + DateFormatUtils.MIN;
                }
                return round + "mm * " + round2 + DateFormatUtils.MIN;
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String d(Context context) {
        int i;
        int i2;
        WindowMetrics maximumWindowMetrics;
        Rect bounds;
        Rect bounds2;
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            defaultDisplay.getMetrics(new DisplayMetrics());
            if (Build.VERSION.SDK_INT >= 31) {
                maximumWindowMetrics = windowManager.getMaximumWindowMetrics();
                bounds = maximumWindowMetrics.getBounds();
                i = bounds.width();
                bounds2 = maximumWindowMetrics.getBounds();
                i2 = bounds2.height();
            } else {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                i = point.x;
                i2 = point.y;
            }
            if (i > i2) {
                return i2 + "*" + i;
            }
            return i + "*" + i2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String e(Context context) {
        DisplayMetrics j = j(context);
        if (j != null) {
            return Integer.toString(j.densityDpi);
        }
        return null;
    }

    public static String f(Context context) {
        Process process;
        InputStream inputStream;
        InputStream inputStream2 = null;
        r7 = null;
        String str = null;
        inputStream2 = null;
        try {
            process = Runtime.getRuntime().exec("cat /proc/version");
            try {
                inputStream = process.getInputStream();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            process = null;
        }
        try {
            byte[] bArr = new byte[1024];
            int read = inputStream.read(bArr);
            if (read <= 0) {
                try {
                    inputStream.close();
                } catch (Throwable unused3) {
                }
                process.destroy();
                return bi.c;
            }
            byte[] bArr2 = new byte[read];
            System.arraycopy(bArr, 0, bArr2, 0, read);
            String str2 = new String(bArr2, "utf-8");
            int indexOf = str2.indexOf("version");
            if (indexOf != -1) {
                String[] split = str2.substring(indexOf).split(" ");
                if (1 < split.length) {
                    str = split[1];
                }
            }
            if (TextUtils.isEmpty(str)) {
                try {
                    inputStream.close();
                } catch (Throwable unused4) {
                }
                process.destroy();
                return bi.c;
            }
            try {
                inputStream.close();
            } catch (Throwable unused5) {
            }
            process.destroy();
            return str;
        } catch (Throwable unused6) {
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Throwable unused7) {
                }
            }
            if (process != null) {
                process.destroy();
                return bi.d;
            }
            return bi.d;
        }
    }

    public static int g(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_off_timeout");
        } catch (Exception unused) {
            return -2;
        }
    }

    public static int h(Context context) {
        try {
            return ((AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getRingerMode();
        } catch (Exception unused) {
            return -2;
        }
    }

    public static int i(Context context) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", null);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke((ConnectivityManager) context.getSystemService("connectivity"), null)).booleanValue() ? 0 : 1;
        } catch (Throwable unused) {
            return -2;
        }
    }

    private static DisplayMetrics j(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static float a(DisplayMetrics displayMetrics) {
        if (displayMetrics == null) {
            return 0.0f;
        }
        try {
            return displayMetrics.xdpi;
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    private static float b(DisplayMetrics displayMetrics) {
        if (displayMetrics == null) {
            return 0.0f;
        }
        try {
            return displayMetrics.ydpi;
        } catch (Throwable unused) {
            return 0.0f;
        }
    }
}
