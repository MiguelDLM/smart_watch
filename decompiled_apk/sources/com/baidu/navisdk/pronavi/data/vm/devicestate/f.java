package com.baidu.navisdk.pronavi.data.vm.devicestate;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;

/* loaded from: classes7.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7703a;
    private int b;

    public f(boolean z, int i) {
        this.f7703a = z;
        this.b = i;
    }

    public final int a() {
        return this.b;
    }

    public final boolean b() {
        return this.f7703a;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f7703a == fVar.f7703a && this.b == fVar.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.f7703a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.b;
    }

    @OOXIXo
    public String toString() {
        return "RGVolumeIconData(isShow=" + this.f7703a + ", volumeIconId=" + this.b + oIX0oI.I0Io.f4095I0Io;
    }

    public final void a(boolean z) {
        this.f7703a = z;
    }

    public final void a(int i) {
        this.b = i;
    }
}
