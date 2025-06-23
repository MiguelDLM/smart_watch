package com.baidu.platform.comapi.walknavi.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9819a;
    final /* synthetic */ b b;

    public u(b bVar, int i) {
        this.b = bVar;
        this.f9819a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.wnplatform.j.n.a().a(b.m(), this.f9819a);
    }
}
