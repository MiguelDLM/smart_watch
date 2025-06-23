package com.baidu.navisdk.ugc.report.data.datarepository;

import android.graphics.drawable.Drawable;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class d {
    private static d n = null;
    public static boolean o = false;
    private f c;

    /* renamed from: a, reason: collision with root package name */
    private a f8248a = null;
    private c b = null;
    private String d = null;
    private com.baidu.navisdk.ugc.report.data.datarepository.b e = null;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> f = null;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> g = null;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> h = null;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> i = null;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> j = null;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> k = null;
    private b l = null;
    private b m = null;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f8249a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;

        public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.f8249a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = str6;
            this.g = str7;
        }

        public String toString() {
            return "ActBaseDataModel{entryIconUrl='" + this.f8249a + "', bannerIconUrl='" + this.b + "', camaraIconUrl='" + this.c + "', entryTips='" + this.d + "', bannerTips='" + this.e + "', camraTips='" + this.f + "', bottonTips='" + this.g + "'}";
        }
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f8250a = "";
        public ArrayList<a> b = null;

        /* loaded from: classes8.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            int f8251a;
            String b;
            String c;
            Drawable d = null;

            public Drawable a() {
                return this.d;
            }

            public String b() {
                return this.c;
            }

            public String c() {
                return this.b;
            }

            public int d() {
                return this.f8251a;
            }

            public String toString() {
                return "CheckBoxOption{type=" + this.f8251a + ", optionText='" + this.b + "', IconUrl='" + this.c + "', IconDrawable=" + this.d + '}';
            }
        }

        public String toString() {
            return "CheckBoxContentModel{title='" + this.f8250a + "', optionList=" + Arrays.toString(this.b.toArray()) + '}';
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
    }

    private d() {
        this.c = null;
        this.c = f.e();
    }

    public static d i() {
        if (n == null) {
            n = new d();
        }
        return n;
    }

    private void j() {
        if (this.f != null && this.g != null && this.h != null) {
            for (int i = 0; i < this.f.size(); i++) {
                this.c.a(this.f.get(i), 1);
            }
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                this.c.a(this.g.get(i2), 2);
            }
        }
    }

    private void k() {
        b bVar = new b();
        this.m = bVar;
        bVar.f8250a = JarUtils.getResources().getString(R.string.nsdk_string_ugc_jam_report_notication_title);
        this.m.b = new ArrayList<>();
        b.a aVar = new b.a();
        aVar.f8251a = 5;
        aVar.b = "事故";
        aVar.d = JarUtils.getResources().getDrawable(R.drawable.nsdk_type_default_trafic_accident);
        b.a aVar2 = new b.a();
        aVar2.f8251a = -1;
        aVar2.b = "其他";
        aVar2.d = JarUtils.getResources().getDrawable(R.drawable.nsdk_ugc_jam_notification_others);
        this.m.b.add(aVar);
        this.m.b.add(aVar2);
    }

    public boolean a(int i) {
        ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = this.h;
        if (arrayList == null) {
            return false;
        }
        Iterator<com.baidu.navisdk.ugc.report.data.datarepository.b> it = arrayList.iterator();
        while (it.hasNext()) {
            if (i == it.next().b) {
                return true;
            }
        }
        return false;
    }

    public b b() {
        b bVar = this.l;
        if (bVar != null) {
            return bVar;
        }
        if (this.m == null) {
            k();
        }
        return this.m;
    }

    public String c() {
        return this.d;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> d() {
        if (this.f == null) {
            this.f = this.c.a();
        }
        return this.f;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> e() {
        if (this.h == null) {
            this.h = this.c.b();
        }
        return this.h;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> f() {
        if (this.g == null) {
            this.g = this.c.c();
        }
        return this.g;
    }

    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> g() {
        return this.c.d();
    }

    public void h() {
        if (this.f != null && this.g != null && this.h != null) {
            j();
        }
    }

    public String toString() {
        return "UgcDataRepository{mActBaseDataModel=" + this.f8248a + ", mCommonBaseDataModel=" + this.b + ", mNaviUgcReportIconUrl='" + this.d + "', mMapUgcActTipModel=" + this.e + ", mMapUgcDataList=" + this.f + ", mNaviUgcDataList=" + this.g + ", mNaviUgcMayiDataList=" + this.h + ", mMapPositionFeedBackDataList=" + this.i + ", mMapRoadFeedBackDataList=" + this.j + ", mMapOtherFeedBackDataList=}";
    }

    private com.baidu.navisdk.ugc.report.data.datarepository.b c(JSONObject jSONObject) {
        com.baidu.navisdk.ugc.report.data.datarepository.b bVar = new com.baidu.navisdk.ugc.report.data.datarepository.b();
        bVar.b = jSONObject.optInt("type");
        bVar.f8246a = jSONObject.optString("title");
        bVar.c = jSONObject.optString(x.cD);
        bVar.d = jSONObject.optString("link");
        bVar.e = jSONObject.optString("describe");
        bVar.f = jSONObject.optString(RequestParameters.MARKER);
        bVar.g = jSONObject.optString("markerColor");
        return bVar;
    }

    private synchronized void d(JSONObject jSONObject) {
        JSONObject optJSONObject;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcDataRepository", "parseCheckBoxContentData: " + jSONObject);
        }
        try {
            optJSONObject = jSONObject.getJSONObject("ugc_navi_checkbox_content").optJSONObject("yongdu");
        } catch (JSONException e) {
            e.printStackTrace();
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar2.d()) {
                gVar2.e("UgcDataRepository", "key获取数据失败" + jSONObject);
            }
        }
        if (optJSONObject == null) {
            return;
        }
        b bVar = new b();
        this.l = bVar;
        bVar.f8250a = optJSONObject.optString("title");
        this.l.b = new ArrayList<>();
        JSONArray optJSONArray = optJSONObject.optJSONArray("option");
        for (int i = 0; i < optJSONArray.length(); i++) {
            b.a aVar = new b.a();
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            aVar.b = jSONObject2.optString("optionText");
            aVar.c = jSONObject2.optString("optionIconUrl");
            aVar.f8251a = jSONObject2.optInt("optionType");
            this.l.b.add(aVar);
        }
        com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.UGC;
        if (gVar3.d()) {
            gVar3.e("UgcDataRepository", "解析后数据 : " + this.l.toString());
        }
    }

    private void e(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("map_feedback_15_3");
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcDataRepository", "mainDataObject" + jSONObject2);
            }
            if (jSONObject2 != null) {
                JSONArray jSONArray = jSONObject2.getJSONArray("location");
                JSONArray jSONArray2 = jSONObject2.getJSONArray("road");
                JSONArray jSONArray3 = jSONObject2.getJSONArray("other");
                int length = jSONArray.length();
                int length2 = jSONArray2.length();
                int length3 = jSONArray3.length();
                this.i = new ArrayList<>(length);
                this.j = new ArrayList<>(length2);
                this.k = new ArrayList<>(length3);
                for (int i = 0; i < length; i++) {
                    this.i.add(c(jSONArray.getJSONObject(i)));
                }
                for (int i2 = 0; i2 < length2; i2++) {
                    this.j.add(c(jSONArray2.getJSONObject(i2)));
                }
                for (int i3 = 0; i3 < length3; i3++) {
                    this.k.add(c(jSONArray3.getJSONObject(i3)));
                }
            }
        } catch (Exception unused) {
            this.i = null;
        }
    }

    public a a() {
        return this.f8248a;
    }

    public synchronized boolean a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("ugc_sug")) {
                i.c().a(jSONObject.getJSONObject("ugc_sug"));
            }
        } catch (Exception e) {
            if (com.baidu.navisdk.util.common.g.UGC.d()) {
                e.printStackTrace();
            }
        }
        if (jSONObject.has("login_guide")) {
            try {
                o = jSONObject.optJSONObject("login_guide").optInt("value") == 1;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            com.baidu.navisdk.ugc.routereport.models.a.a().a(jSONObject.optJSONArray("ugc_carpage"), jSONObject.optJSONObject("route_result_end_error"));
        } catch (Exception e3) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.c()) {
                gVar.c("UgcDataRepository", "parseCloudJson ugc_carpage " + e3.toString());
            }
        }
        try {
            com.baidu.navisdk.ugc.routereport.models.a.a().a(jSONObject.optJSONArray("ugc_finishpage"));
        } catch (Exception e4) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar2.c()) {
                gVar2.c("UgcDataRepository", "parseCloudJson ugc_finishpage " + e4.toString());
            }
        }
        try {
            b(jSONObject);
            this.h = this.c.b();
            e(jSONObject);
            d(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("navi_report_entry_icon");
            if (optJSONObject != null) {
                this.d = optJSONObject.optString("value");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ugc_act");
            if (optJSONObject2 != null) {
                this.f8248a = new a(optJSONObject2.optString("entry_icon"), null, null, null, null, null, optJSONObject2.optString("botton_tips"));
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("ugc_act_tips");
            if (optJSONObject3 != null) {
                com.baidu.navisdk.ugc.report.data.datarepository.b bVar = new com.baidu.navisdk.ugc.report.data.datarepository.b(optJSONObject3.optString("text"), 0, optJSONObject3.optString(x.cD));
                this.e = bVar;
                bVar.d = optJSONObject3.optString("url");
            }
        } catch (Exception unused) {
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            return false;
        }
        return true;
    }

    public synchronized boolean b(JSONObject jSONObject) {
        ArrayList arrayList;
        ArrayList arrayList2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcDataRepository", "parseUgcDynamicEvents: " + jSONObject);
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("ugc_map");
            JSONArray jSONArray2 = jSONObject.getJSONArray("ugc_navi");
            if (jSONArray != null) {
                arrayList = new ArrayList(jSONArray.length() + 1);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    int i2 = jSONObject2.getInt("type");
                    if (this.c.d(i2)) {
                        arrayList.add(new com.baidu.navisdk.ugc.report.data.datarepository.b(jSONObject2.getString("title"), i2, jSONObject2.getString(x.cD)));
                    }
                }
            } else {
                arrayList = null;
            }
            if (jSONArray2 != null) {
                arrayList2 = new ArrayList(jSONArray2.length() + 1);
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                    int i4 = jSONObject3.getInt("type");
                    if (this.c.d(i4)) {
                        arrayList2.add(new com.baidu.navisdk.ugc.report.data.datarepository.b(jSONObject3.getString("title"), i4, jSONObject3.getString(x.cD)));
                    }
                }
            } else {
                arrayList2 = null;
            }
            if (jSONObject.has("ugc_extreme_weather_item")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("ugc_extreme_weather_item");
                com.baidu.navisdk.ugc.report.data.datarepository.b bVar = optJSONObject != null ? new com.baidu.navisdk.ugc.report.data.datarepository.b(optJSONObject.optString("title"), optJSONObject.optInt("type"), optJSONObject.optString(x.cD)) : null;
                if (bVar != null && this.c.d(bVar.b)) {
                    if (arrayList != null) {
                        arrayList.add(bVar);
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(new com.baidu.navisdk.ugc.report.data.datarepository.b(bVar.f8246a, bVar.b, bVar.c));
                    }
                }
            }
            if (this.f == null) {
                this.f = new ArrayList<>(6);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f.clear();
                this.f.addAll(arrayList);
            }
            if (this.g == null) {
                this.g = new ArrayList<>(6);
            }
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                this.g.clear();
                this.g.addAll(arrayList2);
            }
        } catch (Exception unused) {
            return false;
        }
        return true;
    }
}
