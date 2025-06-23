package com.baidu.navisdk.ugc.report;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Set<Integer> f8242a;

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final c f8243a = new c();
    }

    public static c a() {
        return b.f8243a;
    }

    public boolean b(boolean z) {
        return a(z, 3);
    }

    public boolean c(boolean z) {
        return a(z, 2);
    }

    private c() {
        this.f8242a = new HashSet(3);
    }

    public boolean a(boolean z) {
        return a(z, 1);
    }

    private boolean a(boolean z, int i) {
        if (z) {
            this.f8242a.add(Integer.valueOf(i));
        } else {
            this.f8242a.remove(Integer.valueOf(i));
        }
        if (z) {
            return true;
        }
        return !this.f8242a.isEmpty();
    }
}
