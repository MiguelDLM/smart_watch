package com.baidu.navisdk.ui.routeguide.asr.instruction;

import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class c {

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            if (com.baidu.navisdk.ui.routeguide.utils.b.w()) {
                return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.bnav_rg_hd_navi_no_support_xd_tip));
            }
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.9.2");
            BNCommSettingManager.getInstance().setSimpleGuideMode(0);
            com.baidu.navisdk.logicframe.b h = com.baidu.navisdk.ui.routeguide.b.V().h();
            if (h != null) {
                h.j().e("RGGuidePanelModelService").a(30001).a((Object) 0).a();
            }
            com.baidu.navisdk.ui.routeguide.control.x.b().L4();
            BNMapController.getInstance().setSimpleModeGuide(!com.baidu.navisdk.ui.routeguide.utils.b.x());
            com.baidu.navisdk.ui.routeguide.control.q.c().b();
            return com.baidu.navisdk.module.asr.instructions.b.b("已切换经典诱导面板");
        }
    }

    /* loaded from: classes8.dex */
    public class a0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            if (c.a()) {
                return null;
            }
            BNSettingManager.setFirstRefreshRoute(false);
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.7.8");
            if (JNIGuidanceControl.getInstance().getViaCnt() >= 1) {
                return com.baidu.navisdk.module.asr.instructions.b.b("添加途经点后不支持该功能");
            }
            com.baidu.navisdk.ui.routeguide.model.x.A().a(true);
            com.baidu.navisdk.ui.routeguide.b.V().l().c();
            return com.baidu.navisdk.module.asr.instructions.b.a();
        }
    }

    /* loaded from: classes8.dex */
    public class a1 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            if (com.baidu.navisdk.ui.routeguide.utils.b.o().f != 0) {
                return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.bnav_rg_hd_navi_no_support_xd_tip));
            }
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.9.1");
            com.baidu.navisdk.ui.routeguide.b.V().b(1);
            com.baidu.navisdk.ui.routeguide.control.x.b().I().b(true);
            com.baidu.navisdk.ui.routeguide.control.x.b().Y2();
            if (RouteGuideParams.NavState.NAV_STATE_OPERATE.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b())) {
                com.baidu.navisdk.ui.routeguide.b.V().r().l();
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_roadbar_minimap));
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            if (com.baidu.navisdk.ui.routeguide.utils.b.w()) {
                return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.bnav_rg_hd_navi_no_support_xd_tip));
            }
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.9.3");
            BNCommSettingManager.getInstance().setSimpleGuideMode(1);
            com.baidu.navisdk.logicframe.b h = com.baidu.navisdk.ui.routeguide.b.V().h();
            if (h != null) {
                h.j().e("RGGuidePanelModelService").a(30001).a((Object) 1).a();
            }
            com.baidu.navisdk.ui.routeguide.control.x.b().L4();
            BNMapController.getInstance().setSimpleModeGuide(true ^ com.baidu.navisdk.ui.routeguide.utils.b.x());
            com.baidu.navisdk.ui.routeguide.control.q.c().b();
            return com.baidu.navisdk.module.asr.instructions.b.b("已切换简约诱导面板");
        }
    }

    /* loaded from: classes8.dex */
    public class b0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.asr.d.B().c();
            if (com.baidu.navisdk.ui.routeguide.control.x.b().q2()) {
                return null;
            }
            com.baidu.navisdk.ui.routeguide.control.x.b().y(2);
            com.baidu.navisdk.framework.interfaces.pronavi.j k = com.baidu.navisdk.ui.routeguide.b.V().k();
            if (k != null) {
                k.c();
            }
            TTSPlayerControl.playXDTTSText(JarUtils.getResources().getString(R.string.nsdk_string_open_more_setting), 1);
            return null;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.asr.instruction.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0422c extends com.baidu.navisdk.asr.a {

        /* renamed from: com.baidu.navisdk.ui.routeguide.asr.instruction.c$c$a */
        /* loaded from: classes8.dex */
        public class a extends com.baidu.navisdk.util.worker.f<String, String> {
            public a(C0422c c0422c, String str, String str2) {
                super(str, str2);
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.a", "1", "1", null);
                com.baidu.navisdk.module.abtest.model.k.x().t();
                com.baidu.navisdk.ui.routeguide.b.V().Q();
                return null;
            }
        }

        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.6");
            com.baidu.navisdk.util.worker.c.a().a(new a(this, "exitNav-" + C0422c.class.getSimpleName(), null), new com.baidu.navisdk.util.worker.e(2, 0), 1500L);
            return com.baidu.navisdk.module.asr.instructions.b.b("下次见");
        }
    }

    /* loaded from: classes8.dex */
    public class c0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String str;
            if (c.a()) {
                return null;
            }
            BNSettingManager.setFirstSwitchRoute(false);
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.l.1.7");
            if (BNRoutePlaner.getInstance().a(aVar.f6554x0) >= 0) {
                com.baidu.navisdk.module.asr.busi.f.c().a(true);
                com.baidu.navisdk.module.asr.busi.f.c().a(aVar.m);
                str = "";
            } else {
                str = "切换失败,将继续当前导航";
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(str);
        }
    }

    /* loaded from: classes8.dex */
    public class d extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.5.1");
            if (c.a()) {
                return null;
            }
            if (JNIGuidanceControl.getInstance().getViaCnt() >= 1) {
                return com.baidu.navisdk.module.asr.instructions.b.b("添加途经点后不支持该功能");
            }
            if (com.baidu.navisdk.module.asr.h.a()) {
                return com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.asr_rg_pref_off_line_not_use));
            }
            if (com.baidu.navisdk.ui.routeguide.b.V().c() != null && com.baidu.navisdk.util.common.y.d(com.baidu.navisdk.ui.routeguide.b.V().c()) && BNRouteGuider.getInstance().isCurDriveRouteOnline()) {
                com.baidu.navisdk.util.common.g.ASR.e("XDVoice", "excute - changeFasterRoute()");
                c.b(26);
                return null;
            }
            com.baidu.navisdk.util.common.g.ASR.e("XDVoice", "changeFasterRoute() -- offlineMode -- retuen");
            return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_avoid_traffic_no_route));
        }
    }

    /* loaded from: classes8.dex */
    public class d0 extends com.baidu.navisdk.asr.a {

        /* loaded from: classes8.dex */
        public class a extends com.baidu.navisdk.asr.i.a {
            public a() {
            }

            @Override // com.baidu.navisdk.asr.i.a
            public void a(String str, boolean z) {
                super.a(str, z);
                if (z) {
                    if (com.baidu.navisdk.module.routepreference.d.j().h()) {
                        com.baidu.navisdk.module.routepreference.d.j().b(false);
                        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().G(7);
                        d0.this.a();
                    }
                    com.baidu.navisdk.asr.d.B().a(com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.nsdk_limit_voice_close_tip_yes)));
                    return;
                }
                com.baidu.navisdk.asr.d.B().a(com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.nsdk_limit_voice_close_tip_no)));
            }

            @Override // com.baidu.navisdk.asr.i.a
            public void b() {
                com.baidu.navisdk.asr.d.B().c();
            }
        }

        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String string;
            if (aVar.t0 == 1) {
                com.baidu.navisdk.module.asr.instructions.b.a("3.c.l.2.0");
            } else {
                com.baidu.navisdk.module.asr.instructions.b.a("3.c.l.2.1");
            }
            if (com.baidu.navisdk.module.asr.h.a()) {
                return com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.asr_rg_pref_off_line_not_use));
            }
            if (TextUtils.isEmpty(com.baidu.navisdk.h.a())) {
                string = JarUtils.getResources().getString(R.string.nsdk_limit_voice_not_set);
            } else if (aVar.t0 == 1) {
                string = JarUtils.getResources().getString(R.string.nsdk_limit_voice_open_tip);
                if (!com.baidu.navisdk.module.routepreference.d.j().h()) {
                    com.baidu.navisdk.module.routepreference.d.j().b(true);
                    com.baidu.navisdk.ui.routeguide.mapmode.a.o5().G(7);
                    a();
                }
            } else {
                if (com.baidu.navisdk.module.routepreference.d.j().h()) {
                    com.baidu.navisdk.asr.d.B().a(JarUtils.getResources().getString(R.string.nsdk_limit_voice_close_tip), "car_limit", (com.baidu.navisdk.asr.i.a) new a(), true);
                    return null;
                }
                string = JarUtils.getResources().getString(R.string.nsdk_limit_voice_close_tip_yes);
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(string);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            com.baidu.navisdk.ui.routeguide.model.a0.G = 3;
            com.baidu.navisdk.ui.routeguide.control.l.l().i();
        }
    }

    /* loaded from: classes8.dex */
    public class e extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.5.2");
            if (c.a()) {
                return null;
            }
            if (JNIGuidanceControl.getInstance().getViaCnt() >= 1) {
                return com.baidu.navisdk.module.asr.instructions.b.b("添加途经点后不支持该功能");
            }
            if (com.baidu.navisdk.module.asr.h.a()) {
                return com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.asr_rg_pref_off_line_not_use));
            }
            if (com.baidu.navisdk.ui.routeguide.b.V().c() != null && com.baidu.navisdk.util.common.y.d(com.baidu.navisdk.ui.routeguide.b.V().c()) && BNRouteGuider.getInstance().isCurDriveRouteOnline()) {
                com.baidu.navisdk.util.common.g.ASR.e("XDVoice", "execute - avoid_congestion()");
                c.b(25);
                return null;
            }
            com.baidu.navisdk.util.common.g.ASR.e("XDVoice", "changeFasterRoute() -- offlineMode -- retuen");
            return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_avoid_traffic_no_route));
        }
    }

    /* loaded from: classes8.dex */
    public class e0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.l.1.8");
            if (TextUtils.isEmpty(aVar.v)) {
                return com.baidu.navisdk.module.asr.instructions.b.b("");
            }
            if (TextUtils.equals(aVar.v, "home")) {
                Bundle n = com.baidu.navisdk.framework.b.n();
                if (n != null && n.containsKey("addr")) {
                    com.baidu.navisdk.module.asr.instructions.b.a("3.c.l.1.8.1", "0", "0");
                    aVar.v = n.getString("addr");
                } else {
                    com.baidu.navisdk.module.asr.instructions.b.a("3.c.l.1.8.1", "0", "1");
                    return com.baidu.navisdk.module.asr.instructions.b.b("您暂未设置家的地址，导航结束后可在通勤设置页面完成添加");
                }
            } else if (TextUtils.equals(aVar.v, "company")) {
                Bundle k = com.baidu.navisdk.framework.b.k();
                if (k != null && k.containsKey("addr")) {
                    com.baidu.navisdk.module.asr.instructions.b.a("3.c.l.1.8.1", "1", "0");
                    aVar.v = k.getString("addr");
                } else {
                    com.baidu.navisdk.module.asr.instructions.b.a("3.c.l.1.8.1", "1", "1");
                    return com.baidu.navisdk.module.asr.instructions.b.b("您暂未设置公司的地址，导航结束后可在通勤设置页面完成添加");
                }
            }
            com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.b.b().a().a(aVar, com.baidu.navisdk.asr.d.B());
            return com.baidu.navisdk.module.asr.instructions.b.a();
        }
    }

    /* loaded from: classes8.dex */
    public class f extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.5.1");
            if (c.a()) {
                return null;
            }
            if (JNIGuidanceControl.getInstance().getViaCnt() >= 1) {
                return com.baidu.navisdk.module.asr.instructions.b.b("添加途经点后不支持该功能");
            }
            if (com.baidu.navisdk.module.asr.h.a()) {
                return com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.asr_rg_pref_off_line_not_use));
            }
            if (com.baidu.navisdk.ui.routeguide.b.V().c() != null && com.baidu.navisdk.util.common.y.d(com.baidu.navisdk.ui.routeguide.b.V().c()) && BNRouteGuider.getInstance().isCurDriveRouteOnline()) {
                com.baidu.navisdk.util.common.g.ASR.e("XDVoice", "execute - prefer_quicker()");
                c.b(26);
                return null;
            }
            com.baidu.navisdk.util.common.g.ASR.e("XDVoice", "changeFasterRoute() -- offlineMode -- retuen");
            return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_avoid_traffic_no_route));
        }
    }

    /* loaded from: classes8.dex */
    public class f0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.l.2.2");
            if (c.a()) {
                return null;
            }
            if (JNIGuidanceControl.getInstance().getViaCnt() == 0) {
                return com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.nav_voice_delete_all_via_no_via));
            }
            com.baidu.navisdk.module.asr.busi.d.b(true);
            com.baidu.navisdk.ui.routeguide.model.a0.I();
            com.baidu.navisdk.ui.routeguide.model.a0.G = 6;
            com.baidu.navisdk.ui.routeguide.control.l.l().b(aVar.q0);
            return com.baidu.navisdk.module.asr.instructions.b.b("");
        }
    }

    /* loaded from: classes8.dex */
    public class g extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            if (c.a()) {
                return null;
            }
            BNSettingManager.setFirstClickChangePrefer(false);
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.i", Integer.toString(aVar.w0));
            new com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.f().a(aVar.w0);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class g0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            BNSettingManager.setFirstClickDayNight(false);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.5", "1", null, "2");
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.8.4");
            BNCommSettingManager.getInstance().setNaviDayAndNightMode(2);
            return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_into_day_mode));
        }
    }

    /* loaded from: classes8.dex */
    public class h extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        @Deprecated
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            new com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.f().a(128);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class h0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.m.2");
            com.baidu.navisdk.framework.b.a(18, (Object) 0);
            return com.baidu.navisdk.module.asr.instructions.b.b("已为您打开语音广场");
        }
    }

    /* loaded from: classes8.dex */
    public class i extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        @Deprecated
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            new com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.f().a(512);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class i0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String str = aVar.p0;
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        c = 0;
                        break;
                    }
                    break;
                case 49:
                    if (str.equals("1")) {
                        c = 1;
                        break;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.9.9");
                    com.baidu.navisdk.ui.routeguide.b.V().l().a(0);
                    com.baidu.navisdk.ui.routeguide.b.V().l().b(1);
                    return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_short_its));
                case 1:
                    com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.9.10");
                    com.baidu.navisdk.ui.routeguide.b.V().l().a(0);
                    com.baidu.navisdk.ui.routeguide.b.V().l().b(0);
                    return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_standard_tts));
                case 2:
                    com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.9.8");
                    com.baidu.navisdk.ui.routeguide.b.V().l().a(0);
                    com.baidu.navisdk.ui.routeguide.b.V().l().b(7);
                    return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_long_tts));
                default:
                    return null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        @Deprecated
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            new com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.f().a(4);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class j0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            boolean z;
            String str;
            boolean s2 = com.baidu.navisdk.ui.routeguide.control.x.b().s2();
            if (aVar.t0 == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                str = "竖屏";
            } else {
                str = "横屏";
            }
            if (s2 != z) {
                com.baidu.navisdk.ui.routeguide.b.V().a();
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.nav_voice_screen_orientation, str));
        }
    }

    /* loaded from: classes8.dex */
    public class k extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            if (com.baidu.navisdk.ui.routeguide.utils.b.t()) {
                return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.bnav_rg_hd_navi_no_support_xd_tip));
            }
            com.baidu.navisdk.ui.routeguide.b.V().r().k();
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.4.1");
            return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_into_on_overview));
        }
    }

    /* loaded from: classes8.dex */
    public class k0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String string;
            BNCommSettingManager.getInstance().setLocationShareBtnNeedNewTag(false);
            com.baidu.navisdk.framework.interfaces.locationshare.a j = com.baidu.navisdk.framework.interfaces.c.p().j();
            if (j != null && j.l()) {
                string = JarUtils.getResources().getString(R.string.nav_voice_group_trip);
                Bundle bundle = new Bundle();
                bundle.putString("pageSrc", NotificationCompat.CATEGORY_NAVIGATION);
                bundle.putInt("vehicleType", com.baidu.navisdk.module.vehiclemanager.b.i().b());
                com.baidu.navisdk.framework.b.c(bundle);
            } else {
                string = JarUtils.getResources().getString(R.string.nav_voice_group_trip_error);
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "服务暂不可用，敬请期待");
            }
            com.baidu.navisdk.asr.d.B().c();
            TTSPlayerControl.playXDTTSText(string, 1);
            return com.baidu.navisdk.module.asr.instructions.b.b("");
        }
    }

    /* loaded from: classes8.dex */
    public class l extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String h;
            int i;
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.6.1");
            AudioManager audioManager = (AudioManager) com.baidu.navisdk.framework.a.c().a().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            if (streamVolume >= streamMaxVolume) {
                h = com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_inc_volume_max);
            } else {
                if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().u0() != null) {
                    int i2 = aVar.t0;
                    if (i2 == 0) {
                        i = streamMaxVolume / 2;
                        if (streamVolume <= i) {
                            i = (int) ((0.85d - (streamVolume / streamMaxVolume)) * 15.0d);
                        }
                    } else {
                        i = (int) ((i2 / 100.0d) * streamMaxVolume);
                    }
                    int i3 = 0;
                    while (true) {
                        int i4 = i3 + 1;
                        if (i3 >= i || (streamVolume = com.baidu.navisdk.ui.routeguide.mapmode.a.o5().u0().b(audioManager, streamMaxVolume)) >= streamMaxVolume) {
                            break;
                        }
                        i3 = i4;
                    }
                }
                if (streamVolume > 0) {
                    com.baidu.navisdk.ui.routeguide.mapmode.a.o5().U(false);
                }
                if (aVar.t0 == 100) {
                    h = com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_inc_volume_to_max);
                } else {
                    h = com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_inc_volume);
                }
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(h);
        }
    }

    /* loaded from: classes8.dex */
    public class l0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String string;
            if (aVar.t0 == 0) {
                if (com.baidu.navisdk.util.common.l.c(com.baidu.navisdk.framework.a.c().a())) {
                    string = JarUtils.getResources().getString(R.string.nav_voice_power_saving_open);
                    BNCommSettingManager.getInstance().setPowerSaveMode(0);
                } else {
                    string = JarUtils.getResources().getString(R.string.nav_voice_power_saving_no_auth);
                    com.baidu.navisdk.ui.routeguide.asr.a.a(true);
                    com.baidu.navisdk.util.common.l.a(com.baidu.navisdk.framework.a.c().b(), 4102);
                }
            } else {
                string = JarUtils.getResources().getString(R.string.nav_voice_power_saving_close);
                BNCommSettingManager.getInstance().setPowerSaveMode(2);
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(string);
        }
    }

    /* loaded from: classes8.dex */
    public class m extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String h;
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.6.2");
            AudioManager audioManager = (AudioManager) com.baidu.navisdk.framework.a.c().a().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            if (streamVolume == 0) {
                h = com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_dec_volume_min);
            } else {
                if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().u0() != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        if (i >= 4 || (streamVolume = com.baidu.navisdk.ui.routeguide.mapmode.a.o5().u0().a(audioManager, streamMaxVolume)) == 0) {
                            break;
                        }
                        i = i2;
                    }
                }
                if (streamVolume == 0) {
                    com.baidu.navisdk.ui.routeguide.mapmode.a.o5().U(true);
                }
                h = com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_dec_volume);
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(h);
        }
    }

    /* loaded from: classes8.dex */
    public class m0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            BNSettingManager.setFirstClickDayNight(false);
            BNCommSettingManager.getInstance().setNaviDayAndNightMode(1);
            return com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.nav_voice_auto_daynight));
        }
    }

    /* loaded from: classes8.dex */
    public class n extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            BNSettingManager.setFirstClickVoiceMode(false);
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.9.4");
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.i", null, "", "2");
            com.baidu.navisdk.ui.routeguide.b.V().l().c(true);
            return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_common_notification_close_quiet_voice));
        }
    }

    /* loaded from: classes8.dex */
    public class n0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String string = JarUtils.getResources().getString(R.string.nav_voice_travel_share);
            if (com.baidu.navisdk.module.international.a.a(com.baidu.navisdk.framework.a.c().a())) {
                com.baidu.navisdk.asr.d.B().b();
            } else {
                com.baidu.navisdk.asr.d.B().b();
                com.baidu.navisdk.module.a.h().a(com.baidu.navisdk.ui.routeguide.b.V().b(), 0, true);
                TTSPlayerControl.playXDTTSText(string, 1);
            }
            return com.baidu.navisdk.module.asr.instructions.b.b("");
        }
    }

    /* loaded from: classes8.dex */
    public class o extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.9.5");
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.i", "", null, "2");
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.7.2", "0", null, "2");
            com.baidu.navisdk.ui.routeguide.b.V().l().a(2);
            return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_common_notification_open_quiet_mode_voice));
        }
    }

    /* loaded from: classes8.dex */
    public class o0 extends com.baidu.navisdk.asr.a {

        /* loaded from: classes8.dex */
        public class a extends com.baidu.navisdk.asr.i.a {

            /* renamed from: com.baidu.navisdk.ui.routeguide.asr.instruction.c$o0$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C0423a extends TTSPlayerControl.f {
                public C0423a() {
                }

                @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
                public void a(String str) {
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
                    if (gVar.d()) {
                        gVar.e("XDVoice", "onPlayStart: " + str);
                    }
                }

                @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
                public void onPlayEnd(String str) {
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
                    if (gVar.d()) {
                        gVar.e("XDVoice", "onPlayEnd: " + str);
                    }
                    TTSPlayerControl.removeTTSPlayStateListener(this);
                    if ("bn_navi_voice_record".equals(str)) {
                        a.this.c();
                    }
                }
            }

            /* loaded from: classes8.dex */
            public class b {
                public b(a aVar, Bundle bundle) {
                }
            }

            public a(o0 o0Var) {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void c() {
                com.baidu.navisdk.asr.d.B().c();
                com.baidu.navisdk.ui.routeguide.b.V().Q();
                Bundle bundle = new Bundle();
                bundle.putBoolean("back_page_go_to_where", true);
                if (com.baidu.navisdk.framework.b.e0()) {
                    com.baidu.navisdk.framework.b.a(19, bundle);
                } else {
                    com.baidu.navisdk.framework.b.a(24, new b(this, bundle));
                }
            }

            @Override // com.baidu.navisdk.asr.i.a
            public void b() {
                TTSPlayerControl.playXDTTSText(JarUtils.getResources().getString(R.string.nsdk_xd_voice_record_cancel), 1);
            }

            @Override // com.baidu.navisdk.asr.i.a
            public void a(String str, boolean z) {
                String string;
                super.a(str, z);
                if (z) {
                    TTSPlayerControl.addTTSPlayStateListener(new C0423a());
                    if (com.baidu.navisdk.framework.b.e0()) {
                        string = JarUtils.getResources().getString(R.string.nsdk_xd_voice_record_logged);
                    } else {
                        string = JarUtils.getResources().getString(R.string.nsdk_xd_voice_record_no_logging);
                    }
                    TTSPlayerControl.playXDTTSTextForResult(string, 1, "bn_navi_voice_record");
                    return;
                }
                com.baidu.navisdk.asr.d.B().a(com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.nsdk_xd_voice_record_cancel)));
            }
        }

        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
            if (gVar.d()) {
                gVar.e("XDVoice", "action: voice_record");
            }
            com.baidu.navisdk.asr.d.B().a(JarUtils.getResources().getString(R.string.nsdk_xd_voice_record), "voice_record", (com.baidu.navisdk.asr.i.a) new a(this), true);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class p extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String str;
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.9.6");
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.2", "", null, "2");
            if (com.baidu.navisdk.ui.routeguide.b.V().l().a(true)) {
                str = com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_open_its);
            } else {
                str = "开启路况失败";
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(str);
        }
    }

    /* loaded from: classes8.dex */
    public class p0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            if (RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.BrowseMap)) {
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BROWSER_STATE_EXIT);
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.nav_voice_continue_drive));
        }
    }

    /* loaded from: classes8.dex */
    public class q extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String str;
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.9.7");
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.2", null, "", "2");
            if (com.baidu.navisdk.ui.routeguide.b.V().l().a(false)) {
                str = com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_close_its);
            } else {
                str = "关闭路况失败";
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(str);
        }
    }

    /* loaded from: classes8.dex */
    public class q0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.model.datastruct.s sVar = new com.baidu.navisdk.model.datastruct.s();
            sVar.e = aVar.B0;
            sVar.p = aVar.f0;
            sVar.k = new GeoPoint(aVar.A0);
            if (TextUtils.equals(aVar.z0, "ne_recommend_charge")) {
                sVar.z = 1;
            }
            com.baidu.navisdk.poisearch.model.a.k().d(1);
            com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.e.d().b().a(sVar);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class r extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String string;
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.l.1.1");
            if (c.a()) {
                return null;
            }
            if ((com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a0() & 1) != 0) {
                com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.1.3");
                BNRouteGuider.getInstance().onlineChangeRoute(1);
                com.baidu.navisdk.ui.routeguide.asr.c.n().l();
                return null;
            }
            if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a0() == 2) {
                string = JarUtils.getResources().getString(R.string.asr_rg_main_aux_road_already, "主路");
            } else {
                string = JarUtils.getResources().getString(R.string.asr_rg_main_aux_switch_error, "主路");
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(string);
        }
    }

    /* loaded from: classes8.dex */
    public class r0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            BNSettingManager.setFirstClickDayNight(false);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.5", "2", null, "2");
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.8.5");
            BNCommSettingManager.getInstance().setNaviDayAndNightMode(3);
            return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_into_night_mode));
        }
    }

    /* loaded from: classes8.dex */
    public class s extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String string;
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.l.1.2");
            if (c.a()) {
                return null;
            }
            if ((com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a0() & 2) != 0) {
                com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.2.3");
                BNRouteGuider.getInstance().onlineChangeRoute(2);
                com.baidu.navisdk.ui.routeguide.asr.c.n().l();
                return null;
            }
            if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a0() == 1) {
                string = JarUtils.getResources().getString(R.string.asr_rg_main_aux_road_already, "辅路");
            } else {
                string = JarUtils.getResources().getString(R.string.asr_rg_main_aux_switch_error, "辅路");
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(string);
        }
    }

    /* loaded from: classes8.dex */
    public class s0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.model.datastruct.s sVar = new com.baidu.navisdk.model.datastruct.s();
            sVar.e = aVar.B0;
            sVar.p = aVar.f0;
            sVar.k = new GeoPoint(aVar.A0);
            com.baidu.navisdk.poisearch.model.a.k().d(1);
            com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.e.d().b().b(sVar);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class t extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String string;
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.l.1.3");
            if (c.a()) {
                return null;
            }
            if ((com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a0() & 4) != 0) {
                BNRouteGuider.getInstance().onlineChangeRoute(4);
                com.baidu.navisdk.ui.routeguide.asr.c.n().l();
                return null;
            }
            if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a0() == 8) {
                string = JarUtils.getResources().getString(R.string.asr_rg_main_aux_road_already, "桥上");
            } else {
                string = JarUtils.getResources().getString(R.string.asr_rg_main_aux_switch_error, "桥上");
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(string);
        }
    }

    /* loaded from: classes8.dex */
    public class t0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.asr.d.B().c();
            if (!com.baidu.navisdk.framework.b.e0()) {
                TTSPlayerControl.playXDTTSText("您需要登录后才能进行路线收藏", 1);
                return null;
            }
            com.baidu.navisdk.framework.b.a(1);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class u extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String string;
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.l.1.4");
            if (c.a()) {
                return null;
            }
            if ((com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a0() & 8) != 0) {
                BNRouteGuider.getInstance().onlineChangeRoute(8);
                com.baidu.navisdk.ui.routeguide.asr.c.n().l();
                return null;
            }
            if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a0() == 4) {
                string = JarUtils.getResources().getString(R.string.asr_rg_main_aux_road_already, "桥下");
            } else {
                string = JarUtils.getResources().getString(R.string.asr_rg_main_aux_switch_error, "桥下");
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(string);
        }
    }

    /* loaded from: classes8.dex */
    public class u0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String str = aVar.m;
            if (str == null) {
                str = com.baidu.navisdk.ui.util.b.h(R.string.nav_voice_mock_guide);
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(str);
        }
    }

    /* loaded from: classes8.dex */
    public class v extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            if (com.baidu.navisdk.ui.routeguide.utils.b.t()) {
                return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.bnav_rg_hd_navi_no_support_xd_tip));
            }
            com.baidu.navisdk.ui.routeguide.b.V().r().m();
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.4.2");
            return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_into_off_overview));
        }
    }

    /* loaded from: classes8.dex */
    public class v0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.pronavi.hd.normal.i.a aVar2;
            com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b bVar;
            com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
            String str = null;
            if (j != null) {
                bVar = j.c(true);
                aVar2 = j.d(true);
            } else {
                aVar2 = null;
                bVar = null;
            }
            int c = com.baidu.navisdk.ui.routeguide.model.a0.I().c();
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("XDVoice", "action : " + aVar.toString() + ", curRoadGrade:" + c);
            }
            if (c != 0 && c != 1) {
                if (aVar2 != null) {
                    str = aVar2.a(aVar.p0);
                }
            } else if (bVar != null) {
                str = bVar.a(aVar.p0);
            }
            if (TextUtils.isEmpty(str)) {
                str = "当前路段暂不支持，请稍后再试";
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(str);
        }
    }

    /* loaded from: classes8.dex */
    public class w extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            if (c.a()) {
                return null;
            }
            if (JNIGuidanceControl.getInstance().getViaCnt() >= 1) {
                return com.baidu.navisdk.module.asr.instructions.b.b("添加途径点后不支持该功能");
            }
            if (!com.baidu.navisdk.util.common.y.d(com.baidu.navisdk.framework.a.c().a())) {
                com.baidu.navisdk.util.common.g.ASR.e("XDVoice", "excute refreshRoute() - not Network!  retuen");
                String h = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_avoid_traffic_network_failture);
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), h);
                return com.baidu.navisdk.module.asr.instructions.b.b(h);
            }
            if (com.baidu.navisdk.module.asr.h.a()) {
                com.baidu.navisdk.module.asr.i.c(JarUtils.getResources().getString(R.string.asr_rg_pref_off_line_not_use));
                return null;
            }
            try {
                List<String> list = aVar.i0;
                if (list != null) {
                    String str = list.get(0);
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.navisdk.util.common.g.ASR.e("XDVoice", "走XX路：" + str);
                        com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.7.1", "1", str);
                        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().r4();
                        com.baidu.navisdk.ui.routeguide.asr.instruction.d.INSTANCE.a(str);
                        return null;
                    }
                }
                List<String> list2 = aVar.j0;
                if (list2 != null) {
                    String str2 = list2.get(0);
                    if (!TextUtils.isEmpty(str2)) {
                        com.baidu.navisdk.util.common.g.ASR.e("XDVoice", "不走XX路：" + str2);
                        com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.7.1", "2", str2);
                        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().r4();
                        com.baidu.navisdk.ui.routeguide.asr.instruction.d.INSTANCE.a(str2, 31);
                        return null;
                    }
                }
            } catch (Exception e) {
                com.baidu.navisdk.util.common.g.ASR.e("XDVoice", "personalize_route " + e.getMessage());
                com.baidu.navisdk.ui.routeguide.asr.c.n().l();
            }
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class w0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String str;
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.8.6");
            if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().f2() || com.baidu.navisdk.ui.routeguide.mapmode.a.o5().N2()) {
                str = "暂时无法为您切换镜像投影模式，请驶出该区域后再重新尝试";
            } else {
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.VOICE_HUDMIRROR);
                str = "已切换镜像投影模式，请注意安全驾驶";
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(str);
        }
    }

    /* loaded from: classes8.dex */
    public class x extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            boolean z = true;
            if (aVar.G0 == 1 && c.b()) {
                com.baidu.navisdk.util.statistic.userop.b.r().b("38.0.21.1463");
                com.baidu.navisdk.ui.routeguide.b.V().s().j().e("RGParkingLotListComponent").a(4).a();
                Bundle bundle = new Bundle();
                bundle.putInt("key_type_show_views", 7);
                bundle.putBoolean("call_by_xd", true);
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.ENTRY_DYNAMIC_LAYER, bundle);
                return null;
            }
            BNCommSettingManager.getInstance().saveFirstGuide("NAVI_XD_SCENE_AID_CHANGE_PREFER", false);
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.l.1.5");
            if (com.baidu.navisdk.asr.d.B().n()) {
                com.baidu.navisdk.asr.d.B().z();
                com.baidu.navisdk.asr.d.B().x();
                com.baidu.navisdk.asr.d.B().y();
            }
            if (TextUtils.isEmpty(aVar.p0)) {
                com.baidu.navisdk.ui.routeguide.asr.c.n().l();
            } else {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(aVar.p0);
                if (aVar.q0 != null) {
                    com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.e d = com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.e.d();
                    ArrayList<String> arrayList2 = (ArrayList) aVar.q0;
                    if (aVar.y0 != 1) {
                        z = false;
                    }
                    d.a(arrayList, arrayList2, z);
                } else {
                    com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.e d2 = com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.e.d();
                    if (aVar.y0 != 1) {
                        z = false;
                    }
                    d2.a(arrayList, (ArrayList<String>) null, z);
                }
            }
            return com.baidu.navisdk.module.asr.instructions.b.a();
        }
    }

    /* loaded from: classes8.dex */
    public class x0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            if (com.baidu.navisdk.ui.routeguide.utils.b.t()) {
                return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.bnav_rg_hd_navi_no_support_xd_tip));
            }
            RouteGuideFSM.getInstance().cacheBackMapState(RGFSMTable.FsmState.Car3D);
            com.baidu.navisdk.ui.routeguide.b.V().r().l();
            RouteGuideFSM.getInstance().setFullViewByUser(false);
            BNCommSettingManager.getInstance().setMapMode(1);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.1", "", null, "4");
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.8.7");
            return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_into_car_3d));
        }
    }

    /* loaded from: classes8.dex */
    public class y extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            boolean z;
            String str;
            String str2;
            try {
            } catch (Exception e) {
                e.printStackTrace();
                com.baidu.navisdk.ui.routeguide.asr.c.n().l();
            }
            if (c.a()) {
                return null;
            }
            String str3 = aVar.v;
            if (TextUtils.isEmpty(str3)) {
                com.baidu.navisdk.ui.routeguide.asr.c.n().l();
                return null;
            }
            if (aVar.G0 == 1 && c.b()) {
                com.baidu.navisdk.util.statistic.userop.b.r().b("38.0.21.1463");
                com.baidu.navisdk.ui.routeguide.b.V().s().j().e("RGParkingLotListComponent").a(4).a();
                Bundle bundle = new Bundle();
                bundle.putInt("key_type_show_views", 7);
                bundle.putBoolean("call_by_xd", true);
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.ENTRY_DYNAMIC_LAYER, bundle);
                return null;
            }
            com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.d l = com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.d.l();
            if (aVar.h0 == 1) {
                z = true;
            } else {
                z = false;
            }
            l.a(z);
            if (aVar.v0 == 1) {
                l.i();
            } else if (TextUtils.equals(str3, "home")) {
                l.d(aVar.c);
            } else if (TextUtils.equals(str3, "company")) {
                l.c(aVar.c);
            } else if (TextUtils.equals(aVar.s0, "change_address")) {
                l.a(str3, aVar.f6552a, aVar.c, aVar.r0);
            } else {
                String str4 = aVar.p;
                if (TextUtils.isEmpty(str4)) {
                    str = "";
                } else {
                    if (TextUtils.equals(str4, "终点")) {
                        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
                        if (fVar.g() == null) {
                            str2 = "";
                        } else {
                            str2 = "" + fVar.g().getName();
                        }
                    } else {
                        str2 = "" + str4;
                    }
                    str = str2 + "附近的";
                }
                com.baidu.navisdk.module.asr.instructions.b.a("3.c.h");
                l.a(str + str3, aVar.f6552a, aVar.c, "");
            }
            return com.baidu.navisdk.module.asr.instructions.b.a();
        }
    }

    /* loaded from: classes8.dex */
    public class y0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            if (com.baidu.navisdk.ui.routeguide.utils.b.t()) {
                return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.bnav_rg_hd_navi_no_support_xd_tip));
            }
            RouteGuideFSM.getInstance().cacheBackMapState(RGFSMTable.FsmState.North2D);
            com.baidu.navisdk.ui.routeguide.b.V().r().l();
            RouteGuideFSM.getInstance().setFullViewByUser(false);
            BNCommSettingManager.getInstance().setMapMode(2);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.1", null, "", "4");
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.8.8");
            return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_into_north_2d));
        }
    }

    /* loaded from: classes8.dex */
    public class z extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String str;
            int f = com.baidu.navisdk.ui.routeguide.control.b.k().f();
            int i = 0;
            if (TextUtils.equals(aVar.u0, "in")) {
                com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.7.9");
                if (f >= 21) {
                    str = "已放大地图到最大";
                } else {
                    if (f != 20) {
                        while (true) {
                            int i2 = i + 1;
                            if (i >= 2) {
                                break;
                            }
                            com.baidu.navisdk.ui.routeguide.b.V().r().o();
                            i = i2;
                        }
                    } else {
                        com.baidu.navisdk.ui.routeguide.b.V().r().o();
                    }
                    str = "已放大地图";
                }
            } else if (TextUtils.equals(aVar.u0, "out")) {
                com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.8.1");
                if (f <= 4) {
                    str = "已缩小地图到最小";
                } else {
                    if (f != 5) {
                        while (true) {
                            int i3 = i + 1;
                            if (i >= 2) {
                                break;
                            }
                            com.baidu.navisdk.ui.routeguide.b.V().r().p();
                            i = i3;
                        }
                    } else {
                        com.baidu.navisdk.ui.routeguide.b.V().r().p();
                    }
                    str = "已缩小地图";
                }
            } else {
                str = "";
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(str);
        }
    }

    /* loaded from: classes8.dex */
    public class z0 extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            if (com.baidu.navisdk.ui.routeguide.utils.b.o().f != 0) {
                return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.bnav_rg_hd_navi_no_support_xd_tip));
            }
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.8.9");
            com.baidu.navisdk.ui.routeguide.b.V().b(0);
            com.baidu.navisdk.ui.routeguide.control.x.b().I().b(true);
            com.baidu.navisdk.ui.routeguide.control.x.b().Y2();
            if (RouteGuideParams.NavState.NAV_STATE_OPERATE.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b())) {
                com.baidu.navisdk.ui.routeguide.b.V().r().l();
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_window_minimap));
        }
    }

    public static /* synthetic */ boolean a() {
        return e();
    }

    public static /* synthetic */ boolean b() {
        return c();
    }

    private static boolean c() {
        com.baidu.navisdk.pronavi.data.model.f fVar = (com.baidu.navisdk.pronavi.data.model.f) com.baidu.navisdk.ui.routeguide.b.V().s().b(com.baidu.navisdk.pronavi.data.model.f.class);
        if (fVar != null && fVar.b().getValue() != null && fVar.b().getValue().a() != null) {
            return true;
        }
        return false;
    }

    public static void d() {
        new k().a("on_preview");
        new v().a("off_preview");
        new g0().a("day_mode");
        new r0().a("night_mode");
        new w0().a("enter_hud");
        new x0().a("follow_view");
        new y0().a("god_view");
        new z0().a("window_minimap");
        new a1().a("roadbar_minimap");
        new a().a("panel_default_mode");
        new b().a("panel_simple_mode");
        new C0422c().a("exit_navigation");
        new d().a("more_fast");
        new e().a("avoid_congestion");
        new f().a("prefer_quicker");
        new g().a("prefer");
        new h().a("prefer_shorter");
        new i().a("prefer_highway");
        new j().a("prefer_no_highway");
        new l().a("inc_volume");
        new m().a("dec_volume");
        new n().a("on_volume");
        new o().a("off_volume");
        new p().a("on_roadcond");
        new q().a("off_roadcond");
        new r().a("main_road");
        new s().a("aux_road");
        new t().a("on_bridge");
        new u().a("under_bridge");
        new w().a("personalize_route");
        new x().a("add_via_node");
        new y().a("change_route");
        new z().a("chg_map_size");
        new a0().a("refresh_route");
        new b0().a("open_setting");
        new c0().a("route");
        new d0().a("car_limit");
        new e0().a("ETA_query");
        new f0().a("del_via_node");
        new h0().a("voice_market");
        new i0().a("set_tts_mode");
        new j0().a("screen_orientation");
        new k0().a("group_trip");
        new l0().a("power_saving");
        new m0().a("auto_daynight");
        new n0().a("travel_sharing");
        new o0().a("voice_record");
        new p0().a("continue_drive");
        new q0().a("direct_add_approach");
        new s0().a("change_end_node");
        new t0().a("road_collect");
        new u0().a("mock_guide");
        new v0().a("lane_navigation");
    }

    private static boolean e() {
        if (com.baidu.navisdk.ui.routeguide.control.x.b().m2()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
            if (gVar.d()) {
                gVar.e("XDVoice", "isInterceptRecalRouteForVdrGuide: ");
            }
            String h2 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_vdr_intercept_recal_route_tip);
            com.baidu.navisdk.ui.routeguide.control.s.T().a(h2, false);
            com.baidu.navisdk.asr.d.B().a(com.baidu.navisdk.module.asr.instructions.b.b(h2));
            return true;
        }
        if (!com.baidu.navisdk.ui.routeguide.model.a0.I().w()) {
            return false;
        }
        String h3 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_intercept_pre_yawing_route_tip);
        com.baidu.navisdk.ui.routeguide.control.s.T().a(h3, false);
        com.baidu.navisdk.asr.d.B().a(com.baidu.navisdk.module.asr.instructions.b.b(h3));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i2) {
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().r4();
        BNRouteGuider.getInstance().calcOtherRoute("", 1, i2);
    }
}
