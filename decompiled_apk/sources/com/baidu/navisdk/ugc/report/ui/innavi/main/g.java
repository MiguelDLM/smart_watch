package com.baidu.navisdk.ugc.report.ui.innavi.main;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.navisdk.ugc.report.ui.innavi.main.e;

/* loaded from: classes8.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private e f8294a;
    private d b;
    private ViewGroup c;
    private com.baidu.navisdk.ugc.report.data.datastatus.a d;
    private com.baidu.navisdk.ugc.report.ui.innavi.sub.c e = null;
    private e.j f;
    private int g;
    private Handler h;

    public g(d dVar, com.baidu.navisdk.ugc.report.data.datastatus.a aVar, e eVar, e.j jVar, Handler handler) {
        this.b = dVar;
        this.d = aVar;
        this.f8294a = eVar;
        this.f = jVar;
        this.h = handler;
    }

    public void a(int i) {
        this.g = i;
        this.f8294a.c(false);
        this.f.a(i);
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.d;
        if (aVar != null) {
            aVar.e = i;
            aVar.N = 1;
        }
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar2 = e.B;
        if (aVar2 != null && aVar != null) {
            aVar2.e = aVar.e;
            aVar2.N = aVar.N;
        }
        a(false);
    }

    public void a(d dVar) {
        this.b = dVar;
    }

    public void a(boolean z) {
        com.baidu.navisdk.ugc.report.ui.innavi.sub.c cVar;
        if (e.B == null) {
            e.B = new com.baidu.navisdk.ugc.report.data.datastatus.a();
        }
        com.baidu.navisdk.ugc.report.ui.innavi.sub.d dVar = new com.baidu.navisdk.ugc.report.ui.innavi.sub.d(this.b.a(), this.b.c(), 4);
        com.baidu.navisdk.ugc.report.data.datarepository.e f = com.baidu.navisdk.ugc.report.data.datarepository.c.f(this.g);
        if (z && (cVar = this.e) != null) {
            cVar.a(dVar);
        } else {
            this.e = new com.baidu.navisdk.ugc.report.ui.innavi.sub.c(this.b.a(), f, dVar, this.f8294a, this.d, this.h, 2, true, 4, null);
        }
        dVar.a((com.baidu.navisdk.ugc.report.ui.a) this.e);
        View h = dVar.h();
        ViewGroup d = this.b.d();
        this.c = d;
        if (d == null || h == null) {
            return;
        }
        d.removeAllViews();
        this.c.addView(h, new FrameLayout.LayoutParams(-1, -1));
        if (z) {
            this.e.a((Configuration) null);
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.4.2", "2", f.j() + "", null);
        this.e.z();
    }
}
