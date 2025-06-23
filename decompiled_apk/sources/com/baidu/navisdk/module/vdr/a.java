package com.baidu.navisdk.module.vdr;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.location.LocationConst;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.o;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.tts.emstatistics.TtsStatsUploadBag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.text.ooOOo0oXI;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f7604a = false;
    public static boolean b = false;
    public static boolean c = true;
    private static List<b> d = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.navisdk.module.vdr.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public enum EnumC0300a {
        NE_RouteDataForVdr_Type_Invalid(0),
        NE_RouteDataForVdr_Type_Tunnel(1),
        NE_RouteDataForVdr_Type_NormalRoad(2),
        NE_RouteDataForVdr_Type_IndoorPark(3);


        /* renamed from: a, reason: collision with root package name */
        int f7605a;

        EnumC0300a(int i) {
            this.f7605a = i;
        }

        public int a() {
            return this.f7605a;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(String str, com.baidu.navisdk.framework.interfaces.opendatasturct.a aVar);
    }

    public static boolean a(int i, EnumC0300a enumC0300a) {
        if (i != 2 && !b()) {
            g gVar = g.VDR;
            if (gVar.d()) {
                gVar.e("BNVdrHelper", "updateState,VDR disabled");
            }
            return false;
        }
        ArrayList<String> a2 = a(enumC0300a.a());
        if (a2.isEmpty()) {
            g gVar2 = g.VDR;
            if (gVar2.d()) {
                gVar2.e("BNVdrHelper", "updateData,data empty");
            }
            return false;
        }
        g gVar3 = g.VDR;
        if (gVar3.d()) {
            gVar3.e("BNVdrHelper", "updateData,dataJson:" + Arrays.toString((String[]) a2.toArray(new String[a2.size()])));
        }
        return com.baidu.navisdk.framework.b.a(a2);
    }

    public static int b(int i) {
        switch (i) {
            case 4:
                return 3;
            case 5:
            case 8:
                return 0;
            case 6:
                return 1;
            case 7:
                return 2;
            case 9:
            default:
                return 5;
            case 10:
                return 4;
        }
    }

    public static boolean c(int i) {
        return i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 10;
    }

    public static boolean d(int i) {
        if (!b()) {
            g gVar = g.VDR;
            if (!gVar.d()) {
                return false;
            }
            gVar.e("BNVdrHelper", "updateState,VDR disabled,state:" + i);
            return false;
        }
        ArrayList arrayList = new ArrayList();
        String str = "{\"navi_status\":" + i + ooOOo0oXI.f33074oOoXoXO;
        arrayList.add(str);
        g gVar2 = g.VDR;
        if (gVar2.d()) {
            gVar2.e("BNVdrHelper", "updateState,json:" + str);
        }
        return com.baidu.navisdk.framework.b.a((ArrayList<String>) arrayList);
    }

    public static com.baidu.navisdk.framework.interfaces.opendatasturct.a e() {
        if (!b) {
            return null;
        }
        Bundle bundle = new Bundle();
        int matchResultForVDR = JNIGuidanceControl.getInstance().getMatchResultForVDR(bundle);
        g gVar = g.VDR;
        if (gVar.d()) {
            gVar.e("Location", "getMatchResultForVDR ret:" + matchResultForVDR);
        }
        if (matchResultForVDR != 1) {
            return null;
        }
        com.baidu.navisdk.framework.interfaces.opendatasturct.a a2 = com.baidu.navisdk.framework.interfaces.opendatasturct.a.a(bundle);
        com.baidu.navisdk.comapi.a.a(a2);
        return a2;
    }

    public static boolean b() {
        boolean isVDREnabled = BNSettingManager.isVDREnabled();
        g gVar = g.VDR;
        if (gVar.d()) {
            gVar.e("BNVdrHelper", "isVDREnabled,settingRet:" + isVDREnabled);
        }
        return isVDREnabled && !a() && c;
    }

    public static boolean c() {
        if (!b()) {
            g gVar = g.VDR;
            if (!gVar.d()) {
                return false;
            }
            gVar.e("BNVdrHelper", "setStartVDRFailed,VDR disabled");
            return false;
        }
        return JNIGuidanceControl.getInstance().setStartVDRFailed();
    }

    public static void b(b bVar) {
        if (d.contains(bVar)) {
            d.remove(bVar);
        }
    }

    public static void e(int i) {
        if (b) {
            com.baidu.navisdk.framework.interfaces.opendatasturct.b bVar = new com.baidu.navisdk.framework.interfaces.opendatasturct.b();
            bVar.f6816a = i;
            com.baidu.navisdk.comapi.a.a(bVar);
        }
    }

    public static boolean d() {
        if (!b()) {
            g gVar = g.VDR;
            if (!gVar.d()) {
                return false;
            }
            gVar.e("BNVdrHelper", "stopVDR,VDR disabled");
            return false;
        }
        return com.baidu.navisdk.framework.b.b0();
    }

    public static ArrayList<String> a(int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        a(arrayList, i);
        return arrayList;
    }

    private static void a(ArrayList<String> arrayList, int i) {
        String str = "{\"update_navi_links\":" + BNRouteGuider.getInstance().getTunnelDataForVdr(i) + ooOOo0oXI.f33074oOoXoXO;
        arrayList.add(str);
        g gVar = g.VDR;
        if (gVar.d()) {
            gVar.e("BNVdrHelper", "getTunnelDataForVdr,roadType:" + i + " result : " + str);
        }
    }

    public static boolean a() {
        boolean z = com.baidu.navisdk.module.pronavi.a.j == 2;
        g gVar = g.VDR;
        if (gVar.d()) {
            gVar.e("BNVdrHelper", "isSimulateNav:" + z);
        }
        return z;
    }

    public static void a(boolean z) {
        g gVar = g.VDR;
        if (gVar.d()) {
            gVar.e("BNVdrHelper", "setVDREnableTemp(), enable = " + z);
        }
        c = z;
    }

    @Deprecated
    public static void a(Location location) {
        if (location != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                GeoPoint e = o.e(location.getLongitude(), location.getLatitude());
                double latitudeE6 = e != null ? e.getLatitudeE6() / 100000.0f : location.getLatitude();
                double longitudeE6 = e != null ? e.getLongitudeE6() / 100000.0f : location.getLongitude();
                jSONObject.put(LocationConst.NaviVdrConst.KEY_VDR_LAT, latitudeE6);
                jSONObject.put(LocationConst.NaviVdrConst.KEY_VDR_LON, longitudeE6);
                jSONObject.put(LocationConst.NaviVdrConst.KEY_VDR_RADIUS, location.getAccuracy());
                jSONObject.put(LocationConst.NaviVdrConst.KEY_VDR_DIRECTION, location.getBearing());
                jSONObject.put(LocationConst.NaviVdrConst.KEY_VDR_SPEED, location.getSpeed());
                jSONObject.put(LocationConst.NaviVdrConst.KEY_VDR_TIME, location.getTime() / 1000);
                Bundle extras = location.getExtras();
                jSONObject.put(LocationConst.NaviVdrConst.KEY_VDR_SOURCE, b(extras != null ? extras.getInt("type", -1) : -1));
                String string = extras.getString("floor", null);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("floor", string);
                }
                if (extras.containsKey("subType")) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("net_indoor_park", extras.get("subType"));
                    jSONObject2.put("net_lat", latitudeE6);
                    jSONObject2.put("net_lon", longitudeE6);
                    jSONObject2.put("net_radius", location.getAccuracy());
                    jSONObject2.put("net_time", location.getTime() / 1000);
                    jSONObject2.put(TtsStatsUploadBag.KEY_NET_TYPE, "wf");
                    jSONObject.put("net_point", jSONObject2);
                }
                g gVar = g.VDR;
                if (gVar.d()) {
                    gVar.e("BNVdrHelper", "onLocationChangeForDebugVDR(), jsonObject = " + jSONObject);
                }
                a(jSONObject.toString(), location.getTime() / 1000, 0);
                return;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return;
            }
        }
        g gVar2 = g.VDR;
        if (gVar2.d()) {
            gVar2.e("BNVdrHelper", "onLocationChange,for debug,location is null");
        }
    }

    public static void a(String str) {
        g gVar = g.VDR;
        if (gVar.d()) {
            gVar.e("BNVdrHelper", "onLocationChange,MOCK_VDR_FUNCTION_STATE:" + f7604a);
        }
        if (f7604a) {
            return;
        }
        a(str, System.currentTimeMillis() / 1000, 1);
    }

    private static void a(String str, long j, int i) {
        if (!BNSettingManager.isVDREnabled()) {
            g gVar = g.VDR;
            if (gVar.d()) {
                gVar.e("BNVdrHelper", "onLocationChange,VDR disabled");
                return;
            }
            return;
        }
        g gVar2 = g.VDR;
        if (gVar2.d()) {
            gVar2.e("BNVdrHelper", "onLocationChange dataSource: " + i + ", vdrJsonData:" + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JNIGuidanceControl.getInstance().triggerVDRDataChangeWithJson(str);
        JNITrajectoryControl.sInstance.trajectoryVdrRecodingWithJson(str);
        a(str, e());
    }

    private static void a(String str, com.baidu.navisdk.framework.interfaces.opendatasturct.a aVar) {
        Iterator<b> it = d.iterator();
        while (it.hasNext()) {
            it.next().a(str, aVar);
        }
    }

    public static void a(b bVar) {
        if (d.contains(bVar)) {
            return;
        }
        d.add(bVar);
    }
}
