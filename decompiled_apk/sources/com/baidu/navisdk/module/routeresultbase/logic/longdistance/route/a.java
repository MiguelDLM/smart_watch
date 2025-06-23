package com.baidu.navisdk.module.routeresultbase.logic.longdistance.route;

import androidx.annotation.NonNull;
import com.baidu.nplatform.comapi.basestruct.c;

/* loaded from: classes7.dex */
public class a implements com.baidu.navisdk.module.routeresultbase.logic.longdistance.a, Comparable<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f7519a = null;
    public String b = null;
    public String c = null;
    public int d = 0;
    public boolean e = false;
    public c f = null;
    public c g = null;
    public c h = null;
    public int i = 0;
    public boolean j = false;

    public void a(com.baidu.navisdk.module.routeresultbase.logic.longdistance.a aVar) {
        if (aVar instanceof a) {
            a aVar2 = (a) aVar;
            this.f7519a = aVar2.f7519a;
            this.d = aVar2.d;
            if (aVar2.f != null) {
                this.f = new c(r0.c(), aVar2.f.d());
            }
            this.b = aVar2.b;
            this.c = aVar2.c;
            this.e = aVar2.e;
            this.i = aVar2.i;
        }
    }

    public String toString() {
        return "CarPassRouteInfo{mRoadName='" + this.f7519a + "', mLane='" + this.b + "', mSpeed='" + this.c + "', mRouteLength=" + this.d + ", isHighWay=" + this.e + ", mPoint=" + this.f + ", mStartPoint=" + this.g + ", mEndPoint=" + this.h + ", mIndex=" + this.i + ", isRoute=" + this.j + '}';
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull a aVar) {
        int i = this.d;
        int i2 = aVar.d;
        if (i < i2) {
            return 1;
        }
        return i > i2 ? -1 : 0;
    }
}
