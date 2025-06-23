package com.ss.android.downloadlib.g;

import java.lang.ref.SoftReference;

/* loaded from: classes11.dex */
public class c<P, R> implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private P f26119a;
    private R b;
    private int c;
    private SoftReference<a<P, R>> d;
    private c<?, P> e;
    private c<R, ?> f;

    /* loaded from: classes11.dex */
    public interface a<PARAM, RESULT> {
        RESULT a(PARAM param);
    }

    private c(int i, a<P, R> aVar, P p) {
        this.c = i;
        this.d = new SoftReference<>(aVar);
        this.f26119a = p;
    }

    public static <P, R> c<P, R> a(a<P, R> aVar, P p) {
        return new c<>(2, aVar, p);
    }

    private R b() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public void run() {
        c<?, P> cVar;
        if (this.c == 0 && !m.b()) {
            com.ss.android.downloadlib.g.a().b().post(this);
            return;
        }
        if (this.c == 1 && m.b()) {
            com.ss.android.downloadlib.d.a().a(this);
            return;
        }
        if (this.c == 2 && m.b()) {
            com.ss.android.downloadlib.d.a().b(this);
            return;
        }
        if (this.f26119a == null && (cVar = this.e) != null) {
            this.f26119a = cVar.b();
        }
        a<P, R> aVar = this.d.get();
        if (aVar == null) {
            return;
        }
        this.b = aVar.a(this.f26119a);
        c<R, ?> cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> c<R, NR> a(int i, a<R, NR> aVar) {
        c cVar = (c<R, ?>) new c(i, aVar, null);
        this.f = cVar;
        cVar.e = this;
        return cVar;
    }

    public <NR> c<R, NR> a(a<R, NR> aVar) {
        return a(0, aVar);
    }

    public void a() {
        c<?, P> cVar = this.e;
        if (cVar != null) {
            cVar.a();
        } else {
            run();
        }
    }
}
