package com.ss.android.socialbase.downloader.network;

import XIXIX.OOXIXo;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes13.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static final String f26415a = "k";
    private final d b;
    private volatile boolean c;
    private final AtomicReference<l> d;
    private AtomicReference<l> e;
    private final ArrayList<b> f;
    private int g;

    /* renamed from: com.ss.android.socialbase.downloader.network.k$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26416a;

        static {
            int[] iArr = new int[l.values().length];
            f26416a = iArr;
            try {
                iArr[l.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26416a[l.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26416a[l.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26416a[l.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final k f26417a = new k(null);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void a(l lVar);
    }

    public /* synthetic */ k(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static k a() {
        return a.f26417a;
    }

    private boolean c() {
        double d;
        if (this.b == null) {
            return false;
        }
        try {
            int i = AnonymousClass1.f26416a[this.d.get().ordinal()];
            double d2 = 150.0d;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return true;
                        }
                        d2 = 3.4028234663852886E38d;
                        d = 2000.0d;
                    } else {
                        d = 550.0d;
                        d2 = 2000.0d;
                    }
                } else {
                    d2 = 550.0d;
                    d = 150.0d;
                }
            } else {
                d = OOXIXo.f3760XO;
            }
            double a2 = this.b.a();
            if (a2 > d2) {
                if (a2 > d2 * 1.25d) {
                    return true;
                }
            } else if (a2 < d * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private void d() {
        try {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.get(i).a(this.d.get());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized l b() {
        d dVar = this.b;
        if (dVar == null) {
            return l.UNKNOWN;
        }
        try {
            return a(dVar.a());
        } catch (Throwable th) {
            th.printStackTrace();
            return l.UNKNOWN;
        }
    }

    private k() {
        this.b = new d(0.05d);
        this.c = false;
        this.d = new AtomicReference<>(l.UNKNOWN);
        this.f = new ArrayList<>();
    }

    public synchronized void a(long j, long j2) {
        l b2;
        double d = ((j * 1.0d) / j2) * 8.0d;
        if (j2 == 0 || d < 3.0d) {
            return;
        }
        try {
            this.b.a(d);
            b2 = b();
        } catch (Throwable unused) {
        }
        if (this.c) {
            this.g++;
            if (b2 != this.e.get()) {
                this.c = false;
                this.g = 1;
            }
            if (this.g >= 5.0d && c()) {
                this.c = false;
                this.g = 1;
                this.d.set(this.e.get());
                d();
            }
            return;
        }
        if (this.d.get() != b2) {
            this.c = true;
            this.e = new AtomicReference<>(b2);
        }
    }

    private l a(double d) {
        if (d < OOXIXo.f3760XO) {
            return l.UNKNOWN;
        }
        if (d < 150.0d) {
            return l.POOR;
        }
        if (d < 550.0d) {
            return l.MODERATE;
        }
        if (d < 2000.0d) {
            return l.GOOD;
        }
        return l.EXCELLENT;
    }
}
