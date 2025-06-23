package o0IXXIx;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.openalliance.ad.constant.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import x0.xII;

/* loaded from: classes11.dex */
public class x0XOIxOo {
    public static String I0Io(Context context, String str) {
        try {
            PackageInfo X0o0xo2 = X0o0xo(context, str);
            if (X0o0xo2 == null) {
                return null;
            }
            return String.valueOf(X0o0xo2.versionCode);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long II0XooXoX() {
        return System.currentTimeMillis() / 1000;
    }

    public static String II0xO0() {
        if (new File("/system/bin/su").exists() && oxoX("/system/bin/su")) {
            return "yes";
        }
        if (new File("/system/xbin/su").exists() && oxoX("/system/xbin/su")) {
            return "yes";
        }
        return "no";
    }

    public static String IXxxXO(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem + "";
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String OOXIXo(Context context) {
        return context.getPackageName();
    }

    public static String Oo(Context context) {
        if (context.getResources().getConfiguration().orientation == 2) {
            return "2";
        }
        return "1";
    }

    public static String Oxx0IOOO(Context context) {
        String OOXIXo2 = xII.OOXIXo(context, "codeList");
        if (OOXIXo2 == null) {
            return "";
        }
        return OOXIXo2;
    }

    public static String Oxx0xo(Context context) {
        String I0Io2 = I0Io(context, x.Y);
        if (I0Io2 == null) {
            return "";
        }
        return I0Io2;
    }

    public static PackageInfo X0o0xo(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return packageManager.getPackageInfo(str, 128);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String XO() {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return null;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSize = statFs.getBlockSize();
            return (statFs.getBlockCount() * blockSize) + "";
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String oI0IIXIo(Context context) {
        String I0Io2 = I0Io(context, "com.huawei.hwid");
        if (I0Io2 == null) {
            return "";
        }
        return I0Io2;
    }

    public static long oIX0oI(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static String oO(Context context) {
        return String.valueOf(context.getResources().getDisplayMetrics().widthPixels);
    }

    public static String oOoXoXO(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String ooOOo0oXI(Context context) {
        String OOXIXo2 = xII.OOXIXo(context, "__GROUPVERSION__");
        if (OOXIXo2 == null) {
            return "";
        }
        return OOXIXo2;
    }

    public static boolean oxoX(String str) {
        Process process = null;
        try {
            try {
                process = Runtime.getRuntime().exec("ls -l " + str);
                String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
                if (readLine != null && readLine.length() >= 4) {
                    char charAt = readLine.charAt(3);
                    if (charAt == 's' || charAt == 'x') {
                        process.destroy();
                        return true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (process == null) {
                    return false;
                }
            }
            process.destroy();
            return false;
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }

    public static String x0XOIxOo(Context context) {
        String str;
        try {
            str = (String) context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return OOXIXo(context);
        }
        return str;
    }

    public static String x0xO0oo(Context context) {
        return String.valueOf(context.getResources().getDisplayMetrics().heightPixels);
    }

    public static boolean xoIox(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || str == null || str.isEmpty()) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        }
        return true;
    }

    public static long xxIXOIIO(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
