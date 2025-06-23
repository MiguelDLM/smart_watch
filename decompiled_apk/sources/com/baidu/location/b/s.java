package com.baidu.location.b;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.Jni;
import com.google.android.material.timepicker.TimeModel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* loaded from: classes7.dex */
public abstract class s {
    public static String d;
    public a e;

    /* renamed from: a, reason: collision with root package name */
    public com.baidu.location.c.p f5659a = null;
    public com.baidu.location.c.a b = null;
    public HashSet<String> c = null;
    private boolean g = true;
    private boolean h = true;
    private boolean i = false;
    private long j = 0;
    final Handler f = new b();
    private String k = null;
    private String l = null;
    private boolean m = false;
    private long n = 0;
    private int o = 0;

    /* loaded from: classes7.dex */
    public static class a extends com.baidu.location.e.g {

        /* renamed from: a, reason: collision with root package name */
        private long f5660a;
        private int b;

        public a() {
            this.dB = new HashMap();
        }

        @Override // com.baidu.location.e.g
        public void a() {
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append("os=A");
            stringBuffer.append(Build.VERSION.SDK_INT);
            stringBuffer.append("&prod=");
            stringBuffer.append(com.baidu.location.e.b.e);
            stringBuffer.append("&resid=");
            stringBuffer.append(com.tencent.connect.common.II0xO0.f26834o0IXXIx);
            String str = com.baidu.location.e.b.i;
            if (str == null) {
                str = "";
            }
            stringBuffer.append("&mapver=");
            stringBuffer.append(str);
            stringBuffer.append(com.baidu.location.e.o.e(com.baidu.location.f.getServiceContext()));
            stringBuffer.append("&cu=");
            stringBuffer.append(com.baidu.location.e.b.a().b());
            stringBuffer.append("&error=");
            stringBuffer.append(this.b);
            if (this.f5660a > 0) {
                stringBuffer.append("&tm=");
                stringBuffer.append(this.f5660a);
            }
            this.dB.put("info", Jni.encodeTp4(stringBuffer.toString()));
            this.dB.put("qt", "monitor");
        }

        @Override // com.baidu.location.e.g
        public void a(boolean z) {
            Map<String, Object> map = this.dB;
            if (map != null) {
                map.clear();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (com.baidu.location.f.isServing) {
                int i = message.what;
                if (i == 21) {
                    s.this.a(message);
                } else if (i == 62 || i == 63) {
                    s.this.a();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.location.e.g {

        /* renamed from: a, reason: collision with root package name */
        String f5662a = null;
        String b = null;
        long c = 0;
        long d = 0;
        long e = 0;

        public c() {
            this.dB = new HashMap();
        }

        @Override // com.baidu.location.e.g
        public void a() {
            if ((com.baidu.location.e.o.g || com.baidu.location.e.o.i) && s.this.k != null && s.this.l != null) {
                this.b += String.format(Locale.CHINA, "&ki=%s&sn=%s", s.this.k, s.this.l);
            }
            if (t.a().b()) {
                this.b += "&enc=2";
            }
            String q = com.baidu.location.c.h.a().q();
            if (q != null) {
                this.dH = Jni.encodeTp4(q);
            }
            String encodeTp4 = Jni.encodeTp4(this.b);
            this.b = null;
            if (this.f5662a == null) {
                this.f5662a = am.b();
            }
            this.dB.put("bloc", encodeTp4);
            String str = this.f5662a;
            if (str != null) {
                this.dB.put("up", str);
            }
            this.dB.put("trtm", String.format(Locale.CHINA, TimeModel.NUMBER_FORMAT, Long.valueOf(System.currentTimeMillis())));
            this.dI = 0L;
        }

        public void a(String str, long j) {
            this.b = str;
            this.d = System.currentTimeMillis();
            this.c = j;
            ExecutorService b = aj.a().b();
            if (com.baidu.location.e.o.b()) {
                a(b, false, null);
            } else if (b != null) {
                a(b, com.baidu.location.e.e.c);
            } else {
                b(com.baidu.location.e.e.c);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
        
            r12 = r11.dA;
         */
        /* JADX WARN: Removed duplicated region for block: B:43:0x011c  */
        /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.location.e.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(boolean r12) {
            /*
                Method dump skipped, instructions count: 288
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.s.c.a(boolean):void");
        }
    }

    public abstract void a();

    public abstract void a(Message message);

    public String b() {
        String c2 = com.baidu.location.b.c.a().c();
        String format = com.baidu.location.c.h.a().l() ? "&cn=32" : String.format(Locale.CHINA, "&cn=%d", Integer.valueOf(com.baidu.location.c.h.a().g()));
        if (System.currentTimeMillis() - this.n > 60000) {
            this.n = System.currentTimeMillis();
            String c3 = com.baidu.location.e.o.c();
            if (!TextUtils.isEmpty(c3)) {
                format = format + "&qcip6c=" + c3;
            }
        }
        if (this.g) {
            this.g = false;
        } else if (!this.i) {
            String e = am.e();
            if (e != null) {
                format = format + e;
            }
            this.i = true;
        }
        return format + c2;
    }

    public String a(String str) {
        com.baidu.location.c.p pVar;
        String o;
        if (this.k == null) {
            this.k = com.baidu.location.a.a.b(com.baidu.location.f.getServiceContext());
        }
        if (this.l == null) {
            this.l = com.baidu.location.a.a.c(com.baidu.location.f.getServiceContext());
        }
        com.baidu.location.c.a aVar = this.b;
        if (aVar == null || !aVar.a()) {
            this.b = com.baidu.location.c.h.a().f();
        }
        com.baidu.location.c.p pVar2 = this.f5659a;
        if (pVar2 == null || !pVar2.b()) {
            this.f5659a = com.baidu.location.c.h.a().r();
        }
        Location g = com.baidu.location.c.e.a().j() ? com.baidu.location.c.e.a().g() : null;
        com.baidu.location.c.a aVar2 = this.b;
        if ((aVar2 == null || aVar2.d() || this.b.c()) && (((pVar = this.f5659a) == null || pVar.a() == 0) && g == null)) {
            return null;
        }
        String b2 = b();
        if (r.a().d() == -2) {
            b2 = b2 + "&imo=1";
        }
        int b3 = com.baidu.location.e.o.b(com.baidu.location.f.getServiceContext());
        if (b3 >= 0) {
            b2 = b2 + "&lmd=" + b3;
            if (Build.VERSION.SDK_INT >= 28 && !this.m) {
                this.m = true;
                try {
                    if (com.baidu.location.f.getServiceContext().getPackageManager().hasSystemFeature("android.hardware.wifi.rtt")) {
                        b2 = b2 + "&rtt=1";
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        com.baidu.location.c.p pVar3 = this.f5659a;
        if ((pVar3 == null || pVar3.a() == 0) && (o = com.baidu.location.c.h.a().o()) != null) {
            b2 = o + b2;
        }
        if (com.baidu.location.c.h.a().m()) {
            b2 = b2 + "&wf_freq=1";
        }
        String str2 = b2;
        if (!this.h) {
            return com.baidu.location.e.o.a(this.b, this.f5659a, g, str2, 0);
        }
        this.h = false;
        return com.baidu.location.e.o.a(this.b, this.f5659a, g, str2, 0, true);
    }
}
