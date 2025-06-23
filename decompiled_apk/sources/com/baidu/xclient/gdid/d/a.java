package com.baidu.xclient.gdid.d;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Point;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.ai.speech.realtime.Util;
import com.baidu.xclient.gdid.c;
import com.baidu.xclient.gdid.e.d;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.jieli.jl_filebrowse.FileBrowseManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import jxl.read.biff.oIX0oI;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static long f10230a;
    public static long b;
    public static long c;
    public static long d;

    public static int a(long j) {
        try {
            if (g()) {
                String upperCase = Build.BOARD.trim().toUpperCase();
                if (upperCase.startsWith("SQW100-")) {
                    return FileBrowseManager.y;
                }
                if (!upperCase.startsWith("SQC100-") && !upperCase.startsWith("SQK100-") && !upperCase.startsWith("SQN100-") && !upperCase.startsWith("SQR100-") && !upperCase.startsWith("STA100-") && !upperCase.startsWith("STK100-") && !upperCase.startsWith("STL100-") && !upperCase.startsWith("STR100-")) {
                    if (upperCase.startsWith("STJ100-")) {
                        return oIX0oI.f28372XO;
                    }
                }
                return 2048;
            }
            float f = ((float) j) / 1024.0f;
            if (f > 10.0f) {
                return 12288;
            }
            if (f > 8.0f) {
                return 10240;
            }
            if (f > 7.0f) {
                return 8192;
            }
            if (f > 5.0f) {
                return 6144;
            }
            if (f > 4.0f) {
                return Util.BYTES_PER_FRAME;
            }
            if (f > 3.0f) {
                return 4096;
            }
            if (f > 2.0f) {
                return FileBrowseManager.y;
            }
            if (f > 1.0f) {
                return 2048;
            }
            if (f > 0.75f) {
                return 1024;
            }
            if (f > 0.5f) {
                return 768;
            }
            return f > 0.25f ? 512 : 0;
        } catch (Throwable th) {
            d.a(th);
            return 0;
        }
    }

    public static long b() {
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return -1L;
            }
            if (d == 0) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                d = statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            return d;
        } catch (Throwable th) {
            d.a(th);
            return -1L;
        }
    }

    public static long c() {
        try {
            if (f10230a == 0) {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                f10230a = statFs.getBlockSize() * statFs.getBlockCount();
            }
            return f10230a;
        } catch (Throwable th) {
            d.a(th);
            return -1L;
        }
    }

    public static long d() {
        try {
            if (b == 0) {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                b = statFs.getBlockSize() * statFs.getAvailableBlocks();
            }
            return b;
        } catch (Throwable th) {
            d.a(th);
            return -1L;
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static long e() {
        BufferedReader bufferedReader;
        String readLine;
        File a2 = com.baidu.mshield.b.e.a.a(c.b, "/proc/meminfo");
        long j = 0;
        if (a2 != null && a2.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(a2));
                do {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            d.a(th);
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th2) {
                                    d.a(th2);
                                }
                            }
                        }
                    }
                } while (!readLine.startsWith("MemTotal:"));
                String upperCase = readLine.substring(9).trim().toUpperCase();
                int indexOf = upperCase.indexOf(" KB");
                if (indexOf > 0) {
                    long a3 = a(upperCase.substring(0, indexOf));
                    if (a3 > 0) {
                        j = a3 / 1024;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        }
        return j;
    }

    public static int f(Context context) {
        try {
            return context.getResources().getConfiguration().orientation == 2 ? 0 : 1;
        } catch (Throwable th) {
            d.a(th);
            return 1;
        }
    }

    public static int g(Context context) {
        try {
            BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
            if (batteryManager == null) {
                return 0;
            }
            return batteryManager.getIntProperty(4);
        } catch (Throwable th) {
            d.a(th);
            return 0;
        }
    }

    public static boolean h(Context context) {
        try {
            int intExtra = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", -1);
            return intExtra == 2 || intExtra == 5;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    public static long a() {
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return -1L;
            }
            if (c == 0) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                c = statFs.getBlockSize() * statFs.getBlockCount();
            }
            return c;
        } catch (Throwable th) {
            d.a(th);
            return -1L;
        }
    }

    public static long b(Context context) {
        try {
            long c2 = c(context);
            return c2 <= 0 ? e() : c2;
        } catch (Throwable th) {
            d.a(th);
            return 0L;
        }
    }

    @SuppressLint({"NewApi"})
    public static long c(Context context) {
        if (context != null) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                if (activityManager == null) {
                    return 0L;
                }
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo.totalMem / 1048576;
            } catch (Throwable th) {
                d.a(th);
            }
        }
        return 0L;
    }

    public static String d(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            int i = (int) (memoryInfo.availMem / 1048576);
            return i % 1024 == 0 ? String.format("%d %s", Integer.valueOf(i / 1024), "GB") : (i < 1024 || i % 512 != 0) ? a(Long.valueOf(i)) : String.format("%.1f %s", Float.valueOf(i / 1024.0f), "GB");
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public static String e(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return "";
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        int i = point.x;
        return point.y + "X" + i;
    }

    public static String f() {
        try {
            return Build.MANUFACTURER.trim();
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public static boolean g() {
        try {
            if (!f().toUpperCase().equals("BLACKBERRY")) {
                if (!f().equals("RIM")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    public static long a(String str) {
        try {
            return Long.valueOf(str).longValue();
        } catch (NumberFormatException e) {
            d.a(e);
            return Long.MIN_VALUE;
        }
    }

    public static String a(Context context) {
        try {
            int a2 = a(b(context));
            if (a2 <= 0) {
                return null;
            }
            return a2 % 1024 == 0 ? String.format("%d %s", Integer.valueOf(a2 / 1024), "GB") : (a2 < 1024 || a2 % 512 != 0) ? a(Long.valueOf(a2)) : String.format("%.1f %s", Float.valueOf(a2 / 1024.0f), "GB");
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public static String a(Long l) {
        try {
            return l.longValue() >= 10240 ? String.format("%.2f %s", Float.valueOf(((float) l.longValue()) / 1024.0f), "GB") : String.format("%d %s", l, "MB");
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }
}
