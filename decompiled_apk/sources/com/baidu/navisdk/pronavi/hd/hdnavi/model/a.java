package com.baidu.navisdk.pronavi.hd.hdnavi.model;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;
import kotlin.LazyThreadSafetyMode;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class a {

    @OOXIXo
    public static final C0320a h = new C0320a(null);

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private final X0IIOO f7738a;

    @OOXIXo
    private final X0IIOO b;

    @OOXIXo
    private final X0IIOO c;

    @OOXIXo
    private final X0IIOO d;

    @OOXIXo
    private final X0IIOO e;

    @OOXIXo
    private final X0IIOO f;
    private final boolean g;

    /* renamed from: com.baidu.navisdk.pronavi.hd.hdnavi.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0320a {
        private C0320a() {
        }

        public final int a() {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_4dp);
        }

        public final int b() {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_hd_shadow_portrait_height);
        }

        public final int c() {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_9dp);
        }

        public /* synthetic */ C0320a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends Lambda implements oIX0oI<Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7739a = new b();

        public b() {
            super(0);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return -1;
        }

        @Override // Oox.oIX0oI
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends Lambda implements oIX0oI<Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f7740a = new c();

        public c() {
            super(0);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return 0;
        }

        @Override // Oox.oIX0oI
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends Lambda implements oIX0oI<Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f7741a = new d();

        public d() {
            super(0);
        }

        @Override // Oox.oIX0oI
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return (int) (com.baidu.navisdk.pronavi.util.a.h.d() * 0.34d);
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
            return a.this.b();
        }
    }

    /* loaded from: classes7.dex */
    public static final class f extends Lambda implements oIX0oI<Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f7743a = new f();

        public f() {
            super(0);
        }

        @Override // Oox.oIX0oI
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return (int) (com.baidu.navisdk.pronavi.util.a.h.d() * 0.33d);
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
            if (a.this.g) {
                return 0;
            }
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_bottom_bar_new_eta_height);
        }
    }

    /* loaded from: classes7.dex */
    public static final class h extends Lambda implements oIX0oI<Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final h f7745a = new h();

        public h() {
            super(0);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return -1;
        }

        @Override // Oox.oIX0oI
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
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
            return a.this.d() + a.this.e();
        }
    }

    public a(boolean z) {
        this.g = z;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        XIxXXX0x0.I0Io(lazyThreadSafetyMode, h.f7745a);
        this.f7738a = XIxXXX0x0.I0Io(lazyThreadSafetyMode, f.f7743a);
        this.b = XIxXXX0x0.I0Io(lazyThreadSafetyMode, d.f7741a);
        XIxXXX0x0.I0Io(lazyThreadSafetyMode, b.f7739a);
        this.c = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new g());
        this.d = XIxXXX0x0.I0Io(lazyThreadSafetyMode, c.f7740a);
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        aVar.e();
        this.e = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new i());
        this.f = XIxXXX0x0.I0Io(lazyThreadSafetyMode, new e());
        aVar.e();
    }

    public final int a() {
        return ((Number) this.d.getValue()).intValue();
    }

    public final int b() {
        return ((Number) this.b.getValue()).intValue();
    }

    public final int c() {
        return ((Number) this.f.getValue()).intValue();
    }

    public final int d() {
        return ((Number) this.f7738a.getValue()).intValue();
    }

    public final int e() {
        return ((Number) this.c.getValue()).intValue();
    }

    public final int f() {
        return ((Number) this.e.getValue()).intValue();
    }

    public final long a(int i2, boolean z) {
        if (!z) {
            return -((com.baidu.navisdk.pronavi.util.a.h.e() / 2) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_90dp));
        }
        if (i2 == 2) {
            return -((d() / 2) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_52dp));
        }
        if (i2 != 3) {
            return 0L;
        }
        return -((com.baidu.navisdk.pronavi.util.a.h.d() / 2) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_190dp));
    }

    public final int a(boolean z) {
        return z ? d() : b();
    }
}
