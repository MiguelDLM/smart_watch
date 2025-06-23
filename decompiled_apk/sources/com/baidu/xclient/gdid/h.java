package com.baidu.xclient.gdid;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static volatile h f10236a;
    public AtomicBoolean b = new AtomicBoolean(false);

    public static h a() {
        if (f10236a == null) {
            synchronized (h.class) {
                try {
                    if (f10236a == null) {
                        f10236a = new h();
                    }
                } finally {
                }
            }
        }
        return f10236a;
    }

    public final JSONObject a(Context context, StringBuilder sb) {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = c.a().d()[0];
            String str2 = "";
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            jSONObject.put("15028", str);
            String a2 = com.baidu.xclient.gdid.e.c.a("02018", c.a().c("arid"), sb);
            if (!TextUtils.isEmpty(a2)) {
                str2 = a2;
            }
            jSONObject.put("02018", str2);
            jSONObject.put("15003", com.baidu.mshield.b.b.a.a(context));
            jSONObject.put("02003", c.a().c("mod"));
            jSONObject.put("02002", com.baidu.xclient.gdid.jni.c.a(context).f());
            String b = com.baidu.mshield.b.a.g.b(context);
            String c = com.baidu.mshield.b.a.g.c(context);
            jSONObject.put("15029", b);
            jSONObject.put("15030", c);
            jSONObject.put("p", com.baidu.mshield.b.a.e.a() ? "1" : "0");
            jSONObject.put("02020", com.baidu.xclient.gdid.e.d.b());
            jSONObject.put("02015", c.a().c("arv"));
            jSONObject.put("s", com.baidu.xclient.gdid.jni.c.a(context).a());
            return jSONObject;
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
            return null;
        }
    }

    public void a(Context context) {
        if (this.b.get()) {
            return;
        }
        try {
            this.b.set(true);
            if (!f.a().t() && com.baidu.xclient.gdid.e.d.a(context) && com.baidu.mshield.b.e.a.c(context)) {
                long j = f.a().j();
                long k = f.a().k();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - j >= k) {
                    StringBuilder sb = new StringBuilder();
                    JSONObject a2 = a(context, sb);
                    a2.put("15057", sb);
                    JSONObject a3 = com.baidu.xclient.gdid.e.d.a(context, a2, "1072102");
                    if (a3 != null && new com.baidu.xclient.gdid.b.a(context, null).a(a3) != null) {
                        f.a().A();
                        f.a().g(currentTimeMillis);
                    }
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }
}
