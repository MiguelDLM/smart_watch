package com.baidu.platform.comapi.walknavi.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9807a;

    public i(b bVar) {
        this.f9807a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9807a.n != null) {
            this.f9807a.n.g();
        }
    }
}
