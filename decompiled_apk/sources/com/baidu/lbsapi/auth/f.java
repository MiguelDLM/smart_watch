package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f5587a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ e e;

    public f(e eVar, String str, int i, String str2, String str3) {
        this.e = eVar;
        this.f5587a = str;
        this.b = i;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        HashMap<String, String> hashMap;
        b.a("postWithHttps start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        context = this.e.f5586a;
        i iVar = new i(context);
        hashMap = this.e.b;
        this.e.a(iVar.a(hashMap, this.f5587a, this.b, this.c, this.d));
    }
}
