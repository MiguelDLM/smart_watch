package com.bomdic.gomoreedgekit.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class GMCoachBound {
    private final int lower;
    private final int upper;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public GMCoachBound() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bomdic.gomoreedgekit.data.GMCoachBound.<init>():void");
    }

    public static /* synthetic */ GMCoachBound copy$default(GMCoachBound gMCoachBound, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = gMCoachBound.upper;
        }
        if ((i3 & 2) != 0) {
            i2 = gMCoachBound.lower;
        }
        return gMCoachBound.copy(i, i2);
    }

    public final int component1() {
        return this.upper;
    }

    public final int component2() {
        return this.lower;
    }

    @OOXIXo
    public final GMCoachBound copy(int i, int i2) {
        return new GMCoachBound(i, i2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GMCoachBound)) {
            return false;
        }
        GMCoachBound gMCoachBound = (GMCoachBound) obj;
        return this.upper == gMCoachBound.upper && this.lower == gMCoachBound.lower;
    }

    public final int getLower() {
        return this.lower;
    }

    public final int getUpper() {
        return this.upper;
    }

    public int hashCode() {
        return (this.upper * 31) + this.lower;
    }

    @OOXIXo
    public String toString() {
        return "GMCoachBound(upper=" + this.upper + ", lower=" + this.lower + oIX0oI.I0Io.f4095I0Io;
    }

    public GMCoachBound(int i, int i2) {
        this.upper = i;
        this.lower = i2;
    }

    public /* synthetic */ GMCoachBound(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? -9999 : i, (i3 & 2) != 0 ? -9999 : i2);
    }
}
