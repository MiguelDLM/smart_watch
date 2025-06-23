package com.baidu.navisdk.ui.util;

import android.os.SystemClock;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.baidu.navisdk.util.common.d0;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f9201a = new Object();
    private static final a b = new a(64);
    private static final ConcurrentHashMap<String, Long> c = new ConcurrentHashMap<>();

    /* loaded from: classes8.dex */
    public static class a extends LruCache<String, Long> {
        public a(int i) {
            super(i);
        }

        @Override // android.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z, String str, Long l, Long l2) {
            super.entryRemoved(z, str, l, l2);
            if (z && l != null && str != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() > 20000) {
                    f.c.clear();
                } else {
                    f.c.put(str, l);
                }
            }
        }
    }

    public static boolean a(long j) {
        return a("fast_click_default_tag", j);
    }

    public static boolean a(@NonNull String str) {
        return a(str, 800L);
    }

    public static boolean a(@NonNull String str, long j) {
        boolean z;
        d0.a(str, "fast click tag can not be null!");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (f9201a) {
            try {
                a aVar = b;
                Long l = aVar.get(str);
                if (l == null) {
                    l = c.remove(str);
                }
                z = l != null && elapsedRealtime - l.longValue() <= j;
                if (!z) {
                    aVar.put(str, Long.valueOf(elapsedRealtime));
                }
            } finally {
            }
        }
        return z;
    }
}
