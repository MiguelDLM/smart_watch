package com.baidu.navisdk.ui.routeguide.ace;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private boolean f8429a;
    private boolean b;
    private boolean c;

    @xoIox
    public g() {
        this(false, false, false, 7, null);
    }

    public final boolean a() {
        return this.c;
    }

    public final boolean b() {
        return this.f8429a;
    }

    public final boolean c() {
        return this.b;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f8429a == gVar.f8429a && this.b == gVar.b && this.c == gVar.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z = this.f8429a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.b;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        boolean z2 = this.c;
        return i3 + (z2 ? 1 : z2 ? 1 : 0);
    }

    @OOXIXo
    public String toString() {
        return "RGACEStatusModel(isInArea=" + this.f8429a + ", isInGreen=" + this.b + ", isHideView=" + this.c + oIX0oI.I0Io.f4095I0Io;
    }

    @xoIox
    public g(boolean z, boolean z2, boolean z3) {
        this.f8429a = z;
        this.b = z2;
        this.c = z3;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final void b(boolean z) {
        this.f8429a = z;
    }

    public final void c(boolean z) {
        this.b = z;
    }

    public /* synthetic */ g(boolean z, boolean z2, boolean z3, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
    }
}
