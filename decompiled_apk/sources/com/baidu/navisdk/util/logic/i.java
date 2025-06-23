package com.baidu.navisdk.util.logic;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes8.dex */
public class i {
    private static i c;

    /* renamed from: a, reason: collision with root package name */
    private List<a> f9327a = new CopyOnWriteArrayList();
    private AtomicInteger b = new AtomicInteger(0);

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i, float[] fArr);
    }

    public static i a() {
        if (c == null) {
            synchronized (i.class) {
                try {
                    if (c == null) {
                        c = new i();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public void a(int i) {
        if (this.b.get() < 1) {
            return;
        }
        for (a aVar : this.f9327a) {
            if (aVar instanceof a) {
                aVar.a(i, null);
            }
        }
    }
}
