package com.baidu.platform.comapi.walknavi.h.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9783a;
    final /* synthetic */ c b;

    public k(c cVar, String str) {
        this.b = cVar;
        this.f9783a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.b.a().K().d(true);
        this.b.d(this.f9783a);
    }
}
