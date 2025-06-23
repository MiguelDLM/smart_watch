package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.Os;
import android.system.StructStat;
import android.system.StructTimespec;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.location.c.a.O0xOxO;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.exoplayer2.util.MimeTypes;
import com.kwad.sdk.service.ServiceProvider;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* loaded from: classes11.dex */
public final class bj {
    private static String aRA = "";
    private static boolean aRB = false;
    private static String aRC = "";
    private static String aRD = "";
    private static int aRE = 0;
    private static boolean aRF = false;
    private static int aRG = 0;
    private static boolean aRH = false;
    private static String aRM;
    private static String aRN;
    private static int aRV;
    private static long aRW;
    private static String aRz;
    private static final String[] aRI = {"", ""};
    private static String aRJ = "";
    private static String aRK = "";
    private static String aRL = "";
    private static int aRO = -1;
    private static boolean aRP = false;
    private static boolean aRQ = false;
    private static boolean aRR = false;
    private static boolean aRS = false;
    private static boolean aRT = false;
    private static boolean aRU = false;
    private static String aRX = "";
    private static String aRY = "";
    public static String aRZ = "";
    private static final List<String> aSa = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    private static long NC() {
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            return longValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static long NE() {
        return com.kwad.sdk.crash.utils.h.K(Environment.getDataDirectory());
    }

    public static long NF() {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(1024L)) {
            return 0L;
        }
        return com.kwad.sdk.crash.utils.h.J(Environment.getDataDirectory());
    }

    public static long NG() {
        long freeMemory;
        try {
            freeMemory = Runtime.getRuntime().freeMemory();
        } catch (Throwable unused) {
        }
        if (freeMemory <= 0) {
            return 0L;
        }
        return freeMemory;
    }

