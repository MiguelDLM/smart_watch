package com.baidu.navisdk.yellowbannerui.view.params;

import com.baidu.navisdk.yellowbannerui.config.f;
import com.baidu.navisdk.yellowtipdata.model.data.d;

/* loaded from: classes8.dex */
public class a extends com.baidu.navisdk.module.routeresult.model.a {
    private int i;
    private boolean j;
    private d k;
    private f.b l = new f.a();
    private boolean m;

    public void a(boolean z) {
    }

    public void b(int i) {
    }

    public void c(boolean z) {
        this.j = z;
    }

    public int i() {
        return this.i;
    }

    public d j() {
        return this.k;
    }

    public f.b k() {
        return this.l;
    }

    public boolean l() {
        return this.m;
    }

    public boolean m() {
        return this.j;
    }

    @Override // com.baidu.navisdk.module.routeresult.model.a
    public String toString() {
        return super.toString() + "\nRouteCarYBannerParams{routeCarYBannerModel=" + this.k + "isShowArrowBg=" + this.m + '}';
    }

    public void a(d dVar) {
        this.k = dVar;
    }

    public void b(boolean z) {
        this.m = z;
    }

    public void a(int i) {
        this.i = i;
    }
}
