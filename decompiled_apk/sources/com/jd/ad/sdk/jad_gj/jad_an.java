package com.jd.ad.sdk.jad_gj;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.jd.ad.sdk.jad_an.jad_cp;
import com.kuaishou.weapon.p0.an;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_an {
    public static Context jad_an = null;
    public static boolean jad_bo = false;

    public static String jad_an() {
        String str;
        PackageInfo packageInfo;
        Context context = jad_an;
        if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_bo.jad_an)) {
            str = "";
            if (context == null) {
                com.jd.ad.sdk.jad_dq.jad_an.jad_cp("AppInfo", "context is null");
            } else {
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(com.jd.ad.sdk.jad_an.jad_bo.jad_an(context), 16384);
                } catch (Exception e) {
                    if (com.jd.ad.sdk.jad_dq.jad_an.jad_cp) {
                        Log.e("AppInfo", "An exception happends when call getPackageInfo().", e);
                    }
                    packageInfo = null;
                }
                if (packageInfo == null) {
                    com.jd.ad.sdk.jad_dq.jad_an.jad_cp("AppInfo", "packageInfo is null");
                } else {
                    com.jd.ad.sdk.jad_an.jad_bo.jad_an = context.getPackageManager().getApplicationLabel(packageInfo.applicationInfo).toString();
                }
            }
            com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getAppName() --> ".concat(String.valueOf(str)));
            return str;
        }
        str = com.jd.ad.sdk.jad_an.jad_bo.jad_an;
        com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getAppName() --> ".concat(String.valueOf(str)));
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
    
        if (r2 == null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String jad_bo() {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            java.lang.String r2 = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            r1.close()     // Catch: java.io.IOException -> L18
        L18:
            r2.close()     // Catch: java.io.IOException -> L50
            goto L50
        L1c:
            r0 = move-exception
            goto L20
        L1e:
            goto L24
        L20:
            r3 = r1
            r1 = r0
            r0 = r3
            goto L36
        L24:
            r0 = r1
            goto L44
        L26:
            r2 = move-exception
            goto L2a
        L28:
            goto L2f
        L2a:
            r3 = r2
            r2 = r0
            r0 = r1
            r1 = r3
            goto L36
        L2f:
            r2 = r0
            goto L24
        L31:
            r1 = move-exception
            goto L35
        L33:
            goto L43
        L35:
            r2 = r0
        L36:
            if (r0 == 0) goto L3d
            r0.close()     // Catch: java.io.IOException -> L3c
            goto L3d
        L3c:
        L3d:
            if (r2 == 0) goto L42
            r2.close()     // Catch: java.io.IOException -> L42
        L42:
            throw r1
        L43:
            r2 = r0
        L44:
            if (r0 == 0) goto L4b
            r0.close()     // Catch: java.io.IOException -> L4a
            goto L4b
        L4a:
        L4b:
            java.lang.String r0 = ""
            if (r2 == 0) goto L50
            goto L18
        L50:
            java.lang.String r1 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "getCpuCurFreq() --> "
            java.lang.String r1 = r2.concat(r1)
            java.lang.String r2 = "BaseInfo.CoreInfo"
            com.jd.ad.sdk.jad_dq.jad_an.jad_an(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_gj.jad_an.jad_bo():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
    
        if (r2 == null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String jad_cp() {
        /*
            java.lang.String r0 = com.jd.ad.sdk.jad_an.jad_cp.jad_hu
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L59
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = "/proc/cpuinfo"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3c
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L36
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L36
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L29
            java.lang.String r3 = ":\\s+"
            r4 = 2
            java.lang.String[] r0 = r0.split(r3, r4)     // Catch: java.lang.Throwable -> L29
            int r3 = r0.length     // Catch: java.lang.Throwable -> L29
            if (r3 < r4) goto L2b
            r3 = 1
            r0 = r0[r3]     // Catch: java.lang.Throwable -> L29
            com.jd.ad.sdk.jad_an.jad_cp.jad_hu = r0     // Catch: java.lang.Throwable -> L29
            goto L2b
        L29:
            r0 = move-exception
            goto L32
        L2b:
            r1.close()     // Catch: java.io.IOException -> L2e
        L2e:
            r2.close()     // Catch: java.io.IOException -> L59
            goto L59
        L32:
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3e
        L36:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r1
            r1 = r5
            goto L3e
        L3c:
            r1 = move-exception
            r2 = r0
        L3e:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto L48
            r0.close()     // Catch: java.io.IOException -> L47
            goto L48
        L47:
        L48:
            if (r2 == 0) goto L59
            goto L2e
        L4b:
            r1 = move-exception
            if (r0 == 0) goto L53
            r0.close()     // Catch: java.io.IOException -> L52
            goto L53
        L52:
        L53:
            if (r2 == 0) goto L58
            r2.close()     // Catch: java.io.IOException -> L58
        L58:
            throw r1
        L59:
            java.lang.String r0 = com.jd.ad.sdk.jad_an.jad_cp.jad_hu
            java.lang.String r1 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "getCpuName() --> "
            java.lang.String r1 = r2.concat(r1)
            java.lang.String r2 = "BaseInfo.CoreInfo"
            com.jd.ad.sdk.jad_dq.jad_an.jad_an(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_gj.jad_an.jad_cp():java.lang.String");
    }

    public static String jad_dq() {
        String str;
        if (TextUtils.isEmpty(jad_cp.jad_jt)) {
            try {
                jad_cp.jad_jt = String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new com.jd.ad.sdk.jad_cp.jad_an()).length);
            } catch (Exception e) {
                if (com.jd.ad.sdk.jad_dq.jad_an.jad_cp) {
                    Log.e("DeviceInfo", "An exception happens when call getCPUNum()", e);
                }
                str = "1";
            }
        }
        str = jad_cp.jad_jt;
        com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getCPUNum() --> ".concat(String.valueOf(str)));
        return str;
    }

    public static String jad_er() {
        String str;
        if (TextUtils.isEmpty(jad_cp.jad_dq)) {
            if (TextUtils.isEmpty(jad_cp.jad_cp)) {
                jad_cp.jad_cp = com.jd.ad.sdk.jad_dq.jad_bo.jad_an(Build.BRAND, "");
            }
            if ("xiaomi".equalsIgnoreCase(jad_cp.jad_cp)) {
                try {
                    str = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "ro.product.marketname", "");
                } catch (Throwable th) {
                    com.jd.ad.sdk.jad_dq.jad_an.jad_cp("CoreInfo.SystemPropertyUtil", "An exception happends when call get(), key='ro.product.marketname':\n" + th.toString());
                    str = "";
                }
                jad_cp.jad_dq = str;
            }
            if (TextUtils.isEmpty(jad_cp.jad_dq)) {
                jad_cp.jad_dq = com.jd.ad.sdk.jad_dq.jad_bo.jad_an(Build.MODEL, "");
            }
        }
        String str2 = jad_cp.jad_dq;
        com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getModel() --> ".concat(String.valueOf(str2)));
        return str2;
    }

    public static String jad_fs() {
        String str;
        Context context = jad_an;
        String str2 = "";
        if (context == null) {
            str = "context is null";
        } else {
            try {
                str2 = com.jd.ad.sdk.jad_dq.jad_bo.jad_an(((TelephonyManager) context.getSystemService("phone")).getSimOperator(), "");
            } catch (Throwable th) {
                str = "DeviceInfo.getSimOperator() exception: " + th.getMessage();
            }
            com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getSimOperator() --> ".concat(String.valueOf(str2)));
            return str2;
        }
        com.jd.ad.sdk.jad_dq.jad_an.jad_cp("DeviceInfo", str);
        com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getSimOperator() --> ".concat(String.valueOf(str2)));
        return str2;
    }

    public static String jad_hu() {
        List<Sensor> sensorList = ((SensorManager) jad_an.getSystemService("sensor")).getSensorList(-1);
        com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getSensorList() --> ".concat(String.valueOf(sensorList)));
        if (sensorList == null || sensorList.size() <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer("");
        int size = sensorList.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append(sensorList.get(i).getName());
            if (i != size - 1) {
                stringBuffer.append(", ");
            }
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(2:2|3)|(2:29|30)|5|6|7|8|(8:10|(1:12)|13|14|(1:16)|(1:18)|21|22)|26|(0)|13|14|(0)|(0)|21|22) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0024 A[Catch: Exception -> 0x0043, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0043, blocks: (B:30:0x000c, B:12:0x0024, B:18:0x003c), top: B:29:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c A[Catch: Exception -> 0x0043, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0043, blocks: (B:30:0x000c, B:12:0x0024, B:18:0x003c), top: B:29:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String jad_iv() {
        /*
            android.content.Context r0 = com.jd.ad.sdk.jad_gj.jad_an.jad_an
            r1 = 0
            boolean r2 = android.os.Debug.isDebuggerConnected()     // Catch: java.lang.Exception -> L8
            goto La
        L8:
            r2 = 0
        La:
            if (r2 == 0) goto L13
            long r2 = com.jd.ad.sdk.jad_il.jad_an.jad_an     // Catch: java.lang.Exception -> L43
            r4 = 1
            long r2 = r2 | r4
            com.jd.ad.sdk.jad_il.jad_an.jad_an = r2     // Catch: java.lang.Exception -> L43
        L13:
            r2 = 1
            android.content.pm.ApplicationInfo r3 = r0.getApplicationInfo()     // Catch: java.lang.Exception -> L20
            int r3 = r3.flags     // Catch: java.lang.Exception -> L20
            r3 = r3 & 2
            if (r3 == 0) goto L21
            r3 = 1
            goto L22
        L20:
        L21:
            r3 = 0
        L22:
            if (r3 == 0) goto L2b
            long r3 = com.jd.ad.sdk.jad_il.jad_an.jad_an     // Catch: java.lang.Exception -> L43
            r5 = 2
            long r3 = r3 | r5
            com.jd.ad.sdk.jad_il.jad_an.jad_an = r3     // Catch: java.lang.Exception -> L43
        L2b:
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> L39
            java.lang.String r3 = "adb_enabled"
            int r0 = android.provider.Settings.Secure.getInt(r0, r3, r1)     // Catch: java.lang.Exception -> L39
            if (r0 <= 0) goto L3a
            r1 = 1
            goto L3a
        L39:
        L3a:
            if (r1 == 0) goto L43
            long r0 = com.jd.ad.sdk.jad_il.jad_an.jad_an     // Catch: java.lang.Exception -> L43
            r2 = 4
            long r0 = r0 | r2
            com.jd.ad.sdk.jad_il.jad_an.jad_an = r0     // Catch: java.lang.Exception -> L43
        L43:
            long r0 = com.jd.ad.sdk.jad_il.jad_an.jad_an
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_gj.jad_an.jad_iv():java.lang.String");
    }

    public static int jad_jt() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Context context = jad_an;
        if (context == null) {
            com.jd.ad.sdk.jad_dq.jad_an.jad_cp("AppInfo", "getRunningAppProcesses context is null");
            runningAppProcesses = new ArrayList<>();
        } else {
            runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
        }
        com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getRunningAppProcesses() --> ".concat(String.valueOf(runningAppProcesses)));
        if (runningAppProcesses != null) {
            return runningAppProcesses.size();
        }
        return 0;
    }

    public static String jad_jw() {
        Boolean bool;
        try {
            if (com.jd.ad.sdk.jad_il.jad_bo.jad_an(jad_an).booleanValue()) {
                com.jd.ad.sdk.jad_il.jad_bo.jad_an |= 2;
            }
            if (com.jd.ad.sdk.jad_il.jad_bo.jad_an().booleanValue()) {
                com.jd.ad.sdk.jad_il.jad_bo.jad_an |= 4;
            }
            try {
                try {
                    Class.forName("de.robv.android.xposed.XC_MethodHook");
                    bool = Boolean.TRUE;
                } catch (Exception unused) {
                    Class.forName(an.f18308a);
                    bool = Boolean.FALSE;
                }
            } catch (Exception unused2) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                com.jd.ad.sdk.jad_il.jad_bo.jad_an |= 8;
            }
            Boolean bool2 = Boolean.FALSE;
            try {
                if (System.getProperty("vxp") != null) {
                    bool2 = Boolean.TRUE;
                }
            } catch (Exception unused3) {
            }
            if (bool2.booleanValue()) {
                com.jd.ad.sdk.jad_il.jad_bo.jad_an |= 16;
            }
        } catch (Exception unused4) {
        }
        return String.valueOf(com.jd.ad.sdk.jad_il.jad_bo.jad_an);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a2, code lost:
    
        com.jd.ad.sdk.jad_il.jad_cp.jad_an |= 64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String jad_kx() {
        /*
            android.content.Context r0 = com.jd.ad.sdk.jad_gj.jad_an.jad_an
            boolean r1 = com.jd.ad.sdk.jad_il.jad_cp.jad_an(r0)     // Catch: java.lang.Exception -> Lad
            if (r1 == 0) goto Lf
            long r1 = com.jd.ad.sdk.jad_il.jad_cp.jad_an     // Catch: java.lang.Exception -> Lad
            r3 = 1
            long r1 = r1 | r3
            com.jd.ad.sdk.jad_il.jad_cp.jad_an = r1     // Catch: java.lang.Exception -> Lad
        Lf:
            java.io.File r1 = r0.getFilesDir()     // Catch: java.lang.Exception -> Lad
            java.lang.String r1 = r1.getPath()     // Catch: java.lang.Exception -> Lad
            java.lang.String[] r2 = com.jd.ad.sdk.jad_il.jad_cp.jad_cp     // Catch: java.lang.Exception -> Lad
            int r3 = r2.length     // Catch: java.lang.Exception -> Lad
            r4 = 0
            r5 = 0
        L1c:
            if (r5 >= r3) goto L31
            r6 = r2[r5]     // Catch: java.lang.Exception -> Lad
            boolean r6 = r1.contains(r6)     // Catch: java.lang.Exception -> Lad
            if (r6 == 0) goto L2e
            long r1 = com.jd.ad.sdk.jad_il.jad_cp.jad_an     // Catch: java.lang.Exception -> Lad
            r5 = 2
            long r1 = r1 | r5
            com.jd.ad.sdk.jad_il.jad_cp.jad_an = r1     // Catch: java.lang.Exception -> Lad
            goto L31
        L2e:
            int r5 = r5 + 1
            goto L1c
        L31:
            boolean r1 = com.jd.ad.sdk.jad_il.jad_cp.jad_an()     // Catch: java.lang.Exception -> Lad
            if (r1 == 0) goto L3e
            long r1 = com.jd.ad.sdk.jad_il.jad_cp.jad_an     // Catch: java.lang.Exception -> Lad
            r5 = 4
            long r1 = r1 | r5
            com.jd.ad.sdk.jad_il.jad_cp.jad_an = r1     // Catch: java.lang.Exception -> Lad
        L3e:
            android.net.LocalServerSocket r1 = com.jd.ad.sdk.jad_il.jad_cp.jad_bo     // Catch: java.lang.Exception -> Lad
            if (r1 == 0) goto L43
            goto L56
        L43:
            android.net.LocalServerSocket r1 = new android.net.LocalServerSocket     // Catch: java.io.IOException -> L4f java.lang.Exception -> Lad
            java.lang.String r2 = r0.getPackageName()     // Catch: java.io.IOException -> L4f java.lang.Exception -> Lad
            r1.<init>(r2)     // Catch: java.io.IOException -> L4f java.lang.Exception -> Lad
            com.jd.ad.sdk.jad_il.jad_cp.jad_bo = r1     // Catch: java.io.IOException -> L4f java.lang.Exception -> Lad
            goto L56
        L4f:
            long r1 = com.jd.ad.sdk.jad_il.jad_cp.jad_an     // Catch: java.lang.Exception -> Lad
            r5 = 16
            long r1 = r1 | r5
            com.jd.ad.sdk.jad_il.jad_cp.jad_an = r1     // Catch: java.lang.Exception -> Lad
        L56:
            java.lang.String r1 = r0.getPackageName()     // Catch: java.lang.Exception -> Lad
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> Lad
            if (r2 == 0) goto L61
            goto L80
        L61:
            java.lang.String r2 = "com.jingdong.app.mall"
            boolean r2 = r1.equals(r2)     // Catch: java.lang.Exception -> Lad
            if (r2 != 0) goto L79
            java.lang.String r2 = "com.jd.pingou"
            boolean r2 = r1.equals(r2)     // Catch: java.lang.Exception -> Lad
            if (r2 != 0) goto L79
            java.lang.String r2 = "com.jd.jdlite"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> Lad
            if (r1 == 0) goto L80
        L79:
            long r1 = com.jd.ad.sdk.jad_il.jad_cp.jad_an     // Catch: java.lang.Exception -> Lad
            r5 = 32
            long r1 = r1 | r5
            com.jd.ad.sdk.jad_il.jad_cp.jad_an = r1     // Catch: java.lang.Exception -> Lad
        L80:
            java.util.List r0 = com.jd.ad.sdk.jad_hk.jad_an.jad_an(r0)     // Catch: java.lang.Exception -> Lad
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> Lad
        L88:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Exception -> Lad
            if (r1 == 0) goto Lad
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Exception -> Lad
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> Lad
            java.lang.String[] r2 = com.jd.ad.sdk.jad_il.jad_cp.jad_cp     // Catch: java.lang.Exception -> Lad
            int r3 = r2.length     // Catch: java.lang.Exception -> Lad
            r5 = 0
        L98:
            if (r5 >= r3) goto L88
            r6 = r2[r5]     // Catch: java.lang.Exception -> Lad
            boolean r6 = r1.contains(r6)     // Catch: java.lang.Exception -> Lad
            if (r6 == 0) goto Laa
            long r0 = com.jd.ad.sdk.jad_il.jad_cp.jad_an     // Catch: java.lang.Exception -> Lad
            r2 = 64
            long r0 = r0 | r2
            com.jd.ad.sdk.jad_il.jad_cp.jad_an = r0     // Catch: java.lang.Exception -> Lad
            goto Lad
        Laa:
            int r5 = r5 + 1
            goto L98
        Lad:
            long r0 = com.jd.ad.sdk.jad_il.jad_cp.jad_an
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_gj.jad_an.jad_kx():java.lang.String");
    }

    public static boolean jad_ly() {
        try {
            return ((KeyguardManager) jad_an.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Exception e) {
            com.jd.ad.sdk.jad_dq.jad_an.jad_bo("AntiSDK", e.getMessage());
            return false;
        }
    }

    public static boolean jad_mz() {
        try {
            return !((PowerManager) jad_an.getSystemService("power")).isScreenOn();
        } catch (Exception e) {
            com.jd.ad.sdk.jad_dq.jad_an.jad_bo("AntiSDK", e.getMessage());
            return false;
        }
    }
}
