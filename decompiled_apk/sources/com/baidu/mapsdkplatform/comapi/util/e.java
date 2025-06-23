package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f6206a;
    final /* synthetic */ int b;
    final /* synthetic */ c c;

    public e(c cVar, String str, int i) {
        this.c = cVar;
        this.f6206a = str;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.c.d;
        context.getSharedPreferences("ad_auth", 0).edit().putInt(this.f6206a, this.b).apply();
    }
}
