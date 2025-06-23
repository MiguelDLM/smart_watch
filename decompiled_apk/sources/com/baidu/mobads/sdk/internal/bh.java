package com.baidu.mobads.sdk.internal;

import java.lang.Thread;

/* loaded from: classes7.dex */
class bh implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bg f6247a;

    public bh(bg bgVar) {
        this.f6247a = bgVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        az.h("ThreadPoolFactory").c("线程名字=" + thread.getName() + "线程crash信息", th);
    }
}
