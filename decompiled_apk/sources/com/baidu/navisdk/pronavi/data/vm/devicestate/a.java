package com.baidu.navisdk.pronavi.data.vm.devicestate;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7688a;
    private int b;
    private int c;
    private boolean d;

    public a(boolean z, int i, int i2, boolean z2) {
        this.f7688a = z;
        this.b = i;
        this.c = i2;
        this.d = z2;
    }

    public final void a(boolean z) {
        this.f7688a = z;
    }

    public final int b() {
        return this.b;
    }

    public final boolean c() {
        return this.f7688a;
    }

    public final boolean d() {
        return this.d;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f7688a == aVar.f7688a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.f7688a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = ((((r0 * 31) + this.b) * 31) + this.c) * 31;
        boolean z2 = this.d;
        return i + (z2 ? 1 : z2 ? 1 : 0);
    }

    @OOXIXo
    public String toString() {
        return "RGCurAreaStateData(isShow=" + this.f7688a + ", areaState=" + this.b + ", areaIconId=" + this.c + ", isShowForSimpleGuide=" + this.d + oIX0oI.I0Io.f4095I0Io;
    }

    public final int a() {
        return this.c;
    }

    public final void b(int i) {
        this.b = i;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final void b(boolean z) {
        this.d = z;
    }
}
