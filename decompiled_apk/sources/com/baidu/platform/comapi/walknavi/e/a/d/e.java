package com.baidu.platform.comapi.walknavi.e.a.d;

/* loaded from: classes8.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f9728a;
    final /* synthetic */ long b;
    final /* synthetic */ d c;

    public e(d dVar, long j, long j2) {
        this.c = dVar;
        this.f9728a = j;
        this.b = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.this.a((int) ((((float) this.f9728a) * 100.0f) / ((float) this.b)));
    }
}
