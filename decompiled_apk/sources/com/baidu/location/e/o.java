package com.baidu.location.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.huawei.openalliance.ad.constant.x;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* loaded from: classes7.dex */
public class o {
    public static float A = 2.3f;
    public static float B = 3.8f;
    public static int C = 3;
    public static int D = 10;
    public static int E = 2;
    public static int F = 7;
    public static int G = 20;
    public static int H = 70;
    public static int I = 120;
    public static float J = 2.0f;
    public static float K = 10.0f;
    public static float L = 50.0f;
    public static float M = 200.0f;
    public static int N = 16;
    public static int O = 32;
    public static float P = 0.9f;
    public static int Q = 10000;
    public static float R = 0.5f;
    public static float S = 0.0f;
    public static float T = 0.1f;
    public static int U = 30;
    public static int V = 100;
    public static int W = 0;
    public static int X = 0;
    public static int Y = 0;
    public static int Z = 420000;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f5746a = false;
    public static float aA = 0.75f;
    public static double aB = -0.10000000149011612d;
    public static int aC = 0;
    public static int aD = 0;
    public static int aE = 1;
    public static int aF = 1;
    public static int aG = 0;
    public static float aH = 0.8f;
    public static float aI = 0.2f;
    public static int aJ = 0;
    public static int[] aK = null;
    public static boolean aL = false;
    public static int aM = 8;
    public static int aN = 4000;
    public static boolean aO = false;
    public static int aP = -1;
    public static int aQ = 10;
    public static int aR = 3;
    public static int aS = 40;
    public static double[] aT = null;
    public static int aU = 1;
    public static int aV = 1;
    public static int aW = 1;
    public static boolean aa = true;
    public static boolean ab = true;
    public static int ac = 20;
    public static int ad = 300;
    public static int ae = 1000;
    public static int af = Integer.MAX_VALUE;
    public static long ag = 900000;
    public static long ah = 420000;
    public static long ai = 180000;
    public static long aj = 0;
    public static long ak = 15;
    public static long al = 300000;
    public static int am = 1000;
    public static int an = 0;
    public static int ao = 30000;
    public static int ap = 30000;
    public static float aq = 10.0f;
    public static float ar = 6.0f;
    public static float as = 10.0f;
    public static int at = 60;
    public static int au = 70;
    public static int av = 6;
    public static String aw = null;
    public static boolean ax = false;
    public static int ay = 16;
    public static int az = 15;
    public static boolean b = false;
    public static boolean c = false;
    public static int d = 0;
    public static String e = "no";
    public static int f = 4;
    public static boolean g = false;
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;
    public static boolean k = false;
    public static boolean l = false;
    public static String m = "gcj02";
    public static String n = "";
    public static boolean o = true;
    public static int p = 3;
    public static double q = 0.0d;
    public static double r = 0.0d;
    public static double s = 0.0d;
    public static double t = 0.0d;
    public static int u = 0;
    public static byte[] v = null;
    public static boolean w = false;
    public static int x = 0;
    public static float y = 1.1f;
    public static float z = 2.2f;
    private static String bc = Build.MANUFACTURER;
    public static boolean aX = false;
    public static String aY = null;
    public static int aZ = -1;
    public static String ba = null;
    public static String bb = null;

    public static double a(double d2, double d3, double d4, double d5) {
        Location.distanceBetween(d2, d3, d4, d5, new float[1]);
        return r0[0];
    }

    public static int b(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode", -1);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static long c(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime() / 1000;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String d() {
        return e.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String e() {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 28
            if (r0 > r2) goto L20
            java.lang.String r0 = android.os.Environment.getExternalStorageState()     // Catch: java.lang.Exception -> L1c
            java.lang.String r3 = "mounted"
            boolean r0 = r0.equals(r3)     // Catch: java.lang.Exception -> L1c
            if (r0 == 0) goto L20
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Exception -> L1c
            java.lang.String r0 = r0.getPath()     // Catch: java.lang.Exception -> L1c
            goto L21
        L1c:
            r0 = move-exception
            r0.printStackTrace()
        L20:
            r0 = r1
        L21:
            if (r0 != 0) goto L3e
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 <= r2) goto L3e
            android.content.Context r2 = com.baidu.location.f.getServiceContext()
            if (r2 == 0) goto L3e
            android.content.Context r0 = com.baidu.location.f.getServiceContext()     // Catch: java.lang.Exception -> L3c
            java.lang.String r2 = android.os.Environment.DIRECTORY_MOVIES     // Catch: java.lang.Exception -> L3c
            java.io.File r0 = r0.getExternalFilesDir(r2)     // Catch: java.lang.Exception -> L3c
            java.lang.String r0 = r0.getAbsolutePath()     // Catch: java.lang.Exception -> L3c
            goto L3e
        L3c:
            r0 = r1
        L3e:
            if (r0 == 0) goto L65
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L60
            r2.<init>()     // Catch: java.lang.Exception -> L60
            r2.append(r0)     // Catch: java.lang.Exception -> L60
            java.lang.String r3 = "/baidu/tempdata"
            r2.append(r3)     // Catch: java.lang.Exception -> L60
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L60
            java.io.File r3 = new java.io.File     // Catch: java.lang.Exception -> L60
            r3.<init>(r2)     // Catch: java.lang.Exception -> L60
            boolean r2 = r3.exists()     // Catch: java.lang.Exception -> L60
            if (r2 != 0) goto L65
            r3.mkdirs()     // Catch: java.lang.Exception -> L60
            goto L65
        L60:
            r0 = move-exception
            r0.printStackTrace()
            goto L66
        L65:
            r1 = r0
        L66:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.o.e():java.lang.String");
    }

