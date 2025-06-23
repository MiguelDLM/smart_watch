package com.baidu.mshield.x6.d;

import android.content.Context;

/* loaded from: classes7.dex */
public class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f6435a;

    public g(f fVar) {
        this.f6435a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        try {
            f fVar = this.f6435a;
            context = fVar.b;
            fVar.b(context);
        } catch (Throwable th) {
            com.baidu.mshield.x6.e.f.a(th);
        }
    }
}
