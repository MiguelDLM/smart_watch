package com.baidu.navisdk.ui.chargelist.data.beans;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;

/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f8374a;

    @oOoXoXO
    private final String b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public b(@oOoXoXO String str, int i, int i2, int i3, int i4, int i5) {
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
    }

    public int a() {
        return this.f;
    }

    public int b() {
        return this.g;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    @oOoXoXO
    public String f() {
        return this.b;
    }

    public final boolean g() {
        return this.f8374a;
    }

    @OOXIXo
    public String toString() {
        return "ChargeWrapper(uid=" + f() + ", groupIndex=" + c() + ", itemType=" + d() + ", positionType=" + e() + ", backgroundType=" + a() + ", distance=" + b() + ", isSelected=" + this.f8374a + oIX0oI.I0Io.f4095I0Io;
    }

    public final void a(boolean z) {
        this.f8374a = z;
    }
}
