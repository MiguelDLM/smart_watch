package com.baidu.navisdk.comapi.routeplan;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.navisdk.comapi.routeplan.e;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.widget.BNBaseDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.common.z;
import com.baidu.navisdk.util.listener.NetworkListener;
import com.baidu.navisdk.util.statistic.o;
import com.baidu.navisdk.util.statistic.s;
import com.baidu.navisdk.util.statistic.t;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class BNRoutePlaner extends com.baidu.navisdk.comapi.routeplan.v2.e {
    private static boolean A = false;
    public static RoutePlanNode B = null;
    public static int C = 0;
    public static boolean D = false;
    private static g E;
    private static g F;
    private static volatile BNRoutePlaner z;
    public int t;
    private final com.baidu.navisdk.util.worker.loop.d v;
    private Handler w;
    private final com.baidu.navisdk.util.worker.loop.a x;
    private f y;
    private int s = 1;
    public RoutePlanNode u = null;

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.d {
        public a() {
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(4099);
            observe(4400);
            observe(4170);
            observe(4173);
            observe(4403);
            observe(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE);
            observe(4175);
            observe(4209);
            observe(4115);
            observe(4418);
            observe(4449);
            observe(4525);
        }

        @Override // com.baidu.navisdk.util.worker.loop.d
        public void onMessage(Message message) {
            int i;
            com.baidu.navisdk.comapi.routeplan.v2.d dVar;
            int i2;
            com.baidu.navisdk.comapi.routeplan.v2.d c;
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RoutePlan", "baidu_navi_route_plan_handler: msg.what = " + message.what + ", msg.arg1 = " + message.arg1 + ", msg.arg2 = " + message.arg2 + ", msg.obj = " + message.obj);
            }
            switch (message.what) {
                case 4099:
                    t.u().a(Long.valueOf(System.currentTimeMillis()));
                    BNRoutePlaner.this.a(message);
                    return;
                case 4115:
                    BNRoutePlaner.this.a((com.baidu.navisdk.comapi.routeplan.v2.d) null, 145, message.arg1);
                    if (LogUtil.LOGGABLE && 3 == message.arg1) {
                        SDKDebugFileUtil.get(SDKDebugFileUtil.RoutePlan_FILENAME).add(" msg.arg1 = " + message.arg1 + " ||| msg.arg2 = " + message.arg2 + " msg.what=" + message.what);
                        return;
                    }
                    return;
                case 4170:
                    if (BNRoutePlaner.this.w != null) {
                        Message obtainMessage = BNRoutePlaner.this.w.obtainMessage();
                        obtainMessage.what = 4170;
                        BNRoutePlaner.this.w.dispatchMessage(obtainMessage);
                    }
                    if (BNRoutePlaner.F != null) {
                        BNRoutePlaner.F.a(4170, 0, 0, null);
                        g unused = BNRoutePlaner.F = null;
                    }
                    com.baidu.navisdk.comapi.routeplan.f.c(null, 18);
                    BNRoutePlaner.this.a((com.baidu.navisdk.comapi.routeplan.v2.d) null, 18, message.arg1);
                    BNRoutePlaner.this.a(1, 2, (Object) null);
                    LogUtil.e("RoutePlan", "MSG_NAVI_Success_BuildGuideRoute msg.arg1 = " + message.arg1 + " ||| msg.arg2 = " + message.arg2);
                    if (BNRoutePlaner.this.e() == 2 || BNRoutePlaner.this.e() == 0) {
                        com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410371", "410371");
                        if ((BNRoutePlaner.this.b() & 64) > 0) {
                            com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410372", "410372");
                        }
                    }
                    if (LogUtil.LOGGABLE) {
                        SDKDebugFileUtil.get(SDKDebugFileUtil.RoutePlan_FILENAME).add(" msg.arg1 = " + message.arg1 + " ||| msg.arg2 = " + message.arg2 + " msg.what=" + message.what);
                        return;
                    }
                    return;
                case 4173:
                    BNRoutePlaner.this.a((com.baidu.navisdk.comapi.routeplan.v2.d) null, 19, message.arg1);
                    if (BNRoutePlaner.this.w != null) {
                        Message obtainMessage2 = BNRoutePlaner.this.w.obtainMessage();
                        obtainMessage2.what = 4173;
                        BNRoutePlaner.this.w.dispatchMessage(obtainMessage2);
                    }
                    if (BNRoutePlaner.F != null) {
                        BNRoutePlaner.F.a(4173, 0, 0, null);
                        g unused2 = BNRoutePlaner.F = null;
                    }
                    BNRoutePlaner.this.a(1, 3, (Object) null);
                    LogUtil.e("RoutePlan", "MSG_NAVI_Fail_BuildGuideRoute msg.arg1 = " + message.arg1 + " ||| msg.arg2 = " + message.arg2);
                    try {
                        t.u().g(501);
                    } catch (ConcurrentModificationException e) {
                        if (LogUtil.LOGGABLE) {
                            e.printStackTrace();
                        }
                    }
                    if (LogUtil.LOGGABLE) {
                        SDKDebugFileUtil.get(SDKDebugFileUtil.RoutePlan_FILENAME).add(" msg.arg1 = " + message.arg1 + " ||| msg.arg2 = " + message.arg2 + " msg.what=" + message.what);
                        return;
                    }
                    return;
                case 4175:
                    com.baidu.navisdk.util.common.g.ROUTE_PLAN.a("CancelRoute MSG_NAVI_KeyWordResult arg1 :" + message.arg1 + " arg2 :" + message.arg2);
                    com.baidu.navisdk.skyeye.a.n().c();
                    t.u().l();
                    ArrayList<Bundle> arrayList = new ArrayList<>();
                    Bundle bundle = new Bundle();
                    BNRoutePlaner.this.a(arrayList, bundle);
                    if (bundle.containsKey("unRoutePlanID")) {
                        i = bundle.getInt("unRoutePlanID");
                    } else {
                        i = -1;
                    }
                    if (i >= 0 && BNRoutePlaner.this.k.containsKey(Integer.valueOf(i))) {
                        dVar = BNRoutePlaner.this.c(i);
                    } else {
                        dVar = null;
                    }
                    int i3 = message.arg1;
                    if (i3 == 0 || i3 == 2) {
                        com.baidu.navisdk.module.vehiclemanager.a.a(bundle, ((com.baidu.navisdk.comapi.routeplan.v2.e) BNRoutePlaner.this).m);
                        ((com.baidu.navisdk.comapi.routeplan.v2.e) BNRoutePlaner.this).d.c();
                        o.n().a((int) ((com.baidu.navisdk.comapi.routeplan.v2.e) BNRoutePlaner.this).d.a());
                        if (BNRoutePlaner.this.c() != 3 && BNRoutePlaner.this.c() != 1) {
                            o.n().b("2");
                        } else {
                            o.n().b("1");
                        }
                        o.n().b(true);
                        o.n().k();
                        BNRoutePlaner.this.a(dVar, 49, 0);
                        com.baidu.navisdk.comapi.routeplan.f.c(dVar, 49);
                        BNRoutePlaner.this.a(1, 2, (Object) null);
                    }
                    if (com.baidu.navisdk.util.common.g.b0) {
                        SDKDebugFileUtil.get(SDKDebugFileUtil.RoutePlan_FILENAME).add(" msg.arg1 = " + message.arg1 + " ||| msg.arg2 = " + message.arg2 + " msg.what=" + message.what);
                        return;
                    }
                    return;
                case 4209:
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_PLAN;
                    if (gVar.a()) {
                        gVar.a("CancelRoute IPO_ROUTE_PLAN_RESULT arg1 :" + message.arg1 + " arg2 :" + message.arg2);
                    }
                    com.baidu.navisdk.skyeye.a.n().c();
                    com.baidu.navisdk.framework.b.Z();
                    ArrayList<Bundle> arrayList2 = new ArrayList<>();
                    Bundle bundle2 = new Bundle();
                    BNRoutePlaner.this.a(arrayList2, bundle2);
                    if (bundle2.containsKey("unRoutePlanID")) {
                        i2 = bundle2.getInt("unRoutePlanID");
                    } else {
                        i2 = -1;
                    }
                    if (i2 < 0 || !BNRoutePlaner.this.k.containsKey(Integer.valueOf(i2))) {
                        int b = BNRoutePlaner.this.b(i2);
                        LogUtil.e("RoutePlan", "rp.handler light.oid=" + b);
                        c = BNRoutePlaner.this.c(b);
                    } else {
                        c = BNRoutePlaner.this.c(i2);
                    }
                    int i4 = message.arg1;
                    if (i4 == 0) {
                        com.baidu.navisdk.module.vehiclemanager.a.a(bundle2, ((com.baidu.navisdk.comapi.routeplan.v2.e) BNRoutePlaner.this).m);
                        BNRoutePlaner.this.a();
                        com.baidu.navisdk.model.modelfactory.f fVar = ((com.baidu.navisdk.comapi.routeplan.v2.e) BNRoutePlaner.this).c;
                        ArrayList<RoutePlanNode> k = fVar.k();
                        BNRoutePlaner.this.a(arrayList2, k, c);
                        if (arrayList2.size() > 0 && arrayList2.get(0).containsKey("routeCnt")) {
                            BNRoutePlaner.C = arrayList2.get(0).getInt("routeCnt");
                        }
                        fVar.b(k);
                        BNRoutePlaner.this.a(c, 97, 0);
                        BNRoutePlaner.this.a(1, 2, (Object) null);
                        s.n().l = BNRoutePlaner.getInstance().t();
                        s.n().k();
                        t.u().b((Long) 0L);
                        return;
                    }
                    BNRoutePlaner.this.a(c, 98, 0);
                    e.c cVar = new e.c();
                    int i5 = message.arg1;
                    cVar.f6721a = i5;
                    cVar.b = com.baidu.navisdk.comapi.routeplan.c.a(i5);
                    BNRoutePlaner.this.a(1, 7, cVar);
                    s.n().e(i4);
                    return;
                case 4400:
                    BNRoutePlaner.this.a((com.baidu.navisdk.comapi.routeplan.v2.d) null, 17, message.arg1);
                    LogUtil.e("RoutePlan", "BuildGuideRoute msg.arg1 = " + message.arg1 + " ||| msg.arg2 = " + message.arg2);
                    return;
                case 4403:
                    BNRoutePlaner.this.a((com.baidu.navisdk.comapi.routeplan.v2.d) null, 33, 0);
                    LogUtil.e("RoutePlan", "BuildGuideRoute msg.arg1 = " + message.arg1 + " ||| msg.arg2 = " + message.arg2);
                    if (LogUtil.LOGGABLE) {
                        SDKDebugFileUtil.get(SDKDebugFileUtil.RoutePlan_FILENAME).add(" msg.arg1 = " + message.arg1 + " ||| msg.arg2 = " + message.arg2 + " msg.what=" + message.what);
                        return;
                    }
                    return;
                case 4418:
                    BNRoutePlaner.this.a((com.baidu.navisdk.comapi.routeplan.v2.d) null, 4111, message.arg1);
                    return;
                case 4449:
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("RoutePlan", "MSG_NAVI_Type_WeatherInfo msg.arg1 = " + message.arg1 + ", msg.arg2 = " + message.arg2);
                    }
                    if (message.arg1 == 0) {
                        BNRoutePlaner.this.a((com.baidu.navisdk.comapi.routeplan.v2.d) null, 178, message.arg2);
                        return;
                    } else {
                        BNRoutePlaner.this.a((com.baidu.navisdk.comapi.routeplan.v2.d) null, 177, message.arg2);
                        return;
                    }
                case 4525:
                    BNRoutePlaner.this.a((com.baidu.navisdk.comapi.routeplan.v2.d) null, 4112, 0);
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("RoutePlan", "Message_Type_RouteLinkID_Update");
                        return;
                    }
                    return;
                case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                    if (message.arg1 == 12) {
                        BNRoutePlaner.this.a((com.baidu.navisdk.comapi.routeplan.v2.d) null, 81, 0);
                        BNRoutePlaner.this.a(1, 22, new e.c());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BNBaseDialog.OnNaviClickListener {
        public b() {
        }

        @Override // com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener
        public void onClick() {
            BNRoutePlaner.this.a(5, 17, (Object) null);
            com.baidu.navisdk.comapi.routeplan.v2.b f = BNRoutePlaner.this.f();
            if (f != null) {
                f.g = 0;
                BNRoutePlaner.this.a(f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.util.worker.loop.a {
        public c(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            if (message.what == 5555) {
                if (1 == message.arg2) {
                    BNRoutePlaner.this.k(3);
                } else {
                    BNRoutePlaner.this.k(1);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6716a;
        final /* synthetic */ int b;
        final /* synthetic */ Object c;

        public e(int i, int i2, Object obj) {
            this.f6716a = i;
            this.b = i2;
            this.c = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            BNRoutePlaner.this.notifyObservers(this.f6716a, this.b, this.c);
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a(ArrayList<RoutePlanNode> arrayList);
    }

    /* loaded from: classes7.dex */
    public interface g {
        int a(int i, int i2, int i3, Object obj);
    }

    private BNRoutePlaner() {
        a aVar = new a();
        this.v = aVar;
        this.x = new c("RP-2");
        if (this.b == null) {
            this.b = JNIGuidanceControl.getInstance();
        }
        com.baidu.navisdk.vi.b.a(aVar);
    }

    private void E() {
        NetworkListener.a(this.x);
    }

    private void F() {
        LogUtil.e("RoutePlan", "requestMapHandleRPcancel");
        g gVar = E;
        if (gVar != null) {
            gVar.a(32, 0, 0, null);
        }
    }

    private void G() {
        e.b bVar = new e.b();
        bVar.f6720a = new b();
        a(5, 16, bVar);
    }

    private void H() {
        NetworkListener.b(this.x);
    }

    public static void destory() {
        if (z != null) {
            synchronized (BNRoutePlaner.class) {
                try {
                    if (z != null) {
                        z.dispose();
                        z = null;
                    }
                } finally {
                }
            }
        }
    }

    private void dispose() {
        LogUtil.e("RoutePlan", "dispose");
        com.baidu.navisdk.vi.b.b(this.v);
        com.baidu.navisdk.model.modelfactory.c.a().b("RoutePlanModel");
        this.b = null;
        this.c = null;
        H();
    }

    public static BNRoutePlaner getInstance() {
        if (z == null) {
            synchronized (BNRoutePlaner.class) {
                try {
                    if (z == null) {
                        z = new BNRoutePlaner();
                    }
                } finally {
                }
            }
        }
        return z;
    }

    public static int requestMapLightService(String str, int i, int i2) {
        LogUtil.out("RoutePlan", "requestMapLightService() url=" + str + ", orID=" + i + ", to=" + i2);
        com.baidu.navisdk.comapi.routeplan.v2.e.p = i;
        if (E != null) {
            LogUtil.e("RoutePlan", "mMapComponentCallback toString=" + E);
            return E.a(1, i2, 0, str);
        }
        com.baidu.navisdk.util.http.center.b.a().a(str, new HashMap<>(), new d(), new com.baidu.navisdk.util.http.center.e());
        return 1;
    }

    public static int requestMapLightServiceV2(String str, int i) {
        return requestMapLightService(str, -1, i);
    }

    private boolean s(int i) {
        return i == 31 || i == 42;
    }

    public boolean A() {
        com.baidu.navisdk.model.modelfactory.f fVar = this.c;
        if (fVar != null) {
            return fVar.u();
        }
        return false;
    }

    public boolean B() {
        int u = u();
        int e2 = e();
        LogUtil.e("RoutePlan", "isOfflineRoutePlan() engineNetMode=" + u + ", netMode=" + e2);
        if (u == 0 && (e2 == 0 || e2 == 2)) {
            return true;
        }
        return false;
    }

    public void C() {
        LogUtil.e("RoutePlan", "showReCalRouteProgressDialog");
        a(1, 1, (Object) null);
    }

    public boolean D() {
        boolean z2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RoutePlan", "stopDrivingCar()");
        }
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            z2 = jNIGuidanceControl.StopDrivingCar();
        } else {
            z2 = false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RoutePlan", "stopDrivingCar --> ret = " + z2);
        }
        return z2;
    }

    public void l(int i) {
        try {
            com.baidu.navisdk.skyeye.a.n().c();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.baidu.navisdk.util.common.g.ROUTE_PLAN.a("CancelRoute id :" + i);
        a(i, false, 0);
    }

    public synchronized byte[] m(int i) {
        if (!com.baidu.navisdk.module.init.a.a()) {
            if (LogUtil.OUT_LOGGABLE) {
                LogUtil.out("RoutePlan", "getRoutePlanResultMapProtoBuf --> init is failed.");
            }
            return null;
        }
        Bundle bundle = new Bundle();
        if (!this.b.GetRoutePlanResultMapProtoBuf(bundle, i) || !bundle.containsKey("pb_data")) {
            return null;
        }
        return bundle.getByteArray("pb_data");
    }

    public boolean n(int i) {
        boolean z2 = false;
        if (!com.baidu.navisdk.module.init.a.a()) {
            if (LogUtil.OUT_LOGGABLE) {
                LogUtil.out("RoutePlan", "selectRoute --> init is failed.");
            }
            return false;
        }
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            z2 = jNIGuidanceControl.SelectRoute(i);
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RoutePlan", "selectRoute --> unRouteIdx = " + i + ", isSelectSuccess = " + z2);
        }
        return z2;
    }

    public void o(int i) {
        this.s = i;
    }

    public void p() {
        LogUtil.e("RoutePlan", "cancleCalcRouteRequest() mCalcRequestID = " + this.e);
        a(1, 4, (Object) null);
        l(this.e);
        synchronized (this.f6729a) {
            a(c(this.e), 5, 0);
        }
        F();
    }

    public void q() {
        LogUtil.e("RoutePlan", "cancleCalcWhenQuitNavi() mCalcRequestID = " + this.e);
        a(1, 4, (Object) null);
        l(this.e);
        synchronized (this.f6729a) {
            a(c(this.e), 5, 0);
        }
        F();
    }

    public void r() {
        LogUtil.e("dengtianjian", "clearRouteInfoHandler");
        this.w = null;
    }

    public int t() {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null) {
            return 0;
        }
        return jNIGuidanceControl.GetRouteCnt();
    }

    public int u() {
        com.baidu.navisdk.model.modelfactory.f fVar = this.c;
        if (fVar != null) {
            return fVar.n();
        }
        return -1;
    }

    public int v() {
        return this.e;
    }

    public byte[] w() {
        return m(0);
    }

    @Nullable
    public String x() {
        Bundle bundle = new Bundle();
        if (c(bundle) != 0) {
            return null;
        }
        return bundle.getString("session", null);
    }

    public boolean y() {
        com.baidu.navisdk.model.modelfactory.f fVar = this.c;
        if (fVar != null) {
            return fVar.r();
        }
        return false;
    }

    public boolean z() {
        return A;
    }

    public void o() {
        l(this.e);
    }

    public int s() {
        return this.s;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:
    
        if (a(r8.getGeoPoint()) == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(java.util.ArrayList<android.os.Bundle> r19, java.util.ArrayList<com.baidu.navisdk.model.datastruct.RoutePlanNode> r20) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.comapi.routeplan.BNRoutePlaner.b(java.util.ArrayList, java.util.ArrayList):void");
    }

    public int c(Bundle bundle) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        return (jNIGuidanceControl != null && jNIGuidanceControl.GetRouteSessionIDAndMrsl(bundle) == 1) ? 0 : -1;
    }

    public void d(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int i = bundle.containsKey("enPreCalcRouteResult") ? bundle.getInt("enPreCalcRouteResult") : 0;
        LogUtil.e("RoutePlan", "statisPreCalcRoute   enPreCalcRouteResult=" + i);
        if (i > 1) {
            double d2 = bundle.containsKey("dDist") ? bundle.getDouble("dDist") : -1.0d;
            long j = bundle.containsKey("nTickInterval") ? bundle.getLong("nTickInterval") : -1L;
            int i2 = bundle.containsKey("enLocationType") ? bundle.getInt("enLocationType") : -1;
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RoutePlan", "statisPreCalcRoute   enPreCalcRouteResult=" + i + ", dDist=" + d2 + ", nTickInterval=" + j + ", enLocationType=" + i2);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a(i == 2 ? "2.g.2" : "2.g.3", String.valueOf(i2), String.valueOf(j), String.valueOf(d2));
        }
    }

    public boolean r(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_PLAN;
        if (gVar.a()) {
            gVar.a("RoutePlan", "triggerFastRouteStatus --> " + i);
        }
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null) {
            return false;
        }
        return jNIGuidanceControl.triggerFastRouteStatus(i);
    }

    /* loaded from: classes7.dex */
    public class d extends com.baidu.navisdk.util.http.center.a {
        @Override // com.baidu.navisdk.util.http.center.a
        public void a(int i, byte[] bArr) {
            LogUtil.out("RoutePlan", "requestMapLightService status = " + i);
            com.baidu.navisdk.util.statistic.userop.b.r().d("30.0.39.46", "2");
            BNRoutePlaner.getInstance().a(1, 1, null, BNRoutePlaner.getInstance().b(), bArr, bArr.length);
        }

        @Override // com.baidu.navisdk.util.http.center.a
        public void a(int i, byte[] bArr, Throwable th) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("30.0.39.46", "3", String.valueOf(i));
            LogUtil.out("RoutePlan", "requestMapLightService onFailure");
        }
    }

    public void c(String str) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.SetRoutePlanStatistcsUrl(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<Bundle> arrayList, ArrayList<RoutePlanNode> arrayList2, com.baidu.navisdk.comapi.routeplan.v2.d dVar) {
        com.baidu.navisdk.comapi.routeplan.v2.b e2 = dVar == null ? null : dVar.e();
        Bundle bundle = e2 != null ? e2.r : null;
        boolean z2 = false;
        if (bundle != null && bundle.getBoolean("smart_sort_via", false)) {
            z2 = true;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RoutePlan", "updateRoutePlanNodes --> isSmartSort = " + z2 + ", routePlanSubResult = " + arrayList + ", routePlanNodeList = " + arrayList2);
            LogUtil.printList("RoutePlan", "updateRoutePlanNodes", "routePlanSubResult", arrayList);
            LogUtil.printList("RoutePlan", "updateRoutePlanNodes", "routePlanNodeList", arrayList2);
        }
        if (z2) {
            b(arrayList, arrayList2);
        } else {
            a(arrayList, arrayList2);
        }
    }

    public void p(int i) {
        a(i, 0);
    }

    public void q(int i) {
        com.baidu.navisdk.model.modelfactory.f fVar = this.c;
        if (fVar != null) {
            fVar.f(i);
        }
    }

    private void a(ArrayList<Bundle> arrayList, ArrayList<RoutePlanNode> arrayList2) {
        if (arrayList2 == null || arrayList2.size() != arrayList.size()) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Bundle bundle = arrayList.get(size);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_PLAN;
            if (gVar.e()) {
                gVar.g("updateRoutePlanNodesNormal --> nodeBundle i = " + size + " : " + bundle);
            }
            int i = bundle.getInt("cityId", -1);
            RoutePlanNode routePlanNode = arrayList2.get(size);
            if (routePlanNode != null) {
                if (size == 0) {
                    if (i != -1) {
                        routePlanNode.setDistrictID(i);
                    }
                    if (!a(routePlanNode.getGeoPoint())) {
                    }
                }
                double d2 = bundle.getDouble("x", -2.147483648E9d);
                double d3 = bundle.getDouble("y", -2.147483648E9d);
                boolean z2 = bundle.getBoolean("isPassed", false);
                String string = bundle.getString("uid");
                String string2 = bundle.getString("floor");
                if (!TextUtils.isEmpty(string2)) {
                    routePlanNode.setFloorId(string2);
                }
                if (i != -1) {
                    routePlanNode.setDistrictID(i);
                }
                routePlanNode.setGeoPoint(new GeoPoint((int) (d2 * 100000.0d), (int) (d3 * 100000.0d)));
                routePlanNode.setFrom(1);
                routePlanNode.setPassed(z2);
                routePlanNode.setUID(string);
                if (size != 0) {
                    int i2 = bundle.getInt("nodeParkType", 0);
                    routePlanNode.setParkType(i2);
                    if (gVar.a()) {
                        gVar.a("RGIndoorParkC", "end node parkType1:" + i2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:247|248|(1:254)|255|(7:260|261|(1:263)|264|265|266|(1:268)(1:269))|276|261|(0)|264|265|266|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0819, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x081d, code lost:
    
        if (com.baidu.navisdk.util.common.LogUtil.LOGGABLE != false) goto L269;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x081f, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0583 A[Catch: all -> 0x014a, TRY_LEAVE, TryCatch #1 {all -> 0x014a, blocks: (B:25:0x0122, B:27:0x013c, B:28:0x015d, B:31:0x0163, B:32:0x0177, B:34:0x0180, B:36:0x018b, B:38:0x01a2, B:40:0x01ae, B:42:0x01b4, B:44:0x01fc, B:46:0x0204, B:47:0x021c, B:49:0x0223, B:51:0x0229, B:52:0x022e, B:53:0x0231, B:56:0x0233, B:58:0x023b, B:59:0x0244, B:61:0x024c, B:62:0x0255, B:64:0x025d, B:65:0x0266, B:67:0x0288, B:72:0x0294, B:74:0x029a, B:75:0x02b9, B:76:0x02bf, B:79:0x02c4, B:80:0x02c9, B:82:0x02d1, B:83:0x02df, B:85:0x02e7, B:86:0x02f4, B:88:0x02fc, B:89:0x0305, B:91:0x030d, B:92:0x031b, B:94:0x0323, B:95:0x0331, B:97:0x0339, B:98:0x0347, B:100:0x034f, B:101:0x035d, B:103:0x0365, B:104:0x0373, B:106:0x037b, B:107:0x0389, B:109:0x0391, B:110:0x03a1, B:112:0x03aa, B:113:0x03b9, B:116:0x03c2, B:117:0x0438, B:119:0x043c, B:120:0x0443, B:123:0x044f, B:125:0x0455, B:127:0x0461, B:128:0x0470, B:130:0x0479, B:132:0x0488, B:133:0x0493, B:135:0x0499, B:137:0x049d, B:139:0x04a6, B:141:0x04ac, B:142:0x04c1, B:144:0x04d1, B:146:0x0579, B:148:0x0583, B:150:0x0588, B:152:0x059f, B:154:0x064e, B:156:0x0665, B:158:0x0676, B:160:0x0687, B:162:0x068d, B:164:0x06ca, B:167:0x06d0, B:168:0x0714, B:170:0x072c, B:172:0x0737, B:173:0x073f, B:175:0x0751, B:176:0x0850, B:180:0x0859, B:182:0x085d, B:183:0x0864, B:185:0x0868, B:186:0x08c6, B:188:0x075e, B:190:0x076c, B:191:0x0694, B:193:0x06b7, B:194:0x067b, B:197:0x05db, B:199:0x0611, B:201:0x0621, B:203:0x0629, B:205:0x0630, B:208:0x0638, B:209:0x0642, B:213:0x04de, B:215:0x04f1, B:217:0x04ff, B:219:0x0508, B:221:0x0512, B:224:0x053e, B:226:0x0559, B:228:0x0562, B:230:0x03b5, B:231:0x039d, B:232:0x0385, B:233:0x036f, B:234:0x0359, B:235:0x0343, B:236:0x032d, B:237:0x0317, B:238:0x02db, B:242:0x0779, B:246:0x0794, B:248:0x07ab, B:250:0x07bd, B:254:0x07c4, B:255:0x07c7, B:257:0x07df, B:260:0x07e7, B:263:0x07fe, B:265:0x0811, B:273:0x081b, B:275:0x081f, B:266:0x0822, B:268:0x0828, B:269:0x0845, B:276:0x07f2, B:278:0x01cb, B:279:0x01dc, B:281:0x01e2, B:284:0x0150), top: B:24:0x0122, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x059f A[Catch: all -> 0x014a, TryCatch #1 {all -> 0x014a, blocks: (B:25:0x0122, B:27:0x013c, B:28:0x015d, B:31:0x0163, B:32:0x0177, B:34:0x0180, B:36:0x018b, B:38:0x01a2, B:40:0x01ae, B:42:0x01b4, B:44:0x01fc, B:46:0x0204, B:47:0x021c, B:49:0x0223, B:51:0x0229, B:52:0x022e, B:53:0x0231, B:56:0x0233, B:58:0x023b, B:59:0x0244, B:61:0x024c, B:62:0x0255, B:64:0x025d, B:65:0x0266, B:67:0x0288, B:72:0x0294, B:74:0x029a, B:75:0x02b9, B:76:0x02bf, B:79:0x02c4, B:80:0x02c9, B:82:0x02d1, B:83:0x02df, B:85:0x02e7, B:86:0x02f4, B:88:0x02fc, B:89:0x0305, B:91:0x030d, B:92:0x031b, B:94:0x0323, B:95:0x0331, B:97:0x0339, B:98:0x0347, B:100:0x034f, B:101:0x035d, B:103:0x0365, B:104:0x0373, B:106:0x037b, B:107:0x0389, B:109:0x0391, B:110:0x03a1, B:112:0x03aa, B:113:0x03b9, B:116:0x03c2, B:117:0x0438, B:119:0x043c, B:120:0x0443, B:123:0x044f, B:125:0x0455, B:127:0x0461, B:128:0x0470, B:130:0x0479, B:132:0x0488, B:133:0x0493, B:135:0x0499, B:137:0x049d, B:139:0x04a6, B:141:0x04ac, B:142:0x04c1, B:144:0x04d1, B:146:0x0579, B:148:0x0583, B:150:0x0588, B:152:0x059f, B:154:0x064e, B:156:0x0665, B:158:0x0676, B:160:0x0687, B:162:0x068d, B:164:0x06ca, B:167:0x06d0, B:168:0x0714, B:170:0x072c, B:172:0x0737, B:173:0x073f, B:175:0x0751, B:176:0x0850, B:180:0x0859, B:182:0x085d, B:183:0x0864, B:185:0x0868, B:186:0x08c6, B:188:0x075e, B:190:0x076c, B:191:0x0694, B:193:0x06b7, B:194:0x067b, B:197:0x05db, B:199:0x0611, B:201:0x0621, B:203:0x0629, B:205:0x0630, B:208:0x0638, B:209:0x0642, B:213:0x04de, B:215:0x04f1, B:217:0x04ff, B:219:0x0508, B:221:0x0512, B:224:0x053e, B:226:0x0559, B:228:0x0562, B:230:0x03b5, B:231:0x039d, B:232:0x0385, B:233:0x036f, B:234:0x0359, B:235:0x0343, B:236:0x032d, B:237:0x0317, B:238:0x02db, B:242:0x0779, B:246:0x0794, B:248:0x07ab, B:250:0x07bd, B:254:0x07c4, B:255:0x07c7, B:257:0x07df, B:260:0x07e7, B:263:0x07fe, B:265:0x0811, B:273:0x081b, B:275:0x081f, B:266:0x0822, B:268:0x0828, B:269:0x0845, B:276:0x07f2, B:278:0x01cb, B:279:0x01dc, B:281:0x01e2, B:284:0x0150), top: B:24:0x0122, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0665 A[Catch: all -> 0x014a, TryCatch #1 {all -> 0x014a, blocks: (B:25:0x0122, B:27:0x013c, B:28:0x015d, B:31:0x0163, B:32:0x0177, B:34:0x0180, B:36:0x018b, B:38:0x01a2, B:40:0x01ae, B:42:0x01b4, B:44:0x01fc, B:46:0x0204, B:47:0x021c, B:49:0x0223, B:51:0x0229, B:52:0x022e, B:53:0x0231, B:56:0x0233, B:58:0x023b, B:59:0x0244, B:61:0x024c, B:62:0x0255, B:64:0x025d, B:65:0x0266, B:67:0x0288, B:72:0x0294, B:74:0x029a, B:75:0x02b9, B:76:0x02bf, B:79:0x02c4, B:80:0x02c9, B:82:0x02d1, B:83:0x02df, B:85:0x02e7, B:86:0x02f4, B:88:0x02fc, B:89:0x0305, B:91:0x030d, B:92:0x031b, B:94:0x0323, B:95:0x0331, B:97:0x0339, B:98:0x0347, B:100:0x034f, B:101:0x035d, B:103:0x0365, B:104:0x0373, B:106:0x037b, B:107:0x0389, B:109:0x0391, B:110:0x03a1, B:112:0x03aa, B:113:0x03b9, B:116:0x03c2, B:117:0x0438, B:119:0x043c, B:120:0x0443, B:123:0x044f, B:125:0x0455, B:127:0x0461, B:128:0x0470, B:130:0x0479, B:132:0x0488, B:133:0x0493, B:135:0x0499, B:137:0x049d, B:139:0x04a6, B:141:0x04ac, B:142:0x04c1, B:144:0x04d1, B:146:0x0579, B:148:0x0583, B:150:0x0588, B:152:0x059f, B:154:0x064e, B:156:0x0665, B:158:0x0676, B:160:0x0687, B:162:0x068d, B:164:0x06ca, B:167:0x06d0, B:168:0x0714, B:170:0x072c, B:172:0x0737, B:173:0x073f, B:175:0x0751, B:176:0x0850, B:180:0x0859, B:182:0x085d, B:183:0x0864, B:185:0x0868, B:186:0x08c6, B:188:0x075e, B:190:0x076c, B:191:0x0694, B:193:0x06b7, B:194:0x067b, B:197:0x05db, B:199:0x0611, B:201:0x0621, B:203:0x0629, B:205:0x0630, B:208:0x0638, B:209:0x0642, B:213:0x04de, B:215:0x04f1, B:217:0x04ff, B:219:0x0508, B:221:0x0512, B:224:0x053e, B:226:0x0559, B:228:0x0562, B:230:0x03b5, B:231:0x039d, B:232:0x0385, B:233:0x036f, B:234:0x0359, B:235:0x0343, B:236:0x032d, B:237:0x0317, B:238:0x02db, B:242:0x0779, B:246:0x0794, B:248:0x07ab, B:250:0x07bd, B:254:0x07c4, B:255:0x07c7, B:257:0x07df, B:260:0x07e7, B:263:0x07fe, B:265:0x0811, B:273:0x081b, B:275:0x081f, B:266:0x0822, B:268:0x0828, B:269:0x0845, B:276:0x07f2, B:278:0x01cb, B:279:0x01dc, B:281:0x01e2, B:284:0x0150), top: B:24:0x0122, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x06ce  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x072c A[Catch: all -> 0x014a, TryCatch #1 {all -> 0x014a, blocks: (B:25:0x0122, B:27:0x013c, B:28:0x015d, B:31:0x0163, B:32:0x0177, B:34:0x0180, B:36:0x018b, B:38:0x01a2, B:40:0x01ae, B:42:0x01b4, B:44:0x01fc, B:46:0x0204, B:47:0x021c, B:49:0x0223, B:51:0x0229, B:52:0x022e, B:53:0x0231, B:56:0x0233, B:58:0x023b, B:59:0x0244, B:61:0x024c, B:62:0x0255, B:64:0x025d, B:65:0x0266, B:67:0x0288, B:72:0x0294, B:74:0x029a, B:75:0x02b9, B:76:0x02bf, B:79:0x02c4, B:80:0x02c9, B:82:0x02d1, B:83:0x02df, B:85:0x02e7, B:86:0x02f4, B:88:0x02fc, B:89:0x0305, B:91:0x030d, B:92:0x031b, B:94:0x0323, B:95:0x0331, B:97:0x0339, B:98:0x0347, B:100:0x034f, B:101:0x035d, B:103:0x0365, B:104:0x0373, B:106:0x037b, B:107:0x0389, B:109:0x0391, B:110:0x03a1, B:112:0x03aa, B:113:0x03b9, B:116:0x03c2, B:117:0x0438, B:119:0x043c, B:120:0x0443, B:123:0x044f, B:125:0x0455, B:127:0x0461, B:128:0x0470, B:130:0x0479, B:132:0x0488, B:133:0x0493, B:135:0x0499, B:137:0x049d, B:139:0x04a6, B:141:0x04ac, B:142:0x04c1, B:144:0x04d1, B:146:0x0579, B:148:0x0583, B:150:0x0588, B:152:0x059f, B:154:0x064e, B:156:0x0665, B:158:0x0676, B:160:0x0687, B:162:0x068d, B:164:0x06ca, B:167:0x06d0, B:168:0x0714, B:170:0x072c, B:172:0x0737, B:173:0x073f, B:175:0x0751, B:176:0x0850, B:180:0x0859, B:182:0x085d, B:183:0x0864, B:185:0x0868, B:186:0x08c6, B:188:0x075e, B:190:0x076c, B:191:0x0694, B:193:0x06b7, B:194:0x067b, B:197:0x05db, B:199:0x0611, B:201:0x0621, B:203:0x0629, B:205:0x0630, B:208:0x0638, B:209:0x0642, B:213:0x04de, B:215:0x04f1, B:217:0x04ff, B:219:0x0508, B:221:0x0512, B:224:0x053e, B:226:0x0559, B:228:0x0562, B:230:0x03b5, B:231:0x039d, B:232:0x0385, B:233:0x036f, B:234:0x0359, B:235:0x0343, B:236:0x032d, B:237:0x0317, B:238:0x02db, B:242:0x0779, B:246:0x0794, B:248:0x07ab, B:250:0x07bd, B:254:0x07c4, B:255:0x07c7, B:257:0x07df, B:260:0x07e7, B:263:0x07fe, B:265:0x0811, B:273:0x081b, B:275:0x081f, B:266:0x0822, B:268:0x0828, B:269:0x0845, B:276:0x07f2, B:278:0x01cb, B:279:0x01dc, B:281:0x01e2, B:284:0x0150), top: B:24:0x0122, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x076c A[Catch: all -> 0x014a, TryCatch #1 {all -> 0x014a, blocks: (B:25:0x0122, B:27:0x013c, B:28:0x015d, B:31:0x0163, B:32:0x0177, B:34:0x0180, B:36:0x018b, B:38:0x01a2, B:40:0x01ae, B:42:0x01b4, B:44:0x01fc, B:46:0x0204, B:47:0x021c, B:49:0x0223, B:51:0x0229, B:52:0x022e, B:53:0x0231, B:56:0x0233, B:58:0x023b, B:59:0x0244, B:61:0x024c, B:62:0x0255, B:64:0x025d, B:65:0x0266, B:67:0x0288, B:72:0x0294, B:74:0x029a, B:75:0x02b9, B:76:0x02bf, B:79:0x02c4, B:80:0x02c9, B:82:0x02d1, B:83:0x02df, B:85:0x02e7, B:86:0x02f4, B:88:0x02fc, B:89:0x0305, B:91:0x030d, B:92:0x031b, B:94:0x0323, B:95:0x0331, B:97:0x0339, B:98:0x0347, B:100:0x034f, B:101:0x035d, B:103:0x0365, B:104:0x0373, B:106:0x037b, B:107:0x0389, B:109:0x0391, B:110:0x03a1, B:112:0x03aa, B:113:0x03b9, B:116:0x03c2, B:117:0x0438, B:119:0x043c, B:120:0x0443, B:123:0x044f, B:125:0x0455, B:127:0x0461, B:128:0x0470, B:130:0x0479, B:132:0x0488, B:133:0x0493, B:135:0x0499, B:137:0x049d, B:139:0x04a6, B:141:0x04ac, B:142:0x04c1, B:144:0x04d1, B:146:0x0579, B:148:0x0583, B:150:0x0588, B:152:0x059f, B:154:0x064e, B:156:0x0665, B:158:0x0676, B:160:0x0687, B:162:0x068d, B:164:0x06ca, B:167:0x06d0, B:168:0x0714, B:170:0x072c, B:172:0x0737, B:173:0x073f, B:175:0x0751, B:176:0x0850, B:180:0x0859, B:182:0x085d, B:183:0x0864, B:185:0x0868, B:186:0x08c6, B:188:0x075e, B:190:0x076c, B:191:0x0694, B:193:0x06b7, B:194:0x067b, B:197:0x05db, B:199:0x0611, B:201:0x0621, B:203:0x0629, B:205:0x0630, B:208:0x0638, B:209:0x0642, B:213:0x04de, B:215:0x04f1, B:217:0x04ff, B:219:0x0508, B:221:0x0512, B:224:0x053e, B:226:0x0559, B:228:0x0562, B:230:0x03b5, B:231:0x039d, B:232:0x0385, B:233:0x036f, B:234:0x0359, B:235:0x0343, B:236:0x032d, B:237:0x0317, B:238:0x02db, B:242:0x0779, B:246:0x0794, B:248:0x07ab, B:250:0x07bd, B:254:0x07c4, B:255:0x07c7, B:257:0x07df, B:260:0x07e7, B:263:0x07fe, B:265:0x0811, B:273:0x081b, B:275:0x081f, B:266:0x0822, B:268:0x0828, B:269:0x0845, B:276:0x07f2, B:278:0x01cb, B:279:0x01dc, B:281:0x01e2, B:284:0x0150), top: B:24:0x0122, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x06b7 A[Catch: all -> 0x014a, TryCatch #1 {all -> 0x014a, blocks: (B:25:0x0122, B:27:0x013c, B:28:0x015d, B:31:0x0163, B:32:0x0177, B:34:0x0180, B:36:0x018b, B:38:0x01a2, B:40:0x01ae, B:42:0x01b4, B:44:0x01fc, B:46:0x0204, B:47:0x021c, B:49:0x0223, B:51:0x0229, B:52:0x022e, B:53:0x0231, B:56:0x0233, B:58:0x023b, B:59:0x0244, B:61:0x024c, B:62:0x0255, B:64:0x025d, B:65:0x0266, B:67:0x0288, B:72:0x0294, B:74:0x029a, B:75:0x02b9, B:76:0x02bf, B:79:0x02c4, B:80:0x02c9, B:82:0x02d1, B:83:0x02df, B:85:0x02e7, B:86:0x02f4, B:88:0x02fc, B:89:0x0305, B:91:0x030d, B:92:0x031b, B:94:0x0323, B:95:0x0331, B:97:0x0339, B:98:0x0347, B:100:0x034f, B:101:0x035d, B:103:0x0365, B:104:0x0373, B:106:0x037b, B:107:0x0389, B:109:0x0391, B:110:0x03a1, B:112:0x03aa, B:113:0x03b9, B:116:0x03c2, B:117:0x0438, B:119:0x043c, B:120:0x0443, B:123:0x044f, B:125:0x0455, B:127:0x0461, B:128:0x0470, B:130:0x0479, B:132:0x0488, B:133:0x0493, B:135:0x0499, B:137:0x049d, B:139:0x04a6, B:141:0x04ac, B:142:0x04c1, B:144:0x04d1, B:146:0x0579, B:148:0x0583, B:150:0x0588, B:152:0x059f, B:154:0x064e, B:156:0x0665, B:158:0x0676, B:160:0x0687, B:162:0x068d, B:164:0x06ca, B:167:0x06d0, B:168:0x0714, B:170:0x072c, B:172:0x0737, B:173:0x073f, B:175:0x0751, B:176:0x0850, B:180:0x0859, B:182:0x085d, B:183:0x0864, B:185:0x0868, B:186:0x08c6, B:188:0x075e, B:190:0x076c, B:191:0x0694, B:193:0x06b7, B:194:0x067b, B:197:0x05db, B:199:0x0611, B:201:0x0621, B:203:0x0629, B:205:0x0630, B:208:0x0638, B:209:0x0642, B:213:0x04de, B:215:0x04f1, B:217:0x04ff, B:219:0x0508, B:221:0x0512, B:224:0x053e, B:226:0x0559, B:228:0x0562, B:230:0x03b5, B:231:0x039d, B:232:0x0385, B:233:0x036f, B:234:0x0359, B:235:0x0343, B:236:0x032d, B:237:0x0317, B:238:0x02db, B:242:0x0779, B:246:0x0794, B:248:0x07ab, B:250:0x07bd, B:254:0x07c4, B:255:0x07c7, B:257:0x07df, B:260:0x07e7, B:263:0x07fe, B:265:0x0811, B:273:0x081b, B:275:0x081f, B:266:0x0822, B:268:0x0828, B:269:0x0845, B:276:0x07f2, B:278:0x01cb, B:279:0x01dc, B:281:0x01e2, B:284:0x0150), top: B:24:0x0122, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x067b A[Catch: all -> 0x014a, TryCatch #1 {all -> 0x014a, blocks: (B:25:0x0122, B:27:0x013c, B:28:0x015d, B:31:0x0163, B:32:0x0177, B:34:0x0180, B:36:0x018b, B:38:0x01a2, B:40:0x01ae, B:42:0x01b4, B:44:0x01fc, B:46:0x0204, B:47:0x021c, B:49:0x0223, B:51:0x0229, B:52:0x022e, B:53:0x0231, B:56:0x0233, B:58:0x023b, B:59:0x0244, B:61:0x024c, B:62:0x0255, B:64:0x025d, B:65:0x0266, B:67:0x0288, B:72:0x0294, B:74:0x029a, B:75:0x02b9, B:76:0x02bf, B:79:0x02c4, B:80:0x02c9, B:82:0x02d1, B:83:0x02df, B:85:0x02e7, B:86:0x02f4, B:88:0x02fc, B:89:0x0305, B:91:0x030d, B:92:0x031b, B:94:0x0323, B:95:0x0331, B:97:0x0339, B:98:0x0347, B:100:0x034f, B:101:0x035d, B:103:0x0365, B:104:0x0373, B:106:0x037b, B:107:0x0389, B:109:0x0391, B:110:0x03a1, B:112:0x03aa, B:113:0x03b9, B:116:0x03c2, B:117:0x0438, B:119:0x043c, B:120:0x0443, B:123:0x044f, B:125:0x0455, B:127:0x0461, B:128:0x0470, B:130:0x0479, B:132:0x0488, B:133:0x0493, B:135:0x0499, B:137:0x049d, B:139:0x04a6, B:141:0x04ac, B:142:0x04c1, B:144:0x04d1, B:146:0x0579, B:148:0x0583, B:150:0x0588, B:152:0x059f, B:154:0x064e, B:156:0x0665, B:158:0x0676, B:160:0x0687, B:162:0x068d, B:164:0x06ca, B:167:0x06d0, B:168:0x0714, B:170:0x072c, B:172:0x0737, B:173:0x073f, B:175:0x0751, B:176:0x0850, B:180:0x0859, B:182:0x085d, B:183:0x0864, B:185:0x0868, B:186:0x08c6, B:188:0x075e, B:190:0x076c, B:191:0x0694, B:193:0x06b7, B:194:0x067b, B:197:0x05db, B:199:0x0611, B:201:0x0621, B:203:0x0629, B:205:0x0630, B:208:0x0638, B:209:0x0642, B:213:0x04de, B:215:0x04f1, B:217:0x04ff, B:219:0x0508, B:221:0x0512, B:224:0x053e, B:226:0x0559, B:228:0x0562, B:230:0x03b5, B:231:0x039d, B:232:0x0385, B:233:0x036f, B:234:0x0359, B:235:0x0343, B:236:0x032d, B:237:0x0317, B:238:0x02db, B:242:0x0779, B:246:0x0794, B:248:0x07ab, B:250:0x07bd, B:254:0x07c4, B:255:0x07c7, B:257:0x07df, B:260:0x07e7, B:263:0x07fe, B:265:0x0811, B:273:0x081b, B:275:0x081f, B:266:0x0822, B:268:0x0828, B:269:0x0845, B:276:0x07f2, B:278:0x01cb, B:279:0x01dc, B:281:0x01e2, B:284:0x0150), top: B:24:0x0122, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x07fe A[Catch: all -> 0x014a, TRY_LEAVE, TryCatch #1 {all -> 0x014a, blocks: (B:25:0x0122, B:27:0x013c, B:28:0x015d, B:31:0x0163, B:32:0x0177, B:34:0x0180, B:36:0x018b, B:38:0x01a2, B:40:0x01ae, B:42:0x01b4, B:44:0x01fc, B:46:0x0204, B:47:0x021c, B:49:0x0223, B:51:0x0229, B:52:0x022e, B:53:0x0231, B:56:0x0233, B:58:0x023b, B:59:0x0244, B:61:0x024c, B:62:0x0255, B:64:0x025d, B:65:0x0266, B:67:0x0288, B:72:0x0294, B:74:0x029a, B:75:0x02b9, B:76:0x02bf, B:79:0x02c4, B:80:0x02c9, B:82:0x02d1, B:83:0x02df, B:85:0x02e7, B:86:0x02f4, B:88:0x02fc, B:89:0x0305, B:91:0x030d, B:92:0x031b, B:94:0x0323, B:95:0x0331, B:97:0x0339, B:98:0x0347, B:100:0x034f, B:101:0x035d, B:103:0x0365, B:104:0x0373, B:106:0x037b, B:107:0x0389, B:109:0x0391, B:110:0x03a1, B:112:0x03aa, B:113:0x03b9, B:116:0x03c2, B:117:0x0438, B:119:0x043c, B:120:0x0443, B:123:0x044f, B:125:0x0455, B:127:0x0461, B:128:0x0470, B:130:0x0479, B:132:0x0488, B:133:0x0493, B:135:0x0499, B:137:0x049d, B:139:0x04a6, B:141:0x04ac, B:142:0x04c1, B:144:0x04d1, B:146:0x0579, B:148:0x0583, B:150:0x0588, B:152:0x059f, B:154:0x064e, B:156:0x0665, B:158:0x0676, B:160:0x0687, B:162:0x068d, B:164:0x06ca, B:167:0x06d0, B:168:0x0714, B:170:0x072c, B:172:0x0737, B:173:0x073f, B:175:0x0751, B:176:0x0850, B:180:0x0859, B:182:0x085d, B:183:0x0864, B:185:0x0868, B:186:0x08c6, B:188:0x075e, B:190:0x076c, B:191:0x0694, B:193:0x06b7, B:194:0x067b, B:197:0x05db, B:199:0x0611, B:201:0x0621, B:203:0x0629, B:205:0x0630, B:208:0x0638, B:209:0x0642, B:213:0x04de, B:215:0x04f1, B:217:0x04ff, B:219:0x0508, B:221:0x0512, B:224:0x053e, B:226:0x0559, B:228:0x0562, B:230:0x03b5, B:231:0x039d, B:232:0x0385, B:233:0x036f, B:234:0x0359, B:235:0x0343, B:236:0x032d, B:237:0x0317, B:238:0x02db, B:242:0x0779, B:246:0x0794, B:248:0x07ab, B:250:0x07bd, B:254:0x07c4, B:255:0x07c7, B:257:0x07df, B:260:0x07e7, B:263:0x07fe, B:265:0x0811, B:273:0x081b, B:275:0x081f, B:266:0x0822, B:268:0x0828, B:269:0x0845, B:276:0x07f2, B:278:0x01cb, B:279:0x01dc, B:281:0x01e2, B:284:0x0150), top: B:24:0x0122, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0828 A[Catch: all -> 0x014a, TryCatch #1 {all -> 0x014a, blocks: (B:25:0x0122, B:27:0x013c, B:28:0x015d, B:31:0x0163, B:32:0x0177, B:34:0x0180, B:36:0x018b, B:38:0x01a2, B:40:0x01ae, B:42:0x01b4, B:44:0x01fc, B:46:0x0204, B:47:0x021c, B:49:0x0223, B:51:0x0229, B:52:0x022e, B:53:0x0231, B:56:0x0233, B:58:0x023b, B:59:0x0244, B:61:0x024c, B:62:0x0255, B:64:0x025d, B:65:0x0266, B:67:0x0288, B:72:0x0294, B:74:0x029a, B:75:0x02b9, B:76:0x02bf, B:79:0x02c4, B:80:0x02c9, B:82:0x02d1, B:83:0x02df, B:85:0x02e7, B:86:0x02f4, B:88:0x02fc, B:89:0x0305, B:91:0x030d, B:92:0x031b, B:94:0x0323, B:95:0x0331, B:97:0x0339, B:98:0x0347, B:100:0x034f, B:101:0x035d, B:103:0x0365, B:104:0x0373, B:106:0x037b, B:107:0x0389, B:109:0x0391, B:110:0x03a1, B:112:0x03aa, B:113:0x03b9, B:116:0x03c2, B:117:0x0438, B:119:0x043c, B:120:0x0443, B:123:0x044f, B:125:0x0455, B:127:0x0461, B:128:0x0470, B:130:0x0479, B:132:0x0488, B:133:0x0493, B:135:0x0499, B:137:0x049d, B:139:0x04a6, B:141:0x04ac, B:142:0x04c1, B:144:0x04d1, B:146:0x0579, B:148:0x0583, B:150:0x0588, B:152:0x059f, B:154:0x064e, B:156:0x0665, B:158:0x0676, B:160:0x0687, B:162:0x068d, B:164:0x06ca, B:167:0x06d0, B:168:0x0714, B:170:0x072c, B:172:0x0737, B:173:0x073f, B:175:0x0751, B:176:0x0850, B:180:0x0859, B:182:0x085d, B:183:0x0864, B:185:0x0868, B:186:0x08c6, B:188:0x075e, B:190:0x076c, B:191:0x0694, B:193:0x06b7, B:194:0x067b, B:197:0x05db, B:199:0x0611, B:201:0x0621, B:203:0x0629, B:205:0x0630, B:208:0x0638, B:209:0x0642, B:213:0x04de, B:215:0x04f1, B:217:0x04ff, B:219:0x0508, B:221:0x0512, B:224:0x053e, B:226:0x0559, B:228:0x0562, B:230:0x03b5, B:231:0x039d, B:232:0x0385, B:233:0x036f, B:234:0x0359, B:235:0x0343, B:236:0x032d, B:237:0x0317, B:238:0x02db, B:242:0x0779, B:246:0x0794, B:248:0x07ab, B:250:0x07bd, B:254:0x07c4, B:255:0x07c7, B:257:0x07df, B:260:0x07e7, B:263:0x07fe, B:265:0x0811, B:273:0x081b, B:275:0x081f, B:266:0x0822, B:268:0x0828, B:269:0x0845, B:276:0x07f2, B:278:0x01cb, B:279:0x01dc, B:281:0x01e2, B:284:0x0150), top: B:24:0x0122, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0845 A[Catch: all -> 0x014a, TryCatch #1 {all -> 0x014a, blocks: (B:25:0x0122, B:27:0x013c, B:28:0x015d, B:31:0x0163, B:32:0x0177, B:34:0x0180, B:36:0x018b, B:38:0x01a2, B:40:0x01ae, B:42:0x01b4, B:44:0x01fc, B:46:0x0204, B:47:0x021c, B:49:0x0223, B:51:0x0229, B:52:0x022e, B:53:0x0231, B:56:0x0233, B:58:0x023b, B:59:0x0244, B:61:0x024c, B:62:0x0255, B:64:0x025d, B:65:0x0266, B:67:0x0288, B:72:0x0294, B:74:0x029a, B:75:0x02b9, B:76:0x02bf, B:79:0x02c4, B:80:0x02c9, B:82:0x02d1, B:83:0x02df, B:85:0x02e7, B:86:0x02f4, B:88:0x02fc, B:89:0x0305, B:91:0x030d, B:92:0x031b, B:94:0x0323, B:95:0x0331, B:97:0x0339, B:98:0x0347, B:100:0x034f, B:101:0x035d, B:103:0x0365, B:104:0x0373, B:106:0x037b, B:107:0x0389, B:109:0x0391, B:110:0x03a1, B:112:0x03aa, B:113:0x03b9, B:116:0x03c2, B:117:0x0438, B:119:0x043c, B:120:0x0443, B:123:0x044f, B:125:0x0455, B:127:0x0461, B:128:0x0470, B:130:0x0479, B:132:0x0488, B:133:0x0493, B:135:0x0499, B:137:0x049d, B:139:0x04a6, B:141:0x04ac, B:142:0x04c1, B:144:0x04d1, B:146:0x0579, B:148:0x0583, B:150:0x0588, B:152:0x059f, B:154:0x064e, B:156:0x0665, B:158:0x0676, B:160:0x0687, B:162:0x068d, B:164:0x06ca, B:167:0x06d0, B:168:0x0714, B:170:0x072c, B:172:0x0737, B:173:0x073f, B:175:0x0751, B:176:0x0850, B:180:0x0859, B:182:0x085d, B:183:0x0864, B:185:0x0868, B:186:0x08c6, B:188:0x075e, B:190:0x076c, B:191:0x0694, B:193:0x06b7, B:194:0x067b, B:197:0x05db, B:199:0x0611, B:201:0x0621, B:203:0x0629, B:205:0x0630, B:208:0x0638, B:209:0x0642, B:213:0x04de, B:215:0x04f1, B:217:0x04ff, B:219:0x0508, B:221:0x0512, B:224:0x053e, B:226:0x0559, B:228:0x0562, B:230:0x03b5, B:231:0x039d, B:232:0x0385, B:233:0x036f, B:234:0x0359, B:235:0x0343, B:236:0x032d, B:237:0x0317, B:238:0x02db, B:242:0x0779, B:246:0x0794, B:248:0x07ab, B:250:0x07bd, B:254:0x07c4, B:255:0x07c7, B:257:0x07df, B:260:0x07e7, B:263:0x07fe, B:265:0x0811, B:273:0x081b, B:275:0x081f, B:266:0x0822, B:268:0x0828, B:269:0x0845, B:276:0x07f2, B:278:0x01cb, B:279:0x01dc, B:281:0x01e2, B:284:0x0150), top: B:24:0x0122, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.os.Message r17) {
        /*
            Method dump skipped, instructions count: 2250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.comapi.routeplan.BNRoutePlaner.a(android.os.Message):void");
    }

    public int b(ArrayList<Bundle> arrayList) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.GetRoutePlanNodeList(arrayList);
        }
        return -1;
    }

    public void b(String str) {
        com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410360", "410360");
    }

    private boolean a(GeoPoint geoPoint) {
        if (geoPoint == null || geoPoint.getLongitudeE6() == Integer.MIN_VALUE || geoPoint.getLatitudeE6() == Integer.MIN_VALUE) {
            return true;
        }
        return geoPoint.getLongitudeE6() == 0 && geoPoint.getLatitudeE6() == 0;
    }

    public void a(Context context) {
        this.c = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (z.a(context)) {
            k(3);
        } else {
            k(1);
        }
        E();
    }

    public int a(int i, Bundle bundle) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null) {
            return 0;
        }
        return jNIGuidanceControl.GetRouteInfo(i, bundle);
    }

    public boolean a(int i, int i2, ArrayList<RoutePlanNode> arrayList, int i3, byte[] bArr, int i4) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RoutePlan", "calcRouteWithLightResultPB() routeDataMode=" + i + ", outDataType=" + i2 + ", pbDataLen=" + i4 + ", unPreference=" + i3);
        }
        if (this.b == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_PLAN;
            if (gVar.a()) {
                gVar.a("calcRouteWithPBData mGuidanceControl is null");
            }
            return false;
        }
        e.c cVar = new e.c();
        com.baidu.navisdk.model.modelfactory.f fVar = this.c;
        if (fVar != null) {
            fVar.c();
        }
        Bundle bundle = new Bundle();
        bundle.putByteArray("pb_data", bArr);
        a(bundle);
        int CalcRouteWithPB = this.b.CalcRouteWithPB(i, i2, i3, bundle, i4, this.h);
        this.f = CalcRouteWithPB;
        this.e = b(CalcRouteWithPB);
        LogUtil.e("RoutePlan", "calcRouteWithLightResultPB. mCalcRequestID = " + this.e + ", mLastLightRPRequestID=" + this.f);
        if (this.e < 0) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.ROUTE_PLAN;
            if (gVar2.a()) {
                gVar2.a("calcRouteWithLightResultPB. failed.mCalcRequestID < 0");
            }
            cVar.f6721a = 5050;
            cVar.b = com.baidu.navisdk.comapi.routeplan.c.b(5050);
            a(1, 6, cVar);
            return false;
        }
        a(1, 1, (Object) null);
        return true;
    }

    public boolean a(int i, boolean z2, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RoutePlan", "cancelCalcRoute --> mGuidanceControl = " + this.b + ", requestId = " + i + ", isSwitchCalcRoute = " + z2 + ", cancelCalcType = " + i2);
        }
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null) {
            return false;
        }
        try {
            return jNIGuidanceControl.cancelCalcRoute(i, z2, i2);
        } catch (Throwable th) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RoutePlan", "cancelCalcRoute --> throwable = " + th);
            }
            return false;
        }
    }

    public int a(ArrayList<Bundle> arrayList, Bundle bundle) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null) {
            return -1;
        }
        return jNIGuidanceControl.GetRoutePlanSubResult(arrayList, bundle);
    }

    public boolean a(ArrayList<Bundle> arrayList) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null) {
            return false;
        }
        return jNIGuidanceControl.GetPassportInfo(arrayList);
    }

    public boolean a(double d2, double d3) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null) {
            return false;
        }
        try {
            return jNIGuidanceControl.triggerSensorAngle(d2, d3);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean a(float f2, float f3, float f4) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null) {
            return false;
        }
        try {
            return jNIGuidanceControl.TriggerStartSensorData(f2, f3, f4);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean a(float f2) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null) {
            return false;
        }
        try {
            return jNIGuidanceControl.triggerPressureChange(f2);
        } catch (Throwable unused) {
            return false;
        }
    }

    public int a(String str) {
        LogUtil.e("RoutePlan", "selectRouteWithMrsl() routeMrsl=" + str + ", time=" + SystemClock.elapsedRealtime());
        int SelectRouteWithMrsl = this.b.SelectRouteWithMrsl(str);
        StringBuilder sb = new StringBuilder();
        sb.append("selectRouteWithMrsl() selectRet=");
        sb.append(SelectRouteWithMrsl);
        LogUtil.e("RoutePlan", sb.toString());
        if (SelectRouteWithMrsl >= 0) {
            Bundle bundle = new Bundle();
            int selectRouteIdx = JNIGuidanceControl.getInstance().getSelectRouteIdx();
            LogUtil.e("RoutePlan", "selectRouteWithMrsl() curRouteIdx=" + selectRouteIdx);
            int a2 = getInstance().a(selectRouteIdx, bundle);
            LogUtil.e("RoutePlan", "selectRouteWithMrsl() ret=" + a2);
            if (a2 == 2) {
                this.c.a(com.baidu.navisdk.framework.a.c().a(), bundle);
            }
        }
        return SelectRouteWithMrsl;
    }

    public String a(String str, String str2) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null) {
            return null;
        }
        return jNIGuidanceControl.GetRoutePlanSessionIDAndMrsl(str, str2);
    }

    public void a(f fVar) {
        this.y = fVar;
    }

    public int a(com.baidu.navisdk.model.datastruct.g gVar, boolean z2) {
        RoutePlanNode routePlanNode;
        com.baidu.navisdk.model.modelfactory.f fVar = this.c;
        if (fVar == null) {
            routePlanNode = null;
        } else if (z2) {
            routePlanNode = fVar.o();
        } else {
            routePlanNode = fVar.g();
        }
        if (routePlanNode != null && routePlanNode.getLatitudeE6() != Integer.MIN_VALUE && routePlanNode.getLongitudeE6() != Integer.MIN_VALUE && gVar != null) {
            double d2 = gVar.b;
            if (d2 != -1.0d) {
                double d3 = gVar.f6926a;
                if (d3 != -1.0d) {
                    double b2 = l0.b(d2 * 100000.0d, d3 * 100000.0d, routePlanNode.getLongitudeE6(), routePlanNode.getLatitudeE6());
                    LogUtil.e("RoutePlan", "getLineDist2RpNode: --> lDist: " + b2);
                    return (int) b2;
                }
            }
        }
        return -1;
    }

    public void a(int i, int i2, Object obj) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            notifyObservers(i, i2, obj);
        } else {
            this.x.post(new e(i, i2, obj));
        }
    }

    public void a(int i, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_PLAN;
        if (gVar.a()) {
            gVar.a("RoutePlan", "setNaviPageStatus --> naviPageStatus = " + i + ", naviPageType = " + i2 + ", mGuidanceControl = " + this.b);
        }
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.setNaviPageStatus(i, i2);
        }
    }

    public Bundle a(int i, String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_PLAN;
        if (gVar.a()) {
            gVar.a("RoutePlan", "getChargeStationById --> mGuidanceControl = " + this.b);
        }
        if (this.b == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        this.b.getChargeStationById(i, str, bundle);
        return bundle;
    }

    public boolean a(int i, ArrayList<Bundle> arrayList, Bundle bundle, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_PLAN;
        if (gVar.a()) {
            gVar.a("RoutePlan", "getNeTransRouteInfo --> mGuidanceControl = " + this.b + ", routeIndex = " + i);
        }
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null) {
            return false;
        }
        return jNIGuidanceControl.getNeTransRouteInfo(i, arrayList, bundle, i2);
    }

    public boolean a(int i, ArrayList<Bundle> arrayList) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_PLAN;
        if (gVar.a()) {
            gVar.a("RoutePlan", "getChargeStationBubbles --> mGuidanceControl = " + this.b + ", routeIndex = " + i);
        }
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null) {
            return false;
        }
        return jNIGuidanceControl.getChargeStationBubbles(i, arrayList);
    }
}
