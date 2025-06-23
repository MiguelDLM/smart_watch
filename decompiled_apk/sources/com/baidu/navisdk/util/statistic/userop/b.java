package com.baidu.navisdk.util.statistic.userop;

import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.statistics.d;
import com.baidu.navisdk.comapi.statistics.f;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.framework.interfaces.o;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.common.n;
import com.baidu.navisdk.util.statistic.g;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class b extends f {
    private static b v;
    private String j;
    private long k;
    private long l;
    private StringBuffer m;
    private Map<String, com.baidu.navisdk.util.statistic.userop.a> n;
    private int o;
    private int p;
    private int q;
    private int r;
    private String s;
    private int t;
    private n.b u;

    public b(d dVar) {
        super(dVar);
        this.j = null;
        this.k = -1L;
        this.l = -1L;
        this.m = new StringBuffer();
        this.n = new HashMap();
        this.p = 1;
        this.q = 0;
        this.r = 0;
        this.s = null;
        this.t = 0;
        this.u = new a();
        n.d().a(this.u);
    }

    private void e(String str, String str2) {
        b(str, str2);
        a(false);
    }

    private String f(String str) {
        String str2 = "";
        if (!l0.c(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.getJSONObject("ActParam");
                String optString = jSONObject2.optString("lj", "");
                o m = com.baidu.navisdk.framework.interfaces.c.p().m();
                if (m != null && m.Z()) {
                    str2 = ":1.k-0";
                    m.o(false);
                }
                String str3 = str2 + ":1.j-0";
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Statistics-UserOP", "performLoadCacheOPs() loadOP=" + jSONObject2.toString() + ", tmp=" + str3);
                }
                if (!optString.contains(str3)) {
                    jSONObject2.put("lj", optString + str3);
                }
                if (jSONObject2.isNull("ssid")) {
                    jSONObject2.put("ssid", this.j);
                }
                jSONObject.put("ActParam", jSONObject2);
                return jSONObject.toString();
            } catch (JSONException e) {
                if (LogUtil.LOGGABLE) {
                    e.printStackTrace();
                    LogUtil.printException("Statistics-UserOP", e);
                }
            }
        }
        return str;
    }

    private void o() {
        int i;
        String str = this.s;
        if (str != null && (i = this.t) > 0) {
            a(str, i);
            this.s = null;
            this.t = 0;
        }
    }

    private void p() {
        if (!TextUtils.isEmpty(this.j) && !g().containsKey("ssid")) {
            b("ssid", this.j);
            a(true);
        }
    }

    private void q() {
        int g = b().g();
        if (this.o + 100 > g || (this.l > 0 && SystemClock.elapsedRealtime() - this.l > 21600000)) {
            LogUtil.e("Statistics-UserOP", "checkEnd() end, mOPsTotalSize=" + this.o + "100,maxUserOpContentSize=" + g);
            n();
        }
    }

    public static b r() {
        if (v == null) {
            synchronized (b.class) {
                try {
                    if (v == null) {
                        v = new b(com.baidu.navisdk.comapi.statistics.b.f());
                    }
                } finally {
                }
            }
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        LogUtil.e("Statistics-UserOP", "uploadHistoryOps()");
        if (com.baidu.navisdk.framework.a.c().a() == null) {
            a(1000L);
            return;
        }
        String str = f().b() + "/userOp";
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            a(file);
            f().c(str);
        }
    }

    public void b(String str) {
        a(str, null, null, null);
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String c() {
        return "userOp/50008";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String d() {
        return "50008";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "Statistics-UserOP";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public void l() {
        super.l();
        this.k = -1L;
        this.l = -1L;
        this.m = new StringBuffer();
        this.o = 0;
    }

    public boolean n() {
        b("lj", this.m.toString());
        b("ssid", this.j);
        g.d().a();
        String b = g.d().b();
        if (b != null) {
            b("rg", b);
        }
        new c(super.g()).a();
        com.baidu.navisdk.framework.interfaces.g d = com.baidu.navisdk.framework.interfaces.c.p().d();
        if (d != null && d.O()) {
            SDKDebugFileUtil.get(SDKDebugFileUtil.USEROP_FILENAME).add(this.m.toString());
        }
        super.k();
        return true;
    }

    /* loaded from: classes8.dex */
    public class a extends n.b {
        public a() {
        }

        @Override // com.baidu.navisdk.util.common.n.b
        public void a(Message message) {
            if (message.what != 1) {
                return;
            }
            b.this.s();
        }

        @Override // com.baidu.navisdk.util.common.n.b
        public String b() {
            return "Statistics-UserOP";
        }

        @Override // com.baidu.navisdk.util.common.n.b
        public void a() {
            a(1);
        }
    }

    public void a(int i, int i2) {
        boolean z = LogUtil.LOGGABLE;
        if (z && i != 1 && i != 2 && i != 3) {
            throw new IllegalArgumentException(String.format("UserOPController setVehicle value(%d) is exception", Integer.valueOf(i)));
        }
        if (z) {
            LogUtil.e("Statistics-UserOP", "setVehicleAndScene() --> vehicle = " + i + ", scene = " + i2);
        }
        this.p = i;
        this.q = i2;
    }

    public String b(String str, String str2, String str3) {
        return !l0.c(str) ? str.replaceAll(str2, str3) : str;
    }

    public void c(String str) {
        if (str == null) {
            return;
        }
        String str2 = this.s;
        if (str2 == null) {
            this.s = str;
            this.t = 1;
        } else {
            if (str2.equals(str)) {
                this.t++;
                return;
            }
            a(this.s, this.t);
            this.s = str;
            this.t = 1;
        }
    }

    public void d(String str, String str2) {
        a(str, str2, null, null);
    }

    public void d(String str) {
        this.j = str;
        p();
    }

    public boolean e(String str) {
        if (str == null || str.length() <= 0 || !this.n.containsKey(str)) {
            return false;
        }
        com.baidu.navisdk.util.statistic.userop.a aVar = this.n.get(str);
        if (aVar != null) {
            a(str, aVar.b, aVar.c, aVar.d);
            return true;
        }
        this.n.remove(str);
        return false;
    }

    public void a(String str, String str2, String str3) {
        a(str, str2, str3, null);
    }

    public void a(String str, String str2, String str3, String str4) {
        long elapsedRealtime;
        if (str == null || str.length() == 0) {
            return;
        }
        if (str2 != null) {
            if (str2.trim().equals("a")) {
                str2 = "";
            } else if (str2.trim().equals("b")) {
                str3 = "";
                str2 = null;
            } else if (str2.trim().equals("c")) {
                str4 = "";
                str2 = null;
                str3 = null;
            }
        }
        q();
        o();
        if (this.k <= 0) {
            this.k = SystemClock.elapsedRealtime();
            elapsedRealtime = System.currentTimeMillis() / 1000;
        } else {
            elapsedRealtime = ((SystemClock.elapsedRealtime() - this.k) / 1000) + 1;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        String str5 = HelpFormatter.DEFAULT_OPT_PREFIX;
        stringBuffer.append(HelpFormatter.DEFAULT_OPT_PREFIX);
        stringBuffer.append(String.valueOf(elapsedRealtime));
        boolean z = true;
        if (str2 != null || str3 != null || str4 != null) {
            if (str2 != null) {
                stringBuffer.append(HelpFormatter.DEFAULT_OPT_PREFIX);
                stringBuffer.append("a");
                if (str2.length() > 0) {
                    stringBuffer.append(str2);
                }
                z = false;
            }
            if (str3 != null) {
                stringBuffer.append(z ? HelpFormatter.DEFAULT_OPT_PREFIX : "|");
                stringBuffer.append("b");
                if (str3.length() > 0) {
                    stringBuffer.append(str3);
                }
                z = false;
            }
            if (str4 != null) {
                stringBuffer.append(z ? HelpFormatter.DEFAULT_OPT_PREFIX : "|");
                stringBuffer.append("c");
                if (str4.length() > 0) {
                    stringBuffer.append(str4);
                }
                z = false;
            }
        }
        if (!z) {
            str5 = "|";
        }
        stringBuffer.append(str5);
        stringBuffer.append("p");
        stringBuffer.append((this.r * 256) + (this.q * 16) + this.p);
        this.l = SystemClock.elapsedRealtime();
        if (this.m.length() > 0) {
            this.m.append(":");
        }
        String stringBuffer2 = stringBuffer.toString();
        this.m.append(stringBuffer2);
        this.o += stringBuffer2.length();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("UserOP", "add() ops=" + stringBuffer2 + ", mOPsTotalSize=" + this.o);
        }
        try {
            e("lj", this.m.toString());
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.f("Statistics-UserOP", "ex=" + e.getMessage());
            }
        }
        p();
    }

    private void a(long j) {
        n.d().a(1);
        n.d().a(1, 0, 0, null, j);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:7|(2:11|(3:13|14|15))|16|17|(2:19|20)(1:21)|15) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
    
        if (com.baidu.navisdk.util.common.LogUtil.LOGGABLE != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0061, code lost:
    
        com.baidu.navisdk.util.common.LogUtil.printException("Statistics-UserOP", r3);
        r3.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.io.File r10) {
        /*
            r9 = this;
            java.lang.String r0 = "Statistics-UserOP"
            java.io.File[] r10 = r10.listFiles()
            if (r10 == 0) goto L6a
            int r1 = r10.length
            if (r1 <= 0) goto L6a
            int r1 = r10.length
            r2 = 0
        Ld:
            if (r2 >= r1) goto L6a
            r3 = r10[r2]
            boolean r4 = r3.isFile()
            if (r4 == 0) goto L3c
            long r4 = r3.length()
            r6 = 512000(0x7d000, double:2.529616E-318)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L3c
            java.lang.String r4 = r3.getAbsolutePath()
            java.lang.String r4 = com.baidu.navisdk.util.common.s.e(r4)
            java.lang.String r4 = r9.f(r4)
            boolean r5 = com.baidu.navisdk.util.common.l0.c(r4)
            if (r5 != 0) goto L3c
            java.lang.String r3 = r3.getAbsolutePath()
            com.baidu.navisdk.util.common.s.b(r3, r4)
            goto L67
        L3c:
            java.lang.String r3 = r3.getAbsolutePath()     // Catch: java.lang.Exception -> L5c
            com.baidu.navisdk.util.common.s.a(r3)     // Catch: java.lang.Exception -> L5c
            boolean r4 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE     // Catch: java.lang.Exception -> L5c
            if (r4 == 0) goto L67
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5c
            r4.<init>()     // Catch: java.lang.Exception -> L5c
            java.lang.String r5 = "handleHistoryUserOpFile->删除异常文件:"
            r4.append(r5)     // Catch: java.lang.Exception -> L5c
            r4.append(r3)     // Catch: java.lang.Exception -> L5c
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Exception -> L5c
            com.baidu.navisdk.util.common.LogUtil.e(r0, r3)     // Catch: java.lang.Exception -> L5c
            goto L67
        L5c:
            r3 = move-exception
            boolean r4 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
            if (r4 == 0) goto L67
            com.baidu.navisdk.util.common.LogUtil.printException(r0, r3)
            r3.printStackTrace()
        L67:
            int r2 = r2 + 1
            goto Ld
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.statistic.userop.b.a(java.io.File):void");
    }

    private void a(String str, int i) {
        this.s = null;
        this.t = 0;
        if ("3.ka".equals(str)) {
            d("3.k", String.valueOf(i));
        } else if ("3.kb".equals(str)) {
            a("3.k", null, String.valueOf(i), null);
        } else {
            d(str, String.valueOf(i));
        }
    }
}
