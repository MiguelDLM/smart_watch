package com.baidu.navisdk.adapter.impl.locallimit;

import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.adapter.impl.locallimit.bean.d;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.http.center.i;
import com.baidu.navisdk.util.http.center.l;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import o0oIxXOx.XIxXXX0x0;
import o0oIxXOx.oO;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public abstract class d {
    private static String f = "NavLocalLimitModel";

    /* renamed from: a, reason: collision with root package name */
    public com.baidu.navisdk.adapter.impl.locallimit.bean.a f6522a = new com.baidu.navisdk.adapter.impl.locallimit.bean.a();
    public f[] b = new f[3];
    public List<com.baidu.navisdk.adapter.impl.locallimit.bean.b> c = new ArrayList();
    public Map<String, com.baidu.navisdk.adapter.impl.locallimit.bean.c> d = new ConcurrentHashMap();
    private String e;

    public d(String str) {
        f = str;
    }

    public abstract void a(int i, List<l> list);

    public com.baidu.navisdk.adapter.impl.locallimit.bean.c b(String str) {
        com.baidu.navisdk.adapter.impl.locallimit.bean.a aVar = this.f6522a;
        if (aVar.c.containsKey(str)) {
            return aVar.c.get(str);
        }
        for (com.baidu.navisdk.adapter.impl.locallimit.bean.e eVar : aVar.b) {
            if (str.equals(Integer.toString(eVar.f6517a))) {
                return a(eVar.b);
            }
        }
        g gVar = g.OPEN_SDK;
        if (!gVar.d()) {
            return null;
        }
        gVar.e(f, "requestRouteCityLimitation mRouteCityList not find cityId:" + str);
        return null;
    }

    public List<com.baidu.navisdk.adapter.impl.locallimit.bean.e> c(String str) {
        return e(str);
    }

    public String d() {
        return "https://newclient.map.baidu.com/client/phpui2/?";
    }

    public String e() {
        return "552dc39c7d7eca972455060daa3f4634";
    }

    public String f() {
        String g = g();
        if (g == null) {
            return "";
        }
        return g;
    }

    public String g() {
        return BNSettingManager.getPlateFromLocal();
    }

    public String h() {
        return this.e;
    }

    public List<com.baidu.navisdk.adapter.impl.locallimit.bean.b> i() {
        ArrayList arrayList = new ArrayList();
        com.baidu.navisdk.util.http.center.b.a().a(b(0, new ArrayList()), null, new a(this, arrayList), new com.baidu.navisdk.util.http.center.e(false));
        return arrayList;
    }

    private List<com.baidu.navisdk.adapter.impl.locallimit.bean.e> e(String str) {
        g gVar = g.OPEN_SDK;
        if (gVar.d()) {
            gVar.e(f, "requestCustomCityList ids = " + str);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i("info_ids", str));
        String b2 = b(1, arrayList);
        ArrayList arrayList2 = new ArrayList();
        com.baidu.navisdk.util.http.center.b.a().a(b2, null, new c(this, arrayList2), new com.baidu.navisdk.util.http.center.e(false));
        return arrayList2;
    }

    public com.baidu.navisdk.adapter.impl.locallimit.bean.c a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i("cityId", str));
        String b2 = b(2, arrayList);
        com.baidu.navisdk.adapter.impl.locallimit.bean.c cVar = new com.baidu.navisdk.adapter.impl.locallimit.bean.c();
        com.baidu.navisdk.util.http.center.b.a().a(b2, null, new b(cVar), new com.baidu.navisdk.util.http.center.e(false));
        return cVar;
    }

    public void c() {
        for (int i = 0; i < 3; i++) {
            this.b[i] = null;
        }
        b();
    }

    public void d(String str) {
        this.e = str;
    }

    private String c(List<String> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(list.get(i));
            if (i < size - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.navisdk.adapter.impl.locallimit.bean.d a(JSONObject jSONObject) {
        com.baidu.navisdk.adapter.impl.locallimit.bean.d dVar = new com.baidu.navisdk.adapter.impl.locallimit.bean.d();
        jSONObject.optString("type");
        jSONObject.optInt("category");
        jSONObject.optInt("isLocal");
        jSONObject.optInt("isLimit", -1);
        dVar.f6519a = jSONObject.optLong("max_x");
        dVar.b = jSONObject.optLong("max_y");
        dVar.c = jSONObject.optLong("min_x");
        dVar.d = jSONObject.optLong("min_y");
        jSONObject.optInt("carType");
        JSONObject optJSONObject = jSONObject.optJSONObject("policies");
        d.a aVar = new d.a();
        optJSONObject.optString("id");
        optJSONObject.optString(XIxXXX0x0.f31178xoIox);
        optJSONObject.optString("rule");
        optJSONObject.optString("area");
        aVar.f6520a = optJSONObject.optString("geom");
        dVar.e = aVar;
        return dVar;
    }

    public void b() {
        com.baidu.navisdk.adapter.impl.locallimit.bean.a aVar = this.f6522a;
        aVar.f6516a = null;
        aVar.b.clear();
        this.f6522a.c.clear();
    }

    /* renamed from: com.baidu.navisdk.adapter.impl.locallimit.d$d, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0164d extends com.baidu.navisdk.util.http.center.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.adapter.impl.locallimit.bean.c f6526a;

        public C0164d(com.baidu.navisdk.adapter.impl.locallimit.bean.c cVar) {
            this.f6526a = cVar;
        }

        @Override // com.baidu.navisdk.util.http.center.a
        public void a(int i, byte[] bArr) {
            try {
                LogUtil.e(d.f, "query success, bytes length = " + bArr.length);
                JSONObject optJSONObject = new JSONObject(new String(bArr)).optJSONObject("car_platform");
                this.f6526a.b = optJSONObject.optString("title");
                this.f6526a.f6518a = optJSONObject.optInt("cityId");
                this.f6526a.c = optJSONObject.optString("cityName");
                JSONArray optJSONArray = optJSONObject.optJSONArray("limitData");
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    this.f6526a.d.add(d.this.a(optJSONArray.optJSONObject(i2)));
                }
            } catch (Exception unused) {
                LogUtil.e(d.f, "aoi info parsing error, not a RoutePoiRec");
            }
        }

        @Override // com.baidu.navisdk.util.http.center.a
        public void a(int i, byte[] bArr, Throwable th) {
            LogUtil.e(d.f, "request onFailure " + th.getMessage());
        }
    }

    private String b(int i, List<l> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i("cuid", a0.e()));
        arrayList.add(new i("mb", a0.f9218a));
        arrayList.add(new i(oO.f31192XO, "2"));
        arrayList.add(new i("osv", a0.b));
        arrayList.add(new i(t.r, a0.g()));
        arrayList.add(new i("qt", "carplatformnavi"));
        arrayList.add(new i("sv", a0.k()));
        arrayList.add(new i("rp_format", "json"));
        arrayList.add(new i("c", "limit"));
        arrayList.add(new i("maptoken", e()));
        if (g.b0) {
            arrayList.add(new i("TOHOST", "QA1"));
        }
        String f2 = f();
        if (!TextUtils.isEmpty(f2)) {
            arrayList.add(new i("plate", f2));
        }
        if (i == 0) {
            arrayList.add(new i("m", "getRstCity"));
            arrayList.add(new i("status", "1"));
            arrayList.add(new i("geom", "1"));
        } else if (i == 1) {
            arrayList.add(new i("m", "getcitybyinfoid"));
        } else if (i == 2 || i == 3) {
            arrayList.add(new i("m", "rstgeom"));
        }
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
        }
        a(i, arrayList);
        com.baidu.navisdk.util.http.a.a(arrayList);
        String b2 = b(arrayList);
        if (TextUtils.isEmpty(b2)) {
            b2 = "";
        }
        arrayList.add(new i(HttpConstants.SIGN, b2));
        String a2 = com.baidu.navisdk.util.http.center.c.a(d(), arrayList);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(f, "NavLocalLimitModel->getUrl=" + a2);
        }
        return a2;
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.util.http.center.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.adapter.impl.locallimit.bean.c f6524a;

        public b(com.baidu.navisdk.adapter.impl.locallimit.bean.c cVar) {
            this.f6524a = cVar;
        }

        @Override // com.baidu.navisdk.util.http.center.a
        public void a(int i, byte[] bArr) {
            try {
                g gVar = g.OPEN_SDK;
                if (gVar.d()) {
                    gVar.e(d.f, "query success, bytes length = " + bArr.length);
                }
                JSONObject optJSONObject = new JSONObject(new String(bArr)).optJSONObject("car_platform");
                this.f6524a.b = optJSONObject.optString("title");
                this.f6524a.f6518a = optJSONObject.optInt("cityId");
                this.f6524a.c = optJSONObject.optString("cityName");
                JSONArray optJSONArray = optJSONObject.optJSONArray("limitData");
                int length = optJSONArray == null ? 0 : optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    this.f6524a.d.add(d.this.a(optJSONArray.optJSONObject(i2)));
                }
            } catch (Exception unused) {
                g gVar2 = g.OPEN_SDK;
                if (gVar2.d()) {
                    gVar2.e(d.f, "aoi info parsing error, not a RoutePoiRec");
                }
            }
        }

        @Override // com.baidu.navisdk.util.http.center.a
        public void a(int i, byte[] bArr, Throwable th) {
            g gVar = g.OPEN_SDK;
            if (gVar.d()) {
                gVar.e(d.f, "request mz poi render date onFailure " + th.getMessage());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.http.center.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f6523a;

        public a(d dVar, List list) {
            this.f6523a = list;
        }

        @Override // com.baidu.navisdk.util.http.center.a
        public void a(int i, byte[] bArr) {
            try {
                g gVar = g.OPEN_SDK;
                if (gVar.d()) {
                    gVar.e(d.f, "query success, bytes length = " + bArr.length);
                }
                JSONArray optJSONArray = new JSONObject(new String(bArr)).optJSONObject("car_platform").optJSONArray("cityinfo");
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    com.baidu.navisdk.adapter.impl.locallimit.bean.b bVar = new com.baidu.navisdk.adapter.impl.locallimit.bean.b();
                    bVar.f6517a = optJSONObject.optInt("city_id");
                    optJSONObject.optString("city_name");
                    optJSONObject.optString("cityname_pinyin");
                    this.f6523a.add(bVar);
                }
            } catch (Exception unused) {
                g gVar2 = g.OPEN_SDK;
                if (gVar2.d()) {
                    gVar2.e(d.f, "aoi info parsing error, not a RoutePoiRec");
                }
            }
        }

        @Override // com.baidu.navisdk.util.http.center.a
        public void a(int i, byte[] bArr, Throwable th) {
            g gVar = g.OPEN_SDK;
            if (gVar.d()) {
                gVar.e(d.f, "request mz poi render date onFailure " + th.getMessage());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.util.http.center.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f6525a;

        public c(d dVar, List list) {
            this.f6525a = list;
        }

        @Override // com.baidu.navisdk.util.http.center.a
        public void a(int i, byte[] bArr) {
            try {
                g gVar = g.OPEN_SDK;
                if (gVar.d()) {
                    gVar.e(d.f, "query success, bytes length = " + bArr.length);
                }
                String str = new String(bArr);
                JSONArray optJSONArray = new JSONObject(str).optJSONObject("car_platform").optJSONArray("citylist");
                int length = optJSONArray.length();
                if (gVar.d()) {
                    gVar.e(d.f, "query success, city len ：" + length + "jsonStr ：" + str);
                }
                for (int i2 = 0; i2 < length; i2++) {
                    com.baidu.navisdk.adapter.impl.locallimit.bean.e eVar = new com.baidu.navisdk.adapter.impl.locallimit.bean.e();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    eVar.f6517a = optJSONObject.optInt("cityId");
                    optJSONObject.optString("cityname");
                    optJSONObject.optString("cityname_pinyin");
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("info_id");
                    int length2 = optJSONArray2.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        eVar.a(optJSONArray2.optString(i3));
                    }
                    this.f6525a.add(eVar);
                }
            } catch (Exception unused) {
                g gVar2 = g.OPEN_SDK;
                if (gVar2.d()) {
                    gVar2.e(d.f, "aoi info parsing error, not a RoutePoiRec");
                }
            }
        }

        @Override // com.baidu.navisdk.util.http.center.a
        public void a(int i, byte[] bArr, Throwable th) {
            g gVar = g.OPEN_SDK;
            if (gVar.d()) {
                gVar.e(d.f, "request mz poi render date onFailure " + th.getMessage());
            }
        }
    }

    public List<com.baidu.navisdk.adapter.impl.locallimit.bean.e> a(int i) {
        return this.b[i].d;
    }

    public List<com.baidu.navisdk.adapter.impl.locallimit.bean.e> a(List<String> list, List<String> list2, int i) {
        String str;
        if (a(i) != null && a(i).size() > 0) {
            return a(i);
        }
        String c2 = c(list);
        String c3 = c(list2);
        if (!TextUtils.isEmpty(c2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(c2);
            if (TextUtils.isEmpty(c3)) {
                str = "";
            } else {
                str = "," + c3;
            }
            sb.append(str);
            c3 = sb.toString();
        }
        g gVar = g.OPEN_SDK;
        if (gVar.d()) {
            gVar.e(f, "requestRouteCityList ids = " + c3);
        }
        return e(c3);
    }

    public com.baidu.navisdk.adapter.impl.locallimit.bean.c a(String str, int i) {
        f fVar = this.b[i];
        if (fVar.e.containsKey(str)) {
            return fVar.e.get(str);
        }
        for (com.baidu.navisdk.adapter.impl.locallimit.bean.e eVar : fVar.d) {
            if (str.equals(Integer.toString(eVar.f6517a))) {
                return a(eVar.b);
            }
        }
        g gVar = g.OPEN_SDK;
        if (!gVar.d()) {
            return null;
        }
        gVar.e(f, "requestRouteCityLimitation mRouteCityList not find cityId:" + str);
        return null;
    }

    private String b(List<l> list) {
        return JNITrajectoryControl.sInstance.getUrlParamsSignRp(com.baidu.navisdk.util.http.center.c.b(list));
    }

    public com.baidu.navisdk.adapter.impl.locallimit.bean.c a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i("info_id", c(list)));
        String b2 = b(3, arrayList);
        com.baidu.navisdk.util.http.center.e eVar = new com.baidu.navisdk.util.http.center.e();
        eVar.f9300a = false;
        com.baidu.navisdk.adapter.impl.locallimit.bean.c cVar = new com.baidu.navisdk.adapter.impl.locallimit.bean.c();
        com.baidu.navisdk.util.http.center.b.a().a(b2, null, new C0164d(cVar), eVar);
        return cVar;
    }

    public void a() {
        this.c.clear();
        this.d.clear();
    }
}
