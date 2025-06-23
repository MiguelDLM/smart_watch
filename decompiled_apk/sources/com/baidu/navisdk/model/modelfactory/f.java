package com.baidu.navisdk.model.modelfactory;

import android.content.Context;
import android.os.Bundle;
import com.baidu.entity.pb.Cars;
import com.baidu.entity.pb.PoiResult;
import com.baidu.entity.pb.TrafficPois;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.l;
import com.baidu.navisdk.model.datastruct.o;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.worker.g;
import com.garmin.fit.xOxOoo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class f extends com.baidu.navisdk.model.modelfactory.a {
    public static ArrayList<RoutePlanNode> y;
    private boolean b;
    public ArrayList<o> e;
    public int f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private Bundle[] k;
    public Map<Integer, a> l;
    private com.baidu.navisdk.util.worker.f<String, String> m;
    private Cars n;
    private Cars o;
    private boolean p;
    private boolean q;
    private boolean r;
    private String s;
    private int t;
    private boolean u;
    private int v;
    private int w;
    private int x;

    /* renamed from: a, reason: collision with root package name */
    private int f6952a = -1;
    private int c = 0;
    private final ArrayList<RoutePlanNode> d = new ArrayList<>();

    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f6953a;
        public int b;
        public int c;

        public a(f fVar) {
        }
    }

    static {
        new ArrayList();
    }

    public f() {
        new l();
        this.e = new ArrayList<>();
        this.f = 0;
        this.g = false;
        this.h = false;
        this.i = 0;
        this.j = 0;
        this.k = null;
        this.l = new HashMap();
        this.m = null;
        this.u = false;
        this.v = 0;
        this.w = 0;
        this.x = -1;
    }

    private String j(int i) {
        return i <= 1 ? "" : i != 2 ? i != 4 ? i != 8 ? i != 16 ? "推荐" : "躲避拥堵" : "少收费" : "不走高速" : "高速优先";
    }

    private void w() {
        com.baidu.navisdk.util.worker.c.a().a((g) this.m, true);
        this.m = null;
    }

    public synchronized void a(PoiResult poiResult) {
    }

    public void b() {
        this.e.clear();
    }

    public synchronized boolean c(boolean z) {
        return z;
    }

    public void d(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RoutePlan", "setGuideType,guideType:" + i);
        }
        this.t = i;
    }

    public int e() {
        return this.j;
    }

    public int f() {
        return this.i;
    }

    public RoutePlanNode g() {
        try {
            if (this.d.size() <= 1) {
                return null;
            }
            ArrayList<RoutePlanNode> arrayList = this.d;
            RoutePlanNode routePlanNode = arrayList.get(arrayList.size() - 1);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RoutePlan", "getEndNode --> endNode = " + routePlanNode);
            }
            return routePlanNode;
        } catch (Exception e) {
            LogUtil.printException("getEndNode Exception:", e);
            return null;
        }
    }

    public void h(int i) {
    }

    public synchronized String i() {
        return this.s;
    }

    public ArrayList<RoutePlanNode> k() {
        if (LogUtil.LOGGABLE) {
            a("getRouteInput", this.d);
        }
        return (ArrayList) this.d.clone();
    }

    public ArrayList<o> l() {
        return this.e;
    }

    public Bundle m() {
        LogUtil.e("wangyang", "getRoutePlanBundle start");
        Bundle bundle = new Bundle();
        if (BNRoutePlaner.getInstance().a(this.f, bundle) == 2) {
            LogUtil.e("wangyang", "getRoutePlanBundle: full");
            return bundle;
        }
        return null;
    }

    public int n() {
        return this.f6952a;
    }

    public RoutePlanNode o() {
        try {
            if (this.d.size() <= 0) {
                return null;
            }
            return this.d.get(0);
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("getStartNode", e);
            }
            return null;
        }
    }

    public int p() {
        a aVar = this.l.get(Integer.valueOf(this.f));
        if (aVar != null) {
            LogUtil.e("wangyang", "getTotalDistanceInt-> Parse");
            return aVar.c;
        }
        Bundle m = m();
        if (m != null) {
            a(com.baidu.navisdk.framework.a.c().a(), m);
            if (a(this.f)) {
                a aVar2 = this.l.get(Integer.valueOf(this.f));
                if (aVar2 == null) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("RoutePlan", "getTotalDistanceInt-> info == null");
                    }
                    return 0;
                }
                return aVar2.c;
            }
        }
        return 0;
    }

    public int q() {
        try {
            if (a(this.f)) {
                return this.l.get(Integer.valueOf(this.f)).f6953a;
            }
            Bundle m = m();
            if (m != null) {
                a(com.baidu.navisdk.framework.a.c().a(), m);
                if (a(this.f) && this.l.get(Integer.valueOf(this.f)) != null) {
                    return this.l.get(Integer.valueOf(this.f)).f6953a;
                }
                return 0;
            }
            return 0;
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("getTotalTimeInt", e);
                return 0;
            }
            return 0;
        }
    }

    public synchronized boolean r() {
        return this.p;
    }

    public synchronized boolean s() {
        return this.r;
    }

    public boolean t() {
        return this.u;
    }

    public synchronized boolean u() {
        return this.q;
    }

    public boolean v() {
        return this.g;
    }

    private void b(Context context, Bundle bundle) {
        a aVar = new a(this);
        aVar.c = bundle.getInt("totaldistance");
        aVar.f6953a = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime);
        aVar.b = bundle.getInt("nodenum");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_PLAN;
        if (gVar.d()) {
            gVar.e("parseRouteResult mDistance = " + aVar.c + " mTime = " + aVar.f6953a + " mNodeNum = " + aVar.b);
        }
        if (aVar.b <= 0) {
            gVar.a("route plan not finished mNodeNum si 0");
        }
        String[] stringArray = bundle.getStringArray("nextroadname");
        if (stringArray == null) {
            stringArray = new String[aVar.b];
            Arrays.fill(stringArray, "");
        }
        int[] intArray = bundle.getIntArray(xOxOoo.f15470o00);
        int[] intArray2 = bundle.getIntArray("turntype");
        bundle.getIntArray("ptX");
        bundle.getIntArray("ptY");
        bundle.getIntArray("roadCond");
        bundle.getIntArray("linkAngle");
        bundle.getString("mainroads");
        bundle.getInt("trafficlightcnt");
        bundle.getInt("tollfees");
        bundle.getInt("gasmoney");
        bundle.getString("pusDirection");
        bundle.getString("pusDetectedRoad");
        if (stringArray.length >= 1) {
            int i = 1;
            while (true) {
                if (i >= stringArray.length) {
                    break;
                }
                if (!l0.c(stringArray[i])) {
                    String str = stringArray[i];
                    break;
                }
                i++;
            }
        }
        if (intArray2.length >= 2) {
            int i2 = intArray2[1];
        }
        if (intArray.length >= 2) {
            int i3 = intArray[0];
        }
        this.l.put(Integer.valueOf(this.f), aVar);
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.ROUTE_PLAN;
        if (gVar2.d()) {
            gVar2.e("mAllRoutePlanInfo.put  done mCurRouteIndex = " + this.f);
        }
    }

    public synchronized void a(TrafficPois trafficPois) {
    }

    public void c() {
        LogUtil.e("wangyang", "clearRouteResult");
        this.l.clear();
        this.e.clear();
        this.f = 0;
    }

    public void e(boolean z) {
        this.u = z;
    }

    public void f(int i) {
        this.f6952a = i;
    }

    public void h(boolean z) {
        this.g = z;
    }

    public synchronized void i(int i) {
        this.x = i;
    }

    public int j() {
        return this.v;
    }

    public synchronized void a(byte[] bArr) {
    }

    public void e(int i) {
        this.v = i;
    }

    public synchronized void f(boolean z) {
        this.q = z;
    }

    public int h() {
        return this.t;
    }

    public void a(ArrayList<Bundle> arrayList) {
        b();
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        b();
        this.c = arrayList.size();
        for (int i = 0; i < this.c; i++) {
            Bundle bundle = arrayList.get(i);
            int i2 = bundle.getInt("totaldistance");
            int i3 = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime);
            int i4 = bundle.getInt("trafficlightcnt");
            int i5 = bundle.getInt("tollfees");
            String string = bundle.getString("pusLabelName");
            int b = BNRoutePlaner.getInstance().b();
            int i6 = bundle.getInt("pusLabelID");
            if ("".equals(string) && b != 1) {
                if (i == 0) {
                    string = j(b);
                } else {
                    if (i == 1) {
                        string = "方案二";
                    }
                    if (i == 2) {
                        string = "方案三";
                    }
                }
            }
            this.e.add(new o(i, "", i5, i4, 0, i2, i3, string, bundle.getString("pusLabelTips"), i6));
        }
        Bundle bundle2 = arrayList.get(0);
        bundle2.getIntArray("prefId");
        bundle2.getStringArray("prefStr");
    }

    public synchronized Cars d() {
        return this.n;
    }

    public synchronized void d(boolean z) {
        this.r = z;
    }

    public void c(int i) {
        this.i = i;
    }

    public synchronized void g(boolean z) {
        this.b = z;
    }

    public void g(int i) {
        this.w = i;
    }

    public void a(Context context, Bundle bundle) {
        if (context == null) {
            return;
        }
        try {
            b(context, bundle);
        } catch (Exception e) {
            com.baidu.navisdk.util.common.g.ROUTE_PLAN.d("parseRouteResult err: " + e.getLocalizedMessage());
        }
    }

    public boolean a(int i) {
        return this.l.get(Integer.valueOf(i)) != null;
    }

    public void a() {
        w();
        this.d.clear();
    }

    private void a(String str, List<RoutePlanNode> list) {
        if (LogUtil.LOGGABLE) {
            if (list == null) {
                LogUtil.e("RoutePlan", str + " --> routePlanNodeList is null!!!");
                return;
            }
            ArrayList<RoutePlanNode> arrayList = new ArrayList(list);
            StringBuilder sb = new StringBuilder(str + " --> routePlanNodeList is ");
            for (RoutePlanNode routePlanNode : arrayList) {
                sb.append("\n       ");
                sb.append(routePlanNode);
            }
            LogUtil.e("RoutePlan", sb.toString());
        }
    }

    public void b(ArrayList<RoutePlanNode> arrayList) {
        if (LogUtil.LOGGABLE) {
            a("setRouteInput", arrayList);
        }
        com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.b(arrayList);
        if (arrayList == null) {
            return;
        }
        a();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.d.add(arrayList.get(i).mo81clone());
        }
    }

    public String a(Context context, boolean z) {
        try {
            if (this.d.size() <= 1) {
                return "";
            }
            ArrayList<RoutePlanNode> arrayList = this.d;
            return a(context, arrayList.get(arrayList.size() - 1), z);
        } catch (Exception e) {
            LogUtil.printException("getEndName Exception:", e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(android.content.Context r3, com.baidu.navisdk.model.datastruct.RoutePlanNode r4, boolean r5) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            if (r4 == 0) goto L7c
            if (r3 == 0) goto L7c
            boolean r3 = r4.isNodeSettedData()
            if (r3 != 0) goto Le
            goto L7c
        Le:
            int r3 = r4.mFrom     // Catch: java.lang.Exception -> L2c
            r1 = 1
            if (r3 == r1) goto L45
            r1 = 3
            if (r3 == r1) goto L36
            r1 = 4
            if (r3 == r1) goto L32
            r1 = 5
            if (r3 == r1) goto L2e
            java.lang.String r3 = r4.mName     // Catch: java.lang.Exception -> L2c
            boolean r3 = com.baidu.navisdk.util.common.l0.c(r3)     // Catch: java.lang.Exception -> L2c
            if (r3 == 0) goto L28
            java.lang.String r0 = "未知路"
            goto L5d
        L28:
            java.lang.String r3 = r4.mName     // Catch: java.lang.Exception -> L2c
        L2a:
            r0 = r3
            goto L5d
        L2c:
            r3 = move-exception
            goto L54
        L2e:
            java.lang.String r0 = "公司"
            goto L5d
        L32:
            java.lang.String r0 = "家"
            goto L5d
        L36:
            java.lang.String r3 = r4.mName     // Catch: java.lang.Exception -> L2c
            boolean r3 = com.baidu.navisdk.util.common.l0.c(r3)     // Catch: java.lang.Exception -> L2c
            if (r3 == 0) goto L42
            java.lang.String r0 = "我的位置"
            goto L5d
        L42:
            java.lang.String r3 = r4.mName     // Catch: java.lang.Exception -> L2c
            goto L2a
        L45:
            java.lang.String r3 = r4.mName     // Catch: java.lang.Exception -> L2c
            boolean r3 = com.baidu.navisdk.util.common.l0.c(r3)     // Catch: java.lang.Exception -> L2c
            if (r3 == 0) goto L51
            java.lang.String r0 = "地图上的点"
            goto L5d
        L51:
            java.lang.String r3 = r4.mName     // Catch: java.lang.Exception -> L2c
            goto L2a
        L54:
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "RoutePlan"
            com.baidu.navisdk.util.common.LogUtil.e(r4, r3)
        L5d:
            if (r5 == 0) goto L7c
            int r3 = r0.length()
            r4 = 6
            if (r3 <= r4) goto L7c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r5 = 0
            java.lang.String r4 = r0.substring(r5, r4)
            r3.append(r4)
            java.lang.String r4 = "..."
            r3.append(r4)
            java.lang.String r0 = r3.toString()
        L7c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.model.modelfactory.f.a(android.content.Context, com.baidu.navisdk.model.datastruct.RoutePlanNode, boolean):java.lang.String");
    }

    public String b(Context context, boolean z) {
        return this.d.size() <= 0 ? "" : a(context, this.d.get(0), z);
    }

    public void b(int i) {
        this.j = i;
    }

    public synchronized void b(Cars cars) {
        this.o = cars;
    }

    public synchronized void b(boolean z) {
        this.p = z;
    }

    public void a(Bundle[] bundleArr) {
        this.k = bundleArr;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public synchronized void a(Cars cars) {
        this.n = cars;
    }

    public synchronized void a(String str) {
        this.s = str;
    }
}
