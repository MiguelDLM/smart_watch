package com.baidu.mapapi.utils;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f6018a;
    final /* synthetic */ int b;

    public f(Context context, int i) {
        this.f6018a = context;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread thread;
        long currentTimeMillis = System.currentTimeMillis();
        do {
            if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                b.a(this.f6018a);
                b.a(this.b, this.f6018a);
            }
            thread = b.x;
        } while (!thread.isInterrupted());
    }
}
