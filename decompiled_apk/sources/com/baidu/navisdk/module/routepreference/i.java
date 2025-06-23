package com.baidu.navisdk.module.routepreference;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.routepreference.drivinghabit.c;
import com.baidu.navisdk.util.common.LogUtil;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class i {
    private static final String f = "i";
    private static i g;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<j> f7485a = null;
    private ArrayList<j> b = null;
    private ArrayList<j> c = null;
    public ArrayList<com.baidu.navisdk.module.routepreference.drivinghabit.c> d = null;
    private boolean e = false;

    private boolean b(int i, ArrayList<j> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                j jVar = arrayList.get(i2);
                if (jVar != null && (jVar.b & i) != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private void g() {
        if (!b(BNSettingManager.getLastRouteSearchMCarPrefer(), this.f7485a)) {
            if ((BNSettingManager.getLastRouteSearchMCarPrefer() & 32) != 0) {
                BNSettingManager.setLastRouteSearchMCarPrefer(33);
                d.j().f(33);
                BNSettingManager.setDefaultRouteSort(33);
            } else {
                BNSettingManager.setLastRouteSearchMCarPrefer(1);
                d.j().f(1);
                BNSettingManager.setDefaultRouteSort(1);
            }
        }
    }

    private void h() {
        int c = com.baidu.navisdk.module.motorbike.preferences.a.u0().c();
        if (!b(c, this.f7485a)) {
            if ((c & 32) != 0) {
                com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().f(33);
                com.baidu.navisdk.module.motorbike.preferences.a.u0().c(33);
            } else {
                com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().f(1);
                com.baidu.navisdk.module.motorbike.preferences.a.u0().c(1);
            }
        }
    }

    private void i() {
        int c = com.baidu.navisdk.module.trucknavi.preferences.a.r0().c();
        if (!b(c, d())) {
            if ((c & 32) != 0) {
                com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j().f(33);
                com.baidu.navisdk.module.trucknavi.preferences.a.r0().c(33);
            } else {
                com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j().f(1);
                com.baidu.navisdk.module.trucknavi.preferences.a.r0().c(1);
            }
        }
    }

    public static i j() {
        if (g == null) {
            synchronized (i.class) {
                try {
                    if (g == null) {
                        g = new i();
                    }
                } finally {
                }
            }
        }
        return g;
    }

    private void k() {
        if (this.b == null) {
            ArrayList<j> arrayList = new ArrayList<>();
            this.b = arrayList;
            arrayList.add(new j("智能推荐", 1));
            this.b.add(new j("躲避拥堵", 16));
            this.b.add(new j("时间优先", 256));
            this.b.add(new j("少收费", 8));
            this.b.add(new j("不走高速", 4));
            this.b.add(new j("高速优先", 512));
        }
    }

    private void l() {
        ArrayList<j> arrayList = new ArrayList<>();
        this.c = arrayList;
        arrayList.add(new j("智能推荐", 1));
        this.c.add(new j("躲避拥堵", 16));
        this.c.add(new j("省钱路线", 1024));
        this.c.add(new j("时间优先", 256));
        this.c.add(new j("高速优先", 512));
        this.c.add(new j("不走高速", 4));
    }

    public boolean a(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("road_sort");
            if (optJSONObject == null) {
                return false;
            }
            optJSONObject.optInt("open", 1);
            JSONArray optJSONArray = optJSONObject.optJSONArray("labels");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.f7485a = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    this.f7485a.add(new j(jSONObject2.getString(TTDownloadField.TT_LABEL), jSONObject2.getInt("tag")));
                }
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("truck_labels");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                this.c = new ArrayList<>();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                    this.c.add(new j(jSONObject3.getString(TTDownloadField.TT_LABEL), jSONObject3.getInt("tag")));
                }
            }
            return true;
        } catch (Exception unused) {
            this.f7485a = null;
            return false;
        }
    }

    public ArrayList<j> c() {
        ArrayList<j> arrayList = this.f7485a;
        if (arrayList == null) {
            k();
            return this.b;
        }
        return arrayList;
    }

    public ArrayList<j> d() {
        if (this.c == null) {
            l();
        }
        return this.c;
    }

    public boolean e() {
        ArrayList<com.baidu.navisdk.module.routepreference.drivinghabit.c> arrayList;
        if (this.e && (arrayList = this.d) != null && !arrayList.isEmpty()) {
            return true;
        }
        return false;
    }

    public void f() {
    }

    public String b() {
        int b = com.baidu.navisdk.module.vehiclemanager.b.i().b();
        if (b == 3) {
            return b(c.f(b));
        }
        return a(c.f(b));
    }

    public String b(int i) {
        return a(i, j().d());
    }

    public void b(JSONObject jSONObject) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(f, "parseDrivingHabitData start jsonObject:" + jSONObject);
        }
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has("isShowDrivingHabit")) {
            this.e = jSONObject.optJSONObject("isShowDrivingHabit").optInt("open") == 1;
        }
        BNSettingManager.setIsShowedDrivingHabitEnter(this.e);
        com.baidu.navisdk.module.motorbike.preferences.a.u0().i(this.e);
        if (jSONObject.has("drivingHabits")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("drivingHabits");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return;
            }
            int length = optJSONArray.length();
            ArrayList<com.baidu.navisdk.module.routepreference.drivinghabit.c> arrayList = this.d;
            if (arrayList != null) {
                arrayList.clear();
            } else {
                this.d = new ArrayList<>(length);
            }
            int routeSortDrivingHabitValue = BNSettingManager.getRouteSortDrivingHabitValue();
            int E = com.baidu.navisdk.module.motorbike.preferences.a.u0().E();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    com.baidu.navisdk.module.routepreference.drivinghabit.c cVar = new com.baidu.navisdk.module.routepreference.drivinghabit.c();
                    cVar.f7480a = optJSONObject.optString("titleName");
                    cVar.b = optJSONObject.optString("titleSummary");
                    cVar.c = optJSONObject.optInt("isMultiple") == 1;
                    if (!TextUtils.isEmpty(cVar.f7480a)) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("items");
                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                            int length2 = optJSONArray2.length();
                            ArrayList<c.a> arrayList2 = cVar.d;
                            if (arrayList2 == null) {
                                cVar.d = new ArrayList<>(length2);
                            } else {
                                arrayList2.clear();
                            }
                            for (int i4 = 0; i4 < length2; i4++) {
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i4);
                                if (optJSONObject2 != null) {
                                    c.a aVar = new c.a();
                                    aVar.f7481a = optJSONObject2.optString("name");
                                    aVar.b = optJSONObject2.optString("summary");
                                    aVar.c = optJSONObject2.optInt("preferValue");
                                    if (!TextUtils.isEmpty(aVar.f7481a) && aVar.c > 0) {
                                        cVar.d.add(aVar);
                                        int i5 = aVar.c;
                                        if ((routeSortDrivingHabitValue & i5) == i5) {
                                            i |= i5;
                                        }
                                        if ((E & i5) == i5) {
                                            i2 = i5 | i;
                                        }
                                    }
                                }
                            }
                        }
                        this.d.add(cVar);
                    }
                }
            }
            ArrayList<com.baidu.navisdk.module.routepreference.drivinghabit.c> arrayList3 = this.d;
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                if (i != routeSortDrivingHabitValue) {
                    BNSettingManager.setRouteSortDrivingHabitValue(i);
                }
                if (i2 != E) {
                    com.baidu.navisdk.module.motorbike.preferences.a.u0().r(i2);
                }
            }
        }
        if (LogUtil.LOGGABLE) {
            String str = f;
            StringBuilder sb = new StringBuilder();
            sb.append("parseDrivingHabitData done ");
            ArrayList<com.baidu.navisdk.module.routepreference.drivinghabit.c> arrayList4 = this.d;
            sb.append(arrayList4 == null ? "null" : arrayList4.toString());
            LogUtil.e(str, sb.toString());
        }
    }

    public void a() {
        g();
        h();
        i();
    }

    public String a(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(f, "getCurrentRouteSortName(), preferValue = " + i);
        }
        return a(i, j().c());
    }

    private String a(int i, ArrayList<j> arrayList) {
        if (arrayList == null) {
            return "";
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            j jVar = arrayList.get(i2);
            if (jVar != null && (jVar.b & i) != 0) {
                return jVar.f7486a;
            }
        }
        return "";
    }

    public String a(Context context, int i) {
        ArrayList<com.baidu.navisdk.module.routepreference.drivinghabit.c> arrayList;
        ArrayList<c.a> arrayList2;
        if (i != 0 && (arrayList = this.d) != null && !arrayList.isEmpty()) {
            Iterator<com.baidu.navisdk.module.routepreference.drivinghabit.c> it = this.d.iterator();
            String str = "";
            while (it.hasNext()) {
                com.baidu.navisdk.module.routepreference.drivinghabit.c next = it.next();
                if (next != null && (arrayList2 = next.d) != null) {
                    Iterator<c.a> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        c.a next2 = it2.next();
                        int i2 = next2.c;
                        if ((i & i2) == i2) {
                            if (TextUtils.isEmpty(str)) {
                                str = next2.f7481a;
                            } else {
                                str = String.format("%s，%s", str, next2.f7481a);
                            }
                        }
                    }
                }
            }
            return TextUtils.isEmpty(str) ? context.getString(R.string.nsdk_string_smart_route_know_better) : str;
        }
        return context.getString(R.string.nsdk_string_smart_route_know_better);
    }
}
