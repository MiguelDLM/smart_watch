package com.baidu.mshield.core;

import java.util.TimerTask;

/* loaded from: classes7.dex */
public final class b extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.baidu.mshield.c f6375a;

    public b(com.baidu.mshield.c cVar) {
        this.f6375a = cVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f6375a.a("4.2.2", this.f6375a.a("4.2.2") - 1);
    }
}
