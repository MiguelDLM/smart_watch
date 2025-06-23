package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ugc.a;
import com.baidu.navisdk.ugc.b;
import com.baidu.navisdk.ugc.interaction.c;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.m;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.f;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class d1 {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.ui.routeguide.ugc.b f8732a = null;
    private com.baidu.navisdk.ui.routeguide.ugc.a b = null;

    /* loaded from: classes8.dex */
    public class a implements com.baidu.navisdk.ugc.replenishdetails.a {
        public a(d1 d1Var) {
        }

        @Override // com.baidu.navisdk.ugc.replenishdetails.a
        public void a(boolean z) {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().J().b(z);
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().J().a(z, true);
            com.baidu.navisdk.ui.routeguide.control.x.b().q(z);
        }
    }

    /* loaded from: classes8.dex */
    public class b extends b.AbstractC0368b {
        public b() {
        }

        @Override // com.baidu.navisdk.ugc.b.AbstractC0368b
        public void a(boolean z) {
            d1.this.n();
        }

        @Override // com.baidu.navisdk.ugc.b.AbstractC0368b
        public ArrayList<View> b() {
            ViewGroup s0 = com.baidu.navisdk.ui.routeguide.control.x.b().s0();
            if (s0 == null) {
                return null;
            }
            ArrayList<View> arrayList = new ArrayList<>(2);
            if (com.baidu.navisdk.ui.routeguide.control.x.b().d0() == 1) {
                if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
                    arrayList.add(s0.findViewById(R.id.bnav_rg_top_panel));
                } else {
                    arrayList.add(s0.findViewById(R.id.bnav_simple_model_guide_panel_layout));
                }
            } else {
                arrayList.add(com.baidu.navisdk.ui.routeguide.control.x.b().U());
            }
            if (RGLaneInfoModel.getModel(false).isShowLaneLineView()) {
                arrayList.add(s0.findViewById(R.id.bnav_rg_lane_line_root_view));
            }
            return arrayList;
        }

        @Override // com.baidu.navisdk.ugc.b.AbstractC0368b
        public int c() {
            if (com.baidu.navisdk.ui.routeguide.control.x.b().d0() == 1) {
                return com.baidu.navisdk.ui.routeguide.mapmode.a.o5().K() + 360;
            }
            if (!com.baidu.navisdk.ui.routeguide.b.V().r().g()) {
                return 20;
            }
            return 20 + ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b());
        }

        @Override // com.baidu.navisdk.ugc.b.AbstractC0368b
        public void d() {
            if (RouteGuideFSM.getInstance().isBrowseState()) {
                com.baidu.navisdk.ui.routeguide.b.V().r().n();
            }
        }

        @Override // com.baidu.navisdk.ugc.b.AbstractC0368b
        public int a() {
            return R.id.bnav_rg_ugc_menu_panel;
        }
    }

    /* loaded from: classes8.dex */
    public class e extends com.baidu.navisdk.comapi.ugc.a {
        public e() {
        }

        @Override // com.baidu.navisdk.comapi.ugc.a
        public void a(Bundle bundle) {
            if (bundle != null && bundle.getBoolean("isHighlightedState", true)) {
                if (BNMapController.getInstance().getMapController() != null) {
                    BNMapController.getInstance().getMapController().a(false, -1, -1, "", (String) null);
                }
                d1.this.s();
            }
        }

        @Override // com.baidu.navisdk.comapi.ugc.a
        public void b(Bundle bundle) {
            com.baidu.navisdk.framework.interfaces.pronavi.k o;
            if (BNMapController.getInstance().getMapController() != null && bundle != null && bundle.getBoolean("isHighlightedState", true)) {
                BNMapController.getInstance().getMapController().a(true, bundle.getInt(MapItem.KEY_JAM_INDEX), bundle.getInt("jamVersion"), bundle.getString("event_id"), bundle.getString("routeMD5"));
            }
            if (bundle != null) {
                boolean z = bundle.getBoolean("isOrientationChange", false);
                int i = bundle.getInt("source", 0);
                if (z && i == 16 && (o = com.baidu.navisdk.util.common.x.o()) != null) {
                    o.d();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends a.b {
        public f() {
        }

        @Override // com.baidu.navisdk.ugc.a.b
        public Activity a() {
            return com.baidu.navisdk.ui.routeguide.b.V().b();
        }

        @Override // com.baidu.navisdk.ugc.a.b
        public int b() {
            if (com.baidu.navisdk.ui.routeguide.control.x.b().d0() == 1) {
                return com.baidu.navisdk.ui.routeguide.mapmode.a.o5().K();
            }
            return 0;
        }

        @Override // com.baidu.navisdk.ugc.a.b
        public boolean d() {
            return false;
        }

        @Override // com.baidu.navisdk.ugc.a.b
        public boolean e() {
            return com.baidu.navisdk.ui.routeguide.b.V().r().g();
        }

        @Override // com.baidu.navisdk.ugc.a.b
        public void f() {
            if (d1.this.b != null) {
                d1.this.b.c();
                d1.this.b.a();
                d1.this.b = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends com.baidu.navisdk.comapi.ugc.a {
        public g(d1 d1Var) {
        }

        @Override // com.baidu.navisdk.comapi.ugc.a
        public void a(Bundle bundle) {
            if (BNMapController.getInstance().getMapController() != null && bundle != null && bundle.getBoolean("isHighlightedState", true)) {
                BNMapController.getInstance().getMapController().a(false, bundle.getString("id"), bundle.getInt("iid"));
            }
        }

        @Override // com.baidu.navisdk.comapi.ugc.a
        public void b(Bundle bundle) {
            if (BNMapController.getInstance().getMapController() != null && bundle != null && bundle.getBoolean("isHighlightedState", true)) {
                BNMapController.getInstance().getMapController().a(true, bundle.getString("id"), bundle.getInt("iid"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends c.d {

        /* loaded from: classes8.dex */
        public class a implements m.g {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.baidu.navisdk.ugc.interaction.b f8737a;

            public a(h hVar, com.baidu.navisdk.ugc.interaction.b bVar) {
                this.f8737a = bVar;
            }

            @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.m.g
            public void a() {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                if (gVar.d()) {
                    gVar.e("RGMMUgcViewController", "naving auto close in showNavingNoticeTips");
                }
                com.baidu.navisdk.ugc.interaction.b bVar = this.f8737a;
                if (bVar != null) {
                    bVar.c(1);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements f.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.baidu.navisdk.ugc.interaction.b f8738a;

            public b(h hVar, com.baidu.navisdk.ugc.interaction.b bVar) {
                this.f8738a = bVar;
            }

            @Override // com.baidu.navisdk.ui.routeguide.model.f.c
            public void onClick(int i) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                if (gVar.d()) {
                    gVar.e("RGMMUgcViewController", "naving click notice tip in showNavingNoticeTips clickType:" + i);
                }
                com.baidu.navisdk.ugc.interaction.b bVar = this.f8738a;
                if (bVar != null) {
                    if (i == 1) {
                        bVar.a(1);
                    } else {
                        bVar.b(1);
                    }
                }
            }
        }

        public h(d1 d1Var) {
        }

        @Override // com.baidu.navisdk.ugc.interaction.c.d
        public void a(String str, Bundle bundle) {
            com.baidu.navisdk.ui.routeguide.b.V().b(str, true, bundle);
        }

        @Override // com.baidu.navisdk.ugc.interaction.c.d
        public boolean a(String str, String str2, int i, com.baidu.navisdk.ugc.interaction.b bVar) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("RGMMUgcViewController", "showNavingNoticeTips BNavConfig.pRGLocateMode:" + com.baidu.navisdk.module.pronavi.a.j);
            }
            if (com.baidu.navisdk.module.pronavi.a.j == 2) {
                return false;
            }
            if (!com.baidu.navisdk.function.b.FUNC_UGC_DETAILS.a()) {
                if (gVar.d()) {
                    gVar.e("RGMMUgcViewController", "showNavingNoticeTips: FUNC_UGC_DETAILS not enable");
                }
                return false;
            }
            return com.baidu.navisdk.ui.routeguide.mapmode.a.o5().j(116).z(100).f(str2).b(JarUtils.getResources().getDrawable(i)).v(20000).a(new b(this, bVar)).a(new a(this, bVar)).y();
        }

        @Override // com.baidu.navisdk.ugc.interaction.c.d
        public boolean a() {
            int c = com.baidu.navisdk.module.pronavi.model.g.o().c();
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMUgcViewController", "onSuccess instantaneousSpeed: " + c);
            }
            return c <= 5;
        }
    }

    private com.baidu.navisdk.ugc.external.e q() {
        return new c(this);
    }

    public static boolean r() {
        return com.baidu.navisdk.ugc.external.c.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (!RGFSMTable.FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getTopState())) {
            com.baidu.navisdk.ui.routeguide.b.V().r().n();
        }
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.hd.c c() {
        return this.b;
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.hd.c d() {
        return this.f8732a;
    }

    public void e() {
        com.baidu.navisdk.ui.routeguide.ugc.b bVar = this.f8732a;
        if (bVar != null) {
            bVar.j();
        }
    }

    public void f() {
        com.baidu.navisdk.ugc.replenishdetails.d.o().a(new a(this));
        com.baidu.navisdk.ugc.external.a.c().a(q());
    }

    public boolean g() {
        com.baidu.navisdk.ui.routeguide.ugc.a aVar = this.b;
        if (aVar != null && aVar.d()) {
            return true;
        }
        return false;
    }

    public boolean h() {
        com.baidu.navisdk.ui.routeguide.ugc.b bVar = this.f8732a;
        if (bVar != null && bVar.n()) {
            return true;
        }
        return false;
    }

    public void i() {
        com.baidu.navisdk.ui.routeguide.ugc.a aVar = this.b;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void j() {
        com.baidu.navisdk.ui.routeguide.ugc.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
            this.b.f();
            this.b = null;
        }
    }

    public void k() {
        com.baidu.navisdk.ui.routeguide.ugc.a aVar = this.b;
        if (aVar != null) {
            aVar.g();
        }
    }

    public void l() {
        com.baidu.navisdk.ui.routeguide.ugc.a aVar = this.b;
        if (aVar != null) {
            aVar.h();
        }
    }

    public void m() {
        com.baidu.navisdk.ui.routeguide.ugc.b bVar = this.f8732a;
        if (bVar != null) {
            bVar.o();
        }
    }

    public void n() {
        com.baidu.navisdk.ui.routeguide.ugc.b bVar = this.f8732a;
        if (bVar != null) {
            bVar.p();
            this.f8732a = null;
        }
    }

    public void o() {
        com.baidu.navisdk.ugc.interaction.c.a().a(2, new h(this));
    }

    public void p() {
        com.baidu.navisdk.ugc.replenishdetails.d.o().a((com.baidu.navisdk.ugc.replenishdetails.a) null);
        com.baidu.navisdk.ugc.external.a.c().a();
    }

    public boolean b(int i) {
        com.baidu.navisdk.ui.routeguide.ugc.b bVar = this.f8732a;
        return bVar != null && bVar.a(i);
    }

    /* loaded from: classes8.dex */
    public class c extends com.baidu.navisdk.ugc.external.e {
        public c(d1 d1Var) {
        }

        @Override // com.baidu.navisdk.ugc.external.e
        public void a(String str, String str2) {
            if (com.baidu.navisdk.util.common.x.t()) {
                com.baidu.navisdk.ui.routeguide.control.x.b().z();
                com.baidu.navisdk.ui.routeguide.control.s.T().d(str);
            }
        }

        @Override // com.baidu.navisdk.ugc.external.e
        public void a(com.baidu.navisdk.ugc.report.data.datarepository.a aVar) {
            if (com.baidu.navisdk.util.common.x.t()) {
                com.baidu.navisdk.ui.routeguide.control.x.b().z();
                com.baidu.navisdk.ui.routeguide.control.s.T().e(com.baidu.navisdk.j.d() ? aVar.c.f8245a : "上报成功，感谢您的反馈");
            }
        }

        @Override // com.baidu.navisdk.ugc.external.e
        public void a(String str) {
            super.a(str);
        }
    }

    public void b(int i, int i2, Intent intent) {
        com.baidu.navisdk.ui.routeguide.ugc.b bVar = this.f8732a;
        if (bVar != null) {
            bVar.a(i, i2, intent);
        }
    }

    public void a(ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar, int i) {
        if (!com.baidu.navisdk.util.common.z.a(com.baidu.navisdk.framework.a.c().a())) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), JarUtils.getResources().getString(R.string.nsdk_network_not_available));
            return;
        }
        if (this.f8732a == null) {
            this.f8732a = new com.baidu.navisdk.ui.routeguide.ugc.b(com.baidu.navisdk.ui.routeguide.b.V().b(), viewGroup, new b(), com.baidu.navisdk.ui.routeguide.control.x.b().d0(), i, com.baidu.navisdk.ugc.report.data.datarepository.c.g(), com.baidu.navisdk.module.vehiclemanager.b.i().b() == 3 ? com.baidu.navisdk.ugc.report.data.datarepository.c.f() : null);
        }
        if (com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
            com.baidu.navisdk.ui.routeguide.control.x.b().B();
        }
        if (com.baidu.navisdk.ugc.replenishdetails.d.o().a(2)) {
            this.f8732a.s();
        } else if (com.baidu.navisdk.ugc.replenishdetails.d.o().b(2)) {
            this.f8732a.t();
        } else {
            this.f8732a.c(true);
        }
        this.f8732a.r();
    }

    private void b(ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar, String str, Bundle bundle) {
        int i = bundle.containsKey("ridx") ? bundle.getInt("ridx", -1) : -1;
        if (i >= 0 && i <= 2) {
            int routeLabelType = JNIGuidanceControl.getInstance().getRouteLabelType(i);
            r7 = (routeLabelType & 1048576) == 1048576;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("RGMMUgcViewController", "showUgcDetailsPanel: " + i + ",routeLabelType: " + routeLabelType);
            }
        }
        bundle.putBoolean("notShowAvoidCongestion", r7);
        if (this.b == null) {
            com.baidu.navisdk.ui.routeguide.ugc.a aVar2 = new com.baidu.navisdk.ui.routeguide.ugc.a(com.baidu.navisdk.ui.routeguide.b.V().c(), viewGroup, new d());
            this.b = aVar2;
            aVar2.a(new e());
            this.b.a(str, bundle, com.baidu.navisdk.ui.routeguide.control.x.b().d0());
        }
    }

    /* loaded from: classes8.dex */
    public class d extends a.b {
        public d() {
        }

        @Override // com.baidu.navisdk.ugc.a.b
        public void a(int i, Bundle bundle) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMUgcViewController", "onClickButton: " + i + ", " + bundle);
            }
            if (com.baidu.navisdk.ui.routeguide.control.x.b().l2()) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGMMUgcViewController", "onClickAvoidCongestion isInterceptRecalRouteOnVdrGuide ");
                }
            } else {
                if (bundle == null) {
                    return;
                }
                d1.this.a(i, bundle);
            }
        }

        @Override // com.baidu.navisdk.ugc.a.b
        public int b() {
            if (com.baidu.navisdk.ui.routeguide.control.x.b().d0() == 1) {
                return com.baidu.navisdk.ui.routeguide.mapmode.a.o5().K();
            }
            if (!com.baidu.navisdk.ui.routeguide.b.V().r().g()) {
                return 20;
            }
            return 20 + ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b());
        }

        @Override // com.baidu.navisdk.ugc.a.b
        public boolean d() {
            return false;
        }

        @Override // com.baidu.navisdk.ugc.a.b
        public boolean e() {
            return com.baidu.navisdk.ui.routeguide.b.V().r().g();
        }

        @Override // com.baidu.navisdk.ugc.a.b
        public void f() {
            if (d1.this.b != null) {
                d1.this.b.c();
                d1.this.b.a();
                d1.this.b = null;
            }
            com.baidu.navisdk.framework.interfaces.pronavi.k o = com.baidu.navisdk.util.common.x.o();
            if (o != null) {
                o.c();
            }
        }

        @Override // com.baidu.navisdk.ugc.a.b
        public Activity a() {
            return com.baidu.navisdk.ui.routeguide.b.V().b();
        }
    }

    public void b() {
        com.baidu.navisdk.ui.routeguide.ugc.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
            this.b = null;
        }
    }

    private Bundle b(Bundle bundle) {
        return com.baidu.navisdk.util.common.o.b((int) bundle.getDouble("x"), (int) bundle.getDouble("y"));
    }

    public void a(ViewGroup viewGroup, int i) {
        com.baidu.navisdk.ui.routeguide.ugc.b bVar;
        if (!com.baidu.navisdk.ugc.external.d.n || (bVar = this.f8732a) == null) {
            return;
        }
        bVar.a(viewGroup, i);
        this.f8732a.r();
    }

    public void a(ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar, String str, Bundle bundle, boolean z) {
        if (bundle == null) {
            return;
        }
        bundle.putBoolean("isOrientationChange", z);
        if (bundle.getInt("source", 0) == 11) {
            a(viewGroup, aVar, str, bundle);
        } else {
            b(viewGroup, aVar, str, bundle);
        }
        if (this.b != null) {
            com.baidu.navisdk.ui.routeguide.control.s.T().p();
            if (com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
                com.baidu.navisdk.ui.routeguide.control.x.b().B();
            }
            this.b.i();
        }
    }

    private void a(ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar, String str, Bundle bundle) {
        if (bundle != null) {
            bundle.putInt("page", 1);
        }
        if (this.b == null) {
            com.baidu.navisdk.ui.routeguide.ugc.a aVar2 = new com.baidu.navisdk.ui.routeguide.ugc.a(com.baidu.navisdk.ui.routeguide.b.V().c(), viewGroup, new f());
            this.b = aVar2;
            aVar2.a(new g(this));
            this.b.a(str, bundle, com.baidu.navisdk.ui.routeguide.control.x.b().d0());
        }
    }

    public void a(Message message) {
        com.baidu.navisdk.ui.routeguide.ugc.a aVar;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMUgcViewController", "onTrafficLightEvent: " + message.arg1 + ", " + message.arg2);
        }
        if (message.arg1 == 2 && (aVar = this.b) != null && aVar.d()) {
            this.b.a(message.arg2);
        }
    }

    public boolean a(int i) {
        com.baidu.navisdk.ui.routeguide.ugc.a aVar = this.b;
        return aVar != null && aVar.b(i);
    }

    public void a(int i, int i2, Intent intent) {
        com.baidu.navisdk.ui.routeguide.ugc.a aVar = this.b;
        if (aVar != null) {
            aVar.a(i, i2, intent);
        }
    }

    public static void a(boolean z) {
        com.baidu.navisdk.ugc.external.c.b(z);
    }

    public void a() {
        com.baidu.navisdk.ui.routeguide.ugc.a aVar = this.b;
        if (aVar != null && aVar.d()) {
            this.b.b();
        }
        com.baidu.navisdk.ui.routeguide.ugc.b bVar = this.f8732a;
        if (bVar == null || !bVar.n()) {
            return;
        }
        this.f8732a.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Bundle bundle) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMUgcViewController", "handleOnClickButton(), clickType = " + i + " bundle = " + bundle);
        }
        if (i == 1) {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().r4();
            BNRouteGuider.getInstance().calcOtherRoute(bundle.getString("event_id", null), 1, 27);
        } else if (i != 2) {
            if (i != 3) {
                return;
            }
            a(bundle);
        } else {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().r4();
            Bundle bundle2 = new Bundle();
            bundle2.putInt(MapItem.KEY_JAM_INDEX, bundle.getInt(MapItem.KEY_JAM_INDEX, -1));
            bundle2.putInt("jamVer", bundle.getInt("jamVersion", -1));
            BNRouteGuider.getInstance().calcOtherRoute(null, 1, 34, bundle2);
        }
    }

    private void a(Bundle bundle) {
        boolean c2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMUgcViewController", "addVia: " + bundle);
        }
        com.baidu.navisdk.module.nearbysearch.model.b bVar = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE;
        ArrayList<com.baidu.navisdk.module.nearbysearch.model.a> e2 = bVar.e();
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("handleOnClickButton --> viaNodeList.size = ");
            sb.append(e2 == null ? 0 : e2.size());
            LogUtil.e("RGMMUgcViewController", sb.toString());
        }
        if (com.baidu.navisdk.j.d()) {
            int n = com.baidu.navisdk.ui.routeguide.utils.b.n();
            if (e2 != null && e2.size() >= n) {
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.ui.util.b.a(R.string.nsdk_string_rg_max_add_via_exceeded, Integer.valueOf(n)));
                return;
            }
        } else if (e2 != null && e2.size() >= BNSettingManager.getViaPointCount()) {
            if (com.baidu.navisdk.util.common.g.c0) {
                com.baidu.navisdk.util.common.g.OPEN_SDK.f("RGMMUgcViewController", "showPickPoint --> " + BNSettingManager.getViaPointCount());
            }
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_add_via_over));
            return;
        }
        String string = bundle.getString("uid");
        Bundle b2 = b(bundle);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMUgcViewController", "addVia: " + b2);
        }
        GeoPoint geoPoint = new GeoPoint(b2.getInt("LLx"), b2.getInt("LLy"));
        if (a(string, geoPoint)) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "已设为终点，不可设途经点");
            return;
        }
        if (!TextUtils.isEmpty(string)) {
            c2 = bVar.a(string);
        } else {
            c2 = bVar.c(geoPoint);
        }
        if (c2) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_has_been_add_via));
            return;
        }
        j();
        com.baidu.navisdk.ui.routeguide.model.a0.G = 1;
        String string2 = bundle.getString("eventName");
        com.baidu.navisdk.module.nearbysearch.model.a aVar = new com.baidu.navisdk.module.nearbysearch.model.a();
        aVar.setName(string2);
        aVar.setGeoPoint(geoPoint);
        aVar.setUID(string);
        bVar.a(aVar, false);
        com.baidu.navisdk.ui.routeguide.control.l.l().a(geoPoint, string2, string);
    }

    private boolean a(String str, GeoPoint geoPoint) {
        RoutePlanNode g2;
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar == null || (g2 = fVar.g()) == null) {
            return false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMUgcViewController", "isContainerEndNode: " + g2.toString());
        }
        if (!TextUtils.isEmpty(str)) {
            return str.equals(g2.getUID());
        }
        GeoPoint geoPoint2 = g2.mGeoPoint;
        if (geoPoint2 == null || geoPoint == null) {
            return false;
        }
        return a(geoPoint, geoPoint2);
    }

    private boolean a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        return geoPoint != null && geoPoint2 != null && geoPoint.getLatitudeE6() > 0 && geoPoint.getLongitudeE6() > 0 && Math.abs(geoPoint.getLongitudeE6() - geoPoint2.getLongitudeE6()) < 2 && Math.abs(geoPoint.getLatitudeE6() - geoPoint2.getLatitudeE6()) < 2;
    }
}
