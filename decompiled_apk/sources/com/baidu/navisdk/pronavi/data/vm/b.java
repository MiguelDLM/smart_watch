package com.baidu.navisdk.pronavi.data.vm;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.pronavi.data.model.d;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class b extends com.baidu.navisdk.pronavi.base.b {
    private C0313b b;

    @OOXIXo
    private final X0IIOO c = XIxXXX0x0.oIX0oI(d.f7683a);

    @OOXIXo
    private final X0IIOO d = XIxXXX0x0.oIX0oI(c.f7682a);
    private boolean e;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* renamed from: com.baidu.navisdk.pronavi.data.vm.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0313b {

        /* renamed from: a, reason: collision with root package name */
        @OOXIXo
        private String f7681a;
        private int b;
        private boolean c;
        private long d;
        private int e;
        private int f;

        public C0313b(@OOXIXo String assertName, int i, boolean z, long j, int i2, int i3) {
            IIX0o.x0xO0oo(assertName, "assertName");
            this.f7681a = assertName;
            this.b = i;
            this.c = z;
            this.d = j;
            this.e = i2;
            this.f = i3;
        }

        @OOXIXo
        public final String a() {
            return this.f7681a;
        }

        public final long b() {
            return this.d;
        }

        public final void c(int i) {
            this.b = i;
        }

        public final int d() {
            return this.f;
        }

        public final int e() {
            return this.b;
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0313b)) {
                return false;
            }
            C0313b c0313b = (C0313b) obj;
            return IIX0o.Oxx0IOOO(this.f7681a, c0313b.f7681a) && this.b == c0313b.b && this.c == c0313b.c && this.d == c0313b.d && this.e == c0313b.e && this.f == c0313b.f;
        }

        public final boolean f() {
            return this.c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.f7681a;
            int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.b) * 31;
            boolean z = this.c;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode + i) * 31;
            long j = this.d;
            return ((((i2 + ((int) (j ^ (j >>> 32)))) * 31) + this.e) * 31) + this.f;
        }

        @OOXIXo
        public String toString() {
            return "LottieAnimatorData(assertName=" + this.f7681a + ", type=" + this.b + ", isShowInSimpleGuide=" + this.c + ", intervalDuration=" + this.d + ", repeatCount=" + this.e + ", repeatMode=" + this.f + oIX0oI.I0Io.f4095I0Io;
        }

        public final void a(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.f7681a = str;
        }

        public final void b(int i) {
            this.f = i;
        }

        public final int c() {
            return this.e;
        }

        public final void a(boolean z) {
            this.c = z;
        }

        public final void a(long j) {
            this.d = j;
        }

        public final void a(int i) {
            this.e = i;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends Lambda implements Oox.oIX0oI<com.baidu.navisdk.framework.lifecycle.a<Integer>> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f7682a = new c();

        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.a<Integer> invoke() {
            return new com.baidu.navisdk.framework.lifecycle.a<>();
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends Lambda implements Oox.oIX0oI<com.baidu.navisdk.framework.lifecycle.a<C0313b>> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f7683a = new d();

        public d() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.a<C0313b> invoke() {
            return new com.baidu.navisdk.framework.lifecycle.a<>();
        }
    }

    /* loaded from: classes7.dex */
    public static final class e<T> implements Observer<d.a> {
        public e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(d.a input) {
            b bVar = b.this;
            IIX0o.oO(input, "input");
            bVar.a(input);
        }
    }

    /* loaded from: classes7.dex */
    public static final class f<T> implements Observer<Integer> {
        public f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer model) {
            b bVar = b.this;
            IIX0o.oO(model, "model");
            bVar.b(model.intValue());
        }
    }

    static {
        new a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        C0313b value;
        Integer value2 = c().getValue();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelLottieViewVM", "updateGuidePanelMode: " + value2 + org.apache.commons.text.oIX0oI.f33048oxoX + i + "; " + this.e);
        }
        if (value2 == null || value2.intValue() != i) {
            c().setValue(Integer.valueOf(i));
        }
        if (this.b != null && !this.e) {
            if (i == 1) {
                if (d().getValue() != null && (value = d().getValue()) != null && !value.f()) {
                    d().setValue(null);
                    return;
                } else {
                    d().setValue(this.b);
                    return;
                }
            }
            d().setValue(this.b);
        }
    }

    private final void h() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelLottieViewVM", "hideLottieAnimator: " + d().getValue());
        }
        if (d().getValue() != null) {
            d().setValue(null);
        }
    }

    private final boolean i() {
        Integer value = c().getValue();
        if (value != null && value.intValue() == 1) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.a<Integer> c() {
        return (com.baidu.navisdk.framework.lifecycle.a) this.d.getValue();
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.a<C0313b> d() {
        return (com.baidu.navisdk.framework.lifecycle.a) this.c.getValue();
    }

    public final void e() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelLottieViewVM", "hideACELottieAnimator, " + this.b);
        }
        a(1);
    }

    public final void f() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelLottieViewVM", "showACEBlueLottieAnimator");
        }
        a(this, "bluelottiledata.json", 1, false, 0L, 0, 0, 56, null);
    }

    public final void g() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelLottieViewVM", "showACEGreenLottieAnimator");
        }
        a(this, "greenlottiledata.json", 1, false, 0L, 0, 0, 56, null);
    }

    @Override // com.baidu.navisdk.pageframe.store.data.c
    public void a(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar) {
        super.a((b) bVar);
        com.baidu.navisdk.pronavi.ui.base.b a2 = a();
        if (a2 != null) {
            com.baidu.navisdk.pronavi.data.model.d dVar = (com.baidu.navisdk.pronavi.data.model.d) a2.b(com.baidu.navisdk.pronavi.data.model.d.class);
            if (dVar != null) {
                d().addSource(dVar.a(), new e());
            }
            com.baidu.navisdk.pronavi.data.model.c cVar = (com.baidu.navisdk.pronavi.data.model.c) a2.b(com.baidu.navisdk.pronavi.data.model.c.class);
            if (cVar != null) {
                c().addSource(cVar.a(), new f());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(d.a aVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelLottieViewVM", "onChangeIHighSpeedState:" + aVar);
        }
        int i = com.baidu.navisdk.pronavi.data.vm.c.f7686a[aVar.ordinal()];
        if (i == 1) {
            a(2);
        } else {
            if (i != 2) {
                return;
            }
            a(this, "bluelottiledata.json", 2, true, 480000L, 3, 0, 32, null);
        }
    }

    public final void a(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelLottieViewVM", "changeExitMainRoadGuidePanelVisible:" + z + ", " + this.b + ", " + this.e);
        }
        if (z == this.e) {
            return;
        }
        this.e = z;
        if (z) {
            h();
            return;
        }
        C0313b c0313b = this.b;
        if (c0313b != null) {
            a(c0313b.a(), c0313b.e(), c0313b.f(), c0313b.b(), c0313b.c(), c0313b.d());
        }
    }

    private final void a(int i) {
        C0313b value = d().getValue();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelLottieViewVM", "exitLottieAnimator:" + i + ", " + this.b + ", showed:" + value);
        }
        C0313b c0313b = this.b;
        if (c0313b == null || c0313b.e() != i) {
            return;
        }
        this.b = null;
        if (value != null) {
            d().setValue(null);
        }
    }

    public static /* synthetic */ void a(b bVar, String str, int i, boolean z, long j, int i2, int i3, int i4, Object obj) {
        bVar.a(str, i, z, (i4 & 8) != 0 ? 0L : j, (i4 & 16) != 0 ? -1 : i2, (i4 & 32) != 0 ? 1 : i3);
    }

    private final void a(String str, int i, boolean z, long j, int i2, int i3) {
        C0313b c0313b = this.b;
        if (c0313b == null) {
            this.b = new C0313b(str, i, z, j, i2, i3);
        } else {
            c0313b.a(str);
            c0313b.a(i2);
            c0313b.b(i3);
            c0313b.a(z);
            c0313b.c(i);
            c0313b.a(j);
        }
        if ((!z && i()) || this.e) {
            h();
        } else {
            d().setValue(this.b);
        }
    }
}
