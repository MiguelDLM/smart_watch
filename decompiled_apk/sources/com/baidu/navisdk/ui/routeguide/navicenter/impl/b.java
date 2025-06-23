package com.baidu.navisdk.ui.routeguide.navicenter.impl;

import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.control.r;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.navicenter.BNavigatorLogic;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class b extends e {
    public b(BNavigatorLogic bNavigatorLogic) {
        super(bNavigatorLogic);
    }

    private void h(boolean z) {
        boolean z2 = false;
        if (z) {
            if (BNCommSettingManager.getInstance().getVoiceMode() == 2) {
                x.b().U(true);
                return;
            } else {
                if (com.baidu.navisdk.util.common.d.c(com.baidu.navisdk.framework.a.c().a()) > 0) {
                    x.b().U(false);
                    return;
                }
                return;
            }
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a b = x.b();
        if (com.baidu.navisdk.util.common.d.c(com.baidu.navisdk.framework.a.c().a()) <= 0) {
            z2 = true;
        }
        b.U(z2);
    }

    @Override // com.baidu.navisdk.ui.routeguide.navicenter.impl.e, com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean a(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BaseProNaviImpl", "setRoadConditionEnable -> enable = " + z);
        }
        if (!com.baidu.navisdk.ui.routeguide.b.W()) {
            LogUtil.e("BaseProNaviImpl", "setRoadConditionEnable -> isNaviBegin=false, return !");
            return false;
        }
        boolean a2 = super.a(z);
        if (a2) {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().d5();
        }
        return a2;
    }

    @Override // com.baidu.navisdk.ui.routeguide.navicenter.impl.e, com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean c() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BaseProNaviImpl", "refreshRoute ->");
        }
        if (!com.baidu.navisdk.ui.routeguide.b.W()) {
            LogUtil.e("BaseProNaviImpl", "refreshRoute -> isNaviBegin=false, return !");
            return false;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().b("3.h");
        if (com.baidu.navisdk.poisearch.model.a.k().h()) {
            r.i().f();
        }
        com.baidu.navisdk.ui.routeguide.b.V().r().l();
        if (!y.d(com.baidu.navisdk.ui.routeguide.b.V().c())) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.ui.routeguide.b.V().c(), JarUtils.getResources().getString(R.string.nsdk_string_rg_avoid_traffic_network_failture));
            LogUtil.e("BaseProNaviImpl", "refreshRoute -> isNetworkAvailable = false");
            return false;
        }
        com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410302", "410302");
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().r4();
        boolean c = super.c();
        com.baidu.navisdk.ui.routeguide.asr.c.n().b(false);
        return c;
    }

    @Override // com.baidu.navisdk.ui.routeguide.navicenter.impl.e, com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean g() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BaseProNaviImpl", "offlineToOnline ->");
        }
        if (!com.baidu.navisdk.ui.routeguide.b.W()) {
            LogUtil.e("BaseProNaviImpl", "offlineToOnline -> isNaviBegin=false, return !");
            return false;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().b("3.h");
        if (com.baidu.navisdk.poisearch.model.a.k().h()) {
            r.i().f();
        }
        com.baidu.navisdk.ui.routeguide.b.V().r().n();
        x.b().f4();
        boolean g = super.g();
        com.baidu.navisdk.ui.routeguide.asr.c.n().b(false);
        return g;
    }

    @Override // com.baidu.navisdk.ui.routeguide.navicenter.impl.e, com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean a(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BaseProNaviImpl", "setVoiceMode -> " + i);
        }
        if (!com.baidu.navisdk.ui.routeguide.b.W()) {
            LogUtil.e("BaseProNaviImpl", "setVoiceModeNovice -> isNaviBegin=false, return !");
            return false;
        }
        boolean a2 = super.a(i);
        if (a2) {
            h(!c(i));
        }
        return a2;
    }

    @Override // com.baidu.navisdk.ui.routeguide.navicenter.impl.e, com.baidu.navisdk.framework.interfaces.pronavi.i
    public void a(int i, com.baidu.navisdk.framework.interfaces.pronavi.g gVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BaseProNaviImpl", "changePrefer(preferType, callback) -> preferType = " + i);
        }
        if (!com.baidu.navisdk.ui.routeguide.b.W()) {
            LogUtil.e("BaseProNaviImpl", "changePrefer -> isNaviBegin=false, return !");
        } else {
            super.a(i, gVar);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.navicenter.impl.e, com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean a(String str, ArrayList<String> arrayList) {
        if (!y.d(com.baidu.navisdk.framework.a.c().a()) || l0.c(str) || com.baidu.navisdk.module.international.a.a(b())) {
            return false;
        }
        int a2 = com.baidu.navisdk.ui.routeguide.b.V().d().a();
        if (com.baidu.navisdk.ui.routeguide.b.V().d().a(a2)) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.a", Integer.toString(a2), "1", null);
            l.l().i();
            return false;
        }
        return super.a(str, arrayList);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean c(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BaseProNaviImpl", "setGuideVoiceEnable -> enable = " + z);
        }
        if (!com.baidu.navisdk.ui.routeguide.b.W()) {
            LogUtil.e("BaseProNaviImpl", "setGuideVoiceEnable -> isNaviBegin=false, return !");
            return false;
        }
        return a(z ? 0 : BNCommSettingManager.getInstance().getLastQuiteMode());
    }
}
