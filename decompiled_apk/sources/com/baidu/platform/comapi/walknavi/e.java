package com.baidu.platform.comapi.walknavi;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9712a;
    final /* synthetic */ b b;

    public e(b bVar, String str) {
        this.b = bVar;
        this.f9712a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.M().setInitialState(this.f9712a);
        this.b.M().runCurrentState();
    }
}
