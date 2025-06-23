package com.baidu.navisdk.ui.chargelist.data.beans;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;

/* loaded from: classes8.dex */
public final class d extends b {
    private boolean h;
    private final int i;
    private final int j;
    private final int k;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(int r10, int r11, int r12) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            r1 = 95
            r0.append(r1)
            r0.append(r12)
            java.lang.String r3 = r0.toString()
            r6 = 3
            r8 = -1
            r5 = 4
            r2 = r9
            r4 = r10
            r7 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r9.i = r10
            r9.j = r11
            r9.k = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.chargelist.data.beans.d.<init>(int, int, int):void");
    }

    @Override // com.baidu.navisdk.ui.chargelist.data.beans.b
    public int a() {
        return this.j;
    }

    public final void b(boolean z) {
        this.h = z;
    }

    @Override // com.baidu.navisdk.ui.chargelist.data.beans.b
    public int c() {
        return this.i;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (c() == dVar.c() && this.k == dVar.k && this.h == dVar.h) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final String h() {
        if (this.h) {
            return "收起";
        }
        return this.k + "个备选充电站";
    }

    public int hashCode() {
        return (((c() * 31) + this.k) * 31) + Boolean.valueOf(this.h).hashCode();
    }

    public final boolean i() {
        return this.h;
    }

    @Override // com.baidu.navisdk.ui.chargelist.data.beans.b
    @OOXIXo
    public String toString() {
        return "MoreWrapper(" + super.toString() + ", groupIndex=" + c() + ", backgroundType=" + a() + ", backupCsCount=" + this.k + ", isExpanded=" + this.h + oIX0oI.I0Io.f4095I0Io;
    }
}
