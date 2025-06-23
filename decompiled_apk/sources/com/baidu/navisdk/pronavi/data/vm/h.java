package com.baidu.navisdk.pronavi.data.vm;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import com.baidu.navisdk.model.datastruct.m;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class h extends com.baidu.navisdk.pronavi.base.b {
    private final X0IIOO b = XIxXXX0x0.oIX0oI(new e());

    @OOXIXo
    private final X0IIOO c = XIxXXX0x0.oIX0oI(new d());

    @OOXIXo
    private final X0IIOO d = XIxXXX0x0.oIX0oI(new f());

    @OOXIXo
    private final X0IIOO e = XIxXXX0x0.oIX0oI(new a());

    @OOXIXo
    private final X0IIOO f = XIxXXX0x0.oIX0oI(new c());

    @OOXIXo
    private final X0IIOO g = XIxXXX0x0.oIX0oI(new b());

    @OOXIXo
    private final X0IIOO h = XIxXXX0x0.oIX0oI(g.f7718a);

    /* loaded from: classes7.dex */
    public static final class a extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<Integer>> {
        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<Integer> invoke() {
            return h.this.j().c();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<Double>> {
        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<Double> invoke() {
            return h.this.j().a();
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<Integer>> {
        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<Integer> invoke() {
            return h.this.j().b();
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<List<? extends m>>> {
        public d() {
            super(0);
        }

        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<List<? extends m>> invoke() {
            return h.this.j().d();
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends Lambda implements oIX0oI<com.baidu.navisdk.pronavi.data.model.g> {
        public e() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.pronavi.data.model.g invoke() {
            com.baidu.navisdk.pronavi.ui.base.b a2 = h.a(h.this);
            IIX0o.ooOOo0oXI(a2);
            com.baidu.navisdk.pageframe.store.data.b b = a2.b((Class<com.baidu.navisdk.pageframe.store.data.b>) com.baidu.navisdk.pronavi.data.model.g.class);
            IIX0o.ooOOo0oXI(b);
            IIX0o.oO(b, "context!!.getMData(RGRoa…itionViewM::class.java)!!");
            return (com.baidu.navisdk.pronavi.data.model.g) b;
        }
    }

    /* loaded from: classes7.dex */
    public static final class f extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<List<? extends com.baidu.navisdk.module.pronavi.model.c>>> {
        public f() {
            super(0);
        }

        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<List<? extends com.baidu.navisdk.module.pronavi.model.c>> invoke() {
            return h.this.j().e();
        }
    }

    /* loaded from: classes7.dex */
    public static final class g extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<com.baidu.navisdk.module.pronavi.model.c>> {

        /* renamed from: a, reason: collision with root package name */
        public static final g f7718a = new g();

        public g() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<com.baidu.navisdk.module.pronavi.model.c> invoke() {
            return new com.baidu.navisdk.framework.lifecycle.b<>();
        }
    }

    public static final /* synthetic */ com.baidu.navisdk.pronavi.ui.base.b a(h hVar) {
        return hVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.baidu.navisdk.pronavi.data.model.g j() {
        return (com.baidu.navisdk.pronavi.data.model.g) this.b.getValue();
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<Integer> c() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.e.getValue();
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<Double> d() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.g.getValue();
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<Integer> e() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.f.getValue();
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<List<m>> f() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.c.getValue();
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<List<com.baidu.navisdk.module.pronavi.model.c>> g() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.d.getValue();
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<com.baidu.navisdk.module.pronavi.model.c> h() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.h.getValue();
    }

    public final void i() {
        h().setValue(null);
    }

    public final void a(@OOXIXo com.baidu.navisdk.module.pronavi.model.c item) {
        IIX0o.x0xO0oo(item, "item");
        h().setValue(item);
    }
}
