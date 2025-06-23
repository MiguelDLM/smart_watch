package com.baidu.navisdk.module.perform;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.navisdk.util.common.g;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static SimpleDateFormat f7376a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    public static ConcurrentHashMap<String, Long> b = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, Long> c = new ConcurrentHashMap<>();
    public static CopyOnWriteArrayList<a> d = new CopyOnWriteArrayList<>();
    public static ArrayList<String> e = new ArrayList<>();
    public static long f = -1;
    public static int g = 0;
    public static int h = 0;
    private static b i;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f7377a;
        String b;
        long c;
        long d;
        long e;
        long f;
        boolean g;

        private a() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[LOG][");
            sb.append(b.f7376a.format(new Date(this.c)));
            sb.append("][");
            sb.append(this.e);
            sb.append("]");
            sb.append("[");
            sb.append(this.f);
            sb.append("]");
            sb.append(",");
            sb.append(this.g);
            sb.append(",");
            sb.append(this.f7377a);
            sb.append(",");
            sb.append(this.d);
            if (!TextUtils.isEmpty(this.b)) {
                sb.append(",");
                sb.append(this.b);
            }
            return sb.toString();
        }

        public /* synthetic */ a(com.baidu.navisdk.module.perform.a aVar) {
            this();
        }
    }

    public b() {
        e.add("maps_start_time");
        e.add("app_start_time");
        e.add("navi_init");
        e.add("navi_init_engine");
    }

    public static b d() {
        if (i == null) {
            synchronized (b.class) {
                try {
                    if (i == null) {
                        i = new b();
                    }
                } finally {
                }
            }
        }
        return i;
    }

    public static boolean f(String str) {
        if (!b.containsKey(str) && !c.containsKey(str)) {
            return false;
        }
        return true;
    }

    public static long g(String str) {
        Long l;
        if (str != null && b.containsKey(str)) {
            Long l2 = b.get(str);
            if (l2 == null) {
                return 0L;
            }
            return l2.longValue();
        }
        if (str == null || !c.containsKey(str) || (l = c.get(str)) == null) {
            return 0L;
        }
        return l.longValue();
    }

    public boolean a() {
        return com.baidu.navisdk.module.cloudconfig.a.b().b("is_open_perform_monitor", false);
    }

    public void b(String str) {
        if (e(str)) {
            b(str, SystemClock.elapsedRealtime());
        }
    }

    public boolean e(String str) {
        if (!d(str) && !a()) {
            return false;
        }
        return true;
    }

    public void c(String str) {
        if (e(str)) {
            a(str, true);
        }
    }

    public void a(String str) {
        if (e(str)) {
            a(str, SystemClock.elapsedRealtime());
        }
    }

    private void b(String str, long j) {
        a(str, null, true, j, true);
    }

    private void b(String str, String str2, boolean z, long j) {
        a aVar = new a(null);
        aVar.f7377a = "cost_" + str;
        aVar.b = str2;
        aVar.c = System.currentTimeMillis();
        aVar.f = SystemClock.currentThreadTimeMillis();
        aVar.e = Thread.currentThread().getId();
        aVar.d = j;
        aVar.g = z;
        d.add(aVar);
        if (g.b0) {
            Log.e("navi_perf", aVar.toString());
        }
    }

    private void a(String str, long j) {
        a(str + "_end", null, true, j, true);
        if (f(str)) {
            a("cost_" + str, null, true, j - g(str), false);
        }
    }

    public boolean d(String str) {
        return e.contains(str);
    }

    public void a(String str, boolean z) {
        if (e(str)) {
            a(str, null, z);
        }
    }

    public void a(String str, String str2, boolean z) {
        a(str, str2, z, SystemClock.elapsedRealtime(), true);
    }

    private void a(String str, String str2, boolean z, long j, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z2) {
            a(str, str2, z, j);
        } else {
            b(str, str2, z, j);
        }
        if (z || !(b.containsKey(str) || c.containsKey(str))) {
            if (!d(str) && !str.startsWith("cost_")) {
                b.put(str, Long.valueOf(j));
            } else {
                c.put(str, Long.valueOf(j));
            }
        }
    }

    public void b() {
        if (!a()) {
            c.clear();
        }
        b.clear();
    }

    private void a(String str, String str2, boolean z, long j) {
        a aVar = new a(null);
        aVar.f7377a = str;
        aVar.b = str2;
        aVar.c = System.currentTimeMillis();
        long j2 = f;
        aVar.d = j2 == -1 ? 0L : j - j2;
        aVar.g = z;
        aVar.f = SystemClock.currentThreadTimeMillis();
        aVar.e = Thread.currentThread().getId();
        d.add(aVar);
        f = j;
        if (g.b0) {
            Log.e("navi_perf", aVar.toString());
        }
    }
}
