package com.baidu.navisdk.ui.routeguide.control;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import com.baidu.navisdk.adapter.IBNRouteResultManager;
import com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.ui.routeguide.model.d0;
import com.baidu.navisdk.ui.routeguide.model.f;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.routesearchfilterview.BNRouteNearbySearchUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.navimageloader.b;
import com.baidu.navisdk.yellowtipdata.model.a;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.voicesquare.interfaces.VoiceInterfaceImplProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class s {
    private static s h;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.m> f8584a = new ArrayList<>();
    private final ArrayList<com.baidu.navisdk.ui.routeguide.model.f> b = new ArrayList<>();
    private final ArrayList<i0> c = new ArrayList<>();
    private final ArrayList<com.baidu.navisdk.ui.routeguide.model.u> d = new ArrayList<>();
    private final ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.l> e = new ArrayList<>();
    private final ArrayList<com.baidu.navisdk.ui.routeguide.model.e> f = new ArrayList<>();
    private WeakReference<com.baidu.navisdk.ui.routeguide.subview.a> g;

    /* loaded from: classes8.dex */
    public class a implements g0.e {
        public a(s sVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void c() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void d() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a(boolean z) {
            int i = com.baidu.navisdk.ui.routeguide.model.x.A().r;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "setShowRouteChoose, showStatus:1, pushType:10, sourceType:" + i);
            }
            JNIGuidanceControl.getInstance().setShowRouteChoose(1, 10, i);
            BNMapController.getInstance().setMapForceSwitchStrategy(true);
            BNRouteGuider.getInstance().SetFullViewState(true);
            com.baidu.navisdk.ui.routeguide.control.x.b().D0 = true;
            com.baidu.navisdk.ui.routeguide.control.x.b().a(24, 23, 22);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b(boolean z) {
            int i = com.baidu.navisdk.ui.routeguide.model.x.A().r;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "setShowRouteChoose, showStatus:4, pushType:10, sourceType:" + i + ", isFullViewState:" + com.baidu.navisdk.ui.routeguide.model.g.h().a());
            }
            BNMapController.getInstance().setMapForceSwitchStrategy(false);
            if (!com.baidu.navisdk.ui.routeguide.model.g.h().a()) {
                BNRouteGuider.getInstance().SetFullViewState(false);
            }
            JNIGuidanceControl.getInstance().setShowRouteChoose(4, 10, i);
            com.baidu.navisdk.ui.routeguide.control.x.b().D0 = false;
            com.baidu.navisdk.ui.routeguide.control.x.b().a(24, 23, 22);
        }
    }

    /* loaded from: classes8.dex */
    public class a0 extends g0.f {
        public a0(s sVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b() {
            com.baidu.navisdk.ui.routeguide.model.a0.E = false;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void c() {
            com.baidu.navisdk.ui.routeguide.model.a0.E = false;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void d() {
        }
    }

    /* loaded from: classes8.dex */
    public class b extends g0.f {
        public b(s sVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void c() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void d() {
        }
    }

    /* loaded from: classes8.dex */
    public class b0 implements i0.f {
        public b0(s sVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showWaitRPResult --> click cancel btn, quit nav!!!");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.a", "1", "1", null);
            com.baidu.navisdk.module.abtest.model.k.x().t();
            com.baidu.navisdk.ui.routeguide.b.V().H();
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showWaitRPResult --> click confirm btn, re calc route!!!");
            }
            com.baidu.navisdk.ui.routeguide.model.a0.I().u = false;
            com.baidu.navisdk.ui.routeguide.control.x.b().o4();
            com.baidu.navisdk.ui.routeguide.control.l.l().a(com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k());
        }
    }

    /* loaded from: classes8.dex */
    public class c extends g0.f {
        public c(s sVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void c() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void d() {
        }
    }

    /* loaded from: classes8.dex */
    public class d extends g0.f {
        public d(s sVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a() {
            com.baidu.navisdk.poisearch.model.b.m().b(true);
            com.baidu.navisdk.ui.routeguide.control.r.i().a();
            com.baidu.navisdk.ui.routeguide.control.x.b().l(false);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b() {
            com.baidu.navisdk.poisearch.model.b.m().b(false);
            BNMapController.getInstance().focusItem(4, com.baidu.navisdk.poisearch.model.a.k().e(), false);
            if (RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getTopState())) {
                com.baidu.navisdk.ui.routeguide.control.r.i().g();
                com.baidu.navisdk.ui.routeguide.control.x.b().c4();
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void c() {
            com.baidu.navisdk.poisearch.model.b.m().b(false);
            BNMapController.getInstance().focusItem(4, com.baidu.navisdk.poisearch.model.a.k().e(), false);
            if (RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getTopState())) {
                com.baidu.navisdk.ui.routeguide.control.r.i().g();
                com.baidu.navisdk.ui.routeguide.control.x.b().c4();
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void d() {
            com.baidu.navisdk.poisearch.model.b.m().b(true);
            com.baidu.navisdk.ui.routeguide.control.r.i().a();
            com.baidu.navisdk.ui.routeguide.control.x.b().l(false);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements i0.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.model.datastruct.n f8585a;

        public e(s sVar, com.baidu.navisdk.model.datastruct.n nVar) {
            this.f8585a = nVar;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
            com.baidu.navisdk.poisearch.model.b.m().b(false);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            com.baidu.navisdk.poisearch.model.b.m().b(false);
            com.baidu.navisdk.poisearch.model.a.k().j();
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            String str;
            int size;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showPickPoint() --> onConfirmBtnClick()");
            }
            com.baidu.navisdk.poisearch.model.b.m().b(false);
            com.baidu.navisdk.module.nearbysearch.model.b bVar = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE;
            ArrayList<com.baidu.navisdk.module.nearbysearch.model.a> e = bVar.e();
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("onConfirmBtnClick() --> viaNodeList.size = ");
                if (e == null) {
                    size = 0;
                } else {
                    size = e.size();
                }
                sb.append(size);
                gVar.e("RGNotificationController", sb.toString());
            }
            if (com.baidu.navisdk.j.d()) {
                int n = com.baidu.navisdk.ui.routeguide.utils.b.n();
                if (e != null && e.size() >= n) {
                    if (gVar.d()) {
                        gVar.e("RGNotificationController", "showPickPoint --> 途经点数量大于" + n + "个，直接返回！！！");
                    }
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.ui.util.b.a(R.string.nsdk_string_rg_max_add_via_exceeded, Integer.valueOf(n)));
                    return;
                }
            } else if (e != null && e.size() >= BNSettingManager.getViaPointCount()) {
                if (com.baidu.navisdk.util.common.g.c0) {
                    com.baidu.navisdk.util.common.g.OPEN_SDK.f("RGNotificationController", "showPickPoint --> " + BNSettingManager.getViaPointCount());
                }
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_add_via_over));
                return;
            }
            BNRoutePlaner.getInstance().h(1);
            if (com.baidu.navisdk.poisearch.model.a.k().h()) {
                com.baidu.navisdk.poisearch.model.a.k().a(false);
                com.baidu.navisdk.poisearch.model.a.k().e(-1);
                com.baidu.navisdk.poisearch.c.a();
                BNMapController.getInstance().updateLayer(4);
                BNMapController.getInstance().showLayer(4, false);
                com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410310", "410310");
            }
            com.baidu.navisdk.ui.routeguide.model.a0.I();
            com.baidu.navisdk.ui.routeguide.model.a0.G = 1;
            if (com.baidu.navisdk.poisearch.model.b.m().f() != null) {
                str = com.baidu.navisdk.poisearch.model.b.m().f().f6936a;
            } else {
                str = "";
            }
            GeoPoint d = com.baidu.navisdk.poisearch.model.b.m().d();
            String str2 = com.baidu.navisdk.poisearch.model.b.m().f().b;
            com.baidu.navisdk.module.nearbysearch.model.a aVar = new com.baidu.navisdk.module.nearbysearch.model.a();
            aVar.setName(str);
            aVar.setGeoPoint(d);
            aVar.setUID(str2);
            aVar.b(BNRouteNearbySearchUtils.getRouteAroundCategoryByStyleId(this.f8585a.c));
            bVar.a(aVar, false);
            com.baidu.navisdk.ui.routeguide.control.l.l().a(d, str, str2);
            com.baidu.navisdk.ui.routeguide.control.r.i().d();
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.g.3.2", BNRouteNearbySearchUtils.getRouteAroundOpsTypeByStyleId(this.f8585a.c), null, null);
        }
    }

    /* loaded from: classes8.dex */
    public class f extends g0.f {
        public f(s sVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a() {
            com.baidu.navisdk.poisearch.model.b.m().d(true);
            com.baidu.navisdk.ui.routeguide.control.r.i().a();
            com.baidu.navisdk.ui.routeguide.control.x.b().l(false);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b() {
            com.baidu.navisdk.poisearch.model.b.m().d(false);
            BNMapController.getInstance().focusItem(4, com.baidu.navisdk.poisearch.model.a.k().e(), false);
            if (RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getTopState())) {
                com.baidu.navisdk.ui.routeguide.control.r.i().g();
                com.baidu.navisdk.ui.routeguide.control.x.b().c4();
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void c() {
            com.baidu.navisdk.poisearch.model.b.m().d(false);
            BNMapController.getInstance().focusItem(4, com.baidu.navisdk.poisearch.model.a.k().e(), false);
            if (RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getTopState())) {
                com.baidu.navisdk.ui.routeguide.control.r.i().g();
                com.baidu.navisdk.ui.routeguide.control.x.b().c4();
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void d() {
            com.baidu.navisdk.poisearch.model.b.m().d(true);
            com.baidu.navisdk.ui.routeguide.control.r.i().a();
            com.baidu.navisdk.ui.routeguide.control.x.b().l(false);
        }
    }

    /* loaded from: classes8.dex */
    public class g implements i0.f {
        public g() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
            com.baidu.navisdk.poisearch.model.b.m().d(false);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            com.baidu.navisdk.poisearch.model.b.m().d(false);
            com.baidu.navisdk.poisearch.model.a.k().j();
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            String str;
            int size;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showPickPoint() --> onConfirmBtnClick()");
            }
            com.baidu.navisdk.poisearch.model.b.m().d(false);
            com.baidu.navisdk.poisearch.model.a.k().j();
            com.baidu.navisdk.module.nearbysearch.model.b bVar = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE;
            ArrayList<com.baidu.navisdk.module.nearbysearch.model.a> e = bVar.e();
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("onConfirmBtnClick() --> viaNodeList.size = ");
                if (e == null) {
                    size = 0;
                } else {
                    size = e.size();
                }
                sb.append(size);
                gVar.e("RGNotificationController", sb.toString());
            }
            if (com.baidu.navisdk.j.d()) {
                int n = com.baidu.navisdk.ui.routeguide.utils.b.n();
                if (e != null && e.size() >= n) {
                    if (gVar.d()) {
                        gVar.e("RGNotificationController", "showPickPoint --> 途经点数量大于" + n + "个，直接返回！！！");
                    }
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.ui.util.b.a(R.string.nsdk_string_rg_max_add_via_exceeded, Integer.valueOf(n)));
                    if (s.this.g != null && s.this.g.get() != null) {
                        ((com.baidu.navisdk.ui.routeguide.subview.a) s.this.g.get()).d();
                        return;
                    }
                    return;
                }
            } else if (e != null && e.size() >= BNSettingManager.getViaPointCount()) {
                if (com.baidu.navisdk.util.common.g.c0) {
                    com.baidu.navisdk.util.common.g.OPEN_SDK.f("RGNotificationController", "showPickPoint --> " + BNSettingManager.getViaPointCount());
                }
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_add_via_over));
                if (s.this.g != null && s.this.g.get() != null) {
                    ((com.baidu.navisdk.ui.routeguide.subview.a) s.this.g.get()).d();
                    return;
                }
                return;
            }
            BNRoutePlaner.getInstance().h(1);
            if (com.baidu.navisdk.poisearch.model.a.k().h()) {
                com.baidu.navisdk.poisearch.model.a.k().a(false);
                com.baidu.navisdk.poisearch.model.a.k().e(-1);
                com.baidu.navisdk.poisearch.c.a();
                BNMapController.getInstance().updateLayer(4);
                BNMapController.getInstance().showLayer(4, false);
                com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410310", "410310");
            }
            com.baidu.navisdk.ui.routeguide.model.a0.I();
            com.baidu.navisdk.ui.routeguide.model.a0.G = 1;
            if (com.baidu.navisdk.poisearch.model.b.m().a() != null) {
                str = com.baidu.navisdk.poisearch.model.b.m().a().e;
            } else {
                str = "";
            }
            GeoPoint d = com.baidu.navisdk.poisearch.model.b.m().d();
            String str2 = com.baidu.navisdk.poisearch.model.b.m().a().p;
            com.baidu.navisdk.module.nearbysearch.model.a aVar = new com.baidu.navisdk.module.nearbysearch.model.a();
            aVar.setName(str);
            aVar.setGeoPoint(d);
            aVar.setUID(str2);
            aVar.b(com.baidu.navisdk.poisearch.model.a.k().b());
            aVar.a(com.baidu.navisdk.poisearch.model.a.k().d());
            bVar.a(aVar, false);
            com.baidu.navisdk.ui.routeguide.control.l.l().a(d, str, str2);
            com.baidu.navisdk.ui.routeguide.control.r.i().d();
            if (com.baidu.navisdk.poisearch.model.a.k().f() == 1) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.g.1", "2", null, null);
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.g.1", "1", null, null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends g0.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.model.datastruct.chargestation.b f8587a;

        public h(s sVar, com.baidu.navisdk.model.datastruct.chargestation.b bVar) {
            this.f8587a = bVar;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a() {
            com.baidu.navisdk.poisearch.model.b.m().a(true);
            BNMapController.getDynamicOverlay().focusIdsBySid(BNDynamicOverlay.Key.ROUTE_AROUND_NE_CS_BUBBLE, this.f8587a.p());
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b() {
            com.baidu.navisdk.poisearch.model.b.m().a(false);
            BNMapController.getDynamicOverlay().cancelFocusAll(BNDynamicOverlay.Key.ROUTE_AROUND_NE_CS_BUBBLE);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void c() {
            com.baidu.navisdk.poisearch.model.b.m().b(false);
            BNMapController.getDynamicOverlay().cancelFocusAll(BNDynamicOverlay.Key.ROUTE_AROUND_NE_CS_BUBBLE);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void d() {
            com.baidu.navisdk.poisearch.model.b.m().a(true);
            BNMapController.getDynamicOverlay().focusIdsBySid(BNDynamicOverlay.Key.ROUTE_AROUND_NE_CS_BUBBLE, this.f8587a.p());
        }
    }

    /* loaded from: classes8.dex */
    public class i implements i0.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.model.datastruct.chargestation.b f8588a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        public i(s sVar, com.baidu.navisdk.model.datastruct.chargestation.b bVar, int i, String str) {
            this.f8588a = bVar;
            this.b = i;
            this.c = str;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
            com.baidu.navisdk.poisearch.model.b.m().a(false);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showAroundNeCsPoint --> onCancelBtnClick()");
            }
            com.baidu.navisdk.poisearch.model.b.m().a(false);
            com.baidu.navisdk.poisearch.model.a.k().j();
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.17.1.9", this.c);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showAroundNeCsPoint --> onConfirmBtnClick()");
            }
            com.baidu.navisdk.poisearch.model.b.m().b(false);
            String j = this.f8588a.j();
            GeoPoint g = this.f8588a.g();
            String p = this.f8588a.p();
            com.baidu.navisdk.module.nearbysearch.model.a aVar = new com.baidu.navisdk.module.nearbysearch.model.a();
            aVar.setName(j);
            aVar.setGeoPoint(g);
            aVar.setUID(p);
            aVar.setIconType(1);
            aVar.b(IBNRouteResultManager.NearbySearchKeyword.Charging_Station);
            int i = this.b;
            if (i != 1 && i != 3) {
                BNRoutePlaner.getInstance().h(0);
                com.baidu.navisdk.ui.routeguide.model.a0.G = 14;
                com.baidu.navisdk.poisearch.model.b.m().a(aVar.mName);
                com.baidu.navisdk.ui.routeguide.control.l.l().a(aVar);
            } else {
                com.baidu.navisdk.module.nearbysearch.model.b bVar = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE;
                ArrayList<com.baidu.navisdk.module.nearbysearch.model.a> e = bVar.e();
                if (gVar.d()) {
                    gVar.e("RGNotificationController", "showAroundNeCsPoint --> onConfirmBtnClick() --> viaNodeList.size = " + e.size());
                }
                if (com.baidu.navisdk.j.d()) {
                    int n = com.baidu.navisdk.ui.routeguide.utils.b.n();
                    if (e.size() >= n) {
                        if (gVar.d()) {
                            gVar.e("RGNotificationController", "showAroundNeCsPoint --> 途经点数量大于" + n + "个，直接返回！！！");
                        }
                        TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.ui.util.b.a(R.string.nsdk_string_rg_max_add_via_exceeded, Integer.valueOf(n)));
                        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
                        return;
                    }
                } else if (e.size() >= BNSettingManager.getViaPointCount()) {
                    if (com.baidu.navisdk.util.common.g.c0) {
                        com.baidu.navisdk.util.common.g.OPEN_SDK.f("RGNotificationController", "showAroundNeCsPoint --> " + BNSettingManager.getViaPointCount());
                    }
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_add_via_over));
                    RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
                    return;
                }
                BNRoutePlaner.getInstance().h(1);
                com.baidu.navisdk.ui.routeguide.model.a0.G = 1;
                bVar.a(aVar, false);
                com.baidu.navisdk.ui.routeguide.control.l.l().a(g, j, p, 1);
                if (this.b == 1) {
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.g.3.2", "2", null, null);
                }
            }
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.17.1.8", this.c);
        }
    }

    /* loaded from: classes8.dex */
    public class j extends g0.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.module.pronavi.model.d f8589a;

        public j(s sVar, com.baidu.navisdk.module.pronavi.model.d dVar) {
            this.f8589a = dVar;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a() {
            com.baidu.navisdk.poisearch.model.b.m().c(true);
            BNMapController.getDynamicOverlay().focusIdsBySid(BNDynamicOverlay.Key.SERVICE_AREA_ADD_VIA, this.f8589a.i());
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b() {
            com.baidu.navisdk.poisearch.model.b.m().c(false);
            BNMapController.getDynamicOverlay().cancelFocusAll(BNDynamicOverlay.Key.SERVICE_AREA_ADD_VIA);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void c() {
            com.baidu.navisdk.poisearch.model.b.m().c(false);
            BNMapController.getDynamicOverlay().cancelFocusAll(BNDynamicOverlay.Key.SERVICE_AREA_ADD_VIA);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void d() {
            com.baidu.navisdk.poisearch.model.b.m().c(true);
            BNMapController.getDynamicOverlay().focusIdsBySid(BNDynamicOverlay.Key.SERVICE_AREA_ADD_VIA, this.f8589a.i());
        }
    }

    /* loaded from: classes8.dex */
    public class k implements i0.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.module.pronavi.model.d f8590a;

        public k(s sVar, com.baidu.navisdk.module.pronavi.model.d dVar) {
            this.f8590a = dVar;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
            com.baidu.navisdk.poisearch.model.b.m().c(false);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showAroundCarServiceAreaPoint --> onCancelBtnClick()");
            }
            com.baidu.navisdk.poisearch.model.b.m().c(false);
            com.baidu.navisdk.poisearch.model.a.k().j();
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showAroundCarServiceAreaPoint --> onConfirmBtnClick()");
            }
            com.baidu.navisdk.poisearch.model.b.m().b(false);
            String h = this.f8590a.h();
            GeoPoint j = this.f8590a.j();
            String i = this.f8590a.i();
            com.baidu.navisdk.module.nearbysearch.model.a aVar = new com.baidu.navisdk.module.nearbysearch.model.a();
            aVar.setName(h);
            aVar.setGeoPoint(j);
            aVar.setUID(i);
            aVar.b(IBNRouteResultManager.NearbySearchKeyword.Service);
            com.baidu.navisdk.module.nearbysearch.model.b bVar = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE;
            ArrayList<com.baidu.navisdk.module.nearbysearch.model.a> e = bVar.e();
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showAroundCarServiceAreaPoint --> onConfirmBtnClick() --> viaNodeList.size = " + e.size());
            }
            if (com.baidu.navisdk.j.d()) {
                int n = com.baidu.navisdk.ui.routeguide.utils.b.n();
                if (e.size() >= n) {
                    if (gVar.d()) {
                        gVar.e("RGNotificationController", "showAroundCarServiceAreaPoint --> 途经点数量大于" + n + "个，直接返回！！！");
                    }
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.ui.util.b.a(R.string.nsdk_string_rg_max_add_via_exceeded, Integer.valueOf(n)));
                    RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
                    return;
                }
            } else if (e.size() >= BNSettingManager.getViaPointCount()) {
                if (com.baidu.navisdk.util.common.g.c0) {
                    com.baidu.navisdk.util.common.g.OPEN_SDK.f("RGNotificationController", "showAroundCarServiceAreaPoint --> " + BNSettingManager.getViaPointCount());
                }
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_add_via_over));
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
                return;
            }
            BNRoutePlaner.getInstance().h(1);
            com.baidu.navisdk.ui.routeguide.model.a0.G = 1;
            bVar.a(aVar, false);
            com.baidu.navisdk.ui.routeguide.control.l.l().a(j, h, i, 0, 2, 2);
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
        }
    }

    /* loaded from: classes8.dex */
    public class l extends g0.f {
        public l(s sVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a() {
            com.baidu.navisdk.poisearch.model.b.m().e(true);
            com.baidu.navisdk.ui.routeguide.control.r.i().a();
            com.baidu.navisdk.ui.routeguide.control.x.b().c();
            com.baidu.navisdk.ui.routeguide.control.x.b().l(false);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b() {
            com.baidu.navisdk.poisearch.model.b.m().e(false);
            BNMapController.getInstance().focusItem(4, com.baidu.navisdk.poisearch.model.a.k().e(), false);
            com.baidu.navisdk.ui.routeguide.control.x.b().a(0L);
            if (RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getTopState())) {
                com.baidu.navisdk.ui.routeguide.control.r.i().g();
                com.baidu.navisdk.ui.routeguide.control.x.b().c4();
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void c() {
            com.baidu.navisdk.poisearch.model.b.m().e(false);
            BNMapController.getInstance().focusItem(4, com.baidu.navisdk.poisearch.model.a.k().e(), false);
            com.baidu.navisdk.ui.routeguide.control.x.b().a(0L);
            if (RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getTopState())) {
                com.baidu.navisdk.ui.routeguide.control.r.i().g();
                com.baidu.navisdk.ui.routeguide.control.x.b().c4();
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void d() {
            com.baidu.navisdk.poisearch.model.b.m().e(true);
            com.baidu.navisdk.ui.routeguide.control.r.i().a();
            com.baidu.navisdk.ui.routeguide.control.x.b().c();
            com.baidu.navisdk.ui.routeguide.control.x.b().l(false);
        }
    }

    /* loaded from: classes8.dex */
    public class m implements i0.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GeoPoint f8591a;

        public m(s sVar, GeoPoint geoPoint) {
            this.f8591a = geoPoint;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
            com.baidu.navisdk.poisearch.model.b.m().e(false);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            com.baidu.navisdk.poisearch.model.b.m().e(false);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            com.baidu.navisdk.poisearch.model.b.m().e(false);
            BNRoutePlaner.getInstance().h(3);
            if (com.baidu.navisdk.poisearch.model.a.k().h()) {
                com.baidu.navisdk.poisearch.model.a.k().a(false);
                com.baidu.navisdk.poisearch.model.a.k().e(-1);
                com.baidu.navisdk.poisearch.c.a();
                BNMapController.getInstance().updateLayer(4);
                BNMapController.getInstance().showLayer(4, false);
            }
            com.baidu.navisdk.ui.routeguide.model.a0.I();
            com.baidu.navisdk.ui.routeguide.model.a0.G = 6;
            com.baidu.navisdk.ui.routeguide.control.l.l().a(this.f8591a);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.g.2", null, null, null);
        }
    }

    /* loaded from: classes8.dex */
    public class n extends com.baidu.navisdk.util.worker.f<String, String> {
        public n(s sVar, String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("XDVoice", "showFirstVoiceGuide()");
            }
            com.baidu.navisdk.ui.routeguide.control.x.b().j(113).z(100).v(10000).b(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_asr_normal)).f("呼叫'小度小度'开启语音控制").y();
            BNCommSettingManager.getInstance().setFirstVoiceNotifyGuide(false);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class o implements f.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8592a;

        public o(s sVar, int i) {
            this.f8592a = i;
        }

        @Override // com.baidu.navisdk.ui.routeguide.model.f.c
        public void onClick(int i) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.15.1.3", "" + this.f8592a, "" + i, null);
        }
    }

    /* loaded from: classes8.dex */
    public class p implements i0.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8593a;
        final /* synthetic */ Bundle b;

        public p(s sVar, int i, Bundle bundle) {
            this.f8593a = i;
            this.b = bundle;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.3.1352", this.f8593a + "", "1", "1");
            com.baidu.navisdk.comapi.routeplan.v2.b bVar = new com.baidu.navisdk.comapi.routeplan.v2.b();
            bVar.f6726a = new RoutePlanNode(com.baidu.navisdk.util.logic.h.b(), 3, "我的位置", "");
            bVar.f = 2;
            bVar.g = 0;
            bVar.d = com.baidu.navisdk.ui.routeguide.b.V().d().d();
            bVar.p = null;
            com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
            RoutePlanNode g = fVar.g();
            Bundle bundle = this.b;
            if (bundle != null && bundle.containsKey("permitInfoId")) {
                String string = this.b.getString("permitInfoId");
                String i = fVar.i();
                if (!TextUtils.isEmpty(i)) {
                    if (!l0.a(i.split(","), string)) {
                        string = string + "," + i;
                    } else {
                        string = i;
                    }
                }
                fVar.a(string);
            }
            bVar.b = g;
            com.baidu.navisdk.ui.routeguide.b.V().a(bVar, true);
        }
    }

    /* loaded from: classes8.dex */
    public class q implements f.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8594a;

        public q(s sVar, int i) {
            this.f8594a = i;
        }

        @Override // com.baidu.navisdk.ui.routeguide.model.f.c
        public void onClick(int i) {
            if (i == 1 && this.f8594a == 3) {
                com.baidu.navisdk.ui.routeguide.control.x.b().U2();
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.3.1352", "" + this.f8594a, "1", i + "");
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.control.s$s, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0441s implements f.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.yellowtipdata.model.data.c f8596a;

        public C0441s(s sVar, com.baidu.navisdk.yellowtipdata.model.data.c cVar) {
            this.f8596a = cVar;
        }

        @Override // com.baidu.navisdk.ui.routeguide.model.f.c
        public void onClick(int i) {
            if (i == 1) {
                if (this.f8596a.l() == 3) {
                    com.baidu.navisdk.ui.routeguide.control.x.b().U2();
                } else {
                    int e = this.f8596a.e();
                    if (e != 0) {
                        if (e != 1) {
                            if (e == 2) {
                                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                                if (gVar.d()) {
                                    gVar.e("RGNotificationController", "CLICK_ACTION_RE_CAL");
                                }
                            }
                        } else {
                            Bundle bundle = new Bundle();
                            bundle.putString("url", this.f8596a.m());
                            com.baidu.navisdk.framework.b.a(15, bundle);
                        }
                    } else {
                        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                        if (gVar2.d()) {
                            gVar2.e("RGNotificationController", "nothing");
                        }
                    }
                }
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.3.1352", "" + this.f8596a.l(), "1", i + "");
        }
    }

    /* loaded from: classes8.dex */
    public class u extends g0.f {
        public u(s sVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a() {
            BNSettingManager.setVoiceRecommendNotificationShowCnt(BNSettingManager.getVoiceRecommendNotificationShowCnt() + 1);
            com.baidu.navisdk.util.statistic.userop.b.r().a("5.4.1", "1", null, null);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void c() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void d() {
        }
    }

    /* loaded from: classes8.dex */
    public class v implements i0.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.yellowtipdata.model.data.c f8598a;
        final /* synthetic */ d0 b;
        final /* synthetic */ Bundle c;

        public v(com.baidu.navisdk.yellowtipdata.model.data.c cVar, d0 d0Var, Bundle bundle) {
            this.f8598a = cVar;
            this.b = d0Var;
            this.c = bundle;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.2", this.f8598a.l() + "", null, "1");
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showComOperableNoteWithCloud,onConfirmBtnClick");
            }
            int e = this.f8598a.e();
            if (e != 0) {
                if (e != 1) {
                    if (e == 2) {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.2", this.f8598a.l() + "", null, "2");
                        com.baidu.navisdk.ui.routeguide.model.a0.G = s.this.r(this.f8598a.l());
                        GeoPoint b = s.b(this.b.b(), this.b.c());
                        if (gVar.d()) {
                            gVar.e("RGNotificationController", " showComOperableNoteWithCloud, geoPoint:" + b);
                            gVar.e("RGNotificationController", " showComOperableNoteWithCloud, mode, x:" + this.b.b() + ",y:" + this.b.c());
                        }
                        com.baidu.navisdk.comapi.routeplan.v2.b bVar = new com.baidu.navisdk.comapi.routeplan.v2.b();
                        bVar.f6726a = new RoutePlanNode(com.baidu.navisdk.util.logic.h.b(), 3, "我的位置", "");
                        bVar.b = new RoutePlanNode(b, 8, this.b.a(), "", this.b.d());
                        bVar.f = 2;
                        bVar.g = 0;
                        bVar.p = null;
                        Bundle bundle = this.c;
                        bundle.putBoolean("restore_dest_cal", true);
                        bVar.r = bundle;
                        com.baidu.navisdk.ui.routeguide.b.V().a(bVar, true);
                    }
                } else if (gVar.d()) {
                    gVar.e("RGNotificationController", "nothing");
                }
            } else if (gVar.d()) {
                gVar.e("RGNotificationController", "nothing");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.3.1352", "" + this.f8598a.l(), "1", "1");
        }
    }

    /* loaded from: classes8.dex */
    public class w implements com.baidu.navisdk.framework.interfaces.y {
        public w() {
        }

        @Override // com.baidu.navisdk.framework.interfaces.y
        public View[] B() {
            View n0;
            View n02;
            View n03;
            if (s.this.j() && s.this.e != null && !s.this.e.isEmpty()) {
                com.baidu.navisdk.ui.routeguide.mapmode.subview.l lVar = (com.baidu.navisdk.ui.routeguide.mapmode.subview.l) s.this.e.get(s.this.e.size() - 1);
                if (lVar != null && (n03 = lVar.n0()) != null && n03.isShown()) {
                    return new View[]{n03};
                }
                return null;
            }
            if (s.this.l() && s.this.c != null && !s.this.c.isEmpty()) {
                i0 i0Var = (i0) s.this.c.get(s.this.c.size() - 1);
                if (i0Var != null && (n02 = i0Var.n0()) != null && n02.isShown()) {
                    return new View[]{n02};
                }
                return null;
            }
            if (s.this.k() && !s.this.f8584a.isEmpty()) {
                com.baidu.navisdk.ui.routeguide.model.f fVar = (com.baidu.navisdk.ui.routeguide.model.f) s.this.b.get(s.this.b.size() - 1);
                com.baidu.navisdk.ui.routeguide.mapmode.subview.m mVar = (com.baidu.navisdk.ui.routeguide.mapmode.subview.m) s.this.f8584a.get(s.this.f8584a.size() - 1);
                if (mVar != null && fVar.v == 1 && (n0 = mVar.n0()) != null && n0.isShown()) {
                    return new View[]{n0};
                }
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class x implements i0.f {
        public x(s sVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.2.2", null, "2", null);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            com.baidu.navisdk.ui.routeguide.model.a0.I();
            com.baidu.navisdk.ui.routeguide.model.a0.G = 11;
            com.baidu.navisdk.ui.routeguide.control.l.l().a(0, 48);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.2.2", null, "1", null);
        }
    }

    /* loaded from: classes8.dex */
    public class y implements i0.f {
        public y(s sVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.2.1", null, "1", null);
        }
    }

    /* loaded from: classes8.dex */
    public class z implements i0.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8600a;
        final /* synthetic */ String b;

        public z(s sVar, String str, String str2) {
            this.f8600a = str;
            this.b = str2;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("5.4.1", "3", null, null);
            BNCommSettingManager.getInstance().setHasVoiceRecommendClicked(true);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            Context a2 = com.baidu.navisdk.framework.a.c().a();
            if (!com.baidu.navisdk.util.common.z.b(a2)) {
                TipTool.onCreateToastDialog(a2, "当前网络异常");
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("5.4.1", "2", null, null);
            VoiceInterfaceImplProxy o = com.baidu.navisdk.framework.interfaces.c.p().o();
            if (o != null) {
                o.downloadVoice(this.f8600a);
            }
            BNCommSettingManager.getInstance().setHasVoiceRecommendClicked(true);
            String str = "正在为你下载" + this.b;
            TTSPlayerControl.playTTS(str, 1);
            TipTool.onCreateToastDialog(a2, str);
        }
    }

    private s() {
    }

    public static s T() {
        if (h == null) {
            synchronized (s.class) {
                try {
                    if (h == null) {
                        h = new s();
                    }
                } finally {
                }
            }
        }
        return h;
    }

    private Bundle U() {
        Bundle bundle = new Bundle();
        if (!JNIGuidanceControl.getInstance().GetLocalRouteInfo(bundle)) {
            return null;
        }
        return bundle;
    }

    private String V() {
        String b2 = com.baidu.navisdk.module.routepreference.i.j().b();
        if (!TextUtils.isEmpty(b2)) {
            return JarUtils.getResources().getString(R.string.nsdk_string_rg_common_notification_route_prefer, b2);
        }
        return "";
    }

    private boolean W() {
        Iterator<com.baidu.navisdk.ui.routeguide.model.u> it = h().iterator();
        while (it.hasNext()) {
            if (it.next().B == 116) {
                return true;
            }
        }
        return false;
    }

    private boolean X() {
        Iterator<com.baidu.navisdk.ui.routeguide.model.f> it = c().iterator();
        while (it.hasNext()) {
            if (it.next().r == 114) {
                return true;
            }
        }
        return W();
    }

    private boolean Y() {
        int e2 = BNRoutePlaner.getInstance().e();
        if (e2 == 3 || e2 == 1) {
            return true;
        }
        return false;
    }

    private boolean Z() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showRouteRecommend");
        }
        if (!com.baidu.navisdk.ui.routeguide.model.x.A().f8982a) {
            return false;
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().t1();
        com.baidu.navisdk.ui.routeguide.control.x.b().u1();
        com.baidu.navisdk.ui.routeguide.control.x.b().Z0();
        com.baidu.navisdk.ui.routeguide.control.x.b().o3();
        com.baidu.navisdk.ui.routeguide.control.x.b().b3();
        com.baidu.navisdk.ui.routeguide.control.x.b().a1();
        g0 c2 = com.baidu.navisdk.ui.routeguide.model.x.A().c();
        if (c2 == null) {
            return false;
        }
        c2.y();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.d", "", null, null);
        int m2 = com.baidu.navisdk.ui.routeguide.model.x.A().m();
        if (com.baidu.navisdk.ui.routeguide.model.x.A().e() != 3 && (m2 == 7 || m2 == 13)) {
            com.baidu.navisdk.ui.routeguide.utils.b.a("recommond route");
            int j2 = com.baidu.navisdk.ui.routeguide.model.x.A().j();
            int i2 = com.baidu.navisdk.ui.routeguide.model.x.A().r;
            int k2 = com.baidu.navisdk.ui.routeguide.model.x.A().k();
            if (gVar.d()) {
                gVar.e("RGNotificationController", "setShowRouteChoose, showStatus:1, pushType:" + j2 + "sourceType:" + i2 + "routeId:" + k2);
            }
            JNIGuidanceControl.getInstance().setShowRouteChoose(1, j2, i2);
            BNMapController.getInstance().setLabelBreathing(k2, true);
            if (gVar.d()) {
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "回传类型： 1");
            }
        }
        return true;
    }

    private int q(int i2) {
        if (i2 == 1) {
            return 100;
        }
        if (i2 == 2) {
            return 300;
        }
        if (i2 != 4) {
            return i2 != 5 ? 200 : 160;
        }
        return 150;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int r(int i2) {
        if (i2 != 39) {
            return i2 != 49 ? 0 : 12;
        }
        return 9;
    }

    private int s(int i2) {
        if (i2 != 39) {
            return i2 != 49 ? -1 : 126;
        }
        return 116;
    }

    private void u(int i2) {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.e> arrayList = this.f;
        if (arrayList == null) {
            return;
        }
        Iterator<com.baidu.navisdk.ui.routeguide.model.e> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.ui.routeguide.model.e next = it.next();
            if (next != null && next.h() == i2) {
                if (next.j() != null) {
                    next.j().s0();
                } else {
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("RGNotificationController", "hideCheckboxViewInner mView is null type:" + i2);
                    }
                }
                next.m();
                it.remove();
            }
        }
    }

    private void v(int i2) {
        int size;
        com.baidu.navisdk.ui.routeguide.model.f fVar;
        ArrayList<com.baidu.navisdk.ui.routeguide.model.f> arrayList = this.b;
        if (arrayList == null || (size = arrayList.size()) == 0 || (fVar = this.b.get(size - 1)) == null || fVar.r != i2) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.m mVar = fVar.f8941a;
        if (mVar != null) {
            mVar.q0();
        }
        fVar.c();
        if (this.b.isEmpty()) {
            return;
        }
        this.b.remove(r3.size() - 1);
    }

    private void w(int i2) {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.u> arrayList = this.d;
        if (arrayList == null) {
            return;
        }
        Iterator<com.baidu.navisdk.ui.routeguide.model.u> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.ui.routeguide.model.u next = it.next();
            if (next != null && next.B == i2) {
                i0 i0Var = next.f8977a;
                if (i0Var != null) {
                    i0Var.t0();
                } else {
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("RGNotificationController", "hideOperableViewInner mView is null type:" + i2);
                    }
                }
                next.a();
                it.remove();
            }
        }
    }

    private boolean x(int i2) {
        return i2 == 52 || i2 == 5;
    }

    public void A() {
        if (this.b != null && this.d != null && this.e != null) {
            ArrayList<com.baidu.navisdk.ui.routeguide.model.e> arrayList = this.f;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<com.baidu.navisdk.ui.routeguide.model.e> it = this.f.iterator();
                while (it.hasNext()) {
                    com.baidu.navisdk.ui.routeguide.model.e next = it.next();
                    if (next != null) {
                        if (it.hasNext()) {
                            next.m();
                            it.remove();
                        } else {
                            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                            if (gVar.d()) {
                                gVar.e("RGNotificationController", "recoveryCheckboxView NotificationType:" + next.h());
                            }
                            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(next).p0();
                        }
                    }
                }
                return;
            }
            if (!this.d.isEmpty()) {
                Iterator<com.baidu.navisdk.ui.routeguide.model.u> it2 = this.d.iterator();
                while (it2.hasNext()) {
                    com.baidu.navisdk.ui.routeguide.model.u next2 = it2.next();
                    if (next2 != null) {
                        i0 i0Var = next2.f8977a;
                        if (i0Var != null) {
                            i0Var.i();
                            next2.f8977a = null;
                        }
                        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                        if (gVar2.d()) {
                            gVar2.e("RGNotificationController", "recoveryOperableView NotificationType:" + next2.B);
                        }
                        i0 k2 = com.baidu.navisdk.ui.routeguide.mapmode.a.o5().k(next2.B);
                        next2.f8977a = k2;
                        if (k2 != null) {
                            next2.b = String.valueOf(k2.hashCode());
                            int i2 = next2.c;
                            if (i2 != 100 && i2 != 200 && i2 != 300) {
                                next2.f8977a.a(next2).C(next2.H).z(next2.G).a(next2.e).h(next2.f).y(next2.i).A(next2.k).b(next2.g).E(next2.j).c(next2.h).F(next2.l).g(next2.m).f(next2.n).x(next2.o).w(next2.p).d(next2.q).b(next2.I).b(next2.J);
                                if (!l0.c(next2.x) || next2.y != null) {
                                    if (!l0.c(next2.x) && next2.x.endsWith(".gif")) {
                                        next2.f8977a.i(next2.x);
                                    } else {
                                        next2.f8977a.a(next2.x, next2.y, next2.z);
                                    }
                                }
                                next2.f8977a.B(next2.r).c(next2.s).b(next2.t).a(next2.u).a(next2.v).a(next2.w).A(next2.C).p0();
                            } else {
                                next2.f8977a.a(next2).D(next2.c).C(next2.H).z(next2.G).a(next2.e).h(next2.f).y(next2.i).A(next2.k).b(next2.g).E(next2.j).c(next2.h).F(next2.l).d(next2.q).b(next2.I).b(next2.J);
                                if (!l0.c(next2.x) || next2.y != null) {
                                    if (!l0.c(next2.x) && next2.x.endsWith(".gif")) {
                                        next2.f8977a.i(next2.x);
                                    } else {
                                        next2.f8977a.a(next2.x, next2.y, next2.z);
                                    }
                                }
                                next2.f8977a.g(next2.m).f(next2.n).a(next2.u).a(next2.v).a(next2.w).A(next2.C).p0();
                            }
                        }
                    }
                }
                return;
            }
            Iterator<com.baidu.navisdk.ui.routeguide.model.f> it3 = this.b.iterator();
            while (it3.hasNext()) {
                com.baidu.navisdk.ui.routeguide.model.f next3 = it3.next();
                if (next3 != null) {
                    if (it3.hasNext()) {
                        next3.c();
                        it3.remove();
                    } else {
                        com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
                        if (gVar3.d()) {
                            gVar3.e("RGNotificationController", "recoveryCommonView NotificationType:" + next3);
                        }
                        if (!next3.b()) {
                            it3.remove();
                        } else {
                            com.baidu.navisdk.ui.routeguide.mapmode.subview.m a2 = com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(next3.r, next3.v);
                            next3.f8941a = a2;
                            if (a2 != null) {
                                next3.b = String.valueOf(a2.hashCode());
                                int i3 = next3.c;
                                if (i3 != 100 && i3 != 200 && i3 != 300 && i3 != 130) {
                                    next3.f8941a.a(next3).f(next3.e).g(next3.f).h(next3.g).x(next3.h).A(next3.i).D(next3.j).y(next3.l).b(next3.k).a(next3.o, next3.p, next3.q).a(next3.m).a(next3.n).p0();
                                } else {
                                    next3.f8941a.a(next3).z(next3.c).f(next3.e).g(next3.f).h(next3.g).b(next3.k).a(next3.o, next3.p, next3.q).a(next3.m).a(next3.n).p0();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void B() {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.e> arrayList = this.f;
        if (arrayList == null) {
            return;
        }
        Iterator<com.baidu.navisdk.ui.routeguide.model.e> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.ui.routeguide.model.e next = it.next();
            if (next != null && next.j() != null) {
                next.j().p0();
            }
        }
    }

    public void C() {
        i0 i0Var;
        ArrayList<com.baidu.navisdk.ui.routeguide.model.u> arrayList = this.d;
        if (arrayList == null) {
            return;
        }
        Iterator<com.baidu.navisdk.ui.routeguide.model.u> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.ui.routeguide.model.u next = it.next();
            if (next != null && (i0Var = next.f8977a) != null) {
                i0Var.p0();
            }
        }
    }

    public void D() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showCancelRouteRecommend");
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().j(100).z(100).b(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_fail)).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_common_notification_cancel_route_recommend)).y();
    }

    public void E() {
        com.baidu.navisdk.util.worker.c.a().a(new n(this, s.class.getSimpleName(), null), new com.baidu.navisdk.util.worker.e(99, 0), 5000L);
    }

    public void F() {
        com.baidu.navisdk.ui.routeguide.control.x.b().j(101).z(100).b(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_success)).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_common_notification_show_float_window)).y();
    }

    public void G() {
        if (!com.baidu.navisdk.ui.routeguide.model.a0.D) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().j(102).z(100).b(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_gps)).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_common_notification_gps_weak_maintitle)).y();
    }

    public void H() {
        String str;
        String sb;
        int i2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showPickPoint");
        }
        if (!T().b(106)) {
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showPickPoint allowOperableNotificationShow return false!");
                return;
            }
            return;
        }
        t();
        com.baidu.navisdk.model.datastruct.s a2 = com.baidu.navisdk.poisearch.model.b.m().a();
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showPickPoint --> poi is " + a2);
        }
        if (a2 == null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        String a3 = l0.a(a2.h, sb2);
        if (!TextUtils.isEmpty(a2.y)) {
            sb = a2.y;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("距您");
            sb3.append((Object) sb2);
            sb3.append(a3);
            if (a2.u != null) {
                str = " " + a2.u;
            } else {
                str = "";
            }
            sb3.append(str);
            sb = sb3.toString();
        }
        if (TextUtils.isEmpty(a2.y)) {
            i2 = R.color.nsdk_rg_operable_notification_subtitle;
        } else if (a2.x == 1) {
            i2 = R.color.nsdk_rg_operable_notification_subtitle_shop_time_yellow;
        } else {
            i2 = R.color.nsdk_rg_operable_notification_subtitle_shop_time_red;
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().k(106).D(100).v(30000).b(sb).E(i2).g(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_route_search_add_via)).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_faster_route_btn_cancle)).a(new g()).a(new f(this)).d(com.baidu.navisdk.ui.util.b.f(BNRouteNearbySearchUtils.getPoiViaPointNotificationIcon(com.baidu.navisdk.poisearch.model.a.k().c(), a2.s))).a(a2.e).h(a2.t).y();
    }

    public void I() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showRPPrefer - RGSimpleGuideModel.mIsRPPrefer : " + com.baidu.navisdk.ui.routeguide.model.a0.C + ", getRPPreferTipsText() : " + V());
        }
        if (!com.baidu.navisdk.ui.routeguide.model.a0.C) {
            return;
        }
        String V = V();
        if (TextUtils.isEmpty(V)) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().j(106).z(100).b(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_success)).f(V).y();
    }

    public void J() {
        if (!T().b(109)) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showRemoveViaNode allowOperableNotificationShow return false!");
                return;
            }
            return;
        }
        GeoPoint e2 = com.baidu.navisdk.poisearch.model.b.m().e();
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGNotificationController", "showRemoveViaNode: geoPoint --> " + e2);
        }
        if (e2 == null) {
            if (gVar2.d()) {
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "不存在该途经点");
                gVar2.e("RGNotificationController", "showRemoveViaNode: Error --> Via Node Does Not Exist");
            }
            com.baidu.navisdk.poisearch.model.b.m().e(false);
            return;
        }
        com.baidu.navisdk.module.nearbysearch.model.b bVar = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE;
        com.baidu.navisdk.module.nearbysearch.model.a b2 = bVar.b(e2);
        if (b2 == null) {
            if (gVar2.d()) {
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "不存在该途经点");
                gVar2.e("RGNotificationController", "showRemoveViaNode: Error --> Via Node Does Not Exist");
            }
            com.baidu.navisdk.poisearch.model.b.m().e(false);
            return;
        }
        if (gVar2.d()) {
            com.baidu.navisdk.module.nearbysearch.model.a a2 = bVar.a(b2.mName, b2.mGeoPoint);
            Context a3 = com.baidu.navisdk.framework.a.c().a();
            if (a2 != null) {
                TipTool.onCreateToastDialog(a3, "搜索一级类别是：" + a2.b() + ", 二级类别是：" + a2.a());
            } else {
                TipTool.onCreateToastDialog(a3, "获取到途经点为空，node.mName = " + b2.mName + ", node.mGeoPoint = " + b2.mGeoPoint);
            }
        }
        p();
        com.baidu.navisdk.ui.routeguide.control.x.b().k(109).D(100).v(-1).a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_route_search_remove_via)).b(b2.getName()).g(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_route_search_remove_via_confirm)).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_faster_route_btn_cancle)).a(new m(this, e2)).a(new l(this)).d(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_via_point_delect)).y();
    }

    public void K() {
        if (!T().b(124)) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showRoadCondNotRefreshWarningNotification return !");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGNotificationController", "isIndoorParkState return !");
                return;
            }
            return;
        }
        if (!Y()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGNotificationController", "showRoadCondNotRefreshWarningNotification,not online mode, return !");
                return;
            }
            return;
        }
        p();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.2.1", "1", null, null);
        if (BNSettingManager.isShowRemindDialog()) {
            com.baidu.navisdk.ui.routeguide.control.x.b().k(124).d(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_fail)).D(100).a(JarUtils.getResources().getString(R.string.nsdk_road_cond_refresh_warning)).v(10000).g(JarUtils.getResources().getString(R.string.nsdk_road_cond_refresh_warning_confirm)).a(new y(this)).y();
        }
    }

    public void L() {
        String obj;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showRouteAroundElement");
        }
        if (!T().b(113)) {
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showRouteAroundElement allowOperableNotificationShow return false!");
                return;
            }
            return;
        }
        w();
        com.baidu.navisdk.model.datastruct.n f2 = com.baidu.navisdk.poisearch.model.b.m().f();
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("showRouteAroundElement --> poi is ");
            if (f2 == null) {
                obj = "null";
            } else {
                obj = f2.toString();
            }
            sb.append(obj);
            gVar.e("RGNotificationController", sb.toString());
        }
        if (f2 == null) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().k(113).D(100).v(30000).g(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_route_search_add_via)).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_faster_route_btn_cancle)).a(new e(this, f2)).a(new d(this)).d(com.baidu.navisdk.ui.util.b.f(BNRouteNearbySearchUtils.getRouteAroundIconByStyleId(f2.c))).a(f2.f6936a).y();
    }

    public boolean M() {
        if (!e(false)) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showRouteRecommendAsr false return");
            }
            return false;
        }
        String o2 = com.baidu.navisdk.ui.routeguide.model.x.A().o();
        if (TextUtils.isEmpty(o2)) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGNotificationController", "showRouteRecommendAsr voiceTips is null");
            }
            return false;
        }
        int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
        if ((2 == voiceMode || 3 == voiceMode) && !com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGNotificationController", "showRouteRecommendAsr isPlayVoice false");
            }
            return false;
        }
        TTSPlayerControl.stopVoiceTTSOutput();
        if (!com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
            TTSPlayerControl.playFastRouteVoice();
        }
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        if (com.baidu.navisdk.asr.query.a.a(a2).b("fast_route")) {
            com.baidu.navisdk.asr.query.a.a(a2).a("fast_route");
            com.baidu.navisdk.ui.routeguide.model.x.A().f8982a = true;
            com.baidu.navisdk.ui.routeguide.asr.c.n().a(o2, com.baidu.navisdk.ui.routeguide.model.x.A().r);
        } else {
            int g2 = com.baidu.navisdk.ui.routeguide.model.x.A().g();
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("RGNotificationController", "CarLimitVoice-, showRouteRecommendAsr(), voiceTips=" + o2 + ", voiceTipType=" + g2);
            }
            if (g2 == 1) {
                TTSPlayerControl.playXDTTSTextForResult(o2, 1, TTSPlayerControl.CAR_LIMIT_VOICE_TAG);
            } else {
                TTSPlayerControl.playXDTTSText(o2, 1);
            }
        }
        return true;
    }

    public void N() {
        if (!T().b(125)) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showSessionRecoveryNotification return false!");
                return;
            }
            return;
        }
        p();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.2.2", "1", null, null);
        com.baidu.navisdk.ui.routeguide.control.x.b().k(125).d(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_fail)).D(100).a(JarUtils.getResources().getString(R.string.nsdk_road_cond_can_refresh_warning)).g(JarUtils.getResources().getString(R.string.nsdk_road_cond_can_refresh_confirm)).f(JarUtils.getResources().getString(R.string.nsdk_road_cond_can_refresh_cancel)).v(-1).a(new x(this)).y();
    }

    public void O() {
        com.baidu.navisdk.ui.routeguide.control.x.b().j(107).z(100).b(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_fail)).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_rp_build_fail)).y();
    }

    public void P() {
        com.baidu.navisdk.ui.routeguide.control.x.b().j(108).z(100).b(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_success)).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_rp_build_success)).y();
    }

    public void Q() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showUgcOfficialEvent");
        }
        if (!com.baidu.navisdk.ui.routeguide.model.a0.E) {
            return;
        }
        String GetRoadEventText = JNIGuidanceControl.getInstance().GetRoadEventText();
        if (TextUtils.isEmpty(GetRoadEventText)) {
            if (gVar.d()) {
                gVar.e("RGNotificationController", "title is null or empty");
                return;
            }
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().j(109).z(100).v(10000).b(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_ugc_official_event)).f(GetRoadEventText).a(new a0(this)).y();
    }

    public void R() {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.f> arrayList = this.b;
        if (arrayList != null && this.f8584a != null && this.d != null && this.c != null) {
            if (!arrayList.isEmpty()) {
                Iterator<com.baidu.navisdk.ui.routeguide.model.f> it = this.b.iterator();
                while (it.hasNext()) {
                    com.baidu.navisdk.ui.routeguide.model.f next = it.next();
                    if (next != null) {
                        next.c();
                    }
                    it.remove();
                }
            }
            if (!this.d.isEmpty()) {
                Iterator<com.baidu.navisdk.ui.routeguide.model.u> it2 = this.d.iterator();
                while (it2.hasNext()) {
                    com.baidu.navisdk.ui.routeguide.model.u next2 = it2.next();
                    if (next2 != null) {
                        next2.a();
                    }
                    it2.remove();
                }
            }
        }
    }

    public void S() {
    }

    public void f(int i2) {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.e> arrayList = this.f;
        if (arrayList == null) {
            return;
        }
        Iterator<com.baidu.navisdk.ui.routeguide.model.e> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.ui.routeguide.model.e next = it.next();
            if (next != null && next.h() == i2 && next.j() != null) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGNotificationController", "hideRepeatedCheckboxView type:" + i2);
                }
                next.j().s0();
                next.m();
                it.remove();
            }
        }
    }

    public void g(int i2) {
        try {
            ArrayList<com.baidu.navisdk.ui.routeguide.model.f> arrayList = this.b;
            if (arrayList == null) {
                return;
            }
            Iterator<com.baidu.navisdk.ui.routeguide.model.f> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.ui.routeguide.model.f next = it.next();
                if (next != null && next.r == i2 && next.f8941a != null) {
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("RGNotificationController", "hideRepeatedCommonView type:" + i2);
                    }
                    next.f8941a.q0();
                    next.c();
                    it.remove();
                }
            }
        } catch (Exception e2) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGNotificationController", e2.toString());
            }
            LogUtil.printCallStack();
        }
    }

    public void h(int i2) {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.u> arrayList = this.d;
        if (arrayList == null) {
            return;
        }
        Iterator<com.baidu.navisdk.ui.routeguide.model.u> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.ui.routeguide.model.u next = it.next();
            if (next != null && next.B == i2 && next.f8977a != null) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGNotificationController", "hideRepeatedOperableView type:" + i2);
                }
                next.f8977a.t0();
                next.a();
                it.remove();
            }
        }
    }

    public ArrayList<i0> i() {
        return this.c;
    }

    public boolean j(int i2) {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.e> arrayList = this.f;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                com.baidu.navisdk.ui.routeguide.model.e eVar = this.f.get(i3);
                if (eVar != null && eVar.h() == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean k(int i2) {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.u> arrayList = this.d;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i3 = 0; i3 < this.d.size(); i3++) {
                com.baidu.navisdk.ui.routeguide.model.u uVar = this.d.get(i3);
                if (uVar != null && uVar.B == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean l(int i2) {
        i0 i0Var;
        ArrayList<com.baidu.navisdk.ui.routeguide.model.u> arrayList = this.d;
        boolean z2 = false;
        if (arrayList == null) {
            return false;
        }
        Iterator<com.baidu.navisdk.ui.routeguide.model.u> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.navisdk.ui.routeguide.model.u next = it.next();
            if (next != null && next.B == i2 && (i0Var = next.f8977a) != null) {
                z2 = i0Var.a();
                break;
            }
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "isOperableViewShowing type:" + i2 + ", isShowing:" + z2);
        }
        return z2;
    }

    public void m() {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.e> arrayList = this.f;
        if (arrayList == null) {
            return;
        }
        Iterator<com.baidu.navisdk.ui.routeguide.model.e> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.ui.routeguide.model.e next = it.next();
            if (next != null && next.j() != null && next.j().l != null) {
                if (next.j().l.hasEnded()) {
                    next.j().s0();
                } else {
                    next.j().o0();
                }
                next.m();
                it.remove();
            }
        }
    }

    public void n() {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.e> arrayList = this.f;
        if (arrayList == null) {
            return;
        }
        Iterator<com.baidu.navisdk.ui.routeguide.model.e> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.ui.routeguide.model.e next = it.next();
            if (next != null && next.j() != null && next.j().l != null && !next.k()) {
                if (next.j().l.hasEnded()) {
                    next.j().s0();
                } else {
                    next.j().o0();
                }
                next.m();
                it.remove();
            }
        }
    }

    public void o() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.m mVar;
        Animation animation;
        ArrayList<com.baidu.navisdk.ui.routeguide.model.f> arrayList = this.b;
        if (arrayList == null) {
            return;
        }
        Iterator<com.baidu.navisdk.ui.routeguide.model.f> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.ui.routeguide.model.f next = it.next();
            if (next != null && (mVar = next.f8941a) != null && (animation = mVar.l) != null) {
                if (animation.hasEnded()) {
                    next.f8941a.q0();
                } else {
                    next.f8941a.o0();
                }
                next.c();
                it.remove();
            }
        }
    }

    public void p() {
        i0 i0Var;
        Animation animation;
        ArrayList<com.baidu.navisdk.ui.routeguide.model.u> arrayList = this.d;
        if (arrayList == null) {
            return;
        }
        Iterator<com.baidu.navisdk.ui.routeguide.model.u> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.ui.routeguide.model.u next = it.next();
            if (next != null && (i0Var = next.f8977a) != null && (animation = i0Var.l) != null) {
                if (animation.hasEnded()) {
                    next.f8977a.t0();
                } else {
                    next.f8977a.o0();
                }
                next.a();
                it.remove();
            }
        }
    }

    public void t() {
        e(106);
        e(111);
    }

    public boolean y() {
        Iterator<com.baidu.navisdk.ui.routeguide.model.f> it = c().iterator();
        while (it.hasNext()) {
            if (it.next().v == 1) {
                return true;
            }
        }
        return W();
    }

    public boolean z() {
        int i2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "isShowAddPlateYB: ");
        }
        if (!TextUtils.isEmpty(com.baidu.navisdk.h.a())) {
            return true;
        }
        com.baidu.navisdk.module.pronavi.model.f n2 = com.baidu.navisdk.ui.routeguide.b.V().n();
        if (n2 != null) {
            i2 = n2.f();
        } else {
            i2 = 0;
        }
        if (i2 != 1) {
            return true;
        }
        return false;
    }

    /* loaded from: classes8.dex */
    public class r implements com.baidu.navisdk.util.navimageloader.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8595a;
        final /* synthetic */ com.baidu.navisdk.ui.routeguide.mapmode.subview.m b;

        public r(int i, com.baidu.navisdk.ui.routeguide.mapmode.subview.m mVar) {
            this.f8595a = i;
            this.b = mVar;
        }

        @Override // com.baidu.navisdk.util.navimageloader.e
        public void a(String str, View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "onLoadingStarted(), imageUri=" + str);
            }
        }

        @Override // com.baidu.navisdk.util.navimageloader.e
        public void a(String str, View view, Bitmap bitmap, int i) {
            Drawable o = s.this.o(this.f8595a);
            if (TextUtils.isEmpty(str) && o != null) {
                this.b.b(o);
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "onLoadingComplete(), imageUri=" + str + ", from=" + i + ", drawableIcon=" + o);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements com.baidu.navisdk.util.navimageloader.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.yellowtipdata.model.data.c f8597a;
        final /* synthetic */ com.baidu.navisdk.ui.routeguide.mapmode.subview.m b;

        public t(com.baidu.navisdk.yellowtipdata.model.data.c cVar, com.baidu.navisdk.ui.routeguide.mapmode.subview.m mVar) {
            this.f8597a = cVar;
            this.b = mVar;
        }

        @Override // com.baidu.navisdk.util.navimageloader.e
        public void a(String str, View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "onLoadingStarted(), imageUri=" + str);
            }
        }

        @Override // com.baidu.navisdk.util.navimageloader.e
        public void a(String str, View view, Bitmap bitmap, int i) {
            Drawable o = s.this.o(this.f8597a.g());
            if (TextUtils.isEmpty(str) && o != null) {
                this.b.b(o);
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "onLoadingComplete(), imageUri=" + str + ", from=" + i + ", drawableIcon=" + o);
            }
        }
    }

    public void c(com.baidu.navisdk.ui.routeguide.mapmode.subview.m mVar) {
        ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.m> arrayList = this.f8584a;
        if (arrayList == null || mVar == null || !arrayList.contains(mVar)) {
            return;
        }
        Iterator<com.baidu.navisdk.ui.routeguide.mapmode.subview.m> it = this.f8584a.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.ui.routeguide.mapmode.subview.m next = it.next();
            if (next != null && next.equals(mVar)) {
                it.remove();
                return;
            }
        }
    }

    public void d(com.baidu.navisdk.ui.routeguide.model.f fVar) {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.f> arrayList = this.b;
        if (arrayList == null || fVar == null) {
            return;
        }
        if (!arrayList.contains(fVar)) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "removeCommonModel failed: " + fVar + "," + this.b);
                return;
            }
            return;
        }
        Iterator<com.baidu.navisdk.ui.routeguide.model.f> it = this.b.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.ui.routeguide.model.f next = it.next();
            if (next != null && next.equals(fVar)) {
                next.c();
                it.remove();
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
    
        if (r0.a() != false) goto L11;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.baidu.navisdk.ui.routeguide.mapmode.subview.g0 e() {
        /*
            r3 = this;
            java.util.ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.l> r0 = r3.e
            r1 = 0
            if (r0 == 0) goto L21
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L21
            java.util.ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.l> r0 = r3.e
            int r2 = r0.size()
            int r2 = r2 + (-1)
            java.lang.Object r0 = r0.get(r2)
            com.baidu.navisdk.ui.routeguide.mapmode.subview.g0 r0 = (com.baidu.navisdk.ui.routeguide.mapmode.subview.g0) r0
            if (r0 == 0) goto L21
            boolean r2 = r0.a()
            if (r2 != 0) goto L22
        L21:
            r0 = r1
        L22:
            java.util.ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.i0> r2 = r3.c
            if (r2 == 0) goto L43
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L43
            java.util.ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.i0> r0 = r3.c
            int r2 = r0.size()
            int r2 = r2 + (-1)
            java.lang.Object r0 = r0.get(r2)
            com.baidu.navisdk.ui.routeguide.mapmode.subview.g0 r0 = (com.baidu.navisdk.ui.routeguide.mapmode.subview.g0) r0
            if (r0 == 0) goto L42
            boolean r2 = r0.a()
            if (r2 != 0) goto L43
        L42:
            r0 = r1
        L43:
            java.util.ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.m> r2 = r3.f8584a
            if (r2 == 0) goto L64
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L64
            java.util.ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.m> r0 = r3.f8584a
            int r2 = r0.size()
            int r2 = r2 + (-1)
            java.lang.Object r0 = r0.get(r2)
            com.baidu.navisdk.ui.routeguide.mapmode.subview.g0 r0 = (com.baidu.navisdk.ui.routeguide.mapmode.subview.g0) r0
            if (r0 == 0) goto L65
            boolean r2 = r0.a()
            if (r2 != 0) goto L64
            goto L65
        L64:
            r1 = r0
        L65:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.control.s.e():com.baidu.navisdk.ui.routeguide.mapmode.subview.g0");
    }

    public boolean i(int i2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.m mVar;
        ArrayList<com.baidu.navisdk.ui.routeguide.model.f> arrayList = this.b;
        boolean z2 = false;
        if (arrayList == null) {
            return false;
        }
        Iterator<com.baidu.navisdk.ui.routeguide.model.f> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.navisdk.ui.routeguide.model.f next = it.next();
            if (next != null && next.r == i2 && (mVar = next.f8941a) != null) {
                z2 = mVar.a();
                break;
            }
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "isCommonViewShowing type:" + i2 + ", isShowing:" + z2);
        }
        return z2;
    }

    public void q() {
        e(132);
    }

    public void r() {
        e(134);
    }

    public void s() {
        if (T().l(131)) {
            T().e(131);
        }
    }

    public void x() {
        if (T().l(125)) {
            T().e(125);
        }
    }

    private Drawable t(int i2) {
        if (i2 == 39) {
            return com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_ic_dest_arrive_reminder);
        }
        return com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_yellow_banner_gaosuyouxian_yellow);
    }

    public ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.l> b() {
        return this.e;
    }

    public void a(com.baidu.navisdk.ui.routeguide.model.f fVar) {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.f> arrayList = this.b;
        if (arrayList == null || fVar == null || arrayList.contains(fVar)) {
            return;
        }
        this.b.add(fVar);
    }

    public void b(com.baidu.navisdk.ui.routeguide.mapmode.subview.m mVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "hideCommonViewByHandler");
        }
        mVar.r0();
        mVar.c();
    }

    public boolean j() {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.e> arrayList = this.f;
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }

    public boolean k() {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.f> arrayList = this.b;
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }

    public void a(com.baidu.navisdk.ui.routeguide.model.u uVar) {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.u> arrayList = this.d;
        if (arrayList == null || uVar == null || arrayList.contains(uVar)) {
            return;
        }
        this.d.add(uVar);
    }

    public void b(i0 i0Var) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "hideOperableViewByHandler");
        }
        i0Var.c();
        i0Var.q0();
    }

    public boolean c(com.baidu.navisdk.ui.routeguide.model.f fVar) {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.f> arrayList = this.b;
        if (arrayList == null || arrayList.isEmpty() || fVar == null) {
            return false;
        }
        return this.b.contains(fVar);
    }

    public void a(com.baidu.navisdk.ui.routeguide.model.e eVar) {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.e> arrayList = this.f;
        if (arrayList == null || eVar == null || arrayList.contains(eVar)) {
            return;
        }
        this.f.add(eVar);
    }

    public boolean l() {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.u> arrayList = this.d;
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }

    public void v() {
        if (T().l(124)) {
            T().e(124);
        }
    }

    private boolean e(boolean z2) {
        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().i() && !z2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("XDVoice", "XDPlan have been shown , can't showRouteRecommend");
            }
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().z()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGNotificationController", "showRouteRecommend: --> isBackgroundNavi");
            }
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().L2()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGNotificationController", "showRouteRecommend: --> isUgcReportVisible");
            }
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().S1()) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("RGNotificationController", "showRouteRecommend: --> isBNRCEventDetailsMenuVisible");
            }
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().T()) {
            com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar5.d()) {
                gVar5.e("RGNotificationController", "showRouteRecommend: --> hud is showing");
            }
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.model.x.A().u()) {
            return true;
        }
        com.baidu.navisdk.util.common.g gVar6 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar6.d()) {
            gVar6.e("RGNotificationController", "showRouteRecommend: --> params error");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable o(int i2) {
        String str;
        int[] a2 = com.baidu.navisdk.yellowbannerui.controller.a.c().a();
        Drawable f2 = (a2 == null || i2 < 0 || i2 >= a2.length) ? null : com.baidu.navisdk.ui.util.b.f(a2[i2]);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("getNotificationYBarIcon(), iconId=");
            sb.append(i2);
            sb.append("， drawable=");
            sb.append(f2);
            sb.append("drawableIds.length=");
            if (a2 == null) {
                str = "0";
            } else {
                str = a2.length + "";
            }
            sb.append(str);
            gVar.e("RGNotificationController", sb.toString());
        }
        return f2;
    }

    private String p(int i2) {
        String str;
        String[] a2 = com.baidu.navisdk.yellowtipdata.model.a.c().a();
        String str2 = (a2 == null || i2 < 0 || i2 >= a2.length) ? null : a2[i2];
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("getNotificationYBarIcon(), iconId=");
            sb.append(i2);
            sb.append("， iconUrl=");
            sb.append(str2);
            sb.append("iconUrls.length=");
            if (a2 == null) {
                str = "0";
            } else {
                str = a2.length + "";
            }
            sb.append(str);
            gVar.e("RGNotificationController", sb.toString());
        }
        return str2;
    }

    public boolean c(com.baidu.navisdk.ui.routeguide.model.u uVar) {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.u> arrayList = this.d;
        if (arrayList == null || arrayList.isEmpty() || uVar == null) {
            return false;
        }
        return this.d.contains(uVar);
    }

    public ArrayList<com.baidu.navisdk.ui.routeguide.model.u> h() {
        return this.d;
    }

    public void b(com.baidu.navisdk.ui.routeguide.mapmode.subview.l lVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "hideCheckboxViewByHandler");
        }
        lVar.q0();
        lVar.c();
    }

    public void d(com.baidu.navisdk.ui.routeguide.model.u uVar) {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.u> arrayList = this.d;
        if (arrayList == null || uVar == null || !arrayList.contains(uVar)) {
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "removeOperableModel mNotificationType:" + uVar.B);
        }
        Iterator<com.baidu.navisdk.ui.routeguide.model.u> it = this.d.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.ui.routeguide.model.u next = it.next();
            if (next != null && next.equals(uVar)) {
                next.a();
                it.remove();
                return;
            }
        }
    }

    public int f() {
        Bundle bundle = new Bundle();
        if (JNIGuidanceControl.getInstance().GetLocalRouteInfo(bundle) && !TextUtils.isEmpty(Html.fromHtml(bundle.getString("info")).toString())) {
            return bundle.getInt("type");
        }
        return -1;
    }

    public void m(int i2) {
        com.baidu.navisdk.ui.routeguide.control.x.b().j(115).z(100).b(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_power_saver_icon)).f(i2 != 0 ? i2 != 1 ? i2 != 2 ? "" : "系统暂不支持省电模式" : "已关闭智能省电模式" : "已开启智能省电模式").y();
    }

    public void u() {
        e(109);
    }

    public void w() {
        e(113);
    }

    public void a(com.baidu.navisdk.ui.routeguide.mapmode.subview.m mVar) {
        ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.m> arrayList = this.f8584a;
        if (arrayList == null || mVar == null || arrayList.contains(mVar)) {
            return;
        }
        this.f8584a.add(mVar);
    }

    public boolean c(com.baidu.navisdk.ui.routeguide.model.e eVar) {
        ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.l> arrayList = this.e;
        if (arrayList == null || arrayList.isEmpty() || eVar == null) {
            return false;
        }
        return this.e.contains(eVar);
    }

    public void n(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showWaitRPResult");
        }
        if (!T().b(101)) {
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showWaitRPResult allowOperableNotificationShow return false!");
                return;
            }
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().k(101).D(100).v(-1).d(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_fail)).a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_operable_notification_wait_route_plan_result_main_title)).b(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_operable_notification_wait_route_plan_result_sub_title)).g(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_operable_notification_wait_route_plan_result_confirm)).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_operable_notification_wait_route_plan_result_cancel)).a(new b0(this)).y();
    }

    public com.baidu.navisdk.framework.interfaces.y g() {
        return new w();
    }

    public void c(i0 i0Var) {
        ArrayList<i0> arrayList = this.c;
        if (arrayList == null || i0Var == null || !arrayList.contains(i0Var)) {
            return;
        }
        Iterator<i0> it = this.c.iterator();
        while (it.hasNext()) {
            i0 next = it.next();
            if (next != null && next.equals(i0Var)) {
                it.remove();
                return;
            }
        }
    }

    public void a(i0 i0Var) {
        ArrayList<i0> arrayList = this.c;
        if (arrayList == null || i0Var == null || arrayList.contains(i0Var)) {
            return;
        }
        this.c.add(i0Var);
    }

    public void b(com.baidu.navisdk.ui.routeguide.model.f fVar) {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.f> arrayList = this.b;
        if (arrayList != null && fVar != null) {
            if (!arrayList.contains(fVar)) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGNotificationController", "mode is not in the list");
                    return;
                }
                return;
            }
            Iterator<com.baidu.navisdk.ui.routeguide.model.f> it = this.b.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.ui.routeguide.model.f next = it.next();
                if (next != null && !next.equals(fVar)) {
                    com.baidu.navisdk.ui.routeguide.mapmode.subview.m mVar = next.f8941a;
                    if (mVar != null) {
                        mVar.o0();
                        next.c();
                        it.remove();
                    }
                } else if (next != null && next.equals(fVar)) {
                    return;
                }
            }
            return;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGNotificationController", "mCommonModelList = " + this.b + ", model = " + fVar);
        }
    }

    public void a(com.baidu.navisdk.ui.routeguide.mapmode.subview.l lVar) {
        ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.l> arrayList = this.e;
        if (arrayList == null || lVar == null || arrayList.contains(lVar)) {
            return;
        }
        this.e.add(lVar);
    }

    public void a() {
        ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.m> arrayList = this.f8584a;
        if (arrayList == null || this.c == null || this.e == null) {
            return;
        }
        if (!arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(this.f8584a);
            this.f8584a.clear();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((com.baidu.navisdk.ui.routeguide.mapmode.subview.m) it.next()).i();
            }
            arrayList2.clear();
        }
        if (!this.c.isEmpty()) {
            ArrayList arrayList3 = new ArrayList(this.c);
            this.c.clear();
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                ((i0) it2.next()).i();
            }
            arrayList3.clear();
        }
        this.b.clear();
        this.d.clear();
        this.f.clear();
        ViewGroup s0 = com.baidu.navisdk.ui.routeguide.control.x.b().s0();
        if (s0 != null) {
            ViewGroup b2 = com.baidu.navisdk.ui.routeguide.control.x.b().b(R.id.bnav_rg_notification_panel);
            ViewGroup b3 = com.baidu.navisdk.ui.routeguide.control.x.b().b(R.id.bnav_rg_notification_container);
            if (b3 != null) {
                s0.removeView(b3);
                b3.setVisibility(8);
            }
            if (b2 != null) {
                s0.removeView(b2);
                b2.setVisibility(8);
            }
        }
    }

    public void c(com.baidu.navisdk.ui.routeguide.mapmode.subview.l lVar) {
        ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.l> arrayList = this.e;
        if (arrayList == null || lVar == null || !arrayList.contains(lVar)) {
            return;
        }
        Iterator<com.baidu.navisdk.ui.routeguide.mapmode.subview.l> it = this.e.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.ui.routeguide.mapmode.subview.l next = it.next();
            if (next != null && next.equals(lVar)) {
                it.remove();
                return;
            }
        }
    }

    public void d(com.baidu.navisdk.ui.routeguide.model.e eVar) {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.e> arrayList = this.f;
        if (arrayList == null || eVar == null || !arrayList.contains(eVar)) {
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "removeCheckboxModel mNotificationType:" + eVar.h());
        }
        Iterator<com.baidu.navisdk.ui.routeguide.model.e> it = this.f.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.ui.routeguide.model.e next = it.next();
            if (next != null && next.equals(eVar)) {
                next.m();
                it.remove();
                return;
            }
        }
    }

    public ArrayList<com.baidu.navisdk.ui.routeguide.model.f> c() {
        return this.b;
    }

    public boolean c(boolean z2) {
        String o2;
        if (!e(z2)) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showRouteRecommend false return");
            }
            return false;
        }
        if (!BNSettingManager.isMultiRouteEnable()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGNotificationController", "sdk单路线 不展示更快路线");
            }
            return false;
        }
        com.baidu.navisdk.ui.routeguide.model.x.A().f8982a = true;
        if (!T().Z()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGNotificationController", "showRouteRecommend show notification fail");
            }
            com.baidu.navisdk.ui.routeguide.model.x.A().f8982a = false;
            return false;
        }
        com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar4.d()) {
            gVar4.e("RGNotificationController", "showRouteRecommend: mVoiceBroadType --> " + com.baidu.navisdk.ui.routeguide.model.x.A().n());
        }
        if (com.baidu.navisdk.ui.routeguide.model.x.A().n() == 1 && (o2 = com.baidu.navisdk.ui.routeguide.model.x.A().o()) != null) {
            TTSPlayerControl.stopVoiceTTSOutput();
            if (!com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
                TTSPlayerControl.playFastRouteVoice();
            }
            if (!com.baidu.navisdk.ui.routeguide.model.x.A().f8982a) {
                return false;
            }
            int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
            boolean z3 = !(2 == voiceMode || 3 == voiceMode) || com.baidu.navisdk.ui.routeguide.model.x.A().x();
            if (gVar4.d()) {
                gVar4.e("RGNotificationController", "showRouteRecommend --> isUseTTSPlay = " + com.baidu.navisdk.ui.routeguide.model.x.A().b);
            }
            if (z3) {
                Context a2 = com.baidu.navisdk.framework.a.c().a();
                if (!com.baidu.navisdk.ui.routeguide.model.x.A().q() && (!com.baidu.navisdk.asr.query.a.a(a2).b("fast_route") || com.baidu.navisdk.ui.routeguide.model.x.A().b)) {
                    int g2 = com.baidu.navisdk.ui.routeguide.model.x.A().g();
                    com.baidu.navisdk.ui.routeguide.model.x.A().b = false;
                    if (gVar4.d()) {
                        gVar4.e("RGNotificationController", "CarLimitVoice-, showRouteRecommend(), voiceTips=" + o2 + ", voiceTipType=" + g2);
                    }
                    if (g2 == 1) {
                        TTSPlayerControl.playXDTTSTextForResult(o2, 1, TTSPlayerControl.CAR_LIMIT_VOICE_TAG);
                    } else {
                        TTSPlayerControl.playXDTTSText(o2, 1);
                    }
                } else {
                    com.baidu.navisdk.asr.query.a.a(a2).a("fast_route");
                    com.baidu.navisdk.ui.routeguide.asr.c.n().a(o2, com.baidu.navisdk.ui.routeguide.model.x.A().r);
                }
            }
        }
        if (RGFSMTable.FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getTopState())) {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BROWSER_STATE_EXIT);
        }
        if (com.baidu.navisdk.ui.routeguide.model.x.A().m() != 7 && com.baidu.navisdk.ui.routeguide.model.x.A().m() != 13) {
            if (com.baidu.navisdk.ui.routeguide.model.x.A().m() == 3) {
                com.baidu.navisdk.ui.routeguide.b.V().r().c(false);
            }
        } else {
            if (!((com.baidu.navisdk.ui.routeguide.model.x.A().r == 11 || com.baidu.navisdk.ui.routeguide.model.x.A().r == 12) ? BNMapController.getInstance().setMapFuncInfoFastRoute(true, com.baidu.navisdk.ui.routeguide.model.x.A().k(), com.baidu.navisdk.ui.routeguide.model.x.A().f, com.baidu.navisdk.ui.routeguide.model.x.A().g) : false)) {
                com.baidu.navisdk.ui.routeguide.b.V().r().c(false);
            }
            BNMapController.getInstance().setHighLightAvoidTrafficRoute(com.baidu.navisdk.ui.routeguide.model.x.A().k());
        }
        if (gVar4.d()) {
            gVar4.e("RGNotificationController", "showRouteRecommend subType: " + com.baidu.navisdk.ui.routeguide.model.x.A().m());
        }
        return true;
    }

    public void e(String str) {
        com.baidu.navisdk.ui.routeguide.control.x.b().j(110).x(R.color.nsdk_rg_common_notification_middle_priority_main_text).w(130).v(3000).y(R.drawable.nsdk_ugc_verify_result_bg).y(true).C(40).f(str).y();
    }

    public boolean b(int i2) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        if (i2 == 112) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "force allowOperableNotificationShow ok");
            }
            return true;
        }
        if (i2 != 114 && i2 != 116 && X()) {
            if (i2 == 119) {
                if (W()) {
                    com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar2.d()) {
                        gVar2.e("RGNotificationController", "allowOperableNotificationShow AvoidPoorDestShowing false");
                    }
                    return false;
                }
                com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar3.d()) {
                    gVar3.e("RGNotificationController", "allowOperableNotificationShow ,TYPE_BROADCAST_DIY_GUIDE 可能将显示");
                }
            } else {
                com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar4.d()) {
                    gVar4.e("RGNotificationController", "allowOperableNotificationShow isNotificationYBarShowing ,return false");
                }
                return false;
            }
        }
        ViewGroup b02 = com.baidu.navisdk.ui.routeguide.control.x.b().b0();
        boolean isBrowseState = RouteGuideFSM.getInstance().isBrowseState();
        boolean z22 = com.baidu.navisdk.ui.routeguide.control.x.b().z2();
        boolean z10 = b02 != null && b02.getVisibility() == 0;
        boolean T1 = com.baidu.navisdk.ui.routeguide.control.x.b().T1();
        boolean q2 = com.baidu.navisdk.ui.routeguide.control.x.b().q2();
        boolean v2 = com.baidu.navisdk.ui.routeguide.control.x.b().v2();
        boolean J2 = com.baidu.navisdk.ui.routeguide.control.x.b().J2();
        boolean X1 = com.baidu.navisdk.ui.routeguide.control.x.b().X1();
        boolean k2 = com.baidu.navisdk.ui.routeguide.model.i.s().k();
        boolean T = com.baidu.navisdk.ui.routeguide.mapmode.a.o5().T();
        boolean w2 = com.baidu.navisdk.ui.routeguide.mapmode.a.o5().w2();
        boolean I2 = com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I2();
        boolean a2 = com.baidu.navisdk.ugc.d.a();
        boolean j2 = T().j();
        boolean i22 = com.baidu.navisdk.ui.routeguide.control.x.b().i2();
        com.baidu.navisdk.pronavi.ui.base.b s = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s == null || !s.I()) {
            z2 = isBrowseState;
            z3 = false;
        } else {
            z2 = isBrowseState;
            z3 = true;
        }
        boolean z11 = s != null && s.L();
        boolean z12 = s != null && s.K();
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().f() && (i2 == 106 || i2 == 113 || i2 == 132 || i2 == 134 || i2 == 111 || i2 == 114)) {
            com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
            z4 = z3;
            if (gVar5.d()) {
                gVar5.e("RGNotificationController", "沿途检索，更改终点，instant刷新这三种状态不管是不是语音态都能弹出来");
            }
            z5 = false;
            z2 = false;
        } else {
            z4 = z3;
            z5 = k2;
        }
        if ((i2 == 107 || i2 == 108 || i2 == 102) && !T && !z22 && !T1 && !q2 && !z5 && !i22) {
            com.baidu.navisdk.util.common.g gVar6 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (!gVar6.d()) {
                return true;
            }
            gVar6.e("RGNotificationController", "allowOperableNotificationShow return true type = " + i2);
            return true;
        }
        if (i2 == 106 || i2 == 113 || i2 == 132 || i2 == 134 || i2 == 109 || i2 == 111 || i2 == 103 || i2 == 114) {
            com.baidu.navisdk.util.common.g gVar7 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar7.d()) {
                z6 = j2;
                gVar7.e("RGNotificationController", "allowOperableNotificationShow 修改isNavOperate值 type = " + i2);
            } else {
                z6 = j2;
            }
            z7 = false;
        } else {
            z6 = j2;
            z7 = z2;
        }
        if (i2 == 100 || i2 == 105 || i2 == 104 || i2 == 127 || i2 == 101) {
            com.baidu.navisdk.util.common.g gVar8 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar8.d()) {
                z8 = a2;
                gVar8.e("RGNotificationController", "allowOperableNotificationShow 修改isNavOperate值 type = " + i2);
            } else {
                z8 = a2;
            }
            z9 = false;
        } else {
            z9 = I2;
            z8 = a2;
        }
        if (!z7 && !z22 && !z10 && !T1 && !q2 && !v2 && !J2 && !X1 && !z5 && !T && !w2 && !z9 && !z8 && !z6 && !i22 && !z4 && !z11 && !z12) {
            return true;
        }
        com.baidu.navisdk.util.common.g gVar9 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (!gVar9.d()) {
            return false;
        }
        gVar9.e("RGNotificationController", "allowOperableNotificationShow return false !, isNavOperate = " + z7 + ", isSafetyVisible = " + z22 + ", isModuleVisible = " + z10 + ", isBlueToothUSBGuideVisible = " + T1 + ", isMenuMoreVisible = " + q2 + ", isRouteSearchVisible = " + v2 + ", isUGCPanelVisible = " + J2 + ", isCommomViewShow = " + X1 + ", isHUDStatus = " + T + ", isRouteSortViewVisible = " + w2 + ", isToolboxOpened = " + z9 + ", isUgcUserOperating = " + z8 + ", isAnyEnlargeRoadMapShowing = " + z5 + ", hasCheckboxNotification = " + z6 + ", isHighwaySubscribeViewShowing = " + i22 + ", isShowChargeList = " + z4);
        return false;
    }

    public ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.m> d() {
        return this.f8584a;
    }

    public void d(i0 i0Var) {
        if (i0Var != null) {
            i0Var.u0();
        }
    }

    public boolean d(boolean z2) {
        String o2;
        if (!e(z2)) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showSupplyDataNoRoute false return");
            }
            return false;
        }
        com.baidu.navisdk.ui.routeguide.model.x.A().f8982a = true;
        if (!T().Z()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGNotificationController", "showSupplyDataNoRoute show notification fail");
            }
            com.baidu.navisdk.ui.routeguide.model.x.A().f8982a = false;
        }
        com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar3.d()) {
            gVar3.e("RGNotificationController", "showRouteRecommend: mVoiceBroadType --> " + com.baidu.navisdk.ui.routeguide.model.x.A().n());
        }
        if (com.baidu.navisdk.ui.routeguide.model.x.A().n() == 1 && (o2 = com.baidu.navisdk.ui.routeguide.model.x.A().o()) != null) {
            TTSPlayerControl.stopVoiceTTSOutput();
            if (!com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
                TTSPlayerControl.playFastRouteVoice();
            }
            int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
            boolean z3 = !(2 == voiceMode || 3 == voiceMode) || com.baidu.navisdk.ui.routeguide.model.x.A().x();
            if (gVar3.d()) {
                gVar3.e("RGNotificationController", "showRouteRecommend --> isUseTTSPlay = " + com.baidu.navisdk.ui.routeguide.model.x.A().b);
            }
            if (z3) {
                Context a2 = com.baidu.navisdk.framework.a.c().a();
                if (com.baidu.navisdk.asr.query.a.a(a2).b("fast_route") && !com.baidu.navisdk.ui.routeguide.model.x.A().b) {
                    com.baidu.navisdk.asr.query.a.a(a2).a("fast_route");
                    com.baidu.navisdk.ui.routeguide.asr.c.n().a(o2, com.baidu.navisdk.ui.routeguide.model.x.A().r);
                } else {
                    int g2 = com.baidu.navisdk.ui.routeguide.model.x.A().g();
                    com.baidu.navisdk.ui.routeguide.model.x.A().b = false;
                    if (gVar3.d()) {
                        gVar3.e("RGNotificationController", "CarLimitVoice-, showRouteRecommend(), voiceTips=" + o2 + ", voiceTipType=" + g2);
                    }
                    if (g2 == 1) {
                        TTSPlayerControl.playXDTTSTextForResult(o2, 1, TTSPlayerControl.CAR_LIMIT_VOICE_TAG);
                    } else {
                        TTSPlayerControl.playXDTTSText(o2, 1);
                    }
                }
            }
        }
        if (RGFSMTable.FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getCurrentState())) {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BROWSER_STATE_EXIT);
        }
        if (gVar3.d()) {
            gVar3.e("RGNotificationController", "showRouteRecommend subType: " + com.baidu.navisdk.ui.routeguide.model.x.A().m());
        }
        return true;
    }

    public void e(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "hideOperableView type = " + i2);
        }
        w(i2);
        if (i2 == 103 || i2 == 107) {
            com.baidu.navisdk.ui.routeguide.control.x.b().I().a(0);
        }
    }

    public void a(boolean z2, boolean z3, boolean z4) {
        i0 i0Var;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.m mVar;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "hideAllView isCommonViewRecoverable = " + z2 + ", isOperableViewRecoverable = " + z3);
        }
        ArrayList<com.baidu.navisdk.ui.routeguide.model.f> arrayList = this.b;
        if (arrayList != null) {
            Iterator<com.baidu.navisdk.ui.routeguide.model.f> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.ui.routeguide.model.f next = it.next();
                if (next != null && (mVar = next.f8941a) != null) {
                    mVar.o0();
                    if (!z2) {
                        next.c();
                        it.remove();
                    }
                }
            }
        }
        ArrayList<com.baidu.navisdk.ui.routeguide.model.u> arrayList2 = this.d;
        if (arrayList2 != null) {
            Iterator<com.baidu.navisdk.ui.routeguide.model.u> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                com.baidu.navisdk.ui.routeguide.model.u next2 = it2.next();
                if (next2 != null && (i0Var = next2.f8977a) != null) {
                    i0Var.o0();
                    if (!z3) {
                        next2.f8977a.i();
                        next2.a();
                        it2.remove();
                    }
                }
            }
        }
        ArrayList<com.baidu.navisdk.ui.routeguide.model.e> arrayList3 = this.f;
        if (arrayList3 != null) {
            Iterator<com.baidu.navisdk.ui.routeguide.model.e> it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                com.baidu.navisdk.ui.routeguide.model.e next3 = it3.next();
                if (next3 != null && next3.j() != null) {
                    next3.j().o0();
                    if (!z4) {
                        next3.m();
                        try {
                            it3.remove();
                        } catch (Throwable th) {
                            if (com.baidu.navisdk.util.common.g.PRO_NAV.a()) {
                                com.baidu.navisdk.util.common.g.PRO_NAV.a("RGNotificationController", "mCheckboxModelList remove exception" + th);
                            }
                            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                            if (gVar2.b()) {
                                gVar2.f(th.getMessage());
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean b(boolean z2) {
        return a(z2, false);
    }

    public boolean b(String str, int i2) {
        return com.baidu.navisdk.ui.routeguide.control.x.b().j(120).z(300).b(com.baidu.navisdk.ui.util.b.f(i2)).f(str).y();
    }

    public void d(String str) {
        com.baidu.navisdk.ui.routeguide.control.x.b().j(110).z(200).y(R.drawable.nsdk_ugc_verify_result_bg).y(true).C(40).f("提交成功，感谢您的反馈").y();
    }

    public boolean b(com.baidu.navisdk.ui.routeguide.model.u uVar) {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.u> arrayList = this.d;
        if (arrayList != null && uVar != null) {
            Iterator<com.baidu.navisdk.ui.routeguide.model.u> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.ui.routeguide.model.u next = it.next();
                if (next != null && !next.equals(uVar) && next.C) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean a(int i2) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        if (i2 == 117) {
            return true;
        }
        if (i2 != 114 && X()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "allowCommonNotificationShow isNotificationYBarShowing ,return false");
            }
            return false;
        }
        boolean equals = RouteGuideParams.NavState.NAV_STATE_OPERATE.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b());
        ViewGroup b02 = com.baidu.navisdk.ui.routeguide.control.x.b().b0();
        boolean z22 = com.baidu.navisdk.ui.routeguide.control.x.b().z2();
        boolean z12 = b02 != null && b02.getVisibility() == 0;
        boolean T1 = com.baidu.navisdk.ui.routeguide.control.x.b().T1();
        boolean q2 = com.baidu.navisdk.ui.routeguide.control.x.b().q2();
        boolean v2 = com.baidu.navisdk.ui.routeguide.control.x.b().v2();
        boolean J2 = com.baidu.navisdk.ui.routeguide.control.x.b().J2();
        boolean K2 = com.baidu.navisdk.ui.routeguide.control.x.b().K2();
        boolean X1 = com.baidu.navisdk.ui.routeguide.control.x.b().X1();
        boolean b2 = com.baidu.navisdk.ui.routeguide.control.x.b().b2();
        boolean k2 = com.baidu.navisdk.ui.routeguide.model.i.s().k();
        boolean T = com.baidu.navisdk.ui.routeguide.mapmode.a.o5().T();
        boolean w2 = com.baidu.navisdk.ui.routeguide.mapmode.a.o5().w2();
        boolean I2 = com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I2();
        boolean a2 = com.baidu.navisdk.ugc.d.a();
        boolean b3 = com.baidu.navisdk.ui.routeguide.control.i.g().b();
        com.baidu.navisdk.pronavi.ui.base.b s = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s == null || !s.I()) {
            z2 = k2;
            z3 = false;
        } else {
            z2 = k2;
            z3 = true;
        }
        boolean z13 = s != null && s.L();
        if (s == null || !s.K()) {
            z4 = z3;
            z5 = false;
        } else {
            z4 = z3;
            z5 = true;
        }
        if (i2 == 112) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                z7 = b3;
                StringBuilder sb = new StringBuilder();
                z6 = a2;
                sb.append("allowCommonNotificationShow isNavOperate type = ");
                sb.append(i2);
                gVar2.e("RGNotificationController", sb.toString());
            } else {
                z6 = a2;
                z7 = b3;
            }
            z8 = false;
        } else {
            z6 = a2;
            z7 = b3;
            z8 = equals;
        }
        if (i2 == 999) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                StringBuilder sb2 = new StringBuilder();
                z9 = I2;
                sb2.append("allowCommonNotificationShow isEnlargeOrColladaShow type = ");
                sb2.append(i2);
                gVar3.e("RGNotificationController", sb2.toString());
            } else {
                z9 = I2;
            }
            z10 = false;
            z11 = false;
        } else {
            z9 = I2;
            z10 = b2;
            z11 = z2;
        }
        if (!z8 && !z22 && !z12 && !T1 && !q2 && !v2 && !J2 && !K2 && !X1 && !z10 && !z11 && !T && !w2 && !z9 && !z6 && !z7 && !z4 && !z13 && !z5) {
            return true;
        }
        com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (!gVar4.d()) {
            return false;
        }
        gVar4.e("RGNotificationController", "allowCommonNotificationShow return false !, isNavOperate = " + z8 + ", isSafetyVisible = " + z22 + ", isModuleVisible = " + z12 + ", isBlueToothUSBGuideVisible = " + T1 + ", isMenuMoreVisible = " + q2 + ", isRouteSearchVisible = " + v2 + ", isUGCPanelVisible = " + J2 + ", isCommomViewShow = " + X1 + ", isEnlargeOrColladaShow = " + z10 + ", isHUDStatus = " + T + ", isRouteSortViewVisible = " + w2 + ", isToolboxOpened = " + z9 + ", isUgcUserOperating = " + z6 + ", isAnyEnlargeRoadMapShowing = " + z11 + ", isCardShow = " + z7 + ", isUGCDetailViewShow = " + K2 + ", isShowChargeList = " + z4);
        return false;
    }

    public void d(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "hideCommonView type = " + i2);
        }
        v(i2);
    }

    public boolean b(com.baidu.navisdk.ui.routeguide.model.e eVar) {
        ArrayList<com.baidu.navisdk.ui.routeguide.model.e> arrayList = this.f;
        if (arrayList != null && eVar != null) {
            Iterator<com.baidu.navisdk.ui.routeguide.model.e> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.ui.routeguide.model.e next = it.next();
                if (next != null && !next.equals(eVar) && next.l()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void b(String str) {
        com.baidu.navisdk.ui.routeguide.control.x.b().j(108).z(100).b(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_success)).f(str).v(10000).y();
    }

    public void c(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "hideCheckboxView type = " + i2);
        }
        u(i2);
        if (i2 == 1) {
            com.baidu.navisdk.ui.routeguide.control.x.b().I().a(0);
        }
    }

    public void c(String str) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.m f2 = com.baidu.navisdk.ui.routeguide.control.x.b().a(112, 1).z(100).b(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_success)).f(str);
        f2.v(10000);
        f2.a(new a(this));
        f2.y();
    }

    public void b(String str, String str2, i0.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showETAPoint");
        }
        if (!T().b(114)) {
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showETAPoint allowOperableNotificationShow return false!");
            }
        } else {
            e(114);
            com.baidu.navisdk.ui.routeguide.control.x.b().k(114).D(100).v(-1).b(str2).g(com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_eta_query_confirm)).f(com.baidu.navisdk.ui.util.b.h(R.string.alert_cancel)).a(fVar).a(new c(this)).d(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_via_point)).a(str).y();
        }
    }

    public void c(int i2, boolean z2) {
        String str;
        String h2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showAroundNeCsPoint --> type = " + i2 + ", isAutoHide = " + z2);
        }
        if (!T().b(132)) {
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showAroundNeCsPoint allowOperableNotificationShow return false!");
                return;
            }
            return;
        }
        q();
        if (!RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getTopState()) && !com.baidu.navisdk.poisearch.model.a.k().h()) {
            com.baidu.navisdk.model.datastruct.chargestation.b c2 = com.baidu.navisdk.poisearch.model.b.m().c();
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showAroundNeCsPoint --> neCsPoi is " + c2);
            }
            if (c2 == null) {
                return;
            }
            p();
            String j2 = c2.j();
            String b2 = l0.b(c2.d().a(), l0.a.ZH);
            String a2 = l0.a(c2.d().h());
            int i3 = z2 ? 30000 : -1;
            if (i2 == 4) {
                h2 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_route_search_change_dest);
                str = "2";
            } else if (i2 == 1) {
                h2 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_route_search_add_via);
                str = "0";
            } else {
                str = "1";
                if (i2 == 2) {
                    h2 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_route_search_change_dest);
                } else {
                    h2 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_route_search_add_via);
                }
            }
            String[] split = c2.d().d().split("\\|");
            ArrayList arrayList = new ArrayList();
            com.baidu.navisdk.framework.interfaces.k k2 = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (k2 != null && k2.m() && split.length > 0) {
                for (String str2 : split) {
                    if (!TextUtils.isEmpty(str2)) {
                        i0.e eVar = new i0.e();
                        eVar.f8793a = str2;
                        arrayList.add(eVar);
                    }
                }
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_rg_operable_notification_ne_cs_confirm_background, true));
            gradientDrawable.setCornerRadius(ScreenUtil.getInstance().dip2px(30));
            b.C0502b c0502b = new b.C0502b();
            int i4 = R.drawable.nsdk_notification_charge_station_icon;
            com.baidu.navisdk.ui.routeguide.control.x.b().k(132).v(i3).g(h2).c(gradientDrawable).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_faster_route_btn_cancle)).b(com.baidu.navisdk.ui.util.b.c(R.drawable.nsdk_note_cancel_bt_bg_selector, true)).B(R.color.nsdk_rg_operable_notification_background).y(R.color.nsdk_rg_operable_notification_maintitle).E(R.color.nsdk_rg_operable_notification_subtitle).F(com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_14dp)).x(R.color.nsdk_note_confirm_bt_txt_selector).w(R.color.nsdk_note_cancel_bt_txt_selector).a(new i(this, c2, i2, str)).a(new h(this, c2)).a(com.baidu.navisdk.ui.routeguide.model.d.g().a(c2.d().i()), c0502b.b(i4).a(i4).a(), (com.baidu.navisdk.util.navimageloader.e) null).a(j2).b(b2).c(a2).b(arrayList).y();
            return;
        }
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showAroundNeCsPoint --> is in nearby search mode, return!");
        }
    }

    public boolean a(int i2, boolean z2) {
        boolean z3;
        if (z2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "ugc panel enlargeMapTogether allowCheckboxNotificationShow ok");
            }
            return true;
        }
        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().z()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGNotificationController", "allowCheckboxNotificationShow: --> isBackgroundNavi");
            }
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().T()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGNotificationController", "allowCheckboxNotificationShow: --> hud is showing");
            }
            return false;
        }
        if (RouteGuideFSM.getInstance().isTopState(RGFSMTable.FsmState.HUD) || RouteGuideFSM.getInstance().isTopState(RGFSMTable.FsmState.HUDMirror)) {
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
            if (i2 != 108) {
                com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar4.d()) {
                    gVar4.e("RGNotificationController", "allowCheckboxNotificationShow RGAsrProxy.getInstance().isRoused()");
                }
                return false;
            }
            com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar5.d()) {
                gVar5.e("RGNotificationController", "allowCheckboxNotificationShow 异常拥堵上报不管是不是语音态都能弹出来");
            }
        }
        boolean isBrowseState = RouteGuideFSM.getInstance().isBrowseState();
        ViewGroup b02 = com.baidu.navisdk.ui.routeguide.control.x.b().b0();
        boolean z22 = com.baidu.navisdk.ui.routeguide.control.x.b().z2();
        boolean z4 = b02 != null && b02.getVisibility() == 0;
        boolean T1 = com.baidu.navisdk.ui.routeguide.control.x.b().T1();
        boolean v2 = com.baidu.navisdk.ui.routeguide.control.x.b().v2();
        boolean J2 = com.baidu.navisdk.ui.routeguide.control.x.b().J2();
        boolean X1 = com.baidu.navisdk.ui.routeguide.control.x.b().X1();
        boolean b2 = com.baidu.navisdk.ui.routeguide.control.x.b().b2();
        boolean k2 = com.baidu.navisdk.ui.routeguide.model.i.s().k();
        boolean T = com.baidu.navisdk.ui.routeguide.mapmode.a.o5().T();
        boolean w2 = com.baidu.navisdk.ui.routeguide.mapmode.a.o5().w2();
        boolean I2 = com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I2();
        boolean a2 = com.baidu.navisdk.ugc.d.a();
        com.baidu.navisdk.pronavi.ui.base.b s = com.baidu.navisdk.ui.routeguide.b.V().s();
        boolean z5 = s != null && s.I();
        boolean z6 = s != null && s.L();
        boolean z7 = s != null && s.K();
        if (i2 == 108 && !T && !b2 && !z22 && !T1) {
            com.baidu.navisdk.util.common.g gVar6 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (!gVar6.d()) {
                return true;
            }
            gVar6.e("RGNotificationController", "allowCheckboxNotificationShow return true type = " + i2);
            return true;
        }
        if (isBrowseState || z22 || z4 || T1 || v2 || J2 || X1 || b2 || k2 || T || w2 || I2 || a2) {
            z3 = z5;
        } else {
            z3 = z5;
            if (!z3 && !z6 && !z7) {
                return true;
            }
        }
        com.baidu.navisdk.util.common.g gVar7 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar7.d()) {
            gVar7.e("RGNotificationController", "allowCheckboxNotificationShow return false !, isNavOperate = " + isBrowseState + ", isSafetyVisible = " + z22 + ", isModuleVisible = " + z4 + ", isBlueToothUSBGuideVisible = " + T1 + ", isRouteSearchVisible = " + v2 + ", isUGCPanelVisible = " + J2 + ", isCommomViewShow = " + X1 + ", isEnlargeOrColladaShow = " + b2 + ", isHUDStatus = " + T + ", isRouteSortViewVisible = " + w2 + ", isToolboxOpened = " + I2 + ", isUgcUserOperating = " + a2 + ", isAnyEnlargeRoadMapShowing = " + k2 + ", isShowChargeList = " + z3);
        }
        return false;
    }

    public void b(int i2, boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showAroundCarServiceAreaPoint --> type = " + i2 + ", isAutoHide = " + z2);
        }
        if (!T().b(134)) {
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showAroundCarServiceAreaPoint allowOperableNotificationShow return false!");
                return;
            }
            return;
        }
        r();
        if (!RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getTopState()) && !com.baidu.navisdk.poisearch.model.a.k().h()) {
            com.baidu.navisdk.module.pronavi.model.d b2 = com.baidu.navisdk.poisearch.model.b.m().b();
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showAroundCarServiceAreaPoint --> serviceAreaPoi is " + b2);
            }
            if (b2 == null) {
                return;
            }
            String b3 = l0.b(b2.a(), l0.a.ZH);
            com.baidu.navisdk.ui.routeguide.control.x.b().k(134).D(100).v(z2 ? 30000 : -1).g(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_route_search_add_via)).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_faster_route_btn_cancle)).a(new k(this, b2)).a(new j(this, b2)).d(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_service_area)).a(b2.h()).b("距您" + b3).b(b2).y();
            return;
        }
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showAroundCarServiceAreaPoint --> is in nearby search mode, return!");
        }
    }

    public void b(Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showPermitOperationYBar(), bundle=" + bundle);
        }
        int i2 = bundle.getInt("tipId", -1);
        String string = bundle.getString("mainTitle", "");
        String string2 = bundle.getString("subTitle", "");
        int i3 = bundle.getInt("backColorId", -1);
        int i4 = bundle.getInt("iconId", -1);
        String string3 = bundle.getString("permitInfoId", "");
        if (i2 != 48 || TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || i4 == -1 || i3 == -1 || TextUtils.isEmpty(string3)) {
            return;
        }
        a(123, i2, string, string2, i3, i4, bundle);
    }

    public boolean a(boolean z2, boolean z3) {
        String str;
        int i2;
        int i3;
        Bundle U = U();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showLocalRoute(), isStartNav=" + z2 + ", isFromCommute=" + z3 + ", infos=" + U);
        }
        if (U == null || U.isEmpty()) {
            return false;
        }
        int i4 = U.getInt("type", -1);
        int i5 = U.getInt("iconId", -1);
        int i6 = U.getInt("backColorId", -1);
        String string = U.getString("info", "");
        if (i4 == 1) {
            if (z3) {
                str = "<font color=\"#ffffff\">" + string.replaceAll("</?[^>]+>", "") + "</font>";
                i2 = 2;
                i3 = 2;
            } else {
                str = string;
                i2 = i6;
                i3 = i5;
            }
            a(103, 4, str, (String) null, i2, i3);
            return true;
        }
        if (i4 != 0 || !z2 || com.baidu.navisdk.ui.routeguide.b.V().q() == 3 || com.baidu.navisdk.ui.routeguide.b.V().q() == 7 || !com.baidu.navisdk.j.d() || com.baidu.navisdk.ui.routeguide.b.V().A() || !z()) {
            return false;
        }
        a(103, 3, string, (String) null, i6, i5);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GeoPoint b(int i2, int i3) {
        Bundle b2 = com.baidu.navisdk.util.common.o.b(i2, i3);
        GeoPoint geoPoint = new GeoPoint();
        geoPoint.setLongitudeE6(b2.getInt("LLx"));
        geoPoint.setLatitudeE6(b2.getInt("LLy"));
        return geoPoint;
    }

    public void a(int i2, String str, String str2, String str3, String str4, String str5) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("voice_page", "showBusinessVoiceRecommend");
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().k(104).D(100).v(i2 * 1000).C(JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_92dp)).i(str).a(str2).b(str3).z(2).g(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_operable_notification_voice_recommend_confirm)).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_operable_notification_voice_recommend_cancel)).a(new z(this, str4, str5)).a(new u(this)).y();
    }

    public void a(boolean z2, int i2) {
        com.baidu.navisdk.ui.routeguide.model.x.A().f8982a = false;
        com.baidu.navisdk.ui.routeguide.asr.c.n().l();
        T().e(103);
        BNMapController.getInstance().recoveryHighLightRoute();
        BNMapController.getInstance().setMapFuncInfoFastRoute(false, -1, -1, -1);
        com.baidu.navisdk.ui.routeguide.b.V().r().n();
        int m2 = com.baidu.navisdk.ui.routeguide.model.x.A().m();
        if (com.baidu.navisdk.ui.routeguide.model.x.A().e() != 3) {
            if (m2 == 7 || m2 == 13) {
                int j2 = com.baidu.navisdk.ui.routeguide.model.x.A().j();
                int i3 = com.baidu.navisdk.ui.routeguide.model.x.A().r;
                int k2 = com.baidu.navisdk.ui.routeguide.model.x.A().k();
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGNotificationController", "setShowRouteChoose, showStatus:" + i2 + ", pushType:" + j2 + "source:" + i3);
                }
                JNIGuidanceControl.getInstance().setShowRouteChoose(i2, j2, i3);
                BNMapController.getInstance().setLabelBreathing(k2, false);
                if (gVar.d()) {
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "回传类型： " + i2);
                }
            }
        }
    }

    public i0 a(i0.f fVar, g0.d dVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showOfflineToOnlineNotification");
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().a(false);
        com.baidu.navisdk.ui.routeguide.control.x.b().t1();
        com.baidu.navisdk.ui.routeguide.control.x.b().u1();
        com.baidu.navisdk.ui.routeguide.control.x.b().Z0();
        com.baidu.navisdk.ui.routeguide.control.x.b().o3();
        com.baidu.navisdk.ui.routeguide.control.x.b().b3();
        com.baidu.navisdk.ui.routeguide.control.x.b().a1();
        String string = JarUtils.getResources().getString(R.string.nsdk_string_rg_offline_to_online_title);
        String string2 = JarUtils.getResources().getString(R.string.nsdk_string_rg_offline_to_online_tips);
        e(110);
        return com.baidu.navisdk.ui.routeguide.control.x.b().k(110).d(JarUtils.getResources().getDrawable(R.drawable.nsdk_notification_fail)).D(100).v(20000).a(string).b(string2).g("继续离线导航").y(true).z(true).A(false).a(fVar).a(dVar);
    }

    public i0 a(i0.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "getYawingNotificationView");
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().a(false);
        com.baidu.navisdk.ui.routeguide.control.x.b().t1();
        com.baidu.navisdk.ui.routeguide.control.x.b().u1();
        com.baidu.navisdk.ui.routeguide.control.x.b().Z0();
        com.baidu.navisdk.ui.routeguide.control.x.b().o3();
        com.baidu.navisdk.ui.routeguide.control.x.b().a1();
        com.baidu.navisdk.ui.routeguide.control.x.b().b3();
        String string = JarUtils.getResources().getString(R.string.nsdk_string_rg_first_yawing_failed_title);
        String string2 = JarUtils.getResources().getString(R.string.nsdk_string_rg_operable_notification_wait_route_plan_result_sub_title);
        e(117);
        return com.baidu.navisdk.ui.routeguide.control.x.b().k(117).a(string).b(string2).d(JarUtils.getResources().getDrawable(R.drawable.nsdk_notification_fail)).D(100).g("立即重算").f("取消").y(false).z(false).A(false).v(-1).z(2).a(fVar);
    }

    public void a(String str, int i2) {
        com.baidu.navisdk.ui.routeguide.control.x.b().j(122).z(100).b(com.baidu.navisdk.ui.util.b.f(i2)).f(str).y();
    }

    public void a(String str, boolean z2) {
        a(str, z2, -1);
    }

    public void a(String str, boolean z2, int i2) {
        Drawable f2;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.m z3 = com.baidu.navisdk.ui.routeguide.control.x.b().j(112).z(100);
        if (z2) {
            f2 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_success);
        } else {
            f2 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_fail);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.m f3 = z3.b(f2).f(str);
        if (i2 >= 0) {
            f3.v(i2);
        }
        f3.y();
    }

    public void a(String str, String str2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.m g2 = com.baidu.navisdk.ui.routeguide.control.x.b().a(112, 1).z(100).b(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_yaw)).f(str).g(str2);
        g2.v(10000);
        g2.y();
    }

    public void a(String str) {
        com.baidu.navisdk.ui.routeguide.control.x.b().j(112).z(100).b(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_success)).f(str).v(5000).y();
    }

    public void a(String str, String str2, i0.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showDestinationPoint");
        }
        if (!T().b(111)) {
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showDestinationPoint allowOperableNotificationShow return false!");
            }
        } else {
            e(111);
            com.baidu.navisdk.ui.routeguide.control.x.b().k(111).D(100).v(-1).b(str2).g(com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_modify_destination_confirm)).f(com.baidu.navisdk.ui.util.b.h(R.string.alert_cancel)).a(fVar).a(new b(this)).d(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_via_point)).a(str).y();
        }
    }

    public void a(boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showJamReport: --> " + com.baidu.navisdk.ui.routeguide.model.q.d().f8961a);
        }
        if (com.baidu.navisdk.ugc.d.a()) {
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showJamReport: --> UgcExternalImpl.isUserOperating true ");
                return;
            }
            return;
        }
        com.baidu.navisdk.ui.routeguide.model.q.d().f8961a = true;
        if (com.baidu.navisdk.ui.routeguide.model.q.d().f8961a && com.baidu.navisdk.j.d()) {
            if (gVar.d()) {
                gVar.e("caoyujieTodo", T().f.size() + ", view = " + T().e.size());
            }
            if (com.baidu.navisdk.ui.routeguide.model.q.d().c(z2)) {
                com.baidu.navisdk.ui.routeguide.control.x.b().a(false);
                com.baidu.navisdk.ui.routeguide.control.x.b().t1();
                com.baidu.navisdk.ui.routeguide.control.x.b().u1();
                com.baidu.navisdk.ui.routeguide.control.x.b().Z0();
                com.baidu.navisdk.ui.routeguide.control.x.b().o3();
                com.baidu.navisdk.ui.routeguide.control.x.b().a1();
                com.baidu.navisdk.ui.routeguide.control.x.b().b3();
                com.baidu.navisdk.ui.routeguide.model.q.d().a(true);
            }
        }
    }

    public void a(com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        if (aVar == null) {
            WeakReference<com.baidu.navisdk.ui.routeguide.subview.a> weakReference = this.g;
            if (weakReference != null) {
                weakReference.clear();
                this.g = null;
                return;
            }
            return;
        }
        this.g = new WeakReference<>(aVar);
    }

    public int a(boolean z2, int i2, @NonNull Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showCommonNotificationForJNI isShow =" + z2 + bundle);
        }
        if (i2 == 2 && com.baidu.navisdk.module.pronavi.a.j == 2) {
            if (gVar.d()) {
                gVar.e("showCommonNotificationForJNI is DemoGPS");
            }
            return 1;
        }
        if (z2) {
            String string = bundle.getString("title");
            String string2 = bundle.getString("subText");
            String string3 = bundle.getString("voice");
            if (!TextUtils.isEmpty(string3)) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("36.0.2.1433", com.baidu.navisdk.ui.routeguide.ace.a.m().d().a(), "" + BNRouteGuider.getInstance().getACEABTag());
                if (BNRouteGuider.getInstance().getACEABTag() != 1) {
                    TTSPlayerControl.playTTS(string3, 1);
                }
            }
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                return 1;
            }
            int i3 = bundle.getInt("displayDuation", 0);
            int i4 = bundle.getInt("iconType", 0);
            int i5 = bundle.getInt("level", 0);
            Drawable f2 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_success);
            if (i4 == 1) {
                f2 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_fail);
            }
            int i6 = i5 == 0 ? 100 : i5 == 1 ? 200 : 300;
            com.baidu.navisdk.ui.routeguide.mapmode.subview.m j2 = com.baidu.navisdk.ui.routeguide.control.x.b().j(999);
            j2.f(string).g(string2).b(f2);
            j2.z(i6);
            if (i3 > 0) {
                j2.v(i3 * 1000);
            }
            j2.a(new o(this, i2));
            j2.y();
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.15.1.1", "" + i2, null, null);
        } else {
            v(999);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.15.1.2", "" + i2, null, null);
        }
        return 1;
    }

    private void a(int i2, int i3, String str, String str2, int i4, int i5, Bundle bundle) {
        String str3;
        i0 a2 = com.baidu.navisdk.ui.routeguide.control.x.b().k(i2).a(Html.fromHtml(str).toString()).b(str2).D(100).v(20000).a(new p(this, i3, bundle));
        a2.d(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_yellow_banner_green));
        a.d g2 = com.baidu.navisdk.yellowtipdata.model.a.c().g(i3);
        str3 = "可穿行";
        String str4 = "取消";
        if (g2 != null) {
            str3 = TextUtils.isEmpty(g2.b()) ? "可穿行" : g2.b();
            if (!TextUtils.isEmpty(g2.a())) {
                str4 = g2.a();
            }
        }
        boolean y2 = a2.g(str3).f(str4).y();
        if (!y2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNotificationController", "non car plate show ret =" + y2);
                return;
            }
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.3.1352", i3 + "", "0");
        TTSPlayerControl.playTTS(str2, 1);
    }

    public void a(int i2, int i3, String str, String str2, int i4, int i5) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showNotificationYBar --> notificationType = " + i2 + " tipId = " + i3 + " mainTitle = " + str + " subTitle = " + str2 + " backColorId = " + i4 + " iconId = " + i5);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.m a2 = com.baidu.navisdk.ui.routeguide.control.x.b().j(i2).f(Html.fromHtml(str).toString()).g(str2).z(q(i4)).B(i3).a(new q(this, i3));
        int a3 = com.baidu.navisdk.yellowbannerui.controller.a.c().a(i5);
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showNotificationYBar iconDrawableId: " + a3 + ", iconId:" + i5);
        }
        a2.a(p(i5), a3 > 0 ? new b.C0502b().b(a3).a(a3).a() : null, new r(i5, a2));
        a2.y();
        com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.3.1352", "" + i3, "0");
    }

    public int a(Bundle bundle) {
        if (bundle == null) {
            return -1;
        }
        com.baidu.navisdk.yellowtipdata.model.data.c a2 = com.baidu.navisdk.yellowtipdata.model.data.c.a(bundle);
        a2.f(114);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showComNoteYBarJumpNavigation,model:" + a2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.m a3 = com.baidu.navisdk.ui.routeguide.control.x.b().j(a2.j()).f(Html.fromHtml(a2.h()).toString()).g((String) null).z(q(a2.b())).B(a2.l()).a(new C0441s(this, a2));
        int a4 = com.baidu.navisdk.yellowbannerui.controller.a.c().a(a2.g());
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showNotificationYBar iconDrawableId: " + a4 + ", iconId:" + a2.g());
        }
        a3.a(p(a2.g()), a4 > 0 ? new b.C0502b().b(a4).a(a4).a() : null, new t(a2, a3));
        a3.y();
        com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.3.1352", "" + a2.l(), "0");
        if (!x(a2.l()) || TextUtils.isEmpty(a2.c())) {
            return 0;
        }
        TTSPlayerControl.playTTS(a2.c(), 1);
        return 0;
    }

    public void a(int i2, int i3, String str) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.m j2 = com.baidu.navisdk.ui.routeguide.control.x.b().j(117);
        Drawable f2 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_success);
        if (i2 == 1) {
            f2 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_fail);
        }
        j2.f(str).b(f2);
        j2.z(300);
        if (i3 > 0) {
            j2.v(i3 * 1000);
        }
        j2.y();
    }

    public int a(Bundle bundle, ArrayList<Bundle> arrayList) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showComOperableNoteWithCloud");
        }
        if (bundle == null) {
            return 4;
        }
        if (arrayList == null || arrayList.size() < 1) {
            return 5;
        }
        Bundle bundle2 = arrayList.get(0);
        if (bundle2 == null) {
            return 6;
        }
        com.baidu.navisdk.yellowtipdata.model.data.c a2 = com.baidu.navisdk.yellowtipdata.model.data.c.a(bundle);
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showComOperableNoteWithCloud, pointInfo:" + bundle2);
            gVar.e("RGNotificationController", "showComOperableNoteWithCloud, notifyModel:" + a2);
        }
        if (k(s(a2.l()))) {
            if (!gVar.d()) {
                return 2;
            }
            gVar.e("RGNotificationController", "showComOperableNoteWithCloud,isContainsOperableType ->true");
            return 2;
        }
        if (!T().b(s(a2.l()))) {
            if (!gVar.d()) {
                return 3;
            }
            gVar.e("RGNotificationController", "showComOperableNoteWithCloud,allowOperableNotificationShow->false");
            return 3;
        }
        d0 a3 = d0.a(bundle2);
        if (a3 == null) {
            return 7;
        }
        if (a2.l() == 49) {
            String h2 = a2.h();
            String a4 = l0.a(h2, "<", 14, "...");
            a2.d(a4);
            if (gVar.d()) {
                gVar.e("RGNotificationController", "showOperableNoteYBarWithCloud(), title = " + h2 + ", result=" + a4);
            }
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.2", a2.l() + "", "1", null);
        i0 k2 = com.baidu.navisdk.ui.routeguide.control.x.b().k(s(a2.l()));
        k2.D(100).a(Html.fromHtml(a2.h())).z(a2.i()).f(a2.d()).a(new v(a2, a3, bundle));
        if (a2.l() == 49) {
            k2.b((CharSequence) null);
            k2.d(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_ic_dest_arrive_reminder));
            k2.v(20000);
            k2.g(a3.a());
        } else {
            k2.b(a2.k());
            k2.d(t(a2.l()));
            k2.v(a2.a());
            k2.g(a2.f());
        }
        boolean y2 = k2.y();
        if (gVar.d()) {
            gVar.e("RGNotificationController", "showComOperableNoteWithCloud,success init, ret=" + y2);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.3.1352", "" + a2.l(), "0");
        return 1;
    }

    public void a(i0.f fVar, g0.e eVar, g0.d dVar) {
        p();
        com.baidu.navisdk.ui.routeguide.control.x.b().k(131).d(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_fail)).D(100).a(JarUtils.getResources().getString(R.string.nsdk_wifi_switch_title)).g(JarUtils.getResources().getString(R.string.nsdk_wifi_switch_confirm)).f(JarUtils.getResources().getString(R.string.nsdk_wifi_switch_cancel)).v(15000).y(true).z(true).a(eVar).a(dVar).a(fVar).y();
    }
}
