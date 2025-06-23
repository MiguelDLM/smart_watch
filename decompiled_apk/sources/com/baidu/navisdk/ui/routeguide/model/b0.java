package com.baidu.navisdk.ui.routeguide.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;

/* loaded from: classes8.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f8930a;
    private final int b;

    public b0(boolean z, int i) {
        this.f8930a = z;
        this.b = i;
    }

    public final int a() {
        return this.b;
    }

    public final boolean b() {
        return this.f8930a;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.f8930a == b0Var.f8930a && this.b == b0Var.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.f8930a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.b;
    }

    @OOXIXo
    public String toString() {
        return "RGSmartTrafficSpeedModel(isShow=" + this.f8930a + ", type=" + this.b + oIX0oI.I0Io.f4095I0Io;
    }
}
