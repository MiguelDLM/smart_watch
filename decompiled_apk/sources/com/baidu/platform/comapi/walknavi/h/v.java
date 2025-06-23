package com.baidu.platform.comapi.walknavi.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9820a;

    public v(b bVar) {
        this.f9820a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9820a.y();
        com.baidu.platform.comapi.walknavi.b.a().O().b("WALKNAVI_AR_ADJUST_HAS_SHOW", true);
    }
}
