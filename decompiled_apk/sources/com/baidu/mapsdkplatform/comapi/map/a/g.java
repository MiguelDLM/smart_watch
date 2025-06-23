package com.baidu.mapsdkplatform.comapi.map.a;

import com.baidu.mapapi.map.track.TraceOverlay;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TraceOverlay f6175a;
    final /* synthetic */ c b;

    public g(c cVar, TraceOverlay traceOverlay) {
        this.b = cVar;
        this.f6175a = traceOverlay;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        this.b.c(this.f6175a);
        aVar = this.b.f6170a;
        aVar.a();
    }
}
