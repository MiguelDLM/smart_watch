package com.baidu.navisdk.yellowbannerui.controller;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.mapframework.statistics.ControlLogStatistics;
import com.baidu.navisdk.comapi.mapcontrol.MapParams;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.bean.j;
import com.baidu.navisdk.framework.message.bean.s;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.module.routeresult.interfaces.a;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.facebook.FacebookSdkVersion;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Context f9444a;
    private ViewGroup b;
    private com.baidu.navisdk.yellowbannerui.view.a d;
    private com.baidu.navisdk.yellowbannerui.c e;
    private com.baidu.navisdk.yellowbannerui.interfaces.c g;
    private d h;

    @NonNull
    private final com.baidu.navisdk.yellowbannerui.interfaces.a n;
    private com.baidu.navisdk.yellowbannerui.interfaces.b c = null;
    private com.baidu.navisdk.util.worker.loop.a f = null;
    private int i = -1;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private int o = 0;
    private final c p = new c(this, null);

    /* loaded from: classes8.dex */
    public class a extends f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9445a;
        final /* synthetic */ boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, int i, boolean z) {
            super(str, str2);
            this.f9445a = i;
            this.b = z;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            b.this.c(this.f9445a, this.b);
            return null;
        }
    }

    /* renamed from: com.baidu.navisdk.yellowbannerui.controller.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC0516b extends com.baidu.navisdk.util.worker.loop.a {
        public HandlerC0516b() {
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteCarYBannerControl", "countTimesHandle --> msg = " + message + ", curRouteIndex = " + b.this.i);
            }
            if (message == null) {
                return;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteCarYBannerControl", "countTimesHandle --> routeCarYBannerDataManager = " + b.this.e);
            }
            if (b.this.e != null && b.this.e.e() != null) {
                int i = message.what;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                for (int i2 = 0; i2 < b.this.e.e().length; i2++) {
                                    b.this.e.e()[i2] = false;
                                }
                                b.this.a(false);
                                return;
                            }
                            return;
                        }
                        if (b.this.e.e().length >= 3) {
                            b.this.e.e()[2] = false;
                        }
                        if (b.this.i != 2) {
                            b.this.d(2);
                            return;
                        } else {
                            b.this.a(false);
                            return;
                        }
                    }
                    if (b.this.e.e().length >= 2) {
                        b.this.e.e()[1] = false;
                    }
                    if (b.this.i != 1) {
                        b.this.d(1);
                        return;
                    } else {
                        b.this.a(false);
                        return;
                    }
                }
                if (b.this.e.e().length >= 1) {
                    b.this.e.e()[0] = false;
                }
                if (b.this.i != 0) {
                    b.this.d(0);
                    return;
                } else {
                    b.this.a(false);
                    return;
                }
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteCarYBannerControl", "countTimesHandle --> routeCarYBannerDataManager or routeCarYBannerDataManager.getMainViewVisibleFlag() is null!!!");
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class c extends f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        private int f9447a;
        private boolean b;

        public /* synthetic */ c(b bVar, a aVar) {
            this();
        }

        private c() {
            super("RouteCarYBannerControl::informYBannerShow", null);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (b.this.i < 0 || b.this.i >= 3 || b.this.e == null || b.this.e.b(this.f9447a) == null || b.this.d == null || b.this.e.e() == null || !b.this.e.e()[this.f9447a]) {
                return null;
            }
            com.baidu.navisdk.yellowbannerui.view.params.a p = b.this.d.p();
            p.c(this.b);
            b.this.d.a(p);
            b.this.d.d(false);
            if (b.this.c == null) {
                return null;
            }
            b.this.c.b(true);
            return null;
        }
    }

    public b(Context context, com.baidu.navisdk.yellowbannerui.c cVar) {
        this.f9444a = context;
        this.e = cVar;
        this.n = cVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h() {
        int i = this.o;
        if (i != 1) {
            return i;
        }
        int h = this.e.h();
        int g = this.e.g();
        int i2 = 2;
        if (h != 2) {
            i2 = 3;
            if (h != 3) {
                if (g != 1) {
                    return 1;
                }
                return 4;
            }
        }
        return i2;
    }

    private void i() {
        this.f = new HandlerC0516b();
    }

    private boolean j() {
        if (!this.k && !this.l && !this.m) {
            return false;
        }
        return true;
    }

    private Handler k() {
        if (this.f == null) {
            i();
        }
        return this.f;
    }

    private void l() {
        k().removeMessages(4);
    }

    private void m() {
        int i;
        if (this.e != null && (i = this.i) >= 0 && i < 3) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteCarYBannerControl", "setRouteYBannerViewCountDownAndVisible --> isFutureTripCal = " + BNRoutePlaner.getInstance().y() + ", routeCarYBannerDataManager.isGlobalType = " + this.e.l() + ", routeCarYBannerDataManager.getMainViewVisibleFlag = " + Arrays.toString(this.e.e()) + ", routeCarYBannerDataManager.isGlobalType = " + this.e.l());
            }
            boolean z = true;
            if (this.e.l()) {
                c(true);
                return;
            }
            if (this.e.e() == null || !this.e.e()[this.i]) {
                z = false;
            }
            c(z);
        }
    }

    private void e(int i) {
        if (i == 0) {
            k().removeMessages(1);
        } else if (i == 1) {
            k().removeMessages(2);
        } else {
            if (i != 2) {
                return;
            }
            k().removeMessages(3);
        }
    }

    private void g() {
        com.baidu.navisdk.yellowbannerui.view.a aVar;
        if (this.e.l() || (aVar = this.d) == null) {
            return;
        }
        aVar.b(false);
        this.d = null;
    }

    public boolean b(int i) {
        LogUtil.e("RouteCarYBannerControl", "removeAllYBannerDataByGlobal --> globalTipType is " + i);
        if (!this.e.c(i)) {
            return false;
        }
        c(false);
        return true;
    }

    public ViewGroup c() {
        d();
        return this.b;
    }

    public void d() {
        if (this.b == null) {
            this.b = (ViewGroup) JarUtils.inflate(this.f9444a, R.layout.nsdk_layout_route_banner_yellow_tips_root_layout, null);
        }
    }

    public void f() {
        k().removeMessages(1);
        k().removeMessages(2);
        k().removeMessages(3);
        k().removeMessages(4);
    }

    public int a(int i) {
        com.baidu.navisdk.yellowbannerui.c cVar = this.e;
        if (cVar == null) {
            return -1;
        }
        return cVar.a(i);
    }

    public void c(int i) {
        a(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i, boolean z) {
        com.baidu.navisdk.yellowbannerui.interfaces.b bVar;
        LogUtil.e("RouteCarYBannerControl", "showRouteCarYBannerInMainThread() --> curRouteIndex = " + i);
        this.i = i;
        this.j = z;
        d();
        ViewGroup viewGroup = this.b;
        if (viewGroup != null && viewGroup.getParent() != null) {
            ((ViewGroup) this.b.getParent()).setVisibility(0);
        }
        this.e.d(this.i);
        com.baidu.navisdk.yellowtipdata.model.data.d b = this.e.b(i);
        if (b != null && b.c() != null) {
            g();
            if (this.e.j() != null && (bVar = this.c) != null && bVar.g() && this.e.n()) {
                b(b);
                d(b);
                c(b);
                return -2;
            }
            if (!this.e.k() && this.e.l()) {
                d(b);
                c(b);
                return -3;
            }
            LogUtil.e("RouteCarYBannerControl", "showRouteCarYBannerInMainThread() --> routeCarYBannerModel = " + b);
            a(b);
            int a2 = b.a();
            if (a2 == 35) {
                this.n.a(true);
            } else if (a2 == 55) {
                this.n.a(System.currentTimeMillis());
                com.baidu.navisdk.util.statistic.userop.b.r().a("2.h.7", "", null, null);
            }
            this.e.a(false);
            m();
            b(b);
            return 0;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteCarYBannerControl", "showRouteCarYBannerInMainThread --> cur route has not routeCarYBannerModel, force dismiss last yellow banner!!!");
        }
        b();
        return -1;
    }

    private void d(com.baidu.navisdk.yellowtipdata.model.data.d dVar) {
        com.baidu.navisdk.yellowbannerui.interfaces.b bVar;
        if (this.d != null) {
            this.d.a(dVar.c().b(), this.o == 1 && (bVar = this.c) != null && bVar.d());
        }
    }

    public void b() {
        com.baidu.navisdk.yellowbannerui.view.a aVar = this.d;
        if (aVar != null) {
            aVar.b(false);
            this.d = null;
        }
        com.baidu.navisdk.yellowbannerui.interfaces.b bVar = this.c;
        if (bVar != null) {
            bVar.b(false);
        }
    }

    public synchronized void e() {
        LogUtil.e("RouteCarYBannerControl", "reset --> yellow banner reset!");
        f();
    }

    public void a(int i, boolean z) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            b(i, z);
            return;
        }
        int c2 = c(i, z);
        g gVar = g.ROUTE_RESULT;
        if (gVar.d()) {
            gVar.e("RouteCarYBannerControl", "showRouteCarYBanner --> ret: " + c2);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements a.b {

        /* renamed from: a, reason: collision with root package name */
        private final com.baidu.navisdk.yellowbannerui.interfaces.b f9448a;
        private final com.baidu.navisdk.yellowbannerui.c b;
        private com.baidu.navisdk.yellowtipdata.model.data.d c;

        public d(com.baidu.navisdk.yellowbannerui.interfaces.b bVar, com.baidu.navisdk.yellowbannerui.c cVar) {
            this.f9448a = bVar;
            this.b = cVar;
        }

        private void b(@NonNull com.baidu.navisdk.yellowtipdata.model.data.d dVar, int i) {
            if (TextUtils.isEmpty(dVar.c().d())) {
                return;
            }
            s sVar = new s(1);
            Bundle bundle = new Bundle();
            boolean z = i == 1;
            bundle.putBoolean("has_bottom_panel_anim", z);
            bundle.putBoolean("has_bottom_panel_close_btn", z);
            bundle.putBoolean("has_top_left_back_btn", !z);
            com.baidu.navisdk.framework.message.a.a().a(sVar);
        }

        private void c(@NonNull com.baidu.navisdk.yellowtipdata.model.data.d dVar, int i) {
            String k = dVar.c().k();
            if (LogUtil.LOGGABLE) {
                TipTool.onCreateDebugToast(b.this.f9444a, "通行证类型的限行黄条");
                LogUtil.e("RouteCarYBannerControl", "YELLOW_PERMIT_LIMIT permitInfoId:" + k);
            }
            if (TextUtils.isEmpty(k)) {
                return;
            }
            s sVar = new s(1);
            Bundle bundle = new Bundle();
            boolean z = i == 1;
            bundle.putBoolean("has_bottom_panel_anim", z);
            bundle.putBoolean("has_bottom_panel_close_btn", z);
            bundle.putBoolean("has_top_left_back_btn", !z);
            com.baidu.navisdk.framework.message.a.a().a(sVar);
        }

        private void d() {
            com.baidu.navisdk.yellowbannerui.interfaces.b bVar = this.f9448a;
            if (bVar != null) {
                bVar.m();
            }
        }

        private void e() {
            com.baidu.navisdk.yellowbannerui.interfaces.b bVar = this.f9448a;
            if (bVar != null) {
                bVar.j();
            }
        }

        private void f() {
            com.baidu.navisdk.yellowbannerui.interfaces.b bVar = this.f9448a;
            if (bVar != null) {
                bVar.b();
            }
        }

        private void g() {
            if (this.c == null) {
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.h.6", null, null, null);
            com.baidu.navisdk.framework.message.a.a().a(new j(0));
            b.this.n.d(false);
            b.this.b(false);
            this.b.c(true);
            this.f9448a.i();
        }

        private void h() {
            com.baidu.navisdk.yellowbannerui.interfaces.b bVar = this.f9448a;
            if (bVar != null) {
                bVar.c();
            }
        }

        private void i() {
            ControlLogStatistics.getInstance().addLog("CarRouteDMapPG.localPlateSetting");
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.d", "2", null, null);
            if (!TextUtils.isEmpty(b.this.n.d())) {
                b.this.n.d(true);
            }
            if (!TextUtils.isEmpty(b.this.n.d())) {
                b.this.n.d(true);
                com.baidu.navisdk.yellowbannerui.interfaces.b bVar = this.f9448a;
                if (bVar != null) {
                    bVar.i();
                    return;
                }
                return;
            }
            com.baidu.navisdk.yellowbannerui.interfaces.b bVar2 = this.f9448a;
            if (bVar2 != null) {
                if (bVar2.l()) {
                    this.f9448a.h();
                } else {
                    this.f9448a.a(true);
                    com.baidu.navisdk.framework.b.g(b.this.n.f());
                }
            }
        }

        @Override // com.baidu.navisdk.module.routeresult.interfaces.a.b
        public void a(com.baidu.navisdk.module.routeresult.interfaces.a aVar, int i, Object... objArr) {
            Object obj;
            if (objArr == null || objArr.length == 0 || !(objArr[0] instanceof com.baidu.navisdk.yellowtipdata.model.data.d)) {
                return;
            }
            if (com.baidu.navisdk.ui.util.f.a(300L)) {
                g gVar = g.ROUTE_RESULT;
                if (gVar.b()) {
                    gVar.b("RouteCarYBannerControl", "onClick --> yellow banner click,fast click, return");
                    return;
                }
                return;
            }
            this.c = (com.baidu.navisdk.yellowtipdata.model.data.d) objArr[0];
            int intValue = (objArr.length <= 1 || (obj = objArr[1]) == null || !(obj instanceof Integer)) ? 0 : ((Integer) obj).intValue();
            g gVar2 = g.ROUTE_RESULT;
            if (gVar2.b()) {
                gVar2.b("RouteCarYBannerControl", "yellow banner click: what is " + i + ",invokeSource:" + intValue);
            }
            switch (i) {
                case 1:
                    com.baidu.navisdk.util.statistic.userop.b.r().a(FacebookSdkVersion.BUILD, b.this.h() + "", this.c.a() + "");
                    a();
                    return;
                case 2:
                    com.baidu.navisdk.util.statistic.userop.b.r().a("14.1.3", b.this.h() + "", this.c.a() + "");
                    a(aVar, intValue);
                    return;
                case 3:
                    a(0);
                    return;
                case 4:
                    a(1);
                    return;
                case 5:
                    a(2);
                    return;
                case 6:
                    com.baidu.navisdk.util.statistic.userop.b.r().a("14.1.2", b.this.h() + "", this.c.a() + "");
                    a(this.c.c().c(), aVar, intValue);
                    return;
                case 7:
                    a((com.baidu.navisdk.yellowtipdata.model.data.a) objArr[2], aVar, intValue);
                    return;
                default:
                    return;
            }
        }

        private void b() {
            com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
            String i = fVar.i();
            String k = this.c.c().k();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteCarYBannerControl", "clickPermitLimitButton(), totalPermitInfoIds=" + i + ", currentPermitInfoId=" + k);
            }
            if (TextUtils.isEmpty(k)) {
                return;
            }
            if (TextUtils.isEmpty(i)) {
                i = k;
            } else if (!l0.a(i.split(","), k)) {
                i = k + "," + i;
            }
            fVar.a(i);
            this.f9448a.a(i);
        }

        private void c() {
            if (this.f9448a != null) {
                Bundle bundle = new Bundle();
                com.baidu.navisdk.yellowtipdata.model.data.g c = this.c.c();
                if (c != null) {
                    bundle.putInt("yellow_id", c.i());
                    bundle.putString("event_id", c.f());
                    bundle.putInt(MapParams.PanoramaKeys.EVENT_TYPE, c.g());
                    bundle.putBoolean("is_jump_flag", c.p());
                    bundle.putBoolean("is_panel_flag", c.q());
                    bundle.putInt("road_no", c.l());
                    this.f9448a.a(bundle);
                }
            }
        }

        private void a() {
            if (com.baidu.navisdk.ui.util.g.a()) {
                LogUtil.e("RouteCarYBannerControl", "clickCloseButton --> double click close button");
                return;
            }
            if (this.c == null) {
                return;
            }
            b.this.a(true);
            com.baidu.navisdk.yellowbannerui.interfaces.b bVar = this.f9448a;
            if (bVar != null) {
                bVar.b(this.c.a(), this.c);
            }
        }

        private void a(com.baidu.navisdk.module.routeresult.interfaces.a aVar, int i) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.h.3", this.c.a() + "", "0", null);
            a(this.c);
        }

        private void a(com.baidu.navisdk.yellowtipdata.model.data.a aVar, com.baidu.navisdk.module.routeresult.interfaces.a aVar2, int i) {
            if (this.c == null) {
                g gVar = g.ROUTE_RESULT;
                if (gVar.d()) {
                    gVar.e("RouteCarYBannerControl", "clickYellowBannerNew routeCarYBannerModel is null");
                    return;
                }
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.h.3", this.c.a() + "", null, "0");
            int a2 = aVar.a();
            if (a2 == 1) {
                String c = aVar.c();
                if (TextUtils.isEmpty(c)) {
                    return;
                }
                com.baidu.navisdk.framework.b.e(c);
                return;
            }
            if (a2 == 2) {
                a(this.c, 0);
                return;
            }
            if (a2 != 3) {
                if (a2 == 4) {
                    a(this.c);
                    return;
                } else {
                    if (a2 != 5) {
                        return;
                    }
                    a(aVar, this.c, i, aVar2);
                    return;
                }
            }
            String c2 = aVar.c();
            if (TextUtils.isEmpty(c2)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("openapi", c2);
            com.baidu.navisdk.framework.b.a(32, bundle);
        }

        private void a(com.baidu.navisdk.yellowtipdata.model.data.a aVar, @NonNull com.baidu.navisdk.yellowtipdata.model.data.d dVar, int i, com.baidu.navisdk.module.routeresult.interfaces.a aVar2) {
            com.baidu.navisdk.yellowbannerui.interfaces.b bVar;
            String c = aVar.c();
            if (g.PRO_NAV.b()) {
                TipTool.onCreateDebugToast(b.this.f9444a, "JUMP:" + c);
            }
            c.hashCode();
            char c2 = 65535;
            switch (c.hashCode()) {
                case -1855597447:
                    if (c.equals("gotoCarLimitPage")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1726138249:
                    if (c.equals("pushUgcDetailPage")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1539355826:
                    if (c.equals("gotoFavoritePage")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1510903063:
                    if (c.equals("localSetCarNum")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1500398804:
                    if (c.equals("gotoPermitLimitPage")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1243947965:
                    if (c.equals("localEvadeRoute")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -633407616:
                    if (c.equals("referenceCallRoute")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -58343378:
                    if (c.equals("refreshRoute")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 9330400:
                    if (c.equals("pushExplainOrUgcPage")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 291705830:
                    if (c.equals("gotoEtaTab")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 504542633:
                    if (c.equals("gotoVehiclePassPage")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case 1378477834:
                    if (c.equals("enterRoadPredictionMode")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 1653568523:
                    if (c.equals("quickClose")) {
                        c2 = '\f';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    b(dVar, i);
                    return;
                case 1:
                    c();
                    return;
                case 2:
                    d();
                    return;
                case 3:
                    i();
                    return;
                case 4:
                    c(dVar, i);
                    return;
                case 5:
                    a(dVar, i, aVar2);
                    return;
                case 6:
                    b();
                    return;
                case 7:
                    h();
                    return;
                case '\b':
                    com.baidu.navisdk.yellowbannerui.interfaces.b bVar2 = this.f9448a;
                    if (bVar2 != null && bVar2.e()) {
                        a(dVar);
                        return;
                    } else {
                        c();
                        return;
                    }
                case '\t':
                    if (!com.baidu.navisdk.framework.b.N() || (bVar = this.f9448a) == null) {
                        return;
                    }
                    bVar.k();
                    return;
                case '\n':
                    e();
                    return;
                case 11:
                    com.baidu.navisdk.util.statistic.userop.b.r().a("2.x.1.1", "3", null, null);
                    f();
                    return;
                case '\f':
                    g();
                    return;
                default:
                    return;
            }
        }

        private void a(@NonNull com.baidu.navisdk.yellowtipdata.model.data.d dVar, int i, com.baidu.navisdk.module.routeresult.interfaces.a aVar) {
            s sVar = new s(1);
            Bundle bundle = new Bundle();
            boolean z = i == 1;
            bundle.putBoolean("has_bottom_panel_anim", z);
            bundle.putBoolean("has_bottom_panel_close_btn", z);
            bundle.putBoolean("has_top_left_back_btn", !z);
            com.baidu.navisdk.framework.message.a.a().a(sVar);
        }

        private void a(int i) {
            com.baidu.navisdk.yellowtipdata.model.data.d dVar;
            if (this.f9448a == null || (dVar = this.c) == null || dVar.c() == null || this.c.c().j() == null || i < 0 || i >= this.c.c().j().size()) {
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.h.3", this.c.a() + "", this.c.c().j().size() + "", null);
            LogUtil.e("RouteCarYBannerControl", "clickEndRecommendButton --> position is " + i);
            a(this.c, i);
        }

        private void a(@NonNull com.baidu.navisdk.yellowtipdata.model.data.d dVar) {
            com.baidu.navisdk.yellowbannerui.interfaces.b bVar = this.f9448a;
            if (bVar != null) {
                bVar.f();
            }
        }

        private void a(@NonNull com.baidu.navisdk.yellowtipdata.model.data.d dVar, int i) {
            com.baidu.navisdk.yellowtipdata.model.data.b bVar;
            com.baidu.navisdk.yellowtipdata.model.data.g c = dVar.c();
            if (c == null) {
                return;
            }
            Bundle bundle = new Bundle();
            if (dVar.a() == 39) {
                bundle.putBoolean("restore_dest_cal", true);
            }
            List<com.baidu.navisdk.yellowtipdata.model.data.b> j = c.j();
            if (j == null || j.size() <= i || i < 0 || (bVar = j.get(i)) == null || this.f9448a == null) {
                return;
            }
            RoutePlanNode a2 = com.baidu.navisdk.yellowtipdata.model.data.b.f.a(bVar);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteCarYBannerControl", "changeDest --> routePlanNode = " + a2);
            }
            if (a2 == null) {
                return;
            }
            this.f9448a.a(a2, bundle);
        }
    }

    private void b(int i, boolean z) {
        com.baidu.navisdk.util.worker.c.a().a((f) new a("showRouteCarYBannerInChildThread-" + b.class.getSimpleName(), null, i, z), new e(1, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(int i) {
        try {
            com.baidu.navisdk.yellowbannerui.c cVar = this.e;
            if (cVar == null) {
                return;
            }
            com.baidu.navisdk.yellowtipdata.model.data.d b = cVar.b(i);
            if (b != null && !b.g()) {
                this.e.b()[i] = null;
            } else if (this.e.c() != null && i >= 0 && i < this.e.c().length && !this.e.c()[i]) {
                this.e.c()[i] = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(int i, String str, int i2) {
        a(i, str, i2, this.j);
    }

    public void a(int i, String str, int i2, boolean z) {
        if (j()) {
            LogUtil.e("RouteCarYBannerControl", "handleYBannerDataFromHalfway --> isBackFromXXNavi");
            return;
        }
        this.i = i2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteCarYBannerControl", "handleYBannerDataFromHalfway --> tipType is " + i + ", title is " + str);
        }
        this.e.a(i, str);
        f();
        if (LogUtil.LOGGABLE && this.f9444a != null) {
            com.baidu.navisdk.yellowtipdata.model.data.d b = this.e.b(0);
            com.baidu.navisdk.yellowtipdata.model.data.d b2 = this.e.b(1);
            com.baidu.navisdk.yellowtipdata.model.data.d b3 = this.e.b(2);
            StringBuilder sb = new StringBuilder();
            sb.append("handleYBannerDataFromHalfway --> 筛完小黄条type --------------------------------\n第一条路线：");
            sb.append(b == null ? "null" : Integer.valueOf(b.a()));
            sb.append("\n第二条路线：");
            sb.append(b2 == null ? "null" : Integer.valueOf(b2.a()));
            sb.append("\n第三条路线：");
            sb.append(b3 != null ? Integer.valueOf(b3.a()) : "null");
            LogUtil.e("RouteCarYBannerControl", sb.toString());
        }
        a(this.i, z);
    }

    private void b(com.baidu.navisdk.yellowtipdata.model.data.d dVar) {
        com.baidu.navisdk.yellowbannerui.c cVar = this.e;
        if (cVar == null || cVar.m() || dVar == null || dVar.c() == null) {
            return;
        }
        com.baidu.navisdk.yellowbannerui.interfaces.b bVar = this.c;
        if (bVar != null) {
            bVar.a(dVar.a(), dVar);
        }
        this.e.b(true);
        com.baidu.navisdk.util.statistic.userop.b.r().a("2.h.1", dVar.a() + "", null, null);
        if (dVar.a() == 3 && "1".equals(dVar.c().a())) {
            if (this.e.f() == null) {
                this.e.a(dVar.c().e());
            }
            if (this.e.f() != null && !this.e.f().equals(dVar.c().e())) {
                this.e.a(dVar.c().e());
                this.e.e(1);
            } else {
                this.e.e(this.e.d() + 1);
            }
            this.n.a(this.e.d(), this.e.f());
        }
    }

    public void a() {
        LogUtil.e("RouteCarYBannerControl", "destroy --> yellow banner destroy!");
        com.baidu.navisdk.yellowbannerui.c cVar = this.e;
        if (cVar != null) {
            this.n.a(cVar.d(), this.e.f());
        }
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.p, true);
        f();
        e();
        c(false);
        com.baidu.navisdk.yellowbannerui.view.a aVar = this.d;
        if (aVar != null) {
            aVar.b(false);
        }
        this.e = null;
        this.b = null;
        this.c = null;
        this.f = null;
    }

    public void b(boolean z) {
        a(z, false, true);
    }

    private void c(com.baidu.navisdk.yellowtipdata.model.data.d dVar) {
        com.baidu.navisdk.yellowbannerui.view.a aVar = this.d;
        if (aVar == null) {
            return;
        }
        com.baidu.navisdk.yellowbannerui.view.params.a p = aVar.p();
        p.a(a(this.i));
        p.c(this.j);
        this.d.a(p);
    }

    private void c(boolean z) {
        g gVar = g.ROUTE_RESULT;
        if (gVar.d()) {
            gVar.e("RouteCarYBannerControl", "setYBannerViewVisible --> show = " + z + ", routeCarYBannerBaseView = " + this.d + ", mainView = " + this.b);
        }
        if (this.d == null || this.b == null) {
            return;
        }
        if (this.e.e() != null) {
            int length = this.e.e().length;
            int i = this.i;
            if (length > i && i >= 0) {
                this.e.e()[this.i] = z;
            }
        }
        if (z) {
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("setYBannerViewVisible --> mYBannerViewChange = ");
                sb.append(this.c);
                sb.append(", mYBannerViewChange.isViewAllStatus = ");
                com.baidu.navisdk.yellowbannerui.interfaces.b bVar = this.c;
                sb.append(bVar != null && bVar.a());
                sb.append(", routeCarYBannerBaseView.isShowing = ");
                sb.append(this.d.g());
                gVar.e("RouteCarYBannerControl", sb.toString());
            }
            com.baidu.navisdk.yellowbannerui.interfaces.b bVar2 = this.c;
            if (bVar2 == null || bVar2.a() || this.d.g()) {
                return;
            }
            if (gVar.d()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("setYBannerViewVisible --> showRouteCarYBannerBaseView isHasAnim = ");
                sb2.append(this.o == 1);
                gVar.e("RouteCarYBannerControl", sb2.toString());
            }
            this.d.d(true);
            this.c.b(true);
            return;
        }
        if (this.d.g()) {
            if (gVar.d()) {
                gVar.e("RouteCarYBannerControl", "setYBannerViewVisible --> hideRouteCarYBannerBaseView");
            }
            this.d.c(this.e.o() != null && this.e.o().f());
            this.c.b(false);
        }
    }

    private void a(com.baidu.navisdk.yellowtipdata.model.data.d dVar) {
        com.baidu.navisdk.yellowbannerui.view.params.a aVar = new com.baidu.navisdk.yellowbannerui.view.params.a();
        aVar.b((ViewGroup) null);
        aVar.a(this.b);
        aVar.a(this.c.isLongDistance());
        aVar.a(dVar);
        aVar.a(this.h);
        aVar.b(this.o);
        aVar.a(a(this.i));
        boolean z = false;
        if (this.o == 1) {
            aVar.c(this.j);
        } else {
            aVar.c(false);
        }
        if (this.e.i() == null) {
            if (this.o == 1 && this.c.d()) {
                z = true;
            }
            aVar.b(z);
            com.baidu.navisdk.yellowbannerui.view.a a2 = com.baidu.navisdk.yellowbannerui.view.c.a(this.f9444a, aVar);
            this.d = a2;
            if (a2 == null) {
                LogUtil.e("RouteCarYBannerControl", "getRouteYBannerView --> routeCarYBannerBaseView is null");
                return;
            }
            a2.f();
            com.baidu.navisdk.util.statistic.userop.b.r().a("14.1.0", h() + "", dVar.a() + "");
            return;
        }
        this.e.i().a(dVar.a());
        throw null;
    }

    public void a(com.baidu.navisdk.yellowbannerui.interfaces.b bVar) {
        this.c = bVar;
    }

    public void a(boolean z) {
        a(z, false, false);
    }

    public synchronized void a(boolean z, boolean z2, boolean z3) {
        int i;
        int i2;
        int i3;
        try {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteCarYBannerControl", "dismissCurTips --> isByClick = " + z + " isByClickUgc = " + z2 + " isForceHasNoAnim = " + z3 + " routeCarYBannerDataManager = " + this.e);
            }
            com.baidu.navisdk.yellowbannerui.c cVar = this.e;
            if (cVar == null) {
                return;
            }
            com.baidu.navisdk.yellowtipdata.model.data.d o = cVar.o();
            if (z && o != null) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("2.h.2", o.a() + "", null, null);
            }
            com.baidu.navisdk.yellowbannerui.interfaces.c cVar2 = this.g;
            if (cVar2 != null && !z2) {
                cVar2.a(z);
            }
            if (this.e.b() != null && this.i < this.e.b().length && this.i >= 0) {
                this.e.b()[this.i] = null;
            }
            if (o != null && !o.g()) {
                c(false);
            } else {
                ViewGroup viewGroup = this.b;
                if (viewGroup != null && this.d != null && viewGroup.getVisibility() == 0) {
                    if (this.b.isShown()) {
                        this.d.c((o == null || !o.f() || j() || z3) ? false : true);
                    } else {
                        this.d.c(false);
                    }
                }
                if (this.e.l()) {
                    if (this.e.c() != null && (i3 = this.i) >= 0 && i3 < this.e.c().length && !this.e.c()[this.i]) {
                        Arrays.fill(this.e.c(), true);
                    }
                    if (this.e.e() != null) {
                        for (int i4 = 0; i4 < this.e.e().length; i4++) {
                            this.e.e()[i4] = false;
                        }
                    }
                    l();
                } else {
                    if (this.e.c() != null && (i2 = this.i) >= 0 && i2 < this.e.c().length && !this.e.c()[this.i]) {
                        this.e.c()[this.i] = true;
                    }
                    if (this.e.e() != null && (i = this.i) >= 0 && i < this.e.e().length) {
                        this.e.e()[this.i] = false;
                    }
                    e(this.i);
                }
            }
            com.baidu.navisdk.yellowbannerui.interfaces.b bVar = this.c;
            if (bVar != null) {
                bVar.b(false);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public d a(com.baidu.navisdk.yellowbannerui.interfaces.b bVar, com.baidu.navisdk.yellowbannerui.c cVar) {
        d dVar = new d(bVar, cVar);
        this.h = dVar;
        return dVar;
    }
}
