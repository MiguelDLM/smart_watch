package com.baidu.platform.comapi.walknavi.h;

import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9811a;

    public m(b bVar) {
        this.f9811a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.platform.comapi.walknavi.b.a().K().f()) {
            com.baidu.platform.comapi.walknavi.b.a().M().run(RGFSMTable.FsmEvent.BTN_CLICK_LOC_CAR);
        }
    }
}