    public static String f() {
        String e2 = e();
        if (e2 == null) {
            return null;
        }
        return e2 + "/baidu/tempdata";
    }

    public static int g(Context context) {
        int a2 = a(context, com.kuaishou.weapon.p0.g.g) | a(context, com.kuaishou.weapon.p0.g.h);
        if (b(context) != 0 && a2 == 1) {
            return 1;
        }
        if (b(context) == 0 || a2 == 1) {
            return (b(context) >= 1 || a2 != 1) ? 0 : -1;
        }
        return -2;
    }

    public static String h() {
        try {
            File file = new File(com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "/baidu/tempdata");
            if (!file.exists()) {
                file.mkdirs();
            }
            return com.baidu.location.f.getServiceContext().getFilesDir().getPath();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String i() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(com.baidu.location.f.getServiceContext().getFilesDir());
            String str = File.separator;
            sb.append(str);
            sb.append("/baidu/tempdata");
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return com.baidu.location.f.getServiceContext().getFilesDir().getPath() + str + "/baidu/tempdata";
        } catch (Exception unused) {
            return null;
        }
    }

    public static String j() {
        return b("ro.mediatek.platform");
    }

    public static SSLSocketFactory k() throws Exception {
        TrustManager[] trustManagerArr = {new p()};
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, trustManagerArr, new SecureRandom());
        return sSLContext.getSocketFactory();
    }

    public static boolean l() {
        if (com.baidu.location.f.getServiceContext() == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 31 && a(com.baidu.location.f.getServiceContext(), com.kuaishou.weapon.p0.g.g) == 0 && a(com.baidu.location.f.getServiceContext(), com.kuaishou.weapon.p0.g.h) == 1;
    }

    public static int a(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Exception unused) {
            return 2;
        }
    }

    public static String b(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
        } catch (Exception unused) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
            }
            if (TextUtils.isEmpty(readLine)) {
                return null;
            }
            return readLine;
        } catch (Exception unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    public static String c() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet6Address) && nextElement.getHostAddress() != null && !nextElement.getHostAddress().startsWith("fe80:")) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String d(Context context) {
        int a2 = a(context, com.kuaishou.weapon.p0.g.h);
        int a3 = a(context, com.kuaishou.weapon.p0.g.g);
        int a4 = a(context, com.kuaishou.weapon.p0.g.c);
        if (Build.VERSION.SDK_INT < 29) {
            return "&per=" + a2 + "|" + a3 + "|" + a4;
        }
        return "&per=" + a2 + "|" + a3 + "|" + a4 + "|" + a(context, "android.permission.ACCESS_BACKGROUND_LOCATION");
    }

    public static String e(Context context) {
        int i2 = -1;
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    i2 = activeNetworkInfo.getType();
                }
            } catch (Throwable unused) {
            }
        }
        return "&netc=" + i2;
    }

    public static String f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String g() {
        try {
            File file = new File(com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "lldt");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Exception unused) {
            return null;
        }
    }

    public static int a(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0 ? 1 : 0;
        } catch (Exception unused) {
            return 1;
        }
    }

    public static boolean b() {
        return false;
    }

    public static boolean c(Context context) {
        int i2;
        if (context != null) {
            try {
                i2 = a(context, com.kuaishou.weapon.p0.g.h);
            } catch (Exception e2) {
                e2.printStackTrace();
                i2 = 1;
            }
            boolean z2 = i2 == 1;
            if (z2 && Build.VERSION.SDK_INT >= 23) {
                try {
                    if (Settings.Secure.getInt(context.getContentResolver(), "location_mode", 1) == 0) {
                        return false;
                    }
                } catch (Exception unused) {
                }
            }
            return z2;
        }
        return true;
    }

    public static int a(Object obj, String str) throws Exception {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, null);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return ((Integer) declaredMethod.invoke(obj, null)).intValue();
    }

    public static boolean b(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static int a(String str, String str2, String str3) {
        int indexOf;
        int length;
        int indexOf2;
        String substring;
        if (str != null && !str.equals("") && (indexOf = str.indexOf(str2)) != -1 && (indexOf2 = str.indexOf(str3, (length = indexOf + str2.length()))) != -1 && (substring = str.substring(length, indexOf2)) != null && !substring.equals("")) {
            try {
                return Integer.parseInt(substring);
            } catch (NumberFormatException unused) {
            }
        }
        return Integer.MIN_VALUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] b(byte[] r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L51
            int r1 = r4.length
            if (r1 != 0) goto L7
            goto L51
        L7:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r4)
            r4 = 0
            java.util.zip.GZIPInputStream r3 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L36
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L36
            r4 = 2048(0x800, float:2.87E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L27
        L1b:
            int r2 = r3.read(r4)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L27
            if (r2 < 0) goto L29
            r1.write(r4, r0, r2)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L27
            goto L1b
        L25:
            r4 = move-exception
            goto L46
        L27:
            r4 = move-exception
            goto L39
        L29:
            r3.close()     // Catch: java.io.IOException -> L2d
            goto L41
        L2d:
            r4 = move-exception
            r4.printStackTrace()
            goto L41
        L32:
            r0 = move-exception
            r3 = r4
            r4 = r0
            goto L46
        L36:
            r0 = move-exception
            r3 = r4
            r4 = r0
        L39:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L25
            if (r3 == 0) goto L41
            r3.close()     // Catch: java.io.IOException -> L2d
        L41:
            byte[] r4 = r1.toByteArray()
            return r4
        L46:
            if (r3 == 0) goto L50
            r3.close()     // Catch: java.io.IOException -> L4c
            goto L50
        L4c:
            r0 = move-exception
            r0.printStackTrace()
        L50:
            throw r4
        L51:
            byte[] r4 = new byte[r0]
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.o.b(byte[]):byte[]");
    }

    public static String a() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(5);
        return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(i2), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
    }

    public static String a(com.baidu.location.c.a aVar, com.baidu.location.c.p pVar, Location location, String str, int i2) {
        return a(aVar, pVar, location, str, i2, false);
    }

    public static String a(com.baidu.location.c.a aVar, com.baidu.location.c.p pVar, Location location, String str, int i2, boolean z2) {
        String b2;
        StringBuffer stringBuffer = new StringBuffer(2048);
        if (aVar != null && (b2 = com.baidu.location.c.h.a().b(aVar)) != null) {
            stringBuffer.append(b2);
        }
        if (pVar != null) {
            String a2 = com.baidu.location.c.h.a().a(i2 == 0 ? N : az, true, pVar, ay);
            if (a2 != null) {
                stringBuffer.append(a2);
            }
        }
        if (location != null) {
            String b3 = (d == 0 || i2 == 0) ? com.baidu.location.c.e.b(location) : com.baidu.location.c.e.c(location);
            if (b3 != null) {
                stringBuffer.append(b3);
            }
        }
        String a3 = b.a().a(i2 == 0);
        if (a3 != null) {
            stringBuffer.append(a3);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(com.baidu.location.c.e.a().m());
        String a4 = com.baidu.location.c.h.a().a(aVar);
        if (a4 != null && a4.length() + stringBuffer.length() < 2000) {
            stringBuffer.append(a4);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (location != null && pVar != null) {
            try {
                float speed = location.getSpeed();
                int i3 = d;
                int a5 = com.baidu.location.c.h.a().a(pVar);
                int a6 = pVar.a();
                boolean z3 = pVar.d;
                if (speed < ar && ((i3 == 1 || i3 == 0) && (a5 < at || z3))) {
                    p = 1;
                } else if (speed < as && ((i3 == 1 || i3 == 0 || i3 == 3) && (a5 < au || a6 > av))) {
                    p = 2;
                }
            } catch (Exception unused) {
                p = 3;
            }
            return stringBuffer2;
        }
        p = 3;
        return stringBuffer2;
    }

    public static String a(String str) {
        return Jni.en1(n + x.aL + str);
    }

    public static String a(byte[] bArr, String str, boolean z2) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (z2) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    public static String a(byte[] bArr, boolean z2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z2);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean a(double d2, double d3) {
        return Math.abs(d2 - d3) <= 1.192092896E-7d;
    }

    public static boolean a(float f2, float f3) {
        return Math.abs(f2 - f3) <= 1.1920929E-7f;
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:943)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:759)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:838)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:711)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static boolean a(android.location.Location r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L22
            java.lang.String r1 = com.baidu.location.e.o.bc
            if (r1 == 0) goto L22
            java.lang.String r2 = "huawei"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 != 0) goto L10
            goto L22
        L10:
            android.os.Bundle r3 = r3.getExtras()     // Catch: java.lang.Exception -> L22
            if (r3 == 0) goto L22
            java.lang.String r1 = "SourceType"
            int r3 = r3.getInt(r1)     // Catch: java.lang.Exception -> L22
            r1 = 128(0x80, float:1.8E-43)
            r3 = r3 & r1
            if (r3 != r1) goto L22
            r0 = 1
        L22:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.o.a(android.location.Location):boolean");
    }

    public static boolean a(BDLocation bDLocation) {
        int locType = bDLocation.getLocType();
        return (locType > 100 && locType < 200) || locType == 62;
    }

    public static boolean a(int[] iArr) {
        if (iArr != null && iArr.length >= 18) {
            for (int i2 : iArr) {
                if (i2 == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
