package com.baidu.navisdk.ui.routeguide.ar;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.ar.d;
import java.lang.ref.WeakReference;
import kotlin.Pair;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes8.dex */
public final class g implements com.baidu.navisdk.framework.interfaces.pronavi.multinavi.d {

    /* renamed from: a, reason: collision with root package name */
    private int f8463a;
    private ViewGroup b;
    private View c;
    private ViewGroup d;
    private int e;
    private int f;
    private boolean g;
    private com.baidu.navisdk.ui.routeguide.ar.d h;
    private WeakReference<com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a> i;
    private View j;
    private final X0IIOO k;
    private int l;
    private int m;

    @oOoXoXO
    private b n;

    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements oIX0oI<a> {

        /* loaded from: classes8.dex */
        public static final class a implements d.b {
            public a() {
            }

            @Override // com.baidu.navisdk.ui.routeguide.ar.d.b
            public void a(int i) {
                com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a aVar;
                WeakReference weakReference = g.this.i;
                if (weakReference == null || (aVar = (com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a) weakReference.get()) == null) {
                    return;
                }
                aVar.c(i);
            }

            @Override // com.baidu.navisdk.ui.routeguide.ar.d.b
            public void b() {
                com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a aVar;
                WeakReference weakReference = g.this.i;
                if (weakReference != null && (aVar = (com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a) weakReference.get()) != null) {
                    aVar.l();
                }
            }

            @Override // com.baidu.navisdk.ui.routeguide.ar.d.b
            public void c() {
                g.this.d();
            }

            @Override // com.baidu.navisdk.ui.routeguide.ar.d.b
            public void a() {
                g.this.d();
            }
        }

        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final a invoke() {
            return new a();
        }
    }

