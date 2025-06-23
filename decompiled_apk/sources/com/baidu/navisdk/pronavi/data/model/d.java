package com.baidu.navisdk.pronavi.data.model;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class d extends com.baidu.navisdk.pageframe.store.data.b {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private final X0IIOO f7658a = XIxXXX0x0.oIX0oI(b.f7660a);

    /* loaded from: classes7.dex */
    public enum a {
        ENTER,
        EXIT
    }

    /* loaded from: classes7.dex */
    public static final class b extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<a>> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7660a = new b();

        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<a> invoke() {
            return new com.baidu.navisdk.framework.lifecycle.b<>();
        }
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<a> a() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.f7658a.getValue();
    }
}
