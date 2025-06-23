package com.baidu.platform.comapi.wnplatform.model;

import XIXIX.OOXIXo;
import android.os.Bundle;
import com.baidu.entity.pb.IndoorNavi;
import com.baidu.entity.pb.WalkPlan;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.google.protobuf.micro.MessageMicro;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class e extends a {

    /* renamed from: a, reason: collision with root package name */
    private int f9940a = 0;
    private int b = 0;
    private int c = 1;
    private ArrayList<LatLng> d = new ArrayList<>();
    private WalkPlan e = null;

    public void a() {
        this.f9940a = 0;
        this.b = 0;
        ArrayList<LatLng> arrayList = this.d;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public WalkPlan b() {
        return this.e;
    }

    public int b(WalkPlan walkPlan, int i) {
        int i2 = 0;
        if (walkPlan == null) {
            return 0;
        }
        WalkPlan.Routes routes = i < walkPlan.getRoutesCount() ? walkPlan.getRoutes(i) : null;
        if (routes != null) {
            Iterator<WalkPlan.Routes.Legs> it = routes.getLegsList().iterator();
            while (it.hasNext()) {
                i2 += it.next().getDistance();
            }
        }
        Iterator<IndoorNavi> it2 = walkPlan.getIndoorNavisList().iterator();
        while (it2.hasNext()) {
            Iterator<IndoorNavi.Routes> it3 = it2.next().getRoutesList().iterator();
            while (it3.hasNext()) {
                Iterator<IndoorNavi.Routes.Legs> it4 = it3.next().getLegsList().iterator();
                while (it4.hasNext()) {
                    i2 += it4.next().getDistance();
                }
            }
        }
        return i2;
    }

    public void a(Bundle bundle, int i) {
        WalkPlan walkPlan;
        WalkPlan walkPlan2;
        a();
        if (bundle == null) {
            return;
        }
        this.c = i;
        this.f9940a = bundle.getInt("totaldistance");
        this.b = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime);
        if (this.f9940a <= 0 && (walkPlan2 = this.e) != null) {
            this.f9940a = b(walkPlan2, com.baidu.platform.comapi.walknavi.b.a().b());
        }
        if (this.b <= 0 && (walkPlan = this.e) != null) {
            this.b = a(walkPlan, com.baidu.platform.comapi.walknavi.b.a().b());
        }
        double[] doubleArray = bundle.getDoubleArray("ptShapeX");
        double[] doubleArray2 = bundle.getDoubleArray("ptShapeY");
        if (doubleArray == null || doubleArray2 == null) {
            return;
        }
        LatLng latLng = new LatLng(OOXIXo.f3760XO, OOXIXo.f3760XO);
        for (int i2 = 0; i2 < doubleArray.length; i2++) {
            LatLng gcjToBaidu = CoordTrans.gcjToBaidu(new LatLng(doubleArray2[i2], doubleArray[i2]));
            if (Math.abs(latLng.longitude - gcjToBaidu.longitude) >= 1.0E-6d || Math.abs(latLng.latitude - gcjToBaidu.latitude) >= 1.0E-6d) {
                this.d.add(gcjToBaidu);
                latLng = gcjToBaidu;
            }
        }
    }

    public boolean a(com.baidu.platform.comapi.wnplatform.e.a aVar) {
        MessageMicro messageMicro;
        com.baidu.platform.comapi.wnplatform.e.c cVar = aVar instanceof com.baidu.platform.comapi.wnplatform.e.c ? (com.baidu.platform.comapi.wnplatform.e.c) aVar : null;
        if (cVar == null || (messageMicro = cVar.a().get(0)) == null) {
            return false;
        }
        try {
            this.e = (WalkPlan) messageMicro;
            com.baidu.platform.comapi.walknavi.b.a().a(this.e);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public int a(WalkPlan walkPlan, int i) {
        int i2 = 0;
        if (walkPlan == null) {
            return 0;
        }
        WalkPlan.Routes routes = i < walkPlan.getRoutesCount() ? walkPlan.getRoutes(i) : null;
        if (routes != null) {
            Iterator<WalkPlan.Routes.Legs> it = routes.getLegsList().iterator();
            while (it.hasNext()) {
                i2 += it.next().getDuration();
            }
        }
        Iterator<IndoorNavi> it2 = walkPlan.getIndoorNavisList().iterator();
        while (it2.hasNext()) {
            Iterator<IndoorNavi.Routes> it3 = it2.next().getRoutesList().iterator();
            while (it3.hasNext()) {
                Iterator<IndoorNavi.Routes.Legs> it4 = it3.next().getLegsList().iterator();
                while (it4.hasNext()) {
                    i2 += it4.next().getDuration();
                }
            }
        }
        return i2;
    }
}
