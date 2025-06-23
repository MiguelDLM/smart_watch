package com.baidu.navisdk.pronavi.data.vm.devicestate;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;

/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7701a;
    private int b;

    public d(boolean z, int i) {
        this.f7701a = z;
        this.b = i;
    }

    public final int a() {
        return this.b;
    }

    public final boolean b() {
        return this.f7701a;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f7701a == dVar.f7701a && this.b == dVar.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.f7701a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.b;
    }

    @OOXIXo
    public String toString() {
        return "RGServiceSubscribeData(isShow=" + this.f7701a + ", subscribeNum=" + this.b + oIX0oI.I0Io.f4095I0Io;
    }

    public final void a(boolean z) {
        this.f7701a = z;
    }

    public final void a(int i) {
        this.b = i;
    }
}
