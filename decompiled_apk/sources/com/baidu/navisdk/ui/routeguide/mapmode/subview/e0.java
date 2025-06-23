package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.mapmode.a;
import com.baidu.navisdk.ui.widget.routesearchfilterview.BNRouteNearbySearchCallback;
import com.baidu.navisdk.ui.widget.routesearchfilterview.BNRouteNearbySearchFilterView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes8.dex */
public class e0 extends com.baidu.navisdk.ui.routeguide.widget.d implements com.baidu.navisdk.framework.interfaces.pronavi.hd.c {
    private String i;
    private ViewGroup j;
    private FrameLayout k;
    private boolean l;
    private BNRouteNearbySearchFilterView m;
    private a.q0 n;

    /* loaded from: classes8.dex */
    public class a implements a.q0 {
        public a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.a.q0
        public void a() {
            com.baidu.navisdk.ui.routeguide.control.x.b().d(e0.this.j);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements BNRouteNearbySearchCallback {
        public b() {
        }

        @Override // com.baidu.navisdk.ui.widget.routesearchfilterview.BNRouteNearbySearchCallback
        public void clickCallback(HashMap<String, ArrayList<String>> hashMap) {
            com.baidu.navisdk.asr.d.B().v();
            com.baidu.navisdk.asr.d.B().c();
            ((com.baidu.navisdk.ui.routeguide.widget.d) e0.this).c.a(9, 0, 0, hashMap);
        }
    }

    public e0(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar, String str) {
        super(context, viewGroup, aVar);
        this.i = str;
        n0();
        a(com.baidu.navisdk.ui.util.b.b());
    }

    private void n0() {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) ((ViewStub) viewGroup.findViewById(R.id.bnav_rg_nearby_search_stub)).inflate();
        this.j = viewGroup2;
        this.k = (FrameLayout) viewGroup2.findViewById(R.id.bnav_rg_nearby_search_filter_container);
        this.n = new a();
        com.baidu.navisdk.ui.routeguide.control.x.b().a(this.n);
        o0();
        com.baidu.navisdk.ui.routeguide.control.x.b().d(this.j);
    }

    private void o0() {
        if (this.f9165a != null && this.b != null && this.j != null && this.k != null) {
            if (1 == com.baidu.navisdk.ui.routeguide.control.x.b().d0()) {
                this.f = 1;
            } else {
                this.f = 2;
            }
            BNRouteNearbySearchFilterView bNRouteNearbySearchFilterView = this.m;
            if (bNRouteNearbySearchFilterView == null) {
                this.m = new BNRouteNearbySearchFilterView(this.f9165a, this.i, this.f, new b(), true);
            } else {
                bNRouteNearbySearchFilterView.setCategoryName(this.i, this.f);
            }
            View mainView = this.m.getMainView();
            FrameLayout frameLayout = this.k;
            if (frameLayout != null && mainView != null) {
                frameLayout.removeAllViews();
                if (mainView.getParent() != null) {
                    ((ViewGroup) mainView.getParent()).removeAllViews();
                }
                this.k.addView(mainView, new ViewGroup.LayoutParams(-2, -2));
            }
        }
    }

    private boolean z(boolean z) {
        BNRouteNearbySearchFilterView bNRouteNearbySearchFilterView = this.m;
        if (bNRouteNearbySearchFilterView != null && bNRouteNearbySearchFilterView.getMainView() != null) {
            return this.m.getIsTrueCurDay(z);
        }
        return false;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d, com.baidu.navisdk.framework.interfaces.y
    public View[] B() {
        BNRouteNearbySearchFilterView bNRouteNearbySearchFilterView = this.m;
        if (bNRouteNearbySearchFilterView != null && bNRouteNearbySearchFilterView.getMainView() != null && this.m.getMainView().isShown()) {
            return new View[]{this.m.getMainView()};
        }
        return null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        ViewGroup viewGroup = this.j;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            this.l = false;
        }
        super.c();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> d(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        ViewGroup viewGroup;
        if (!z || (viewGroup = this.j) == null || viewGroup.getVisibility() != 0) {
            return null;
        }
        Animator a2 = com.baidu.navisdk.pronavi.hd.d.f7723a.a(this.j, com.baidu.navisdk.ui.routeguide.utils.b.c());
        if (a2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(a2);
        return arrayList;
    }

    public void f(String str) {
        this.i = str;
        if (this.b != null && this.j != null) {
            o0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        ViewGroup viewGroup = this.j;
        if (viewGroup != null && this.k != null) {
            viewGroup.setVisibility(0);
            this.k.setVisibility(0);
            this.l = true;
            if (j0() && com.baidu.navisdk.module.newguide.a.e().d()) {
                com.baidu.navisdk.framework.interfaces.pronavi.hd.f o = com.baidu.navisdk.ui.routeguide.utils.b.o();
                com.baidu.navisdk.pronavi.hd.d.f7723a.a(this.j, !o.b() || o.g(true), com.baidu.navisdk.ui.routeguide.utils.b.a(true, (com.baidu.navisdk.framework.interfaces.pronavi.hd.f) null), com.baidu.navisdk.ui.routeguide.mapmode.a.o5().N());
            }
        }
        super.y();
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        n0();
        a(com.baidu.navisdk.ui.util.b.b());
        if (this.l) {
            y();
        } else {
            c();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> c(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        ViewGroup viewGroup;
        if (!z || (viewGroup = this.j) == null || viewGroup.getVisibility() != 0) {
            return null;
        }
        Animator a2 = com.baidu.navisdk.pronavi.hd.d.f7723a.a(this.j, com.baidu.navisdk.ui.routeguide.utils.b.c());
        if (a2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(a2);
        return arrayList;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        if (z(z)) {
            return;
        }
        super.a(z);
        BNRouteNearbySearchFilterView bNRouteNearbySearchFilterView = this.m;
        if (bNRouteNearbySearchFilterView == null || bNRouteNearbySearchFilterView.getMainView() == null) {
            return;
        }
        this.m.updateStyle();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> a(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        ViewGroup viewGroup;
        if (!z || (viewGroup = this.j) == null || viewGroup.getVisibility() != 0) {
            return null;
        }
        if (fVar.g(true)) {
            i2 += com.baidu.navisdk.ui.routeguide.utils.b.p();
        }
        Animator a2 = com.baidu.navisdk.pronavi.hd.d.f7723a.a(this.j, i2);
        if (a2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(a2);
        return arrayList;
    }

    public void y(boolean z) {
        BNRouteNearbySearchFilterView bNRouteNearbySearchFilterView = this.m;
        if (bNRouteNearbySearchFilterView == null) {
            return;
        }
        bNRouteNearbySearchFilterView.setEnabled(z);
    }
}
