package com.baidu.navisdk.util.common;

import android.content.Context;
import androidx.annotation.NonNull;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes8.dex */
public class b0 {

    /* loaded from: classes8.dex */
    public static class a<K, V> extends LinkedHashMap<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private final int f9220a;

        public a(int i) {
            super(((int) Math.ceil(i / 0.75d)) + 1, 0.75f, false);
            this.f9220a = i;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, V> entry) {
            if (size() > this.f9220a) {
                return true;
            }
            return false;
        }
    }

    static {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.getDefault());
    }

    public b0(Context context) {
        this(context, "BNPerformanceMonitorThread");
    }

    private void a() {
    }

    public void b(@NonNull String... strArr) {
    }

    public b0(Context context, String str) {
        new a(400);
        new a(200);
        a();
    }

    public void a(@NonNull String... strArr) {
    }
}
