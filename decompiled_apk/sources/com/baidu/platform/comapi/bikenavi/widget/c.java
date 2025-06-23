package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9561a;

    public c(a aVar) {
        this.f9561a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        CustomScrollView customScrollView;
        int i;
        int i2;
        int i3;
        CustomScrollView customScrollView2;
        a aVar = this.f9561a;
        aVar.G = com.baidu.platform.comapi.wnplatform.p.h.e(aVar.f9557a) - com.baidu.platform.comapi.wnplatform.p.h.a(this.f9561a.f9557a, a.H + a.l);
        customScrollView = this.f9561a.n;
        i = this.f9561a.G;
        customScrollView.setBlankHeight(i);
        i2 = this.f9561a.G;
        Activity activity = this.f9561a.f9557a;
        int i4 = a.H + a.l;
        i3 = a.I;
        int a2 = i2 + com.baidu.platform.comapi.wnplatform.p.h.a(activity, i4 - i3);
        customScrollView2 = this.f9561a.n;
        customScrollView2.setStatusHeight(a2, 0);
    }
}
