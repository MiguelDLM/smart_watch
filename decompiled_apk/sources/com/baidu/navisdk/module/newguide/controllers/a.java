package com.baidu.navisdk.module.newguide.controllers;

import android.content.SharedPreferences;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.control.q;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i;
import com.baidu.navisdk.ui.routeguide.model.g;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class a implements com.baidu.navisdk.module.pronavi.abs.b {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.ui.routeguide.subview.a f7214a;
    private SharedPreferences.OnSharedPreferenceChangeListener b;
    private HashMap<String, Object> c;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int d = -1;
    private int e = -1;
    private boolean m = false;

    private void b() {
        com.baidu.navisdk.ui.routeguide.subview.a aVar;
        if (RouteGuideParams.NavState.NAV_STATE_OPERATE.equals(g.h().b()) && (aVar = this.f7214a) != null) {
            aVar.a(3, 0, 0, null);
        }
    }

    public void a(com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        this.f7214a = aVar;
        this.m = true;
        this.d = BNCommSettingManager.getInstance().getIsShowMapSwitch();
        this.e = BNCommSettingManager.getInstance().getSimpleGuideMode();
        this.f = BNCommSettingManager.getInstance().getPrefRealEnlargementNavi();
        BNCommSettingManager.getInstance().isShowLaneLine();
        this.g = BNCommSettingManager.getInstance().isShowSpeedClock();
        this.h = BNCommSettingManager.getInstance().isShowHighSpeedPanel();
        this.i = BNCommSettingManager.getInstance().isShowCurrentRoad();
        this.j = BNCommSettingManager.getInstance().isShowCarDirCompass();
        this.k = BNCommSettingManager.getInstance().getShowCarLogoToEnd();
        this.l = BNCommSettingManager.getInstance().isShowXiaoDu();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCustomNaviViewControl", "loadCurrentSetting: " + this.e);
        }
    }

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.b;
        if (onSharedPreferenceChangeListener != null) {
            BNSettingManager.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            this.b = null;
        }
        HashMap<String, Object> hashMap = this.c;
        if (hashMap != null && !hashMap.isEmpty()) {
            this.c.clear();
            this.c = null;
        }
    }

    public void a() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCustomNaviViewControl", "handlerUserSettingChange: " + this.m);
        }
        if (this.m) {
            this.m = false;
            int isShowMapSwitch = BNCommSettingManager.getInstance().getIsShowMapSwitch();
            if (this.d != isShowMapSwitch) {
                x.b().a(24, 23, 22);
                com.baidu.navisdk.ui.routeguide.b.V().b(isShowMapSwitch);
                x.b().I().b(true);
                x.b().Y2();
                b();
                if (isShowMapSwitch == 0) {
                    com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_roadconditon_mapmini"));
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.p.1", null, null, "1");
                } else {
                    com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_roadconditon_bar"));
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.p.2", null, null, "1");
                }
            }
            int simpleGuideMode = BNCommSettingManager.getInstance().getSimpleGuideMode();
            if (gVar.d()) {
                gVar.e("RGCustomNaviViewControl", "handlerUserSettingChange:mSimpleGuideMode " + this.e + ",mode: " + simpleGuideMode + ",isEnable: " + com.baidu.navisdk.function.b.FUNC_SIMPLE_GUIDE_MODE.a());
            }
            if (this.e != simpleGuideMode && com.baidu.navisdk.function.b.FUNC_SIMPLE_GUIDE_MODE.a()) {
                x.b().L4();
                b();
                BNMapController.getInstance().setSimpleModeGuide(simpleGuideMode == 1);
                q.c().b();
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.k", simpleGuideMode == 1 ? "0" : "1", null, null);
                if (simpleGuideMode == 0) {
                    com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_standard_mode"));
                } else {
                    com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_simple_mode"));
                }
            }
            boolean prefRealEnlargementNavi = BNCommSettingManager.getInstance().getPrefRealEnlargementNavi();
            if (this.f != prefRealEnlargementNavi) {
                BNRouteGuider.getInstance().enableExpandmapDownload(prefRealEnlargementNavi);
            }
            boolean isShowSpeedClock = BNCommSettingManager.getInstance().isShowSpeedClock();
            if (this.g != isShowSpeedClock) {
                if (isShowSpeedClock && com.baidu.navisdk.module.pronavi.model.g.o().i()) {
                    com.baidu.navisdk.ui.routeguide.mapmode.a.o5().p(0);
                } else {
                    com.baidu.navisdk.ui.routeguide.mapmode.a.o5().p(8);
                }
            }
            boolean isShowHighSpeedPanel = BNCommSettingManager.getInstance().isShowHighSpeedPanel();
            if (isShowHighSpeedPanel != this.h) {
                if (isShowHighSpeedPanel) {
                    if (com.baidu.navisdk.ui.routeguide.b.V().i().c() != null && com.baidu.navisdk.ui.routeguide.b.V().i().c().s()) {
                        x.b().A4();
                    }
                } else {
                    x.b().z1();
                }
            }
            boolean isShowCurrentRoad = BNCommSettingManager.getInstance().isShowCurrentRoad();
            if (isShowCurrentRoad != this.i) {
                x.b().q(isShowCurrentRoad ? 0 : 8);
            }
            boolean showCarLogoToEnd = BNCommSettingManager.getInstance().getShowCarLogoToEnd();
            if (this.k != showCarLogoToEnd) {
                BNMapController.getInstance().setRedLineRender(showCarLogoToEnd);
            }
            boolean isShowCarDirCompass = BNCommSettingManager.getInstance().isShowCarDirCompass();
            if (this.j != isShowCarDirCompass) {
                BNMapController.getInstance().setCompassVisible(isShowCarDirCompass);
            }
            boolean isShowXiaoDu = BNCommSettingManager.getInstance().isShowXiaoDu();
            if (isShowXiaoDu != this.l) {
                i f0 = x.b().f0();
                if (f0 != null) {
                    f0.d(isShowXiaoDu ? 0 : 8);
                }
                x.b().w3();
            }
        }
    }
}
