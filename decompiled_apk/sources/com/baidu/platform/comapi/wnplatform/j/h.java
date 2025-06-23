package com.baidu.platform.comapi.wnplatform.j;

import android.text.TextUtils;
import com.baidu.entity.pb.WalkPlan;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.adapter.IWTTSPlayer;
import com.baidu.mapapi.walknavi.controllers.WNavigatorWrapper;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
import com.baidu.mapapi.walknavi.params.WalkNaviLaunchParam;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;

/* loaded from: classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static h f9926a;
    private static IWTTSPlayer c;
    private static com.baidu.platform.comapi.wnplatform.tts.c d = new k();
    private f b;

    public static h a() {
        if (f9926a == null) {
            synchronized (h.class) {
                try {
                    if (f9926a == null) {
                        f9926a = new h();
                    }
                } finally {
                }
            }
        }
        return f9926a;
    }

    public static void c() {
        if (WNavigatorWrapper.getWNavigator().D()) {
            WNavigatorWrapper.getWNavigator().A();
        }
    }

    public void b() {
        if (d != null) {
            d = null;
        }
        if (this.b != null) {
            com.baidu.platform.comapi.walknavi.b.a().b(this.b);
        }
    }

    public boolean b(WalkNaviLaunchParam walkNaviLaunchParam) {
        LatLng location;
        LatLng location2;
        if (walkNaviLaunchParam.getStartNodeInfo() == null) {
            location = walkNaviLaunchParam.getStartPt();
        } else {
            location = walkNaviLaunchParam.getStartNodeInfo().getLocation();
        }
        if (walkNaviLaunchParam.getEndNodeInfo() == null) {
            location2 = walkNaviLaunchParam.getEndPt();
        } else {
            location2 = walkNaviLaunchParam.getEndNodeInfo().getLocation();
        }
        Point ll2point = CoordUtil.ll2point(location);
        Point ll2point2 = CoordUtil.ll2point(location2);
        return ll2point == null || ll2point2 == null || CoordUtil.getDistance(ll2point, ll2point2) > 50000.0d;
    }

    public void a(IWTTSPlayer iWTTSPlayer) {
        c = iWTTSPlayer;
    }

    public void a(WalkNaviLaunchParam walkNaviLaunchParam, IWRoutePlanListener iWRoutePlanListener, boolean z) {
        LatLng startPt;
        LatLng endPt;
        if (z) {
            startPt = walkNaviLaunchParam.getStartNodeInfo().getLocation();
            endPt = walkNaviLaunchParam.getEndNodeInfo().getLocation();
        } else {
            startPt = walkNaviLaunchParam.getStartPt();
            endPt = walkNaviLaunchParam.getEndPt();
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(startPt);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(endPt);
        com.baidu.platform.comapi.walknavi.f.c create = WalkNaviLaunchParam.create();
        create.b(1);
        create.c(1);
        create.a(0);
        WNavigatorWrapper.getWNavigator().e(1);
        WNavigatorWrapper.getWNavigator().f(walkNaviLaunchParam.getExtraNaviMode());
        com.baidu.platform.comapi.walknavi.b.a().a(startPt);
        com.baidu.platform.comapi.walknavi.b.a().b(endPt);
        create.a((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), 131);
        create.d(0);
        create.a(new int[]{(int) ll2mc2.getLongitudeE6()}, new int[]{(int) ll2mc2.getLatitudeE6()}, new int[]{131});
        a(create, iWRoutePlanListener);
    }

    private boolean b(com.baidu.platform.comapi.walknavi.f.c cVar) {
        if (cVar.b("end_x") == null) {
            return false;
        }
        int length = cVar.b("end_x").length;
        int i = length + 1;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        int[] iArr3 = new int[i];
        int[] iArr4 = new int[i];
        String[] strArr = new String[i];
        String[] strArr2 = new String[i];
        iArr[0] = cVar.a("start_x", 0);
        iArr2[0] = cVar.a("start_y", 0);
        iArr3[0] = cVar.a("start_cityid", 0);
        strArr[0] = cVar.a("start_floor", "");
        strArr2[0] = cVar.a("start_building", "");
        iArr4[0] = -1;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            iArr[i3] = cVar.b("end_x")[i2];
            i2 = i3;
        }
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            iArr2[i5] = cVar.b("end_y")[i4];
            i4 = i5;
        }
        int i6 = 0;
        while (i6 < length) {
            int i7 = i6 + 1;
            iArr3[i7] = cVar.b("end_cityid")[i6];
            i6 = i7;
        }
        int i8 = 0;
        while (i8 < length) {
            i8++;
            iArr4[i8] = -2;
        }
        int i9 = 0;
        while (i9 < length) {
            i9++;
            strArr[i9] = "";
        }
        int i10 = 0;
        while (i10 < length) {
            i10++;
            strArr2[i10] = "";
        }
        String[] c2 = cVar.c("end_floor");
        String[] c3 = cVar.c("end_building");
        if (c2 != null && length == c2.length) {
            for (int i11 = 0; i11 < length; i11++) {
                if (!TextUtils.isEmpty(c2[i11])) {
                    strArr[i11 + 1] = c2[i11];
                } else {
                    strArr[i11 + 1] = "";
                }
            }
        }
        if (c3 != null && length == c3.length) {
            for (int i12 = 0; i12 < length; i12++) {
                if (!TextUtils.isEmpty(c3[i12])) {
                    strArr2[i12 + 1] = c3[i12];
                } else {
                    strArr2[i12 + 1] = "";
                }
            }
        }
        return WNavigatorWrapper.getWNavigator().J().a(iArr, iArr2, iArr3, iArr4, strArr, strArr2);
    }

    public void a(WalkNaviLaunchParam walkNaviLaunchParam, IWRoutePlanListener iWRoutePlanListener) {
        com.baidu.platform.comapi.walknavi.b.a().X().a(new i(this, walkNaviLaunchParam, iWRoutePlanListener));
    }

    public void a(WalkPlan walkPlan) {
        LatLng mc2ll = CoordUtil.mc2ll(new GeoPoint(walkPlan.getOption().getStart().getSpt(1), walkPlan.getOption().getStart().getSpt(0)));
        com.baidu.platform.comapi.walknavi.b.a().a(mc2ll);
        int size = walkPlan.getOption().getEndList().size() - 1;
        com.baidu.platform.comapi.walknavi.b.a().b(CoordUtil.mc2ll(new GeoPoint(walkPlan.getOption().getEnd(size).getSpt(1), walkPlan.getOption().getEnd(size).getSpt(0))));
        String floor = walkPlan.getOption().getStart().getFloor();
        String building = walkPlan.getOption().getStart().getBuilding();
        com.baidu.platform.comapi.wnplatform.model.c cVar = new com.baidu.platform.comapi.wnplatform.model.c();
        cVar.a(mc2ll);
        cVar.a(building);
        cVar.b(floor);
        com.baidu.platform.comapi.walknavi.b.a().a(cVar);
        GeoPoint ll2mc = CoordUtil.ll2mc(mc2ll);
        com.baidu.platform.comapi.walknavi.b.a().K().a((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), 0, building, floor);
    }

    public boolean a(WalkNaviLaunchParam walkNaviLaunchParam) {
        LatLng location;
        LatLng location2;
        if (walkNaviLaunchParam.getStartNodeInfo() == null) {
            location = walkNaviLaunchParam.getStartPt();
        } else {
            location = walkNaviLaunchParam.getStartNodeInfo().getLocation();
        }
        if (walkNaviLaunchParam.getEndNodeInfo() == null) {
            location2 = walkNaviLaunchParam.getEndPt();
        } else {
            location2 = walkNaviLaunchParam.getEndNodeInfo().getLocation();
        }
        Point ll2point = CoordUtil.ll2point(location);
        Point ll2point2 = CoordUtil.ll2point(location2);
        return ll2point == null || ll2point2 == null || CoordUtil.getDistance(ll2point, ll2point2) < 30.0d;
    }

    public com.baidu.platform.comapi.walknavi.f.c a(WalkPlan walkPlan, WalkNaviLaunchParam walkNaviLaunchParam) {
        com.baidu.platform.comapi.walknavi.f.c create = WalkNaviLaunchParam.create();
        create.b(1);
        create.c(walkNaviLaunchParam.getExtraNaviMode());
        create.a(0);
        create.a(walkPlan.getOption().getStart().getSpt(0), walkPlan.getOption().getStart().getSpt(1), walkPlan.getOption().getStartCity().getCode(), walkPlan.getOption().getStart().getFloor(), walkPlan.getOption().getStart().getBuilding());
        int size = walkPlan.getOption().getEndList().size();
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        int[] iArr3 = new int[size];
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        for (int i = 0; i < walkPlan.getOption().getEndList().size(); i++) {
            iArr[i] = walkPlan.getOption().getEnd(i).getSpt(0);
            iArr2[i] = walkPlan.getOption().getEnd(i).getSpt(1);
            iArr3[i] = walkPlan.getOption().getEndCity(0).getCode();
            strArr[i] = walkPlan.getOption().getEnd(i).getFloor();
            strArr2[i] = walkPlan.getOption().getEnd(i).getBuilding();
        }
        create.a(iArr, iArr2, iArr3, strArr, strArr2);
        create.d(2);
        create.a(walkPlan.toByteArray());
        return create;
    }

    public boolean a(com.baidu.platform.comapi.walknavi.f.c cVar) {
        if (!b(cVar)) {
            return false;
        }
        WNavigatorWrapper.getWNavigator().a(d);
        c();
        return true;
    }

    private void a(com.baidu.platform.comapi.walknavi.f.c cVar, IWRoutePlanListener iWRoutePlanListener) {
        WNavigatorWrapper.getWNavigator().a(0, 0);
        if (!b(cVar)) {
            iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.PARSE_FAIL);
        }
        WNavigatorWrapper.getWNavigator().a(d);
        WNavigatorWrapper.getWNavigator().J().a(new j(this, iWRoutePlanListener));
        c();
        WNavigatorWrapper.getWNavigator().J().a(13, cVar.a("route_data_mode", 0), 0, cVar.a("vehicle", 0), cVar.a("route_buff"));
    }
}
