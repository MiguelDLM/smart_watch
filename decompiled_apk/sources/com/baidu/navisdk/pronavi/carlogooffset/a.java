package com.baidu.navisdk.pronavi.carlogooffset;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import com.baidu.navisdk.pronavi.carlogooffset.strategy.c;
import com.baidu.navisdk.util.common.g;
import java.util.HashMap;
import kotlin.LazyThreadSafetyMode;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class a implements com.baidu.navisdk.pronavi.carlogooffset.i.b, com.baidu.navisdk.module.pronavi.abs.b {

    /* renamed from: a, reason: collision with root package name */
    private final X0IIOO f7642a = XIxXXX0x0.I0Io(LazyThreadSafetyMode.NONE, b.f7643a);

    /* renamed from: com.baidu.navisdk.pronavi.carlogooffset.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0307a {
        private C0307a() {
        }

        public /* synthetic */ C0307a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends Lambda implements oIX0oI<HashMap<Integer, com.baidu.navisdk.pronavi.carlogooffset.i.a>> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7643a = new b();

        public b() {
            super(0);
        }

        @Override // Oox.oIX0oI
        @OOXIXo
        public final HashMap<Integer, com.baidu.navisdk.pronavi.carlogooffset.i.a> invoke() {
            return new HashMap<>(4, 1.0f);
        }
    }

    static {
        new C0307a(null);
    }

    private final com.baidu.navisdk.pronavi.carlogooffset.i.a b() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCarLogoOffsetStrategyController", "getARNaviStrategy");
        }
        com.baidu.navisdk.pronavi.carlogooffset.i.a aVar = c().get(1);
        if (aVar == null) {
            com.baidu.navisdk.pronavi.carlogooffset.strategy.b bVar = new com.baidu.navisdk.pronavi.carlogooffset.strategy.b();
            c().put(1, bVar);
            return bVar;
        }
        return aVar;
    }

    private final HashMap<Integer, com.baidu.navisdk.pronavi.carlogooffset.i.a> c() {
        return (HashMap) this.f7642a.getValue();
    }

    private final com.baidu.navisdk.pronavi.carlogooffset.i.a d() {
        com.baidu.navisdk.pronavi.carlogooffset.i.a aVar = c().get(2);
        if (aVar == null) {
            c cVar = new c();
            c().put(2, cVar);
            return cVar;
        }
        return aVar;
    }

    @Override // com.baidu.navisdk.pronavi.carlogooffset.i.b
    @oOoXoXO
    public com.baidu.navisdk.pronavi.carlogooffset.i.a a() {
        com.baidu.navisdk.pronavi.hd.normal.i.a d;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCarLogoOffsetStrategyController", "getCarLogoOffsetStrategy");
        }
        if (com.baidu.navisdk.ui.routeguide.utils.b.s()) {
            return b();
        }
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V, "BNavigator.getInstance()");
        com.baidu.navisdk.ui.routeguide.navicenter.c j = V.j();
        if (j == null || (d = j.d(false)) == null || !d.e()) {
            return null;
        }
        return d();
    }

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
        c().clear();
    }

    @Override // com.baidu.navisdk.pronavi.carlogooffset.i.b
    @oOoXoXO
    public com.baidu.navisdk.pronavi.carlogooffset.i.a a(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCarLogoOffsetStrategyController", "getCarLogoOffsetStrategy:" + i);
        }
        if (i == 1) {
            return b();
        }
        if (i != 2) {
            return null;
        }
        return d();
    }
}
