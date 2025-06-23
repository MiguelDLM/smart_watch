package com.ss.android.socialbase.downloader.i;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public class h<K, T> extends LinkedHashMap<K, T> {

    /* renamed from: a, reason: collision with root package name */
    private int f26360a;

    public h() {
        this(4, 4);
    }

    public void a(int i) {
        this.f26360a = i;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, T> entry) {
        if (size() > this.f26360a) {
            return true;
        }
        return false;
    }

    public h(int i, int i2) {
        this(i, i2, true);
    }

    public h(int i, int i2, boolean z) {
        super(i, 0.75f, z);
        a(i2);
    }
}
