package com.baidu.navisdk.b4nav.func.resolver;

import androidx.annotation.NonNull;
import com.baidu.entity.pb.Cars;
import com.baidu.navisdk.model.datastruct.i;
import com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.c;
import com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.d;
import com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.f;
import com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.g;
import com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.b;
import com.baidu.navisdk.util.common.g;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class a {
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0058, code lost:
    
        r5.a((com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.g) new com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.g.a());
        r6.a((com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.f) new com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.f.a());
        r7.a((com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.d) new com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.d.a());
        r8.a((com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.c) new com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.c.a());
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.e a(com.baidu.entity.pb.Cars r18) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.b4nav.func.resolver.a.a(com.baidu.entity.pb.Cars):com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.e");
    }

    public static int b(Cars cars) {
        if (cars == null || !cars.hasContent()) {
            return 0;
        }
        int routesCount = cars.getContent().getRoutesCount();
        g gVar = g.B4NAV;
        if (!gVar.d()) {
            return routesCount;
        }
        gVar.e("CarsHelper", "onLongDistanceRouteUpdate --> routeCount = " + routesCount);
        return routesCount;
    }

    public static int[] c(Cars cars) {
        int b = b(cars);
        int[] iArr = new int[b];
        for (int i = 0; i < b; i++) {
            if (cars != null && cars.hasContent() && cars.getContent().getRoutesCount() > 0 && cars.getContent().getRoutesCount() > i && cars.getContent().getRoutes(i) != null) {
                Iterator<Cars.Content.Routes.Legs> it = cars.getContent().getRoutes(i).getLegsList().iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    i2 += it.next().getDistance();
                    g gVar = g.B4NAV;
                    if (gVar.d()) {
                        gVar.e("CarsHelper", "parseRouteDistanceArray --> routeCount = " + b);
                    }
                }
                g gVar2 = g.B4NAV;
                if (gVar2.d()) {
                    gVar2.e("CarsHelper", "parseRouteDistanceArray --> i = " + i + " distance = " + i2);
                }
                iArr[i] = i2;
            }
        }
        return iArr;
    }

    private static g.a d(List<Cars.Content.LongDistanceInfo.ViaService> list) {
        g.a aVar = new g.a();
        if (list != null && list.size() > 0) {
            for (Cars.Content.LongDistanceInfo.ViaService viaService : list) {
                if (viaService != null) {
                    aVar.a((g.a) a(viaService));
                }
            }
        }
        return aVar;
    }

    private static d.a b(List<Cars.Content.LongDistanceInfo.ViaCityInfo> list) {
        d.a aVar = new d.a();
        if (list != null && list.size() > 0) {
            if (list.size() <= 2) {
                for (Cars.Content.LongDistanceInfo.ViaCityInfo viaCityInfo : list) {
                    if (viaCityInfo != null) {
                        aVar.a((d.a) a(viaCityInfo));
                    }
                }
            } else {
                HashSet hashSet = new HashSet();
                Cars.Content.LongDistanceInfo.ViaCityInfo viaCityInfo2 = list.get(0);
                Cars.Content.LongDistanceInfo.ViaCityInfo viaCityInfo3 = list.get(list.size() - 1);
                if (viaCityInfo2 != null) {
                    aVar.a((d.a) a(viaCityInfo2));
                    hashSet.add(viaCityInfo2.hasCityName() ? viaCityInfo2.getCityName() : "");
                }
                if (viaCityInfo3 != null) {
                    hashSet.add(viaCityInfo3.hasCityName() ? viaCityInfo3.getCityName() : "");
                }
                for (int i = 1; i < list.size() - 1; i++) {
                    Cars.Content.LongDistanceInfo.ViaCityInfo viaCityInfo4 = list.get(i);
                    if (viaCityInfo4 != null) {
                        String cityName = viaCityInfo4.hasCityName() ? viaCityInfo4.getCityName() : "";
                        if (!hashSet.contains(cityName)) {
                            hashSet.add(cityName);
                            aVar.a((d.a) a(viaCityInfo4));
                        }
                    }
                }
                if (viaCityInfo3 != null) {
                    aVar.a((d.a) a(viaCityInfo3));
                }
            }
        }
        return aVar;
    }

    private static f.a c(List<Cars.Content.LongDistanceInfo.ViaMainRoad> list) {
        f.a aVar = new f.a();
        if (list != null && list.size() > 0) {
            int i = 0;
            for (Cars.Content.LongDistanceInfo.ViaMainRoad viaMainRoad : list) {
                if (viaMainRoad != null) {
                    aVar.a((f.a) a(viaMainRoad, i));
                    i++;
                }
            }
            Collections.sort(aVar.a());
        }
        return aVar;
    }

    private static c.a a(List<Cars.Content.LongDistanceInfo.ViaCheckSer> list) {
        c.a aVar = new c.a();
        if (list != null && list.size() > 0) {
            for (Cars.Content.LongDistanceInfo.ViaCheckSer viaCheckSer : list) {
                if (viaCheckSer != null) {
                    aVar.a((c.a) a(viaCheckSer));
                }
            }
        }
        return aVar;
    }

    @NonNull
    private static com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a a(@NonNull Cars.Content.LongDistanceInfo.ViaCityInfo viaCityInfo) {
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a aVar = new com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a();
        aVar.f7513a = viaCityInfo.hasCityName() ? viaCityInfo.getCityName() : "";
        aVar.b = viaCityInfo.hasCityId() ? viaCityInfo.getCityId() : -1;
        aVar.c = viaCityInfo.hasCityDistanceFromStart() ? viaCityInfo.getCityDistanceFromStart() : 0;
        aVar.f = viaCityInfo.hasPriority() ? viaCityInfo.getPriority() : 99;
        Cars.Content.LongDistanceInfo.Point point = viaCityInfo.hasPoint() ? viaCityInfo.getPoint() : null;
        if (point != null) {
            aVar.e = new com.baidu.nplatform.comapi.basestruct.c(point.getX(), point.getY());
        }
        aVar.d = viaCityInfo.hasDuration() ? viaCityInfo.getDuration() : 0;
        return aVar;
    }

    @NonNull
    private static com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a a(@NonNull Cars.Content.LongDistanceInfo.ViaMainRoad viaMainRoad, int i) {
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a aVar = new com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a();
        aVar.e = (viaMainRoad.hasMainRoadType() ? viaMainRoad.getMainRoadType() : 0) != 1;
        aVar.d = viaMainRoad.hasDistance() ? viaMainRoad.getDistance() : 0;
        aVar.f7519a = viaMainRoad.hasMainRoadName() ? viaMainRoad.getMainRoadName() : "";
        aVar.b = viaMainRoad.hasLaneCount() ? viaMainRoad.getLaneCount() : "";
        aVar.c = viaMainRoad.hasSpeedLimit() ? viaMainRoad.getSpeedLimit() : "";
        aVar.i = i;
        Cars.Content.LongDistanceInfo.Point labelPoint = viaMainRoad.hasLabelPoint() ? viaMainRoad.getLabelPoint() : null;
        if (labelPoint != null) {
            aVar.f = new com.baidu.nplatform.comapi.basestruct.c(labelPoint.getX(), labelPoint.getY());
        }
        return aVar;
    }

    @NonNull
    private static com.baidu.navisdk.module.routeresultbase.logic.longdistance.service.a a(@NonNull Cars.Content.LongDistanceInfo.ViaService viaService) {
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.service.a aVar = new com.baidu.navisdk.module.routeresultbase.logic.longdistance.service.a();
        aVar.f7521a = viaService.hasServiceName() ? viaService.getServiceName() : "";
        aVar.b = viaService.hasServiceDistanceFromStart() ? viaService.getServiceDistanceFromStart() : 0;
        aVar.c = viaService.hasDuration() ? viaService.getDuration() : 0;
        aVar.e = (viaService.hasCanBeViaNode() ? viaService.getCanBeViaNode() : 0) != 0;
        if ((viaService.hasLabelPoint() ? viaService.getLabelPoint() : null) != null) {
            aVar.d = new com.baidu.nplatform.comapi.basestruct.c((int) r1.getX(), (int) r1.getY());
        }
        if (viaService.hasServiceSupport()) {
            aVar.g = viaService.getServiceSupport();
        }
        Cars.Content.LongDistanceInfo.ServiceGasInfo serviceGasInfo = viaService.hasServiceGasInfo() ? viaService.getServiceGasInfo() : null;
        if (serviceGasInfo != null) {
            aVar.f = new com.baidu.navisdk.model.service.a();
            if (serviceGasInfo.hasStationStatus()) {
                aVar.f.f(serviceGasInfo.getStationStatus());
            }
            if (serviceGasInfo.hasBrand()) {
                aVar.f.c(serviceGasInfo.getBrand());
            }
            if (serviceGasInfo.hasLabel()) {
                aVar.f.e(serviceGasInfo.getLabel());
            }
            if (serviceGasInfo.hasGasType()) {
                aVar.f.d(serviceGasInfo.getGasType());
            }
        }
        return aVar;
    }

    @NonNull
    private static com.baidu.navisdk.module.routeresultbase.logic.longdistance.checkpoint.a a(@NonNull Cars.Content.LongDistanceInfo.ViaCheckSer viaCheckSer) {
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.checkpoint.a aVar = new com.baidu.navisdk.module.routeresultbase.logic.longdistance.checkpoint.a();
        aVar.f7512a = viaCheckSer.hasCheckserName() ? viaCheckSer.getCheckserName() : "";
        aVar.b = viaCheckSer.hasCheckserNameDistanceFromStart() ? viaCheckSer.getCheckserNameDistanceFromStart() : 0;
        aVar.c = viaCheckSer.hasDuration() ? viaCheckSer.getDuration() : 0;
        aVar.e = (viaCheckSer.hasCanBeViaNode() ? viaCheckSer.getCanBeViaNode() : 0) != 0;
        Cars.Content.LongDistanceInfo.Point labelPoint = viaCheckSer.hasLabelPoint() ? viaCheckSer.getLabelPoint() : null;
        if (labelPoint != null) {
            aVar.d = new com.baidu.nplatform.comapi.basestruct.c(labelPoint.getX(), labelPoint.getY());
        }
        return aVar;
    }

    public static i a() {
        return b.b();
    }
}
