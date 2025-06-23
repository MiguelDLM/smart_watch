package com.baidu.navisdk.util.common;

import androidx.core.util.Pair;
import com.baidu.navisdk.model.datastruct.RoutePlanTime;
import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes8.dex */
public class g0 {
    private static g0 e;
    private Pair<RoutePlanTime, RoutePlanTime> c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f9228a = false;
    private RoutePlanTime b = new RoutePlanTime(0, 0, true);
    private Calendar d = Calendar.getInstance(TimeZone.getDefault());

    private g0() {
    }

    public static g0 g() {
        if (e == null) {
            e = new g0();
        }
        return e;
    }

    public int a() {
        return this.d.get(11);
    }

    public int b() {
        return this.d.get(12);
    }

    public RoutePlanTime c() {
        if (!this.f9228a) {
            f();
        }
        return this.b;
    }

    public Pair<RoutePlanTime, RoutePlanTime> d() {
        if (!this.f9228a) {
            f();
        }
        return this.c;
    }

    public boolean e() {
        return this.f9228a;
    }

    public void f() {
        this.f9228a = false;
        this.b.setHour(a());
        this.b.setMinute(b());
        this.c = null;
    }

    public void a(RoutePlanTime routePlanTime, Pair<RoutePlanTime, RoutePlanTime> pair) {
        if (routePlanTime == null) {
            f();
            return;
        }
        this.f9228a = true;
        this.b = routePlanTime.m82clone();
        if (pair == null) {
            this.c = null;
            return;
        }
        RoutePlanTime routePlanTime2 = pair.first;
        RoutePlanTime m82clone = routePlanTime2 != null ? routePlanTime2.m82clone() : null;
        RoutePlanTime routePlanTime3 = pair.second;
        this.c = new Pair<>(m82clone, routePlanTime3 != null ? routePlanTime3.m82clone() : null);
    }

    public void a(boolean z) {
        this.b.setValid(z);
    }
}
