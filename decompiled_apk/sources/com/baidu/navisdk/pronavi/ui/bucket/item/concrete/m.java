package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.ui.routeguide.ace.a;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMACEGreenLightSpeedView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMACESpeedView;
import com.baidu.navisdk.ui.routeguide.model.b0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class m extends com.baidu.navisdk.pronavi.ui.bucket.item.a {
    private static int n;

    @OOXIXo
    public static final d o = new d(null);
    public ViewGroup f;

    @OOXIXo
    private RGMMACESpeedView g;

    @OOXIXo
    private RGMMACEGreenLightSpeedView h;
    private boolean i;
    private int j;
    private int k;

    @OOXIXo
    private MutableLiveData<b0> l;

    @OOXIXo
    private final LifecycleOwner m;

    /* loaded from: classes7.dex */
    public static final class a implements Observer<com.baidu.navisdk.ui.routeguide.ace.g> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@oOoXoXO com.baidu.navisdk.ui.routeguide.ace.g gVar) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.ACE;
            if (gVar2.d()) {
                gVar2.e("RGGreenLightSpeedView", "status livedata apply " + gVar);
            }
            if (gVar == null) {
                return;
            }
            if (gVar.a()) {
                m.this.a(false, 0);
                return;
            }
            if (!gVar.b() && !gVar.c()) {
                m.this.a(false, 0);
            } else if (gVar.b()) {
                m.this.a(true, 1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements Observer<com.baidu.navisdk.ui.routeguide.ace.f> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@oOoXoXO com.baidu.navisdk.ui.routeguide.ace.f fVar) {
            MutableLiveData<com.baidu.navisdk.ui.routeguide.ace.g> g;
            com.baidu.navisdk.ui.routeguide.ace.g value;
            Integer num;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ACE;
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("speed livedata apply ");
                Integer num2 = null;
                if (fVar != null) {
                    num = Integer.valueOf(fVar.b());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(" + ");
                if (fVar != null) {
                    num2 = Integer.valueOf(fVar.a());
                }
                sb.append(num2);
                gVar.e("RGGreenLightSpeedView", sb.toString());
            }
            if (fVar == null) {
                return;
            }
            m.this.e(fVar.b());
            m.this.d(fVar.a());
            com.baidu.navisdk.ui.routeguide.ace.a a2 = com.baidu.navisdk.ui.routeguide.ace.a.g.a();
            if (a2 != null && (g = a2.g()) != null && (value = g.getValue()) != null && value.a()) {
                return;
            }
            m.this.a(true, 2);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements Observer<b0> {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@oOoXoXO b0 b0Var) {
            if (b0Var == null) {
                return;
            }
            if (b0Var.b()) {
                m.this.b(true);
                if (m.this.isVisible()) {
                    if (b0Var.a() == 2) {
                        m.this.B();
                        if (m.this.x() != 0 && m.this.w() != 0) {
                            m.this.v().a(m.this.x(), m.this.w());
                            return;
                        }
                        return;
                    }
                    if (b0Var.a() == 1) {
                        m.this.C();
                        return;
                    }
                    return;
                }
                return;
            }
            m.o.a(0);
            m.this.b(false);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d {
        private d() {
        }

        public final int a() {
            return m.n;
        }

        public /* synthetic */ d(IIXOooo iIXOooo) {
            this();
        }

        public final void a(int i) {
            m.n = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext, @OOXIXo com.baidu.navisdk.pronavi.ui.bucket.config.d data, @OOXIXo LifecycleOwner owner) {
        super(uiContext, data);
        MutableLiveData<com.baidu.navisdk.ui.routeguide.ace.f> f;
        MutableLiveData<com.baidu.navisdk.ui.routeguide.ace.g> g;
        IIX0o.x0xO0oo(uiContext, "uiContext");
        IIX0o.x0xO0oo(data, "data");
        IIX0o.x0xO0oo(owner, "owner");
        this.m = owner;
        Context a2 = uiContext.a();
        IIX0o.oO(a2, "uiContext.applicationContext");
        this.g = new RGMMACESpeedView(a2, null, 0, 6, null);
        Context a3 = uiContext.a();
        IIX0o.oO(a3, "uiContext.applicationContext");
        this.h = new RGMMACEGreenLightSpeedView(a3, null, 0, 6, null);
        this.l = new MutableLiveData<>();
        a.C0409a c0409a = com.baidu.navisdk.ui.routeguide.ace.a.g;
        com.baidu.navisdk.ui.routeguide.ace.a a4 = c0409a.a();
        if (a4 != null && (g = a4.g()) != null) {
            g.observe(owner, new a());
        }
        com.baidu.navisdk.ui.routeguide.ace.a a5 = c0409a.a();
        if (a5 != null && (f = a5.f()) != null) {
            f.observe(owner, new b());
        }
        this.l.observe(owner, new c());
    }

    private final void A() {
        com.baidu.navisdk.module.pronavi.model.g o2 = com.baidu.navisdk.module.pronavi.model.g.o();
        IIX0o.oO(o2, "RGAssistGuideModel.getInstance()");
        o2.a(false);
        this.f7853a.j().e("RGBucketGroupComponent").a(1017).a((Object) 2).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
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
        ViewGroup viewGroup4 = this.f;
        if (viewGroup4 == null) {
            IIX0o.XOxIOxOx("mContainerView");
        }
        if (viewGroup4.getVisibility() != 0) {
            ViewGroup viewGroup5 = this.f;
            if (viewGroup5 == null) {
                IIX0o.XOxIOxOx("mContainerView");
            }
            viewGroup5.setVisibility(0);
        }
        n = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
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
        viewGroup3.addView(this.g);
        ViewGroup viewGroup4 = this.f;
        if (viewGroup4 == null) {
            IIX0o.XOxIOxOx("mContainerView");
        }
        if (viewGroup4.getVisibility() != 0) {
            ViewGroup viewGroup5 = this.f;
            if (viewGroup5 == null) {
                IIX0o.XOxIOxOx("mContainerView");
            }
            viewGroup5.setVisibility(0);
        }
        n = 1;
    }

    private final void D() {
        com.baidu.navisdk.pronavi.ui.base.b uiContext = this.f7853a;
        IIX0o.oO(uiContext, "uiContext");
        if (!uiContext.M()) {
            com.baidu.navisdk.module.pronavi.model.g o2 = com.baidu.navisdk.module.pronavi.model.g.o();
            IIX0o.oO(o2, "RGAssistGuideModel.getInstance()");
            o2.a(true);
        }
        this.f7853a.j().e("RGBucketGroupComponent").a(1017).a((Object) 2).a();
    }

    private final void E() {
        this.f7853a.j().e("RGBucketGroupComponent").a(1018).a();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        com.baidu.navisdk.framework.interfaces.pronavi.h hVar;
        if (com.baidu.navisdk.module.pronavi.model.g.o().g()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ACE;
            if (gVar.d()) {
                gVar.e("RGGreenLightSpeedView", "visibility: hasIntervalCamera");
            }
            return 8;
        }
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V, "BNavigator.getInstance()");
        com.baidu.navisdk.ui.routeguide.navicenter.c j = V.j();
        if (j != null) {
            hVar = j.e();
        } else {
            hVar = null;
        }
        if (hVar != null && ((com.baidu.navisdk.ui.routeguide.control.j) hVar).c() == 227) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.ACE;
            if (gVar2.d()) {
                gVar2.e("RGGreenLightSpeedView", "visibility: has speedlogo");
            }
            return 8;
        }
        if (!this.i) {
            return 8;
        }
        return 0;
    }

    public final void d(int i) {
        this.k = i;
    }

    public final void e(int i) {
        this.j = i;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        super.onVisibleChange(i);
        if (i == 0) {
            A();
            E();
        } else {
            D();
        }
    }

    @OOXIXo
    public final RGMMACEGreenLightSpeedView v() {
        return this.h;
    }

    public final int w() {
        return this.k;
    }

    public final int x() {
        return this.j;
    }

    public final void y() {
        if (!isVisible()) {
            return;
        }
        com.baidu.navisdk.module.pronavi.model.g o2 = com.baidu.navisdk.module.pronavi.model.g.o();
        IIX0o.oO(o2, "RGAssistGuideModel.getInstance()");
        String speed = o2.b();
        int i = com.baidu.navisdk.module.pronavi.model.g.o().k;
        int i2 = n;
        if (i2 != 1) {
            if (i2 == 2) {
                RGMMACEGreenLightSpeedView rGMMACEGreenLightSpeedView = this.h;
                IIX0o.oO(speed, "speed");
                rGMMACEGreenLightSpeedView.a(speed, this.j, this.k, i);
                return;
            }
            return;
        }
        RGMMACESpeedView rGMMACESpeedView = this.g;
        IIX0o.oO(speed, "speed");
        rGMMACESpeedView.a(speed, i);
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
        ViewGroup viewGroup2 = this.f;
        if (viewGroup2 == null) {
            IIX0o.XOxIOxOx("mContainerView");
        }
        return viewGroup2;
    }

    public final void b(boolean z) {
        this.i = z;
        if (z && isVisible()) {
            return;
        }
        refreshVisible();
    }

    public final void a(boolean z, int i) {
        this.l.setValue(new b0(z, i));
    }
}
