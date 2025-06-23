package com.baidu.navisdk.pronavi.data.vm;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import com.baidu.navisdk.model.datastruct.p;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class d extends com.baidu.navisdk.pronavi.base.b {
    private final X0IIOO b = XIxXXX0x0.oIX0oI(a.f7687a);

    /* loaded from: classes7.dex */
    public static final class a extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<p>> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f7687a = new a();

        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<p> invoke() {
            return new com.baidu.navisdk.framework.lifecycle.b<>(p.BOTTOM);
        }
    }

    private final com.baidu.navisdk.framework.lifecycle.b<p> d() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.b.getValue();
    }

    public final void a(@OOXIXo p status) {
        IIX0o.x0xO0oo(status, "status");
        d().setValue(status);
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<p> c() {
        return d();
    }
}
