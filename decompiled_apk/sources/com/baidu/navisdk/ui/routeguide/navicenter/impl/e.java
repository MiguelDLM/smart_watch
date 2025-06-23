package com.baidu.navisdk.ui.routeguide.navicenter.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.pronavi.k;
import com.baidu.navisdk.framework.interfaces.pronavi.m;
import com.baidu.navisdk.framework.interfaces.pronavi.o;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.control.r;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.navicenter.BNavigatorLogic;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public abstract class e implements com.baidu.navisdk.framework.interfaces.pronavi.c {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<BNavigatorLogic> f9070a;

    /* loaded from: classes8.dex */
    public class a extends c {
        public a(e eVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.navicenter.impl.c
        public boolean a() {
            return true;
        }
    }

    public e(BNavigatorLogic bNavigatorLogic) {
        this.f9070a = new WeakReference<>(bNavigatorLogic);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    @Nullable
    public k A() {
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j != null) {
            return j.k();
        }
        return null;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean B() {
        return com.baidu.navisdk.module.newguide.a.e().d();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean C() {
        return com.baidu.navisdk.module.newguide.a.e().d();
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.g D() {
        return new a(this);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public void a(o oVar) {
        com.baidu.navisdk.ui.routeguide.b.V().a(oVar);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public Activity b() {
        return com.baidu.navisdk.ui.routeguide.b.V().b();
    }

    public boolean c(int i) {
        return i == 2 || i == 3;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public void d() {
        com.baidu.navisdk.ui.routeguide.b.V().Q();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public void e(boolean z) {
        if (this.f9070a.get() != null) {
            this.f9070a.get().f(z);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public void f(boolean z) {
        com.baidu.navisdk.ui.routeguide.asr.c.n().b(1, z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean g() {
        LogUtil.e("BaseProNaviImpl", "offlineToOnline ->");
        BNRouteGuider.getInstance().calcOtherRoute(2);
        return true;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public String h() {
        return a0.I().d();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public void i() {
        if (this.f9070a.get() != null) {
            this.f9070a.get().v0();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean j() {
        return com.baidu.navisdk.ui.routeguide.asr.c.n().a(1);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public void k() {
        if (this.f9070a.get() != null) {
            this.f9070a.get().i();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public void l() {
        if (this.f9070a.get() != null) {
            this.f9070a.get().z0();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean m() {
        return com.baidu.navisdk.ui.routeguide.utils.b.x();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public void n() {
        if (this.f9070a.get() != null) {
            this.f9070a.get().q0();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean o() {
        return com.baidu.navisdk.ui.routeguide.asr.c.n().a(1);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean p() {
        return a0.I().u();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public String q() {
        return RouteGuideFSM.getInstance().getLatestMap2DOr3DState();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public Bundle r() {
        return a0.I().h();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public Bundle s() {
        return a0.I().k();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public int t() {
        return a0.I().m();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public void u() {
        com.baidu.navisdk.ui.routeguide.asr.c.n().a();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public void v() {
        if (this.f9070a.get() != null) {
            this.f9070a.get().w0();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public Bitmap w() {
        return com.baidu.navisdk.ui.routeguide.mapmode.a.o5().O();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public int x() {
        return a0.I().l();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public void y() {
        if (this.f9070a.get() != null) {
            this.f9070a.get().A0();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    @Nullable
    public m z() {
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j != null) {
            return j.m();
        }
        return null;
    }

    private boolean d(int i) {
        com.baidu.navisdk.ui.routeguide.b.V().h().j().e("BNVoiceService").a(1).a(Integer.valueOf(i)).a();
        return true;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean a(Bundle bundle) {
        return com.baidu.navisdk.ui.routeguide.b.V().b(bundle);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public void b(int i, boolean z) {
        com.baidu.navisdk.ui.routeguide.b.V().b(i, z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean c() {
        LogUtil.e("BaseProNaviImpl", "refreshRoute ->");
        BNRouteGuider.getInstance().calcOtherRoute(2, 1);
        return true;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public int f() {
        return com.baidu.navisdk.ui.routeguide.b.V().q();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean a(boolean z) {
        BNMapController bNMapController = BNMapController.getInstance();
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        GeoPoint geoPosByScreenPos = bNMapController.getGeoPosByScreenPos(aVar.e() / 2, aVar.d() / 2);
        com.baidu.navisdk.model.datastruct.f a2 = (geoPosByScreenPos != null && com.baidu.navisdk.j.d() && BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) ? com.baidu.navisdk.poisearch.c.a(geoPosByScreenPos, 0) : null;
        Context a3 = com.baidu.navisdk.framework.a.c().a();
        boolean isRoadCondOnOrOff = BNCommSettingManager.getInstance().isRoadCondOnOrOff();
        if (!z || isRoadCondOnOrOff) {
            if (!z && isRoadCondOnOrOff) {
                BNMapController.getInstance().showTrafficMap(false);
                BNCommSettingManager.getInstance().setRoadCondOnOff(false);
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BaseProNaviImpl", "setRoadConditionEnable showTrafficMap false");
                }
                if (com.baidu.navisdk.j.d()) {
                    TipTool.onCreateToastDialog(a3, com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_its_is_off));
                }
            }
        } else if (BNCommSettingManager.getInstance().isNaviRealHistoryITS()) {
            if (BNCommSettingManager.getInstance().isFirstItsOn() && !y.b(a3, 1)) {
                BNCommSettingManager.getInstance().setFirstItsOn(false);
                if (com.baidu.navisdk.j.d()) {
                    x.b().R3();
                }
            }
            if (y.d(a3)) {
                BNMapController.getInstance().showTrafficMap(true);
                BNCommSettingManager.getInstance().setRoadCondOnOff(true);
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BaseProNaviImpl", "setRoadConditionEnable showTrafficMap true");
                }
                if (a2 != null && !BNMapController.getInstance().checkRoadConditionSupport(a2.b)) {
                    TipTool.onCreateToastDialog(a3, JarUtils.getResources().getString(R.string.nsdk_string_its_online_missing_data));
                } else {
                    if (com.baidu.navisdk.j.d()) {
                        TipTool.onCreateToastDialog(a3, com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_its_real_is_on));
                    }
                    return true;
                }
            } else {
                TipTool.onCreateToastDialog(a3, com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_its_real_offline));
            }
        }
        return true;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean b(int i) {
        if (i == 1 || i == 0 || i == 7 || i == 6) {
            BNCommSettingManager.getInstance().setDiyVoiceMode(i);
            com.baidu.navisdk.ui.routeguide.b.V().T();
        }
        return true;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean e() {
        return com.baidu.navisdk.ui.routeguide.b.V().p();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public void g(boolean z) {
        com.baidu.navisdk.ui.routeguide.b.V().c(z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public void b(boolean z) {
        com.baidu.navisdk.ui.routeguide.asr.c.n().a(1, z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public void d(boolean z) {
        com.baidu.navisdk.ui.routeguide.b.V().e(z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean a(int i) {
        return d(i);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public void a(int i, com.baidu.navisdk.framework.interfaces.pronavi.g gVar) {
        if (gVar == null) {
            gVar = D();
        }
        new com.baidu.navisdk.ui.routeguide.routeplan.a().a(i, gVar);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean a(RoutePlanNode routePlanNode, int i) {
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("changeDestByOnline -> endNode=");
            sb.append(routePlanNode != null ? routePlanNode.toString() : null);
            sb.append(", entry= ");
            sb.append(i);
            LogUtil.e("BaseProNaviImpl", sb.toString());
        }
        return a(routePlanNode, i, 1);
    }

    private boolean a(RoutePlanNode routePlanNode, int i, int i2) {
        try {
            if (com.baidu.navisdk.ui.routeguide.b.W()) {
                return l.l().a(routePlanNode, i, i2);
            }
            return false;
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("changeDestImpl -> ", e);
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean a(String str, ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add(str);
        if (arrayList == null || arrayList.size() == 0) {
            arrayList = new ArrayList<>();
            arrayList.add(e0.a(b().getApplicationContext()).a(str, ""));
        }
        return r.i().a(arrayList2, arrayList, 20, !com.baidu.navisdk.j.d() ? 2 : 0);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public void a(int i, boolean z) {
        com.baidu.navisdk.ui.routeguide.asr.c.n().b(i, z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.i
    public boolean a() {
        return com.baidu.navisdk.ui.routeguide.asr.c.n().h();
    }
}
