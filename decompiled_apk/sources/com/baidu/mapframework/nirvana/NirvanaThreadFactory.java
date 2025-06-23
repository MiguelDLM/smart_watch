package com.baidu.mapframework.nirvana;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes7.dex */
public class NirvanaThreadFactory implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private String f6077a;

    public NirvanaThreadFactory(String str) {
        this.f6077a = "Nirvana-ThreadFactory-" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new NirvanaThread(runnable, this.f6077a);
    }
}
