package com.baidu.navisdk.naviresult;

import android.os.SystemClock;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.g;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class b {
    private static final String k = "b";

    /* renamed from: a, reason: collision with root package name */
    private int f7626a = 0;
    private boolean b = false;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    private boolean f = false;
    private long g = -1;
    private int h = 0;
    private long i = 0;
    private RoutePlanNode j = null;

    public b a(long j) {
        return this;
    }

    public b b(boolean z) {
        this.b = z;
        return this;
    }

    public b c(int i) {
        return this;
    }

    public long d() {
        return this.g;
    }

    public RoutePlanNode e() {
        return this.j;
    }

    public int f() {
        return this.h;
    }

    public int g() {
        return this.c;
    }

    public b h() {
        this.d++;
        return this;
    }

    public b i() {
        g gVar;
        if (com.baidu.navisdk.util.logic.g.j().h()) {
            gVar = com.baidu.navisdk.util.logic.g.j().a();
        } else {
            gVar = null;
        }
        if (BNRoutePlaner.getInstance().a(gVar, true) > 100 && BNRoutePlaner.getInstance().a(gVar, false) > 100) {
            this.c++;
        }
        return this;
    }

    public boolean j() {
        return this.b;
    }

    public void k() {
        this.i = SystemClock.elapsedRealtime();
        String str = k;
        LogUtil.e(str, "quitNaviGuide: exitNaviTimeMillies --> " + this.i);
        long j = this.g;
        if (j > 0 && this.f) {
            long j2 = this.i;
            if (j2 < j) {
                this.h = (int) (((j - j2) / 1000) / 60);
                LogUtil.e(str, "quitNaviGuide: savedTimeMins --> " + this.h);
            }
        }
        this.h = 0;
        LogUtil.e(str, "quitNaviGuide: savedTimeMins --> " + this.h);
    }

    public b a(boolean z) {
        return this;
    }

    public int b() {
        return this.d;
    }

    public b c(boolean z) {
        return this;
    }

    public int a() {
        return this.f7626a;
    }

    public b b(int i) {
        this.e = i;
        return this;
    }

    public int c() {
        return this.e;
    }

    public b a(int i) {
        this.f7626a = i;
        return this;
    }

    public b a(boolean z, long j, long j2) {
        if (this.g >= 0) {
            LogUtil.e(k, "setNormalRemainTimeMillies: normalArriveTimeMillies already set --> " + this.g);
            return this;
        }
        LogUtil.e(k, "setNormalRemainTimeMillies: isMyLoc --> " + z + ", currentRemainTimeMillies: " + j + ", normalRemainTimeMillies: " + j2);
        if (z && j < j2) {
            this.g = SystemClock.elapsedRealtime() + j2;
        } else {
            this.g = 0L;
        }
        return this;
    }

    public void a(RoutePlanNode routePlanNode) {
        this.j = routePlanNode;
    }
}
