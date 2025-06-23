package com.baidu.navisdk.ui.routeguide.mapmode.iview;

import android.view.ViewGroup;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public abstract class a implements com.baidu.navisdk.module.routepreference.interfaces.a {

    /* renamed from: a, reason: collision with root package name */
    private int f8695a;
    private com.baidu.navisdk.module.routepreference.views.d b;
    private ViewGroup c;

    public a(int i) {
        this.f8695a = i;
    }

    public abstract com.baidu.navisdk.module.routepreference.views.d a(ViewGroup viewGroup, ViewGroup viewGroup2);

    @Override // com.baidu.navisdk.module.routepreference.interfaces.a
    public void a(boolean z) {
    }

    public void b(boolean z) {
        com.baidu.navisdk.module.routepreference.views.d dVar = this.b;
        if (dVar != null) {
            dVar.b(z);
        }
    }

    @Override // com.baidu.navisdk.module.routepreference.interfaces.a
    public void c() {
        com.baidu.navisdk.ui.routeguide.model.g.j = false;
    }

    public void d() {
        com.baidu.navisdk.module.routepreference.views.d dVar = this.b;
        if (dVar != null) {
            dVar.h();
            this.b = null;
        }
    }

    public void e() {
        if (this.b != null) {
            x.b().a(this.c);
        }
    }

    public int f() {
        return this.f8695a;
    }

    public void g() {
        com.baidu.navisdk.module.routepreference.views.d dVar = this.b;
        if (dVar != null) {
            dVar.q();
            com.baidu.navisdk.ui.routeguide.model.g.j = false;
        }
    }

    public boolean h() {
        com.baidu.navisdk.module.routepreference.views.d dVar = this.b;
        if (dVar != null && dVar.w()) {
            return true;
        }
        return false;
    }

    public boolean i() {
        com.baidu.navisdk.module.routepreference.views.d dVar = this.b;
        if (dVar != null && dVar.x()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.module.routepreference.interfaces.a
    public void a(boolean z, int i) {
    }

    public void a(ViewGroup viewGroup) {
        if (this.b == null && viewGroup != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.bnav_rg_route_sort_container);
            this.c = viewGroup2;
            this.b = a(viewGroup, viewGroup2);
            int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_toolbox_margin_left);
            if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().d0() == 1) {
                this.b.a(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            } else {
                this.b.a(0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            }
            this.b.i();
            x.b().a(this.c);
        }
        com.baidu.navisdk.module.routepreference.views.d dVar = this.b;
        if (dVar != null) {
            com.baidu.navisdk.ui.routeguide.model.g.j = dVar.z();
        }
    }

    @Override // com.baidu.navisdk.module.routepreference.interfaces.a
    public void b() {
        g();
    }

    @Override // com.baidu.navisdk.module.routepreference.interfaces.a
    public void a() {
        g();
    }
}
