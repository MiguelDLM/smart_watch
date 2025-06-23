package com.tencent.bugly.proguard;

import XXO0.oIX0oI;
import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.openalliance.ad.constant.bn;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes13.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name */
    private static final ArrayList<oIX0oI> f26525a = new ArrayList<oIX0oI>() { // from class: com.tencent.bugly.proguard.ab.1
        {
            byte b2 = 0;
            add(new oOoXoXO(b2));
            add(new XO(b2));
            add(new Oxx0IOOO(b2));
            add(new ooOOo0oXI(b2));
            add(new II0XooXoX(b2));
            add(new xxIXOIIO(b2));
            add(new OOXIXo(b2));
            add(new X0o0xo(b2));
            add(new xoIox(b2));
            add(new II0xO0(b2));
            add(new oxoX(b2));
            add(new I0Io(b2));
        }
    };
    private static final Map<Integer, String> b = new HashMap<Integer, String>() { // from class: com.tencent.bugly.proguard.ab.2
        {
            put(1, "GPRS");
            put(2, "EDGE");
            put(3, "UMTS");
            put(8, "HSDPA");
            put(9, "HSUPA");
            put(10, "HSPA");
            put(4, "CDMA");
            put(5, "EVDO_0");
            put(6, "EVDO_A");
            put(7, "1xRTT");
            put(11, "iDen");
            put(12, "EVDO_B");
            put(13, "LTE");
            put(14, "eHRPD");
            put(15, "HSPA+");
        }
    };
    private static final String[] c = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    /* loaded from: classes13.dex */
    public static class I0Io extends oIX0oI {
        public I0Io() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.oIX0oI
        public final String oIX0oI() {
            return ap.a("ro.build.fingerprint") + "/" + ap.a("ro.build.rom.id");
        }

        public /* synthetic */ I0Io(byte b) {
            this();
        }
    }

    /* loaded from: classes13.dex */
    public static class II0XooXoX extends oIX0oI {
        public II0XooXoX() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.oIX0oI
        public final String oIX0oI() {
            String a2 = ap.a("ro.meizu.product.model");
            if (!ap.b(a2) && !a2.equals(bn.b.S)) {
                return "Meizu/FLYME/" + ap.a("ro.build.display.id");
            }
            return null;
        }

        public /* synthetic */ II0XooXoX(byte b) {
            this();
        }
    }

    /* loaded from: classes13.dex */
    public static class II0xO0 extends oIX0oI {
        public II0xO0() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.oIX0oI
        public final String oIX0oI() {
            String a2 = ap.a("ro.gn.gnromvernumber");
            if (!ap.b(a2) && !a2.equals(bn.b.S)) {
                return "amigo/" + a2 + "/" + ap.a("ro.build.display.id");
            }
            return null;
        }

        public /* synthetic */ II0xO0(byte b) {
            this();
        }
    }

    /* loaded from: classes13.dex */
    public static class OOXIXo extends oIX0oI {
        public OOXIXo() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.oIX0oI
        public final String oIX0oI() {
            String a2 = ap.a(OI0.oxoX.f1520xxIXOIIO);
            if (!ap.b(a2) && !a2.equals(bn.b.S)) {
                return "vivo/FUNTOUCH/".concat(a2);
            }
            return null;
        }

        public /* synthetic */ OOXIXo(byte b) {
            this();
        }
    }

    /* loaded from: classes13.dex */
    public static class Oxx0IOOO extends oIX0oI {
        public Oxx0IOOO() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.oIX0oI
        public final String oIX0oI() {
            String a2 = ap.a("ro.lenovo.series");
            if (!ap.b(a2) && !a2.equals(bn.b.S)) {
                return "Lenovo/VIBE/".concat(String.valueOf(ap.a(OI0.oxoX.f1519xoIox)));
            }
            return null;
        }

        public /* synthetic */ Oxx0IOOO(byte b) {
            this();
        }
    }

    /* loaded from: classes13.dex */
    public static class X0o0xo extends oIX0oI {
        public X0o0xo() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.oIX0oI
        public final String oIX0oI() {
            String a2 = ap.a("ro.aa.romver");
            if (!ap.b(a2) && !a2.equals(bn.b.S)) {
                return "htc/" + a2 + "/" + ap.a("ro.build.description");
            }
            return null;
        }

        public /* synthetic */ X0o0xo(byte b) {
            this();
        }
    }

    /* loaded from: classes13.dex */
    public static class XO extends oIX0oI {
        public XO() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.oIX0oI
        public final String oIX0oI() {
            String a2 = ap.a(OI0.oxoX.f1509II0XooXoX);
            if (!ap.b(a2) && !a2.equals(bn.b.S)) {
                return "HuaWei/EMOTION/".concat(a2);
            }
            return null;
        }

        public /* synthetic */ XO(byte b) {
            this();
        }
    }

    /* loaded from: classes13.dex */
    public static abstract class oIX0oI {
        public oIX0oI() {
        }

        public abstract String oIX0oI();

        public /* synthetic */ oIX0oI(byte b) {
            this();
        }
    }

    /* loaded from: classes13.dex */
    public static class oOoXoXO extends oIX0oI {
        public oOoXoXO() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.oIX0oI
        public final String oIX0oI() {
            String a2 = ap.a("ro.miui.ui.version.name");
            if (!ap.b(a2) && !a2.equals(bn.b.S)) {
                return "XiaoMi/MIUI/".concat(a2);
            }
            return null;
        }

        public /* synthetic */ oOoXoXO(byte b) {
            this();
        }
    }

    /* loaded from: classes13.dex */
    public static class ooOOo0oXI extends oIX0oI {
        public ooOOo0oXI() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.oIX0oI
        public final String oIX0oI() {
            String a2 = ap.a("ro.build.nubia.rom.name");
            if (!ap.b(a2) && !a2.equals(bn.b.S)) {
                return "Zte/NUBIA/" + a2 + "_" + ap.a("ro.build.nubia.rom.code");
            }
            return null;
        }

        public /* synthetic */ ooOOo0oXI(byte b) {
            this();
        }
    }

    /* loaded from: classes13.dex */
    public static class oxoX extends oIX0oI {
        public oxoX() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.oIX0oI
        public final String oIX0oI() {
            String a2 = ap.a("ro.build.tyd.kbstyle_version");
            if (!ap.b(a2) && !a2.equals(bn.b.S)) {
                return "dido/".concat(a2);
            }
            return null;
        }

        public /* synthetic */ oxoX(byte b) {
            this();
        }
    }

    /* loaded from: classes13.dex */
    public static class xoIox extends oIX0oI {
        public xoIox() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.oIX0oI
        public final String oIX0oI() {
            String a2 = ap.a("ro.lewa.version");
            if (!ap.b(a2) && !a2.equals(bn.b.S)) {
                return "tcl/" + a2 + "/" + ap.a("ro.build.display.id");
            }
            return null;
        }

        public /* synthetic */ xoIox(byte b) {
            this();
        }
    }

    /* loaded from: classes13.dex */
    public static class xxIXOIIO extends oIX0oI {
        public xxIXOIIO() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.proguard.ab.oIX0oI
        public final String oIX0oI() {
            String a2 = ap.a(OI0.oxoX.f1511OOXIXo);
            if (!ap.b(a2) && !a2.equals(bn.b.S)) {
                return "Oppo/COLOROS/".concat(a2);
            }
            return null;
        }

        public /* synthetic */ xxIXOIIO(byte b) {
            this();
        }
    }

    public static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
                return bn.b.S;
            }
            return bn.b.S;
        }
    }

    public static String b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
                return bn.b.S;
            }
            return bn.b.S;
        }
    }

    public static int c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (al.a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String d() {
        try {
            return String.valueOf(System.getProperty("os.arch"));
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
                return bn.b.S;
            }
            return bn.b.S;
        }
    }

    public static long e() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long f() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        r0 = java.lang.Long.parseLong(r2.replaceAll("[^\\d]", ""));
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0036 -> B:13:0x0046). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long g() {
        /*
            r0 = 0
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3a
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3a
            java.lang.String r5 = "/proc/self/status"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L3a
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L2a
        L13:
            if (r2 == 0) goto L31
            java.lang.String r4 = "VmSize"
            boolean r4 = r2.startsWith(r4)     // Catch: java.lang.Throwable -> L2a
            if (r4 == 0) goto L2c
            java.lang.String r4 = "[^\\d]"
            java.lang.String r5 = ""
            java.lang.String r2 = r2.replaceAll(r4, r5)     // Catch: java.lang.Throwable -> L2a
            long r0 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> L2a
            goto L31
        L2a:
            r2 = move-exception
            goto L3e
        L2c:
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L2a
            goto L13
        L31:
            r3.close()     // Catch: java.lang.Throwable -> L35
            goto L46
        L35:
            r2 = move-exception
            r2.printStackTrace()
            goto L46
        L3a:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L3e:
            com.tencent.bugly.proguard.al.a(r2)     // Catch: java.lang.Throwable -> L4b
            if (r3 == 0) goto L46
            r3.close()     // Catch: java.lang.Throwable -> L35
        L46:
            r2 = 1024(0x400, double:5.06E-321)
            long r0 = r0 * r2
            return r0
        L4b:
            r0 = move-exception
            if (r3 == 0) goto L56
            r3.close()     // Catch: java.lang.Throwable -> L52
            goto L56
        L52:
            r1 = move-exception
            r1.printStackTrace()
        L56:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ab.g():long");
    }

    public static long h() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static long i() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            if (!al.a(e)) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                            return -1L;
                        } catch (IOException e2) {
                            if (!al.a(e2)) {
                                e2.printStackTrace();
                                return -1L;
                            }
                            return -1L;
                        }
                    }
                    long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        if (!al.a(e3)) {
                            e3.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e4) {
                        if (!al.a(e4)) {
                            e4.printStackTrace();
                        }
                    }
                    return parseLong;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!al.a(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                                if (!al.a(e5)) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                                return -2L;
                            } catch (IOException e6) {
                                if (!al.a(e6)) {
                                    e6.printStackTrace();
                                    return -2L;
                                }
                                return -2L;
                            }
                        }
                        return -2L;
                    } catch (Throwable th3) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e7) {
                                if (!al.a(e7)) {
                                    e7.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e8) {
                                if (!al.a(e8)) {
                                    e8.printStackTrace();
                                }
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            fileReader = null;
            th = th5;
            bufferedReader = null;
        }
    }

    public static long j() {
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader, 2048);
                try {
                    bufferedReader2.readLine();
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e) {
                            if (!al.a(e)) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e2) {
                            if (!al.a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e3) {
                            if (!al.a(e3)) {
                                e3.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e4) {
                            if (!al.a(e4)) {
                                e4.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long parseLong2 = Long.parseLong(readLine2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim());
                    Long.signum(parseLong2);
                    long j = parseLong + (parseLong2 * 1024);
                    String readLine3 = bufferedReader2.readLine();
                    if (readLine3 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e5) {
                            if (!al.a(e5)) {
                                e5.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e6) {
                            if (!al.a(e6)) {
                                e6.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long parseLong3 = j + (Long.parseLong(readLine3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024);
                    try {
                        bufferedReader2.close();
                    } catch (IOException e7) {
                        if (!al.a(e7)) {
                            e7.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e8) {
                        if (!al.a(e8)) {
                            e8.printStackTrace();
                        }
                    }
                    return parseLong3;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        if (!al.a(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e9) {
                                if (!al.a(e9)) {
                                    e9.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                                return -2L;
                            } catch (IOException e10) {
                                if (!al.a(e10)) {
                                    e10.printStackTrace();
                                    return -2L;
                                }
                                return -2L;
                            }
                        }
                        return -2L;
                    } catch (Throwable th2) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e11) {
                                if (!al.a(e11)) {
                                    e11.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e12) {
                                if (!al.a(e12)) {
                                    e12.printStackTrace();
                                }
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
        }
    }

    public static long k() {
        if (!s()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
                return -2L;
            }
            return -2L;
        }
    }

    public static long l() {
        if (!s()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
                return -2L;
            }
            return -2L;
        }
    }

    public static String m() {
        return "";
    }

    public static String n() {
        Iterator<oIX0oI> it = f26525a.iterator();
        while (it.hasNext()) {
            String oIX0oI2 = it.next().oIX0oI();
            if (!TextUtils.isEmpty(oIX0oI2)) {
                return oIX0oI2;
            }
        }
        return null;
    }

    public static boolean o() {
        if (TextUtils.isEmpty(new xxIXOIIO((byte) 0).oIX0oI())) {
            return false;
        }
        return true;
    }

    public static boolean p() {
        if (TextUtils.isEmpty(new OOXIXo((byte) 0).oIX0oI())) {
            return false;
        }
        return true;
    }

    public static boolean q() {
        boolean z;
        String[] strArr = c;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                if (new File(strArr[i]).exists()) {
                    z = true;
                    break;
                }
                i++;
            } else {
                z = false;
                break;
            }
        }
        String str = Build.TAGS;
        if ((str == null || !str.contains("test-keys")) && !z) {
            return false;
        }
        return true;
    }

    public static boolean r() {
        float maxMemory = (float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
        float f = (float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
        float f2 = maxMemory - f;
        al.c("maxMemory : %f", Float.valueOf(maxMemory));
        al.c("totalMemory : %f", Float.valueOf(f));
        al.c("freeMemory : %f", Float.valueOf(f2));
        if (f2 < 10.0f) {
            return true;
        }
        return false;
    }

    private static boolean s() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public static String c(Context context) {
        NetworkInfo activeNetworkInfo;
        TelephonyManager telephonyManager;
        String str = "unknown";
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e = e;
        }
        if (activeNetworkInfo == null) {
            return null;
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo.getType() == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            int networkType = telephonyManager.getNetworkType();
            String str2 = b.get(Integer.valueOf(networkType));
            if (str2 == null) {
                try {
                    str = "MOBILE(" + networkType + oIX0oI.I0Io.f4095I0Io;
                } catch (Exception e2) {
                    e = e2;
                    str = str2;
                    if (!al.a(e)) {
                        e.printStackTrace();
                    }
                    return str;
                }
            } else {
                str = str2;
            }
        }
        return str;
    }

    public static String a(Context context) {
        if (context != null && context.getApplicationInfo() != null) {
            String str = context.getApplicationInfo().nativeLibraryDir;
            if (TextUtils.isEmpty(str)) {
                return bn.b.S;
            }
            if (str.endsWith("arm")) {
                return "armeabi-v7a";
            }
            if (str.endsWith("arm64")) {
                return "arm64-v8a";
            }
            if (str.endsWith("x86")) {
                return "x86";
            }
            if (str.endsWith("x86_64")) {
                return "x86_64";
            }
        }
        return bn.b.S;
    }

    public static long b(Context context) {
        long pss;
        ActivityManager activityManager;
        try {
            activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        } catch (Throwable unused) {
            pss = Debug.getPss();
        }
        if (activityManager == null) {
            return 0L;
        }
        pss = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss();
        return pss * 1024;
    }
}
