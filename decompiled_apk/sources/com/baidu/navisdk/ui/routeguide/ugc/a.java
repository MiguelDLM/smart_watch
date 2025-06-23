package com.baidu.navisdk.ui.routeguide.ugc;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.animation.Animator;
import android.content.Context;
import android.util.Pair;
import android.view.ViewGroup;
import com.baidu.navisdk.framework.interfaces.pronavi.hd.f;
import com.baidu.navisdk.ugc.a;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.common.g;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class a extends com.baidu.navisdk.ugc.external.c implements com.baidu.navisdk.framework.interfaces.pronavi.hd.c {

    /* renamed from: com.baidu.navisdk.ui.routeguide.ugc.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0485a {
        private C0485a() {
        }

        public /* synthetic */ C0485a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new C0485a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@OOXIXo Context c, @OOXIXo ViewGroup p, @OOXIXo a.b externalCallback) {
        super(c, p, externalCallback);
        IIX0o.x0xO0oo(c, "c");
        IIX0o.x0xO0oo(p, "p");
        IIX0o.x0xO0oo(externalCallback, "externalCallback");
    }

    private final void j() {
        ViewGroup mDetailParentView = this.e;
        if (mDetailParentView == null) {
            return;
        }
        IIX0o.oO(mDetailParentView, "mDetailParentView");
        ViewGroup.LayoutParams layoutParams = mDetailParentView.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            f o = com.baidu.navisdk.ui.routeguide.utils.b.o();
            IIX0o.oO(o, "BNProNaviInnerUtil.getMultiMapNaviSwitchParams()");
            Pair<Integer, Integer> a2 = a(o.f6817a, o);
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGUgcDetailView", "initLandPanelLocation: " + a2);
            }
            Integer num = (Integer) a2.first;
            int i = marginLayoutParams.leftMargin;
            if (num != null && num.intValue() == i) {
                Integer num2 = (Integer) a2.second;
                int i2 = marginLayoutParams.rightMargin;
                if (num2 != null && num2.intValue() == i2) {
                    return;
                }
            }
            Object obj = a2.first;
            IIX0o.oO(obj, "pair.first");
            marginLayoutParams.leftMargin = ((Number) obj).intValue();
            Object obj2 = a2.second;
            IIX0o.oO(obj2, "pair.second");
            marginLayoutParams.rightMargin = ((Number) obj2).intValue();
            this.e.requestLayout();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    @oOoXoXO
    public List<Animator> a(int i, int i2, boolean z, @OOXIXo f params) {
        IIX0o.x0xO0oo(params, "params");
        return a(2, z, params);
    }

    @Override // com.baidu.navisdk.ugc.external.c
    public void b() {
        c(com.baidu.navisdk.ui.routeguide.utils.b.o().b());
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    @oOoXoXO
    public List<Animator> c(int i, int i2, boolean z, @OOXIXo f params) {
        IIX0o.x0xO0oo(params, "params");
        return a(0, z, params);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    @oOoXoXO
    public List<Animator> d(int i, int i2, boolean z, @OOXIXo f params) {
        IIX0o.x0xO0oo(params, "params");
        return a(3, z, params);
    }

    @Override // com.baidu.navisdk.ugc.external.c
    public boolean i() {
        com.baidu.navisdk.ui.routeguide.mapmode.a b = x.b();
        IIX0o.oO(b, "RGViewController.getInstance()");
        if (!b.s2()) {
            j();
        }
        return super.i();
    }

    private final List<Animator> a(int i, boolean z, f fVar) {
        ViewGroup mDetailParentView;
        if (!z && (mDetailParentView = this.e) != null) {
            IIX0o.oO(mDetailParentView, "mDetailParentView");
            if (mDetailParentView.getVisibility() == 0) {
                c(i == 2);
                Pair<Integer, Integer> a2 = a(i, fVar);
                com.baidu.navisdk.pronavi.hd.d dVar = com.baidu.navisdk.pronavi.hd.d.f7723a;
                ViewGroup viewGroup = this.e;
                Object obj = a2.first;
                IIX0o.oO(obj, "pair.first");
                int intValue = ((Number) obj).intValue();
                Object obj2 = a2.second;
                IIX0o.oO(obj2, "pair.second");
                return dVar.b(viewGroup, intValue, ((Number) obj2).intValue());
            }
        }
        return null;
    }

    private final void c(boolean z) {
        x.b().a(true, !z, this.e);
    }

    private final Pair<Integer, Integer> a(int i, f fVar) {
        int q;
        int i2 = 0;
        if (i == 2) {
            q = com.baidu.navisdk.ui.routeguide.utils.b.q();
            i2 = com.baidu.navisdk.ui.routeguide.utils.b.a(false, fVar);
        } else if (i != 3) {
            q = com.baidu.navisdk.ui.routeguide.utils.b.l();
        } else {
            i2 = com.baidu.navisdk.ui.routeguide.utils.b.k();
            q = com.baidu.navisdk.ui.routeguide.utils.b.q() + i2;
        }
        return new Pair<>(Integer.valueOf(q), Integer.valueOf(i2));
    }
}
