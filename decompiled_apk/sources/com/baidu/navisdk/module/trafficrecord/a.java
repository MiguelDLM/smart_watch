package com.baidu.navisdk.module.trafficrecord;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.datastruct.w;
import com.baidu.navisdk.module.trafficrecord.c;
import com.baidu.navisdk.module.trucknavi.logic.plate.d;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.http.center.e;
import com.baidu.navisdk.util.http.center.f;
import com.baidu.navisdk.util.http.center.i;
import com.baidu.navisdk.util.http.center.l;
import com.baidu.nplatform.comapi.MapItem;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.huawei.openalliance.ad.constant.x;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {
    private static final List<l> d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    com.baidu.navisdk.module.trafficrecord.b f7569a;
    ArrayList<w> b = null;
    int c = 1;

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public b(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            TipTool.toast("请沿报备路线行驶，避免违章");
        }
    }

    public a(com.baidu.navisdk.module.trafficrecord.b bVar) {
        this.f7569a = bVar;
    }

    public boolean a(String str, ArrayList<c> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (str.equals(arrayList.get(i).c())) {
                return true;
            }
        }
        return false;
    }

    public String b(ArrayList<c> arrayList) throws JSONException {
        if (arrayList == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pass_id", arrayList.get(i).c());
            JSONArray jSONArray2 = new JSONArray();
            if (arrayList.get(i).b() != null) {
                for (int i2 = 0; i2 < arrayList.get(i).b().size(); i2++) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("x", Math.round(arrayList.get(i).b().get(i2).a().doubleValue() * 1000000.0d) / 1000000.0d);
                    jSONObject2.put("y", Math.round(arrayList.get(i).b().get(i2).b().doubleValue() * 1000000.0d) / 1000000.0d);
                    jSONArray2.put(i2, jSONObject2);
                }
            }
            jSONObject.put("data", jSONArray2);
            String str = "";
            if (arrayList.get(i).a() != null) {
                for (int i3 = 0; i3 < arrayList.get(i).a().size(); i3++) {
                    str = (str + (Math.round(arrayList.get(i).a().get(i3).a().doubleValue() * 1000000.0d) / 1000000.0d) + ",") + (Math.round(arrayList.get(i).a().get(i3).b().doubleValue() * 1000000.0d) / 1000000.0d) + x.aL;
                }
            }
            jSONObject.put("eye_point", str);
            if (!com.baidu.navisdk.framework.b.e0()) {
                long j = w.a(arrayList.get(i).c(), com.baidu.navisdk.framework.b.a(3, com.baidu.navisdk.module.trucknavi.logic.plate.c.g().b())).d;
                long j2 = w.a(arrayList.get(i).c(), com.baidu.navisdk.framework.b.a(3, com.baidu.navisdk.module.trucknavi.logic.plate.c.g().b())).e;
                jSONObject.put("register_date", j);
                jSONObject.put("expire_date", j2);
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray.toString();
    }

    public ArrayList<c> c() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        BNRoutePlaner.getInstance().a(arrayList);
        ArrayList<c> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            c cVar = new c();
            cVar.a(arrayList.get(i).getInt("enRecordType"));
            cVar.a(arrayList.get(i).getString("strPassPortId"));
            double[] doubleArray = arrayList.get(i).getDoubleArray("NEPosX");
            double[] doubleArray2 = arrayList.get(i).getDoubleArray("NEPosY");
            if (doubleArray != null) {
                ArrayList<c.a> arrayList3 = new ArrayList<>();
                for (int i2 = 0; i2 < doubleArray.length; i2++) {
                    c.a aVar = new c.a();
                    aVar.a(Double.valueOf(doubleArray[i2]));
                    aVar.b(Double.valueOf(doubleArray2[i2]));
                    arrayList3.add(aVar);
                }
                cVar.b(arrayList3);
            }
            double[] doubleArray3 = arrayList.get(i).getDoubleArray("CameraNEPosX");
            double[] doubleArray4 = arrayList.get(i).getDoubleArray("CameraNEPosY");
            if (doubleArray3 != null) {
                ArrayList<c.a> arrayList4 = new ArrayList<>();
                for (int i3 = 0; i3 < doubleArray3.length; i3++) {
                    c.a aVar2 = new c.a();
                    aVar2.a(Double.valueOf(doubleArray3[i3]));
                    aVar2.b(Double.valueOf(doubleArray4[i3]));
                    arrayList4.add(aVar2);
                }
                cVar.a(arrayList4);
            }
            arrayList2.add(cVar);
        }
        return arrayList2;
    }

    public String d() throws JSONException {
        d dVar = new d(com.baidu.navisdk.module.trucknavi.logic.plate.c.g().a());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("truck_type", dVar.f7582a);
        jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, dVar.g);
        jSONObject.put("height", dVar.h);
        jSONObject.put("length", dVar.f);
        jSONObject.put("emission", dVar.b);
        jSONObject.put("truck_ext", dVar.q);
        jSONObject.put("power_type", dVar.c);
        return jSONObject.toString();
    }

    public void e() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("TrafficRecordPop", "二次报备——静默");
        }
        ArrayList<w> b2 = b();
        ArrayList<c> c = c();
        if (c != null && c.size() != 0 && b2 != null && b2.size() != 0) {
            for (int i = 0; i < b2.size(); i++) {
                if (a(b2.get(i).f6945a, c)) {
                    a(true);
                    new Handler(Looper.getMainLooper()).post(new b(this));
                }
            }
        }
    }

    public void a(boolean z) {
        if (z) {
            ArrayList<c> c = c();
            if (c == null || c.size() == 0) {
                return;
            }
            a(c);
            e eVar = new e();
            eVar.f9300a = true;
            com.baidu.navisdk.util.http.center.b.a().b(com.baidu.navisdk.util.http.b.d().b("TrafficRecord"), com.baidu.navisdk.util.http.center.c.a(d), new C0294a(z), eVar);
            return;
        }
        this.f7569a.a();
        throw null;
    }

    public void a(ArrayList<c> arrayList) {
        String str;
        List<l> list = d;
        list.add(new i("source", MapItem.KEY_IS_MAP_ITEM));
        list.add(new i("cuid", a0.e()));
        list.add(new i("times", this.c + ""));
        list.add(new i("sv", a0.k()));
        if (com.baidu.navisdk.framework.b.e0()) {
            list.add(new i("bduss", com.baidu.navisdk.framework.b.e()));
            a();
        }
        list.add(new i("vehicle_type", "3"));
        String b2 = com.baidu.navisdk.module.trucknavi.logic.plate.c.g().b();
        list.add(new i("plate", b2));
        try {
            str = b(arrayList);
        } catch (JSONException e) {
            e.printStackTrace();
            str = "";
        }
        List<l> list2 = d;
        list2.add(new i("pass_data", str));
        try {
            list2.add(new i("truck_info", d()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String str2 = (System.currentTimeMillis() / 1000) + "";
        List<l> list3 = d;
        list3.add(new i("time", str2));
        list3.add(new i(HttpConstants.SIGN, a(MapItem.KEY_IS_MAP_ITEM + str2 + str + b2)));
    }

    /* renamed from: com.baidu.navisdk.module.trafficrecord.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0294a extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7570a;

        public C0294a(boolean z) {
            this.f7570a = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
        @Override // com.baidu.navisdk.util.http.center.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(int r9, java.lang.String r10) {
            /*
                r8 = this;
                java.lang.String r0 = "status"
                java.lang.String r1 = "content"
                boolean r2 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
                if (r2 == 0) goto L22
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "onSuccess().statusCode="
                r2.append(r3)
                r2.append(r9)
                r2.append(r10)
                java.lang.String r9 = r2.toString()
                java.lang.String r2 = "TrafficRecordPop1"
                com.baidu.navisdk.util.common.LogUtil.e(r2, r9)
            L22:
                r9 = -1
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L3d
                r2.<init>(r10)     // Catch: org.json.JSONException -> L3d
                org.json.JSONObject r3 = r2.getJSONObject(r1)     // Catch: org.json.JSONException -> L3d
                int r3 = r3.getInt(r0)     // Catch: org.json.JSONException -> L3d
                org.json.JSONObject r2 = r2.getJSONObject(r1)     // Catch: org.json.JSONException -> L3b
                java.lang.String r4 = "retry"
                int r9 = r2.getInt(r4)     // Catch: org.json.JSONException -> L3b
                goto L46
            L3b:
                r2 = move-exception
                goto L3f
            L3d:
                r2 = move-exception
                r3 = -1
            L3f:
                boolean r4 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
                if (r4 == 0) goto L46
                r2.printStackTrace()
            L46:
                r2 = 0
                r4 = 1
                if (r3 != r4) goto L65
                boolean r9 = r8.f7570a
                if (r9 != 0) goto Ld4
                com.baidu.navisdk.module.trafficrecord.a r9 = com.baidu.navisdk.module.trafficrecord.a.this
                com.baidu.navisdk.module.trafficrecord.b r9 = r9.f7569a
                if (r9 != 0) goto L5f
                if (r9 == 0) goto Ld4
                com.baidu.navisdk.module.trafficrecord.b$a r9 = r9.b
                if (r9 == 0) goto Ld4
                r9.a()
                goto Ld4
            L5f:
                r9.f7571a = r4
                r9.b()
                throw r2
            L65:
                java.lang.String r3 = "网络连接失败"
                r5 = 0
                org.json.JSONObject r6 = new org.json.JSONObject     // Catch: org.json.JSONException -> L92
                r6.<init>(r10)     // Catch: org.json.JSONException -> L92
                org.json.JSONObject r10 = r6.getJSONObject(r1)     // Catch: org.json.JSONException -> L92
                java.lang.String r1 = "list"
                org.json.JSONArray r10 = r10.getJSONArray(r1)     // Catch: org.json.JSONException -> L92
                r1 = 0
            L79:
                int r6 = r10.length()     // Catch: org.json.JSONException -> L92
                if (r1 >= r6) goto L9a
                java.lang.Object r6 = r10.get(r1)     // Catch: org.json.JSONException -> L92
                org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch: org.json.JSONException -> L92
                int r7 = r6.getInt(r0)     // Catch: org.json.JSONException -> L92
                if (r7 == r4) goto L94
                java.lang.String r7 = "message"
                java.lang.String r3 = r6.getString(r7)     // Catch: org.json.JSONException -> L92
                goto L94
            L92:
                r10 = move-exception
                goto L97
            L94:
                int r1 = r1 + 1
                goto L79
            L97:
                r10.printStackTrace()
            L9a:
                boolean r10 = r8.f7570a
                if (r10 != 0) goto La9
                com.baidu.navisdk.module.trafficrecord.a r9 = com.baidu.navisdk.module.trafficrecord.a.this
                com.baidu.navisdk.module.trafficrecord.b r9 = r9.f7569a
                if (r9 != 0) goto La5
                goto Ld4
            La5:
                r9.a(r3)
                throw r2
            La9:
                com.baidu.navisdk.module.trafficrecord.a r10 = com.baidu.navisdk.module.trafficrecord.a.this
                int r0 = r10.c
                int r0 = r0 + r4
                r10.c = r0
                if (r9 == r4) goto Lc4
                r10.c = r4
                com.baidu.navisdk.framework.a r9 = com.baidu.navisdk.framework.a.c()
                android.content.Context r9 = r9.a()
                android.widget.Toast r9 = android.widget.Toast.makeText(r9, r3, r5)
                r9.show()
                return
            Lc4:
                boolean r9 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
                if (r9 == 0) goto Lcf
                java.lang.String r9 = "TrafficRecordPop"
                java.lang.String r10 = " 重新发起静默报备"
                com.baidu.navisdk.util.common.LogUtil.e(r9, r10)
            Lcf:
                com.baidu.navisdk.module.trafficrecord.a r9 = com.baidu.navisdk.module.trafficrecord.a.this
                r9.a(r4)
            Ld4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.trafficrecord.a.C0294a.a(int, java.lang.String):void");
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("TrafficRecordPop2", "onFailure().statusCode=" + i);
            }
            if (!this.f7570a) {
                com.baidu.navisdk.module.trafficrecord.b bVar = a.this.f7569a;
                if (bVar == null) {
                    return;
                }
                bVar.a("网络连接失败");
                throw null;
            }
            a aVar = a.this;
            int i2 = aVar.c + 1;
            aVar.c = i2;
            if (i2 > 5) {
                aVar.c = 1;
                Toast.makeText(com.baidu.navisdk.framework.a.c().a(), "备案网络不畅，请稍后重新算路", 0).show();
            } else {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("TrafficRecordPop", "onFailure() 重新发起静默报备");
                }
                a.this.a(true);
            }
        }
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a() {
        if (this.b == null) {
            this.b = b();
        }
        if (this.b.size() != 0) {
            w wVar = this.b.get(0);
            List<l> list = d;
            list.add(new i("pass_id", wVar.f6945a));
            list.add(new i("plate", wVar.b));
            list.add(new i("vehicle_type", wVar.c + ""));
            list.add(new i("register_date", wVar.d + ""));
            list.add(new i("expire_date", wVar.e + ""));
            list.add(new i("status", wVar.f + ""));
            list.add(new i("pass_title", wVar.g));
            list.add(new i("city_id", wVar.h + ""));
            list.add(new i("city_name", wVar.i));
            list.add(new i("info_ids", wVar.j));
            list.add(new i("limit_rule", wVar.k));
        }
    }

    public ArrayList<w> b() {
        return w.a(com.baidu.navisdk.framework.b.a(3, com.baidu.navisdk.module.trucknavi.logic.plate.c.g().b()));
    }
}
