package com.baidu.platform.comapi.walknavi.h;

import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9815a;

    public q(b bVar) {
        this.f9815a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.b.a().K().j();
        com.baidu.platform.comapi.walknavi.b.a().M().run(RGFSMTable.FsmEvent.BTN_CLICK_CAR_3D);
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
    }
}
