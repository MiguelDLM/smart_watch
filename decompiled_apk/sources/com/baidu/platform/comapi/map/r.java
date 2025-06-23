package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bitmap f9671a;
    final /* synthetic */ o b;

    public r(o oVar, Bitmap bitmap) {
        this.b = oVar;
        this.f9671a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        cVar = this.b.j;
        cVar.a(this.f9671a);
    }
}
