package com.baidu.navisdk.ui.routeguide.mapmode.presenter;

import android.graphics.Rect;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.n;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.ui.routeguide.mapmode.iview.f f8704a;

    public f(com.baidu.navisdk.ui.routeguide.mapmode.iview.f fVar) {
        this.f8704a = fVar;
    }

    private n l() {
        return com.baidu.navisdk.ui.routeguide.b.V().i().c();
    }

    private boolean m() {
        n l = l();
        if (l == null) {
            return false;
        }
        List<com.baidu.navisdk.module.pronavi.model.d> h = l.h();
        if (h.isEmpty()) {
            return false;
        }
        if (!a0.I().u() && h.get(0).k() > 2000) {
            return false;
        }
        return true;
    }

    private boolean n() {
        if (this.f8704a == null || !com.baidu.navisdk.module.newguide.a.e().d()) {
            return true;
        }
        return !com.baidu.navisdk.ui.routeguide.utils.b.x();
    }

    public void a() {
        this.f8704a.P();
    }

    public int b() {
        return this.f8704a.A();
    }

    public Rect c() {
        return this.f8704a.L();
    }

    public void d() {
        com.baidu.navisdk.ui.routeguide.mapmode.iview.f fVar = this.f8704a;
        if (fVar != null) {
            fVar.x();
        }
    }

    public boolean e() {
        com.baidu.navisdk.module.pronavi.model.d j;
        n l = l();
        if (l == null || (j = l.j()) == null || j.k() > 2000) {
            return false;
        }
        return true;
    }

    public boolean f() {
        return this.f8704a.a();
    }

    public void g() {
        this.f8704a.onResume();
    }

    public void h() {
        this.f8704a.h();
    }

    public void i() {
        com.baidu.navisdk.ui.routeguide.mapmode.iview.f fVar = this.f8704a;
        if (fVar != null) {
            fVar.Q();
        }
    }

    public void j() {
        this.f8704a.v();
    }

    public void k() {
        if (!this.f8704a.a()) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("ServiceAreaPresenter", "updateDataForView-> isVisibility = false, return");
                return;
            }
            return;
        }
        n l = l();
        if (l != null && l.s()) {
            g gVar2 = g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("ServiceAreaPresenter", "updateDataForView-> isDirectionBoardCanShow= " + Boolean.valueOf(l.q()) + ", isHighwayExitCanShow= " + e() + ", isServiceAreaCanShow= " + m());
            }
            ArrayList arrayList = new ArrayList();
            List<com.baidu.navisdk.module.pronavi.model.d> h = l.h();
            boolean n = n();
            if (n && l.q() && l.e() != null) {
                com.baidu.navisdk.module.pronavi.model.d e = l.e();
                arrayList.add(e);
                if (m() && !h.isEmpty()) {
                    com.baidu.navisdk.module.pronavi.model.d dVar = h.get(0);
                    if (gVar2.d()) {
                        gVar2.e("ServiceAreaPresenter", "updateDataForView-> 有方向看板，nextServiceAreaBean： " + dVar.k() + "，directionData： " + e.k());
                    }
                    if (dVar.k() < e.k()) {
                        arrayList.add(0, dVar);
                    } else {
                        arrayList.add(dVar);
                    }
                }
            } else if (n && e()) {
                com.baidu.navisdk.module.pronavi.model.d j = l.j();
                arrayList.add(j);
                if (m()) {
                    com.baidu.navisdk.module.pronavi.model.d dVar2 = h.get(0);
                    if (gVar2.d()) {
                        gVar2.e("ServiceAreaPresenter", "updateDataForView-> 有出口，nextServiceAreaBean： " + dVar2.k() + "，nextExit： " + j.k());
                    }
                    if (dVar2.k() <= 2000 && dVar2.k() < j.k()) {
                        arrayList.add(0, dVar2);
                    } else {
                        arrayList.add(dVar2);
                    }
                }
            } else if (m()) {
                arrayList.addAll(h);
            }
            this.f8704a.a(arrayList);
            this.f8704a.a0();
            return;
        }
        g gVar3 = g.PRO_NAV;
        if (gVar3.d()) {
            gVar3.e("ServiceAreaPresenter", "updateDataForView-> isServiceAreaCanShow = false, return, getModel():" + l);
        }
        if (this.f8704a.a()) {
            this.f8704a.c();
        }
    }

    public void a(com.baidu.navisdk.module.pronavi.model.d dVar) {
        this.f8704a.a(dVar);
    }
}
