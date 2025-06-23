package com.baidu.navisdk.pronavi.mapshow;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import com.baidu.navisdk.pronavi.mapshow.strategy.c;
import com.baidu.navisdk.pronavi.mapshow.strategy.d;
import com.baidu.navisdk.pronavi.mapshow.strategy.e;
import com.baidu.navisdk.util.common.g;
import java.util.HashMap;
import kotlin.LazyThreadSafetyMode;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class a implements com.baidu.navisdk.pronavi.mapshow.i.b, com.baidu.navisdk.module.pronavi.abs.b {

    /* renamed from: a, reason: collision with root package name */
    private final X0IIOO f7801a = XIxXXX0x0.I0Io(LazyThreadSafetyMode.NONE, b.f7802a);

    /* renamed from: com.baidu.navisdk.pronavi.mapshow.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0327a {
        private C0327a() {
        }

        public /* synthetic */ C0327a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends Lambda implements oIX0oI<HashMap<Integer, com.baidu.navisdk.pronavi.mapshow.i.a>> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7802a = new b();

        public b() {
            super(0);
        }

        @Override // Oox.oIX0oI
        @OOXIXo
        public final HashMap<Integer, com.baidu.navisdk.pronavi.mapshow.i.a> invoke() {
            return new HashMap<>(4, 1.0f);
        }
    }

    static {
        new C0327a(null);
    }

    private final HashMap<Integer, com.baidu.navisdk.pronavi.mapshow.i.a> a() {
        return (HashMap) this.f7801a.getValue();
    }

    private final com.baidu.navisdk.pronavi.mapshow.i.a b(int i, int i2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMapShowRectStrategyController", "getARNaviStrategy, " + i + ':' + i2);
        }
        com.baidu.navisdk.pronavi.mapshow.i.a aVar = a().get(1);
        if (aVar == null) {
            com.baidu.navisdk.pronavi.mapshow.strategy.b bVar = new com.baidu.navisdk.pronavi.mapshow.strategy.b(i, i2);
            a().put(1, bVar);
            return bVar;
        }
        aVar.a(i, i2);
        return aVar;
    }

    private final com.baidu.navisdk.pronavi.mapshow.i.a c(int i, int i2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMapShowRectStrategyController", "getNewEnergyChargeListStrategy, " + i + ':' + i2);
        }
        com.baidu.navisdk.pronavi.mapshow.i.a aVar = a().get(2);
        if (aVar == null) {
            c cVar = new c(i, i2);
            a().put(2, cVar);
            return cVar;
        }
        aVar.a(i, i2);
        return aVar;
    }

    private final com.baidu.navisdk.pronavi.mapshow.i.a d(int i, int i2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMapShowRectStrategyController", "getNormalHDStrategy, " + i + ':' + i2);
        }
        com.baidu.navisdk.pronavi.mapshow.i.a aVar = a().get(3);
        if (aVar == null) {
            d dVar = new d(i, i2);
            a().put(3, dVar);
            return dVar;
        }
        aVar.a(i, i2);
        return aVar;
    }

    private final com.baidu.navisdk.pronavi.mapshow.i.a e(int i, int i2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMapShowRectStrategyController", "getParkRecListStrategy, " + i + ':' + i2);
        }
        com.baidu.navisdk.pronavi.mapshow.i.a aVar = a().get(4);
        if (aVar == null) {
            e eVar = new e(i, i2);
            a().put(4, eVar);
            return eVar;
        }
        aVar.a(i, i2);
        return aVar;
    }

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
        a().clear();
    }

    @Override // com.baidu.navisdk.pronavi.mapshow.i.b
    @oOoXoXO
    public com.baidu.navisdk.pronavi.mapshow.i.a a(int i, int i2) {
        com.baidu.navisdk.pronavi.hd.normal.i.a d;
        com.baidu.navisdk.ui.routeguide.ar.a a2;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMapShowRectStrategyController", "getMapShowScreenRectStrategy" + i + ':' + i2);
        }
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V, "BNavigator.getInstance()");
        com.baidu.navisdk.ui.routeguide.navicenter.c j = V.j();
        if (j != null && (a2 = j.a(false)) != null && a2.k()) {
            return b(i, i2);
        }
        com.baidu.navisdk.ui.routeguide.b V2 = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V2, "BNavigator.getInstance()");
        com.baidu.navisdk.pronavi.ui.base.b s = V2.s();
        if (s != null && s.I()) {
            return c(i, i2);
        }
        if (s != null && s.L()) {
            return e(i, i2);
        }
        if (j == null || (d = j.d(false)) == null || !d.e()) {
            return null;
        }
        return d(i, i2);
    }
}
