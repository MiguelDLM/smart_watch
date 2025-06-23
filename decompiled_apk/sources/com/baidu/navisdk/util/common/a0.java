package com.baidu.navisdk.util.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/* loaded from: classes8.dex */
public class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static String f9218a;
    public static String b;
    public static String c;
    private static String d;
    private static byte[] e;
    public static int f;
    public static String g;
    public static int h;
    private static String i;
    static String j;
    static String k;
    private static long l;

    static {
        System.getProperty("file.separator");
        h = 0;
        i = "0";
        l = 0L;
    }

    public static void a(Context context, String str, boolean z, String str2) {
        a(context, z, str2);
        d(context);
        a(context, z);
        e(context);
        a(context, str, context.getAssets());
        h(context);
    }

    private static long b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String c() {
        return i;
    }

    private static void d(Context context) {
        try {
            Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
        }
    }

    public static String e() {
        String str = k;
        return (str == null || str.length() <= 0) ? "00000000000000000000000000000000|000000000000000" : k;
    }

    public static String f() {
        return j;
    }

    public static String g() {
        return d;
    }

    public static byte[] h() {
        return e;
    }

    public static int i() {
        return h;
    }

    public static int j() {
        return f;
    }

    public static String k() {
        return c;
    }

    public static boolean l() {
        return Build.MANUFACTURER.equals("smartisan");
    }

    private static long c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String d() {
        String str = g;
        return (str == null || str.length() <= 0) ? "baidu" : g;
    }

    public static boolean f(Context context) {
        AudioManager audioManager;
        if (context == null || (audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO)) == null) {
            return false;
        }
        int mode = audioManager.getMode();
        return Build.VERSION.SDK_INT >= 30 ? mode == 1 || mode == 2 || mode == 3 || mode == 4 : mode == 1 || mode == 2 || mode == 3;
    }

    public static boolean g(Context context) {
        return b(context) == c(context);
    }

    private static void h(Context context) {
        try {
            InputStream open = context.getResources().getAssets().open("build");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            i = new String(bArr).trim();
            open.close();
        } catch (Exception e2) {
            if (LogUtil.LOGGABLE) {
                e2.printStackTrace();
            }
        }
    }

    public static void i(Context context) {
        try {
            InputStream open = context.getAssets().open("build");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            i = new String(bArr).trim();
            open.close();
        } catch (Exception e2) {
            if (LogUtil.LOGGABLE) {
                e2.printStackTrace();
            }
        }
    }

    private static void e(Context context) {
        try {
            File file = new File(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir);
            boolean exists = file.exists();
            LogUtil.e("PackageUtil", "initApkUpdateTime: apkFileExists " + exists);
            l = exists ? file.lastModified() : System.currentTimeMillis();
        } catch (Exception e2) {
            if (LogUtil.LOGGABLE) {
                e2.printStackTrace();
            }
        }
    }

    public static String b() {
        return Build.MANUFACTURER;
    }

    private static void a(Context context, boolean z, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            String packageName = context.getPackageName();
            d = packageName;
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            if (z) {
                c = packageInfo.versionName;
            } else {
                c = str;
            }
            f = packageInfo.versionCode;
            e = context.getPackageManager().getPackageInfo(d, 64).signatures[0].toByteArray();
        } catch (Exception unused) {
            c = "1.0.0";
            f = 1;
        }
        try {
            h = Integer.parseInt(Build.VERSION.SDK);
        } catch (Exception unused2) {
        }
        f9218a = Build.MODEL;
        b = "Android" + Build.VERSION.SDK;
    }

    private static void a(Context context, boolean z) {
        j = a(context);
        String str = k;
        if (str == null || TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    Class<?> cls = Class.forName("com.baidu.android.common.util.CommonParam");
                    k = (String) cls.getMethod("getCUID", Context.class).invoke(cls, context);
                    return;
                } catch (Exception e2) {
                    if (LogUtil.LOGGABLE) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            try {
                k = LBSAuthManager.getInstance(context).getCUID();
            } catch (Throwable th) {
                if (LogUtil.LOGGABLE) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        k = str;
    }

    private static String a(Context context) {
        Exception e2;
        String str;
        String str2 = null;
        if (context == null) {
            return null;
        }
        try {
            FileInputStream openFileInput = context.openFileInput("imei.dat");
            byte[] bArr = new byte[openFileInput.available()];
            openFileInput.read(bArr);
            openFileInput.close();
            str = new String(bArr, StandardCharsets.UTF_8);
        } catch (Exception e3) {
            e2 = e3;
        }
        try {
            return str.substring(str.indexOf(124) + 1);
        } catch (Exception e4) {
            e2 = e4;
            str2 = str;
            LogUtil.e("", e2.toString());
            return str2;
        }
    }

    private static void a(Context context, String str, AssetManager assetManager) {
        try {
            File file = new File(str + "/channel");
            InputStream open = assetManager.open("channel");
            long available = (long) open.available();
            if (file.exists() && available == file.length() && file.lastModified() > a()) {
                open.close();
                g = e0.a(context).a("SysOSAPI.channel", g);
                return;
            }
            byte[] bArr = new byte[(int) available];
            open.read(bArr);
            open.close();
            g = new String(bArr).trim();
            e0.a(context).b("SysOSAPI.channel", g);
            byte[] bytes = g.getBytes(StandardCharsets.UTF_8);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (Exception e2) {
            if (LogUtil.LOGGABLE) {
                e2.printStackTrace();
            }
        }
    }

    public static long a() {
        return l;
    }
}
