package com.baidu.xclient.gdid;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile c f10225a = null;
    public static Context b = null;
    public static String c = "";
    public static String d = "";
    public static final HashMap<String, String> e = new HashMap<>();
    public com.baidu.xclient.gdid.c.b f;
    public String h;
    public AtomicBoolean g = new AtomicBoolean(false);
    public ConcurrentHashMap<String, String> i = new ConcurrentHashMap<>();

    public static c a() {
        if (f10225a == null) {
            synchronized (c.class) {
                try {
                    if (f10225a == null) {
                        f10225a = new c();
                    }
                } finally {
                }
            }
        }
        return f10225a;
    }

    public String b(String str) {
        return com.baidu.xclient.gdid.jni.c.a(b).d(str);
    }

    public String c(String str) {
        try {
            HashMap<String, String> hashMap = e;
            if (hashMap.size() <= 0) {
                return "";
            }
            synchronized (hashMap) {
                try {
                    if (!hashMap.containsKey(str)) {
                        return "";
                    }
                    return hashMap.get(str);
                } finally {
                }
            }
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
            return "";
        }
    }

    public synchronized String[] d() {
        String[] strArr = {"", ""};
        String str = this.h;
        if (TextUtils.isEmpty(str)) {
            return strArr;
        }
        String str2 = this.i.get(str);
        strArr[0] = str;
        strArr[1] = str2;
        return strArr;
    }

    public String e() {
        return "";
    }

    public final void f() {
        JSONObject c2;
        try {
            if (com.baidu.xclient.gdid.e.d.a(b) && com.baidu.mshield.b.e.a.c(b) && (c2 = c()) != null) {
                if (new com.baidu.xclient.gdid.b.a(b, null).a(com.baidu.xclient.gdid.e.d.a(b, c2, "1072101").toString())) {
                    long currentTimeMillis = System.currentTimeMillis();
                    f.a().g(currentTimeMillis);
                    f.a().c(currentTimeMillis);
                } else {
                    h.a().a(b);
                }
            }
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
        }
    }

    public final void g() {
        try {
            this.f = new com.baidu.xclient.gdid.c.b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.baidu.xclient.gdid.c.b.f10227a);
            b.registerReceiver(this.f, intentFilter);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
        }
    }

    public final void h() {
        try {
            b.unregisterReceiver(this.f);
            this.f = null;
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
        }
    }

    public final void i() {
        JSONObject jSONObject;
        String l = f.a().l();
        String q = f.a().q();
        f.a().p();
        if (TextUtils.isEmpty(q)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject(q);
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
        }
        if (TextUtils.isEmpty(l)) {
            return;
        }
        this.i.put(l, jSONObject.toString());
        this.h = l;
    }

    public Object a(int i, Object obj, Object obj2, Object obj3) {
        return com.baidu.xclient.gdid.jni.c.a(b).a(i, obj, obj2, obj3);
    }

    public void b() {
        try {
            h();
            this.g.set(false);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
        }
    }

    public JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb = new StringBuilder();
            a(jSONObject, sb);
            a(jSONObject);
            b(jSONObject, sb);
            b(jSONObject);
            jSONObject.put("15057", sb);
            jSONObject.put("15006", TextUtils.isEmpty(com.baidu.xclient.gdid.jni.c.a(b).a()) ? 1 : 0);
            return jSONObject;
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
            return null;
        }
    }

    public String a(Context context) {
        try {
            String c2 = c("p");
            if (!TextUtils.isEmpty(c2)) {
                return c2;
            }
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
        }
        return context.getPackageName();
    }

    public final void b(JSONObject jSONObject) {
        try {
            jSONObject.put("12006", com.baidu.mshield.b.e.a.c(b, "screen_brightness"));
        } catch (Throwable unused) {
            try {
                jSONObject.put("12006", -1);
            } catch (Throwable th) {
                try {
                    com.baidu.xclient.gdid.e.d.a(th);
                } catch (Throwable th2) {
                    com.baidu.xclient.gdid.e.d.a(th2);
                }
            }
        }
    }

    public String a(String str) {
        return com.baidu.xclient.gdid.jni.c.a(b).a(str);
    }

    public final void b(JSONObject jSONObject, StringBuilder sb) {
        StringBuilder sb2;
        try {
            a(jSONObject, "02018", com.baidu.xclient.gdid.e.c.a("02018", c("arid"), sb));
            jSONObject.put("02015", c("arv"));
            jSONObject.put("02016", c("arl"));
            jSONObject.put("02002", com.baidu.xclient.gdid.jni.c.a(b).f());
            jSONObject.put("02003", c("mod"));
            jSONObject.put("02004", com.baidu.xclient.gdid.jni.c.a(b).k());
            jSONObject.put("02005", com.baidu.xclient.gdid.jni.c.a(b).j());
            jSONObject.put("02006", com.baidu.xclient.gdid.jni.c.a(b).i());
            jSONObject.put("02007", com.baidu.xclient.gdid.jni.c.a(b).h());
            jSONObject.put("02008", com.baidu.xclient.gdid.jni.c.a(b).g());
            jSONObject.put("15023", com.baidu.xclient.gdid.d.a.a());
            jSONObject.put("15021", com.baidu.xclient.gdid.d.a.c());
            jSONObject.put("15020", com.baidu.xclient.gdid.d.a.b());
            jSONObject.put("15022", com.baidu.xclient.gdid.d.a.d());
            String b2 = com.baidu.mshield.b.a.g.b(b);
            String c2 = com.baidu.mshield.b.a.g.c(b);
            jSONObject.put("15029", b2);
            jSONObject.put("15030", c2);
            a(jSONObject, "15048", com.baidu.xclient.gdid.jni.b.a(b).a());
            a(jSONObject, "p", com.baidu.mshield.b.a.e.a() ? "1" : "0");
            a(jSONObject, "s", com.baidu.xclient.gdid.jni.c.a(b).a());
            a(jSONObject, "11005", String.valueOf(com.baidu.mshield.b.a.e.b()));
            String c3 = com.baidu.mshield.b.a.e.c();
            if (!TextUtils.isEmpty(c3)) {
                if (c3.contains("64")) {
                    sb2 = new StringBuilder();
                    sb2.append("64 ");
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("32 ");
                }
                sb2.append(c3);
                c3 = sb2.toString();
            }
            a(jSONObject, "11003", c3);
            a(jSONObject, "02010", com.baidu.xclient.gdid.d.a.a(b));
            a(jSONObject, "02012", com.baidu.xclient.gdid.d.a.d(b));
            a(jSONObject, "02059", com.baidu.xclient.gdid.jni.c.a(b).e());
            try {
                com.baidu.xclient.gdid.e.f fVar = new com.baidu.xclient.gdid.e.f();
                fVar.a(10, 10);
                String glGetString = fVar.f.glGetString(7937);
                a(jSONObject, "20081", fVar.f.glGetString(7936));
                a(jSONObject, "20082", glGetString);
                fVar.b();
            } catch (Throwable th) {
                com.baidu.xclient.gdid.e.d.a(th);
            }
            a(jSONObject, "12001", com.baidu.xclient.gdid.d.a.e(b));
            a(jSONObject, "12007", String.valueOf(com.baidu.xclient.gdid.d.a.f(b)));
            a(jSONObject, "06011", String.valueOf(com.baidu.xclient.gdid.d.a.g(b)));
            a(jSONObject, "06012", String.valueOf(com.baidu.xclient.gdid.d.a.h(b) ? 1 : 0));
        } catch (Throwable th2) {
            com.baidu.xclient.gdid.e.d.a(th2);
        }
    }

    public void a(Context context, String str, String str2) {
        try {
            if (this.g.get()) {
                return;
            }
            b = context;
            c = str;
            d = str2;
            i();
            this.g.set(true);
            new Thread(new d(this)).start();
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
        }
    }

    public final void b(boolean z) {
        if (z) {
            com.baidu.xclient.gdid.e.b.c().postDelayed(new e(this), 65000L);
        } else {
            h.a().a(b);
        }
    }

    public void a(Context context, String str, String str2, HashMap<String, String> hashMap) {
        b = context;
        c = str;
        d = str2;
        if (hashMap != null) {
            HashMap<String, String> hashMap2 = e;
            synchronized (hashMap2) {
                hashMap2.putAll(hashMap);
            }
        }
    }

    public void a(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            try {
                if (hashMap.size() == 0) {
                    return;
                }
                synchronized (e) {
                    try {
                        for (String str : hashMap.keySet()) {
                            e.put(str, hashMap.get(str));
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                com.baidu.xclient.gdid.e.d.a(th);
            }
        }
    }

    public final void a(JSONObject jSONObject) {
        try {
            a(jSONObject, "15027", com.baidu.xclient.gdid.a.a.a(b));
            a(jSONObject, "15003", com.baidu.mshield.b.b.a.a(b));
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
        }
    }

    public final void a(JSONObject jSONObject, String str, String str2) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            jSONObject.put(str, str2);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
        }
    }

    public final void a(JSONObject jSONObject, StringBuilder sb) {
        try {
            a(jSONObject, "15200", "C");
            a(jSONObject, "01001", com.baidu.xclient.gdid.e.a.a(b));
            a(jSONObject, "15017", (String) com.baidu.xclient.gdid.e.d.d(b).first);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
        }
    }

    public void a(boolean z) {
        if (f.a().r()) {
            return;
        }
        if (f.a().s()) {
            b(z);
            return;
        }
        long d2 = f.a().d();
        if (System.currentTimeMillis() - d2 < f.a().e()) {
            b(z);
        } else {
            f();
        }
    }

    public void a(boolean z, boolean z2) {
        try {
            b.a().a(b);
            a(z);
            if (z2) {
                long h = f.a().h();
                long i = f.a().i();
                long currentTimeMillis = System.currentTimeMillis();
                long j = currentTimeMillis - h;
                if (j >= i) {
                    f.a().e(currentTimeMillis);
                } else {
                    i -= j;
                }
                com.baidu.xclient.gdid.c.a.a(b, i);
            }
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
        }
    }
}
