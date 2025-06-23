package com.alimm.tanx.core.bridge;

public final /* synthetic */ class I0Io implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ String f1161Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ TanxJsBridge f1162XO;

    public /* synthetic */ I0Io(TanxJsBridge tanxJsBridge, String str) {
        this.f1162XO = tanxJsBridge;
        this.f1161Oo = str;
    }

    public final void run() {
        this.f1162XO.lambda$dispatch$2(this.f1161Oo);
    }
}
