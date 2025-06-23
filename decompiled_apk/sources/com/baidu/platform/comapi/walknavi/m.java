package com.baidu.platform.comapi.walknavi;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f9829a;

    public m(l lVar) {
        this.f9829a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f9829a.f9828a.B;
        com.baidu.platform.comapi.wnplatform.p.l.a(context, com.baidu.platform.comapi.walknavi.b.a.f9701a);
    }
}
