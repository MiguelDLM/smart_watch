package com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.module.abtest.model.k;
import com.baidu.navisdk.module.asr.i;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.control.q;
import com.baidu.navisdk.ui.routeguide.control.r;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.common.o;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.logic.h;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class d extends com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.a {
    private static d m;
    private final com.baidu.navisdk.comapi.base.d k;
    private final BNMapObserver l;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.b {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(4099);
            observe(4175);
        }

        @Override // com.baidu.navisdk.util.worker.loop.b
        public void onMessage(Message message) {
            g.ASR.e("XDVoiceModifyDestination", "PRoute message's what is" + message.what);
            if (message.what == 4099) {
                if (message.arg1 != 0) {
                    d.this.b(false);
                } else {
                    Bundle bundle = new Bundle();
                    BNRoutePlaner.getInstance().a(new ArrayList<>(), bundle);
                    if (bundle.containsKey("unRoutePlanID")) {
                        int i = bundle.getInt("unRoutePlanID");
                        d dVar = d.this;
                        if (dVar.f8495a == i) {
                            dVar.h();
                            com.baidu.navisdk.module.vehiclemanager.a.a(bundle, com.baidu.navisdk.module.vehiclemanager.b.i().b());
                        }
                    }
                }
            }
            com.baidu.navisdk.vi.b.b(d.this.k);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements BNMapObserver {

        /* loaded from: classes8.dex */
        public class a implements i0.f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f8504a;

            public a(int i) {
                this.f8504a = i;
            }

            @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
            public void a() {
            }

            @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
            public void b() {
            }

            @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
            public void c() {
                d.this.a(this.f8504a);
            }
        }

        public b() {
        }

        @Override // com.baidu.navisdk.comapi.base.b
        public void update(com.baidu.navisdk.comapi.base.c cVar, int i, int i2, Object obj) {
            String str;
            if (1 == i && i2 == 265) {
                if (a0.I().D()) {
                    g.ASR.e("XDVoiceModifyDestination", "EVENT_CLICKED_POI_BKG_LAYER return isyawing");
                    return;
                }
                if (!d.this.e()) {
                    return;
                }
                String str2 = ((MapItem) obj).mUid;
                g.ASR.e("XDVoiceModifyDestination", "layerID = " + str2);
                int a2 = com.baidu.navisdk.poisearch.c.a(str2);
                if (a2 >= 0) {
                    com.baidu.navisdk.ui.search.model.a aVar = d.this.d.get(a2);
                    com.baidu.navisdk.poisearch.model.a.k().c(a2);
                    BNMapController.getInstance().focusItem(4, a2, true);
                    BNMapController.getInstance().updateLayer(4);
                    if (!TextUtils.isEmpty(aVar.e) && !TextUtils.equals(aVar.e, "0")) {
                        str = "距离" + aVar.e;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        l0.a((int) aVar.o, l0.a.ZH, sb);
                        str = "距离" + d.this.a(sb.toString());
                    }
                    s.T().a(aVar.b, str, new a(a2));
                }
            }
        }
    }

    private d() {
        super(com.baidu.navisdk.asr.d.B());
        this.k = new a("PRoute");
        this.l = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        String string = JarUtils.getResources().getString(R.string.asr_rg_error_planing_select_route, this.b);
        i.c(string);
        if (z) {
            s.T().a(string, false);
        }
        if (this.j == null) {
            return;
        }
        if (TextUtils.equals(this.c, "home")) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.j.2.2", "2", d(), this.j.d() ? "1" : "0");
        } else if (TextUtils.equals(this.c, "company")) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.j.3.2", "2", d(), this.j.d() ? "1" : "0");
        }
    }

    private void k() {
        ((com.baidu.navisdk.model.modelfactory.e) com.baidu.navisdk.model.modelfactory.c.a().a("PoiSearchModel")).a();
        com.baidu.navisdk.poisearch.c.b();
        com.baidu.navisdk.poisearch.c.a();
        BNMapController.getInstance().updateLayer(4);
        BNMapController.getInstance().clearLayer(4);
        BNMapController.getInstance().showLayer(4, false);
    }

    public static d l() {
        if (m == null) {
            m = new d();
        }
        return m;
    }

    private void m() {
        k();
        BNMapController.getInstance().sendCommandToMapEngine(6, null);
        x.b().O4();
        r.i().d();
    }

    @Override // com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.a
    public String d() {
        return "0";
    }

    @Override // com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.a
    public boolean f() {
        com.baidu.navisdk.poisearch.model.a.k().a(false);
        com.baidu.navisdk.poisearch.model.a.k().e(-1);
        BNMapController.getInstance().setRouteSearchStatus(false);
        m();
        com.baidu.navisdk.ui.routeguide.control.b.k().b(this.l);
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.a
    public void g() {
        b(true);
    }

    public void i() {
        StringBuilder sb = new StringBuilder();
        sb.append("当前终点就是");
        sb.append(((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).g().getName());
        sb.append("预计通行");
        StringBuilder a2 = com.baidu.navisdk.ui.routeguide.asr.instruction.b.a(sb);
        com.baidu.navisdk.asr.d.B().c();
        e(a2.toString());
    }

    public void j() {
        int size;
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
        com.baidu.navisdk.poisearch.model.a.k().a(true);
        BNMapController.getInstance().setRouteSearchStatus(true);
        com.baidu.navisdk.poisearch.model.a k = com.baidu.navisdk.poisearch.model.a.k();
        List<com.baidu.navisdk.ui.search.model.a> list = this.d;
        if (list == null) {
            size = -1;
        } else {
            size = list.size();
        }
        k.e(size);
        if (!RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getTopState())) {
            if (com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
                com.baidu.navisdk.ui.routeguide.b.V().w();
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
            }
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.ENTRY_NEARBY_SEARCH);
        }
        a(com.baidu.navisdk.ui.search.model.a.a(this.d));
        x.b().i5();
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
            float a2 = a(210.0f);
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

    @Override // com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.a
    public String b(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pgname", "NaviPage");
            jSONObject.put("pgid", "");
            jSONObject.put("pgtype", "");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("state", "change_address");
            jSONObject2.put("change", str);
            jSONObject.put("client", jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.a
    public void a(com.baidu.navisdk.ui.search.model.a aVar, int i) {
        com.baidu.navisdk.vi.b.a(this.k);
        GeoPoint b2 = h.b();
        if (b2 != null && b2.isValid()) {
            if (this.h) {
                this.b = aVar.b;
            }
            a0.G = 5;
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(this.i)) {
                bundle.putString("speech_id", this.i);
            }
            bundle.putBoolean("force_clear_last_route_plan_node", false);
            l.l().a(new RoutePlanNode(aVar.l, i, aVar.b, "", aVar.f9185a), 2, -1, 0, true, bundle);
            this.f8495a = BNRoutePlaner.getInstance().v();
            if (TextUtils.equals(this.c, "home")) {
                Bundle c = o.c(aVar.l.getLongitudeE6(), aVar.l.getLatitudeE6());
                com.baidu.navisdk.framework.b.b(this.b, c.getInt("MCx"), c.getInt("MCy"));
                return;
            } else {
                if (TextUtils.equals(this.c, "company")) {
                    Bundle c2 = o.c(aVar.l.getLongitudeE6(), aVar.l.getLatitudeE6());
                    com.baidu.navisdk.framework.b.a(this.b, c2.getInt("MCx"), c2.getInt("MCy"));
                    return;
                }
                return;
            }
        }
        i.c(JarUtils.getResources().getString(R.string.asr_rg_gps_error));
    }

    @Override // com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.a
    public void a() {
        k();
        com.baidu.navisdk.module.pronavi.a.v = true;
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar != null) {
            k.x().a(fVar.g());
        }
    }
}
