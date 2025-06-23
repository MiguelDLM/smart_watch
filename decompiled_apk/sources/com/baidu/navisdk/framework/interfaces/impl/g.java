package com.baidu.navisdk.framework.interfaces.impl;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mapframework.location.LocationChangeListener;
import com.baidu.mapframework.location.LocationManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.routeplan.a;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.w;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.common.o;
import com.baidu.navisdk.util.logic.j;
import com.baidu.navisdk.util.statistic.t;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/* loaded from: classes7.dex */
public class g implements com.baidu.navisdk.comapi.routeplan.b {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<w> f6813a = new ArrayList<>();

    private void a(com.baidu.navisdk.comapi.routeplan.v2.b bVar, com.baidu.navisdk.module.routepreference.a aVar) {
        LogUtil.e("RoutePlan", "repairData networkMode:" + bVar.i);
        if (bVar.i == -1) {
            bVar.i = aVar.d();
        }
        b(bVar, aVar);
        c(bVar);
        d(bVar);
    }

    private void d(com.baidu.navisdk.comapi.routeplan.v2.b bVar) {
        if (bVar.r == null) {
            bVar.r = new Bundle();
        }
        Bundle bundle = bVar.r;
        int m = bVar.m();
        if (bundle.containsKey("isNovice")) {
            boolean z = bundle.getBoolean("isNovice", false);
            if (m == 0 || m == 1) {
                BNSettingManager.putNavPreferMode(z ? 1 : 0);
                return;
            }
            return;
        }
        if (m != 0 && m != 1) {
            bundle.putBoolean("isNovice", false);
        } else {
            bundle.putBoolean("isNovice", BNSettingManager.isNoviceMode());
        }
    }

    @Override // com.baidu.navisdk.comapi.routeplan.b
    public void b(com.baidu.navisdk.comapi.routeplan.v2.b bVar) {
        a(bVar, com.baidu.navisdk.module.routepreference.c.d(bVar.m()));
    }

