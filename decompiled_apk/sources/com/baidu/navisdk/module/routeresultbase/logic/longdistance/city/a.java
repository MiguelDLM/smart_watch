package com.baidu.navisdk.module.routeresultbase.logic.longdistance.city;

import com.baidu.nplatform.comapi.basestruct.c;

/* loaded from: classes7.dex */
public class a implements com.baidu.navisdk.module.routeresultbase.logic.longdistance.a {
    public c e;
    public String g;
    public String h;
    public String i;

    /* renamed from: a, reason: collision with root package name */
    public String f7513a = null;
    public int b = 0;
    public long c = 0;
    public long d = 0;
    public int f = 0;
    public boolean j = false;
    public boolean k = false;

    public void a(com.baidu.navisdk.module.routeresultbase.logic.longdistance.a aVar) {
        if (aVar instanceof a) {
            a aVar2 = (a) aVar;
            this.f = aVar2.f;
            this.b = aVar2.b;
            this.c = aVar2.c;
            this.g = aVar2.g;
            this.f7513a = aVar2.f7513a;
            this.d = aVar2.d;
            this.h = aVar2.h;
            this.j = aVar2.j;
            this.i = aVar2.i;
            this.k = aVar2.k;
            if (aVar2.e != null) {
                this.e = new c(r0.c(), aVar2.e.d());
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.b != aVar.b || !this.f7513a.equals(aVar.f7513a)) {
            return false;
        }
        return this.e.a(aVar.e);
    }

    public int hashCode() {
        return (((this.f7513a.hashCode() * 31) + this.b) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "CarPassCityInfo{mCityName='" + this.f7513a + "', mCityCode=" + this.b + ", mDistance=" + this.c + ", mArriveTime=" + this.d + ", mPoint=" + this.e + ", rank=" + this.f + ", mClimate='" + this.g + "', mTemperature='" + this.h + "', mIconUrl='" + this.i + "', isAlarm=" + this.j + ", hasUpdateWeather=" + this.k + '}';
    }
}
