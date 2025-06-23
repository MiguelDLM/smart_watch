package com.baidu.navisdk.pronavi.carlogooffset.strategy;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;
import kotlin.Pair;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class b extends com.baidu.navisdk.pronavi.carlogooffset.strategy.a {

    /* renamed from: a, reason: collision with root package name */
    private final int f7644a = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_70dp);

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

    @Override // com.baidu.navisdk.pronavi.carlogooffset.i.a
    @OOXIXo
    public String a() {
        return "RGARNaviOffsetStrategy";
    }

    @Override // com.baidu.navisdk.pronavi.carlogooffset.i.a
    @OOXIXo
    public Pair<Long, Long> a(int i, int i2, @oOoXoXO Object obj) {
        int a2;
        boolean z = i != 2;
        if (i2 == 2) {
            return a(z);
        }
        if (obj instanceof Integer) {
            a2 = ((Number) obj).intValue();
        } else if (i == 2) {
            a2 = com.baidu.navisdk.pronavi.util.a.h.b();
        } else {
            a2 = com.baidu.navisdk.ui.routeguide.utils.b.a(true);
        }
        return a(z, a2);
    }

    private final Pair<Long, Long> a(boolean z, int i) {
        return new Pair<>(0L, Long.valueOf(-((i / 2) - this.f7644a)));
    }

    private final Pair<Long, Long> a(boolean z) {
        return new Pair<>(0L, 0L);
    }
}