    public static int NH() {
        int i = aRV;
        if (i > 0) {
            return i;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        aRV = availableProcessors;
        return availableProcessors;
    }

    public static String NI() {
        return Build.MODEL;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006f A[Catch: all -> 0x001a, TRY_LEAVE, TryCatch #0 {all -> 0x001a, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x0013, B:12:0x0021, B:14:0x0027, B:16:0x002d, B:17:0x0030, B:19:0x0036, B:21:0x0040, B:22:0x0043, B:24:0x0049, B:26:0x0053, B:27:0x0056, B:29:0x005c, B:31:0x0066, B:32:0x0069, B:34:0x006f), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized long NJ() {
        /*
            java.lang.Class<com.kwad.sdk.utils.bj> r0 = com.kwad.sdk.utils.bj.class
            monitor-enter(r0)
            boolean r1 = com.kwad.sdk.utils.av.usePhoneStateDisable()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1f
            java.lang.String r1 = com.kwad.sdk.utils.av.MV()     // Catch: java.lang.Throwable -> L1a
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1c
            java.lang.String[] r1 = com.kwad.sdk.utils.av.MW()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1f
            goto L1c
        L1a:
            r1 = move-exception
            goto L7a
        L1c:
            r1 = 1
            goto L21
        L1f:
            r1 = 0
        L21:
            boolean r3 = com.kwad.sdk.utils.av.MT()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L30
            android.location.Location r3 = com.kwad.sdk.utils.av.MU()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L30
            r3 = 64
            long r1 = r1 | r3
        L30:
            boolean r3 = com.kwad.sdk.utils.av.usePhoneStateDisable()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L43
            java.lang.String r3 = com.kwad.sdk.utils.av.MX()     // Catch: java.lang.Throwable -> L1a
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto L43
            r3 = 2
            long r1 = r1 | r3
        L43:
            boolean r3 = com.kwad.sdk.utils.av.MY()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L56
            java.lang.String r3 = com.kwad.sdk.utils.av.MZ()     // Catch: java.lang.Throwable -> L1a
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto L56
            r3 = 4
            long r1 = r1 | r3
        L56:
            boolean r3 = com.kwad.sdk.utils.av.Na()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L69
            java.lang.String r3 = com.kwad.sdk.utils.av.Nb()     // Catch: java.lang.Throwable -> L1a
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto L69
            r3 = 2048(0x800, double:1.012E-320)
            long r1 = r1 | r3
        L69:
            boolean r3 = com.kwad.sdk.utils.av.Ne()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L78
            java.util.List r3 = com.kwad.sdk.utils.av.Nf()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L78
            r3 = 16
            long r1 = r1 | r3
        L78:
            monitor-exit(r0)
            return r1
        L7a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.bj.NJ():long");
    }

    public static String NK() {
        return Build.BRAND;
    }

    public static synchronized long NL() {
        long elapsedRealtime;
        synchronized (bj.class) {
            elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
        }
        return elapsedRealtime;
    }

    public static synchronized long NM() {
        long j;
        synchronized (bj.class) {
            j = Build.TIME;
        }
        return j;
    }

    public static synchronized String NN() {
        String str;
        synchronized (bj.class) {
            str = Build.FINGERPRINT;
        }
        return str;
    }

    public static synchronized String NO() {
        synchronized (bj.class) {
            if (!TextUtils.isEmpty(aRz)) {
                return aRz;
            }
            String radioVersion = Build.getRadioVersion();
            aRz = radioVersion;
            return radioVersion;
        }
    }

    public static synchronized String NP() {
        String name;
        synchronized (bj.class) {
            name = au.getName();
        }
        return name;
    }

    public static synchronized String NQ() {
        String version;
        synchronized (bj.class) {
            version = au.getVersion();
        }
        return version;
    }

    public static String NR() {
        return Build.MANUFACTURER;
    }

    public static int NS() {
        int i;
        if (aRO == -1) {
            if (dt(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())) {
                i = 4;
            } else {
                i = 3;
            }
            aRO = i;
        }
        return aRO;
    }

    public static String NT() {
        if (TextUtils.isEmpty(aRN)) {
            aRN = System.getProperty("os.arch");
        }
        return aRN;
    }

    public static int NU() {
        return Build.VERSION.SDK_INT;
    }

    public static String NV() {
        if (av.Nc() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(8L)) {
            return "";
        }
        if (TextUtils.isEmpty(aRZ)) {
            return aRZ;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                        String hostAddress = nextElement.getHostAddress();
                        aRZ = hostAddress;
                        return hostAddress;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private static String NW() {
        try {
            return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String NX() {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String h = y.h("ksadsdk_pref", "android_id", (String) null);
        y.i(h, "ksadsdk_pref", "android_id");
        return h;
    }

    public static String NY() {
        String substring;
        if (!TextUtils.isEmpty(aRX)) {
            return aRX;
        }
        try {
            String V = q.V(new File("/proc/sys/kernel/random/boot_id"));
            if (TextUtils.isEmpty(V)) {
                substring = "";
            } else {
                substring = V.substring(0, V.indexOf("\n"));
            }
            aRX = substring;
        } catch (Throwable unused) {
        }
        return aRX;
    }

    private static String a(String str, int i, char c) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + str.length() < 16) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    @SuppressLint({"HardwareIds"})
    public static String cJ(Context context) {
        if (TextUtils.isEmpty(aRL) && context != null && !aRS) {
            if (av.usePhoneStateDisable()) {
                return av.MX();
            }
            if (!o.LQ()) {
                return aRL;
            }
            try {
                String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                aRL = string;
                if (!hh(string)) {
                    aRL = "";
                }
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(aRL)) {
                aRS = true;
            }
            return aRL;
        }
        return aRL;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String cN(Context context) {
        synchronized (bj.class) {
            if (context != null) {
                if (!aRQ && TextUtils.isEmpty(aRJ) && SystemUtil.di(context) && !av.usePhoneStateDisable() && o.LX()) {
                    try {
                        aRJ = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
                    } catch (Exception unused) {
                    }
                    aRQ = TextUtils.isEmpty(aRJ);
                    return aRJ;
                }
            }
            return aRJ;
        }
    }

    public static String cd(boolean z) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            return "";
        }
        Context context = fVar.getContext();
        String bp = com.kwad.sdk.core.f.a.bp(context);
        if (!TextUtils.isEmpty(bp)) {
            return bp;
        }
        if (z) {
            return bp;
        }
        if (TextUtils.isEmpty(dm(context))) {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).zl();
        }
        return bp;
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static long dj(Context context) {
        if (context == null || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(1024L)) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static int dk(Context context) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(512L)) {
            return 0;
        }
        try {
            return ((BatteryManager) context.getApplicationContext().getSystemService("batterymanager")).getIntProperty(4);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long dl(Context context) {
        long j = aRW;
        if (j > 0) {
            return j;
        }
        if (context == null) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j2 = memoryInfo.totalMem;
            if (j2 <= 0) {
                j2 = NC();
            }
            aRW = j2;
            return j2;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static synchronized String dm(@Nullable Context context) {
        boolean z;
        synchronized (bj.class) {
            if (av.usePhoneStateDisable() && !TextUtils.isEmpty(av.MV())) {
                return av.MV();
            }
            if (aRP) {
                return aRC;
            }
            if (TextUtils.isEmpty(aRC) && context != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return aRC;
                }
                if (av.usePhoneStateDisable()) {
                    return aRC;
                }
                if (!o.LW()) {
                    return aRC;
                }
                try {
                    z = SystemUtil.di(context);
                    if (z) {
                        try {
                            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                            aRC = deviceId;
                            if (TextUtils.isEmpty(deviceId)) {
                                aRP = true;
                            }
                        } catch (Exception e) {
                            e = e;
                            com.kwad.sdk.core.e.c.printStackTrace(e);
                            if (z) {
                                aRP = true;
                            }
                            return aRC;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    z = false;
                }
                return aRC;
            }
            return aRC;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String dn(@Nullable Context context) {
        boolean z;
        String meid;
        synchronized (bj.class) {
            if (aRU) {
                return aRD;
            }
            if (TextUtils.isEmpty(aRD) && context != null) {
                if (av.usePhoneStateDisable()) {
                    return aRD;
                }
                if (!o.LV()) {
                    return aRL;
                }
                try {
                    z = SystemUtil.di(context);
                    if (z) {
                        try {
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            if (telephonyManager != null) {
                                if (Build.VERSION.SDK_INT >= 26) {
                                    meid = telephonyManager.getMeid();
                                    aRD = meid;
                                    if (TextUtils.isEmpty(meid)) {
                                        aRU = true;
                                    }
                                } else if (telephonyManager.getPhoneType() == 2) {
                                    String deviceId = telephonyManager.getDeviceId();
                                    aRD = deviceId;
                                    if (TextUtils.isEmpty(deviceId)) {
                                        aRU = true;
                                    }
                                } else {
                                    aRD = null;
                                    aRU = true;
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            com.kwad.sdk.core.e.c.printStackTrace(e);
                            if (z) {
                                aRU = true;
                            }
                            return aRD;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    z = false;
                }
                return aRD;
            }
            return aRD;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    /* renamed from: do, reason: not valid java name */
    public static synchronized String[] m280do(@Nullable Context context) {
        String deviceId;
        String imei;
        synchronized (bj.class) {
            if (av.usePhoneStateDisable() && av.MW() != null) {
                return av.MW();
            }
            if (aRT) {
                return aRI;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                return aRI;
            }
            String[] strArr = aRI;
            boolean z = false;
            if (TextUtils.isEmpty(strArr[0]) && TextUtils.isEmpty(strArr[1]) && context != null) {
                if (av.usePhoneStateDisable()) {
                    return strArr;
                }
                if (!o.LW()) {
                    return strArr;
                }
                try {
                    boolean di = SystemUtil.di(context);
                    if (di) {
                        try {
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            if (telephonyManager != null) {
                                if (i >= 26) {
                                    int min = Math.min(dp(context), 2);
                                    for (int i2 = 0; i2 < min; i2++) {
                                        String[] strArr2 = aRI;
                                        imei = telephonyManager.getImei(i2);
                                        strArr2[i2] = imei;
                                    }
                                    String[] strArr3 = aRI;
                                    if (TextUtils.isEmpty(strArr3[0]) && TextUtils.isEmpty(strArr3[1])) {
                                        aRT = true;
                                    }
                                } else if (telephonyManager.getPhoneType() == 1) {
                                    if (i >= 23) {
                                        int min2 = Math.min(dp(context), 2);
                                        for (int i3 = 0; i3 < min2; i3++) {
                                            String[] strArr4 = aRI;
                                            deviceId = telephonyManager.getDeviceId(i3);
                                            strArr4[i3] = deviceId;
                                        }
                                    } else {
                                        strArr[0] = telephonyManager.getDeviceId();
                                        strArr[1] = null;
                                    }
                                    String[] strArr5 = aRI;
                                    if (TextUtils.isEmpty(strArr5[0]) && TextUtils.isEmpty(strArr5[1])) {
                                        aRT = true;
                                    }
                                } else {
                                    strArr[0] = null;
                                    strArr[1] = null;
                                    aRT = true;
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            z = di;
                            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                            if (z) {
                                aRT = true;
                            }
                            return aRI;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                return aRI;
            }
            return strArr;
        }
    }

    public static synchronized int dp(Context context) {
        boolean z;
        int phoneCount;
        synchronized (bj.class) {
            if (!aRF && aRE <= 0 && Build.VERSION.SDK_INT >= 23 && context != null && !av.usePhoneStateDisable()) {
                try {
                    phoneCount = ((TelephonyManager) context.getSystemService("phone")).getPhoneCount();
                    aRE = phoneCount;
                } catch (Exception unused) {
                }
                int i = aRE;
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                aRF = z;
                return i;
            }
            return aRE;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static int dq(Context context) {
        boolean z;
        int activeSubscriptionInfoCount;
        if (context != null && aRG <= 0 && !aRH && Build.VERSION.SDK_INT >= 22 && SystemUtil.di(context) && !av.usePhoneStateDisable()) {
            try {
                activeSubscriptionInfoCount = O0xOxO.oIX0oI(context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
                aRG = activeSubscriptionInfoCount;
            } catch (Throwable unused) {
            }
            int i = aRG;
            if (i != 0) {
                z = true;
            } else {
                z = false;
            }
            aRH = z;
            return i;
        }
        return aRG;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String dr(Context context) {
        String str;
        if (TextUtils.isEmpty(aRK) && context != null) {
            if (aRR) {
                return aRK;
            }
            if (av.usePhoneStateDisable()) {
                return aRK;
            }
            if (!o.LY()) {
                return aRK;
            }
            try {
                if (SystemUtil.di(context)) {
                    aRK = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimSerialNumber();
                }
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
                aRK = null;
            }
            if (TextUtils.isEmpty(aRK)) {
                aRR = true;
            }
            if (TextUtils.isEmpty(aRK)) {
                str = "";
            } else {
                str = aRK;
            }
            aRK = str;
            return str;
        }
        return aRK;
    }

    public static synchronized int ds(Context context) {
        int ringerMode;
        synchronized (bj.class) {
            try {
                ringerMode = ((AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getRingerMode();
            } catch (Exception unused) {
                return -1;
            }
        }
        return ringerMode;
    }

    private static boolean dt(Context context) {
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) {
            return false;
        }
        return true;
    }

    @SuppressLint({"HardwareIds"})
    public static synchronized String du(@Nullable Context context) {
        synchronized (bj.class) {
            if (TextUtils.isEmpty(aRA) && context != null && !aRB) {
                if (av.MY()) {
                    String MZ = av.MZ();
                    aRA = MZ;
                    return MZ;
                }
                if (!o.LR()) {
                    return aRA;
                }
                try {
                    WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                    if (connectionInfo != null) {
                        aRA = connectionInfo.getMacAddress();
                    }
                    if (hf(aRA)) {
                        Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            NetworkInterface networkInterface = (NetworkInterface) it.next();
                            if (networkInterface != null && "wlan0".equals(networkInterface.getName())) {
                                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                                if (hardwareAddress != null && hardwareAddress.length != 0) {
                                    StringBuilder sb = new StringBuilder();
                                    for (byte b : hardwareAddress) {
                                        sb.append(String.format("%02X:", Byte.valueOf(b)));
                                    }
                                    if (sb.length() > 0) {
                                        sb.deleteCharAt(sb.length() - 1);
                                    }
                                    aRA = sb.toString();
                                }
                            }
                        }
                    }
                    if (hf(aRA)) {
                        aRA = com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream());
                    }
                    if (!hf(aRA)) {
                        aRA = aRA.toUpperCase(Locale.US);
                    }
                } catch (Exception unused) {
                    aRB = true;
                }
                aRB = hf(aRA);
                return aRA;
            }
            return aRA;
        }
    }

    @Nullable
    public static List<String> dv(@NonNull Context context) {
        String[] list;
        if (c.bS(context)) {
            return new ArrayList();
        }
        if (!dw(context)) {
            return new ArrayList();
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data");
        if (!file.exists() || !file.isDirectory() || (list = file.list()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && !str.startsWith(FileUtils.FILE_EXTENSION_SEPARATOR)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static boolean dw(@NonNull Context context) {
        if (context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30) {
            return false;
        }
        if (context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.j) != 0) {
            return false;
        }
        return true;
    }

    public static String getDeviceId() {
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
        if (!TextUtils.isEmpty(aRM)) {
            return aRM;
        }
        String NX = NX();
        if (!TextUtils.isEmpty(NX)) {
            String str = "ANDROID_" + NX;
            aRM = str;
            return str;
        }
        String cJ = cJ(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
        if (!TextUtils.isEmpty(cJ) && !hg(cJ) && hh(cJ)) {
            String str2 = "ANDROID_" + cJ;
            aRM = str2;
            return str2;
        }
        String NW = NW();
        if (!TextUtils.isEmpty(NW)) {
            aRM = "ANDROID_" + NW;
            hi(NW);
            return aRM;
        }
        return "ANDROID_";
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getLocale() {
        Locale locale;
        LocaleList localeList;
        if (Build.VERSION.SDK_INT >= 24) {
            localeList = LocaleList.getDefault();
            locale = localeList.get(0);
        } else {
            locale = Locale.getDefault();
        }
        if (locale == null) {
            locale = Locale.CHINESE;
        }
        return String.valueOf(locale);
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getScreenHeight(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getScreenWidth(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static boolean hf(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals("02:00:00:00:00:00")) {
            return false;
        }
        return true;
    }

    private static boolean hg(String str) {
        return aSa.contains(str.toLowerCase(Locale.US));
    }

    private static boolean hh(String str) {
        for (int i = 0; i < str.length(); i++) {
            try {
                if (str.charAt(i) != '0') {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static void hi(String str) {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return;
        }
        y.a("ksadsdk_pref", "android_id", str, true);
    }

    public static String hj(String str) {
        StructStat stat;
        StructTimespec structTimespec;
        StructTimespec structTimespec2;
        long j;
        StructTimespec structTimespec3;
        long j2;
        String valueOf;
        if (TextUtils.isEmpty(aRY) && !TextUtils.isEmpty(str)) {
            int i = Build.VERSION.SDK_INT;
            try {
                stat = Os.stat(str);
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
            if (stat == null) {
                return aRY;
            }
            String str2 = "";
            if (i >= 27) {
                structTimespec = stat.st_atim;
                if (structTimespec != null) {
                    structTimespec2 = stat.st_atim;
                    j = structTimespec2.tv_sec;
                    str2 = String.valueOf(j);
                    structTimespec3 = stat.st_atim;
                    j2 = structTimespec3.tv_nsec;
                    valueOf = String.valueOf(j2);
                } else {
                    valueOf = "";
                }
                aRY = str2 + FileUtils.FILE_EXTENSION_SEPARATOR + valueOf;
            } else {
                long j3 = stat.st_atime;
                if (j3 != 0) {
                    str2 = String.valueOf(j3);
                }
                aRY = str2;
            }
            return aRY;
        }
        return aRY;
    }

    public static String u(@Nullable Context context, boolean z) {
        if (av.usePhoneStateDisable() && !TextUtils.isEmpty(av.MV())) {
            return av.MV();
        }
        String dm = dm(context);
        if (!TextUtils.isEmpty(dm)) {
            return dm;
        }
        if (z) {
            return dm;
        }
        if (TextUtils.isEmpty(com.kwad.sdk.core.f.a.bp(context))) {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).zk();
        }
        return dm;
    }
}
