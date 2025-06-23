package com.baidu.navisdk.ui.routeguide.control;

import com.baidu.navisdk.ui.routeguide.mapmode.subview.j0;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public final class t implements com.baidu.navisdk.module.pronavi.abs.b {
    public void a() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RG3DCarLogoPanelControl", "show PlateLimitSetting Panel: ");
        }
        com.baidu.navisdk.asr.d.B().a(1);
        com.baidu.navisdk.asr.d.B().c();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().m();
        s.T().o();
        i.g().a(new j0());
    }

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
    }

    public void a(boolean z) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.k a2 = i.g().a(1009);
        if (z && (a2 instanceof j0)) {
            ((j0) a2).p();
        } else {
            i.g().b(1009);
        }
    }
}
