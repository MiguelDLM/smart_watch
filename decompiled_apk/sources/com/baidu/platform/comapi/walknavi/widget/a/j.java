package com.baidu.platform.comapi.walknavi.widget.a;

import com.baidu.ar.NavigationConfiguration;
import com.baidu.ar.NavigationController;
import com.baidu.ar.OnSetupComplete;
import com.baidu.ar.marker.PositioningModuleAddListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class j implements OnSetupComplete {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9866a;

    public j(a aVar) {
        this.f9866a = aVar;
    }

    @Override // com.baidu.ar.OnSetupComplete
    public void onSetup() {
        PositioningModuleAddListener positioningModuleAddListener;
        a.f9843a = true;
        com.baidu.platform.comapi.walknavi.b.a().b("call loadcase!!!");
        if (com.baidu.platform.comapi.wnplatform.a.a().e() != null) {
            NavigationController e = com.baidu.platform.comapi.wnplatform.a.a().e();
            NavigationConfiguration navigationConfiguration = NavigationConfiguration.IMU;
            positioningModuleAddListener = this.f9866a.B;
            e.runWithInitConfiguration(navigationConfiguration, positioningModuleAddListener);
            com.baidu.platform.comapi.walknavi.b.a().b("run imu!!!");
        }
    }
}
