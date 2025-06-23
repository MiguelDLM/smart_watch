package com.baidu.navisdk.module.asr.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.c;
import com.baidu.navisdk.model.modelfactory.f;
import com.baidu.navisdk.module.nearbysearch.model.b;
import com.baidu.navisdk.ui.routeguide.model.z;
import com.baidu.navisdk.util.common.o;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.garmin.fit.xOxOoo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {
    private static void a(JSONObject jSONObject) {
        if (jSONObject != null && com.baidu.navisdk.module.init.a.b()) {
            try {
                JSONObject jSONObject2 = new JSONObject(JNIGuidanceControl.getInstance().getXDRoadInfo());
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.get(next));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        try {
            f fVar = (f) c.a().a("RoutePlanModel");
            RoutePlanNode o = fVar.o();
            RoutePlanNode g = fVar.g();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", o.getName());
            jSONObject.put("uid", o.getUID());
            jSONArray.put(jSONObject);
            ArrayList<com.baidu.navisdk.module.nearbysearch.model.a> b = b.INSTANCE.b();
            if (b != null) {
                for (com.baidu.navisdk.module.nearbysearch.model.a aVar : b) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("name", aVar.getName());
                    jSONObject2.put("uid", aVar.getUID());
                    jSONArray.put(jSONObject2);
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("name", g.getName());
            jSONObject3.put("uid", g.getUID());
            jSONArray.put(jSONObject3);
        } catch (Exception unused) {
        }
        return jSONArray;
    }

    public static JSONObject c() {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        if (!com.baidu.navisdk.module.init.a.a()) {
            return jSONObject;
        }
        com.baidu.navisdk.ugc.report.data.datastatus.a d = d();
        try {
            jSONObject.put("mrsl", d.u);
            jSONObject.put("session_id", d.t);
            jSONObject.put("guid", d.g);
            jSONObject.put("linkidx", d.Q);
            jSONObject.put("from_point", d.w);
            jSONObject.put("from_uid", d.y);
            jSONObject.put("from_name", d.v);
            jSONObject.put("to_point", d.x);
            jSONObject.put("to_name", d.C);
            jSONObject.put("to_uid", d.B);
            jSONObject.put("car_type", com.baidu.navisdk.module.vehiclemanager.b.i().b());
            if (BNSettingManager.isNoviceMode() && com.baidu.navisdk.module.vehiclemanager.b.i().f()) {
                z = true;
            } else {
                z = false;
            }
            jSONObject.put("is_new_hand", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a(jSONObject);
        return jSONObject;
    }

    private static com.baidu.navisdk.ugc.report.data.datastatus.a d() {
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = new com.baidu.navisdk.ugc.report.data.datastatus.a();
        Bundle bundle = new Bundle();
        BNRoutePlaner.getInstance().c(bundle);
        aVar.t = bundle.getString("session");
        aVar.u = bundle.getString("mrsl");
        aVar.g = JNITrajectoryControl.sInstance.getCurrentUUID();
        aVar.Q = a() + "";
        f fVar = (f) c.a().a("RoutePlanModel");
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
        return aVar;
    }

    public static JSONArray e() {
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(18, bundle);
        z.c().a(bundle);
        z.a[] a2 = z.c().a();
        JSONArray jSONArray = new JSONArray();
        try {
            for (z.a aVar : a2) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(xOxOoo.f15470o00, aVar.d);
                jSONObject.put("duration", aVar.e);
                jSONObject.put("traffic_light", aVar.f);
                jSONObject.put("mrsl", aVar.f8987a);
                JSONArray jSONArray2 = new JSONArray();
                if (!TextUtils.isEmpty(aVar.b)) {
                    for (String str : aVar.b.split("\\$")) {
                        jSONArray2.put(str);
                    }
                }
                if (!TextUtils.isEmpty(aVar.c)) {
                    jSONArray2.put(aVar.c);
                }
                if (jSONArray2.length() == 0) {
                    jSONArray2.put("");
                }
                jSONObject.put("route_label_name", jSONArray2);
                jSONArray.put(jSONObject);
            }
        } catch (Exception unused) {
        }
        return jSONArray;
    }

    private static int a() {
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(10, bundle);
        return bundle.getInt("linkidx", 0);
    }

    public static void a(com.baidu.navisdk.asr.model.c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.b()) || !cVar.b().startsWith("ugc")) {
            return;
        }
        cVar.b("ugc");
        cVar.b(c());
    }
}
