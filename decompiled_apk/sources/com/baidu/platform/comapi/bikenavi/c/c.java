package com.baidu.platform.comapi.bikenavi.c;

import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9544a;

    public c(b bVar) {
        this.f9544a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.platform.comapi.walknavi.b.a().K().f()) {
            com.baidu.platform.comapi.walknavi.b.a().M().run(RGFSMTable.FsmEvent.BTN_CLICK_LOC_CAR);
        }
    }
}
