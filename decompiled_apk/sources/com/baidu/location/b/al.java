package com.baidu.location.b;

import android.annotation.TargetApi;
import android.location.GnssNavigationMessage;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class al {

    /* renamed from: a, reason: collision with root package name */
    private b f5624a;
    private long b = 0;
    private long c = 0;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static al f5625a = new al();
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.location.e.g {
        private boolean d = false;
        private String e = null;

        /* renamed from: a, reason: collision with root package name */
        public boolean f5626a = false;
        public long b = 0;

        public b() {
            this.dB = new HashMap();
        }

        @Override // com.baidu.location.e.g
        public void a() {
            String c = com.baidu.location.e.b.a().c();
            if (c != null) {
                c = c + "&gnsst=" + this.b;
            }
            String a2 = t.a().a(c);
            String replaceAll = !TextUtils.isEmpty(a2) ? a2.trim().replaceAll("\r|\n", "") : "null";
            String a3 = t.a().a(this.e);
            String replaceAll2 = TextUtils.isEmpty(a3) ? "null" : a3.trim().replaceAll("\r|\n", "");
            try {
                this.dB.put("info", URLEncoder.encode(replaceAll, "utf-8"));
                this.dB.put("enl", URLEncoder.encode(replaceAll2, "utf-8"));
            } catch (Exception unused) {
            }
        }

        public boolean b() {
            return this.d;
        }

        public void a(String str, long j) {
            if (this.d) {
                return;
            }
            this.d = true;
            this.e = str;
            this.b = j;
            ExecutorService c = aj.a().c();
            if (c != null) {
                a(c, "https://ofloc.map.baidu.com/locnu");
            } else {
                b("https://ofloc.map.baidu.com/locnu");
            }
        }

        @Override // com.baidu.location.e.g
        public void a(boolean z) {
            if (z && this.dA != null) {
                try {
                    new JSONObject(this.dA);
                    this.f5626a = true;
                } catch (Throwable unused) {
                }
            }
            Map<String, Object> map = this.dB;
            if (map != null) {
                map.clear();
            }
            this.d = false;
        }
    }

    public static al a() {
        return a.f5625a;
    }

    public void b() {
        ArrayList<String> b2;
        if (this.b == 0 || Math.abs(System.currentTimeMillis() - this.b) >= 20000) {
            return;
        }
        if (this.f5624a == null) {
            this.f5624a = new b();
        }
        b bVar = this.f5624a;
        if (bVar == null || bVar.b() || (b2 = ae.a().b()) == null || b2.size() <= 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = b2.iterator();
        int i = 0;
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            i++;
            if (i != b2.size()) {
                stringBuffer.append(com.huawei.openalliance.ad.constant.x.aL);
            }
        }
        this.f5624a.a(stringBuffer.toString(), this.c);
    }

    @TargetApi(24)
    public void a(GnssNavigationMessage gnssNavigationMessage, long j) {
        ae.a().a(gnssNavigationMessage, j);
        this.b = System.currentTimeMillis();
        this.c = j;
    }
}
