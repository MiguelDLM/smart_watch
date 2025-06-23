package com.baidu.navisdk.ui.routeguide.ace;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f8431a;

    @OOXIXo
    private final e b;

    public i(boolean z, @OOXIXo e panelData) {
        IIX0o.x0xO0oo(panelData, "panelData");
        this.f8431a = z;
        this.b = panelData;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f8431a == iVar.f8431a && IIX0o.Oxx0IOOO(this.b, iVar.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.f8431a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        e eVar = this.b;
        return i + (eVar != null ? eVar.hashCode() : 0);
    }

    @OOXIXo
    public String toString() {
        return "RGSmartTrafficModel(isInArea=" + this.f8431a + ", panelData=" + this.b + oIX0oI.I0Io.f4095I0Io;
    }
}
