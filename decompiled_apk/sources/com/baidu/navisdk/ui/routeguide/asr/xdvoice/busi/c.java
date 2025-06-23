package com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.control.q;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.i;
import com.baidu.navisdk.ui.routeguide.toolbox.view.a;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.map.j;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class c extends com.baidu.navisdk.module.asr.busi.b {
    private final BNMapObserver g = new a();

    /* loaded from: classes8.dex */
    public class a implements BNMapObserver {
        public a() {
        }

        @Override // com.baidu.navisdk.comapi.base.b
        public void update(com.baidu.navisdk.comapi.base.c cVar, int i, int i2, Object obj) {
            if (a0.I().D()) {
                g.ASR.e("XDVoice", "EVENT_CLICKED_POI_BKG_LAYER return isyawing");
                return;
            }
            if (!c.this.d()) {
                return;
            }
            String str = ((MapItem) obj).mUid;
            g.ASR.e("XDVoice", "layerID = " + str);
            c.this.d(com.baidu.navisdk.poisearch.c.a(str));
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.o {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8500a;

        public b(int i) {
            this.f8500a = i;
        }

        @Override // com.baidu.navisdk.ui.routeguide.toolbox.view.a.o
        public void a() {
            if (((com.baidu.navisdk.module.asr.busi.b) c.this).f7028a != null) {
                ((com.baidu.navisdk.module.asr.busi.b) c.this).f7028a.b();
            }
            BNRoutePlaner.getInstance().l(this.f8500a);
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().n1();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0428c implements i0.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8501a;

        public C0428c(int i) {
            this.f8501a = i;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            c.this.e(this.f8501a);
            c.this.i();
        }
    }

    private void j() {
        ((com.baidu.navisdk.model.modelfactory.e) com.baidu.navisdk.model.modelfactory.c.a().a("PoiSearchModel")).a();
        com.baidu.navisdk.poisearch.c.b();
        com.baidu.navisdk.poisearch.c.a();
        BNMapController.getInstance().updateLayer(4);
        BNMapController.getInstance().clearLayer(4);
        BNMapController.getInstance().showLayer(4, false);
    }

    private void k() {
        s.T().p();
        com.baidu.navisdk.poisearch.model.a.k().a(false);
        com.baidu.navisdk.poisearch.model.a.k().e(-1);
        BNMapController.getInstance().setRouteSearchStatus(false);
        j();
        BNMapController.getInstance().sendCommandToMapEngine(6, null);
        x.b().O4();
        com.baidu.navisdk.ui.routeguide.control.b.k().b(this.g);
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_NEARBY_SEARCH);
    }

    public void e(int i) {
        k();
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_NEARBY_SEARCH);
    }

    @Override // com.baidu.navisdk.module.asr.busi.b
    public void f() {
        k();
    }

    @Override // com.baidu.navisdk.module.asr.busi.b
    public void g() {
        s.T().a(JarUtils.getResources().getString(R.string.asr_rg_pref_change_route_not_use), false);
    }

    @Override // com.baidu.navisdk.module.asr.busi.b
    public void h() {
        s.T().a(JarUtils.getResources().getString(R.string.nav_voice_eta_query_search_error), false);
    }

    @Override // com.baidu.navisdk.module.asr.busi.b
    public void b(int i) {
        String str;
        if (i < 0 || i >= this.c.size()) {
            return;
        }
        com.baidu.navisdk.ui.search.model.a aVar = this.c.get(i);
        com.baidu.navisdk.poisearch.model.a.k().c(i);
        BNMapController.getInstance().focusItem(4, i, true);
        BNMapController.getInstance().updateLayer(4);
        if (!TextUtils.isEmpty(aVar.e) && !TextUtils.equals(aVar.e, "0")) {
            str = "距离" + aVar.e;
        } else {
            StringBuilder sb = new StringBuilder();
            l0.a((int) aVar.o, l0.a.ZH, sb);
            str = "距离" + c(sb.toString());
        }
        s.T().b(aVar.b, str, new C0428c(i));
    }

    @Override // com.baidu.navisdk.module.asr.busi.b
    public void c(int i) {
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.l.1.9", "0", "0", com.baidu.navisdk.asr.d.B().d() ? "1" : "0");
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().b("信息查询中", new b(i));
    }

    @Override // com.baidu.navisdk.module.asr.busi.b
    public void a(int i) {
        List<com.baidu.navisdk.ui.search.model.a> list = this.c;
        if (list == null || i < 0 || i >= list.size()) {
            return;
        }
        com.baidu.navisdk.ui.search.model.a aVar = this.c.get(i);
        ArrayList<com.baidu.navisdk.module.nearbysearch.model.a> e = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.e();
        int n = com.baidu.navisdk.ui.routeguide.utils.b.n();
        if (e != null && e.size() >= n) {
            String a2 = com.baidu.navisdk.ui.util.b.a(R.string.nsdk_string_rg_max_add_via_exceeded, Integer.valueOf(n));
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), a2);
            this.f7028a.a(com.baidu.navisdk.module.asr.instructions.b.b(a2));
            e();
            return;
        }
        BNRoutePlaner.getInstance().h(1);
        if (com.baidu.navisdk.poisearch.model.a.k().h()) {
            com.baidu.navisdk.poisearch.model.a.k().a(false);
            com.baidu.navisdk.poisearch.model.a.k().e(-1);
            com.baidu.navisdk.poisearch.c.a();
            BNMapController.getInstance().updateLayer(4);
            BNMapController.getInstance().showLayer(4, false);
        }
        a0.I();
        a0.G = 8;
        l.l().a(aVar.l, aVar.b, aVar.f9185a);
    }

    private String c(String str) {
        return (!TextUtils.isEmpty(str) && str.contains(".0")) ? str.replace(".0", "") : str;
    }

    private void a(List<com.baidu.navisdk.model.datastruct.s> list) {
        BNMapController.getInstance().updateLayer(3);
        if (list == null) {
            return;
        }
        com.baidu.navisdk.poisearch.c.a();
        com.baidu.navisdk.poisearch.c.a(list, -1, 1, -1);
        BNMapController.getInstance().updateLayer(4);
        BNMapController.getInstance().showLayer(4, true);
        BNMapController.getInstance().sendCommandToMapEngine(5, null);
        int i = 0;
        boolean z = x.b().d0() == 1;
        Rect rect = new Rect();
        if (z) {
            rect.left = 0;
            float a2 = com.baidu.navisdk.module.asr.busi.c.a(210.0f);
            com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
            rect.top = (aVar.d() - ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b())) - ((int) a2);
            rect.right = aVar.e();
            rect.bottom = (int) (JarUtils.getResources().getDimension(R.dimen.nsdk_rg_cp_bottom_height) + 0.5f);
        } else {
            com.baidu.navisdk.ui.routeguide.utils.a aVar2 = com.baidu.navisdk.ui.routeguide.utils.a.f9151a;
            rect.left = aVar2.c() / 4;
            rect.top = aVar2.a() - ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b());
            rect.right = aVar2.c();
            rect.bottom = (int) JarUtils.getResources().getDimension(R.dimen.nsdk_rg_cp_bottom_height);
        }
        Bundle bundle = new Bundle();
        int[] iArr = new int[list.size() * 2];
        for (com.baidu.navisdk.model.datastruct.s sVar : list) {
            iArr[i] = sVar.k.getLongitudeE6();
            iArr[i + 1] = sVar.k.getLatitudeE6();
            i += 2;
        }
        bundle.putIntArray("geoList", iArr);
        BNRouteGuider.getInstance().getRouteInfoInUniform(13, bundle);
        Rect rect2 = new Rect();
        rect2.left = (int) bundle.getDouble("bound_left");
        rect2.right = (int) bundle.getDouble("bound_right");
        rect2.top = (int) bundle.getDouble("bound_top");
        rect2.bottom = (int) bundle.getDouble("bound_bottom");
        q.c().a(rect2, rect, z, j.b.eAnimationViewall, 1000);
    }

    @Override // com.baidu.navisdk.module.asr.busi.g
    public void a() {
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
        com.baidu.navisdk.poisearch.model.a.k().a(true);
        BNMapController.getInstance().setRouteSearchStatus(true);
        com.baidu.navisdk.poisearch.model.a k = com.baidu.navisdk.poisearch.model.a.k();
        List<com.baidu.navisdk.ui.search.model.a> list = this.c;
        k.e(list == null ? -1 : list.size());
        if (!RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getTopState())) {
            if (i.s().k()) {
                com.baidu.navisdk.ui.routeguide.b.V().w();
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
            }
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.ENTRY_NEARBY_SEARCH);
        }
        a(com.baidu.navisdk.ui.search.model.a.a(this.c));
        x.b().i5();
    }
}