    @Override // com.baidu.navisdk.comapi.routeplan.b
    public void c() {
        com.baidu.navisdk.model.datastruct.g a2 = com.baidu.navisdk.util.logic.a.j().a();
        if (a2 == null || !a2.b()) {
            return;
        }
        String str = a2.n;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RoutePlan", "calcRouteV2() roadLoc:" + str);
        }
        if (!TextUtils.isEmpty(str)) {
            JNIGuidanceControl.getInstance().setStartPosLocInfo(str);
        } else {
            JNIGuidanceControl.getInstance().setStartPosLocInfo("");
        }
    }

    @Override // com.baidu.navisdk.comapi.routeplan.b
    public int b(int i) {
        return com.baidu.navisdk.module.routepreference.c.e(i);
    }

    @Override // com.baidu.navisdk.comapi.routeplan.b
    public void b() {
        j.r().p();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x04ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(com.baidu.navisdk.comapi.routeplan.v2.b r28, com.baidu.navisdk.module.routepreference.a r29) {
        /*
            Method dump skipped, instructions count: 1280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.framework.interfaces.impl.g.b(com.baidu.navisdk.comapi.routeplan.v2.b, com.baidu.navisdk.module.routepreference.a):void");
    }

    @Override // com.baidu.navisdk.comapi.routeplan.b
    public void a(int i) {
        com.baidu.navisdk.module.routepreference.d.j().g(i);
    }

    @Override // com.baidu.navisdk.comapi.routeplan.b
    public int a() {
        boolean g = j.r().g();
        boolean m = j.r().m();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_PLAN;
        if (gVar.d()) {
            gVar.e("RoutePlan", "calcRouteInner (1087): --> gpsEnabled: " + g + ", locValid: " + m);
        }
        int i = g ? m ? 1 : 2 : 0;
        if (i == 1) {
            if (System.currentTimeMillis() - j.r().e() > 5000) {
                return 2;
            }
        }
        return i;
    }

    private void c(com.baidu.navisdk.comapi.routeplan.v2.b bVar) {
        BNRoutePlaner.getInstance().f(bVar.f);
    }

    private void c(@NonNull RoutePlanNode routePlanNode) {
        com.baidu.navisdk.util.logic.f r;
        if (TextUtils.equals(routePlanNode.getName(), "我的位置")) {
            if (com.baidu.navisdk.j.e()) {
                r = com.baidu.navisdk.util.logic.a.j();
            } else {
                r = j.r();
            }
            routePlanNode.mSensorAngle = com.baidu.navisdk.framework.b.t();
            routePlanNode.setFrom(3);
            routePlanNode.setNodeType(3);
            routePlanNode.setName("我的位置");
            routePlanNode.setDistrictID(com.baidu.navisdk.framework.b.d(routePlanNode.getDistrictID()));
            routePlanNode.setUID("");
            com.baidu.navisdk.model.datastruct.g a2 = r.a();
            if (a2 == null) {
                return;
            }
            LogUtil.out("RoutePlan", "calcRouteV2 --> curLocData.type = " + a2.i + ", curLocData.networkLocType = " + a2.m + ", curLocData.longitude = " + a2.b + ", curLocData.latitude = " + a2.f6926a + ", curLocData.direction = " + a2.e + ", curLocData.accuracy = " + a2.f + ", curLocData.speed = " + a2.c + ", curLocData.altitude = " + a2.h + ", curLocData.floorId = " + a2.p + ", curLocData.buildingId = " + a2.q);
            routePlanNode.setGeoPoint(new GeoPoint((int) (a2.b * 100000.0d), (int) (a2.f6926a * 100000.0d)));
            routePlanNode.mLocType = a2.k;
            routePlanNode.mGPSAngle = a2.e;
            routePlanNode.mGPSAccuracy = a2.f;
            routePlanNode.mGPSSpeed = a2.c / 3.6f;
            routePlanNode.mBias = a2.d;
            routePlanNode.mAltitude = (float) a2.h;
            routePlanNode.setFloorId(a2.p);
            routePlanNode.setBuildingID(a2.q);
        }
    }

    private void d(RoutePlanNode routePlanNode) {
        if (TextUtils.equals(routePlanNode.mName, "我的位置")) {
            if (routePlanNode.getNodeType() != 3) {
                com.baidu.navisdk.util.common.g.ROUTE_PLAN.a("node type err: " + routePlanNode.getNodeType());
            }
            routePlanNode.setFrom(3);
            routePlanNode.setNodeType(3);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeplan.b
    public void a(@NonNull com.baidu.navisdk.comapi.routeplan.v2.b bVar, boolean z) {
        int m = bVar.m();
        int k = bVar.k();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_PLAN;
        if (gVar.d()) {
            gVar.e("calcRouteV2 --> vehicle = " + m + ", subVehicle = " + k);
            ArrayList arrayList = new ArrayList();
            arrayList.add(bVar.f6726a);
            List<RoutePlanNode> list = bVar.c;
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(bVar.b);
            gVar.a("RoutePlan", "beforeUpdateRpNodes", "nodeList", arrayList);
        }
        b(bVar.f6726a, z, m, k);
        a(bVar.c, z, m, k);
        a(bVar.b, z, m, k);
        if (gVar.d()) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(bVar.f6726a);
            List<RoutePlanNode> list2 = bVar.c;
            if (list2 != null) {
                arrayList2.addAll(list2);
            }
            arrayList2.add(bVar.b);
            gVar.a("RoutePlan", "afterUpdateRpNodes", "nodeList", arrayList2);
            try {
                gVar.e("RoutePlan", "calcRouteV2 --> hasOnEvent=" + t.u().q());
                a(bVar.f, bVar.f6726a);
                gVar.e("[[[checkList_RoutePlan]]]", "calcRouteV2 --> startNode" + bVar.f6726a);
                gVar.e("[[[checkList_RoutePlan]]]", "calcRouteV2 --> endNode" + bVar.b);
            } catch (Exception e) {
                com.baidu.navisdk.util.common.g.ROUTE_PLAN.e("RoutePlan", "calcRouteV2 --> exception = " + e);
            }
        }
    }

    private void a(List<RoutePlanNode> list, boolean z, int i, int i2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (RoutePlanNode routePlanNode : list) {
            if (routePlanNode != null) {
                d(routePlanNode);
                a(routePlanNode, i, i2, true);
            }
        }
    }

    private void a(RoutePlanNode routePlanNode, boolean z, int i, int i2) {
        if (routePlanNode == null) {
            return;
        }
        d(routePlanNode);
        a(routePlanNode, i, i2, false);
        if (z) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RoutePlan", "calcRouteV2 --> updateEndNode, endNodeName = " + routePlanNode.mName);
            }
            a(routePlanNode);
        }
    }

    private void a(RoutePlanNode routePlanNode, int i, int i2, boolean z) {
        a.C0182a c0182a = com.baidu.navisdk.comapi.routeplan.a.c;
        c0182a.a().b(routePlanNode);
        if (z && i == 1 && i2 == 1) {
            if (routePlanNode.mIconType > 0 || !c0182a.a().a(routePlanNode)) {
                return;
            }
            routePlanNode.setIconType(1);
            return;
        }
        routePlanNode.setIconType(0);
    }

    private void a(@NonNull RoutePlanNode routePlanNode) {
        if (TextUtils.equals(routePlanNode.getName(), "我的位置")) {
            if (com.baidu.navisdk.j.d()) {
                b(routePlanNode);
            } else {
                c(routePlanNode);
            }
        }
    }

    private void a(int i, RoutePlanNode routePlanNode) {
        if (routePlanNode == null) {
            return;
        }
        if (routePlanNode.mSensorAngle < 0.0f && "我的位置".equals(routePlanNode.getName())) {
            LogUtil.e("[[[checkList_RoutePlan]]]", "calcRouteV2 startNode 传感器角度异常");
            if (i != 43) {
                TTSPlayerControl.playXDTTSText("传感器角度异常", 1);
            }
        }
        if (routePlanNode.mDistrictID < 0) {
            LogUtil.e("[[[checkList_RoutePlan]]]", "calcRouteV2 startNode 城市 id 异常");
        }
        if (routePlanNode.getNodeType() == 2 || routePlanNode.getNodeType() == 4) {
            return;
        }
        GeoPoint geoPoint = routePlanNode.mGeoPoint;
        if (geoPoint == null || !geoPoint.isValid()) {
            LogUtil.e("[[[checkList_RoutePlan]]]", "calcRouteV2 startNode 引导坐标经纬度异常");
        }
    }

    @Override // com.baidu.navisdk.comapi.routeplan.b
    public void a(com.baidu.navisdk.comapi.routeplan.v2.b bVar) {
        com.baidu.navisdk.module.routepreference.a d = com.baidu.navisdk.module.routepreference.c.d(bVar.m());
        int nodePrefer = bVar.f6726a.getNodePrefer();
        if (nodePrefer == 0) {
            nodePrefer = 1;
        }
        List<RoutePlanNode> list = bVar.c;
        int size = (list == null || list.size() <= 0) ? 0 : bVar.c.size();
        int[] iArr = new int[size + 1];
        iArr[0] = d.a(nodePrefer);
        LogUtil.out("RoutePlan", "calcRouteV2 --> viasPrefer viaNodeSize = " + size);
        List<RoutePlanNode> list2 = bVar.c;
        if (list2 != null && list2.size() > 0) {
            Random random = new Random();
            for (int i = 0; i < size; i++) {
                RoutePlanNode routePlanNode = bVar.c.get(i);
                int nodePrefer2 = routePlanNode.getNodePrefer();
                if (LogUtil.LOGGABLE) {
                    LogUtil.out("RoutePlan", "calcRouteV2 --> viasPrefer viaNode preference = " + nodePrefer2);
                }
                if (nodePrefer2 != 0) {
                    iArr[i + 1] = d.a(nodePrefer2);
                } else {
                    iArr[i + 1] = iArr[i];
                }
                if (routePlanNode.getId() == 0) {
                    int abs = Math.abs(random.nextInt());
                    if (abs != Integer.MAX_VALUE) {
                        abs++;
                    }
                    routePlanNode.setId(abs);
                }
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RoutePlan", "calcRouteV2 --> viasPrefer = " + Arrays.toString(iArr));
        }
        bVar.o = iArr;
    }

    private void b(RoutePlanNode routePlanNode, boolean z, int i, int i2) {
        if (routePlanNode == null) {
            return;
        }
        d(routePlanNode);
        a(routePlanNode, i, i2, false);
        if (z) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RoutePlan", "calcRouteV2 --> updateStartNode, startNodeName = " + routePlanNode.mName);
            }
            a(routePlanNode);
        }
    }

    private void b(@NonNull RoutePlanNode routePlanNode) {
        com.baidu.navisdk.model.datastruct.g a2;
        if (TextUtils.equals(routePlanNode.getName(), "我的位置")) {
            routePlanNode.mSensorAngle = com.baidu.navisdk.framework.b.t();
            routePlanNode.setFrom(3);
            routePlanNode.setNodeType(3);
            routePlanNode.setName("我的位置");
            routePlanNode.setDistrictID(com.baidu.navisdk.framework.b.d(routePlanNode.getDistrictID()));
            routePlanNode.setUID("");
            if (LocationManager.getInstance().isLocationValid()) {
                LocationManager.LocData curLocation = LocationManager.getInstance().getCurLocation((LocationChangeListener.CoordType) null);
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RoutePlan", "calcRouteV2 --> curLocData = " + curLocation);
                }
                if (curLocation == null) {
                    return;
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RoutePlan", "calcRouteV2 --> curLocData.type = " + curLocation.type + ", curLocData.networkLocType = " + curLocation.networkLocType + ", curLocData.longitude = " + curLocation.longitude + ", curLocData.latitude = " + curLocation.latitude + ", curLocData.direction = " + curLocation.direction + ", curLocData.accuracy = " + curLocation.accuracy + ", curLocData.speed = " + curLocation.speed + ", curLocData.altitude = " + curLocation.altitude + ", curLocData.floorId = " + curLocation.floorId + ", curLocData.buildingId = " + curLocation.buildingId);
                }
                routePlanNode.setGeoPoint(o.a(new com.baidu.nplatform.comapi.basestruct.c(curLocation.longitude, curLocation.latitude)));
                routePlanNode.mGPSAngle = -2.0f;
                routePlanNode.mGPSSpeed = -2.0f;
                if (curLocation.accuracy >= 0.0f) {
                    routePlanNode.mGPSAccuracy = curLocation.accuracy;
                } else {
                    routePlanNode.mGPSAccuracy = -2.0f;
                }
                routePlanNode.setFloorId(curLocation.floorId);
                routePlanNode.setBuildingID(curLocation.buildingId);
                if (com.baidu.navisdk.util.common.g.b0 && e0.a(com.baidu.navisdk.framework.a.c().a()).a(SettingParams.Key.VDR_MOCK_FOR_DEBUG, false) && TextUtils.isEmpty(routePlanNode.getFloorId()) && TextUtils.isEmpty(routePlanNode.mBuildingID) && (a2 = com.baidu.navisdk.util.logic.c.k().a(3, 10000)) != null) {
                    routePlanNode.setFloorId(a2.p);
                    routePlanNode.setBuildingID(a2.q);
                }
                if (curLocation.type == 61) {
                    routePlanNode.mLocType = 1;
                    routePlanNode.mGPSAngle = curLocation.direction;
                    routePlanNode.mGPSAccuracy = curLocation.accuracy;
                    routePlanNode.mGPSSpeed = curLocation.speed / 3.6f;
                    routePlanNode.mBias = curLocation.bias;
                    routePlanNode.mAltitude = (float) curLocation.altitude;
                    return;
                }
                if (curLocation.type == 161) {
                    if ("wf".equalsIgnoreCase(curLocation.networkLocType)) {
                        routePlanNode.mLocType = 2;
                        return;
                    } else if ("cl".equalsIgnoreCase(curLocation.networkLocType)) {
                        routePlanNode.mLocType = 3;
                        return;
                    } else {
                        routePlanNode.mLocType = 0;
                        return;
                    }
                }
                routePlanNode.mLocType = 0;
            }
        }
    }
}
