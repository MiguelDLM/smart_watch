package com.baidu.location.c.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.DhcpInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.location.c.k;
import com.baidu.location.c.p;
import com.huawei.openalliance.ad.constant.x;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class d implements com.baidu.location.c.b.a {
    private Context h;
    private boolean b = false;
    private WifiManager e = null;
    private b f = null;
    private p g = null;
    private int i = 2000;

    /* renamed from: a, reason: collision with root package name */
    public long f5688a = 0;
    private long j = 0;
    private long k = 0;
    private long l = 0;
    private String m = null;
    private final Object n = new Object();
    private final Object o = new Object();
    private Handler p = null;
    private String q = null;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static d f5689a = new d();
    }

    /* loaded from: classes7.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null) {
                return;
            }
            if ((!com.baidu.location.c.b.a.d || k.h().a(intent)) && intent.getAction().equals("android.net.wifi.SCAN_RESULTS")) {
                d.this.f5688a = System.currentTimeMillis() / 1000;
                d.this.p.post(new f(this));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void g() {
        /*
            r5 = this;
            android.net.wifi.WifiManager r0 = r5.e     // Catch: java.lang.Exception -> L11
            boolean r0 = r0.isWifiEnabled()     // Catch: java.lang.Exception -> L11
            if (r0 != 0) goto L13
            android.net.wifi.WifiManager r0 = r5.e     // Catch: java.lang.Exception -> L11
            boolean r0 = r0.isScanAlwaysAvailable()     // Catch: java.lang.Exception -> L11
            if (r0 == 0) goto L2e
            goto L13
        L11:
            r0 = move-exception
            goto L2b
        L13:
            android.net.wifi.WifiManager r0 = r5.e     // Catch: java.lang.Exception -> L11
            r0.startScan()     // Catch: java.lang.Exception -> L11
            boolean r0 = com.baidu.location.c.b.a.c     // Catch: java.lang.Exception -> L11
            if (r0 == 0) goto L2e
            boolean r0 = com.baidu.location.c.b.a.d     // Catch: java.lang.Exception -> L11
            if (r0 == 0) goto L2e
            com.baidu.location.c.g r0 = com.baidu.location.c.k.h()     // Catch: java.lang.Exception -> L11
            java.lang.String r1 = "wifimanager start scan ..."
            r0.a(r1)     // Catch: java.lang.Exception -> L11
            goto L2e
        L2b:
            r0.printStackTrace()
        L2e:
            long r0 = java.lang.System.currentTimeMillis()
            r5.j = r0
            java.lang.Object r0 = r5.n
            monitor-enter(r0)
            int r1 = r5.i     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            if (r1 == 0) goto L48
            java.lang.Object r2 = r5.n     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            long r3 = (long) r1     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            r2.wait(r3)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            goto L48
        L42:
            r1 = move-exception
            goto L4a
        L44:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L42
        L48:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L42
            return
        L4a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L42
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.d.g():void");
    }

    private String h() {
        DhcpInfo dhcpInfo;
        WifiManager wifiManager = this.e;
        if (wifiManager != null && (dhcpInfo = wifiManager.getDhcpInfo()) != null) {
            return b(dhcpInfo.gateway);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        WifiManager wifiManager = this.e;
        if (wifiManager == null) {
            return;
        }
        try {
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long currentTimeMillis = System.currentTimeMillis();
                if (scanResults != null && scanResults.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    long j = 0;
                    for (int i = 0; i < scanResults.size(); i++) {
                        if (i == 0) {
                            try {
                                j = (currentTimeMillis - scanResults.get(0).timestamp) / 1000000;
                            } catch (Exception e) {
                                e.printStackTrace();
                                j = 0;
                            }
                            sb.append(scanResults.get(0).BSSID + x.aL + Math.abs(scanResults.get(0).level) + x.aL + scanResults.get(0).SSID.trim() + x.aL + scanResults.get(0).frequency + x.aL + j + "|");
                        }
                        sb.append(scanResults.get(i).BSSID + x.aL + Math.abs(scanResults.get(i).level) + x.aL + scanResults.get(i).SSID.trim() + x.aL + scanResults.get(i).frequency + x.aL + (((currentTimeMillis - scanResults.get(i).timestamp) / 1000000) - j) + "|");
                    }
                    sb.append("\t");
                    sb.append(simpleDateFormat.format(new Date(currentTimeMillis)));
                    sb.append("\t");
                    sb.append(currentTimeMillis);
                    sb.append("\tnull\n");
                    k.h().a(sb.toString());
                }
            }
            if (scanResults != null) {
                p pVar = new p(scanResults, System.currentTimeMillis());
                synchronized (this.o) {
                    try {
                        p pVar2 = this.g;
                        if (pVar2 != null) {
                            if (!a(pVar, pVar2)) {
                            }
                        }
                        this.g = pVar;
                    } finally {
                    }
                }
            }
        } catch (Exception e2) {
            if (com.baidu.location.c.b.a.c) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0031 -> B:15:0x0036). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0033 -> B:15:0x0036). Please report as a decompilation issue!!! */
    public p d() {
        p a2;
        synchronized (this.o) {
            a2 = a(this.g);
        }
        if (a2 == null || !a2.b()) {
            try {
                WifiManager wifiManager = this.e;
                if (wifiManager != null) {
                    a2 = new p(wifiManager.getScanResults(), this.j);
                } else {
                    a2 = new p(null, 0L);
                }
            } catch (Exception e) {
                if (com.baidu.location.c.b.a.c) {
                    e.printStackTrace();
                }
            }
        }
        return a2;
    }

    public String e() {
        StringBuffer stringBuffer = new StringBuffer();
        WifiInfo f = a().f();
        String a2 = a(f, (String) null);
        if (f == null || a2 == null) {
            return null;
        }
        String replace = a2.replace(":", "");
        int rssi = f.getRssi();
        String h = a().h();
        if (rssi < 0) {
            rssi = -rssi;
        }
        if (replace == null || rssi >= 100 || "020000000000".equals(replace)) {
            return null;
        }
        stringBuffer.append("&wf=");
        stringBuffer.append(replace);
        stringBuffer.append(x.aL);
        stringBuffer.append("" + rssi + x.aL);
        String ssid = f.getSSID();
        if (ssid != null && (ssid.contains("&") || ssid.contains(x.aL))) {
            ssid = ssid.replace("&", "_");
        }
        stringBuffer.append(ssid);
        stringBuffer.append("&wf_n=1");
        if (h != null) {
            stringBuffer.append("&wf_gw=");
            stringBuffer.append(h);
        }
        return stringBuffer.toString();
    }

    public WifiInfo f() {
        WifiInfo wifiInfo;
        try {
            WifiManager wifiManager = this.e;
            if (wifiManager != null) {
                wifiInfo = wifiManager.getConnectionInfo();
            } else {
                wifiInfo = null;
            }
            String a2 = a(wifiInfo, (String) null);
            if (wifiInfo != null && a2 != null && wifiInfo.getRssi() > -100) {
                String replace = a2.replace(":", "");
                if (!"000000000000".equals(replace) && !"".equals(replace)) {
                    if (!"020000000000".equals(replace)) {
                        return wifiInfo;
                    }
                }
            }
        } catch (Error | Exception unused) {
        }
        return null;
    }

    public static d a() {
        return a.f5689a;
    }

    public void b() {
        if (this.b) {
            try {
                this.h.unregisterReceiver(this.f);
                this.f5688a = 0L;
            } catch (Exception e) {
                if (com.baidu.location.c.b.a.c) {
                    e.printStackTrace();
                }
            }
            this.f = null;
            this.e = null;
            this.b = false;
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                k.h().a("wifimanager stop ...");
            }
        }
    }

    public long c() {
        return this.j;
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(Context context, List<String> list) {
        if (this.b) {
            return;
        }
        this.h = context;
        this.e = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        this.f = new b();
        if (this.p == null) {
            this.p = new Handler(Looper.getMainLooper());
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (!list.contains("android.net.wifi.SCAN_RESULTS")) {
            list.add("android.net.wifi.SCAN_RESULTS");
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.h.registerReceiver(this.f, new IntentFilter(it.next()));
            }
        } catch (Exception e) {
            if (com.baidu.location.c.b.a.c) {
                e.printStackTrace();
            }
        }
        this.b = true;
        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
            k.h().a("wifimanager start ...");
        }
    }

    private String b(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf((int) (j & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 8) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 16) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 24) & 255)));
        return stringBuffer.toString();
    }

    public static boolean a(p pVar, p pVar2, float f) {
        if (pVar != null && pVar2 != null) {
            List<ScanResult> list = pVar.f5714a;
            List<ScanResult> list2 = pVar2.f5714a;
            if (list == list2) {
                return true;
            }
            if (list != null && list2 != null) {
                int size = list.size();
                int size2 = list2.size();
                if (size == 0 && size2 == 0) {
                    return true;
                }
                if (size != 0 && size2 != 0) {
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        String str = list.get(i2) != null ? list.get(i2).BSSID : null;
                        if (str != null) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= size2) {
                                    break;
                                }
                                String str2 = list2.get(i3) != null ? list2.get(i3).BSSID : null;
                                if (str2 != null && str.equals(str2)) {
                                    i++;
                                    break;
                                }
                                i3++;
                            }
                        }
                    }
                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                        k.h().a("wifi same!" + (i / size));
                    }
                    if (i >= size * f) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private String b(String str) {
        return str != null ? (str.contains("&") || str.contains(x.aL)) ? str.replace("&", "_").replace(x.aL, "_") : str : str;
    }

    public p a(long j) {
        if (this.e != null && j < 2147483647L) {
            boolean z = com.baidu.location.c.b.a.c;
            if (z && com.baidu.location.c.b.a.d) {
                k.h().a("Wi-Fi diffTime = " + j + "mLastDiffTime = " + this.k);
            }
            if (j == this.k) {
                if (z && com.baidu.location.c.b.a.d) {
                    k.h().a("System.currentTimeMillis() = " + System.currentTimeMillis() + "wifi diffTime = " + j + ", mScanTime = " + this.j);
                }
                if (System.currentTimeMillis() - this.j > j) {
                    if (z && com.baidu.location.c.b.a.d) {
                        k.h().a("time is over");
                    }
                    g();
                }
            } else {
                if (z && com.baidu.location.c.b.a.d) {
                    k.h().a("diffTime is changed");
                }
                g();
            }
        }
        this.k = j;
        return this.g;
    }

    private p a(p pVar) {
        if (pVar != null) {
            return new p(pVar.f5714a, pVar.b);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01bf A[Catch: Error -> 0x0114, Exception -> 0x0123, TryCatch #11 {Error -> 0x0114, blocks: (B:146:0x0102, B:149:0x0127, B:151:0x012b, B:153:0x012f, B:154:0x0155, B:157:0x0162, B:44:0x0184, B:141:0x01b2, B:48:0x01b7, B:49:0x01c5, B:51:0x01d1, B:54:0x01e8, B:58:0x01f4, B:60:0x0202, B:62:0x0208, B:128:0x01bf, B:165:0x011b, B:167:0x011f), top: B:145:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0346 A[EDGE_INSN: B:172:0x0346->B:173:0x0346 BREAK  A[LOOP:0: B:35:0x00d7->B:82:0x033c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0353 A[Catch: Exception -> 0x021e, Error -> 0x0221, TryCatch #8 {Error -> 0x0221, blocks: (B:65:0x0214, B:72:0x0232, B:74:0x0238, B:76:0x0244, B:78:0x0254, B:82:0x033c, B:88:0x02d0, B:90:0x02d4, B:96:0x0289, B:98:0x028f, B:100:0x029b, B:102:0x02ab, B:106:0x02dc, B:108:0x02e4, B:110:0x02e8, B:111:0x030b, B:173:0x0346, B:175:0x0353, B:178:0x0372, B:180:0x037a, B:182:0x0385, B:185:0x0397, B:186:0x03a1, B:188:0x03ad, B:191:0x03c1, B:196:0x03e2, B:200:0x039e, B:205:0x03ea, B:207:0x0402, B:211:0x0415, B:214:0x042f, B:216:0x0435, B:218:0x0444, B:219:0x045c, B:221:0x0462, B:223:0x046a, B:225:0x0487, B:226:0x0473, B:228:0x0481, B:232:0x048b, B:234:0x048f, B:236:0x0493, B:237:0x04b0, B:238:0x04b7, B:240:0x04d7, B:242:0x04e6, B:243:0x04f0), top: B:64:0x0214 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03ea A[Catch: Exception -> 0x021e, Error -> 0x0221, TryCatch #8 {Error -> 0x0221, blocks: (B:65:0x0214, B:72:0x0232, B:74:0x0238, B:76:0x0244, B:78:0x0254, B:82:0x033c, B:88:0x02d0, B:90:0x02d4, B:96:0x0289, B:98:0x028f, B:100:0x029b, B:102:0x02ab, B:106:0x02dc, B:108:0x02e4, B:110:0x02e8, B:111:0x030b, B:173:0x0346, B:175:0x0353, B:178:0x0372, B:180:0x037a, B:182:0x0385, B:185:0x0397, B:186:0x03a1, B:188:0x03ad, B:191:0x03c1, B:196:0x03e2, B:200:0x039e, B:205:0x03ea, B:207:0x0402, B:211:0x0415, B:214:0x042f, B:216:0x0435, B:218:0x0444, B:219:0x045c, B:221:0x0462, B:223:0x046a, B:225:0x0487, B:226:0x0473, B:228:0x0481, B:232:0x048b, B:234:0x048f, B:236:0x0493, B:237:0x04b0, B:238:0x04b7, B:240:0x04d7, B:242:0x04e6, B:243:0x04f0), top: B:64:0x0214 }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x04f5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b7 A[Catch: Error -> 0x0114, Exception -> 0x0123, TryCatch #11 {Error -> 0x0114, blocks: (B:146:0x0102, B:149:0x0127, B:151:0x012b, B:153:0x012f, B:154:0x0155, B:157:0x0162, B:44:0x0184, B:141:0x01b2, B:48:0x01b7, B:49:0x01c5, B:51:0x01d1, B:54:0x01e8, B:58:0x01f4, B:60:0x0202, B:62:0x0208, B:128:0x01bf, B:165:0x011b, B:167:0x011f), top: B:145:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01d1 A[Catch: Error -> 0x0114, Exception -> 0x0123, TryCatch #11 {Error -> 0x0114, blocks: (B:146:0x0102, B:149:0x0127, B:151:0x012b, B:153:0x012f, B:154:0x0155, B:157:0x0162, B:44:0x0184, B:141:0x01b2, B:48:0x01b7, B:49:0x01c5, B:51:0x01d1, B:54:0x01e8, B:58:0x01f4, B:60:0x0202, B:62:0x0208, B:128:0x01bf, B:165:0x011b, B:167:0x011f), top: B:145:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02d4 A[Catch: Exception -> 0x021e, Error -> 0x0221, TryCatch #8 {Error -> 0x0221, blocks: (B:65:0x0214, B:72:0x0232, B:74:0x0238, B:76:0x0244, B:78:0x0254, B:82:0x033c, B:88:0x02d0, B:90:0x02d4, B:96:0x0289, B:98:0x028f, B:100:0x029b, B:102:0x02ab, B:106:0x02dc, B:108:0x02e4, B:110:0x02e8, B:111:0x030b, B:173:0x0346, B:175:0x0353, B:178:0x0372, B:180:0x037a, B:182:0x0385, B:185:0x0397, B:186:0x03a1, B:188:0x03ad, B:191:0x03c1, B:196:0x03e2, B:200:0x039e, B:205:0x03ea, B:207:0x0402, B:211:0x0415, B:214:0x042f, B:216:0x0435, B:218:0x0444, B:219:0x045c, B:221:0x0462, B:223:0x046a, B:225:0x0487, B:226:0x0473, B:228:0x0481, B:232:0x048b, B:234:0x048f, B:236:0x0493, B:237:0x04b0, B:238:0x04b7, B:240:0x04d7, B:242:0x04e6, B:243:0x04f0), top: B:64:0x0214 }] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v23 */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(int r36, boolean r37, com.baidu.location.c.p r38, int r39) {
        /*
            Method dump skipped, instructions count: 1280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.d.a(int, boolean, com.baidu.location.c.p, int):java.lang.String");
    }

    public synchronized String a(WifiInfo wifiInfo, String str) {
        if (wifiInfo == null && str == null) {
            return null;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.l > 1000) {
                if (wifiInfo != null) {
                    this.m = wifiInfo.getBSSID();
                } else {
                    this.m = str;
                }
                this.l = currentTimeMillis;
            }
            return this.m;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0136 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(com.baidu.location.c.p r28, int r29, java.lang.String r30, boolean r31, int r32) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.d.a(com.baidu.location.c.p, int, java.lang.String, boolean, int):java.lang.String");
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("wpa|wep", 2).matcher(str).find();
    }

    public boolean a(p pVar, p pVar2) {
        List<ScanResult> list = pVar.f5714a;
        if (list == null || pVar2 == null || pVar2.f5714a == null) {
            return false;
        }
        int min = Math.min(list.size(), pVar2.f5714a.size());
        for (int i = 0; i < min; i++) {
            try {
                if (pVar.f5714a.get(i) != null) {
                    String str = pVar.f5714a.get(i).BSSID;
                    String str2 = pVar2.f5714a.get(i).BSSID;
                    if (!TextUtils.isEmpty(str) && !str.equals(str2)) {
                        return false;
                    }
                }
            } catch (Exception e) {
                if (com.baidu.location.c.b.a.c) {
                    e.printStackTrace();
                }
                return false;
            }
        }
        return true;
    }
}
