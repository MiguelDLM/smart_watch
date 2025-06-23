package com.baidu.lbsapi.auth;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f5589a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ g e;

    public h(g gVar, String str, int i, String str2, String str3) {
        this.e = gVar;
        this.f5589a = str;
        this.b = i;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        g gVar = this.e;
        list = gVar.b;
        gVar.a(list, this.f5589a, this.b, this.c, this.d);
    }
}
