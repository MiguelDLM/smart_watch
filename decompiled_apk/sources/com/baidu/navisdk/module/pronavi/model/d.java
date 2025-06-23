package com.baidu.navisdk.module.pronavi.model;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.baidu.navisdk.adapter.IBNRouteResultManager;
import com.baidu.navisdk.util.common.l0;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class d implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private String f7464a;
    private int b;
    private String c;
    private int d;
    private boolean g;
    private boolean h;
    private String i;
    private String j;
    private String k;
    private int l;
    private String m;
    private String n;
    private int o;
    private GeoPoint p;
    private com.baidu.navisdk.model.service.a q;
    private boolean r;
    private String s;
    private int e = 0;
    private final List<Integer> f = new ArrayList();
    private final Map<String, Object> t = new ArrayMap();

    public static String g(int i) {
        if (i == 1) {
            return "加油";
        }
        if (i == 2) {
            return "充电";
        }
        if (i == 4) {
            return "充气";
        }
        if (i == 8) {
            return "停车";
        }
        if (i == 16) {
            return "汽修";
        }
        if (i == 32) {
            return IBNRouteResultManager.NearbySearchKeyword.Restaurant;
        }
        if (i == 64) {
            return "卫生间";
        }
        if (i == 128) {
            return "超市购物";
        }
        if (i != 256) {
            return null;
        }
        return "休闲娱乐";
    }

    private void t() {
        StringBuilder sb = new StringBuilder();
        this.n = l0.a(this.o, sb);
        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0' && sb.charAt(sb.length() - 2) == '.') {
            this.m = sb.substring(0, sb.length() - 2);
        } else {
            this.m = sb.toString();
        }
    }

    public void a(com.baidu.navisdk.model.service.a aVar) {
        this.q = aVar;
    }

    public void b(String str) {
        this.j = str;
    }

    public void c(String str) {
        this.i = str;
    }

    public String d() {
        return this.i;
    }

    public void e(int i) {
        this.d = i;
    }

    public com.baidu.navisdk.model.service.a f() {
        return this.q;
    }

    public String h() {
        return this.c;
    }

    public String i() {
        return this.s;
    }

    public GeoPoint j() {
        return this.p;
    }

    public int k() {
        return this.o;
    }

    public String l() {
        if ("km".equals(this.n)) {
            return "公里";
        }
        return "米";
    }

    public String m() {
        return this.m;
    }

    public String n() {
        return this.n;
    }

    public List<Integer> o() {
        return this.f;
    }

    public int p() {
        return this.b;
    }

    public boolean q() {
        return this.h;
    }

    public boolean r() {
        return this.r;
    }

    public boolean s() {
        return this.g;
    }

    public String toString() {
        return "BNServiceAreaBean{mId='" + this.f7464a + "', type=" + this.b + ", name='" + this.c + "', mSubType=" + this.d + ", mButtonType=" + this.e + ", mServiceAreaSubType=" + this.f + ", mIsSubscribed=" + this.g + ", mExitIDName='" + this.i + "', mExitDrName='" + this.j + "', mExitRoadName='" + this.k + "', mAddDist=" + this.l + ", mRemainDistStr='" + this.m + "', mRemainDistUnitKm='" + this.n + "', mRemainDist=" + this.o + ", mPoint=" + this.p + ", mExtraData=" + this.t + ", mGasInfo=" + this.q + ", parkingAvailable=" + this.r + ", parkingLotUid=" + this.s + '}';
    }

    public int a() {
        return this.l;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public String c() {
        return this.j;
    }

    public void d(String str) {
        this.k = str;
    }

    public String e() {
        return this.k;
    }

    public void f(int i) {
        this.b = i;
    }

    public String g() {
        return this.f7464a;
    }

    public void a(GeoPoint geoPoint) {
        this.p = geoPoint;
    }

    public void b(int i) {
        this.l = i;
    }

    public void c(boolean z) {
        this.r = z;
    }

    public void d(int i) {
        this.o = i;
        t();
    }

    public void e(String str) {
        this.f7464a = str;
    }

    public void f(String str) {
        this.c = str;
    }

    public void g(String str) {
        this.s = str;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public int b() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public void a(int i) {
        this.o = this.l - i;
        t();
    }

    public void b(String str, Object obj) {
        this.t.put(str, obj);
    }

    public void a(List<Integer> list) {
        this.f.clear();
        this.f.addAll(list);
    }

    public <T> T a(@NonNull String str) {
        return (T) a(str, null);
    }

    public <T> T a(@NonNull String str, T t) {
        T t2 = (T) this.t.get(str);
        return t2 == null ? t : t2;
    }
}
