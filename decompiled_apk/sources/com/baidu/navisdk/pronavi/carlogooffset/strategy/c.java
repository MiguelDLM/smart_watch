package com.baidu.navisdk.pronavi.carlogooffset.strategy;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.j;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import kotlin.Pair;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class c extends com.baidu.navisdk.pronavi.carlogooffset.strategy.a {

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
    }

    private final Pair<Long, Long> b(boolean z, int i) {
        long V;
        int i2;
        long j;
        if (z) {
            if (!j.d() && (com.baidu.navisdk.ui.routeguide.c.g().b() != 0 || com.baidu.navisdk.ui.routeguide.c.g().d() != 0)) {
                V = com.baidu.navisdk.ui.routeguide.c.g().b();
                i2 = com.baidu.navisdk.ui.routeguide.c.g().d();
            } else {
                j = -(((com.baidu.navisdk.pronavi.util.a.h.d() / 2) - i) - JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_73dp));
                V = 0;
                return new Pair<>(Long.valueOf(V), Long.valueOf(j));
            }
        } else {
            com.baidu.navisdk.ui.routeguide.mapmode.a b = x.b();
            IIX0o.oO(b, "RGViewController.getInstance()");
            V = (b.V() - i) / 2;
            i2 = -((com.baidu.navisdk.pronavi.util.a.h.e() / 2) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_map_status_y_offset));
        }
        j = i2;
        return new Pair<>(Long.valueOf(V), Long.valueOf(j));
    }

    @Override // com.baidu.navisdk.pronavi.carlogooffset.i.a
    @OOXIXo
    public String a() {
        return "RGNormalHDOffsetStrategy";
    }

    @Override // com.baidu.navisdk.pronavi.carlogooffset.i.a
    @OOXIXo
    public Pair<Long, Long> a(int i, int i2, @oOoXoXO Object obj) {
        Integer first;
        int i3 = 0;
        boolean z = i != 2;
        if (obj instanceof Integer) {
            i3 = ((Number) obj).intValue();
        } else {
            com.baidu.navisdk.pronavi.hd.normal.i.a c = com.baidu.navisdk.ui.routeguide.utils.b.c(false);
            Pair<Integer, Integer> f = c != null ? c.f(i) : null;
            if (!z ? !(f == null || (first = f.getFirst()) == null) : !(f == null || (first = f.getSecond()) == null)) {
                i3 = first.intValue();
            }
        }
        if (i2 == 2) {
            return a(z, i3);
        }
        return b(z, i3);
    }

    private final Pair<Long, Long> a(boolean z, int i) {
        long V;
        long j = 0;
        if (z) {
            V = 0;
            j = -ScreenUtil.getInstance().dip2px(20);
        } else {
            com.baidu.navisdk.ui.routeguide.mapmode.a b = x.b();
            IIX0o.oO(b, "RGViewController.getInstance()");
            V = (b.V() - i) / 2;
        }
        return new Pair<>(Long.valueOf(V), Long.valueOf(j));
    }
}
