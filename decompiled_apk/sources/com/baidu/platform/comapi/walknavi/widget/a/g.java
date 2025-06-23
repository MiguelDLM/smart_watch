package com.baidu.platform.comapi.walknavi.widget.a;

import com.baidu.ar.marker.IMarkerStateListener;
import com.baidu.ar.marker.model.LocationMarkerData;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class g implements IMarkerStateListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9863a;

    public g(a aVar) {
        this.f9863a = aVar;
    }

    @Override // com.baidu.ar.marker.IMarkerStateListener
    public void compassResult(double d) {
    }

    @Override // com.baidu.ar.marker.IMarkerStateListener
    public void onCoordinateResult(int i, double[] dArr) {
    }

    @Override // com.baidu.ar.marker.IMarkerStateListener
    public void onError(int i, String str) {
    }

    @Override // com.baidu.ar.marker.IMarkerStateListener
    public void onLocationResult(boolean z, List<LocationMarkerData> list) {
    }

    @Override // com.baidu.ar.marker.IMarkerStateListener
    public void onResuourceCreated() {
        boolean z;
        com.baidu.platform.comapi.walknavi.b.a().b("***onResuourceCreated");
        com.baidu.platform.comapi.wnplatform.a.a().a(true);
        this.f9863a.k();
        z = this.f9863a.v;
        if (z) {
            this.f9863a.b(false);
        }
    }

    @Override // com.baidu.ar.marker.IMarkerStateListener
    public void onSessionCreated(boolean z, String str) {
        com.baidu.platform.comapi.walknavi.b.a().b("onCreateSessionEnd：" + z + str);
    }
}
