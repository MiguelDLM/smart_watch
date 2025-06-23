package com.baidu.navisdk.pronavi.data.vm;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import androidx.annotation.ColorRes;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.embed.R;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class a extends com.baidu.navisdk.pronavi.base.b {
    private int b;
    private final X0IIOO c = XIxXXX0x0.oIX0oI(new d());

    @OOXIXo
    private final X0IIOO d;

    /* renamed from: com.baidu.navisdk.pronavi.data.vm.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0312a {
        private C0312a() {
        }

        public /* synthetic */ C0312a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @oOoXoXO
        private String f7675a;
        private int b;

        public b(@oOoXoXO String str, @ColorRes int i) {
            this.f7675a = str;
            this.b = i;
        }

        public final int a() {
            return this.b;
        }

        @oOoXoXO
        public final String b() {
            return this.f7675a;
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return IIX0o.Oxx0IOOO(this.f7675a, bVar.f7675a) && this.b == bVar.b;
        }

        public int hashCode() {
            String str = this.f7675a;
            return ((str != null ? str.hashCode() : 0) * 31) + this.b;
        }

        @OOXIXo
        public String toString() {
            return "RoadNameSuffixData(content=" + this.f7675a + ", colorRes=" + this.b + oIX0oI.I0Io.f4095I0Io;
        }

        public final void a(int i) {
            this.b = i;
        }

        public final void a(@oOoXoXO String str) {
            this.f7675a = str;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends Lambda implements Oox.oIX0oI<com.baidu.navisdk.framework.lifecycle.b<String>> {
        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<String> invoke() {
            return a.this.f().a();
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends Lambda implements Oox.oIX0oI<com.baidu.navisdk.pronavi.data.model.a> {
        public d() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.pronavi.data.model.a invoke() {
            com.baidu.navisdk.pronavi.ui.base.b a2 = a.a(a.this);
            IIX0o.ooOOo0oXI(a2);
            com.baidu.navisdk.pageframe.store.data.b b = a2.b((Class<com.baidu.navisdk.pageframe.store.data.b>) com.baidu.navisdk.pronavi.data.model.a.class);
            IIX0o.ooOOo0oXI(b);
            IIX0o.oO(b, "context!!.getMData(RGCurRoadNameM::class.java)!!");
            return (com.baidu.navisdk.pronavi.data.model.a) b;
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends Lambda implements Oox.oIX0oI<com.baidu.navisdk.framework.lifecycle.b<Integer>> {
        public e() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<Integer> invoke() {
            return a.this.f().b();
        }
    }

    /* loaded from: classes7.dex */
    public static final class f extends Lambda implements Oox.oIX0oI<com.baidu.navisdk.framework.lifecycle.a<b>> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f7679a = new f();

        public f() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.a<b> invoke() {
            return new com.baidu.navisdk.framework.lifecycle.a<>();
        }
    }

    /* loaded from: classes7.dex */
    public static final class g<T> implements Observer<com.baidu.navisdk.ui.routeguide.ace.g> {
        public g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(com.baidu.navisdk.ui.routeguide.ace.g gVar) {
            a.this.a(gVar);
        }
    }

    static {
        new C0312a(null);
    }

    public a() {
        XIxXXX0x0.oIX0oI(new c());
        XIxXXX0x0.oIX0oI(new e());
        this.d = XIxXXX0x0.oIX0oI(f.f7679a);
    }

    public static final /* synthetic */ com.baidu.navisdk.pronavi.ui.base.b a(a aVar) {
        return aVar.a();
    }

    private final void d() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCurRoadNameVM", "enterGreenRoad:" + this.b);
        }
        this.b = 1;
        a("·绿波路段", R.color.bnav_rg_road_name_greed_light);
    }

    private final void e() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCurRoadNameVM", "exitGreenRoad:" + this.b);
        }
        if (this.b == 1) {
            this.b = 0;
            a(this, null, 0, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.baidu.navisdk.pronavi.data.model.a f() {
        return (com.baidu.navisdk.pronavi.data.model.a) this.c.getValue();
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.a<b> c() {
        return (com.baidu.navisdk.framework.lifecycle.a) this.d.getValue();
    }

    @Override // com.baidu.navisdk.pageframe.store.data.c
    public void a(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar) {
        com.baidu.navisdk.ui.routeguide.ace.a a2;
        MutableLiveData<com.baidu.navisdk.ui.routeguide.ace.g> g2;
        super.a((a) bVar);
        if (a() == null || (a2 = com.baidu.navisdk.ui.routeguide.ace.a.g.a()) == null || (g2 = a2.g()) == null) {
            return;
        }
        c().addSource(g2, new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(com.baidu.navisdk.ui.routeguide.ace.g gVar) {
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGCurRoadNameVM", "updateAceStatus:" + gVar + TokenParser.SP);
        }
        if (gVar != null) {
            if (gVar.a()) {
                e();
                return;
            } else if (gVar.c()) {
                d();
                return;
            } else {
                e();
                return;
            }
        }
        e();
    }

    public static /* synthetic */ void a(a aVar, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = R.color.nsdk_color_common_black;
        }
        aVar.a(str, i);
    }

    private final void a(String str, @ColorRes int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCurRoadNameVM", "updateRoadNameSuffix:" + str + ", " + i);
        }
        b value = c().getValue();
        if (value == null) {
            c().setValue(new b(str, i));
        } else {
            if (IIX0o.Oxx0IOOO(value.b(), str)) {
                return;
            }
            value.a(str);
            value.a(i);
            c().setValue(value);
        }
    }
}
