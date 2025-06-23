package com.jd.ad.sdk.jad_ob;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.jd.ad.sdk.jad_mz.jad_dq;
import com.jd.ad.sdk.jad_ob.jad_dq;
import com.jd.ad.sdk.jad_sf.jad_an;

/* loaded from: classes10.dex */
public class jad_an {
    public static int jad_an(Context context) {
        try {
            if (!jad_na() && jad_dq.jad_an.jad_an.jad_an("sl") && context != null) {
                return com.jd.ad.sdk.jad_gj.jad_an.jad_ly() ? 1 : 0;
            }
        } catch (Exception unused) {
        }
        return -1;
    }

    public static int jad_bo(Context context) {
        try {
            if (!jad_na() && jad_dq.jad_an.jad_an.jad_an("sof") && context != null) {
                return !com.jd.ad.sdk.jad_gj.jad_an.jad_mz() ? 1 : 0;
            }
        } catch (Exception unused) {
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
    
        if (android.text.TextUtils.isEmpty(r2) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String jad_cp() {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "bluetoothName"
            java.lang.String r2 = "NA"
            boolean r3 = jad_na()     // Catch: java.lang.Exception -> L4e
            if (r3 == 0) goto Ld
            return r2
        Ld:
            com.jd.ad.sdk.jad_ob.jad_dq r3 = com.jd.ad.sdk.jad_ob.jad_dq.jad_an.jad_an     // Catch: java.lang.Exception -> L4e
            boolean r3 = r3.jad_an(r1)     // Catch: java.lang.Exception -> L4e
            if (r3 != 0) goto L16
            return r2
        L16:
            com.jd.ad.sdk.jad_sf.jad_an r3 = com.jd.ad.sdk.jad_sf.jad_an.jad_bo.jad_an     // Catch: java.lang.Exception -> L4e
            r4 = 1
            boolean r4 = r3.jad_an(r1, r4)     // Catch: java.lang.Exception -> L4e
            if (r4 == 0) goto L24
            java.lang.String r0 = r3.jad_dq(r1)     // Catch: java.lang.Exception -> L4e
            goto L4f
        L24:
            android.bluetooth.BluetoothAdapter r2 = android.bluetooth.BluetoothAdapter.getDefaultAdapter()     // Catch: java.lang.Exception -> L36
            if (r2 == 0) goto L2f
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Exception -> L36
            goto L30
        L2f:
            r2 = r0
        L30:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L36
            if (r3 == 0) goto L37
        L36:
            r2 = r0
        L37:
            java.lang.String r3 = "getBluetoothName() --> "
            java.lang.String r4 = "BaseInfo.CoreInfo"
            java.lang.String r5 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L47
            java.lang.String r3 = r3.concat(r5)     // Catch: java.lang.Exception -> L47
            com.jd.ad.sdk.jad_dq.jad_an.jad_an(r4, r3)     // Catch: java.lang.Exception -> L47
            r0 = r2
        L47:
            com.jd.ad.sdk.jad_sf.jad_an r2 = com.jd.ad.sdk.jad_sf.jad_an.jad_bo.jad_an     // Catch: java.lang.Exception -> L4d
            r2.jad_bo(r1, r0)     // Catch: java.lang.Exception -> L4f
            goto L4f
        L4d:
            r2 = r0
        L4e:
            r0 = r2
        L4f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_ob.jad_an.jad_cp():java.lang.String");
    }

    public static String jad_dq() {
        try {
            if (jad_na() || !jad_dq.jad_an.jad_an.jad_an("bootloader")) {
                return "";
            }
            com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("bootloader", true)) {
                return (String) jad_anVar.jad_bo("bootloader");
            }
            if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_cp.jad_fs)) {
                com.jd.ad.sdk.jad_an.jad_cp.jad_fs = com.jd.ad.sdk.jad_dq.jad_bo.jad_an(Build.BOOTLOADER, "");
            }
            String str = com.jd.ad.sdk.jad_an.jad_cp.jad_fs;
            com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getBootloaderVersion() --> ".concat(String.valueOf(str)));
            try {
                jad_anVar.jad_bo("bootloader", str);
            } catch (Exception unused) {
            }
            return str;
        } catch (Exception unused2) {
            return "";
        }
    }

