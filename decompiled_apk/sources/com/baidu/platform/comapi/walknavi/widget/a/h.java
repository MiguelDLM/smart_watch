package com.baidu.platform.comapi.walknavi.widget.a;

import com.baidu.ar.marker.PositioningModuleAddListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class h implements PositioningModuleAddListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9864a;

    public h(a aVar) {
        this.f9864a = aVar;
    }

    @Override // com.baidu.ar.marker.PositioningModuleAddListener
    public void addPositioningResult(boolean z) {
        if (z) {
            com.baidu.platform.comapi.walknavi.b.a().b("run IMU callback!!!" + z);
            this.f9864a.v = true;
            com.baidu.platform.comapi.wnplatform.a.a().b(true);
        }
    }
}
