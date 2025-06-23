package com.baidu.mapsdkplatform.comapi.map.a;

import com.baidu.mapapi.map.track.TraceOverlay;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TraceOverlay f6173a;
    final /* synthetic */ c b;

    public e(c cVar, TraceOverlay traceOverlay) {
        this.b = cVar;
        this.f6173a = traceOverlay;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        com.baidu.mapsdkplatform.comapi.map.c cVar;
        a aVar2;
        aVar = this.b.f6170a;
        if (aVar != null) {
            cVar = this.b.b;
            if (cVar != null) {
                this.b.c(this.f6173a);
                aVar2 = this.b.f6170a;
                aVar2.a();
            }
        }
    }
}