    public static String jad_er() {
        try {
            if (jad_na() || !jad_dq.jad_an.jad_an.jad_an("brand")) {
                return "NA";
            }
            com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("brand", true)) {
                return jad_anVar.jad_dq("brand");
            }
            if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_cp.jad_cp)) {
                com.jd.ad.sdk.jad_an.jad_cp.jad_cp = com.jd.ad.sdk.jad_dq.jad_bo.jad_an(Build.BRAND, "");
            }
            String str = com.jd.ad.sdk.jad_an.jad_cp.jad_cp;
            com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getBrand() --> ".concat(String.valueOf(str)));
            try {
                jad_anVar.jad_bo("brand", str);
            } catch (Exception unused) {
            }
            return str;
        } catch (Exception unused2) {
            return "NA";
        }
    }

    public static String jad_fs() {
        try {
            if (jad_na() || !jad_dq.jad_an.jad_an.jad_an("devicename")) {
                return "NA";
            }
            com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("devicename", true)) {
                return jad_anVar.jad_dq("devicename");
            }
            if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_cp.jad_an)) {
                com.jd.ad.sdk.jad_an.jad_cp.jad_an = com.jd.ad.sdk.jad_dq.jad_bo.jad_an(Build.DEVICE, "");
            }
            String str = com.jd.ad.sdk.jad_an.jad_cp.jad_an;
            com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getDeviceName() --> ".concat(String.valueOf(str)));
            try {
                jad_anVar.jad_bo("devicename", str);
            } catch (Exception unused) {
            }
            return str;
        } catch (Exception unused2) {
            return "NA";
        }
    }

    public static String jad_hu() {
        String str = "NA";
        if (jad_na() || !jad_dq.jad_an.jad_an.jad_an("launcher")) {
            return "NA";
        }
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("launcher", true)) {
            return jad_anVar.jad_dq("launcher");
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = com.jd.ad.sdk.jad_gj.jad_an.jad_an.getPackageManager().resolveActivity(intent, 0);
        String str2 = "";
        if (resolveActivity != null) {
            String str3 = resolveActivity.activityInfo.packageName;
            int i = com.jd.ad.sdk.jad_hk.jad_bo.jad_an;
            if (str3 != null) {
                str2 = str3;
            }
        }
        str = str2;
        jad_anVar.jad_bo("launcher", str);
        return str;
    }

    public static String jad_iv() {
        try {
            if (jad_na() || !jad_dq.jad_an.jad_an.jad_an("make")) {
                return "";
            }
            com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("make", true)) {
                return jad_anVar.jad_dq("make");
            }
            if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_cp.jad_bo)) {
                com.jd.ad.sdk.jad_an.jad_cp.jad_bo = com.jd.ad.sdk.jad_dq.jad_bo.jad_an(Build.MANUFACTURER, "");
            }
            String str = com.jd.ad.sdk.jad_an.jad_cp.jad_bo;
            com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getManufacture() --> ".concat(String.valueOf(str)));
            try {
                jad_anVar.jad_bo("make", str);
            } catch (Exception unused) {
            }
            return str;
        } catch (Exception unused2) {
            return "";
        }
    }

    public static String jad_jt() {
        try {
            if (jad_na() || !jad_dq.jad_an.jad_an.jad_an("hardware")) {
                return "";
            }
            com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("hardware", true)) {
                return jad_anVar.jad_dq("hardware");
            }
            if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_cp.jad_er)) {
                com.jd.ad.sdk.jad_an.jad_cp.jad_er = com.jd.ad.sdk.jad_dq.jad_bo.jad_an(Build.HARDWARE, "");
            }
            String str = com.jd.ad.sdk.jad_an.jad_cp.jad_er;
            com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getHardwareName() --> ".concat(String.valueOf(str)));
            try {
                jad_anVar.jad_bo("hardware", str);
            } catch (Exception unused) {
            }
            return str;
        } catch (Exception unused2) {
            return "";
        }
    }

    public static String jad_jw() {
        String str = "";
        if (jad_na() || !jad_dq.jad_an.jad_an.jad_an("model")) {
            return "";
        }
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("model", true)) {
            return jad_anVar.jad_dq("model");
        }
        str = com.jd.ad.sdk.jad_gj.jad_an.jad_er();
        jad_anVar.jad_bo("model", str);
        return str;
    }

    public static String jad_kx() {
        try {
            if (!jad_dq.jad_an.jad_an.jad_an("soaid")) {
                return "NA";
            }
            return com.jd.ad.sdk.jad_jw.jad_an.jad_an;
        } catch (Exception unused) {
            return "NA";
        }
    }

    public static String jad_ly() {
        int i;
        String str = "NA";
        if (jad_na() || !jad_dq.jad_an.jad_an.jad_an("brightness")) {
            return "NA";
        }
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("brightness", true)) {
            return jad_anVar.jad_dq("brightness");
        }
        try {
            i = Settings.System.getInt(com.jd.ad.sdk.jad_gj.jad_an.jad_an.getContentResolver(), "screen_brightness");
        } catch (Exception e) {
            com.jd.ad.sdk.jad_dq.jad_an.jad_bo("AntiSDK", e.getMessage());
            i = 0;
        }
        str = String.valueOf(i);
        jad_an.jad_bo.jad_an.jad_bo("brightness", str);
        return str;
    }

    public static String jad_mz() {
        int i;
        WifiInfo connectionInfo;
        String str = "NA";
        if (jad_na() || !jad_dq.jad_an.jad_an.jad_an("rssi")) {
            return "NA";
        }
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("rssi", true)) {
            return jad_anVar.jad_dq("rssi");
        }
        try {
            WifiManager wifiManager = (WifiManager) com.jd.ad.sdk.jad_gj.jad_an.jad_an.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                i = connectionInfo.getRssi();
            } else {
                i = 0;
            }
            com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getWifiRssi() --> ".concat(String.valueOf(i)));
        } catch (SecurityException unused) {
            i = -127;
        }
        str = String.valueOf(i);
        jad_an.jad_bo.jad_an.jad_bo("rssi", str);
        return str;
    }

    public static boolean jad_na() {
        return jad_dq.jad_an.jad_an.jad_an(11, (String) null);
    }

    public static int jad_ob() {
        try {
            if (jad_na()) {
                return -1;
            }
            if (!jad_dq.jad_an.jad_an.jad_an("af")) {
                return -1;
            }
            return 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String jad_pc() {
        String str = "NA";
        if (jad_na() || !jad_dq.jad_an.jad_an.jad_an("isDebug")) {
            return "NA";
        }
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("isDebug", true)) {
            return jad_anVar.jad_dq("isDebug");
        }
        str = com.jd.ad.sdk.jad_gj.jad_an.jad_iv();
        jad_anVar.jad_bo("isDebug", str);
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int, boolean] */
    public static int jad_qd() {
        int i = -1;
        if (jad_na() || !jad_dq.jad_an.jad_an.jad_an("jailbreak")) {
            return -1;
        }
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("jailbreak", true)) {
            return jad_anVar.jad_cp("jailbreak");
        }
        i = com.jd.ad.sdk.jad_an.jad_an.jad_cp();
        jad_anVar.jad_bo("jailbreak", Integer.valueOf((int) i));
        return i;
    }

    public static String jad_re() {
        String str = "NA";
        if (jad_na() || !jad_dq.jad_an.jad_an.jad_an("isHooked")) {
            return "NA";
        }
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("isHooked", true)) {
            return jad_anVar.jad_dq("isHooked");
        }
        str = com.jd.ad.sdk.jad_gj.jad_an.jad_jw();
        jad_anVar.jad_bo("isHooked", str);
        return str;
    }

    public static String jad_sf() {
        String str = "NA";
        if (jad_na() || !jad_dq.jad_an.jad_an.jad_an("isMoreOpen")) {
            return "NA";
        }
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("isMoreOpen", true)) {
            return jad_anVar.jad_dq("isMoreOpen");
        }
        str = com.jd.ad.sdk.jad_gj.jad_an.jad_kx();
        jad_anVar.jad_bo("isMoreOpen", str);
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0056, code lost:
    
        if (r2.getType() == 17) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String jad_tg() {
        /*
            java.lang.String r0 = "vpnConnect"
            java.lang.String r1 = "NA"
            boolean r2 = jad_na()     // Catch: java.lang.Exception -> L65
            if (r2 == 0) goto Lb
            return r1
        Lb:
            com.jd.ad.sdk.jad_ob.jad_dq r2 = com.jd.ad.sdk.jad_ob.jad_dq.jad_an.jad_an     // Catch: java.lang.Exception -> L65
            boolean r2 = r2.jad_an(r0)     // Catch: java.lang.Exception -> L65
            if (r2 != 0) goto L14
            return r1
        L14:
            com.jd.ad.sdk.jad_sf.jad_an r2 = com.jd.ad.sdk.jad_sf.jad_an.jad_bo.jad_an     // Catch: java.lang.Exception -> L65
            r3 = 1
            boolean r3 = r2.jad_an(r0, r3)     // Catch: java.lang.Exception -> L65
            if (r3 == 0) goto L22
            java.lang.String r0 = r2.jad_dq(r0)     // Catch: java.lang.Exception -> L65
            goto L66
        L22:
            android.content.Context r2 = com.jd.ad.sdk.jad_gj.jad_an.jad_an     // Catch: java.lang.Exception -> L46
            java.lang.String r3 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r3)     // Catch: java.lang.Exception -> L46
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2     // Catch: java.lang.Exception -> L46
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L46
            r4 = 23
            if (r3 < r4) goto L48
            if (r2 == 0) goto L5e
            android.net.Network r3 = androidx.work.impl.utils.OOXIXo.oIX0oI(r2)     // Catch: java.lang.Exception -> L46
            android.net.NetworkCapabilities r2 = r2.getNetworkCapabilities(r3)     // Catch: java.lang.Exception -> L46
            if (r2 == 0) goto L5e
            r3 = 4
            boolean r2 = r2.hasTransport(r3)     // Catch: java.lang.Exception -> L46
            if (r2 == 0) goto L5e
            goto L58
        L46:
            r2 = move-exception
            goto L5b
        L48:
            if (r2 == 0) goto L5e
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()     // Catch: java.lang.Exception -> L46
            if (r2 == 0) goto L5e
            int r2 = r2.getType()     // Catch: java.lang.Exception -> L46
            r3 = 17
            if (r2 != r3) goto L5e
        L58:
            java.lang.String r1 = "1"
            goto L60
        L5b:
            r2.printStackTrace()     // Catch: java.lang.Exception -> L65
        L5e:
            java.lang.String r1 = "0"
        L60:
            com.jd.ad.sdk.jad_sf.jad_an r2 = com.jd.ad.sdk.jad_sf.jad_an.jad_bo.jad_an     // Catch: java.lang.Exception -> L65
            r2.jad_bo(r0, r1)     // Catch: java.lang.Exception -> L65
        L65:
            r0 = r1
        L66:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_ob.jad_an.jad_tg():java.lang.String");
    }

    public static String jad_an() {
        String str = "NA";
        if (jad_na() || !jad_dq.jad_an.jad_an.jad_an("packagename")) {
            return "NA";
        }
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("packagename", true)) {
            str = jad_anVar.jad_dq("packagename");
        } else {
            String jad_an = com.jd.ad.sdk.jad_an.jad_bo.jad_an(com.jd.ad.sdk.jad_gj.jad_an.jad_an);
            com.jd.ad.sdk.jad_dq.jad_an.jad_an("BaseInfo.CoreInfo", "getPackageName() --> ".concat(String.valueOf(jad_an)));
            try {
                jad_anVar.jad_bo("packagename", jad_an);
            } catch (Exception unused) {
            }
            str = jad_an;
        }
        return str;
    }

    public static String jad_bo() {
        String str = "NA";
        if (jad_na() || !jad_dq.jad_an.jad_an.jad_an("batteryVoltage")) {
            return "NA";
        }
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("batteryVoltage", true)) {
            return jad_anVar.jad_dq("batteryVoltage");
        }
        int i = -1;
        try {
            if (com.jd.ad.sdk.jad_gj.jad_an.jad_an != null) {
                i = com.jd.ad.sdk.jad_gj.jad_an.jad_an.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("voltage", -1);
            }
        } catch (Throwable unused) {
        }
        str = String.valueOf(i);
        jad_an.jad_bo.jad_an.jad_bo("batteryVoltage", str);
        return str;
    }
}
