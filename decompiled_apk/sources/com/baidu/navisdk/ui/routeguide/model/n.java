package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.util.common.l0;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.util.MD5;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class n extends com.baidu.navisdk.module.pronavi.abs.a {

    /* renamed from: a, reason: collision with root package name */
    private List<com.baidu.navisdk.module.pronavi.model.d> f8952a = new ArrayList();
    private List<com.baidu.navisdk.module.pronavi.model.d> b = new ArrayList();
    private List<com.baidu.navisdk.module.pronavi.model.d> c;
    private volatile List<String> d;
    private final List<com.baidu.navisdk.module.pronavi.model.d> e;
    private volatile com.baidu.navisdk.module.pronavi.model.d f;
    private volatile com.baidu.navisdk.module.pronavi.model.d g;
    private volatile com.baidu.navisdk.module.pronavi.model.d h;
    private volatile com.baidu.navisdk.module.pronavi.model.d i;
    private volatile com.baidu.navisdk.module.pronavi.model.d j;
    private volatile int k;
    private boolean l;
    private volatile int m;
    private volatile int n;
    private volatile int o;
    private volatile int p;
    private volatile int q;
    private String r;
    private boolean s;
    private volatile boolean t;
    private com.baidu.navisdk.module.pronavi.model.d u;
    private final com.baidu.navisdk.framework.interfaces.pronavi.p v;
    private final HashMap<String, com.baidu.navisdk.module.pronavi.model.a> w;
    private final List<String> x;
    private volatile boolean y;
    private final com.baidu.navisdk.util.worker.loop.a z;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a() {
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            if (message.what == 1020) {
                n.this.D();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f8956a;
        final /* synthetic */ e b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, boolean z, e eVar) {
            super(str, str2);
            this.f8956a = z;
            this.b = eVar;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            ArrayList<Bundle> arrayList;
            String str;
            int i;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            boolean d = gVar.d();
            String str2 = com.baidu.navisdk.util.worker.g.TAG;
            if (d) {
                gVar.e(com.baidu.navisdk.util.worker.g.TAG, "pullAllServiceAreaDatas-> isPullAll= " + this.f8956a);
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<Bundle> arrayList2 = new ArrayList<>();
            boolean subscribeListData = JNIGuidanceControl.getInstance().getSubscribeListData(arrayList2);
            if (gVar.d()) {
                gVar.e(com.baidu.navisdk.util.worker.g.TAG, "pullAllServiceAreaDatas-> getSubscribeListData from JNI 耗时： " + (System.currentTimeMillis() - currentTimeMillis) + ", 共拉取数据(条)： " + arrayList2.size());
            }
            if (!subscribeListData) {
                if (gVar.d()) {
                    gVar.e(com.baidu.navisdk.util.worker.g.TAG, "pullAllServiceAreaDatas-> getSubscribeListData return false!");
                }
                n.this.a((List<com.baidu.navisdk.module.pronavi.model.d>) null, this.b);
                return null;
            }
            if (arrayList2.isEmpty()) {
                if (gVar.d()) {
                    gVar.e(com.baidu.navisdk.util.worker.g.TAG, "pullAllServiceAreaDatas-> subscribeList.isEmpty, return false!");
                }
                n.this.a((List<com.baidu.navisdk.module.pronavi.model.d>) null, this.b);
                return null;
            }
            if (com.baidu.navisdk.module.routeresultbase.view.template.selector.a.b() != null && gVar.d()) {
                StringBuilder sb = new StringBuilder("pullAllServiceAreaDatas-> sSubscribedIds:");
                Iterator<String> it = com.baidu.navisdk.module.routeresultbase.view.template.selector.a.b().iterator();
                while (it.hasNext()) {
                    sb.append(", " + it.next());
                }
                com.baidu.navisdk.util.common.g.PRO_NAV.e("DynamicCard111", sb.toString());
            }
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                StringBuilder sb2 = new StringBuilder("pullAllServiceAreaDatas-> mSubscribedServiceAreaId:");
                Iterator it2 = n.this.d.iterator();
                while (it2.hasNext()) {
                    sb2.append(", " + ((String) it2.next()));
                }
                com.baidu.navisdk.util.common.g.PRO_NAV.e(com.baidu.navisdk.util.worker.g.TAG, sb2.toString());
            }
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            n.this.C();
            n nVar = n.this;
            nVar.k = nVar.y();
            n.this.e.clear();
            int i2 = 0;
            boolean z = false;
            while (i2 < arrayList2.size()) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar2.d() && arrayList2.get(i2) != null) {
                    gVar2.e(str2, "高速详情面板Item: " + arrayList2.get(i2).toString());
                }
                com.baidu.navisdk.module.pronavi.model.d a2 = n.this.a(arrayList2.get(i2));
                arrayList6.add(a2);
                if (n.this.a(a2)) {
                    arrayList = arrayList2;
                    str = str2;
                    i = 1;
                } else {
                    if (a2.p() == 4 && a2.r() && !TextUtils.isEmpty(a2.i())) {
                        n.this.e.add(a2);
                    }
                    if (a2.p() == 1) {
                        n.e(n.this);
                        if (arrayList4.size() < 2) {
                            arrayList4.add(a2);
                        }
                        arrayList = arrayList2;
                    } else {
                        arrayList = arrayList2;
                        if (a2.p() == 4) {
                            n.g(n.this);
                            if (n.this.f == null) {
                                n.this.f = a2;
                                if (gVar2.d()) {
                                    gVar2.e(str2, "pullAllServiceAreaDatas-> 记录最近的服务区： " + n.this.f.toString());
                                }
                            }
                            if (arrayList4.size() < 2) {
                                arrayList4.add(a2);
                            }
                        } else if (a2.p() != 3 && a2.p() != 5) {
                            if (a2.p() == 7) {
                                n.g(n.this);
                                n.m(n.this);
                                if (gVar2.d()) {
                                    gVar2.e(str2, "pullAllServiceAreaDatas-> 第" + n.this.q + "个充电站(充电站服务区融合)： " + a2);
                                }
                                if (n.this.f == null) {
                                    n.this.f = a2;
                                    if (gVar2.d()) {
                                        gVar2.e(str2, "pullAllServiceAreaDatas-> 记录最近的服务区： " + n.this.f.toString());
                                    }
                                }
                                if (n.this.h == null) {
                                    n.this.h = a2;
                                    if (gVar2.d()) {
                                        gVar2.e(str2, "pullAllServiceAreaDatas-> 记录最近的服务区充电站： " + n.this.h);
                                    }
                                }
                                com.baidu.navisdk.model.datastruct.chargestation.b bVar = (com.baidu.navisdk.model.datastruct.chargestation.b) a2.a("charge_station_info");
                                if (bVar != null && bVar.q()) {
                                    n.this.t = true;
                                }
                                if (arrayList4.size() < 2) {
                                    arrayList4.add(a2);
                                }
                            }
                        } else {
                            n.j(n.this);
                            if (n.this.g == null) {
                                n.this.g = a2;
                                if (gVar2.d()) {
                                    gVar2.e(str2, "pullAllServiceAreaDatas-> 记录最近的出口： " + n.this.g.toString());
                                }
                            }
                        }
                    }
                    if (!z) {
                        arrayList3.add(a2);
                    }
                    z = !this.f8956a && n.this.n + n.this.m >= 2;
                    if (!n.this.d.isEmpty() && n.this.d.contains(a2.g())) {
                        arrayList5.add(a2.g());
                        if (gVar2.d()) {
                            gVar2.e(str2, "当前路线仍存在已订阅的站点：" + a2);
                        }
                    }
                    if (n.this.e != null && n.this.e.size() > 0 && n.this.w != null && n.this.w.size() > 0) {
                        n.this.A();
                    }
                    if (com.baidu.navisdk.module.routeresultbase.view.template.selector.a.b() != null) {
                        if (gVar2.d()) {
                            gVar2.e("DynamicCard111", "data: " + a2);
                        }
                        if (a2.j() != null) {
                            str = str2;
                            if (com.baidu.navisdk.module.routeresultbase.view.template.selector.a.a(String.format("%d_%d", Integer.valueOf(a2.j().getLongitudeE6()), Integer.valueOf(a2.j().getLatitudeE6())))) {
                                arrayList5.add(a2.g());
                                if (gVar2.d()) {
                                    gVar2.e("DynamicCard111", "当前路线存在已订阅的站点：" + a2);
                                }
                            }
                            i = 1;
                        }
                    }
                    str = str2;
                    i = 1;
                }
                i2 += i;
                str2 = str;
                arrayList2 = arrayList;
            }
            com.baidu.navisdk.module.routeresultbase.view.template.selector.a.a();
            n.this.d = arrayList5;
            n.this.c = arrayList4;
            n.this.b = arrayList6;
            n.this.l = arrayList3.size() > 0 && this.f8956a;
            int size = n.this.e != null ? n.this.e.size() : 0;
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGHighwayServiceAreaModel", "pullAllServiceAreaDatas-> 拉取数据总耗时：" + (System.currentTimeMillis() - currentTimeMillis) + ", serviceAreaList= " + arrayList3.size() + ", mFirstTwoNotExitStationData= " + n.this.c.size() + ", mSubscribedServiceAreaId= " + n.this.d.size() + ", 服务区：" + n.this.m + ", 有空车位数据的服务区: " + size + ", 收费站: " + n.this.n + ", 充电站： " + n.this.q + ", 出口： " + n.this.o + ", 入口： " + n.this.p);
            }
            n.this.a(arrayList3, this.b);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class d extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f8957a;
        final /* synthetic */ e b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, String str2, List list, e eVar) {
            super(str, str2);
            this.f8957a = list;
            this.b = eVar;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("handleResultOnMainThread-callback-> data= ");
                List list = this.f8957a;
                sb.append(list == null ? "null" : Integer.valueOf(list.size()));
                sb.append(", callback= ");
                sb.append(this.b);
                gVar.e(com.baidu.navisdk.util.worker.g.TAG, sb.toString());
            }
            List list2 = this.f8957a;
            if (list2 == null || list2.isEmpty()) {
                n.this.C();
                n.this.f8952a.clear();
                n.this.d.clear();
                n.this.c.clear();
            } else {
                n.this.f8952a = this.f8957a;
            }
            if (n.this.v != null) {
                n.this.v.a();
            }
            e eVar = this.b;
            if (eVar == null) {
                return null;
            }
            eVar.a();
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a();
    }

    public n(com.baidu.navisdk.framework.interfaces.pronavi.p pVar) {
        new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.l = false;
        this.s = false;
        this.t = false;
        this.w = new HashMap<>();
        this.x = new ArrayList();
        this.y = false;
        this.z = new a();
        this.v = pVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        for (int i = 0; i < this.e.size(); i++) {
            com.baidu.navisdk.module.pronavi.model.d dVar = this.e.get(i);
            String i2 = dVar.i();
            if (!TextUtils.isEmpty(i2) && dVar.r()) {
                dVar.b("parking_lot_info", this.w.get(i2));
            } else {
                dVar.b("parking_lot_info", null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x002a A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void B() {
        /*
            r5 = this;
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.PRO_NAV
            boolean r1 = r0.d()
            if (r1 == 0) goto Lf
            java.lang.String r1 = "RGHighwayServiceAreaModel"
            java.lang.String r2 = "refreshLocalStation->"
            r0.e(r1, r2)
        Lf:
            java.util.List<com.baidu.navisdk.module.pronavi.model.d> r0 = r5.c
            r0.clear()
            r0 = 0
            r5.g = r0
            com.baidu.navisdk.ui.routeguide.mapmode.a r0 = com.baidu.navisdk.ui.routeguide.control.x.b()
            java.util.List<java.lang.String> r1 = r5.d
            int r1 = r1.size()
            r0.F(r1)
            java.util.List<com.baidu.navisdk.module.pronavi.model.d> r0 = r5.f8952a
            java.util.Iterator r0 = r0.iterator()
        L2a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L8d
            java.lang.Object r1 = r0.next()
            com.baidu.navisdk.module.pronavi.model.d r1 = (com.baidu.navisdk.module.pronavi.model.d) r1
            int r2 = r1.p()
            r3 = 1
            r4 = 2
            if (r2 == r3) goto L70
            r3 = 3
            if (r2 == r3) goto L69
            r3 = 4
            if (r2 == r3) goto L70
            r3 = 5
            if (r2 == r3) goto L69
            r3 = 6
            if (r2 == r3) goto L62
            r3 = 7
            if (r2 == r3) goto L4e
            goto L7d
        L4e:
            com.baidu.navisdk.module.pronavi.model.d r2 = r5.h
            if (r2 != 0) goto L54
            r5.h = r1
        L54:
            java.util.List<com.baidu.navisdk.module.pronavi.model.d> r2 = r5.c
            int r2 = r2.size()
            if (r2 >= r4) goto L7d
            java.util.List<com.baidu.navisdk.module.pronavi.model.d> r2 = r5.c
            r2.add(r1)
            goto L7d
        L62:
            com.baidu.navisdk.module.pronavi.model.d r2 = r5.h
            if (r2 != 0) goto L7d
            r5.h = r1
            goto L7d
        L69:
            com.baidu.navisdk.module.pronavi.model.d r2 = r5.g
            if (r2 != 0) goto L7d
            r5.g = r1
            goto L7d
        L70:
            java.util.List<com.baidu.navisdk.module.pronavi.model.d> r2 = r5.c
            int r2 = r2.size()
            if (r2 >= r4) goto L7d
            java.util.List<com.baidu.navisdk.module.pronavi.model.d> r2 = r5.c
            r2.add(r1)
        L7d:
            java.util.List<com.baidu.navisdk.module.pronavi.model.d> r1 = r5.c
            int r1 = r1.size()
            if (r1 < r4) goto L2a
            com.baidu.navisdk.module.pronavi.model.d r1 = r5.g
            if (r1 == 0) goto L2a
            com.baidu.navisdk.module.pronavi.model.d r1 = r5.h
            if (r1 == 0) goto L2a
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.model.n.B():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        this.n = 0;
        this.m = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        this.x.clear();
        synchronized (this) {
            try {
                this.w.clear();
                List<com.baidu.navisdk.module.pronavi.model.d> list = this.e;
                if (list != null && !list.isEmpty()) {
                    for (int i = 0; i < this.e.size(); i++) {
                        String i2 = this.e.get(i).i();
                        if (!TextUtils.isEmpty(i2)) {
                            this.x.add(i2);
                        }
                    }
                    List<String> list2 = this.x;
                    if (list2 != null && !list2.isEmpty()) {
                        b(this.x.subList(0, Math.min(this.x.size(), 30)));
                    }
                }
            } finally {
            }
        }
    }

    private boolean E() {
        com.baidu.navisdk.module.pronavi.model.d dVar = this.u;
        if (dVar != null) {
            if (dVar.a() > 0 && dVar.k() > 0) {
                com.baidu.navisdk.module.pronavi.model.d dVar2 = this.g;
                if (dVar2 != null && dVar2.a() < dVar.a()) {
                    this.s = false;
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("RGHighwayServiceAreaModel", "updateDirectionBoardDisplay-> 方向看板数据比当前出口远，暂时不显示");
                    }
                } else {
                    this.s = true;
                    com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar2.d()) {
                        gVar2.e("RGHighwayServiceAreaModel", "updateDirectionBoardDisplay-> 方向看板可以显示");
                    }
                    return true;
                }
            } else {
                this.s = false;
                com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar3.d()) {
                    gVar3.e("RGHighwayServiceAreaModel", "updateDirectionBoardDisplay-> 方向看板数据异常，暂时不显示, getAddDist= " + dVar.a() + ", getRemainDist= " + dVar.k());
                }
                this.u = null;
                return false;
            }
        }
        this.s = false;
        return false;
    }

    public static /* synthetic */ int e(n nVar) {
        int i = nVar.n;
        nVar.n = i + 1;
        return i;
    }

    public static /* synthetic */ int g(n nVar) {
        int i = nVar.m;
        nVar.m = i + 1;
        return i;
    }

    public static /* synthetic */ int j(n nVar) {
        int i = nVar.o;
        nVar.o = i + 1;
        return i;
    }

    public static /* synthetic */ int m(n nVar) {
        int i = nVar.q;
        nVar.q = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int y() {
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getVehicleInfo(bundle);
        return bundle.getInt("vehicle_angle_add_dist");
    }

    private boolean z() {
        if (this.f8952a.isEmpty()) {
            return false;
        }
        com.baidu.navisdk.module.pronavi.model.d dVar = this.f8952a.get(0);
        dVar.a(this.k);
        if (dVar.k() > 0) {
            return false;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaModel", "handlePassedServiceArea-> 该站点已经过:" + dVar + ", 当前剩余距离：" + dVar.k() + ", 实际距离差：" + (dVar.a() - this.k));
        }
        this.f8952a.remove(0);
        int p = dVar.p();
        if (p == 1) {
            this.n--;
        } else if (p == 4) {
            this.m--;
        } else if (p != 3 && p != 5) {
            if (p == 7) {
                this.m--;
                this.q--;
            } else if (p == 6) {
                this.q--;
            }
        } else {
            this.o--;
        }
        String g = dVar.g();
        this.d.remove(g);
        if (!this.c.isEmpty() && this.c.get(0).g().equals(g)) {
            this.c.remove(0);
        }
        if (this.g != null && this.g.g().equals(g)) {
            this.g = null;
        }
        if (this.f != null && this.f.g().equals(g)) {
            this.f = null;
        }
        if (this.h != null && this.h.g().equals(g)) {
            this.h = null;
        }
        if (this.i != null && this.i.g().equals(g)) {
            this.i = null;
        }
        if (this.j != null && this.j.g().equals(g)) {
            this.j = null;
        }
        z();
        return true;
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.util.http.center.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f8954a;

        /* loaded from: classes8.dex */
        public class a extends com.baidu.navisdk.util.worker.f<String, String> {
            public a(String str, String str2) {
                super(str, str2);
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                if (n.this.v != null) {
                    n.this.v.a();
                }
                n.this.z.sendEmptyMessageDelayed(1020, 300000L);
                return null;
            }
        }

        public b(List list) {
            this.f8954a = list;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaModel", "requestEmptyParkSpaceInfo->onFailure ,statusCode + " + i + "responseString=" + str + "," + th);
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaModel", "requestEmptyParkSpaceInfo->onSuccess ,statusCode + " + i + "responseString=" + str);
            }
            n.this.a(str, (List<String>) this.f8954a);
            n.this.x.removeAll(this.f8954a);
            if (!n.this.x.isEmpty()) {
                n.this.b((List<String>) n.this.x.subList(0, Math.min(n.this.x.size(), 30)));
                return;
            }
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new a("handleEmptyParkSpaceInfoResponse-callback", null), new com.baidu.navisdk.util.worker.e(2, 0));
        }
    }

    public com.baidu.navisdk.module.pronavi.model.d f() {
        return this.j;
    }

    public com.baidu.navisdk.module.pronavi.model.d g() {
        return this.i;
    }

    public List<com.baidu.navisdk.module.pronavi.model.d> h() {
        return this.c;
    }

    public com.baidu.navisdk.module.pronavi.model.d i() {
        return this.h;
    }

    public com.baidu.navisdk.module.pronavi.model.d j() {
        return this.g;
    }

    public com.baidu.navisdk.module.pronavi.model.d k() {
        return this.f;
    }

    public int l() {
        return this.m;
    }

    public List<com.baidu.navisdk.module.pronavi.model.d> m() {
        return this.f8952a;
    }

    public List<String> n() {
        return this.d;
    }

    public int o() {
        return this.n;
    }

    public boolean p() {
        return this.f8952a.size() > 0;
    }

    public boolean q() {
        return this.s;
    }

    public boolean r() {
        return this.t;
    }

    public boolean s() {
        if (this.s && this.u != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaModel", "isServicePanelCanShow-> isDirectionBoardCanShow=true!");
            }
            return true;
        }
        if (!this.f8952a.isEmpty()) {
            if (a0.I().u()) {
                if (!this.c.isEmpty()) {
                    com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar2.d()) {
                        gVar2.e("RGHighwayServiceAreaModel", "isServicePanelCanShow-> true,FirstTwoNotExitStationData");
                    }
                    return true;
                }
                if (this.g != null && this.g.k() <= 2000) {
                    com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar3.d()) {
                        gVar3.e("RGHighwayServiceAreaModel", "isServicePanelCanShow-> true,NextExit <= 2000");
                    }
                    return true;
                }
                if (this.h != null) {
                    com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar4.d()) {
                        gVar4.e("RGHighwayServiceAreaModel", "isServicePanelCanShow-> true,NextChargeStation != null");
                    }
                    return true;
                }
            } else {
                if (this.h != null) {
                    com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar5.d()) {
                        gVar5.e("RGHighwayServiceAreaModel", "isServicePanelCanShow-> true,NextChargeStation != null");
                    }
                    return true;
                }
                if (this.f8952a.get(0).k() <= 2000) {
                    com.baidu.navisdk.util.common.g gVar6 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar6.d()) {
                        gVar6.e("RGHighwayServiceAreaModel", "isServicePanelCanShow-> true,nextStationData <= 2000");
                    }
                    return true;
                }
            }
        }
        com.baidu.navisdk.util.common.g gVar7 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar7.d()) {
            gVar7.e("RGHighwayServiceAreaModel", "isServicePanelCanShow-> false");
        }
        return false;
    }

    public boolean t() {
        boolean z = com.baidu.navisdk.module.vehiclemanager.b.i().f() && com.baidu.navisdk.module.vehiclemanager.b.i().a() == 0;
        boolean a2 = com.baidu.navisdk.function.b.FUNC_SERVICE_AREA_EMPTY_PARKING_SPACE_INFO.a();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaModel", "isShowEmptyParkingSpaceInfoScene--> isCar-->" + z + ", FUNC_SERVICE_AREA_EMPTY_PARKING_SPACE_INFO is -->" + a2);
        }
        return z && a2;
    }

    public void u() {
        boolean t = t();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaModel", "loopEmptyParkingSpace--> isLoopEmptyParkingSpaceInfo:" + this.y + ", showEmptyParkingSpaceInfoScene-->" + t + ", mEmptyParkSpaceServiceAreaList-->" + this.e.size());
        }
        if (!t || this.y || this.e.isEmpty()) {
            return;
        }
        this.y = true;
        this.z.sendEmptyMessage(1020);
    }

    public void v() {
        if (this.f8952a.size() > 2) {
            com.baidu.navisdk.module.pronavi.model.d dVar = this.f8952a.get(0);
            com.baidu.navisdk.module.pronavi.model.d dVar2 = this.f8952a.get(1);
            this.f8952a.clear();
            this.f8952a.add(dVar);
            this.f8952a.add(dVar2);
        }
        this.l = false;
    }

    public void w() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaModel", "stopLoopEmptyParkingSpace");
        }
        this.z.removeCallbacksAndMessages(null);
        synchronized (this) {
            this.w.clear();
            this.y = false;
        }
    }

    public void x() {
        List<com.baidu.navisdk.module.pronavi.model.d> list = this.f8952a;
        if (list != null) {
            for (com.baidu.navisdk.module.pronavi.model.d dVar : list) {
                if (dVar.k() > 0 && (dVar.p() == 7 || dVar.p() == 6)) {
                    b(dVar);
                }
            }
        }
    }

    public com.baidu.navisdk.module.pronavi.model.d e() {
        return this.u;
    }

    private void c(int i) {
        if (this.f8952a.isEmpty()) {
            return;
        }
        if (this.f != null) {
            this.f.a(i);
        }
        if (this.g != null) {
            this.g.a(i);
        }
        if (this.h != null) {
            this.h.a(i);
        }
        if (this.i != null) {
            this.i.a(i);
        }
        if (this.j != null) {
            this.j.a(i);
        }
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            this.c.get(i2).a(i);
        }
    }

    private List<Integer> d(int i) {
        ArrayList arrayList = new ArrayList();
        if ((i & 2) != 0) {
            arrayList.add(2);
        }
        if ((i & 32) != 0) {
            arrayList.add(32);
        }
        if ((i & 16) != 0) {
            arrayList.add(16);
        }
        if ((i & 4) != 0) {
            arrayList.add(4);
        }
        if ((i & 8) != 0) {
            arrayList.add(8);
        }
        if ((i & 1) != 0) {
            arrayList.add(1);
        }
        if ((i & 256) != 0) {
            arrayList.add(256);
        }
        if ((i & 128) != 0) {
            arrayList.add(128);
        }
        if ((i & 64) != 0) {
            arrayList.add(64);
        }
        return arrayList;
    }

    public String b() {
        return this.r;
    }

    public void b(String str) {
        this.r = str;
    }

    public void b(boolean z) {
        a(z, (e) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<String> list) {
        String a2 = a(list);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("uids", a2);
        hashMap.put(TypedValues.TransitionType.S_FROM, "navi_service");
        hashMap.put(HttpConstants.SIGN, a(hashMap));
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaModel", "requestEmptyParkSpaceInfo->params:" + hashMap);
        }
        com.baidu.navisdk.util.http.center.b.a().a(com.baidu.navisdk.util.http.b.d().b("HighwayParkLeft"), hashMap, new b(list), null);
    }

    public boolean a(boolean z, Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateDirectionData-> isShow= ");
            sb.append(z);
            sb.append(", bundle= ");
            sb.append(bundle == null ? "null" : bundle.toString());
            gVar.e("RGHighwayServiceAreaModel", sb.toString());
        }
        if (!z) {
            this.s = false;
            this.u = null;
            return true;
        }
        if (bundle == null) {
            this.s = false;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaModel", "postDirectionBoardInfo-> bundle == null,return false");
            }
            return false;
        }
        String string = bundle.getString(RouteGuideParams.RGKey.DirectionInfo.NAME, "");
        String string2 = bundle.getString(RouteGuideParams.RGKey.DirectionInfo.CODE, "");
        int i = bundle.getInt(RouteGuideParams.RGKey.DirectionInfo.START_DIST, 0);
        int i2 = bundle.getInt(RouteGuideParams.RGKey.DirectionInfo.REMAIN_DIST, 0);
        int i3 = bundle.getInt(RouteGuideParams.RGKey.DirectionInfo.ADD_DIST, 0);
        if (l0.c(string)) {
            this.s = false;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaModel", "postDirectionBoardInfo-> 方向名为空，不显示");
            }
            return false;
        }
        a(string.replaceAll(",", " "), string2, i, i2, i3);
        return E();
    }

    public int d() {
        return this.k;
    }

    public int c() {
        return this.q;
    }

    private String c(String str) {
        if (l0.c(str)) {
            return str;
        }
        if (str.endsWith("方向")) {
            str = str.substring(0, str.lastIndexOf("方向"));
        }
        return str.contains(",") ? str.replace(",", " ") : str;
    }

    public void b(int i) {
        com.baidu.navisdk.framework.interfaces.pronavi.p pVar;
        boolean z;
        this.k = i;
        c(i);
        boolean z2 = z();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaModel", "updateServiceAreaRemainDist-> mServiceAreaList.size = " + this.f8952a.size() + "， mHasAllDatas= " + this.l + ", isPastArea= " + z2);
        }
        boolean z3 = true;
        if (z2) {
            if (this.l) {
                B();
                z = true;
            } else {
                z = false;
                b(false);
            }
            if (this.u != null) {
                E();
            } else {
                z3 = z;
            }
        }
        if (!z3 || (pVar = this.v) == null) {
            return;
        }
        pVar.a();
    }

    private void a(String str, String str2, int i, int i2, int i3) {
        if (this.u == null) {
            this.u = new com.baidu.navisdk.module.pronavi.model.d();
            this.u.e(str + str2 + i3);
            this.u.f(1000);
        }
        this.u.f(str);
        this.u.c(str2);
        this.u.d(i2);
        this.u.b(i3);
    }

    private void b(com.baidu.navisdk.module.pronavi.model.d dVar) {
        com.baidu.navisdk.model.datastruct.chargestation.b c2 = com.baidu.navisdk.ui.routeguide.model.d.c(dVar.g());
        if (c2 == null) {
            return;
        }
        dVar.b("charge_station_info", c2);
        if (dVar.p() == 6) {
            if (c2.e() == 3) {
                dVar.c(1);
            } else if (c2.e() == 5) {
                dVar.c(2);
            } else {
                dVar.c(0);
            }
        }
    }

    private String a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
                sb.append(",");
            }
        }
        int length = sb.length();
        if (length > 0) {
            sb.delete(length - 1, length);
        }
        return sb.toString();
    }

    public static String a(HashMap<String, String> hashMap) {
        Iterator<String> it = hashMap.keySet().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        Collections.sort(arrayList);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            stringBuffer.append(hashMap.get((String) it2.next()));
        }
        stringBuffer.append("846495F9CEED11ACCF8879F555936A7D");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaModel", "requestEmptyParkSpaceInfo getSignString->sorted params string:" + ((Object) stringBuffer));
        }
        return MD5.getMD5String(stringBuffer.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, List<String> list) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.getInt("errono") != 0 || (jSONObject = jSONObject2.getJSONObject("data")) == null) {
                return;
            }
            synchronized (this) {
                a(list, jSONObject);
                A();
            }
        } catch (Exception e2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                e2.printStackTrace();
                gVar.e("RGHighwayServiceAreaModel", "handleEmptyParkSpaceInfoResponse-> exception! e = " + e2);
            }
        }
    }

    private void a(List<String> list, JSONObject jSONObject) {
        JSONObject jSONObject2;
        for (String str : list) {
            try {
                jSONObject2 = jSONObject.getJSONObject(str);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (com.baidu.navisdk.util.common.g.PRO_NAV.c()) {
                    com.baidu.navisdk.util.common.g.PRO_NAV.c("RGHighwayServiceAreaModel", "parseEmptyParkingSpaceData-->getJSONObject Exception e = " + e2);
                }
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                com.baidu.navisdk.module.pronavi.model.a aVar = new com.baidu.navisdk.module.pronavi.model.a();
                try {
                    aVar.a(jSONObject2);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    if (com.baidu.navisdk.util.common.g.PRO_NAV.c()) {
                        com.baidu.navisdk.util.common.g.PRO_NAV.c("RGHighwayServiceAreaModel", "parseEmptyParkingSpaceData-->fillParkLotDetailData Exception e = " + e3);
                    }
                }
                this.w.put(str, aVar);
            }
        }
    }

    public void a(boolean z, e eVar) {
        synchronized (this) {
            com.baidu.navisdk.util.worker.c.a().c(new c("pullAllServiceAreaDatas", null, z, eVar), new com.baidu.navisdk.util.worker.e(99, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<com.baidu.navisdk.module.pronavi.model.d> list, e eVar) {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new d("handleResultOnMainThread-callback", null, list, eVar), new com.baidu.navisdk.util.worker.e(2, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.navisdk.module.pronavi.model.d dVar) {
        if (dVar.p() == 2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaModel", "pullAllServiceAreaDatas isBadData-> 入口直接跳过");
            }
            this.p++;
            return true;
        }
        if (dVar.p() != 3 && dVar.p() != 5) {
            if (dVar.p() == 6) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar2.d()) {
                    gVar2.e("RGHighwayServiceAreaModel", "pullAllServiceAreaDatas isBadData-> 单独的充电站，直接过滤");
                }
                return true;
            }
            if (dVar.p() == 7) {
                com.baidu.navisdk.model.datastruct.chargestation.b bVar = (com.baidu.navisdk.model.datastruct.chargestation.b) dVar.a("charge_station_info");
                if (bVar == null) {
                    com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar3.d()) {
                        gVar3.e("RGHighwayServiceAreaModel", "pullAllServiceAreaDatas isBadData-> 没有获取到充电站数据，直接过滤");
                    }
                    return true;
                }
                if ((bVar.d().g() <= 0 && bVar.d().c() <= 0) || TextUtils.isEmpty(bVar.j())) {
                    com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar4.d()) {
                        gVar4.e("RGHighwayServiceAreaModel", "pullAllServiceAreaDatas isBadData-> 充电站快慢充总数都为0或者充电站名称为空，直接过滤");
                    }
                    return true;
                }
            }
        } else if (l0.c(dVar.c()) && l0.c(dVar.e())) {
            com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar5.d()) {
                gVar5.e("RGHighwayServiceAreaModel", "pullAllServiceAreaDatas isBadData-> 出口没有道路名和方向名，直接过滤");
            }
            return true;
        }
        if (dVar.a() > 0 && dVar.a() - this.k > 0) {
            return false;
        }
        com.baidu.navisdk.util.common.g gVar6 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar6.d()) {
            gVar6.e("RGHighwayServiceAreaModel", "pullAllServiceAreaDatas isBadData-> 积算距离为负数，抛弃该服务区!, data.getAddDist()= " + dVar.a() + ", mCurAddDist= " + this.k);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.navisdk.module.pronavi.model.d a(Bundle bundle) {
        com.baidu.navisdk.module.pronavi.model.d dVar = new com.baidu.navisdk.module.pronavi.model.d();
        String string = bundle.getString("strUniqueId");
        dVar.e(string);
        dVar.b(this.d.contains(string));
        int i = bundle.getInt("enType");
        dVar.f(i);
        int i2 = bundle.getInt("enSubType");
        dVar.e(i2);
        dVar.a(d(i2));
        dVar.f(bundle.getString("strName"));
        dVar.c(bundle.getString("strExitIDName"));
        String c2 = c(bundle.getString("strExitDrName"));
        dVar.b(c2);
        String c3 = c(bundle.getString("strExitRoadName"));
        dVar.d(c3);
        dVar.b(bundle.getInt("unAddDist"));
        dVar.a(new GeoPoint((int) (bundle.getDouble("x", -2.147483648E9d) * 100000.0d), (int) (bundle.getDouble("y", -2.147483648E9d) * 100000.0d)));
        dVar.a(this.k);
        if (i == 2 || i == 3 || i == 5) {
            if (l0.c(c2)) {
                c2 = c3;
            }
            dVar.f(c2);
        }
        if (i == 7 || i == 6) {
            b(dVar);
        }
        if (i == 4) {
            boolean z = bundle.getBoolean("parkingAvailable");
            String string2 = bundle.getString("strUID");
            dVar.c(z);
            dVar.g(string2);
            if (t() && z && !TextUtils.isEmpty(string2)) {
                dVar.a(com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.a(string2));
                dVar.c(1);
            }
        }
        dVar.a(new com.baidu.navisdk.model.service.a(bundle.getInt("stationStatus"), bundle.getInt("brand"), bundle.getInt(TTDownloadField.TT_LABEL), bundle.getInt("gasType")));
        return dVar;
    }

    public List<com.baidu.navisdk.module.pronavi.model.d> a(boolean z) {
        if (z && this.b != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.b.size(); i++) {
                com.baidu.navisdk.module.pronavi.model.d dVar = this.b.get(i);
                if (!a(dVar)) {
                    arrayList.add(dVar);
                }
            }
            return arrayList;
        }
        return this.b;
    }

    public void a(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaModel", "subscribeServiceArea-> index= " + i + ", mServiceAreaList.size()= " + this.f8952a.size());
        }
        if (this.f8952a.size() > i) {
            com.baidu.navisdk.module.pronavi.model.d dVar = this.f8952a.get(i);
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaModel", "subscribeServiceArea-> index= " + i + ", BNServiceAreaBean= " + dVar.toString());
            }
            String g = dVar.g();
            if (dVar.s()) {
                dVar.b(false);
                this.d.remove(g);
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.3.2", "1", null, null);
            } else {
                dVar.b(true);
                this.d.add(g);
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.3.2", "0", null, null);
            }
        }
    }

    public void a() {
        this.f8952a.clear();
        this.c.clear();
        this.k = 0;
        this.m = 0;
        this.n = 0;
        this.q = 0;
        this.o = 0;
        this.p = 0;
        this.l = false;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.u = null;
        this.s = false;
        synchronized (this) {
            this.e.clear();
            w();
        }
    }

    public com.baidu.navisdk.module.pronavi.model.d a(String str) {
        if (this.b != null && !TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.b.size(); i++) {
                com.baidu.navisdk.module.pronavi.model.d dVar = this.b.get(i);
                if (str.equals(dVar.i())) {
                    return dVar;
                }
            }
        }
        return null;
    }
}
