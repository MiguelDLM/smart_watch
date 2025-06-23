package com.baidu.navisdk.pronavi.data.vm;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import androidx.lifecycle.MutableLiveData;
import com.baidu.navisdk.model.datastruct.p;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class e extends com.baidu.navisdk.pronavi.base.b {
    private final X0IIOO b = XIxXXX0x0.oIX0oI(new a());
    private final X0IIOO c = XIxXXX0x0.oIX0oI(new b());
    private final X0IIOO d = XIxXXX0x0.oIX0oI(c.f7706a);
    private final X0IIOO e = XIxXXX0x0.oIX0oI(d.f7707a);

    /* loaded from: classes7.dex */
    public static final class a extends Lambda implements oIX0oI<com.baidu.navisdk.pronavi.data.vm.d> {
        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.pronavi.data.vm.d invoke() {
            com.baidu.navisdk.pronavi.ui.base.b b = e.b(e.this);
            com.baidu.navisdk.pronavi.data.vm.d dVar = b != null ? (com.baidu.navisdk.pronavi.data.vm.d) b.c(com.baidu.navisdk.pronavi.data.vm.d.class) : null;
            IIX0o.ooOOo0oXI(dVar);
            IIX0o.oO(dVar, "context?.getVMData(RGNewBottomBarVM::class.java)!!");
            return dVar;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<p>> {
        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<p> invoke() {
            return e.this.g().c();
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends Lambda implements oIX0oI<MutableLiveData<Integer>> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f7706a = new c();

        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final MutableLiveData<Integer> invoke() {
            return new MutableLiveData<>(8);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends Lambda implements oIX0oI<MutableLiveData<Integer>> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f7707a = new d();

        public d() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final MutableLiveData<Integer> invoke() {
            return new MutableLiveData<>(8);
        }
    }

    public static final /* synthetic */ com.baidu.navisdk.pronavi.ui.base.b b(e eVar) {
        return eVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.baidu.navisdk.pronavi.data.vm.d g() {
        return (com.baidu.navisdk.pronavi.data.vm.d) this.b.getValue();
    }

    private final com.baidu.navisdk.framework.lifecycle.b<p> h() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.c.getValue();
    }

    private final MutableLiveData<Integer> i() {
        return (MutableLiveData) this.d.getValue();
    }

    private final MutableLiveData<Integer> j() {
        return (MutableLiveData) this.e.getValue();
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<p> c() {
        return h();
    }

    @OOXIXo
    public final MutableLiveData<Integer> d() {
        return i();
    }

    @OOXIXo
    public final MutableLiveData<Integer> e() {
        return j();
    }

    public final boolean f() {
        com.baidu.navisdk.pronavi.ui.base.b a2 = a();
        if (a2 != null && a2.c(RGFSMTable.FsmState.BrowseMap)) {
            com.baidu.navisdk.poisearch.model.a k = com.baidu.navisdk.poisearch.model.a.k();
            IIX0o.oO(k, "BNNearbySearchModel.getInstance()");
            if (!k.h()) {
                com.baidu.navisdk.ui.routeguide.mapmode.a b2 = x.b();
                IIX0o.oO(b2, "RGViewController.getInstance()");
                if (!b2.A2()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(int i) {
        if (i == 0 && f()) {
            i().setValue(0);
        } else {
            i().setValue(8);
        }
    }

    public final void b(int i) {
        j().setValue(Integer.valueOf(i));
    }
}
