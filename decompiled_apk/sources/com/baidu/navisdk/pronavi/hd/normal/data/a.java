package com.baidu.navisdk.pronavi.hd.normal.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import XXO0.oIX0oI;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private final X0IIOO f7747a;

    @OOXIXo
    private final X0IIOO b;

    @OOXIXo
    private final X0IIOO c;

    @OOXIXo
    private final X0IIOO d;

    @OOXIXo
    private final X0IIOO e;
    private final int f;

    @OOXIXo
    private final X0IIOO g;

    @OOXIXo
    private final X0IIOO h;
    private final int i;

    @OOXIXo
    private final X0IIOO j;

    @OOXIXo
    private final X0IIOO k;
    private final int l;

    /* renamed from: com.baidu.navisdk.pronavi.hd.normal.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0321a extends Lambda implements oIX0oI<Rect> {
        public C0321a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final Rect invoke() {
            Rect rect = new Rect();
            try {
                Drawable drawable = JarUtils.getResources().getDrawable(a.this.l);
                if (drawable != null) {
                    drawable.getPadding(rect);
                }
            } catch (Exception e) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGNormalHDSize", "bgPaddingRect exception: " + e);
                }
            }
            return rect;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends Lambda implements oIX0oI<Integer> {
        public b() {
            super(0);
        }

        @Override // Oox.oIX0oI
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return (com.baidu.navisdk.pronavi.util.a.h.e() - a.this.a().top) - a.this.a().bottom;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends Lambda implements oIX0oI<Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f7750a = new c();

        public c() {
            super(0);
        }

        @Override // Oox.oIX0oI
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return (int) (com.baidu.navisdk.pronavi.util.a.h.d() * 0.28d);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends Lambda implements oIX0oI<Pair<? extends Integer, ? extends Integer>> {
        public d() {
            super(0);
        }

        @Override // Oox.oIX0oI
        @OOXIXo
        public final Pair<? extends Integer, ? extends Integer> invoke() {
            int c = a.this.c() + JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_20dp);
            com.baidu.navisdk.ui.routeguide.mapmode.subview.a c2 = com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c();
            IIX0o.oO(c2, "DisplayCutoutManager.getInstance()");
            return new Pair<>(Integer.valueOf((c + c2.a()) - a.this.a().right), Integer.valueOf(a.this.e()));
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends Lambda implements oIX0oI<Integer> {
        public e() {
            super(0);
        }

        @Override // Oox.oIX0oI
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return a.this.c() + a.this.a().left + a.this.a().right;
        }
    }

    /* loaded from: classes7.dex */
    public static final class f extends Lambda implements oIX0oI<Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f7753a = new f();

        public f() {
            super(0);
        }

        @Override // Oox.oIX0oI
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return (int) (com.baidu.navisdk.pronavi.util.a.h.d() * 0.15d);
        }
    }

    /* loaded from: classes7.dex */
    public static final class g extends Lambda implements oIX0oI<Integer> {
        public g() {
            super(0);
        }

        @Override // Oox.oIX0oI
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return (com.baidu.navisdk.pronavi.util.a.h.e() - a.this.a().left) - a.this.a().right;
        }
    }

    /* loaded from: classes7.dex */
    public static final class h extends Lambda implements oIX0oI<Pair<? extends Integer, ? extends Integer>> {
        public h() {
            super(0);
        }

        @Override // Oox.oIX0oI
        @OOXIXo
        public final Pair<? extends Integer, ? extends Integer> invoke() {
            return new Pair<>(Integer.valueOf(a.this.l()), Integer.valueOf(a.this.g() + com.baidu.navisdk.ui.routeguide.utils.b.d()));
        }
    }

    /* loaded from: classes7.dex */
    public static final class i extends Lambda implements oIX0oI<Integer> {
        public i() {
            super(0);
        }

        @Override // Oox.oIX0oI
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return a.this.g() + a.this.a().bottom + a.this.a().top;
        }
    }

    public a(@DrawableRes int i2) {
        this.l = i2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.f7747a = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new C0321a());
        this.b = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new g());
        this.c = XIxXXX0x0.I0Io(lazyThreadSafetyMode, f.f7753a);
        this.d = XIxXXX0x0.I0Io(lazyThreadSafetyMode, c.f7750a);
        this.e = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new b());
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        this.f = aVar.e();
        this.g = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new i());
        this.h = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new e());
        this.i = aVar.e();
        this.j = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new d());
        this.k = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new h());
    }

    @OOXIXo
    public final Rect a() {
        return (Rect) this.f7747a.getValue();
    }

    public final int b() {
        return ((Number) this.e.getValue()).intValue();
    }

    public final int c() {
        return ((Number) this.d.getValue()).intValue();
    }

    @OOXIXo
    public final Pair<Integer, Integer> d() {
        return (Pair) this.j.getValue();
    }

    public final int e() {
        return this.i;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this != obj) {
            return (obj instanceof a) && this.l == ((a) obj).l;
        }
        return true;
    }

    public final int f() {
        return ((Number) this.h.getValue()).intValue();
    }

    public final int g() {
        return ((Number) this.c.getValue()).intValue();
    }

    public final int h() {
        return com.baidu.navisdk.ui.routeguide.utils.b.d() - a().bottom;
    }

    public int hashCode() {
        return this.l;
    }

    public final int i() {
        return ((Number) this.b.getValue()).intValue();
    }

    @OOXIXo
    public final Pair<Integer, Integer> j() {
        return (Pair) this.k.getValue();
    }

    public final int k() {
        return ((Number) this.g.getValue()).intValue();
    }

    public final int l() {
        return this.f;
    }

    @OOXIXo
    public String toString() {
        return "RGNormalHDSize(bgResourceId=" + this.l + oIX0oI.I0Io.f4095I0Io;
    }
}
