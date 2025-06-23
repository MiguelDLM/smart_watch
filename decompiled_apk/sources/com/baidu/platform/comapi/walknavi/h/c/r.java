package com.baidu.platform.comapi.walknavi.h.c;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class r implements com.baidu.platform.comapi.walknavi.e.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9790a;
    final /* synthetic */ c b;

    public r(c cVar, String str) {
        this.b = cVar;
        this.f9790a = str;
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(boolean z, float f) {
        Handler handler;
        if (z) {
            this.b.U = z;
            handler = this.b.o;
            handler.postDelayed(new s(this), 500L);
            return;
        }
        com.baidu.platform.comapi.walknavi.e.e.c().a(this.f9790a, true);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.b("aaaaa progress: " + i);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(int i, String str) {
        com.baidu.platform.comapi.wnplatform.d.a.b("aaaaa responseCode = " + i + ", responseMessage = " + str);
    }
}
