package com.baidu.platform.comapi.wnplatform.j;

import com.baidu.mapapi.bikenavi.adapter.IBRoutePlanListener;
import com.baidu.mapapi.bikenavi.adapter.IBTTSPlayer;
import com.baidu.mapapi.bikenavi.controllers.BNavigatorWrapper;
import com.baidu.mapapi.bikenavi.params.BikeNaviLaunchParam;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f9923a;
    private static IBTTSPlayer b;
    private static com.baidu.platform.comapi.wnplatform.tts.c d = new d();
    private g c;

    public static a a() {
        if (f9923a == null) {
            synchronized (h.class) {
                try {
                    if (f9923a == null) {
                        f9923a = new a();
                    }
                } finally {
                }
            }
        }
        return f9923a;
    }

    public static void c() {
        if (BNavigatorWrapper.getWNavigator().D()) {
            BNavigatorWrapper.getWNavigator().A();
        }
    }

    public void b() {
        if (b != null) {
            b = null;
        }
        if (this.c != null) {
            BNavigatorWrapper.getWNavigator().J().b(this.c);
        }
    }

    public void b(BikeNaviLaunchParam bikeNaviLaunchParam, IBRoutePlanListener iBRoutePlanListener) {
        com.baidu.platform.comapi.wnplatform.model.c cVar = new com.baidu.platform.comapi.wnplatform.model.c();
        cVar.a(bikeNaviLaunchParam.getStartNodeInfo().getLocation());
        GeoPoint ll2mc = CoordUtil.ll2mc(bikeNaviLaunchParam.getStartNodeInfo().getLocation());
        com.baidu.platform.comapi.walknavi.b.a().a(bikeNaviLaunchParam.getStartNodeInfo().getLocation());
        com.baidu.platform.comapi.walknavi.b.a().a(cVar);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(bikeNaviLaunchParam.getEndNodeInfo().getLocation());
        com.baidu.platform.comapi.walknavi.f.a create = BikeNaviLaunchParam.create();
        if (bikeNaviLaunchParam.getVehicle() == 1) {
            create.a(bikeNaviLaunchParam.getVehicle());
        }
        create.b(1);
        BNavigatorWrapper.getWNavigator().e(1);
        BNavigatorWrapper.getWNavigator().f(bikeNaviLaunchParam.getExtraNaviMode());
        com.baidu.platform.comapi.walknavi.b.a().b(bikeNaviLaunchParam.getEndNodeInfo().getLocation());
        create.a((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), 131);
        create.c(0);
        create.a(new int[]{(int) ll2mc2.getLongitudeE6()}, new int[]{(int) ll2mc2.getLatitudeE6()}, new int[]{131});
        a(create, iBRoutePlanListener);
    }

    public void a(IBTTSPlayer iBTTSPlayer) {
        b = iBTTSPlayer;
    }

    public void a(BikeNaviLaunchParam bikeNaviLaunchParam, IBRoutePlanListener iBRoutePlanListener) {
        com.baidu.platform.comapi.walknavi.b.a().X().a(new b(this, bikeNaviLaunchParam, iBRoutePlanListener));
    }

    public void a(com.baidu.platform.comapi.walknavi.f.a aVar, IBRoutePlanListener iBRoutePlanListener) {
        b(aVar, iBRoutePlanListener);
    }

    private void b(com.baidu.platform.comapi.walknavi.f.a aVar, IBRoutePlanListener iBRoutePlanListener) {
        if (aVar == null) {
            return;
        }
        int a2 = aVar.a("vehicle", 0);
        if (a2 == 0) {
            BNavigatorWrapper.getWNavigator().a(1, 1);
        } else if (a2 == 1) {
            BNavigatorWrapper.getWNavigator().a(2, 1);
        }
        if (aVar.b("end_x") == null) {
            return;
        }
        int length = aVar.b("end_x").length;
        int i = length + 1;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        int[] iArr3 = new int[i];
        int[] iArr4 = new int[i];
        iArr[0] = aVar.a("start_x", 0);
        iArr2[0] = aVar.a("start_y", 0);
        iArr3[0] = aVar.a("start_cityid", 0);
        iArr4[0] = -1;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            iArr[i3] = aVar.b("end_x")[i2];
            i2 = i3;
        }
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            iArr2[i5] = aVar.b("end_y")[i4];
            i4 = i5;
        }
        int i6 = 0;
        while (i6 < length) {
            int i7 = i6 + 1;
            iArr3[i7] = aVar.b("end_cityid")[i6];
            i6 = i7;
        }
        int i8 = 0;
        while (i8 < length) {
            i8++;
            iArr4[i8] = i8;
        }
        if (BNavigatorWrapper.getWNavigator().J().a(iArr, iArr2, iArr3, iArr4)) {
            BNavigatorWrapper.getWNavigator().a(d);
            if (this.c == null) {
                this.c = new c(this, iBRoutePlanListener);
            }
            BNavigatorWrapper.getWNavigator().J().a(this.c);
            c();
            BNavigatorWrapper.getWNavigator().J().a(14, aVar.a("route_data_mode", 0), 0, aVar.a("vehicle", 0), aVar.a("route_buff"));
        }
    }
}
