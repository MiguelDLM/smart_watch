package com.baidu.navisdk.ugc;

import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.ugc.utils.h;
import com.baidu.navisdk.ugc.utils.j;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.http.center.i;
import com.baidu.navisdk.util.http.center.l;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.nplatform.comapi.MapItem;
import com.huawei.openalliance.ad.constant.x;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import o0oIxXOx.oO;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class c {
    private static String b = "";

    /* renamed from: a, reason: collision with root package name */
    private b f8017a;

    /* loaded from: classes8.dex */
    public interface b {
        void a(boolean z);
    }

    public c(b bVar) {
        this.f8017a = bVar;
    }

    private int b() {
        return h.c.a();
    }

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.http.center.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8018a;

        public a(int i) {
            this.f8018a = i;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_CloudConfig", "getUgcExtremeEventCloudConfig onFailure: " + i + ", responseString:" + str);
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            g gVar = g.UGC;
            if (gVar.e()) {
                gVar.g("UgcModule_CloudConfig", "getUgcExtremeEventCloudConfig onSuccess: " + i + ", " + str);
            }
            boolean z = false;
            try {
                z = c.this.a(new JSONObject(str), this.f8018a);
                if (gVar.d()) {
                    gVar.e("UgcModule_CloudConfig", "onSuccess: " + z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!z || c.this.f8017a == null) {
                return;
            }
            c.this.f8017a.a(z);
        }
    }

    public void a(int i) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_CloudConfig", "getUgcExtremeEventCloudConfig: " + i);
        }
        List<l> a2 = a(i, "ugc_extreme_weather_item");
        if (a2 == null) {
            if (gVar.d()) {
                gVar.e("UgcModule_CloudConfig", "getUgcExtremeEventCloudConfig getServiceReqParam exception");
                return;
            }
            return;
        }
        com.baidu.navisdk.util.http.center.b.a().b(com.baidu.navisdk.util.http.b.d().b("GetCloudConf"), com.baidu.navisdk.util.http.center.c.a(a2), new a(i), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(JSONObject jSONObject, int i) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_CloudConfig", "parseUgcExtremeEventCloudConfig: " + jSONObject);
        }
        try {
            if (jSONObject.getInt("errno") == 0 && jSONObject.getString("errmsg").equals("success")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = new ArrayList<>(com.baidu.navisdk.ugc.report.data.datarepository.d.i().d());
                ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList2 = new ArrayList<>(com.baidu.navisdk.ugc.report.data.datarepository.d.i().f());
                boolean a2 = a(arrayList, arrayList2);
                if (jSONObject2.has("ugc_extreme_weather_item")) {
                    JSONObject optJSONObject = jSONObject2.optJSONObject("ugc_extreme_weather_item");
                    com.baidu.navisdk.ugc.report.data.datarepository.b bVar = optJSONObject != null ? new com.baidu.navisdk.ugc.report.data.datarepository.b(optJSONObject.optString("title"), optJSONObject.optInt("type"), optJSONObject.optString(x.cD)) : null;
                    if (bVar != null && com.baidu.navisdk.ugc.report.data.datarepository.f.e().d(bVar.b)) {
                        a2 = true;
                        com.baidu.navisdk.ugc.report.data.datarepository.f.e().a(bVar, 1);
                        arrayList.add(bVar);
                        com.baidu.navisdk.ugc.report.data.datarepository.b bVar2 = new com.baidu.navisdk.ugc.report.data.datarepository.b(bVar.f8246a, bVar.b, bVar.c);
                        com.baidu.navisdk.ugc.report.data.datarepository.f.e().a(bVar2, 2);
                        arrayList2.add(bVar2);
                        com.baidu.navisdk.ugc.report.data.datarepository.d.i().d().clear();
                        com.baidu.navisdk.ugc.report.data.datarepository.d.i().d().addAll(arrayList);
                        com.baidu.navisdk.ugc.report.data.datarepository.d.i().f().clear();
                        com.baidu.navisdk.ugc.report.data.datarepository.d.i().f().addAll(arrayList2);
                    }
                }
                b = jSONObject2.optString("etag");
                return a2;
            }
            if (gVar.d()) {
                gVar.e("UgcModule_CloudConfig", "parseUgcExtremeEventCloudConfig get ugc cloud config failed or content not modified");
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            g gVar2 = g.UGC;
            if (gVar2.d()) {
                gVar2.e("UgcModule_CloudConfig", "parseUgcExtremeEventCloudConfig exception: " + e.toString());
            }
            return false;
        }
    }

    private boolean a(ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList, ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList2) {
        boolean z;
        for (int i = 0; i < arrayList.size(); i++) {
            int i2 = arrayList.get(i).b;
            if (i2 == 55 || i2 == 51 || i2 == 54 || i2 == 53) {
                arrayList.remove(i);
                z = true;
                break;
            }
        }
        z = false;
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            int i4 = arrayList2.get(i3).b;
            if (i4 == 55 || i4 == 51 || i4 == 54 || i4 == 53) {
                arrayList2.remove(i3);
                return true;
            }
        }
        return z;
    }

    private List<l> a(int i, String str) {
        try {
            ArrayList arrayList = new ArrayList();
            j jVar = new j();
            String str2 = a0.e() + "";
            arrayList.add(new i("cuid", str2));
            jVar.a("cuid=" + URLEncoder.encode(str2, "utf-8"));
            arrayList.add(new i(MapItem.KEY_ITEM_SID, "1"));
            jVar.a("&sid=" + URLEncoder.encode("1", "utf-8"));
            arrayList.add(new i(oO.f31192XO, "0"));
            jVar.a("&os=" + URLEncoder.encode("0", "utf-8"));
            String str3 = a0.k() + "";
            arrayList.add(new i("sv", str3));
            jVar.a("&sv=" + URLEncoder.encode(str3, "utf-8"));
            String str4 = a0.b + "";
            arrayList.add(new i("osv", str4));
            jVar.a("&osv=" + URLEncoder.encode(str4, "utf-8"));
            String str5 = b() + "";
            arrayList.add(new i("cityCode", str5));
            jVar.a("&cityCode=" + URLEncoder.encode(str5, "utf-8"));
            arrayList.add(new i("mb", VDeviceAPI.getPhoneType()));
            jVar.a("&mb=" + URLEncoder.encode(VDeviceAPI.getPhoneType()));
            String str6 = com.baidu.navisdk.ugc.utils.c.g(i) + "";
            arrayList.add(new i("business_trigger", str6));
            jVar.a("&business_trigger=" + str6);
            arrayList.add(new i("key", str));
            jVar.a("&key=" + str);
            if (!TextUtils.isEmpty(b)) {
                arrayList.add(new i("etag", b));
                jVar.a("&etag=" + b);
            }
            com.baidu.navisdk.util.http.a.a(arrayList);
            String a2 = com.baidu.navisdk.module.cloudconfig.d.a(arrayList);
            String urlParamsSign = JNITrajectoryControl.sInstance.getUrlParamsSign(a2);
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_CloudConfig", "unsign str: " + a2);
                gVar.e("UgcModule_CloudConfig", "hassign sign:" + urlParamsSign);
            }
            arrayList.add(new i(HttpConstants.SIGN, urlParamsSign));
            jVar.a("&sign=" + URLEncoder.encode(urlParamsSign, "utf-8"));
            if (gVar.d()) {
                gVar.e("UgcModule_CloudConfig", "params:" + jVar.toString());
            }
            return arrayList;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void a() {
        this.f8017a = null;
    }
}
