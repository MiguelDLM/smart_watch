package com.baidu.navisdk.adapter.impl.longdistance;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.baidunavis.maplayer.i;
import com.baidu.navisdk.adapter.impl.BNRouteResultManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.j;
import com.baidu.navisdk.model.modelfactory.f;
import com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.c;
import com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.d;
import com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.f;
import com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.g;
import com.baidu.navisdk.module.routeresultbase.logic.longdistance.d;
import com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.d;
import com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.e;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.o;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.c;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class a implements i, d.InterfaceC0288d {

    /* renamed from: a, reason: collision with root package name */
    private Context f6529a = BNRouteResultManager.f().a();
    private d b;
    private com.baidu.navisdk.yellowbannerui.controller.b c;
    private com.baidu.navisdk.poisearch.view.controller.a d;
    private final f e;

    /* renamed from: com.baidu.navisdk.adapter.impl.longdistance.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0165a implements d.InterfaceC0291d {
        public C0165a() {
        }

        @Override // com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.d.InterfaceC0291d
        public void a(d.f fVar) {
            if (LogUtil.LOGGABLE) {
                LogUtil.out("BNRouteResultManager", "onGetData --> weatherData = " + fVar);
            }
            if (fVar == null) {
                return;
            }
            if (fVar.f7533a == 0) {
                a.this.b.l().a(fVar, a.this.b.d().b, a.this.b.d().c);
                if (!a.this.b.l().c(a.this.b.d().b)) {
                    TipTool.onCreateToastDialog(a.this.f6529a, R.string.nsdk_route_result_long_distance_weather_no_result_toast);
                    return;
                }
                a.this.b.l = false;
                a.this.b.a(a.this.f6529a, (c) null);
                a.this.c(4);
                return;
            }
            TipTool.onCreateToastDialog(a.this.f6529a, R.string.nsdk_route_result_long_distance_weather_error_toast);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements i {
        public b() {
        }

        @Override // com.baidu.baidunavis.maplayer.i
        public boolean a(int i) {
            return false;
        }

        @Override // com.baidu.baidunavis.maplayer.i
        public boolean a(c cVar) {
            return false;
        }

        @Override // com.baidu.baidunavis.maplayer.i
        public boolean a(int i, int i2, c cVar) {
            if (i2 != 1) {
                return false;
            }
            com.baidu.navisdk.poisearch.view.model.a c = a.this.d.c();
            if (c == null) {
                c = a.this.d.a();
            }
            a.this.a(c);
            return false;
        }
    }

    public a() {
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar = new com.baidu.navisdk.module.routeresultbase.logic.longdistance.d();
        this.b = dVar;
        dVar.a((i) this);
        this.b.a((d.InterfaceC0288d) this);
        this.d = new com.baidu.navisdk.poisearch.view.controller.a();
        this.c = BNRouteResultManager.f().c();
        this.e = (f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
    }

    private boolean f() {
        return com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.b().size() < 3;
    }

    private void h(boolean z) {
        if (this.b.j().c()) {
            c(3);
            com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar = this.b;
            dVar.r = true;
            dVar.a(3, this.f6529a);
            LogUtil.out("LongDistanceNaviModel", "ACTION_SERVICE select");
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.out("BNRouteResultManager", "handleLongDisNoService: " + z);
        }
        TipTool.onCreateToastDialog(this.f6529a, "沿途没有服务区，试试其他分类");
    }

    private void i() {
        if (!this.b.d().c()) {
            TipTool.onCreateToastDialog(this.f6529a, "沿途没有大中型城市");
            return;
        }
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar = this.b;
        dVar.r = true;
        dVar.a(1, this.f6529a);
    }

    private void j() {
        if (!this.b.h().c()) {
            TipTool.onCreateToastDialog(this.f6529a, "沿途没有高速");
            return;
        }
        c(2);
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar = this.b;
        dVar.r = true;
        dVar.a(2, this.f6529a);
    }

    private void k() {
        if (!this.b.d().c()) {
            TipTool.onCreateToastDialog(this.f6529a, "沿途没有大中型城市");
            return;
        }
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar = this.b;
        dVar.r = true;
        dVar.a(4, this.f6529a);
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar2 = this.b;
        if (!dVar2.l) {
            c(4);
            return;
        }
        Bundle a2 = dVar2.d().a();
        if (a2 == null) {
            return;
        }
        String string = a2.getString("cityId");
        String string2 = a2.getString("cityEta");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.d.a().a(string, string2, new C0165a());
    }

    private void l() {
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar = this.b;
        dVar.r = true;
        dVar.a(4, this.f6529a);
    }

    private void m() {
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar = this.b;
        dVar.v = 0;
        dVar.r = false;
        dVar.m();
        this.b.h = 0;
    }

    private void n() {
        if (e.c()) {
            com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar = this.b;
            if (dVar.i) {
                dVar.v = 0;
                dVar.n = "";
                c i = dVar.i();
                this.b.a(i);
                this.b.a(this.f6529a, i);
            }
        }
    }

    @Override // com.baidu.baidunavis.maplayer.i
    public boolean a(c cVar) {
        return false;
    }

    public void d() {
        LogUtil.out("BNRouteResultManager", "parseWeatherData");
        if (this.b != null) {
            com.baidu.navisdk.model.datastruct.i a2 = com.baidu.navisdk.b4nav.func.resolver.a.a();
            this.b.l().c.clear();
            this.b.l().e.clear();
            this.b.l().d.clear();
            this.b.l().f.clear();
            if (a2 == null) {
                return;
            }
            ArrayList<j> b2 = a2.b();
            for (int i = 0; i < b2.size(); i++) {
                j jVar = b2.get(i);
                if (jVar != null) {
                    this.b.l().c.put(i, jVar.a());
                    this.b.l().e.put(i, jVar.d());
                }
            }
            this.b.o();
        }
    }

    public void e() {
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar = this.b;
        if (dVar != null) {
            dVar.m();
        }
        com.baidu.navisdk.poisearch.view.controller.a aVar = this.d;
        if (aVar != null) {
            aVar.d();
        }
        g();
    }

    public void g(boolean z) {
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar;
        c.a a2;
        g.a a3;
        f.a a4;
        d.a a5;
        LogUtil.out("BNRouteResultManager", "load long distance data");
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar2 = this.b;
        if (dVar2 == null) {
            return;
        }
        dVar2.i = this.e.u();
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar3 = this.b;
        dVar3.x = true;
        dVar3.q = JNIGuidanceControl.getInstance().getSelectRouteIdx();
        this.b.p = com.baidu.navisdk.b4nav.func.resolver.a.b(com.baidu.navisdk.pbprocess.a.a());
        int i = 0;
        int i2 = 0;
        while (true) {
            dVar = this.b;
            if (i2 >= dVar.p) {
                break;
            }
            dVar.s[i2] = b(i2);
            i2++;
        }
        if (!dVar.i) {
            return;
        }
        com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.e a6 = com.baidu.navisdk.b4nav.func.resolver.a.a(com.baidu.navisdk.pbprocess.a.a());
        SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a>> sparseArray = this.b.d().b;
        SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a>> sparseArray2 = this.b.h().b;
        SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.service.a>> sparseArray3 = this.b.j().b;
        SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.checkpoint.a>> sparseArray4 = this.b.c().b;
        if (sparseArray == null || sparseArray2 == null || sparseArray3 == null || a6 == null) {
            return;
        }
        sparseArray.clear();
        sparseArray2.clear();
        sparseArray3.clear();
        sparseArray4.clear();
        while (true) {
            com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar4 = this.b;
            if (i < dVar4.p) {
                com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.d b2 = a6.b();
                if (b2 != null && (a5 = b2.a(i)) != null) {
                    sparseArray.append(i, new ArrayList<>(a5.a()));
                }
                com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.f c = a6.c();
                if (c != null && (a4 = c.a(i)) != null) {
                    sparseArray2.append(i, new ArrayList<>(a4.a()));
                }
                g d = a6.d();
                if (d != null && (a3 = d.a(i)) != null) {
                    sparseArray3.append(i, new ArrayList<>(a3.a()));
                }
                com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.c a7 = a6.a();
                if (a7 != null && (a2 = a7.a(i)) != null) {
                    sparseArray4.append(i, new ArrayList<>(a2.a()));
                }
                i++;
            } else {
                dVar4.a(z);
                return;
            }
        }
    }

    public int b(int i) {
        int[] c = com.baidu.navisdk.b4nav.func.resolver.a.c(com.baidu.navisdk.pbprocess.a.a());
        if (c.length <= 0 || i >= c.length) {
            return 0;
        }
        return c[i];
    }

    public void c(boolean z) {
        if (z) {
            if (!this.b.n()) {
                m();
                LogUtil.out("LongDistanceNaviModel", "ACTION_CITIES not ready");
                return;
            } else {
                i();
                LogUtil.out("LongDistanceNaviModel", "ACTION_CITIES select");
                return;
            }
        }
        this.b.w = 0;
        m();
        n();
    }

    public void f(boolean z) {
        if (z) {
            if (!this.b.b()) {
                m();
                LogUtil.out("LongDistanceNaviModel", "ACTION_WEATHER not ready");
                return;
            } else {
                if (e.c()) {
                    l();
                } else {
                    k();
                }
                LogUtil.out("LongDistanceNaviModel", "ACTION_WEATHER select");
                return;
            }
        }
        this.b.w = 0;
        n();
        m();
        LogUtil.out("LongDistanceNaviModel", "ACTION_WEATHER close");
    }

    @Override // com.baidu.baidunavis.maplayer.i
    public boolean a(int i) {
        if (com.baidu.navisdk.util.common.g.c0) {
            com.baidu.navisdk.util.common.g.OPEN_SDK.f("BNRouteResultManager", "onTap: " + i);
        }
        int i2 = this.b.v;
        if (i2 == 3) {
            com.baidu.baidunavis.maplayer.d a2 = com.baidu.baidunavis.maplayer.e.k().a(i);
            if (LogUtil.LOGGABLE) {
                LogUtil.out("BNRouteResultManager", "onTap --> item = " + a2);
            }
            if (a2 != null && !TextUtils.isEmpty(a2.a())) {
                this.b.a(this.f6529a, a2);
            }
        } else if (i2 == 5) {
            com.baidu.baidunavis.maplayer.d a3 = com.baidu.baidunavis.maplayer.e.k().a(i);
            if (LogUtil.LOGGABLE) {
                LogUtil.out("BNRouteResultManager", "onTap PASS_CHECKPOINT--> item = " + a3);
            }
            if (a3 == null) {
                return false;
            }
            this.b.a(this.f6529a, a3);
        }
        return false;
    }

    public com.baidu.navisdk.module.routeresultbase.logic.longdistance.d b() {
        return this.b;
    }

    public void b(boolean z) {
        if (z) {
            if (!this.b.n()) {
                m();
                LogUtil.out("LongDistanceNaviModel", "ACTION_SERVICE not ready");
                return;
            } else {
                h();
                return;
            }
        }
        this.b.w = 0;
        m();
        n();
        LogUtil.out("LongDistanceNaviModel", "ACTION_CHECKPOINT Checkpoint close");
    }

    public void e(boolean z) {
        if (z) {
            if (!this.b.n()) {
                m();
                LogUtil.out("LongDistanceNaviModel", "ACTION_SERVICE not ready");
                return;
            } else {
                h(true);
                return;
            }
        }
        this.b.w = 0;
        m();
        n();
    }

    private void h() {
        if (this.b.c().b()) {
            com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar = this.b;
            dVar.r = true;
            dVar.a(5, this.f6529a);
            LogUtil.out("LongDistanceNaviModel", "ACTION_CHECKPOINT select");
            return;
        }
        TipTool.onCreateToastDialog(this.f6529a, "沿途没有检查站，试试其他分类");
        LogUtil.out("LongDistanceNaviModel", "ACTION_CHECKPOINT 0 Checkpoint");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        String a2;
        if (i == 2) {
            a2 = this.b.h().a();
        } else if (i == 3) {
            a2 = this.b.j().a();
        } else if (i != 4) {
            a2 = "";
        } else if (e.c()) {
            a2 = this.b.g();
        } else {
            a2 = this.b.l().a(this.b.d().b);
        }
        if (TextUtils.isEmpty(a2)) {
            g();
        } else {
            a(i, a2);
        }
    }

    public void d(boolean z) {
        if (z) {
            if (!this.b.n()) {
                m();
                LogUtil.out("LongDistanceNaviModel", "ACTION_ROUTE not ready");
                return;
            } else {
                j();
                LogUtil.out("LongDistanceNaviModel", "ACTION_ROUTE select");
                return;
            }
        }
        this.b.w = 0;
        m();
        n();
    }

    @Override // com.baidu.baidunavis.maplayer.i
    public boolean a(int i, int i2, com.baidu.nplatform.comapi.basestruct.c cVar) {
        com.baidu.nplatform.comapi.basestruct.c a2;
        com.baidu.nplatform.comapi.basestruct.c a3;
        if (com.baidu.navisdk.util.common.g.c0) {
            com.baidu.navisdk.util.common.g.OPEN_SDK.f("BNRouteResultManager", "onTap: " + i + ", " + cVar);
        }
        com.baidu.baidunavis.maplayer.d a4 = com.baidu.baidunavis.maplayer.e.k().a(i);
        int i3 = this.b.v;
        if (i3 == 3) {
            if (a4 == null) {
                return false;
            }
            if (TextUtils.isEmpty(a4.a()) && i2 == 1 && (a3 = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(a4)) != null) {
                com.baidu.navisdk.module.routeresultbase.logic.longdistance.service.a f = this.b.f();
                com.baidu.navisdk.poisearch.view.model.a aVar = new com.baidu.navisdk.poisearch.view.model.a();
                aVar.a("地图上的点");
                if (f != null && !TextUtils.isEmpty(f.f7521a)) {
                    aVar.a(f.f7521a);
                }
                aVar.a(a3);
                a(aVar);
                BNRouteResultManager.f().handleServiceClick(true);
                return true;
            }
        } else if (i3 == 5 && i2 == 1 && (a2 = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(a4)) != null) {
            com.baidu.navisdk.module.routeresultbase.logic.longdistance.checkpoint.a e = this.b.e();
            com.baidu.navisdk.poisearch.view.model.a aVar2 = new com.baidu.navisdk.poisearch.view.model.a();
            aVar2.a("地图上的点");
            if (e != null && !TextUtils.isEmpty(e.f7512a)) {
                aVar2.a(e.f7512a);
            }
            aVar2.a(a2);
            a(aVar2);
            BNRouteResultManager.f().handleCheckpointClick(true);
            return true;
        }
        this.b.a(this.f6529a, a4);
        return false;
    }

    public com.baidu.navisdk.module.routeresultbase.logic.longdistance.d c() {
        return this.b;
    }

    private void g() {
        this.c.b(11);
        this.c.b(12);
        this.c.b(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.navisdk.poisearch.view.model.a aVar) {
        if (aVar == null) {
            return;
        }
        LogUtil.out("BNRouteResultManager", "addThroughNode: poiNode --> " + aVar);
        if (aVar.b() != null) {
            Bundle b2 = o.b(aVar.b().c(), aVar.b().d());
            GeoPoint geoPoint = new GeoPoint();
            geoPoint.setLongitudeE6(b2.getInt("LLx"));
            geoPoint.setLatitudeE6(b2.getInt("LLy"));
            if (com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.b(new com.baidu.navisdk.module.nearbysearch.model.a(geoPoint)) == -1) {
                if (!f()) {
                    TipTool.onCreateToastDialog(this.f6529a, com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_add_via_exceeded));
                    return;
                }
                BNRoutePlaner.getInstance().t = 25;
                String a2 = aVar.a();
                if (TextUtils.equals("正在获取地址...", a2)) {
                    a2 = "地图上的点";
                }
                l.l().a(geoPoint, a2, 25, aVar.c());
            } else {
                BNRoutePlaner.getInstance().t = 25;
                l.l().a(geoPoint, 25);
            }
            this.d.d();
        }
    }

    @Override // com.baidu.navisdk.module.routeresultbase.logic.longdistance.d.InterfaceC0288d
    public void a(int i, boolean z, boolean z2) {
        LogUtil.out("LongDistanceNaviModel", "mLongDisCallback type is " + i + "," + z);
        if (z) {
            if (i == 1) {
                i();
                return;
            }
            if (i == 3) {
                h(z2);
                return;
            }
            if (i == 2) {
                j();
            } else {
                if (i != 4 || e.c()) {
                    return;
                }
                k();
            }
        }
    }

    @Override // com.baidu.navisdk.module.routeresultbase.logic.longdistance.d.InterfaceC0288d
    public void a(boolean z) {
        boolean b2 = this.b.b();
        if (LogUtil.LOGGABLE) {
            LogUtil.out("LongDistanceNaviModel", "onMeteorDataReady --> isFromMeteorArrive = " + z + ", canMeteorLayer = " + b2);
        }
        if (b2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.out("BNRouteResultManager", "onMeteorDataReady --> mCachedPassType = " + this.b.w + ", mBrightTitle = " + this.b.n);
            }
            if (e.c()) {
                if (this.b.w == 4) {
                    l();
                    return;
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.out("BNRouteResultManager", "onMeteorDataReady --> mPassSeriousMeteorArr = " + this.b.l().e);
                }
                com.baidu.nplatform.comapi.basestruct.c b3 = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.b(this.b.n);
                if (this.b.l().b(b3) == null) {
                    b3 = this.b.i();
                }
                this.b.a(b3);
                this.b.a(this.f6529a, b3);
            }
        }
    }

    public void a(Context context, int i) {
        this.b.a(context, i);
        c(this.b.v);
    }

    private void a(int i, String str) {
        if (i == -1 || TextUtils.isEmpty(str) || !this.b.i) {
            return;
        }
        g();
        if (i == 2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.c.a(17, str, BNRouteResultManager.f().d());
        } else if (i == 3) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.c.a(12, str, BNRouteResultManager.f().d());
        } else {
            if (i != 4 || TextUtils.isEmpty(str)) {
                return;
            }
            this.c.a(11, str, BNRouteResultManager.f().d());
        }
    }

    public void a(Bundle bundle) {
        if (bundle == null || bundle.getSerializable("item") == null) {
            return;
        }
        MapItem mapItem = (MapItem) bundle.getSerializable("item");
        com.baidu.navisdk.poisearch.view.controller.a aVar = this.d;
        if (aVar == null || mapItem == null) {
            return;
        }
        aVar.a((com.baidu.baidunavis.maplayer.d) null);
        this.d.d();
        com.baidu.navisdk.poisearch.view.model.a a2 = this.d.a();
        a2.a(new com.baidu.nplatform.comapi.basestruct.c(mapItem.mLongitudeMc, mapItem.mLatitudeMc));
        com.baidu.navisdk.module.nearbysearch.model.a aVar2 = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.e().get(mapItem.mItemID - 1);
        String name = aVar2.getName();
        if (TextUtils.isEmpty(name)) {
            name = "地图上的点";
        }
        a2.a(name);
        a2.b(aVar2.getUID());
        com.baidu.navisdk.poisearch.b.a();
        this.d.a(this.f6529a, a2, false, new b(), 1, true);
    }

    public void a() {
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar = this.b;
        if (dVar != null) {
            dVar.m();
            this.b = null;
        }
        com.baidu.navisdk.poisearch.view.controller.a aVar = this.d;
        if (aVar != null) {
            aVar.d();
            this.d = null;
        }
        this.f6529a = null;
        this.c = null;
    }
}
