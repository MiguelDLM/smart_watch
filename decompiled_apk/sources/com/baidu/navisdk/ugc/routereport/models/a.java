package com.baidu.navisdk.ugc.routereport.models;

import com.baidu.navisdk.util.common.g;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<com.baidu.navisdk.ugc.routereport.models.b> f8327a;

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static a f8328a = new a();
    }

    public static a a() {
        return b.f8328a;
    }

    private void b() {
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < this.f8327a.size() && (i == -1 || i2 == -1); i3++) {
            if (this.f8327a.get(i3).c == 11) {
                i = i3;
            } else if (this.f8327a.get(i3).c == 16) {
                i2 = i3;
            }
        }
        Collections.swap(this.f8327a, i, i2);
    }

    private ArrayList<com.baidu.navisdk.ugc.routereport.models.b> c(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length() + 1;
        ArrayList<com.baidu.navisdk.ugc.routereport.models.b> arrayList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            try {
                com.baidu.navisdk.ugc.routereport.models.b a2 = a(false, jSONArray.getJSONObject(i));
                if (a2 != null) {
                    arrayList.add(a2);
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private a() {
        this.f8327a = null;
    }

    public void a(JSONArray jSONArray, JSONObject jSONObject) {
        com.baidu.navisdk.ugc.routereport.models.b a2;
        b(jSONArray);
        if (jSONObject == null || this.f8327a == null || (a2 = a(false, jSONObject)) == null) {
            return;
        }
        this.f8327a.add(a2);
        b();
    }

    public void b(JSONArray jSONArray) {
        this.f8327a = c(jSONArray);
    }

    public void a(JSONArray jSONArray) {
        c(jSONArray);
    }

    private com.baidu.navisdk.ugc.routereport.models.b a(boolean z, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.navisdk.ugc.routereport.models.b bVar = new com.baidu.navisdk.ugc.routereport.models.b();
        try {
            bVar.f8329a = z;
            bVar.b = jSONObject.getString("title");
            bVar.c = jSONObject.getInt("type");
            if (jSONObject.has(x.cD)) {
                bVar.d = jSONObject.getString(x.cD);
            }
            if (!z) {
                if (jSONObject.has("subtype")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("subtype");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        bVar.e = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            try {
                                com.baidu.navisdk.ugc.routereport.models.b a2 = a(true, jSONArray.getJSONObject(i));
                                g gVar = g.UGC;
                                if (gVar.d()) {
                                    gVar.e("UgcModule_RouteReport", "parseSingleItem: subItem --> " + a2.toString());
                                }
                                if (a2 != null) {
                                    bVar.e.add(a2);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    } else {
                        a(bVar);
                    }
                } else {
                    a(bVar);
                }
            }
            if (!z) {
                g gVar2 = g.UGC;
                if (gVar2.d()) {
                    gVar2.e("UgcModule_RouteReport", "parseSingleItem: parentItem --> " + bVar.toString());
                }
            }
            return bVar;
        } catch (Exception e) {
            g gVar3 = g.UGC;
            if (gVar3.d()) {
                gVar3.e("UgcModule_RouteReport", "parseSingleItem: Exception --> " + e.toString());
            }
            e.printStackTrace();
            return null;
        }
    }

    public void a(com.baidu.navisdk.ugc.routereport.models.b bVar) {
        ArrayList<com.baidu.navisdk.ugc.routereport.models.b> arrayList = new ArrayList<>(4);
        bVar.e = arrayList;
        int i = bVar.c;
        if (i != 2) {
            switch (i) {
                case 11:
                    arrayList.add(new com.baidu.navisdk.ugc.routereport.models.b(true, "找不到终点", 111));
                    bVar.e.add(new com.baidu.navisdk.ugc.routereport.models.b(true, "车辆无法通行", 112));
                    return;
                case 12:
                    arrayList.add(new com.baidu.navisdk.ugc.routereport.models.b(true, "播报延迟错过路口", 121));
                    bVar.e.add(new com.baidu.navisdk.ugc.routereport.models.b(true, "播报内容错误", 122));
                    return;
                case 13:
                    arrayList.add(new com.baidu.navisdk.ugc.routereport.models.b(true, "封路", 131));
                    bVar.e.add(new com.baidu.navisdk.ugc.routereport.models.b(true, "单向通行", 132));
                    bVar.e.add(new com.baidu.navisdk.ugc.routereport.models.b(true, "路不存在", 134));
                    bVar.e.add(new com.baidu.navisdk.ugc.routereport.models.b(true, "路障", 135));
                    return;
                default:
                    return;
            }
        }
        arrayList.add(new com.baidu.navisdk.ugc.routereport.models.b(true, "有禁左", 21));
        bVar.e.add(new com.baidu.navisdk.ugc.routereport.models.b(true, "有禁右", 23));
        bVar.e.add(new com.baidu.navisdk.ugc.routereport.models.b(true, "有禁掉", 22));
    }
}
