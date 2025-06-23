package com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi;

import android.text.TextUtils;
import com.baidu.navisdk.adapter.IBNRouteResultManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.t;
import com.baidu.navisdk.module.asr.busi.a;
import com.baidu.navisdk.module.asr.h;
import com.baidu.navisdk.module.asr.i;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.control.r;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import com.garmin.fit.xOxOoo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class e extends com.baidu.navisdk.module.asr.busi.a {
    private static e f;

    private e() {
        super(com.baidu.navisdk.asr.d.B(), new a());
    }

    public static e d() {
        if (f == null) {
            f = new e();
        }
        com.baidu.navisdk.module.asr.busi.e.a(f);
        return f;
    }

    public void a(ArrayList<String> arrayList, ArrayList<String> arrayList2, boolean z) {
        this.d = z;
        if (z) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.n.2");
        }
        if (h.a()) {
            i.c(JarUtils.getResources().getString(R.string.asr_rg_pref_route_search_not_use));
            return;
        }
        ArrayList<com.baidu.navisdk.module.nearbysearch.model.a> e = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.e();
        int n = com.baidu.navisdk.ui.routeguide.utils.b.n();
        if (e != null && e.size() >= n) {
            i.c("已无法添加更多途经点，将继续当前导航");
            s.T().a("已无法添加更多途经点，将继续当前导航", false);
            s.T().a("已无法添加更多途经点，将继续当前导航", true);
            return;
        }
        r.i().a(arrayList, arrayList2, 20);
        if (arrayList != null) {
            String str = arrayList.get(0);
            this.f7026a = str;
            if (arrayList2 != null) {
                if (!TextUtils.equals(str, IBNRouteResultManager.NearbySearchKeyword.Gas_Station) && !TextUtils.equals(this.f7026a, IBNRouteResultManager.NearbySearchKeyword.Charging_Station)) {
                    this.f7026a = arrayList2.get(0);
                } else {
                    this.f7026a = arrayList2.get(0) + this.f7026a;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("routeSearch type:");
        sb.append(arrayList == null ? "null" : arrayList.get(0));
        sb.append(" detail:");
        sb.append(arrayList2 != null ? arrayList2.get(0) : "null");
        i.a(sb.toString());
    }

    @Override // com.baidu.navisdk.module.asr.busi.a
    public String c() {
        return "0";
    }

    /* loaded from: classes8.dex */
    public static class a implements a.e {

        /* renamed from: a, reason: collision with root package name */
        private String f8505a = "";

        private void d() {
            ((com.baidu.navisdk.model.modelfactory.e) com.baidu.navisdk.model.modelfactory.c.a().a("PoiSearchModel")).a();
            com.baidu.navisdk.poisearch.c.b();
            com.baidu.navisdk.poisearch.c.a();
            BNMapController.getInstance().updateLayer(4);
            BNMapController.getInstance().clearLayer(4);
            BNMapController.getInstance().showLayer(4, false);
        }

        private static boolean e() {
            if (x.b().m2()) {
                g gVar = g.ASR;
                if (gVar.d()) {
                    gVar.e("XDVoiceAbstractAsrNearbySearchQuery", "isInterceptRecalRouteForVdrGuide: ");
                }
                String h = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_vdr_intercept_recal_route_tip);
                s.T().a(h, false);
                com.baidu.navisdk.asr.d.B().a(com.baidu.navisdk.module.asr.instructions.b.b(h));
                return true;
            }
            if (!a0.I().w()) {
                return false;
            }
            String h2 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_intercept_pre_yawing_route_tip);
            s.T().a(h2, false);
            com.baidu.navisdk.asr.d.B().a(com.baidu.navisdk.module.asr.instructions.b.b(h2));
            return true;
        }

        private void f() {
            d();
            BNMapController.getInstance().sendCommandToMapEngine(6, null);
            x.b().O4();
            r.i().d();
        }

        @Override // com.baidu.navisdk.module.asr.busi.a.e
        public void a(com.baidu.navisdk.model.datastruct.s sVar) {
            if (sVar == null || e()) {
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.g.1", "2", null, null);
            ArrayList<com.baidu.navisdk.module.nearbysearch.model.a> e = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.e();
            int n = com.baidu.navisdk.ui.routeguide.utils.b.n();
            if (e.size() >= n) {
                String a2 = com.baidu.navisdk.ui.util.b.a(R.string.nsdk_string_rg_max_add_via_exceeded, Integer.valueOf(n));
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), a2);
                f();
                com.baidu.navisdk.asr.d.B().a(com.baidu.navisdk.module.asr.instructions.b.b(a2));
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
            a0.G = 1;
            l.l().a(sVar.k, sVar.e, sVar.p, sVar.z);
        }

        @Override // com.baidu.navisdk.module.asr.busi.a.e
        public void b(com.baidu.navisdk.model.datastruct.s sVar) {
            if (sVar == null || e()) {
                return;
            }
            BNRoutePlaner.getInstance().h(0);
            a0.G = 13;
            this.f8505a = sVar.e;
            l.l().a(sVar.e, sVar.k, sVar.p);
        }

        @Override // com.baidu.navisdk.module.asr.busi.a.e
        public void c() {
            f();
            com.baidu.navisdk.asr.d.B().a(com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.asr_rg_switch_route_cancel)));
        }

        @Override // com.baidu.navisdk.module.asr.busi.a.e
        public void b() {
            f();
        }

        @Override // com.baidu.navisdk.module.asr.busi.a.e
        public String a(List<com.baidu.navisdk.model.datastruct.s> list, int i) {
            g gVar = g.ASR;
            if (gVar.d()) {
                gVar.e("XDVoiceAbstractAsrNearbySearchQuery", "getRouteSearchData confirmNum: " + i);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pgname", "NaviPage");
                jSONObject.put("pgtype", "route_search");
                jSONObject.put("pgid", "");
                JSONArray jSONArray = new JSONArray();
                for (com.baidu.navisdk.model.datastruct.s sVar : list) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("uid", sVar.p);
                    jSONObject2.put("name", sVar.e);
                    jSONObject2.put("address", sVar.g);
                    jSONObject2.put("route_cost", sVar.u);
                    jSONObject2.put(xOxOoo.f15470o00, sVar.h);
                    jSONObject2.put("tag", sVar.t);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("list", jSONArray);
                JSONObject jSONObject3 = new JSONObject();
                if (list.size() == 1) {
                    jSONObject3.put("intention", "route_search");
                } else {
                    jSONObject3.put("intention", "route_search_multi_result");
                }
                jSONObject3.put("confirm_num", i);
                jSONObject.put("client", jSONObject3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }

        @Override // com.baidu.navisdk.module.asr.busi.a.e
        public String a() {
            return this.f8505a;
        }
    }

    @Override // com.baidu.navisdk.module.asr.busi.a
    public void a(List<com.baidu.navisdk.model.datastruct.s> list, t tVar, boolean z) {
        if (com.baidu.navisdk.poisearch.model.a.k().f() != 1) {
            return;
        }
        super.a(list, tVar, z);
    }
}
