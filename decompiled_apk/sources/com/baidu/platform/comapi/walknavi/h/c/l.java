package com.baidu.platform.comapi.walknavi.h.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9784a;
    final /* synthetic */ c b;

    public l(c cVar, String str) {
        this.b = cVar;
        this.f9784a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.b.a().K().d(true);
        this.b.c(this.f9784a);
    }
}
