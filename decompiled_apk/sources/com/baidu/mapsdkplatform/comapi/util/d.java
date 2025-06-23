package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f6205a;
    final /* synthetic */ c b;

    public d(c cVar, String str) {
        this.b = cVar;
        this.f6205a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.b.d;
        int unused = c.b = context.getSharedPreferences("ad_auth", 0).getInt(this.f6205a, 0);
    }
}
