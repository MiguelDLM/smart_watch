package com.baidu.navisdk.ui.routeguide.heatmonitor;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;

/* loaded from: classes8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final int f8627a;
    private final int b;

    public h(int i, int i2) {
        this.f8627a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f8627a == hVar.f8627a && this.b == hVar.b;
    }

    public int hashCode() {
        return (this.f8627a * 31) + this.b;
    }

    @OOXIXo
    public String toString() {
        return "RGHMStateBean(from=" + this.f8627a + ", to=" + this.b + oIX0oI.I0Io.f4095I0Io;
    }
}
