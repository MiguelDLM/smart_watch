package com.baidu.platform.comapi.walknavi.h.c;

import android.view.View;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class v implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f9794a;

    public v(c cVar) {
        this.f9794a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        com.baidu.platform.comapi.wnplatform.m.a.a().a("FootNaviPG.turnDire");
        com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "loc click:" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.s());
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE) {
            i = this.f9794a.w;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        com.baidu.platform.comapi.walknavi.b.a().M().run(RGFSMTable.FsmEvent.BTN_CLICK_LOC_CAR);
                        return;
                    }
                    return;
                }
                com.baidu.platform.comapi.walknavi.b.a().M().run(RGFSMTable.FsmEvent.BTN_CLICK_NORTH_2D);
                return;
            }
            com.baidu.platform.comapi.walknavi.b.a().M().run(RGFSMTable.FsmEvent.BTN_CLICK_CAR_3D);
            return;
        }
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
        com.baidu.platform.comapi.walknavi.b.a().K().j();
        this.f9794a.a(true);
    }
}
