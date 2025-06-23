package com.baidu.navisdk.ugc.https;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.ugc.utils.h;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.o;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.net.URLEncoder;

/* loaded from: classes8.dex */
public class d {
    public static int a() {
        return h.c.a();
    }

    public static String b() {
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getVehicleInfo(bundle);
        try {
            Bundle b = o.b(bundle.getDouble("vehicle_stPosX"), bundle.getDouble("vehicle_stPosY"));
            if (b != null) {
                return b.getInt("MCx") + "," + b.getInt("MCy");
            }
        } catch (Exception e) {
            e.printStackTrace();
            g gVar = g.UGC;
            if (gVar.c()) {
                gVar.c("UgcModule_ReportHttp", "getCurrentLocationFromEngine exception: " + e.toString());
            }
        }
        return null;
    }

    private static String c() {
        Bundle b;
        com.baidu.navisdk.model.datastruct.g a2 = com.baidu.navisdk.ugc.utils.f.c.a();
        if (a2 != null && (b = o.b(a2.b, a2.f6926a)) != null) {
            return b.getInt("MCx") + "," + b.getInt("MCy");
        }
        return "";
    }

    private static int d() {
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(10, bundle);
        return bundle.getInt("linkidx", 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(boolean r5) {
        /*
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.UGC
            boolean r1 = r0.d()
            java.lang.String r2 = "UgcModule_ReportHttp"
            if (r1 == 0) goto L1e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "getCurrentLocationPoint isNeedGetFromEngine:"
            r1.append(r3)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.e(r2, r1)
        L1e:
            if (r5 == 0) goto L85
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            com.baidu.navisdk.comapi.routeguide.BNRouteGuider r1 = com.baidu.navisdk.comapi.routeguide.BNRouteGuider.getInstance()
            r1.getVehicleInfo(r0)
            java.lang.String r1 = "vehicle_stPosX"
            double r3 = r0.getDouble(r1)     // Catch: java.lang.Exception -> L61
            java.lang.String r1 = "vehicle_stPosY"
            double r0 = r0.getDouble(r1)     // Catch: java.lang.Exception -> L61
            android.os.Bundle r0 = com.baidu.navisdk.util.common.o.b(r3, r0)     // Catch: java.lang.Exception -> L61
            if (r0 == 0) goto L85
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L61
            r1.<init>()     // Catch: java.lang.Exception -> L61
            java.lang.String r3 = "MCx"
            int r3 = r0.getInt(r3)     // Catch: java.lang.Exception -> L61
            r1.append(r3)     // Catch: java.lang.Exception -> L61
            java.lang.String r3 = ","
            r1.append(r3)     // Catch: java.lang.Exception -> L61
            java.lang.String r3 = "MCy"
            int r0 = r0.getInt(r3)     // Catch: java.lang.Exception -> L61
            r1.append(r0)     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Exception -> L61
            goto L86
        L61:
            r0 = move-exception
            r0.printStackTrace()
            com.baidu.navisdk.util.common.g r1 = com.baidu.navisdk.util.common.g.UGC
            boolean r3 = r1.c()
            if (r3 == 0) goto L85
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "from engine get vehicle info exception: "
            r3.append(r4)
            java.lang.String r0 = r0.toString()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.c(r2, r0)
        L85:
            r0 = 0
        L86:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto Lac
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.UGC
            boolean r1 = r0.d()
            if (r1 == 0) goto La8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "from engine get current location failed, isNeedGetFromEngine: "
            r1.append(r3)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.e(r2, r5)
        La8:
            java.lang.String r0 = c()
        Lac:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ugc.https.d.a(boolean):java.lang.String");
    }

    public static String a(int i) {
        if (i == -1) {
            return "";
        }
        return i + "";
    }

    public static void a(com.baidu.navisdk.ugc.report.data.datastatus.a aVar) {
        if (aVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        BNRoutePlaner.getInstance().c(bundle);
        aVar.t = bundle.getString("session");
        aVar.u = bundle.getString("mrsl");
        aVar.g = JNITrajectoryControl.sInstance.getCurrentUUID();
        aVar.Q = d() + "";
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar != null) {
            if (fVar.o() != null) {
                GeoPoint geoPoint = fVar.o().getGeoPoint();
                if (geoPoint != null) {
                    Bundle c = o.c(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6());
                    aVar.w = c.getInt("MCx") + "," + c.getInt("MCy");
                }
                aVar.y = fVar.o().getUID() + "";
                String description = fVar.o().getDescription();
                if (description == null || description.trim().equals("")) {
                    description = fVar.o().getName() + "";
                }
                aVar.v = description;
            }
            if (fVar.g() != null) {
                GeoPoint geoPoint2 = fVar.g().getGeoPoint();
                if (geoPoint2 != null) {
                    Bundle c2 = o.c(geoPoint2.getLongitudeE6(), geoPoint2.getLatitudeE6());
                    aVar.x = c2.getInt("MCx") + "," + c2.getInt("MCy");
                }
                String uid = fVar.g().getUID();
                if (uid == null || uid.trim().equals("null")) {
                    uid = "";
                }
                aVar.B = uid;
                String description2 = fVar.g().getDescription();
                if (description2 == null || description2.trim().equals("")) {
                    description2 = fVar.g().getName() + "";
                }
                aVar.C = description2;
            }
        }
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