    /* loaded from: classes8.dex */
    public static final class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent event) {
            b a2;
            IIX0o.oO(event, "event");
            if (event.getActionMasked() == 0 && (a2 = g.this.a()) != null) {
                a2.a();
                return true;
            }
            return true;
        }
    }

    static {
        new a(null);
    }

    public g(int i, int i2, @oOoXoXO b bVar) {
        this.l = i;
        this.m = i2;
        this.n = bVar;
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        this.e = aVar.b();
        this.f = aVar.a();
        this.g = true;
        this.k = XIxXXX0x0.oIX0oI(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a aVar;
        com.baidu.navisdk.ui.routeguide.ar.d dVar = this.h;
        if (dVar != null) {
            dVar.b();
        }
        this.h = null;
        View view = this.j;
        if (view != null) {
            view.setVisibility(0);
        }
        WeakReference<com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a> weakReference = this.i;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            aVar.e(BNSettingManager.getArNavState());
        }
    }

    private final d.b e() {
        return (d.b) this.k.getValue();
    }

    public void c() {
        int i;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArView", "onSizeChange");
        }
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        this.e = aVar.b();
        this.f = aVar.a();
        boolean z = this.g;
        if (z) {
            i = this.l;
        } else {
            i = this.m;
        }
        a(z, i, this.f8463a);
        com.baidu.navisdk.ui.routeguide.ar.d dVar = this.h;
        if (dVar != null) {
            dVar.a(this.e, this.f);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void f(int i, int i2, boolean z, @OOXIXo com.baidu.navisdk.framework.interfaces.pronavi.hd.f params) {
        IIX0o.x0xO0oo(params, "params");
        a(z, i2, 0);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.a
    public void onHdStateSwitch(int i, int i2, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArView", "onHdStateSwitch: " + i + org.apache.commons.text.oIX0oI.f33048oxoX + i2 + ", " + z);
        }
        this.f8463a = i2;
    }

    private final Pair<Integer, Integer> b(boolean z, int i) {
        int i2;
        int i3 = -1;
        if (z) {
            if (i != 0) {
                if (i == 2) {
                    i2 = this.f - this.l;
                }
                i2 = -1;
            }
            i3 = 0;
            i2 = 0;
        } else {
            if (i != 0) {
                if (i == 2) {
                    i3 = this.f - this.m;
                }
                i2 = -1;
            }
            i3 = 0;
            i2 = 0;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArView", "ar surfaceView width = " + i3 + " + height = " + i2);
        }
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i2));
    }

    @oOoXoXO
    public final b a() {
        return this.n;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void e(int i, int i2, boolean z, @OOXIXo com.baidu.navisdk.framework.interfaces.pronavi.hd.f params) {
        IIX0o.x0xO0oo(params, "params");
        a(z, i2, 2);
    }

    public void a(@OOXIXo Context context, @oOoXoXO ViewGroup viewGroup, @oOoXoXO View view, int i, boolean z, @oOoXoXO View view2, @OOXIXo com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a arNaviController) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(arNaviController, "arNaviController");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArView", "onCreate" + i + ", " + z);
        }
        this.b = viewGroup;
        this.c = view;
        this.f8463a = i;
        this.g = z;
        this.j = view2;
        this.i = new WeakReference<>(arNaviController);
        if (viewGroup != null && view != null) {
            if (view.getParent() != null) {
                ViewParent parent = view.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(view);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
            }
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.bnav_ar_container);
            this.d = viewGroup2;
            if (viewGroup2 != null) {
                viewGroup2.addView(view, a(z, i));
            }
            ViewGroup viewGroup3 = this.d;
            if (viewGroup3 != null) {
                viewGroup3.setOnTouchListener(new d());
            }
            a(context, z, this.d);
            return;
        }
        if (gVar.c()) {
            gVar.c("RGArView", "onCreate parentViewGroup == null || arSurfaceView == null");
            if (gVar.d()) {
                gVar.a("RGArView", new Throwable("onCreate parentViewGroup == null || arSurfaceView == null"));
            }
        }
    }

    public void b() {
        ViewGroup viewGroup;
        this.i = null;
        com.baidu.navisdk.ui.routeguide.ar.d dVar = this.h;
        if (dVar != null) {
            dVar.b();
        }
        this.h = null;
        View view = this.j;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.c;
        if (view2 != null && (viewGroup = this.d) != null) {
            viewGroup.removeView(view2);
        }
        ViewGroup viewGroup2 = this.d;
        if (viewGroup2 != null) {
            viewGroup2.setOnTouchListener(null);
        }
        this.f8463a = 0;
        this.d = null;
        this.c = null;
        this.n = null;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void b(int i, int i2, boolean z, @OOXIXo com.baidu.navisdk.framework.interfaces.pronavi.hd.f params) {
        IIX0o.x0xO0oo(params, "params");
        a(z, i2, 3);
    }

    private final void a(Context context, boolean z, ViewGroup viewGroup) {
        if (this.h == null) {
            this.h = new com.baidu.navisdk.ui.routeguide.ar.d(this.e, this.f);
        }
        int i = this.g ? 1 : 2;
        com.baidu.navisdk.ui.routeguide.ar.d dVar = this.h;
        IIX0o.ooOOo0oXI(dVar);
        View a2 = dVar.a(context, viewGroup, i, e());
        if (a2 == null || viewGroup == null) {
            return;
        }
        viewGroup.addView(a2);
        View view = this.j;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private final ViewGroup.LayoutParams a(boolean z, int i) {
        Pair<Integer, Integer> b2 = b(z, i);
        return new ViewGroup.LayoutParams(b2.getFirst().intValue(), b2.getSecond().intValue());
    }

    private final void a(boolean z, int i, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArView", "changeSurfaceViewSize:" + z + ", " + i);
        }
        View view = this.c;
        if (view == null) {
            return;
        }
        IIX0o.ooOOo0oXI(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            Pair<Integer, Integer> b2 = b(z, i2);
            if (layoutParams.width == b2.getFirst().intValue() && layoutParams.height == b2.getSecond().intValue()) {
                return;
            }
            layoutParams.width = b2.getFirst().intValue();
            layoutParams.height = b2.getSecond().intValue();
            View view2 = this.c;
            IIX0o.ooOOo0oXI(view2);
            view2.requestLayout();
        }
    }

    public void a(int i, @oOoXoXO ViewGroup viewGroup, @oOoXoXO View view) {
        boolean z = i != 2;
        this.g = z;
        a(z, z ? this.l : this.m, this.f8463a);
        com.baidu.navisdk.ui.routeguide.ar.d dVar = this.h;
        if (dVar != null) {
            dVar.a(viewGroup, i);
            if (dVar.a()) {
                this.j = view;
                if (view != null) {
                    view.setVisibility(8);
                }
            }
        }
    }
}
