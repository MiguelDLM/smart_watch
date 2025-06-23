package com.baidu.navisdk.ui.routeguide.navicenter.impl;

import android.os.Message;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.navicenter.BNavigatorLogic;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.ProNaviStatItem;

/* loaded from: classes8.dex */
public class f implements com.baidu.navisdk.comapi.routeguide.b {

    /* renamed from: a, reason: collision with root package name */
    private Long f9071a = -1L;
    private boolean b = true;
    private BNavigatorLogic c;

    public f(BNavigatorLogic bNavigatorLogic) {
        this.c = bNavigatorLogic;
    }

    @Override // com.baidu.navisdk.comapi.routeguide.b
    public void a(Message message) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
        if (gVar.b()) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.ui.routeguide.b.V().b(), "来自引擎：卫星 changed, arg1=" + message.arg1);
            SDKDebugFileUtil.get(SDKDebugFileUtil.SYSLOC_FILENAME).add("From enginee: onGpsStatusChange msg.arg1=" + message.arg1);
        }
        if (gVar.a()) {
            gVar.a("From enginee: onGpsStatusChange msg.arg1= " + message.arg1);
        }
        if (message.arg1 == 1 && a0.I().j() > 0 && com.baidu.navisdk.ui.routeguide.b.V().e() != null) {
            com.baidu.navisdk.ui.routeguide.b.V().e().removeMessages(10931);
        }
        int i = message.arg1;
        if (i == 0) {
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.c.q().i(), false);
            com.baidu.navisdk.util.worker.c.a().a(this.c.q().i(), new com.baidu.navisdk.util.worker.e(2, 0), 60000L);
        } else if (i == 1) {
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.c.q().i(), false);
        }
        if (a0.I().t()) {
            if (message.arg1 == 0) {
                if (RouteGuideParams.getRouteGuideMode() != 2) {
                    ProNaviStatItem.O().o();
                }
                ProNaviStatItem.O().J();
            } else {
                ProNaviStatItem.O().r();
            }
        }
        a(message.arg1 == 0);
        int i2 = message.arg1;
        if (i2 == 0 || i2 == 1) {
            a0.I().h(message.arg1 == 1);
            if (x.b().j2()) {
                x.b().N3();
                x.b().n4();
            }
            x.b().E(a0.I().j());
            x.b().o4();
            x.b().V3();
            com.baidu.navisdk.module.a.h().a(message.arg1 == 1);
            if (a0.I().t()) {
                com.baidu.navisdk.module.pronavi.model.g.o().h = true;
            } else {
                com.baidu.navisdk.module.pronavi.model.g.o().h = false;
            }
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().P4();
        }
    }

    private void a(boolean z) {
        if (this.f9071a.longValue() <= 0) {
            this.f9071a = Long.valueOf(System.currentTimeMillis());
            this.b = z;
            return;
        }
        boolean z2 = this.b;
        if (z2 == z) {
            return;
        }
        if (z2) {
            int currentTimeMillis = (int) ((System.currentTimeMillis() - this.f9071a.longValue()) / 1000);
            if (currentTimeMillis <= 0) {
                currentTimeMillis = 1;
            }
            if (RouteGuideParams.getRouteGuideMode() == 2) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("8.3.2", "2", currentTimeMillis + "", "");
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().a("8.3.2", "1", currentTimeMillis + "", "");
            }
            LogUtil.e("gpsStatusChangeStatics lost times:", currentTimeMillis + "");
        } else {
            this.f9071a = Long.valueOf(System.currentTimeMillis());
        }
        this.b = z;
    }
}
