package com.baidu.navisdk.pronavi.data.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.model.datastruct.m;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class g extends com.baidu.navisdk.pageframe.store.data.b {

    /* renamed from: a, reason: collision with root package name */
    private final X0IIOO f7664a = XIxXXX0x0.oIX0oI(d.f7668a);
    private final X0IIOO b = XIxXXX0x0.oIX0oI(e.f7669a);
    private final X0IIOO c = XIxXXX0x0.oIX0oI(a.f7665a);
    private final X0IIOO d = XIxXXX0x0.oIX0oI(c.f7667a);
    private final X0IIOO e = XIxXXX0x0.oIX0oI(b.f7666a);

    /* loaded from: classes7.dex */
    public static final class a extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<Integer>> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f7665a = new a();

        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<Integer> invoke() {
            return new com.baidu.navisdk.framework.lifecycle.b<>(0);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<Double>> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7666a = new b();

        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<Double> invoke() {
            return new com.baidu.navisdk.framework.lifecycle.b<>(Double.valueOf(XIXIX.OOXIXo.f3760XO));
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<Integer>> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f7667a = new c();

        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<Integer> invoke() {
            BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
            IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
            return new com.baidu.navisdk.framework.lifecycle.b<>(Integer.valueOf(bNCommSettingManager.getIsShowMapSwitch()));
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<List<? extends m>>> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f7668a = new d();

        public d() {
            super(0);
        }

        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<List<? extends m>> invoke() {
            return new com.baidu.navisdk.framework.lifecycle.b<>();
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<List<? extends com.baidu.navisdk.module.pronavi.model.c>>> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f7669a = new e();

        public e() {
            super(0);
        }

        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<List<? extends com.baidu.navisdk.module.pronavi.model.c>> invoke() {
            return new com.baidu.navisdk.framework.lifecycle.b<>();
        }
    }

    private final com.baidu.navisdk.framework.lifecycle.b<Integer> f() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.c.getValue();
    }

    private final com.baidu.navisdk.framework.lifecycle.b<Double> g() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.e.getValue();
    }

    private final com.baidu.navisdk.framework.lifecycle.b<Integer> h() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.d.getValue();
    }

    private final com.baidu.navisdk.framework.lifecycle.b<List<m>> i() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.f7664a.getValue();
    }

    private final com.baidu.navisdk.framework.lifecycle.b<List<com.baidu.navisdk.module.pronavi.model.c>> j() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(@oOoXoXO List<? extends m> list) {
        i().setValue(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(@oOoXoXO List<? extends com.baidu.navisdk.module.pronavi.model.c> list) {
        j().setValue(list);
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<Integer> c() {
        return f();
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<List<m>> d() {
        return i();
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<List<com.baidu.navisdk.module.pronavi.model.c>> e() {
        return j();
    }

    public final void a(int i) {
        h().setValue(Integer.valueOf(i));
    }

    public final void b(int i) {
        f().setValue(Integer.valueOf(i));
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<Double> a() {
        return g();
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<Integer> b() {
        return h();
    }

    public final void a(double d2) {
        g().setValue(Double.valueOf(d2));
    }
}
