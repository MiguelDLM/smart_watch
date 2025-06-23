package com.baidu.navisdk.pronavi.data.vm;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import androidx.lifecycle.MutableLiveData;
import com.baidu.navisdk.model.datastruct.p;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class f extends com.baidu.navisdk.pronavi.base.b {
    private final X0IIOO b = XIxXXX0x0.oIX0oI(new a());
    private final X0IIOO c = XIxXXX0x0.oIX0oI(new c());
    private final X0IIOO d = XIxXXX0x0.oIX0oI(b.f7709a);

    /* loaded from: classes7.dex */
    public static final class a extends Lambda implements oIX0oI<d> {
        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final d invoke() {
            com.baidu.navisdk.pronavi.ui.base.b b = f.b(f.this);
            d dVar = b != null ? (d) b.c(d.class) : null;
            IIX0o.ooOOo0oXI(dVar);
            IIX0o.oO(dVar, "context?.getVMData(RGNewBottomBarVM::class.java)!!");
            return dVar;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends Lambda implements oIX0oI<MutableLiveData<Integer>> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7709a = new b();

        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final MutableLiveData<Integer> invoke() {
            return new MutableLiveData<>(0);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<p>> {
        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<p> invoke() {
            return f.this.e().c();
        }
    }

    public static final /* synthetic */ com.baidu.navisdk.pronavi.ui.base.b b(f fVar) {
        return fVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d e() {
        return (d) this.b.getValue();
    }

    private final MutableLiveData<Integer> f() {
        return (MutableLiveData) this.d.getValue();
    }

    private final com.baidu.navisdk.framework.lifecycle.b<p> g() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.c.getValue();
    }

    @OOXIXo
    public final MutableLiveData<Integer> c() {
        return f();
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<p> d() {
        return g();
    }
}
