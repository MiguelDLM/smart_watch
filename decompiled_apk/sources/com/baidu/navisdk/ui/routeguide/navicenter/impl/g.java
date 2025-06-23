package com.baidu.navisdk.ui.routeguide.navicenter.impl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.navisdk.adapter.struct.BNHighwayInfo;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.framework.interfaces.pronavi.o;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.module.pronavi.message.model.b;
import com.baidu.navisdk.module.vdr.a;
import com.baidu.navisdk.ugc.https.detail.b;
import com.baidu.navisdk.ugc.https.detail.c;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.RGLineItem;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.l;
import com.baidu.navisdk.ui.routeguide.model.m;
import com.baidu.navisdk.ui.routeguide.model.n;
import com.baidu.navisdk.ui.routeguide.model.q;
import com.baidu.navisdk.ui.routeguide.model.t;
import com.baidu.navisdk.ui.routeguide.navicenter.BNavigatorLogic;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.ProNaviStatItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tts.f0;
import com.baidu.tts.g0;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes8.dex */
public class g extends com.baidu.navisdk.comapi.routeguide.a {

    /* renamed from: a, reason: collision with root package name */
    private final BNavigatorLogic f9072a;
    private final com.baidu.navisdk.ui.routeguide.subview.a b;
    private String c = g0.e;
    private String d = f0.d;
    private final k e = com.baidu.navisdk.framework.interfaces.c.p().k();
    private ImageView f;
    private com.baidu.nplatform.comapi.map.e g;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {
        public a(g gVar, String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "onOfflineToOnlineFailed --> 再次自动请求在线算路");
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "测试toast: 再次自动请求在线算路!!!");
            }
            BNRouteGuider.getInstance().calcOtherRoute(3);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements n.e {
        public b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.model.n.e
        public void a() {
            g.this.e();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements b.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9074a;
        final /* synthetic */ long b;

        public c(g gVar, int i, long j) {
            this.f9074a = i;
            this.b = j;
        }

        @Override // com.baidu.navisdk.ugc.https.detail.b.c
        public void a(com.baidu.navisdk.ugc.https.detail.a aVar) {
            String str;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "result(), model = " + aVar);
            }
            if (aVar.b() == 0) {
                String a2 = aVar.a().a(this.f9074a);
                if (aVar.a().r() != null) {
                    str = aVar.a().r().a();
                } else {
                    str = null;
                }
                BNMapController.getInstance().setRealGraphInfo(this.b, str, a2);
                return;
            }
            if (gVar.d()) {
                gVar.e("eventID : request Fail " + aVar);
            }
        }
    }

    public g(BNavigatorLogic bNavigatorLogic) {
        this.f9072a = bNavigatorLogic;
        this.b = bNavigatorLogic.D();
    }

    private Bundle A0(Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                return (Bundle) obj;
            }
            return null;
        }
        return null;
    }

    private void B0(Message message) {
        com.baidu.navisdk.ui.routeguide.model.i.s().a((Bundle) message.obj);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "dingbbin setLatestAddDistance " + com.baidu.navisdk.ui.routeguide.model.i.s().j() + " handleDirectBoardHideMsg");
        }
        if (!com.baidu.navisdk.ui.routeguide.model.i.s().a()) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "handleDirectBoardHideMsg: not hide:" + message);
                return;
            }
            return;
        }
        com.baidu.navisdk.ui.routeguide.b.V().w();
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
        x.b().N0();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.q", null, null, "3");
    }

    private void C0(Message message) {
        int i;
        Bundle h;
        if (!x.b().R1()) {
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.q.1.1", "4");
            return;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().B3();
        Bundle a2 = com.baidu.navisdk.ui.routeguide.model.i.s().a(RouteGuideParams.RasterType.DIRECT_BOARD, false, message.arg1, message.arg2, (Bundle) message.obj);
        LogUtil.e("RouteGuide", "dingbbin setCurrentAddDist " + com.baidu.navisdk.ui.routeguide.model.i.s().i() + " handleDirectBoardShowMsg");
        if (a2 == null) {
            LogUtil.e("RouteGuide", "failed to update handleDirectBoardShowMsg for bg bitmap is invalid.");
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.model.i.s().a(a2.getString(RouteGuideParams.RGKey.ExpandMap.BgName), a2.getString(RouteGuideParams.RGKey.ExpandMap.ArrowName)) && com.baidu.navisdk.ui.routeguide.model.i.s().m()) {
            com.baidu.navisdk.ui.routeguide.model.i.s().b(true);
            if (com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
                a(a2);
            }
            if (a2.containsKey("resid")) {
                i = a2.getInt("resid");
            } else {
                i = -1;
            }
            if (i <= 0 && (h = a0.I().h()) != null && h.containsKey("resid")) {
                a2.putInt("resid", h.getInt("resid"));
            }
            x.b().a(a2, false);
            com.baidu.navisdk.ui.routeguide.model.i.s().a(true);
            c(0);
            com.baidu.navisdk.ui.routeguide.model.i.s().b(3);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.q", "3", null, null);
        }
    }

    private void D0(Message message) {
        int i;
        Bundle a2 = com.baidu.navisdk.ui.routeguide.model.i.s().a(RouteGuideParams.RasterType.DIRECT_BOARD, true, message.arg1, message.arg2, (Bundle) message.obj);
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            LogUtil.e("RouteGuide", "ExpandMap type handleDirectBoardUpdateMsg, data = " + a2);
        }
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
            a(a2);
        }
        if (RouteGuideFSM.getInstance().getTopState() != null && RGFSMTable.FsmState.EnlargeRoadmap.equalsIgnoreCase(RouteGuideFSM.getInstance().getTopState())) {
            if (a2 != null && a2.containsKey("resid")) {
                i = a2.getInt("resid");
            } else {
                i = -1;
            }
            if (i <= 0) {
                Bundle h = a0.I().h();
                if (a2 != null && h != null && h.containsKey("resid")) {
                    a2.putInt("resid", h.getInt("resid"));
                }
            }
            x.b().a(a2, false);
        }
    }

    private void E0(Message message) {
        String str;
        boolean z;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "ExpandMap type handleEnlargeRoadMapHideMsg: ");
        }
        Bundle bundle = (Bundle) message.obj;
        com.baidu.navisdk.ui.routeguide.model.i.s().a(bundle);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "dingbbin setLatestAddDistance " + com.baidu.navisdk.ui.routeguide.model.i.s().j() + " handleEnlargeRoadMapHideMsg");
        }
        if (!com.baidu.navisdk.ui.routeguide.model.i.s().a()) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "handleEnlargeRoadMapHideMsg: not hide:" + bundle);
                return;
            }
            return;
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.TagContent)) {
            str = bundle.getString(RouteGuideParams.RGKey.ExpandMap.TagContent);
        } else {
            str = "";
        }
        com.baidu.navisdk.util.statistic.g.d().a("3.3", str + "|h");
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.ForbidAnimation)) {
            z = bundle.getBoolean(RouteGuideParams.RGKey.ExpandMap.ForbidAnimation);
        } else {
            z = false;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().T(z);
        com.baidu.navisdk.ui.routeguide.b.V().w();
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
        x.b().N0();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.q", null, null, String.valueOf(bundle.getInt(RouteGuideParams.RGKey.ExpandMap.GridmapKind)));
        k kVar = this.e;
        if (kVar != null) {
            if (!(kVar instanceof com.baidu.navisdk.module.pronavi.message.b)) {
                kVar.b(this.f9072a.c(), "Raster", (Bundle) message.obj);
            } else {
                a(this.f9072a.c(), "Raster", (Bundle) message.obj, com.baidu.navisdk.module.pronavi.message.c.HIDE);
            }
        }
    }

    private void F0(Message message) {
        int i;
        Bundle h;
        LogUtil.e("RouteGuide", "ExpandMap type handleEnlargeRoadMapUpdateMsg");
        Bundle b2 = com.baidu.navisdk.ui.routeguide.model.i.s().b(RouteGuideParams.RasterType.GRID, true, message.arg1, message.arg2, (Bundle) message.obj);
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().f() || (RouteGuideFSM.getInstance().getTopState() != null && RGFSMTable.FsmState.EnlargeRoadmap.equalsIgnoreCase(RouteGuideFSM.getInstance().getTopState()))) {
            LogUtil.e("RouteGuide", "handleEnlargeRoadMapUpdateMsg");
            if (b2.containsKey("resid")) {
                i = b2.getInt("resid");
            } else {
                i = -1;
            }
            if (i <= 0 && (h = a0.I().h()) != null && h.containsKey("resid")) {
                b2.putInt("resid", h.getInt("resid"));
            }
            x.b().a(b2, false);
            Bundle bundle = (Bundle) message.obj;
            bundle.putInt(RouteGuideParams.RGKey.ExpandMap.RemainDist, message.arg2);
            k kVar = this.e;
            if (kVar != null) {
                if (!(kVar instanceof com.baidu.navisdk.module.pronavi.message.b)) {
                    kVar.a(this.f9072a.c(), "Raster", bundle);
                } else {
                    a(this.f9072a.c(), "Raster", (Bundle) message.obj, com.baidu.navisdk.module.pronavi.message.c.UPDATE);
                }
            }
        }
    }

    private void c(int i) {
        boolean run = RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_SHOW);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "enterEnlargeState-> enlargeType=" + i + ", enterResult=" + run);
        }
        if (run) {
            BNRouteGuider.getInstance().setExpandMapStatics(true, i);
        }
    }

    private void y0(Message message) {
        String str;
        int i;
        Bundle h;
        LogUtil.e("RouteGuide", "ExpandMap type HandleRasterExpandMapShowMsg");
        if (!x.b().R1()) {
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.q.1.1", "3");
            return;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().B3();
        Bundle b2 = com.baidu.navisdk.ui.routeguide.model.i.s().b(RouteGuideParams.RasterType.GRID, false, message.arg1, message.arg2, (Bundle) message.obj);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "dingbbin setCurrentAddDist " + com.baidu.navisdk.ui.routeguide.model.i.s().i() + " HandleRasterExpandMapShowMsg");
        }
        if (b2 == null) {
            LogUtil.e("RouteGuide", "failed to update HandleRasterExpandMapShowMsg for bg bitmap is invalid.");
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.model.i.s().a(b2.getString(RouteGuideParams.RGKey.ExpandMap.BgName), b2.getString(RouteGuideParams.RGKey.ExpandMap.ArrowName)) && com.baidu.navisdk.ui.routeguide.model.i.s().m()) {
            if (b2.containsKey(RouteGuideParams.RGKey.ExpandMap.TagContent)) {
                str = b2.getString(RouteGuideParams.RGKey.ExpandMap.TagContent);
            } else {
                str = "";
            }
            com.baidu.navisdk.util.statistic.g.d().a("3.3", str + "|s");
            com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410382", "410382");
            if (b2.containsKey("resid")) {
                i = b2.getInt("resid");
            } else {
                i = -1;
            }
            if (i <= 0 && (h = a0.I().h()) != null && h.containsKey("resid")) {
                b2.putInt("resid", h.getInt("resid"));
            }
            com.baidu.navisdk.ui.routeguide.model.i.s().b(true);
            if (com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
                a(b2);
            }
            k kVar = this.e;
            if (kVar != null) {
                if (!(kVar instanceof com.baidu.navisdk.module.pronavi.message.b)) {
                    kVar.c(this.f9072a.c(), "Raster", (Bundle) message.obj);
                } else {
                    a(this.f9072a.c(), "Raster", (Bundle) message.obj, com.baidu.navisdk.module.pronavi.message.c.SHOW);
                }
            }
            x.b().a(b2, true);
            com.baidu.navisdk.ui.routeguide.model.i.s().a(true);
            int i2 = b2.getInt(RouteGuideParams.RGKey.ExpandMap.GridmapKind);
            c(com.baidu.navisdk.ui.routeguide.model.i.s().a(i2));
            ProNaviStatItem.O().n();
            com.baidu.navisdk.ui.routeguide.model.i.s().b(i2);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.q", String.valueOf(i2), null, null);
        }
        x.b().Z0();
        x.b().t1();
    }

    private void z0(Message message) {
        boolean z;
        int i = message.arg1;
        if (LogUtil.LOGGABLE) {
            TipTool.onCreateDebugToast(com.baidu.navisdk.framework.a.c().a(), "路线/ugc推送消息: type = " + message.arg1);
            LogUtil.e("RouteGuide", "躲避拥堵or躲避UGC路线下发or躲避UGC失败 type:" + message.arg1 + ", routeId: " + message.arg2);
        }
        com.baidu.navisdk.ui.routeguide.control.a.d().a(com.baidu.navisdk.ui.routeguide.model.x.A().i());
        com.baidu.navisdk.ui.routeguide.model.x.A().e(message.arg2);
        if (message.arg2 == 100) {
            if (i == 7) {
                com.baidu.navisdk.ui.routeguide.model.x.A().p();
            } else {
                com.baidu.navisdk.ui.routeguide.ugc.c.a();
            }
        }
        if (com.baidu.navisdk.ui.routeguide.model.x.A().r == 6) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.j.7.4", com.baidu.navisdk.ui.routeguide.asr.instruction.d.INSTANCE.a(), null, null);
        }
        com.baidu.navisdk.ui.routeguide.model.x A = com.baidu.navisdk.ui.routeguide.model.x.A();
        if (i == 14) {
            z = true;
        } else {
            z = false;
        }
        A.b = z;
        boolean c2 = s.T().c(com.baidu.navisdk.ui.routeguide.model.x.A().x());
        if (!c2 && com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
            com.baidu.navisdk.ui.routeguide.asr.c.n().c(true);
        }
        if (!c2) {
            if (i == 7 || i == 13) {
                int j = com.baidu.navisdk.ui.routeguide.model.x.A().j();
                int i2 = com.baidu.navisdk.ui.routeguide.model.x.A().r;
                LogUtil.e("RouteGuide", "setShowRouteChoose, showStatus:0, pushType:" + j + "sourceType:" + i2);
                JNIGuidanceControl.getInstance().setShowRouteChoose(0, j, i2);
                if (LogUtil.LOGGABLE) {
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "回传类型： 0");
                }
            }
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void A(Message message) {
        int i;
        LogUtil.e("RouteGuide", "onHighwayInfoHide");
        m.y().w();
        m.y().b(false);
        l.d(false);
        x.b().s3();
        k kVar = this.e;
        if (kVar != null) {
            if (!(kVar instanceof com.baidu.navisdk.module.pronavi.message.b)) {
                kVar.V();
            } else {
                try {
                    ((com.baidu.navisdk.module.pronavi.message.b) kVar).a(com.baidu.navisdk.module.pronavi.message.c.HIDE, c());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Bundle A0 = A0(message);
        if (A0 == null) {
            return;
        }
        if (A0.containsKey(RouteGuideParams.RGKey.HighWayInfo.ExitRemainDist)) {
            i = A0.getInt(RouteGuideParams.RGKey.HighWayInfo.ExitRemainDist);
        } else {
            i = -1;
        }
        x.b().b((Bundle) null, false);
        a(b.a.c);
        com.baidu.navisdk.util.statistic.g.d().a("3.4", "d" + i + "|h");
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void B(Message message) {
        LogUtil.e("RouteGuide", "Assist SHOW");
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().b(com.baidu.navisdk.module.pronavi.model.g.o().a(1, message.arg1, message.arg2));
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void C(Message message) {
        Bundle A0 = A0(message);
        m.y().a(A0);
        k kVar = this.e;
        if (kVar != null) {
            if (!(kVar instanceof com.baidu.navisdk.module.pronavi.message.b)) {
                kVar.l();
            } else {
                try {
                    ((com.baidu.navisdk.module.pronavi.message.b) kVar).a(com.baidu.navisdk.module.pronavi.message.c.UPDATE, c());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        LogUtil.e("RouteGuide", "onHighwayInfoUpdate data: " + A0.toString());
        boolean a2 = e0.a(com.baidu.navisdk.ui.routeguide.b.V().b()).a("carnet.connected", false);
        if (m.y().v()) {
            l.d(true);
            m.y().b(true);
            com.baidu.navisdk.ui.routeguide.holder.a.d().b(false);
            if (!a2 && !x.b().j2() && !x.b().R2() && !com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
                x.b().s3();
            }
            x.b().d((Bundle) null);
            x.b().b((Bundle) null, true);
        } else {
            m.y().b(false);
            l.d(false);
            if (!com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
                x.b().s3();
            }
            x.b().b((Bundle) null, false);
        }
        a(b.a.b);
        if (x.b().T()) {
            x.b().e(l.f().a(A0));
            x.b().V3();
        }
        if (LogUtil.LOGGABLE) {
            com.baidu.navisdk.ui.routeguide.control.n.d().b();
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void D(Message message) {
        int i;
        Bundle h;
        Bundle A0 = A0(message);
        LogUtil.e("RouteGuide", "ExpandMap type onVectorExpandMapShow");
        if (!x.b().R1()) {
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.q.1.1", "5");
            return;
        }
        if (!BNCommSettingManager.getInstance().getVectorExpandMapVisible()) {
            return;
        }
        if (A0 != null) {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().B3();
            Bundle c2 = com.baidu.navisdk.ui.routeguide.model.i.s().c(false, A0);
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                LogUtil.e("RouteGuide", "dingbbin setCurrentAddDist " + com.baidu.navisdk.ui.routeguide.model.i.s().i() + " onVectorExpandMapShow");
            }
            if (c2 != null && com.baidu.navisdk.ui.routeguide.model.i.s().m()) {
                if (c2.containsKey("resid")) {
                    i = c2.getInt("resid");
                } else {
                    i = -1;
                }
                if (i <= 0 && (h = a0.I().h()) != null && h.containsKey("resid")) {
                    c2.putInt("resid", h.getInt("resid"));
                }
                com.baidu.navisdk.ui.routeguide.model.i.s().b(true);
                if (com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
                    a(c2);
                }
                x.b().a(c2, true);
                com.baidu.navisdk.ui.routeguide.model.i.s().a(true);
                c(1);
                com.baidu.navisdk.util.drivertool.e.l().a(x.b().g0());
                com.baidu.navisdk.ui.routeguide.model.i.s().b(4);
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.q", "4", null, null);
            } else {
                LogUtil.e("RouteGuide", "ExpandMap type onVectorExpandMapShow failed to update vector for bg bitmap is invalid.");
                return;
            }
        } else {
            LogUtil.e("RouteGuide", "ExpandMap type onVectorExpandMapShow getVectorExpandMapInfo failed!");
        }
        x.b().Z0();
        x.b().t1();
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void E(Message message) {
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().p0().E(message);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void F(Message message) {
        Object bundle;
        StringBuilder sb = new StringBuilder();
        sb.append("ExpandMap type onDestStreetViewStartDownload, data = ");
        if (message.getData() == null) {
            bundle = message.getData();
        } else {
            bundle = message.getData().toString();
        }
        sb.append(bundle);
        LogUtil.e("RouteGuide", sb.toString());
        A0(message);
        com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410341", "410341");
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void G(Message message) {
        boolean z;
        Bundle bundle = (Bundle) message.obj;
        com.baidu.navisdk.ui.routeguide.model.i.s().a(bundle);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "dingbbin setLatestAddDistance " + com.baidu.navisdk.ui.routeguide.model.i.s().j() + " onVectorExpandMapHide");
        }
        if (!com.baidu.navisdk.ui.routeguide.model.i.s().a()) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "onVectorExpandMapHide: not hide:" + bundle);
                return;
            }
            return;
        }
        if (bundle.containsKey(RouteGuideParams.RGKey.ExpandMap.ForbidAnimation)) {
            z = bundle.getBoolean(RouteGuideParams.RGKey.ExpandMap.ForbidAnimation);
        } else {
            z = false;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().T(z);
        com.baidu.navisdk.ui.routeguide.b.V().w();
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
        x.b().N0();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.q", null, null, "4");
    }

    @Override // com.baidu.navisdk.comapi.routeguide.g
    public void H(Message message) {
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void I(Message message) {
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void J(Message message) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "ServiceArea-onSimpleBoardHide -> msg.what= " + message.what);
        }
        int i = message.what;
        if (i == 4408) {
            m.y().b((Bundle) null);
        } else if (i == 4411) {
            com.baidu.navisdk.ui.routeguide.model.j.e().a(null);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void K(@NonNull Message message) {
        boolean z;
        int i = message.arg1;
        if (message.arg2 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuideonSwitchModeNotice", "msg.arg1:" + message.arg1 + ",msg.arg2:" + message.arg2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().J().a(z);
        x.b().J().e(z);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void L(Message message) {
        com.baidu.navisdk.module.pronavi.model.g.o().e(true);
        x.b().I().a(message.arg1, message.arg2);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void M(Message message) {
        if (message != null) {
            a0.I().b(message.arg1, message.arg2);
            x.b().X4();
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void N(Message message) {
        boolean z;
        if (com.baidu.navisdk.module.pronavi.a.j != 2) {
            com.baidu.navisdk.ugc.report.c a2 = com.baidu.navisdk.ugc.report.c.a();
            if (message.arg1 == 1) {
                z = true;
            } else {
                z = false;
            }
            boolean a3 = a2.a(z);
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().J().b(a3);
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().J().a(a3, true);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void O(Message message) {
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j != null) {
            j.d(true).a(message);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void P(Message message) {
        LogUtil.e("RouteGuide", "RGSimpleGuideModel===   onRemainDistTimeUpdate");
        x.b().f(a0.I().c(message.arg1, message.arg2));
        k kVar = this.e;
        if (kVar != null) {
            kVar.onRemainInfoUpdate(message.arg1, message.arg2);
        }
        x.b().c5();
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.f9072a.q().j(), false);
        com.baidu.navisdk.util.worker.c.a().a(this.f9072a.q().j(), new com.baidu.navisdk.util.worker.e(2, 0), 60000L);
        x.b().e5();
        com.baidu.navisdk.ui.routeguide.control.e.o.a(message.arg2);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void Q(Message message) {
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.4.1", "1", null, null);
        this.f9072a.j(true);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void R(Message message) {
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(34, bundle);
        String str = "";
        if (!bundle.isEmpty()) {
            str = bundle.getString("floorInfo", "");
        }
        com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().c(str);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void S(Message message) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "onDrivingRouteChange-> msg.arg1= " + message.arg1);
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
            com.baidu.navisdk.ui.routeguide.b.V().j().l().e();
        }
        k kVar = this.e;
        if (kVar != null) {
            kVar.b(message.arg1);
        }
        String topState = RouteGuideFSM.getInstance().getTopState();
        if (RGFSMTable.FsmState.EnlargeRoadmap.equals(topState) || RGFSMTable.FsmState.Colladamap.equals(topState)) {
            com.baidu.navisdk.ui.routeguide.b.V().w();
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BTN_CLICK_BACK);
        }
        if (message.arg1 != 6) {
            a0.I().F();
        }
        t.s().r();
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
            com.baidu.navisdk.ui.routeguide.b.V().j().m().c();
        }
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b b2 = com.baidu.navisdk.ui.routeguide.utils.b.b(false);
        if (b2 != null) {
            b2.b("onDrivingChange");
        }
        com.baidu.navisdk.pronavi.hd.normal.i.a c2 = com.baidu.navisdk.ui.routeguide.utils.b.c(false);
        if (c2 != null) {
            c2.i();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().u();
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void T(Message message) {
        String bundle;
        Bundle A0 = A0(message);
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("ServiceArea-onDirectionBoardShow-> bundle=");
            if (A0 == null) {
                bundle = "null";
            } else {
                bundle = A0.toString();
            }
            sb.append(bundle);
            LogUtil.e("RouteGuide", sb.toString());
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
            com.baidu.navisdk.ui.routeguide.b.V().j().l().a(true, A0);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void U(Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.VDR;
        gVar.a("onVdrLocate state:" + i + "，scene:" + i2);
        if (i2 != 2 && !com.baidu.navisdk.module.vdr.a.b()) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "onVdrLocate,VDR disabled");
                return;
            }
            return;
        }
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        if (i == 1) {
                            com.baidu.navisdk.module.vdr.a.d(6);
                            return;
                        } else {
                            com.baidu.navisdk.module.vdr.a.d(7);
                            return;
                        }
                    }
                    return;
                }
                com.baidu.navisdk.module.vdr.a.a(2, a.EnumC0300a.NE_RouteDataForVdr_Type_IndoorPark);
                return;
            }
            if (i == 1) {
                com.baidu.navisdk.module.vdr.a.d(2);
                boolean a2 = com.baidu.navisdk.module.vdr.a.a(1, a.EnumC0300a.NE_RouteDataForVdr_Type_Tunnel);
                if (gVar.d()) {
                    gVar.e("RouteGuide", "updateData(MSG_TUNNEL) ret:" + a2);
                }
                if (!a2) {
                    com.baidu.navisdk.module.vdr.a.c();
                    return;
                }
                return;
            }
            com.baidu.navisdk.module.vdr.a.d(3);
            com.baidu.navisdk.module.vdr.a.d();
            return;
        }
        if (i == 1) {
            com.baidu.navisdk.module.vdr.a.a(0, a.EnumC0300a.NE_RouteDataForVdr_Type_NormalRoad);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void V(Message message) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "ServiceArea-onDirectionBoardHide-> ");
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
            com.baidu.navisdk.ui.routeguide.b.V().j().l().a(false, null);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void W(Message message) {
        boolean z;
        int i = message.arg2;
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(11, i, bundle);
        s T = s.T();
        if (message.arg1 == 0) {
            z = true;
        } else {
            z = false;
        }
        T.a(z, i, bundle);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void X(Message message) {
        if (message.arg1 == 9) {
            com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().u();
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void Y(Message message) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "onNaviSessionInValid: " + message);
        }
        s.T().N();
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void Z(Message message) {
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_highway_etc_ugc"));
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void a() {
    }

    @Override // com.baidu.navisdk.comapi.routeguide.g
    public void a0(Message message) {
        String str;
        k kVar;
        int i;
        int i2;
        switch (message.what) {
            case 4152:
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
                if (gVar.a()) {
                    gVar.a("MSG_NAVI_Satellite_Fixing_Update arg1=" + message.arg1 + ", arg2=" + message.arg2);
                }
                if (com.baidu.navisdk.util.common.g.ROUTE_GUIDE.b()) {
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "卫星信号： " + message.arg1);
                    SDKDebugFileUtil.get(SDKDebugFileUtil.SYSLOC_FILENAME).add("From enginee: MSG_NAVI_Satellite_Fixing_Update");
                }
                com.baidu.navisdk.logicframe.b d = this.f9072a.d();
                if (d != null) {
                    d.j().e("RGDeviceStateService").a(40002).a(Boolean.FALSE).a();
                    d.j().e("RGDeviceStateService").a(40001).a((Object) 0).b((Object) 0).a();
                }
                a0.I().h(false);
                a0.I().c(0);
                a0.I().d(0);
                x.b().E(0);
                x.b().o4();
                x.b().V3();
                com.baidu.navisdk.module.a.h().a(false);
                return;
            case 4153:
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.GPS;
                if (gVar2.a()) {
                    gVar2.a("MSG_NAVI_Satellite_Fix_Success_Update arg1=" + message.arg1 + ", arg2=" + message.arg2);
                }
                if (gVar2.b()) {
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "卫星信号： " + message.arg1);
                    SDKDebugFileUtil.get(SDKDebugFileUtil.SYSLOC_FILENAME).add("From enginee: MSG_NAVI_Satellite_Fix_Success_Update");
                }
                if (a0.I().j() > 0 && com.baidu.navisdk.ui.routeguide.b.V().e() != null) {
                    com.baidu.navisdk.ui.routeguide.b.V().e().removeMessages(10931);
                }
                a0.I().h(true);
                x.b().E(a0.I().j());
                x.b().o4();
                x.b().V3();
                com.baidu.navisdk.module.a.h().a(true);
                return;
            case 4171:
                com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.GPS;
                if (gVar3.b()) {
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "卫星信号： " + message.arg1);
                    SDKDebugFileUtil.get(SDKDebugFileUtil.SYSLOC_FILENAME).add("From enginee: MSG_NAVI_Star_State  arg1=" + message.arg1 + ", arg2=" + message.arg2);
                }
                if (SDKDebugFileUtil.getInstance().isShowCoreLog(2, 1, message.arg2, null, null)) {
                    gVar3.a("From enginee: MSG_NAVI_Star_State  arg1=" + message.arg1 + ", arg2=" + message.arg2);
                }
                if (gVar3.d()) {
                    gVar3.e("RouteGuide", "MsgDefine.MSG_NAVI_Star_State arg1=" + message.arg1 + ", arg2=" + message.arg2);
                }
                if (message.arg2 >= 3 && com.baidu.navisdk.ui.routeguide.b.V().e() != null) {
                    com.baidu.navisdk.ui.routeguide.b.V().e().removeMessages(10931);
                }
                com.baidu.navisdk.logicframe.b d2 = this.f9072a.d();
                if (d2 != null) {
                    d2.j().e("RGDeviceStateService").a(40001).a(Integer.valueOf(message.arg1)).b(Integer.valueOf(message.arg2)).a();
                }
                a0.I().d(message.arg1);
                a0.I().c(message.arg2);
                x.b().E(message.arg1);
                if (message.arg2 >= 3) {
                    a0.D = false;
                    s.T().d(102);
                    return;
                }
                return;
            case 4172:
                int i3 = message.arg1;
                LogUtil.e("RouteGuide", "MSG_NAVI_CHECK_OTHER_ROUTE --> subType =" + i3 + " arg2 :" + message.arg2);
                x.b().n1();
                x.b().n();
                com.baidu.navisdk.ui.routeguide.asr.c.n().b(true);
                com.baidu.navisdk.ui.routeguide.model.x.A().a(message.arg1, 0);
                com.baidu.navisdk.ui.routeguide.model.x.A().z();
                if (i3 == 5) {
                    if (com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
                        com.baidu.navisdk.ui.routeguide.asr.c.n().c(true);
                        TTSPlayerControl.playXDTTSText(com.baidu.navisdk.ui.routeguide.model.x.A().b(), 1);
                    }
                    x.b().r1();
                    s.T().a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_avoid_traffic_no_route), false);
                    com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
                    int t = BNRoutePlaner.getInstance().t();
                    ArrayList<Bundle> arrayList = new ArrayList<>();
                    for (int i4 = 0; i4 < t; i4++) {
                        Bundle bundle = new Bundle();
                        BNRoutePlaner.getInstance().a(i4, bundle);
                        arrayList.add(bundle);
                    }
                    fVar.a(arrayList);
                    if (arrayList.size() > 0) {
                        fVar.a(com.baidu.navisdk.ui.routeguide.b.V().c(), arrayList.get(0));
                    }
                    BNMapController.getInstance().clearLayer(13);
                    com.baidu.navisdk.framework.b.a(4, (Object) null);
                    if (com.baidu.navisdk.ui.routeguide.model.x.A().v()) {
                        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_refresh_route"));
                        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_refresh_route_callback"));
                    }
                } else if (i3 == 4) {
                    k kVar2 = this.e;
                    if (kVar2 != null) {
                        kVar2.u();
                    }
                    if (com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
                        com.baidu.navisdk.ui.routeguide.asr.c.n().c(true);
                        TTSPlayerControl.playXDTTSText(com.baidu.navisdk.ui.routeguide.model.x.A().b(), 1);
                    }
                    s.T().a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_avoid_traffic_no_route), false);
                    RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BTN_CLICK_BACK);
                    if (com.baidu.navisdk.ui.routeguide.model.x.A().v()) {
                        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_refresh_route"));
                        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_refresh_route_callback"));
                    }
                } else if (i3 == 3) {
                    k kVar3 = this.e;
                    if (kVar3 != null) {
                        kVar3.onNoNewRoute();
                    }
                    if (com.baidu.navisdk.ui.routeguide.model.x.A().r()) {
                        com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.b.b().a().b();
                    } else {
                        if (com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
                            com.baidu.navisdk.ui.routeguide.asr.c.n().c(true);
                            TTSPlayerControl.playXDTTSText(com.baidu.navisdk.ui.routeguide.model.x.A().b(), 1);
                        }
                        s.T().a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_avoid_traffic_no_route), false);
                    }
                    RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BTN_CLICK_BACK);
                    if (com.baidu.navisdk.ui.routeguide.model.x.A().v()) {
                        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_refresh_route"));
                        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_refresh_route_callback"));
                    }
                } else if (i3 == 0) {
                    k kVar4 = this.e;
                    if (kVar4 != null) {
                        if (message.arg2 == 1) {
                            kVar4.j();
                        } else {
                            kVar4.onNoNewRoute();
                        }
                    }
                    x.b().r1();
                    if (com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
                        com.baidu.navisdk.ui.routeguide.asr.c.n().c(true);
                    }
                    if (message.arg2 == 1) {
                        TTSPlayerControl.stopVoiceTTSOutput();
                        int i5 = R.string.nsdk_string_rg_avoid_traffic_switch_success;
                        TTSPlayerControl.playTTS(com.baidu.navisdk.ui.util.b.h(i5), 0);
                        s.T().a(com.baidu.navisdk.ui.util.b.h(i5), true);
                        f();
                    } else {
                        s T = s.T();
                        int i6 = R.string.nsdk_string_rg_avoid_traffic_other_route;
                        T.a(com.baidu.navisdk.ui.util.b.h(i6), true);
                        if (com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
                            TTSPlayerControl.playXDTTSText(JarUtils.getResources().getString(i6), 1);
                        }
                    }
                    if (com.baidu.navisdk.ui.routeguide.model.x.A().v()) {
                        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_refresh_route"));
                        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_refresh_route_callback"));
                    }
                } else if (i3 == 1) {
                    if (com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
                        com.baidu.navisdk.ui.routeguide.asr.c.n().c(true);
                    }
                    com.baidu.navisdk.ui.routeguide.model.x.A().a(message.arg1, 0);
                    com.baidu.navisdk.ui.routeguide.model.x.A().z();
                    s.T().a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_avoid_traffic_no_route), false);
                    if (com.baidu.navisdk.ui.routeguide.model.x.A().v()) {
                        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_refresh_route"));
                        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_refresh_route_callback"));
                    }
                    k kVar5 = this.e;
                    if (kVar5 != null) {
                        kVar5.D();
                    }
                } else if (i3 == 6) {
                    if (com.baidu.navisdk.ui.routeguide.model.x.A().r()) {
                        String o = com.baidu.navisdk.ui.routeguide.model.x.A().o();
                        if (com.baidu.navisdk.ui.routeguide.model.x.A().t()) {
                            com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.b.b().a().a(o);
                            return;
                        } else {
                            com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.b.b().a().b(o);
                            return;
                        }
                    }
                    x.b().r1();
                    com.baidu.navisdk.ui.routeguide.model.x.A().a(message.arg1, 0);
                    com.baidu.navisdk.ui.routeguide.model.x.A().e(message.arg2);
                    com.baidu.navisdk.ui.routeguide.model.x.A().z();
                    int j = com.baidu.navisdk.ui.routeguide.model.x.A().j();
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.8", "" + j, null, null);
                    f();
                    String o2 = com.baidu.navisdk.ui.routeguide.model.x.A().o();
                    int g = com.baidu.navisdk.ui.routeguide.model.x.A().g();
                    String d3 = com.baidu.navisdk.ui.routeguide.model.x.A().d();
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("RouteGuide", "CarLimitVoice-, onOtherRGInfo()111, voiceTips=" + o2 + ", voiceTipType=" + g + ", resonDesc=" + d3);
                    }
                    if (!TextUtils.isEmpty(d3)) {
                        this.e.a(d3);
                        if (com.baidu.navisdk.module.newguide.a.e().d()) {
                            s.T().c(d3);
                        } else {
                            s.T().b(d3);
                        }
                    }
                    if (o2 != null) {
                        if (this.f9072a.I() == 3 && TextUtils.isEmpty(d3)) {
                            s.T().c(o2);
                        }
                        if (TTSPlayerControl.getTTSState() == 1) {
                            TTSPlayerControl.stopVoiceTTSOutput();
                            if (!com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
                                TTSPlayerControl.playFastRouteVoice();
                            }
                            if (com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
                                com.baidu.navisdk.asr.d.B().a(com.baidu.navisdk.module.asr.instructions.b.b(o2));
                            } else if (g == 1) {
                                TTSPlayerControl.playTTS(o2, 0, TTSPlayerControl.CAR_LIMIT_VOICE_TAG);
                            } else {
                                TTSPlayerControl.playTTS(o2, 0);
                            }
                        } else if (com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
                            com.baidu.navisdk.asr.d.B().a(com.baidu.navisdk.module.asr.instructions.b.b(o2));
                        } else if (g == 1) {
                            TTSPlayerControl.playTTS(o2, 0, TTSPlayerControl.CAR_LIMIT_VOICE_TAG);
                        } else {
                            TTSPlayerControl.playTTS(o2, 0);
                        }
                    }
                } else if (i3 == 7 || i3 == 13 || i3 == 14) {
                    z0(message);
                } else if (i3 == 11) {
                    x.b().J(false);
                    x.b().c1();
                    BNavigatorLogic bNavigatorLogic = this.f9072a;
                    if (bNavigatorLogic != null) {
                        bNavigatorLogic.k();
                    }
                    f();
                    BNRoutePlaner.getInstance().g(3);
                    RoutePlanNode g2 = ((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).g();
                    if (g2 != null) {
                        ArrayList<Bundle> arrayList2 = new ArrayList<>();
                        BNRoutePlaner.getInstance().a(arrayList2, new Bundle());
                        if (arrayList2.size() > 1) {
                            int i7 = arrayList2.get(arrayList2.size() - 1).getInt("nodeParkType", 0);
                            g2.setParkType(i7);
                            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.ROUTE_PLAN;
                            if (gVar4.a()) {
                                gVar4.a("RGIndoorParkC", "end node parkType2:" + i7);
                            }
                        }
                    }
                    s.T().a(JarUtils.getResources().getString(R.string.nsdk_string_rg_offline_to_online_success), true);
                } else if (i3 == 12) {
                    d(message.arg2);
                } else if (i3 == 15) {
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.j.7.3", com.baidu.navisdk.ui.routeguide.asr.instruction.d.INSTANCE.a(), null, null);
                    if (com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
                        com.baidu.navisdk.ui.routeguide.asr.c.n().c(true);
                    }
                    String o3 = com.baidu.navisdk.ui.routeguide.model.x.A().o();
                    int g3 = com.baidu.navisdk.ui.routeguide.model.x.A().g();
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("RouteGuide", "CarLimitVoice-, onOtherRGInfo()222, voiceContent=" + o3 + ", voiceContentType=" + g3);
                    }
                    if (g3 == 1) {
                        TTSPlayerControl.playXDTTSTextForResult(o3, 1, TTSPlayerControl.CAR_LIMIT_VOICE_TAG);
                    } else {
                        TTSPlayerControl.playXDTTSText(o3, 1);
                    }
                } else if (i3 == 19) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("RouteGuide", "onOtherRGInfo --> MSG_NAVI_CHECK_OTHER_ROUTE|CHECK_OTHER_ROUTE_STATUS_SWITCH_SUCCESS_WEXP");
                    }
                    com.baidu.navisdk.ui.routeguide.model.x.A().e(message.arg2);
                    if (message.arg2 == 100) {
                        if (i3 == 7) {
                            com.baidu.navisdk.ui.routeguide.model.x.A().p();
                        } else {
                            com.baidu.navisdk.ui.routeguide.ugc.c.a();
                        }
                    }
                    if (!s.T().M() && com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
                        com.baidu.navisdk.ui.routeguide.asr.c.n().l();
                    }
                } else if (i3 == 20) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("RouteGuide", "onOtherRGInfo --> MSG_NAVI_CHECK_OTHER_ROUTE|CHECK_OTHER_ROUTE_STATUS_SUPPLY_DATA_NO_ROUTE");
                    }
                    com.baidu.navisdk.ui.routeguide.model.x.A().b = true;
                    if (!s.T().d(com.baidu.navisdk.ui.routeguide.model.x.A().x()) && com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
                        com.baidu.navisdk.ui.routeguide.asr.c.n().l();
                    }
                } else if (i3 == 21) {
                    com.baidu.navisdk.ui.routeguide.model.x.A().a(message.arg1, 0);
                    com.baidu.navisdk.ui.routeguide.model.x.A().e(message.arg2);
                    com.baidu.navisdk.ui.routeguide.model.x.A().z();
                    String d4 = com.baidu.navisdk.ui.routeguide.model.x.A().d();
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("RouteGuide", "onOtherRGInfo: force switch success reasonDesc=" + d4);
                    }
                    if (!TextUtils.isEmpty(d4)) {
                        s.T().a(103, -1, d4, (String) null, 2, 2);
                    }
                }
                com.baidu.navisdk.ui.routeguide.model.x.A().a(false);
                return;
            case 4192:
                LogUtil.e("RouteGuide", "MSG_NAVI_Type_UGC_ChangeRoadResult arg1=" + message.arg1);
                TipTool.onCreateToastDialog(com.baidu.navisdk.ui.routeguide.b.V().c(), JarUtils.getResources().getString(R.string.nsdk_string_rg_avoid_traffic_no_route));
                return;
            case 4213:
                com.baidu.navisdk.util.logic.j.r().r = true;
                com.baidu.navisdk.util.logic.k.getInstance().a(com.baidu.navisdk.ui.routeguide.b.V().c());
                return;
            case 4214:
                com.baidu.navisdk.util.logic.j.r().r = false;
                com.baidu.navisdk.util.logic.k.getInstance().a();
                return;
            case 4215:
                LogUtil.e("RouteGuide", "MSG_NAVI_TYPE_RCTurnKind_Update =======msg.arg1 " + message.arg1 + "arg2 " + message.arg2);
                if (com.baidu.navisdk.ui.routeguide.b.W()) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(message.arg1);
                    stringBuffer.append("d");
                    stringBuffer.append(message.arg2);
                    LogUtil.e("RouteGuide", "format data " + ((Object) stringBuffer));
                    a(stringBuffer.toString());
                    return;
                }
                return;
            case 4217:
                int i8 = message.arg1;
                if (i8 == 1) {
                    str = this.c + "f1";
                    this.d = "f1";
                } else if (i8 == 2) {
                    String str2 = this.c + f0.d;
                    this.d = f0.d;
                    str = str2;
                } else if (i8 == 4) {
                    str = "g1" + this.d;
                    this.c = "g1";
                } else if (i8 == 8) {
                    str = g0.e + this.d;
                    this.c = g0.e;
                } else if (i8 == 5) {
                    this.c = "g1";
                    this.d = "f1";
                    str = "g1,f1";
                } else if (i8 == 9) {
                    this.c = g0.e;
                    this.d = "f1";
                    str = "g0,f1";
                } else if (i8 == 6) {
                    this.c = "g1";
                    this.d = f0.d;
                    str = "g1,f0";
                } else if (i8 == 10) {
                    this.c = g0.e;
                    this.d = f0.d;
                    str = "g0,f0";
                } else {
                    str = "g0,f0";
                }
                LogUtil.e("RouteGuide", "MSG_NAVI_TYPE_RCRoadInfo_Update =======nChangeType " + i8 + "  roadInfo " + str);
                BNSettingManager.isShowJavaLog();
                if (com.baidu.navisdk.ui.routeguide.b.V().g() != null) {
                    com.baidu.navisdk.ui.routeguide.b.V().g().b(str);
                    return;
                }
                return;
            case 4219:
                LogUtil.e("RouteGuide", "peng enter otherRGInfo MSG_NAVI_TYPE_MAINSLAVE_VIADUCT_CHANGE");
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.6", message.arg1 + "", null, null);
                x.b().D(message.arg1);
                k kVar6 = this.e;
                if (kVar6 != null) {
                    kVar6.n(message.arg1);
                    return;
                }
                return;
            case 4386:
                if (com.baidu.navisdk.module.offscreen.a.g) {
                    com.baidu.navisdk.module.offscreen.a.a("offScreen", "MSG_NAVI_TYPE_SCREEN_BRIGHT");
                    com.baidu.navisdk.module.pronavi.model.j.e = 2;
                    com.baidu.navisdk.module.pronavi.model.j.b().f7471a = false;
                    com.baidu.navisdk.module.offscreen.a.i = false;
                    com.baidu.navisdk.module.offscreen.a.a("offScreen", "navi_type_screen_bright");
                    com.baidu.navisdk.module.offscreen.a.j = true;
                    com.baidu.navisdk.module.offscreen.a.m().a(2);
                    if (RouteGuideParams.NavState.NAV_STATE_OPERATE.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b()) || x.b().b2()) {
                        x.b().a(1, false);
                        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().g();
                        com.baidu.navisdk.module.pronavi.model.j.b().b = false;
                    }
                    LogUtil.e("offScreen", "MSG_NAVI_TYPE_SCREEN_BRIGHT");
                    return;
                }
                return;
            case 4387:
                if (com.baidu.navisdk.module.offscreen.a.g) {
                    com.baidu.navisdk.module.offscreen.a.a("offScreen", "MSG_NAVI_TYPE_SCREEN_OFF");
                    com.baidu.navisdk.module.pronavi.model.j.e = 1;
                    com.baidu.navisdk.module.offscreen.a.i = true;
                    com.baidu.navisdk.module.offscreen.a.m().b(1);
                    LogUtil.e("offScreen", "MSG_NAVI_TYPE_SCREEN_OFF");
                    return;
                }
                return;
            case 4388:
                if (LogUtil.LOGGABLE && com.baidu.navisdk.ui.routeguide.control.n.h) {
                    LogUtil.e("RouteGuide", "MSG_NAVI_TYPE_LANE_INFO_SHOW-> RGLaneLineController.DEBUG_LANE = true, return !");
                    return;
                }
                RGLaneInfoModel model = RGLaneInfoModel.getModel(true);
                RGLineItem[] laneInfo = BNRouteGuider.getInstance().getLaneInfo(model);
                com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar5.d()) {
                    String str3 = RGLaneInfoModel.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("MSG_NAVI_TYPE_LANE_INFO_SHOW - size = ");
                    sb.append(laneInfo != null ? laneInfo.length : 0);
                    gVar5.e(str3, sb.toString());
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RouteGuide", "MSG_NAVI_TYPE_LANE_INFO_SHOW ： " + Arrays.toString(laneInfo));
                }
                model.cloneData(laneInfo);
                com.baidu.navisdk.ui.routeguide.control.n.d().a(model);
                if (laneInfo == null || (kVar = this.e) == null) {
                    return;
                }
                kVar.a(Arrays.asList(laneInfo));
                return;
            case 4389:
                if (LogUtil.LOGGABLE && com.baidu.navisdk.ui.routeguide.control.n.h) {
                    LogUtil.e("RouteGuide", "MSG_NAVI_TYPE_LANE_INFO_HIDE-> RGLaneLineController.DEBUG_LANE = true, return !");
                    return;
                }
                LogUtil.e(RGLaneInfoModel.TAG, "MSG_NAVI_TYPE_LANE_INFO_HIDE");
                RGLaneInfoModel model2 = RGLaneInfoModel.getModel(false);
                if (model2 != null) {
                    model2.isShow = false;
                }
                com.baidu.navisdk.ui.routeguide.control.n.d().b.clear();
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(7, false, 2);
                k kVar7 = this.e;
                if (kVar7 != null) {
                    kVar7.y();
                    return;
                }
                return;
            case 4396:
                LogUtil.e("RouteGuide", "onOtherRGInfo: --> MSG_NAVI_TYPE_HUD_GetRouteInfo");
                this.f9072a.a(Boolean.TRUE);
                return;
            case 4404:
                int i9 = message.arg1;
                int i10 = message.arg2;
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RouteGuide", "MSG_NAVI_TYPE_DrivingRoute_HasHide arg1= " + i9 + " arg2= " + i10);
                }
                int selectRouteIdx = JNIGuidanceControl.getInstance().getSelectRouteIdx();
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.9", "" + i9, "" + selectRouteIdx, "" + i10);
                if (com.baidu.navisdk.module.pronavi.model.i.f().b && (((int) Math.pow(2.0d, com.baidu.navisdk.module.pronavi.model.i.f().e)) & i10) != 0) {
                    com.baidu.navisdk.module.pronavi.model.i.f().b = false;
                    com.baidu.navisdk.ui.routeguide.b.V().r().n();
                }
                x.b().c(i10);
                return;
            case 4405:
                LogUtil.e("RouteGuide", "MSG_NAVI_TYPE_SpeedLimit_Update =======msg.arg1 " + message.arg1 + "  msg.arg2 " + message.arg2);
                com.baidu.navisdk.module.pronavi.model.g.o().k = message.arg1;
                return;
            case 4414:
                LogUtil.e("RouteGuide", "safe MSG_NAVI_SessionIDChange arg1= ");
                com.baidu.navisdk.module.a.h().a(com.baidu.navisdk.ui.routeguide.b.V().b(), 2, false);
                return;
            case 4417:
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RouteGuide", "safe MSG_NAVI_ROUTE_COMMON_INFO arg1 = " + message.arg1);
                }
                int i11 = message.arg1;
                if (i11 == 1) {
                    BNavigatorLogic bNavigatorLogic2 = this.f9072a;
                    if (bNavigatorLogic2 != null && bNavigatorLogic2.x() != null) {
                        this.f9072a.x().b().a(message.arg2);
                    }
                    b(message.arg2);
                    return;
                }
                if (i11 == 2) {
                    b(message.arg2);
                    if (com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.f() < 1) {
                        x.b().D1();
                        a0.I().G();
                    }
                    k kVar8 = this.e;
                    if (kVar8 != null) {
                        kVar8.l(message.arg2);
                        return;
                    }
                    return;
                }
                if (i11 == 3) {
                    com.baidu.navisdk.ui.routeguide.control.e.o.a(message.arg2, RoutePlanNode.POI_TYPE_Parking);
                    return;
                }
                if (i11 == 4) {
                    com.baidu.navisdk.ui.routeguide.control.e.o.b(message.arg2, RoutePlanNode.POI_TYPE_Parking);
                    return;
                }
                if (i11 == 5) {
                    BNavigatorLogic bNavigatorLogic3 = this.f9072a;
                    if (bNavigatorLogic3 != null && bNavigatorLogic3.x() != null) {
                        this.f9072a.x().b().a(message.arg2, RoutePlanNode.POI_TYPE_Parking);
                    }
                    b(message.arg2);
                    return;
                }
                return;
            case 4451:
                com.baidu.navisdk.util.common.g gVar6 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar6.d()) {
                    gVar6.e("RouteGuide", "MSG_NAVI_TYPE_StaticRouteInfo --> subType =" + message.arg1 + " arg2 :" + message.arg2);
                }
                com.baidu.navisdk.ui.routeguide.model.x.A().a(29, 0);
                com.baidu.navisdk.ui.routeguide.model.x.A().z();
                z0(message);
                return;
            case 4479:
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RouteGuide", "Message_Type_Success_BuildDynamicGuide msg.arg1 = " + message.arg1 + ", msg.arg2 = " + message.arg2);
                }
                new com.baidu.navisdk.module.trafficrecord.a(null).e();
                return;
            case 4485:
                LogUtil.e("RouteGuide", "MESSAGE_TYPE_LINKSPEED_LIMIT_UPDATE =======msg.arg1 " + message.arg1 + "  msg.arg2 " + message.arg2);
                com.baidu.navisdk.module.pronavi.model.g.o().l = message.arg1;
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().C(message.arg1);
                return;
            case 4496:
                com.baidu.navisdk.util.common.g gVar7 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar7.d()) {
                    gVar7.e("RouteGuide", "MESSAGE_TYPE_INDOOR_CROSS_FLOOR_YAW --> subType =" + message.arg1 + " arg2 :" + message.arg2);
                }
                com.baidu.navisdk.ui.routeguide.control.e.o.e();
                return;
            case 4498:
                com.baidu.navisdk.util.common.g gVar8 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar8.d()) {
                    gVar8.e("RouteGuide", "NL_UI_Message_Type_IndoorVDRLoc_Quality --> subType =" + message.arg1 + " arg2 :" + message.arg2);
                }
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().x(message.arg1);
                com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().b(message.arg1);
                if (!com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().n() && (i = message.arg1) < 2 && i > 0) {
                    com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().e(true);
                    TTSPlayerControl.playTTS("当前定位信号弱，请谨慎驾驶", 1);
                }
                if (message.arg1 >= 2) {
                    com.baidu.navisdk.ui.routeguide.mapmode.a.o5().q3();
                    return;
                } else {
                    com.baidu.navisdk.ui.routeguide.mapmode.a.o5().A();
                    return;
                }
            case 4499:
                com.baidu.navisdk.util.common.g gVar9 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar9.d()) {
                    gVar9.e("RouteGuide", "NL_UI_Message_Type_IndoorNet_Quality --> subType =" + message.arg1 + " arg2 :" + message.arg2);
                }
                if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().o() || (i2 = message.arg1) >= 2 || i2 <= 0) {
                    return;
                }
                com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().f(true);
                TTSPlayerControl.playTTS("手机网络信号弱，室内导航可能延迟，请谨慎驾驶", 1);
                return;
            case 4504:
                com.baidu.navisdk.util.common.g gVar10 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar10.d()) {
                    gVar10.e("RouteGuide", "NL_UI_Message_Type_Car_Park_Guide --> subType =" + message.arg1 + " arg2 :" + message.arg2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void b(Message message) {
        Bundle A0 = A0(message);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("onCurRoadNameUpdate, data = ");
            sb.append((Object) (A0 == null ? A0 : A0.toString()));
            gVar.e("RouteGuide", sb.toString());
        }
        if (A0 != null && A0.containsKey("road_name")) {
            a0.I().f(A0.getString("road_name"));
            m.y().a(A0.getString("road_name"));
        } else {
            m.y().a((String) null);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void b0(Message message) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "onGpsLostWifiSwitchTip: " + message + "," + message.arg1 + "," + message.arg2);
        }
        if (message != null && message.arg1 == 1 && com.baidu.navisdk.j.d()) {
            x.b().p0().h();
        } else {
            com.baidu.navisdk.framework.c.b().a(15, 14);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void c0(Message message) {
        String bundle;
        Bundle A0 = A0(message);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("onSimpleBoardUpdate: -> data : ");
            if (A0 == null) {
                bundle = A0;
            } else {
                bundle = A0.toString();
            }
            sb.append((Object) bundle);
            gVar.e("RouteGuide", sb.toString());
        }
        int i = message.what;
        if (i == 4407) {
            m.y().b(A0);
        } else if (i == 4410) {
            com.baidu.navisdk.ui.routeguide.model.j.e().a(A0);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void d(Message message) {
        StringBuilder sb = new StringBuilder();
        sb.append("ExpandMap type onDestStreetViewDownloadSuccess, data = ");
        Bundle data = message.getData();
        Bundle data2 = message.getData();
        String str = data2;
        if (data != null) {
            str = data2.toString();
        }
        sb.append((Object) str);
        LogUtil.e("RouteGuide", sb.toString());
        com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410342", "410342");
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void d0(Message message) {
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void e(Message message) {
        Bundle A0 = A0(message);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "onHighwayInfoShow, data = " + A0.toString());
        }
        boolean a2 = e0.a(com.baidu.navisdk.ui.routeguide.b.V().b()).a("carnet.connected", false);
        a0.I().g(false);
        if (a0.I().v()) {
            com.baidu.navisdk.ui.routeguide.holder.a.d().a(false);
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_NAVI_READY);
        }
        m.y().a(A0);
        k kVar = this.e;
        if (kVar != null) {
            if (!(kVar instanceof com.baidu.navisdk.module.pronavi.message.b)) {
                kVar.q0();
            } else {
                try {
                    ((com.baidu.navisdk.module.pronavi.message.b) kVar).a(com.baidu.navisdk.module.pronavi.message.c.SHOW, c());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (!a2 && m.y().v()) {
            l.d(true);
            m.y().b(true);
            com.baidu.navisdk.ui.routeguide.holder.a.d().b(false);
            x.b().s3();
        } else {
            l.d(false);
            m.y().b(false);
        }
        x.b().b((Bundle) null, true);
        a(b.a.f7459a);
        if (x.b().T()) {
            x.b().e(l.f().a(A0));
            x.b().V3();
        }
        int i = A0.containsKey(RouteGuideParams.RGKey.HighWayInfo.ExitRemainDist) ? A0.getInt(RouteGuideParams.RGKey.HighWayInfo.ExitRemainDist) : -1;
        com.baidu.navisdk.util.statistic.g.d().a("3.4", "d" + i + "|s");
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void e0(Message message) {
        String bundle;
        Bundle A0 = A0(message);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("onSimpleBoardShow:  data : ");
            if (A0 == null) {
                bundle = A0;
            } else {
                bundle = A0.toString();
            }
            sb.append((Object) bundle);
            gVar.e("RouteGuide", sb.toString());
        }
        int i = message.what;
        if (i == 4406) {
            m.y().b(A0);
        } else if (i == 4409) {
            com.baidu.navisdk.ui.routeguide.model.j.e().a(A0);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void f(Message message) {
        LogUtil.e("RouteGuide", "onDynamicWindowHide");
        com.baidu.navisdk.ui.routeguide.model.i.s().a((Bundle) message.obj);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "dingbbin setLatestAddDistance " + com.baidu.navisdk.ui.routeguide.model.i.s().j() + " onDynamicWindowHide");
        }
        if (!com.baidu.navisdk.ui.routeguide.model.i.s().a()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "onDynamicWindowHide: not hide:" + message);
                return;
            }
            return;
        }
        com.baidu.navisdk.ui.routeguide.b.V().w();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().v(false);
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
        x.b().N0();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.q", null, null, "99");
        k kVar = this.e;
        if (kVar != null) {
            if (!(kVar instanceof com.baidu.navisdk.module.pronavi.message.b)) {
                kVar.b(this.f9072a.c(), "Dynamic", (Bundle) message.obj);
            } else {
                a(this.f9072a.c(), "Dynamic", (Bundle) message.obj, com.baidu.navisdk.module.pronavi.message.c.HIDE);
            }
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void f0(Message message) {
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j != null) {
            j.c().a(message.arg1);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void g(Message message) {
        LogUtil.e("RouteGuide", "Assist UPDATE");
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().b(com.baidu.navisdk.module.pronavi.model.g.o().a(2, message.arg1, message.arg2));
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void g0(Message message) {
        int i = message.arg1;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_c_in_ugc_road_30s"));
                    return;
                }
                return;
            }
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_c_has_reversible_lanes"));
            return;
        }
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_c_light_stop_10s"));
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void h(Message message) {
        int i;
        Bundle h;
        LogUtil.e("RouteGuide", "ExpandMap type onVectorExpandMapUpdate");
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().f() || (RouteGuideFSM.getInstance().getTopState() != null && RGFSMTable.FsmState.EnlargeRoadmap.equalsIgnoreCase(RouteGuideFSM.getInstance().getTopState()))) {
            LogUtil.e("RouteGuide", "ExpandMap type onVectorExpandMapUpdate VectorExpandMapUpdate, args: " + message.arg1 + ", " + message.arg2);
            Bundle A0 = A0(message);
            if (A0 != null) {
                Bundle c2 = com.baidu.navisdk.ui.routeguide.model.i.s().c(true, A0);
                if (c2.containsKey("resid")) {
                    i = c2.getInt("resid");
                } else {
                    i = -1;
                }
                if (i <= 0 && (h = a0.I().h()) != null && h.containsKey("resid")) {
                    c2.putInt("resid", h.getInt("resid"));
                }
                x.b().a(c2, false);
                x.b().j0();
                x.b().h0();
                x.b().i0();
                return;
            }
            LogUtil.e("RouteGuide", "ExpandMap type onVectorExpandMapUpdate getVectorExpandMapInfo failed!");
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void h0(Message message) {
        if (x.b().t0().a()) {
            x.b().V4();
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void i(Message message) {
        Object bundle;
        StringBuilder sb = new StringBuilder();
        sb.append("ExpandMap type handleDirectBoardUpdateMsg, data = ");
        if (message.getData() == null) {
            bundle = message.getData();
        } else {
            bundle = message.getData().toString();
        }
        sb.append(bundle);
        LogUtil.e("RouteGuide", sb.toString());
        C0(message);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void i0(Message message) {
        LogUtil.e("RouteGuide", "onGPSWeak ->");
        a0.D = true;
        s.T().G();
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void j(Message message) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_TYPE", 4384);
        bundle.putInt("KEY_INTERVAL_CAMERA_REMAIN_AVERAGE_SPEED", message.arg1);
        bundle.putInt("KEY_INTERVAL_CAMERA_REMAIN_DIST", message.arg2);
        LogUtil.e("RouteGuide", "onIntervalCameraOutMapUpdate ->" + bundle);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().a(bundle);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void j0(Message message) {
        boolean z;
        com.baidu.navisdk.module.pronavi.model.g o = com.baidu.navisdk.module.pronavi.model.g.o();
        if (message.arg1 == 0) {
            z = true;
        } else {
            z = false;
        }
        o.c(z);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().P4();
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void k(Message message) {
        LogUtil.e("RouteGuide", "Assist HIDE");
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().b(com.baidu.navisdk.module.pronavi.model.g.o().a(3, message.arg1, message.arg2));
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void k0(Message message) {
        boolean z;
        q d = q.d();
        if (message.arg1 == 1) {
            z = true;
        } else {
            z = false;
        }
        d.b(z);
        if (message.arg1 == 1) {
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_jamming_road"));
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void l(Message message) {
        LogUtil.e("RouteGuide", "ExpandMap type onRasterExpandMapUpdate, data = " + message.getData());
        F0(message);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void l0(Message message) {
        BNavigatorLogic bNavigatorLogic = this.f9072a;
        if (bNavigatorLogic != null && com.baidu.navisdk.module.pronavi.a.j != 2 && bNavigatorLogic.I() == 1 && (this.f9072a.E() == 1 || this.f9072a.E() == 7)) {
            com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().a(message.arg1);
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().a(0);
        if (LogUtil.LOGGABLE && this.f9072a != null) {
            LogUtil.e("RouteGuide", "onNaviModeSwitch->非驾车导航场景！Vehicle=" + this.f9072a.I() + " SceneType=" + this.f9072a.E());
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void m(Message message) {
        LogUtil.e("RouteGuide", "ExpandMap type onDirectBoardHide");
        B0(message);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void m0(Message message) {
        com.baidu.navisdk.module.vdr.a.d(4);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void n(Message message) {
        if (!com.baidu.navisdk.module.pronavi.model.g.o().g()) {
            com.baidu.navisdk.module.pronavi.model.g.o().b(true);
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().a(0, true);
        }
        com.baidu.navisdk.module.pronavi.model.g.o().f().c(message.arg1);
        com.baidu.navisdk.module.pronavi.model.g.o().f().a(message.arg2);
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_TYPE", 4383);
        bundle.putInt("KEY_INTERVAL_CAMERA_SPEED_LIMIT", message.arg1);
        bundle.putInt("KEY_INTERVAL_CAMERA_LENGTH", message.arg2);
        bundle.putInt("KEY_INTERVAL_CAMERA_REMAIN_AVERAGE_SPEED", com.baidu.navisdk.module.pronavi.model.g.o().c());
        LogUtil.e("RouteGuide", "onIntervalCameraOutMapShow ->" + bundle);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().a(bundle);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void n0(Message message) {
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(message);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void o(Message message) {
        Object bundle;
        StringBuilder sb = new StringBuilder();
        sb.append("ExpandMap type onDestStreetViewUpdate, data = ");
        if (message.getData() == null) {
            bundle = message.getData();
        } else {
            bundle = message.getData().toString();
        }
        sb.append(bundle);
        LogUtil.e("RouteGuide", sb.toString());
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().f() || (RouteGuideFSM.getInstance().getTopState() != null && RGFSMTable.FsmState.EnlargeRoadmap.equalsIgnoreCase(RouteGuideFSM.getInstance().getTopState()))) {
            LogUtil.e("RouteGuide", "!# onDestStreetViewUpdate, args: " + message.arg1 + ", " + message.arg2);
            Bundle A0 = A0(message);
            if (A0 != null && !A0.isEmpty()) {
                x.b().a(com.baidu.navisdk.ui.routeguide.model.i.s().b(true, A0), false);
            } else {
                LogUtil.e("RouteGuide", "!# onDestStreetViewUpdate failed!");
            }
            k kVar = this.e;
            if (kVar != null) {
                if (!(kVar instanceof com.baidu.navisdk.module.pronavi.message.b)) {
                    kVar.a(this.f9072a.c(), "Street", (Bundle) message.obj);
                } else {
                    a(this.f9072a.c(), "Street", (Bundle) message.obj, com.baidu.navisdk.module.pronavi.message.c.UPDATE);
                }
            }
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void o0(Message message) {
        String bundle;
        Bundle A0 = A0(message);
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("ServiceArea-onDirectionBoardUpdate-> bundle=");
            if (A0 == null) {
                bundle = "null";
            } else {
                bundle = A0.toString();
            }
            sb.append(bundle);
            LogUtil.e("RouteGuide", sb.toString());
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
            com.baidu.navisdk.ui.routeguide.b.V().j().l().a(A0);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void p(Message message) {
        D0(message);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void p0(Message message) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "onVDRGuideForLostGps: " + message);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().p0().a(message);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void q(Message message) {
        String str;
        LogUtil.e("RouteGuide", "ExpandMap type onDestStreetViewShow()");
        Bundle A0 = A0(message);
        if (A0 != null && !A0.isEmpty()) {
            if (!x.b().R1()) {
                com.baidu.navisdk.util.statistic.userop.b.r().d("3.q.1.1", "7");
                return;
            }
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().B3();
            com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410338", "410338");
            Bundle b2 = com.baidu.navisdk.ui.routeguide.model.i.s().b(false, A0);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "setCurrentAddDist " + com.baidu.navisdk.ui.routeguide.model.i.s().i() + " onDestStreetViewShow");
            }
            if (b2 != null && com.baidu.navisdk.ui.routeguide.model.i.s().m()) {
                com.baidu.navisdk.ui.routeguide.model.i.s().b(true);
                x.b().a(b2, false);
                x.b().g0();
                com.baidu.navisdk.ui.routeguide.model.i.s().a(true);
                c(3);
                com.baidu.navisdk.ui.routeguide.model.i.s().b(98);
                k kVar = this.e;
                if (kVar != null) {
                    if (!(kVar instanceof com.baidu.navisdk.module.pronavi.message.b)) {
                        kVar.c(this.f9072a.c(), "Street", (Bundle) message.obj);
                    } else {
                        a(this.f9072a.c(), "Street", (Bundle) message.obj, com.baidu.navisdk.module.pronavi.message.c.SHOW);
                    }
                }
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.q", "98", null, null);
                int i = b2.getInt(RouteGuideParams.RGKey.ExpandMap.StreetImageSource, -1);
                if (i != -1) {
                    if (i == 2) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.5", str, null, null);
                    return;
                }
                return;
            }
            return;
        }
        LogUtil.e("RouteGuide", "ExpandMap type onDestStreetViewShow failed!");
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void q0(Message message) {
        d();
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void r(Message message) {
        LogUtil.e("RouteGuide", "ExpandMap type onDynamicWindowShow");
        if (!x.b().R1()) {
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.q.1.1", "6");
            return;
        }
        if (!BNCommSettingManager.getInstance().getVectorExpandMapVisible()) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().B3();
        com.baidu.navisdk.ui.routeguide.model.i.s().b(true);
        a(false, message);
        com.baidu.navisdk.ui.routeguide.model.i.s().a(true);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().v(true);
        x.b().O1();
        c(5);
        x.b().Z0();
        x.b().t1();
        com.baidu.navisdk.ui.routeguide.model.i.s().b(99);
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.q", "99", null, null);
        k kVar = this.e;
        if (kVar != null) {
            if (!(kVar instanceof com.baidu.navisdk.module.pronavi.message.b)) {
                kVar.c(this.f9072a.c(), "Dynamic", (Bundle) message.obj);
            } else {
                a(this.f9072a.c(), "Dynamic", (Bundle) message.obj, com.baidu.navisdk.module.pronavi.message.c.SHOW);
            }
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void r0(Message message) {
        BNavigatorLogic bNavigatorLogic = this.f9072a;
        if (bNavigatorLogic != null && com.baidu.navisdk.module.pronavi.a.j != 2 && bNavigatorLogic.I() == 1 && (this.f9072a.E() == 1 || this.f9072a.E() == 7)) {
            com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().q();
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().c(0);
        if (LogUtil.LOGGABLE && this.f9072a != null) {
            LogUtil.e("RouteGuide", "onIndoorParkRouteInfoUpdate->非驾车导航场景！Vehicle=" + this.f9072a.I() + " SceneType=" + this.f9072a.E());
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void s(Message message) {
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j != null) {
            if (BNSettingManager.isRootScreenOpen() && com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                com.baidu.navisdk.util.drivertool.e.l().g();
            }
            j.c(true).s(message);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void s0(Message message) {
        if (message != null) {
            a0.I().a(message.arg1, message.arg2);
            x.b().f5();
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void t(Message message) {
        LogUtil.e("RouteGuide", "ExpandMap type onRasterExpandMapShow");
        y0(message);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void t0(Message message) {
        x.b().I().b(message.arg1, message.arg2);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void u(Message message) {
        Bundle A0 = A0(message);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "ExpandMap type onDestStreetViewHide, data = " + A0);
        }
        if (A0 != null && !A0.isEmpty()) {
            com.baidu.navisdk.ui.routeguide.model.i.s().a(A0);
            LogUtil.e("RouteGuide", "dingbbin setLatestAddDistance " + com.baidu.navisdk.ui.routeguide.model.i.s().j() + " onDestStreetViewHide");
            com.baidu.navisdk.ui.routeguide.b.V().w();
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
            x.b().N0();
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.q", null, null, "98");
            k kVar = this.e;
            if (kVar != null) {
                if (!(kVar instanceof com.baidu.navisdk.module.pronavi.message.b)) {
                    kVar.b(this.f9072a.c(), "Street", (Bundle) message.obj);
                } else {
                    a(this.f9072a.c(), "Street", (Bundle) message.obj, com.baidu.navisdk.module.pronavi.message.c.HIDE);
                }
            }
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void u0(Message message) {
        Object valueOf;
        a0.I().b(message.arg1);
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("onUpdateSubscribeListData-> getServiceAreaData.isEmpty= ");
            if (com.baidu.navisdk.ui.routeguide.b.V().i().c() == null) {
                valueOf = "null";
            } else {
                valueOf = Boolean.valueOf(com.baidu.navisdk.ui.routeguide.b.V().i().c().m().isEmpty());
            }
            sb.append(valueOf);
            LogUtil.e("ServiceArea", sb.toString());
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().i().c() != null && com.baidu.navisdk.ui.routeguide.b.V().i().c().m().isEmpty()) {
            com.baidu.navisdk.ui.routeguide.b.V().i().c().a(false, (n.e) new b());
        } else {
            e();
        }
        t.s().a(message.arg1);
    }

    @Override // com.baidu.navisdk.comapi.routeguide.g
    public void v(Message message) {
        int i;
        LogUtil.e("RouteGuide", "RGSimpleGuideModel=== onSimpleGuideInfoUpdate");
        Bundle A0 = A0(message);
        if (A0 == null) {
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "onSimpleGuideInfoUpdate: " + A0);
        }
        a0.I().t = true;
        a0.I().g(false);
        if (a0.I().v()) {
            com.baidu.navisdk.ui.routeguide.holder.a.d().a(false);
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_NAVI_READY);
        }
        int i2 = A0.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist);
        a0.A = A0;
        x.b().d(A0.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.BroadType, 0));
        Bundle H = a0.I().H();
        x.b().f(H);
        x.b().b(H, false);
        if (x.b().T() && !l.g()) {
            x.b().e(l.f().b(H));
        }
        m.y().d(i2);
        if (H != null && H.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.CurRoadName)) {
            String string = H.getString(RouteGuideParams.RGKey.SimpleGuideInfo.CurRoadName);
            a0.I().f(string);
            m.y().a(string);
            k kVar = this.e;
            if (kVar != null) {
                kVar.onRoadNameUpdate(string);
            }
            x.b().g(string);
        } else {
            m.y().a((String) null);
        }
        if (LogUtil.LOGGABLE) {
            com.baidu.navisdk.ui.routeguide.control.n.d().b();
        }
        String string2 = A0.getString("road_name");
        String string3 = A0.getString("icon_name");
        k kVar2 = this.e;
        if (kVar2 != null) {
            kVar2.a(string2, i2, string3);
        }
        if (t.s().l() && !t.s().h()) {
            i = BNRouteGuider.getInstance().getAddDist();
            t.s().a(i, true);
        } else {
            i = -1;
        }
        n c2 = com.baidu.navisdk.ui.routeguide.b.V().i().c();
        if (c2 != null && (!c2.m().isEmpty() || c2.q())) {
            if (i <= -1) {
                i = BNRouteGuider.getInstance().getAddDist();
            }
            c2.b(i);
        }
        com.baidu.navisdk.ui.routeguide.holder.a.d().c();
    }

    @Override // com.baidu.navisdk.comapi.routeguide.g
    public void v0(Message message) {
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(46, bundle);
        String string = bundle.getString("eventId");
        int i = bundle.getInt("eventType", -1);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "onSetRealGraph(), msg = " + message + " eventID = " + string + " eventType = " + i);
        }
        if (!TextUtils.isEmpty(string) && com.baidu.navisdk.ugc.utils.i.a(i)) {
            com.baidu.navisdk.ugc.https.detail.b bVar = new com.baidu.navisdk.ugc.https.detail.b();
            long uidCodecDecode = JNIGuidanceControl.getInstance().uidCodecDecode(string);
            bVar.a(c.a.b().b(String.valueOf(string)).a(com.baidu.navisdk.ugc.utils.c.b(1)).a(String.valueOf(System.currentTimeMillis() / 1000)).c(com.baidu.navisdk.ugc.https.d.a(true)).c(i).b(1).a(), new c(this, i, uidCodecDecode));
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void w(Message message) {
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void w0(Message message) {
        boolean z = true;
        if (message.arg1 != 1) {
            z = false;
        }
        com.baidu.navisdk.module.pronavi.model.g.o().f = z;
        BNavigatorLogic bNavigatorLogic = this.f9072a;
        if (bNavigatorLogic == null) {
            return;
        }
        if (z) {
            bNavigatorLogic.j();
        } else {
            bNavigatorLogic.s0();
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void x(Message message) {
        LogUtil.e("RouteGuide", "ExpandMap type onDynamicWindowUpdate");
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
            a(true, message);
        }
        if (!x.b().R1()) {
            return;
        }
        a(true, message);
        k kVar = this.e;
        if (kVar != null) {
            if (!(kVar instanceof com.baidu.navisdk.module.pronavi.message.b)) {
                kVar.a(this.f9072a.c(), "Dynamic", (Bundle) message.obj);
            } else {
                a(this.f9072a.c(), "Dynamic", (Bundle) message.obj, com.baidu.navisdk.module.pronavi.message.c.UPDATE);
            }
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void x0(Message message) {
        com.baidu.navisdk.module.pronavi.model.g.o().e(false);
        x.b().I().u();
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void y(Message message) {
        k kVar;
        if (message != null && (kVar = this.e) != null) {
            kVar.y(message);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void z(Message message) {
        LogUtil.e("RouteGuide", "onIntervalCameraOutMapHide ->");
        com.baidu.navisdk.module.pronavi.model.g.o().b(false);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().a(8, true);
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_TYPE", 4385);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().a(bundle);
    }

    public void a(Activity activity, String str, Bundle bundle, com.baidu.navisdk.module.pronavi.message.c cVar) {
        int i = bundle.getInt(RouteGuideParams.RGKey.ExpandMap.TotalDist);
        int i2 = bundle.getInt(RouteGuideParams.RGKey.ExpandMap.RemainDist);
        String string = bundle.getString("road_name");
        int i3 = (i2 <= 0 || i <= 0) ? 100 : ((i - i2) * 100) / i;
        Bitmap bitmap = ((BitmapDrawable) a0.I().d(a0.I().h().getString("icon_name"))).getBitmap();
        LogUtil.e("RouteGuide", "enlargeMapType=" + str + "action=" + cVar + ", remainedDistance=" + i2 + ",totalDistance=" + i + ", progress=" + i3);
        if (!"Raster".equals(str) && !"Street".equals(str)) {
            if ("Dynamic".equals(str)) {
                if (this.g == null) {
                    this.g = new com.baidu.nplatform.comapi.map.e(activity);
                }
                try {
                    ((com.baidu.navisdk.module.pronavi.message.b) this.e).a(cVar, this.g, i2 + "", i3, string, bitmap);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (this.f == null) {
            ImageView imageView = new ImageView(activity);
            this.f = imageView;
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if ("Raster".equals(str)) {
            this.f.setBackgroundDrawable(new BitmapDrawable(com.baidu.navisdk.ui.routeguide.model.i.s().c()));
            this.f.setImageBitmap(com.baidu.navisdk.ui.routeguide.model.i.s().b());
        } else {
            this.f.setImageBitmap(com.baidu.navisdk.ui.routeguide.model.i.s().c());
            this.f.setBackgroundResource(android.R.color.transparent);
        }
        try {
            ((com.baidu.navisdk.module.pronavi.message.b) this.e).a(cVar, this.f, i2 + "", i3, string, bitmap);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "onOfflineToOnlineFailed --> failedType = " + i + ", isOfflineToOnlineViewExist = " + s.T().k(110));
        }
        if (i == 1) {
            if (LogUtil.LOGGABLE) {
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "测试toast: 自动请求在线算路失败!!!");
            }
            if (s.T().k(110)) {
                com.baidu.navisdk.util.worker.c.a().a(new a(this, "-onOfflineToOnlineFailed", null), new com.baidu.navisdk.util.worker.e(2, 0), 3000L);
                return;
            }
            return;
        }
        if (i == 2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "onOfflineToOnlineFailed --> 取消自动请求在线算路");
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "测试toast: 取消自动请求在线算路!!!");
                return;
            }
            return;
        }
        if (i != 3) {
            if (i != 4) {
                return;
            }
            s.T().a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_offline_to_online_failure), false);
            x.b().c1();
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "onOfflineToOnlineFailed --> 取消自动请求在线算路");
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "测试toast: 恢复网络自动在线重算失败!!!");
        }
    }

    public BNHighwayInfo c() {
        BNHighwayInfo bNHighwayInfo = new BNHighwayInfo();
        bNHighwayInfo.directionText = m.y().a();
        bNHighwayInfo.exitRemainDist = m.y().h();
        bNHighwayInfo.exitCode = m.y().d();
        bNHighwayInfo.exitName = m.y().g();
        bNHighwayInfo.gateName = m.y().k();
        bNHighwayInfo.gateRemainDist = m.y().l();
        bNHighwayInfo.serviceName = m.y().q();
        bNHighwayInfo.service2Name = m.y().o();
        bNHighwayInfo.serviceRemainDist = m.y().r();
        bNHighwayInfo.service2RemainDist = m.y().p();
        bNHighwayInfo.highWayName = m.y().b();
        return bNHighwayInfo;
    }

    public void b(int i) {
        Bundle bundle = new Bundle();
        if (JNIGuidanceControl.getInstance().GetViaPoint(i, bundle)) {
            LogUtil.e("RouteGuide", "onArriveViaPoint: index --> " + i + ", bundle: " + bundle);
            int i2 = (int) (bundle.getDouble("x") * 100000.0d);
            int i3 = (int) (bundle.getDouble("y") * 100000.0d);
            bundle.getInt(MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE);
            com.baidu.navisdk.module.nearbysearch.model.a a2 = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.a(new GeoPoint(i2, i3));
            com.baidu.navisdk.ui.routeguide.subview.a aVar = this.b;
            if (aVar != null) {
                aVar.a(10, 0, 0, a2);
                return;
            }
            return;
        }
        LogUtil.e("RouteGuide", "onArriveViaPoint: Error --> GetViaPoint returns false");
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void c(Message message) {
        com.baidu.navisdk.ui.routeguide.control.a.d().a(message);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void f() {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.navicenter.impl.g.f():void");
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void b() {
        LogUtil.e("RouteGuide", "onUGCEventTipsShow ->");
        a0.E = true;
        s.T().Q();
    }

    private void d() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuideVIA_ETA", "clearToolboxViaEta-> ");
        }
        x.b().D1();
        a0.I().G();
    }

    private void a(Bundle bundle) {
        Bundle h;
        if (bundle != null) {
            if ((bundle.containsKey("resid") ? bundle.getInt("resid") : -1) > 0 || (h = a0.I().h()) == null || !h.containsKey("resid")) {
                return;
            }
            bundle.putInt("resid", h.getInt("resid"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("handleServiceAreaVisible-> isServiceAreaCanShow= ");
            sb.append(com.baidu.navisdk.ui.routeguide.b.V().i().c() == null ? "null" : Boolean.valueOf(com.baidu.navisdk.ui.routeguide.b.V().i().c().s()));
            sb.append("\n, getServiceAreaData= ");
            sb.append(com.baidu.navisdk.ui.routeguide.b.V().i().c() != null ? Integer.valueOf(com.baidu.navisdk.ui.routeguide.b.V().i().c().m().size()) : "null");
            LogUtil.e("RouteGuide", sb.toString());
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().i().c() != null && com.baidu.navisdk.ui.routeguide.b.V().i().c().s()) {
            if (x.b().V1()) {
                x.b().A4();
                com.baidu.navisdk.ui.routeguide.b.V().i().c().u();
                return;
            }
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null && com.baidu.navisdk.ui.routeguide.b.V().j().l().b().m().isEmpty()) {
            com.baidu.navisdk.ui.routeguide.b.V().j().l().e();
            return;
        }
        x.b().z1();
        if (com.baidu.navisdk.ui.routeguide.b.V().i().c() != null) {
            com.baidu.navisdk.ui.routeguide.b.V().i().c().w();
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.a, com.baidu.navisdk.comapi.routeguide.g
    public void a(Message message) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("ExpandMap type onRasterExpandMapHide, data = ");
            sb.append(message.getData() == null ? message.getData() : message.getData().toString());
            gVar.e("RouteGuide", sb.toString());
        }
        E0(message);
    }

    private void a(boolean z, Message message) {
        Bundle h;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            LogUtil.e("RouteGuide", "ExpandMap type updateCommonWindowGuideInfo, args: " + message.arg1 + ", " + message.arg2);
        }
        if (!com.baidu.navisdk.ui.routeguide.asr.c.n().f() && z && !RGFSMTable.FsmState.EnlargeRoadmap.equalsIgnoreCase(RouteGuideFSM.getInstance().getTopState())) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "updateCommonWindowGuideInfo: others");
                return;
            }
            return;
        }
        Bundle A0 = A0(message);
        if (A0 != null) {
            Bundle a2 = com.baidu.navisdk.ui.routeguide.model.i.s().a(z, A0);
            if ((a2.containsKey("resid") ? a2.getInt("resid") : -1) <= 0 && (h = a0.I().h()) != null && h.containsKey("resid")) {
                a2.putInt("resid", h.getInt("resid"));
            }
            x.b().a(a2, false);
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.q.1.1", "2", null, null);
        LogUtil.e("RouteGuide", "ExpandMap type onVectorExpandMapUpdate getVectorExpandMapInfo failed!");
    }

    public void a(int i) {
        com.baidu.navisdk.module.pronavi.message.model.b bVar;
        if (i != b.a.c) {
            bVar = new com.baidu.navisdk.module.pronavi.message.model.b();
            bVar.a(m.y().v());
            bVar.a(m.y().a());
            bVar.a(m.y().h());
            bVar.b(m.y().d());
            bVar.c(m.y().g());
            bVar.d(m.y().k());
            bVar.b(m.y().l());
            bVar.g(m.y().q());
            bVar.f(m.y().o());
            bVar.d(m.y().r());
            bVar.c(m.y().p());
            bVar.e(m.y().b());
        } else {
            bVar = null;
        }
        BNRouteGuider.getInstance().messageCallback(2, i, 0, bVar);
    }

    private void a(String str) {
        o g = com.baidu.navisdk.ui.routeguide.b.V().g();
        if (g != null) {
            g.a(str);
        }
    }
}
