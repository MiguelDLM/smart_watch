package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.ui.routeguide.ace.a;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class a extends com.baidu.navisdk.pronavi.ui.bucket.item.a {
    private static int j;

    @OOXIXo
    public static final C0337a k = new C0337a(null);
    public ViewGroup f;
    private boolean g;

    @OOXIXo
    private final com.baidu.navisdk.ui.routeguide.mapmode.subview.w h;

    @OOXIXo
    private final LifecycleOwner i;

    /* renamed from: com.baidu.navisdk.pronavi.ui.bucket.item.concrete.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0337a {
        private C0337a() {
        }

        public final int a() {
            return a.j;
        }

        public /* synthetic */ C0337a(IIXOooo iIXOooo) {
            this();
        }

        public final void a(int i) {
            a.j = i;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements Observer<com.baidu.navisdk.ui.routeguide.ace.g> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@oOoXoXO com.baidu.navisdk.ui.routeguide.ace.g gVar) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.ACE;
            if (gVar2.d()) {
                gVar2.e("BNSmartTrafficPanel", "status livedata apply " + gVar);
            }
            if (gVar != null) {
                if (gVar.a()) {
                    a.this.x();
                    return;
                }
                if (gVar.c()) {
                    a.this.B();
                    if (a.this.isVisible()) {
                        a.this.z();
                        return;
                    }
                    return;
                }
                a.this.x();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements Observer<com.baidu.navisdk.ui.routeguide.ace.d> {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@oOoXoXO com.baidu.navisdk.ui.routeguide.ace.d dVar) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ACE;
            if (gVar.d()) {
                gVar.e("BNSmartTrafficPanel", "green light livedata apply " + dVar);
            }
            a.this.a(dVar, false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext, @OOXIXo com.baidu.navisdk.pronavi.ui.bucket.config.d data, @OOXIXo LifecycleOwner owner) {
        super(uiContext, data);
        IIX0o.x0xO0oo(uiContext, "uiContext");
        IIX0o.x0xO0oo(data, "data");
        IIX0o.x0xO0oo(owner, "owner");
        this.i = owner;
        Activity e = uiContext.e();
        IIX0o.oO(e, "uiContext.activity");
        this.h = new com.baidu.navisdk.ui.routeguide.mapmode.subview.w(0, e, null, 0, 13, null);
        y();
    }

    private final void A() {
        this.f7853a.j().e("RGBucketGroupComponent").a(2010).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        if (this.g && isVisible()) {
            return;
        }
        this.g = true;
        refreshVisible();
    }

    private final void e(int i) {
        com.baidu.navisdk.ui.routeguide.ace.d dVar;
        MutableLiveData<com.baidu.navisdk.ui.routeguide.ace.d> c2;
        if (i != 2 && j == 2) {
            z();
            com.baidu.navisdk.ui.routeguide.ace.a a2 = com.baidu.navisdk.ui.routeguide.ace.a.g.a();
            if (a2 != null && (c2 = a2.c()) != null) {
                dVar = c2.getValue();
            } else {
                dVar = null;
            }
            a(dVar, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        this.g = false;
        refreshVisible();
        j = 0;
    }

    private final void y() {
        MutableLiveData<com.baidu.navisdk.ui.routeguide.ace.d> c2;
        MutableLiveData<com.baidu.navisdk.ui.routeguide.ace.g> g;
        a.C0409a c0409a = com.baidu.navisdk.ui.routeguide.ace.a.g;
        com.baidu.navisdk.ui.routeguide.ace.a a2 = c0409a.a();
        if (a2 != null && (g = a2.g()) != null) {
            g.observe(this.i, new b());
        }
        com.baidu.navisdk.ui.routeguide.ace.a a3 = c0409a.a();
        if (a3 != null && (c2 = a3.c()) != null) {
            c2.observe(this.i, new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        ViewGroup viewGroup = this.f;
        if (viewGroup == null) {
            IIX0o.XOxIOxOx("mContainerView");
        }
        if (viewGroup.getChildCount() > 0) {
            ViewGroup viewGroup2 = this.f;
            if (viewGroup2 == null) {
                IIX0o.XOxIOxOx("mContainerView");
            }
            viewGroup2.removeAllViews();
        }
        ViewGroup viewGroup3 = this.f;
        if (viewGroup3 == null) {
            IIX0o.XOxIOxOx("mContainerView");
        }
        viewGroup3.addView(this.h);
        j = 2;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        super.onVisibleChange(i);
        if (i == 0) {
            A();
            j = 2;
        } else {
            j = 0;
        }
    }

    public final void v() {
    }

    public final void b(boolean z) {
        if (z) {
            B();
        } else {
            x();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (!this.g) {
            return 8;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a o5 = com.baidu.navisdk.ui.routeguide.mapmode.a.o5();
        IIX0o.oO(o5, "RGMapModeViewController.getInstance()");
        if (o5.m0() == null) {
            return 0;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a o52 = com.baidu.navisdk.ui.routeguide.mapmode.a.o5();
        IIX0o.oO(o52, "RGMapModeViewController.getInstance()");
        com.baidu.navisdk.ui.routeguide.mapmode.presenter.f m0 = o52.m0();
        IIX0o.oO(m0, "RGMapModeViewController.…e().serviceAreaController");
        if (!m0.f()) {
            return 0;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ACE;
        if (gVar.d()) {
            gVar.e("BNSmartTrafficPanel", "highway panel showing");
        }
        return 8;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    @OOXIXo
    public View a(@OOXIXo ViewGroup parentView, int i, @OOXIXo Context context) {
        IIX0o.x0xO0oo(parentView, "parentView");
        IIX0o.x0xO0oo(context, "context");
        this.f = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        ViewGroup viewGroup = this.f;
        if (viewGroup == null) {
            IIX0o.XOxIOxOx("mContainerView");
        }
        viewGroup.setLayoutParams(layoutParams);
        e(i);
        ViewGroup viewGroup2 = this.f;
        if (viewGroup2 == null) {
            IIX0o.XOxIOxOx("mContainerView");
        }
        return viewGroup2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(com.baidu.navisdk.ui.routeguide.ace.d dVar, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNSmartTrafficPanel", "onACELightChange: " + dVar + ',' + z);
        }
        if (dVar == null) {
            x();
            return;
        }
        com.baidu.navisdk.module.ace.c b2 = dVar.b();
        if (b2 != null) {
            int i = com.baidu.navisdk.pronavi.ui.bucket.item.concrete.b.f7859a[b2.ordinal()];
            if (i == 1) {
                B();
                this.h.b(dVar.a(), false);
                return;
            }
            if (i == 2) {
                B();
                this.h.b(dVar.a(), !z);
                return;
            } else if (i == 3) {
                B();
                this.h.a(dVar.a(), false);
                return;
            } else if (i == 4) {
                B();
                this.h.a(dVar.a(), !z);
                return;
            }
        }
        if (gVar.d()) {
            gVar.e("BNSmartTrafficPanel", "onACELightChange else: ");
        }
        x();
    }
}
