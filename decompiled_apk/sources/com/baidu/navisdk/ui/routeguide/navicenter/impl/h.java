package com.baidu.navisdk.ui.routeguide.navicenter.impl;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.control.p;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.n;
import com.baidu.navisdk.ui.routeguide.model.t;
import com.baidu.navisdk.ui.routeguide.model.y;
import com.baidu.navisdk.ui.routeguide.navicenter.BNavigatorLogic;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.f0;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class h extends com.baidu.navisdk.comapi.routeplan.v2.a {

    /* renamed from: a, reason: collision with root package name */
    private final BNavigatorLogic f9075a;

    public h(BNavigatorLogic bNavigatorLogic) {
        this.f9075a = bNavigatorLogic;
    }

    private void a() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuideVIA_ETA", "clearToolboxViaEta-> getUnpassedApproachPoiCount= " + com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.f());
        }
        if (com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.f() < 1) {
            x.b().D1();
            a0.I().G();
        }
    }

    private boolean b(int i) {
        if (x.b().k2()) {
            return false;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("showYawCommonMsg subType = " + i);
        }
        if (i == 1) {
            return true;
        }
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (gVar.d()) {
            gVar.e("showYawCommonMsg high," + fVar.t() + ", state:" + fVar.j());
        }
        int j = fVar.j();
        if (fVar.t() && j == 3) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.6.4.2");
            String h = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_yawing_success_on_bridge);
            p.b().a(3);
            s.T().a(h, true);
        } else if (fVar.t() && j == 4) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.6.4.3");
            String h2 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_yawing_success_under_bridge);
            p.b().a(4);
            s.T().a(h2, true);
        } else {
            com.baidu.navisdk.ui.routeguide.model.x.A().a(-1, 44);
            com.baidu.navisdk.ui.routeguide.model.x.A().z();
            String h3 = com.baidu.navisdk.ui.routeguide.model.x.A().h();
            String l = com.baidu.navisdk.ui.routeguide.model.x.A().l();
            String o = com.baidu.navisdk.ui.routeguide.model.x.A().o();
            int n = com.baidu.navisdk.ui.routeguide.model.x.A().n();
            if (TextUtils.isEmpty(h3) && TextUtils.isEmpty(o)) {
                s.T().a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_route_result_yawing_success), true);
            } else {
                if (!TextUtils.isEmpty(h3)) {
                    s.T().a(h3, l);
                }
                if (n == 1 && !TextUtils.isEmpty(o)) {
                    TTSPlayerControl.playTTS(o, 1);
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c() {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.navicenter.impl.h.c():void");
    }

    private void d() {
        int i = a0.G;
        if (i != 1) {
            if (i == 2) {
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_route_preference"));
                return;
            }
            return;
        }
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_route_search"));
    }

    @Override // com.baidu.navisdk.comapi.routeplan.v2.a
    public String getName() {
        return "Naving";
    }

    @Override // com.baidu.navisdk.comapi.routeplan.v2.a
    public boolean isPersist() {
        return true;
    }

    @Override // com.baidu.navisdk.comapi.routeplan.v2.a
    public boolean mustOnMainThread() {
        return true;
    }

    @Override // com.baidu.navisdk.comapi.routeplan.v2.a
    public void onRoutePlan(int i, int i2, com.baidu.navisdk.comapi.routeplan.v2.d dVar, Bundle bundle) {
        com.baidu.navisdk.ui.routeguide.navicenter.a i3;
        n c;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", " onRoutePlan=====resultType:" + i);
        }
        if (i == 1) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", " rpListenerV2=====  RP_BEFORE_START:" + i2);
                LogUtil.e("RouteGuide", " rpListenerV2=====  RGSimpleGuideModel.mCalcRouteType:" + a0.G);
                LogUtil.e("RouteGuide", " rpListenerV2=====  RP_BEFORE_START:" + com.baidu.navisdk.ui.routeguide.b.V().x());
            }
            this.f9075a.h(true);
            if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
                x.b().Y3();
                return;
            }
            k k = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (k != null && k.l0() != null) {
                k.l0().onStart();
            }
            int i4 = a0.G;
            if (i4 != 1) {
                if (i4 != 5) {
                    if (i4 != 6) {
                        switch (i4) {
                            case 8:
                                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().e(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_add_via_loading_text));
                                return;
                            case 9:
                                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().e(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_add_restore_dest_loading_text));
                                return;
                            case 10:
                            case 13:
                            case 14:
                                break;
                            case 11:
                                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().e(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_road_cond_refresh_ing));
                                return;
                            case 12:
                                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().e(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_add_dest_loading_text));
                                return;
                            default:
                                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().e(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_change_prefer_loading_text));
                                return;
                        }
                    } else {
                        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().e(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_del_via_loading_text));
                        return;
                    }
                }
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().e(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_voice_change_route_loading_text));
                return;
            }
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().e(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_add_via_loading_text));
            return;
        }
        if (i == 2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", " rpListenerV2=====  RP_SUCCESS_NORMAL:" + this.f9075a.L());
            }
            com.baidu.navisdk.ui.routeguide.asr.c.n().b(true);
            if (!this.f9075a.L() && !com.baidu.navisdk.ui.routeguide.control.i.g().c(1008)) {
                f0.d().a(502);
                f0.d().b(502);
                return;
            }
            if (gVar.d()) {
                gVar.e("RouteGuide", " rpListenerV2=====  RP_SUCCESS_NORMAL hasCallRerouted:" + this.f9075a.Z());
            }
            if (this.f9075a.Z()) {
                this.f9075a.h(false);
                com.baidu.navisdk.pronavi.ui.base.b bVar = (com.baidu.navisdk.pronavi.ui.base.b) this.f9075a.f();
                if (bVar != null) {
                    bVar.j().e("RGSaveParkComponent").a(10002).a();
                }
                if (this.f9075a.y() != null) {
                    this.f9075a.y().f();
                }
                Bundle bundle2 = new Bundle();
                JNIGuidanceControl.getInstance().getFirstRouteGuideInfo(bundle2);
                a0.I().a(bundle2);
                x.b().P1();
                com.baidu.navisdk.module.pronavi.model.g.o().m();
                if (i2 == 2) {
                    x.b().J(false);
                    s.T().a(JarUtils.getResources().getString(R.string.nsdk_string_rg_offline_to_online_succeed_tips), true);
                }
                if (BNavigatorLogic.z0) {
                    this.f9075a.o();
                }
                c();
                com.baidu.navisdk.framework.b.a0();
                y.d();
                this.f9075a.a(true, i2);
                x.b().J(com.baidu.navisdk.module.pronavi.a.j != 2 && BNRoutePlaner.getInstance().e() == 2);
                this.f9075a.k();
                b();
                d();
                t.s().r();
                Bundle bundle3 = new Bundle();
                JNIGuidanceControl.getInstance().getNotificationYBarMsg(bundle3, new ArrayList<>());
                s.T().b(bundle3);
                a0.G = 0;
                this.f9075a.j(false);
                return;
            }
            return;
        }
        if (i == 3 || i == 4) {
            LogUtil.e("RouteGuide", " rpListenerV2=====  RP_FAIL_NORMAL:" + i2);
            this.f9075a.c(i2);
            return;
        }
        if (i == 5) {
            LogUtil.e("RouteGuide", "rpListenerV2.peng cancleCalcRouteRequest before jump");
            if (!com.baidu.navisdk.ui.routeguide.b.W()) {
                LogUtil.e("RouteGuide", "rpListenerV2.peng cancleCalcRouteRequest return isNaviquit");
                return;
            } else if (Looper.myLooper() != Looper.getMainLooper()) {
                LogUtil.e("RouteGuide", "rpListenerV2.peng cancleCalcRouteRequest return is not mainThread");
                return;
            } else {
                com.baidu.navisdk.ui.routeguide.b.V().H();
                LogUtil.e("RouteGuide", "rpListenerV2.peng cancleCalcRouteRequest after jump");
                return;
            }
        }
        if (i == 33) {
            LogUtil.e("RouteGuide", " rpListenerV2=====  RP_FAIL_BUILD_AUTO");
            x.b().t();
            return;
        }
        if (i == 81) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "rpListenerV2=====  RC_UPDATE_SUCCESS");
            }
            if (f.q.b()) {
                t.s().r();
            }
            if (!com.baidu.navisdk.ui.routeguide.b.V().D() || (i3 = com.baidu.navisdk.ui.routeguide.b.V().i()) == null || (c = i3.c()) == null) {
                return;
            }
            c.x();
            return;
        }
        if (i == 145) {
            LogUtil.e("RouteGuide", " rpListenerV2=====  SYNC_OPERATION:" + i2);
            f0.d().b(504);
            if (i2 != 3 || this.f9075a.e0() || this.f9075a.L()) {
                return;
            }
            boolean judgeRouteInfoAllReady = JNIGuidanceControl.getInstance().judgeRouteInfoAllReady(JNIGuidanceControl.getInstance().getSelectRouteIdx());
            LogUtil.e("RouteGuide", "RP_SUCCESS_SELECT_ROUTE judgeRouteInfoAllReady isReady:" + judgeRouteInfoAllReady);
            if (judgeRouteInfoAllReady) {
                f0.d().a(502);
                f0.d().b(502);
                return;
            }
            return;
        }
        if (i == 4111) {
            a(i2);
            return;
        }
        if (i == 65) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "rpListenerV2=====  YAWING_SUCCESS");
            }
            com.baidu.navisdk.ui.routeguide.control.b.k().a(10, true);
            boolean b = s.T().b(false);
            x.b().F(false);
            if (this.f9075a.g0()) {
                this.f9075a.j(false);
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.4.1", null, "1", null);
            }
            this.f9075a.k();
            if (!b) {
                b(i2);
            }
            x.b().u(false);
            if (BNRoutePlaner.getInstance().B() && com.baidu.navisdk.ui.routeguide.module.convoy.a.c) {
                com.baidu.navisdk.ui.routeguide.module.convoy.a.c = false;
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().F3();
                return;
            }
            return;
        }
        if (i == 66) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "rpListenerV2=====  YAWING_FAILED");
            }
            this.f9075a.j(true);
            x.b().u(false);
            x.b().F(true);
            return;
        }
        if (i == 177) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", " rpListenerV2=====  RC_WEATHER_UPDATE_SUCCESS");
            }
            t.s().r();
            t.s().o();
            t.s().a(false);
            return;
        }
        if (i != 178) {
            switch (i) {
                case 17:
                    LogUtil.e("RouteGuide", " rpListenerV2=====  RP_START_BUILD:" + this.f9075a.M());
                    this.f9075a.d(true);
                    x.b().c(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_rp_start_build));
                    if (com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
                        x.b().B();
                    }
                    com.baidu.navisdk.ui.routeguide.mapmode.a.o5().v(false);
                    com.baidu.navisdk.ui.routeguide.asr.c.n().c(true);
                    return;
                case 18:
                    LogUtil.e("RouteGuide", " rpListenerV2===RP_SUCCESS_BUILD:" + this.f9075a.M() + ", subType:" + i2);
                    if (!this.f9075a.L()) {
                        f0.d().a(502);
                        f0.d().b(502);
                        return;
                    }
                    if (this.f9075a.M()) {
                        this.f9075a.d(false);
                        x.b().t();
                        BNMapController.getInstance().recoveryHighLightRoute();
                        c();
                        if (i2 == 1) {
                            com.baidu.navisdk.ui.routeguide.model.x.A().y();
                            com.baidu.navisdk.ui.routeguide.model.x.A().a(-1, 3);
                            com.baidu.navisdk.ui.routeguide.model.x.A().z();
                            if (com.baidu.navisdk.ui.routeguide.model.x.A().v == 0) {
                                com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.3", null, "1", null);
                            } else if (com.baidu.navisdk.ui.routeguide.model.x.A().v == 1 || com.baidu.navisdk.ui.routeguide.model.x.A().v == 1) {
                                com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.3", null, "2", null);
                            }
                            if (com.baidu.navisdk.ui.routeguide.model.x.A().t != null) {
                                if (!com.baidu.navisdk.ui.routeguide.mapmode.a.o5().x2()) {
                                    TTSPlayerControl.stopVoiceTTSOutput();
                                }
                                TTSPlayerControl.playTTS("叮", 1);
                                TTSPlayerControl.playTTS(com.baidu.navisdk.ui.routeguide.model.x.A().t, 1);
                            }
                            if (com.baidu.navisdk.ui.routeguide.model.x.A().u != null) {
                                s.T().a(com.baidu.navisdk.ui.routeguide.model.x.A().u);
                            }
                        } else {
                            com.baidu.navisdk.ui.routeguide.asr.instruction.d dVar2 = com.baidu.navisdk.ui.routeguide.asr.instruction.d.INSTANCE;
                            if (dVar2.b()) {
                                com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.j.7.5", dVar2.a(), "1", null);
                                dVar2.a(false);
                            }
                            s.T().P();
                            if (com.baidu.navisdk.module.asr.busi.f.c().b()) {
                                com.baidu.navisdk.module.asr.busi.f.c().a(false);
                                this.f9075a.G().a(4000L);
                                TTSPlayerControl.playXDTTSText(com.baidu.navisdk.module.asr.busi.f.c().a(), 1);
                            } else {
                                String h = com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_switch_route_success);
                                if (com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
                                    TTSPlayerControl.playXDTTSText(h, 1);
                                } else {
                                    TTSPlayerControl.playTTS(h, 1);
                                    int i5 = com.baidu.navisdk.ui.routeguide.model.x.A().r;
                                    if (i5 == 9) {
                                        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_weak_fast_route_yes"));
                                    } else if (i5 == 0) {
                                        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_multi_route_switch"));
                                    }
                                }
                            }
                        }
                        com.baidu.navisdk.naviresult.a.d().a().h();
                        return;
                    }
                    return;
                case 19:
                    LogUtil.e("RouteGuide", " rpListenerV2=====  RP_FAIL_BUILD");
                    this.f9075a.d(false);
                    if (!this.f9075a.L()) {
                        LogUtil.e("RouteGuide", " reCalcRoute");
                        l.l().a(com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k());
                        return;
                    }
                    x.b().t();
                    BNMapController.getInstance().recoveryHighLightRoute();
                    x.b().r1();
                    if (!com.baidu.navisdk.ui.routeguide.model.x.A().f8982a) {
                        com.baidu.navisdk.ui.routeguide.b.V().r().n();
                    }
                    String h2 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_rp_build_fail);
                    if (com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
                        TTSPlayerControl.playXDTTSText(h2, 1);
                    } else {
                        TTSPlayerControl.playTTS(h2, 1);
                    }
                    com.baidu.navisdk.module.asr.busi.f.c().a(false);
                    s.T().O();
                    com.baidu.navisdk.ui.routeguide.asr.instruction.d dVar3 = com.baidu.navisdk.ui.routeguide.asr.instruction.d.INSTANCE;
                    if (dVar3.b()) {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.j.7.5", dVar3.a(), "2", null);
                        dVar3.a(false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", " rpListenerV2=====  RC_WEATHER_UPDATE_FAILED");
        }
        t.s().f();
        t.s().a(false);
    }

    private void a(int i) {
        if (com.baidu.navisdk.framework.interfaces.c.p().i().t0()) {
            LogUtil.e("RouteGuide", "handleMainSlaveViaductResultMsg ,lightNavi ing");
            return;
        }
        LogUtil.e("RouteGuide", "handleMainSlaveViaductResultMsg source:" + i);
        if (i == 3) {
            p.b().a(2);
            if (com.baidu.navisdk.naviresult.a.d().a().c() != 0 && com.baidu.navisdk.naviresult.a.d().a().c() != 1) {
                com.baidu.navisdk.naviresult.a.d().a().b(3);
            } else {
                com.baidu.navisdk.naviresult.a.d().a().b(1);
            }
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_slave_route_callback"));
            return;
        }
        if (i == 4) {
            p.b().a(1);
            if (com.baidu.navisdk.naviresult.a.d().a().c() != 0 && com.baidu.navisdk.naviresult.a.d().a().c() != 1) {
                com.baidu.navisdk.naviresult.a.d().a().b(3);
            } else {
                com.baidu.navisdk.naviresult.a.d().a().b(1);
            }
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_main_route_callback"));
            return;
        }
        if (i == 5) {
            p.b().a(3);
            if (com.baidu.navisdk.naviresult.a.d().a().c() != 0 && com.baidu.navisdk.naviresult.a.d().a().c() != 2) {
                com.baidu.navisdk.naviresult.a.d().a().b(3);
            } else {
                com.baidu.navisdk.naviresult.a.d().a().b(2);
            }
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_viaduck_route_callback"));
            return;
        }
        if (i != 6) {
            if (i == 7) {
                LogUtil.e("RouteGuide", "handleMainSlaveViaductResultMsg UNKNOWN_ROUTE_PLAN_RESULT");
                p.b().a();
                return;
            }
            return;
        }
        p.b().a(4);
        if (com.baidu.navisdk.naviresult.a.d().a().c() != 0 && com.baidu.navisdk.naviresult.a.d().a().c() != 2) {
            com.baidu.navisdk.naviresult.a.d().a().b(3);
        } else {
            com.baidu.navisdk.naviresult.a.d().a().b(2);
        }
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_ground_route_callback"));
    }

    private void b() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "enterFullViewStateIfNeeded-> mCalcRouteType= " + a0.G + ", isSetFullViewByUser= " + RouteGuideFSM.getInstance().isSetFullViewByUser());
            LogUtil.printCallStack();
        }
        int i = a0.G;
        if (i == 1) {
            if (com.baidu.navisdk.poisearch.model.a.k().f() == 1) {
                RouteGuideFSM.getInstance();
                if (!RGFSMTable.FsmState.North2D.equals(RouteGuideFSM.getCurrentGlassState())) {
                    RouteGuideFSM.getInstance();
                    if (!RGFSMTable.FsmState.Car3D.equals(RouteGuideFSM.getCurrentGlassState())) {
                        return;
                    }
                }
                this.f9075a.G().a(5000L);
                return;
            }
            com.baidu.navisdk.ui.routeguide.b.V().r().n();
            return;
        }
        if (i != 5 && i != 10 && i != 7 && i != 8 && i != 13 && i != 14) {
            com.baidu.navisdk.ui.routeguide.b.V().r().n();
        } else if (!RouteGuideFSM.getInstance().isSetFullViewByUser()) {
            this.f9075a.G().a(5000L);
        } else {
            this.f9075a.G().k();
        }
    }
}
