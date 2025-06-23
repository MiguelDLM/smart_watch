package com.baidu.mshield.x6.d;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public Context f6431a;
    public h b;
    public com.baidu.mshield.x6.a.b c;
    public int d;

    public c(Context context, int i) {
        this.f6431a = context;
        this.d = i;
        this.b = new h(context, i);
        this.c = new com.baidu.mshield.x6.a.b(this.f6431a);
    }

    public void a() {
        JSONObject a2;
        try {
            com.baidu.mshield.b.c.a.a("report static alive for start");
            JSONObject a3 = this.b.a();
            if (a3 != null) {
                a2 = com.baidu.mshield.x6.e.f.a(this.f6431a, a3, com.baidu.mshield.x6.e.g.c, true);
            } else {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("11111", "-1");
                a2 = com.baidu.mshield.x6.e.f.a(this.f6431a, jSONObject, com.baidu.mshield.x6.e.g.c, true);
            }
            com.baidu.mshield.b.c.a.a("sendJson:" + a2);
        } finally {
            try {
            } finally {
            }
        }
        if (!com.baidu.mshield.b.a.d.b(this.f6431a)) {
            i.c = false;
            return;
        }
        int a4 = com.baidu.mshield.x6.e.l.a(this.f6431a, a2.toString());
        com.baidu.mshield.b.c.a.c("result: " + a4);
        if (a4 == 0) {
            this.c.k(com.baidu.mshield.x6.e.f.c());
            this.c.g(true);
            this.c.a(false);
        } else {
            long b = b();
            if (com.baidu.mshield.b.a.d.b(this.f6431a) && b > 0) {
                f.a(this.f6431a).a(b);
            }
        }
    }

    public final long b() {
        int i;
        long j = 300000;
        try {
            i = i.d;
        } catch (Throwable th) {
            com.baidu.mshield.x6.e.f.a(th);
        }
        if (i != 0 && i != 1 && i != 2) {
            if ((i < 3 || i >= 10) && i >= 10) {
                j = -1;
            }
            i.d = i + 1;
            return j;
        }
        j = 5000;
        i.d = i + 1;
        return j;
    }
}
