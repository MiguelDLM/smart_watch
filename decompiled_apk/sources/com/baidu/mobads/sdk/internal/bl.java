package com.baidu.mobads.sdk.internal;

/* loaded from: classes7.dex */
final class bl implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f6250a;

    public bl(Runnable runnable) {
        this.f6250a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6250a.run();
    }
}
